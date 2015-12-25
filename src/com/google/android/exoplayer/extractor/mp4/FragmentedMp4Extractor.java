// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            TrackFragment, Track, TrackEncryptionBox, Atom, 
//            PsshAtomUtil, AtomParsers, DefaultSampleValues, Sniffer

public final class FragmentedMp4Extractor
    implements Extractor
{

    private static final byte PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE[] = {
        -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 
        108, 66, 124, 100, -115, -12
    };
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    public static final int WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final Stack containerAtoms;
    private final ParsableByteArray encryptionSignalByte;
    private final byte extendedTypeScratch[];
    private DefaultSampleValues extendsDefaults;
    private ExtractorOutput extractorOutput;
    private final TrackFragment fragmentRun;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleIndex;
    private int sampleSize;
    private Track track;
    private TrackOutput trackOutput;
    private final int workaroundFlags;

    public FragmentedMp4Extractor()
    {
        this(0);
    }

    public FragmentedMp4Extractor(int i)
    {
        workaroundFlags = i;
        atomHeader = new ParsableByteArray(16);
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        nalLength = new ParsableByteArray(4);
        encryptionSignalByte = new ParsableByteArray(1);
        extendedTypeScratch = new byte[16];
        containerAtoms = new Stack();
        fragmentRun = new TrackFragment();
        enterReadingAtomHeaderState();
    }

    private int appendSampleEncryptionData(ParsableByteArray parsablebytearray)
    {
        int j = track.sampleDescriptionEncryptionBoxes[fragmentRun.sampleDescriptionIndex].initializationVectorSize;
        boolean flag = fragmentRun.sampleHasSubsampleEncryptionTable[sampleIndex];
        byte abyte0[] = encryptionSignalByte.data;
        char c;
        if (flag)
        {
            c = '\200';
        } else
        {
            c = '\0';
        }
        abyte0[0] = (byte)(c | j);
        encryptionSignalByte.setPosition(0);
        trackOutput.sampleData(encryptionSignalByte, 1);
        trackOutput.sampleData(parsablebytearray, j);
        if (!flag)
        {
            return j + 1;
        } else
        {
            int i = parsablebytearray.readUnsignedShort();
            parsablebytearray.skipBytes(-2);
            i = i * 6 + 2;
            trackOutput.sampleData(parsablebytearray, i);
            return j + 1 + i;
        }
    }

    private void enterReadingAtomHeaderState()
    {
        parserState = 0;
        atomHeaderBytesRead = 0;
    }

    private void onContainerAtomRead(Atom.ContainerAtom containeratom)
    {
        if (containeratom.type == Atom.TYPE_moov)
        {
            onMoovContainerAtomRead(containeratom);
            return;
        }
        if (containeratom.type == Atom.TYPE_moof)
        {
            onMoofContainerAtomRead(containeratom);
            return;
        }
        if (!containerAtoms.isEmpty())
        {
            ((Atom.ContainerAtom)containerAtoms.peek()).add(containeratom);
        }
    }

    private void onLeafAtomRead(Atom.LeafAtom leafatom, long l)
    {
        if (!containerAtoms.isEmpty())
        {
            ((Atom.ContainerAtom)containerAtoms.peek()).add(leafatom);
            return;
        }
        if (leafatom.type == Atom.TYPE_sidx)
        {
            leafatom = parseSidx(leafatom.data, l);
            extractorOutput.seekMap(leafatom);
            haveOutputSeekMap = true;
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containeratom)
    {
        fragmentRun.reset();
        parseMoof(track, extendsDefaults, containeratom, fragmentRun, workaroundFlags, extendedTypeScratch);
        sampleIndex = 0;
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containeratom)
    {
        List list = containeratom.leafChildren;
        int j = list.size();
        byte abyte0[] = null;
        for (int i = 0; i < j;)
        {
            Atom.LeafAtom leafatom = (Atom.LeafAtom)list.get(i);
            Object obj = abyte0;
            if (leafatom.type == Atom.TYPE_pssh)
            {
                obj = abyte0;
                if (abyte0 == null)
                {
                    obj = new com.google.android.exoplayer.drm.DrmInitData.Mapped("video/mp4");
                }
                abyte0 = leafatom.data.data;
                ((com.google.android.exoplayer.drm.DrmInitData.Mapped) (obj)).put(PsshAtomUtil.parseUuid(abyte0), abyte0);
            }
            i++;
            abyte0 = ((byte []) (obj));
        }

        if (abyte0 != null)
        {
            extractorOutput.drmInitData(abyte0);
        }
        extendsDefaults = parseTrex(containeratom.getContainerAtomOfType(Atom.TYPE_mvex).getLeafAtomOfType(Atom.TYPE_trex).data);
        track = AtomParsers.parseTrak(containeratom.getContainerAtomOfType(Atom.TYPE_trak), containeratom.getLeafAtomOfType(Atom.TYPE_mvhd));
        boolean flag;
        if (track != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        trackOutput.format(track.mediaFormat);
    }

    private static void parseMoof(Track track1, DefaultSampleValues defaultsamplevalues, Atom.ContainerAtom containeratom, TrackFragment trackfragment, int i, byte abyte0[])
    {
        parseTraf(track1, defaultsamplevalues, containeratom.getContainerAtomOfType(Atom.TYPE_traf), trackfragment, i, abyte0);
    }

    private static void parseSaiz(TrackEncryptionBox trackencryptionbox, ParsableByteArray parsablebytearray, TrackFragment trackfragment)
    {
        int l = trackencryptionbox.initializationVectorSize;
        parsablebytearray.setPosition(8);
        if ((Atom.parseFullAtomFlags(parsablebytearray.readInt()) & 1) == 1)
        {
            parsablebytearray.skipBytes(8);
        }
        int j = parsablebytearray.readUnsignedByte();
        int k = parsablebytearray.readUnsignedIntToInt();
        if (k != trackfragment.length)
        {
            throw new IllegalStateException((new StringBuilder("Length mismatch: ")).append(k).append(", ").append(trackfragment.length).toString());
        }
        int i = 0;
        if (j == 0)
        {
            trackencryptionbox = trackfragment.sampleHasSubsampleEncryptionTable;
            for (j = 0; j < k; j++)
            {
                int i1 = parsablebytearray.readUnsignedByte();
                i += i1;
                byte byte0;
                if (i1 > l)
                {
                    byte0 = 1;
                } else
                {
                    byte0 = 0;
                }
                trackencryptionbox[j] = byte0;
            }

        } else
        {
            boolean flag;
            if (j > l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = j * k + 0;
            Arrays.fill(trackfragment.sampleHasSubsampleEncryptionTable, 0, k, flag);
        }
        trackfragment.initEncryptionData(i);
    }

    private static void parseSenc(ParsableByteArray parsablebytearray, int i, TrackFragment trackfragment)
    {
        parsablebytearray.setPosition(i + 8);
        i = Atom.parseFullAtomFlags(parsablebytearray.readInt());
        if ((i & 1) != 0)
        {
            throw new IllegalStateException("Overriding TrackEncryptionBox parameters is unsupported");
        }
        boolean flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = parsablebytearray.readUnsignedIntToInt();
        if (i != trackfragment.length)
        {
            throw new IllegalStateException((new StringBuilder("Length mismatch: ")).append(i).append(", ").append(trackfragment.length).toString());
        } else
        {
            Arrays.fill(trackfragment.sampleHasSubsampleEncryptionTable, 0, i, flag);
            trackfragment.initEncryptionData(parsablebytearray.bytesLeft());
            trackfragment.fillEncryptionData(parsablebytearray);
            return;
        }
    }

    private static void parseSenc(ParsableByteArray parsablebytearray, TrackFragment trackfragment)
    {
        parseSenc(parsablebytearray, 0, trackfragment);
    }

    private static ChunkIndex parseSidx(ParsableByteArray parsablebytearray, long l)
    {
        parsablebytearray.setPosition(8);
        int i = Atom.parseFullAtomVersion(parsablebytearray.readInt());
        parsablebytearray.skipBytes(4);
        long l5 = parsablebytearray.readUnsignedInt();
        long l1;
        if (i == 0)
        {
            l1 = parsablebytearray.readUnsignedInt();
            l += parsablebytearray.readUnsignedInt();
        } else
        {
            l1 = parsablebytearray.readUnsignedLongToLong();
            l += parsablebytearray.readUnsignedLongToLong();
        }
        parsablebytearray.skipBytes(2);
        int j = parsablebytearray.readUnsignedShort();
        int ai[] = new int[j];
        long al[] = new long[j];
        long al1[] = new long[j];
        long al2[] = new long[j];
        long l3 = l1;
        long l2 = Util.scaleLargeTimestamp(l1, 0xf4240L, l5);
        i = 0;
        l1 = l3;
        for (; i < j; i++)
        {
            int k = parsablebytearray.readInt();
            if ((0x80000000 & k) != 0)
            {
                throw new IllegalStateException("Unhandled indirect reference");
            }
            long l4 = parsablebytearray.readUnsignedInt();
            ai[i] = 0x7fffffff & k;
            al[i] = l;
            al2[i] = l2;
            l2 = l1 + l4;
            l1 = l2;
            l2 = Util.scaleLargeTimestamp(l2, 0xf4240L, l5);
            al1[i] = l2 - al2[i];
            parsablebytearray.skipBytes(4);
            l += ai[i];
        }

        return new ChunkIndex(ai, al, al1, al2);
    }

    private static long parseTfdt(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsablebytearray.readInt()) == 1)
        {
            return parsablebytearray.readUnsignedLongToLong();
        } else
        {
            return parsablebytearray.readUnsignedInt();
        }
    }

    private static DefaultSampleValues parseTfhd(DefaultSampleValues defaultsamplevalues, ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        int l = Atom.parseFullAtomFlags(parsablebytearray.readInt());
        parsablebytearray.skipBytes(4);
        if ((l & 1) != 0)
        {
            parsablebytearray.skipBytes(8);
        }
        int i;
        if ((l & 2) != 0)
        {
            i = parsablebytearray.readUnsignedIntToInt() - 1;
        } else
        {
            i = defaultsamplevalues.sampleDescriptionIndex;
        }
        int j;
        if ((l & 8) != 0)
        {
            j = parsablebytearray.readUnsignedIntToInt();
        } else
        {
            j = defaultsamplevalues.duration;
        }
        int k;
        if ((l & 0x10) != 0)
        {
            k = parsablebytearray.readUnsignedIntToInt();
        } else
        {
            k = defaultsamplevalues.size;
        }
        if ((l & 0x20) != 0)
        {
            l = parsablebytearray.readUnsignedIntToInt();
        } else
        {
            l = defaultsamplevalues.flags;
        }
        return new DefaultSampleValues(i, j, k, l);
    }

    private static void parseTraf(Track track1, DefaultSampleValues defaultsamplevalues, Atom.ContainerAtom containeratom, TrackFragment trackfragment, int i, byte abyte0[])
    {
        long l;
        if (containeratom.getLeafAtomOfType(Atom.TYPE_tfdt) == null)
        {
            l = 0L;
        } else
        {
            l = parseTfdt(containeratom.getLeafAtomOfType(Atom.TYPE_tfdt).data);
        }
        defaultsamplevalues = parseTfhd(defaultsamplevalues, containeratom.getLeafAtomOfType(Atom.TYPE_tfhd).data);
        trackfragment.sampleDescriptionIndex = defaultsamplevalues.sampleDescriptionIndex;
        parseTrun(track1, defaultsamplevalues, l, i, containeratom.getLeafAtomOfType(Atom.TYPE_trun).data, trackfragment);
        Atom.LeafAtom leafatom = containeratom.getLeafAtomOfType(Atom.TYPE_saiz);
        if (leafatom != null)
        {
            parseSaiz(track1.sampleDescriptionEncryptionBoxes[defaultsamplevalues.sampleDescriptionIndex], leafatom.data, trackfragment);
        }
        track1 = containeratom.getLeafAtomOfType(Atom.TYPE_senc);
        if (track1 != null)
        {
            parseSenc(((Atom.LeafAtom) (track1)).data, trackfragment);
        }
        int j = containeratom.leafChildren.size();
        for (i = 0; i < j; i++)
        {
            track1 = (Atom.LeafAtom)containeratom.leafChildren.get(i);
            if (((Atom.LeafAtom) (track1)).type == Atom.TYPE_uuid)
            {
                parseUuid(((Atom.LeafAtom) (track1)).data, trackfragment, abyte0);
            }
        }

    }

    private static DefaultSampleValues parseTrex(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(16);
        return new DefaultSampleValues(parsablebytearray.readUnsignedIntToInt() - 1, parsablebytearray.readUnsignedIntToInt(), parsablebytearray.readUnsignedIntToInt(), parsablebytearray.readInt());
    }

    private static void parseTrun(Track track1, DefaultSampleValues defaultsamplevalues, long l, int i, ParsableByteArray parsablebytearray, TrackFragment trackfragment)
    {
        parsablebytearray.setPosition(8);
        int k = Atom.parseFullAtomFlags(parsablebytearray.readInt());
        int l1 = parsablebytearray.readUnsignedIntToInt();
        if ((k & 1) != 0)
        {
            parsablebytearray.skipBytes(4);
        }
        boolean flag;
        if ((k & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int j = defaultsamplevalues.flags;
        if (flag)
        {
            j = parsablebytearray.readUnsignedIntToInt();
        }
        boolean flag1;
        if ((k & 0x100) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2;
        if ((k & 0x200) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        boolean flag3;
        if ((k & 0x400) != 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        boolean flag4;
        if ((k & 0x800) != 0)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        trackfragment.initTables(l1);
        int ai[] = trackfragment.sampleSizeTable;
        int ai1[] = trackfragment.sampleCompositionTimeOffsetTable;
        long al[] = trackfragment.sampleDecodingTimeTable;
        trackfragment = trackfragment.sampleIsSyncFrameTable;
        long l2 = track1.timescale;
        boolean flag5;
        if (track1.type == Track.TYPE_vide && (i & 1) == 1)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        for (int i1 = 0; i1 < l1; i1++)
        {
            int j1;
            if (flag1)
            {
                j1 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                j1 = defaultsamplevalues.duration;
            }
            int k1;
            if (flag2)
            {
                k1 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                k1 = defaultsamplevalues.size;
            }
            if (i1 == 0 && flag)
            {
                i = j;
            } else
            if (flag3)
            {
                i = parsablebytearray.readInt();
            } else
            {
                i = defaultsamplevalues.flags;
            }
            if (flag4)
            {
                ai1[i1] = (int)((long)(parsablebytearray.readInt() * 1000) / l2);
            } else
            {
                ai1[i1] = 0;
            }
            al[i1] = Util.scaleLargeTimestamp(l, 1000L, l2);
            ai[i1] = k1;
            byte byte0;
            if ((i >> 16 & 1) == 0 && (!flag5 || i1 == 0))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            trackfragment[i1] = byte0;
            l += j1;
        }

    }

    private static void parseUuid(ParsableByteArray parsablebytearray, TrackFragment trackfragment, byte abyte0[])
    {
        parsablebytearray.setPosition(8);
        parsablebytearray.readBytes(abyte0, 0, 16);
        if (!Arrays.equals(abyte0, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE))
        {
            return;
        } else
        {
            parseSenc(parsablebytearray, 16, trackfragment);
            return;
        }
    }

    private boolean readAtomHeader(ExtractorInput extractorinput)
    {
        if (atomHeaderBytesRead == 0)
        {
            if (!extractorinput.readFully(atomHeader.data, 0, 8, true))
            {
                return false;
            }
            atomHeaderBytesRead = 8;
            atomHeader.setPosition(0);
            atomSize = atomHeader.readUnsignedInt();
            atomType = atomHeader.readInt();
        }
        if (atomSize == 1L)
        {
            extractorinput.readFully(atomHeader.data, 8, 8);
            atomHeaderBytesRead = atomHeaderBytesRead + 8;
            atomSize = atomHeader.readUnsignedLongToLong();
        }
        if (atomType == Atom.TYPE_mdat)
        {
            if (!haveOutputSeekMap)
            {
                extractorOutput.seekMap(SeekMap.UNSEEKABLE);
                haveOutputSeekMap = true;
            }
            if (fragmentRun.sampleEncryptionDataNeedsFill)
            {
                parserState = 2;
            } else
            {
                parserState = 3;
            }
            return true;
        }
        if (shouldParseAtom(atomType))
        {
            if (shouldParseContainerAtom(atomType))
            {
                long l = extractorinput.getPosition();
                long l1 = atomSize;
                containerAtoms.add(new Atom.ContainerAtom(atomType, (l + l1) - 8L));
                enterReadingAtomHeaderState();
            } else
            {
                boolean flag;
                if (atomHeaderBytesRead == 8)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
                if (atomSize <= 0x7fffffffL)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
                atomData = new ParsableByteArray((int)atomSize);
                System.arraycopy(atomHeader.data, 0, atomData.data, 0, 8);
                parserState = 1;
            }
        } else
        {
            boolean flag1;
            if (atomSize <= 0x7fffffffL)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assertions.checkState(flag1);
            atomData = null;
            parserState = 1;
        }
        return true;
    }

    private void readAtomPayload(ExtractorInput extractorinput)
    {
        int i = (int)atomSize - atomHeaderBytesRead;
        if (atomData != null)
        {
            extractorinput.readFully(atomData.data, 8, i);
            onLeafAtomRead(new Atom.LeafAtom(atomType, atomData), extractorinput.getPosition());
        } else
        {
            extractorinput.skipFully(i);
        }
        for (long l = extractorinput.getPosition(); !containerAtoms.isEmpty() && ((Atom.ContainerAtom)containerAtoms.peek()).endPosition == l; onContainerAtomRead((Atom.ContainerAtom)containerAtoms.pop())) { }
        enterReadingAtomHeaderState();
    }

    private void readEncryptionData(ExtractorInput extractorinput)
    {
        fragmentRun.fillEncryptionData(extractorinput);
        parserState = 3;
    }

    private boolean readSample(ExtractorInput extractorinput)
    {
        if (sampleIndex >= fragmentRun.length)
        {
            enterReadingAtomHeaderState();
            return false;
        }
        if (parserState == 3)
        {
            sampleSize = fragmentRun.sampleSizeTable[sampleIndex];
            if (fragmentRun.definesEncryptionData)
            {
                sampleBytesWritten = appendSampleEncryptionData(fragmentRun.sampleEncryptionData);
                sampleSize = sampleSize + sampleBytesWritten;
            } else
            {
                sampleBytesWritten = 0;
            }
            sampleCurrentNalBytesRemaining = 0;
            parserState = 4;
        }
        if (track.nalUnitLengthFieldLength != -1)
        {
            byte abyte0[] = nalLength.data;
            abyte0[0] = 0;
            abyte0[1] = 0;
            abyte0[2] = 0;
            int i = track.nalUnitLengthFieldLength;
            int k = 4 - track.nalUnitLengthFieldLength;
            while (sampleBytesWritten < sampleSize) 
            {
                if (sampleCurrentNalBytesRemaining == 0)
                {
                    extractorinput.readFully(nalLength.data, k, i);
                    nalLength.setPosition(0);
                    sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
                    nalStartCode.setPosition(0);
                    trackOutput.sampleData(nalStartCode, 4);
                    sampleBytesWritten = sampleBytesWritten + 4;
                    sampleSize = sampleSize + k;
                } else
                {
                    int l = trackOutput.sampleData(extractorinput, sampleCurrentNalBytesRemaining, false);
                    sampleBytesWritten = sampleBytesWritten + l;
                    sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - l;
                }
            }
        } else
        {
            int j;
            for (; sampleBytesWritten < sampleSize; sampleBytesWritten = sampleBytesWritten + j)
            {
                j = trackOutput.sampleData(extractorinput, sampleSize - sampleBytesWritten, false);
            }

        }
        long l1 = fragmentRun.getSamplePresentationTime(sampleIndex);
        byte byte0;
        if (fragmentRun.definesEncryptionData)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        boolean flag;
        if (fragmentRun.sampleIsSyncFrameTable[sampleIndex])
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (fragmentRun.definesEncryptionData)
        {
            extractorinput = track.sampleDescriptionEncryptionBoxes[fragmentRun.sampleDescriptionIndex].keyId;
        } else
        {
            extractorinput = null;
        }
        trackOutput.sampleMetadata(l1 * 1000L, byte0 | flag, sampleSize, 0, extractorinput);
        sampleIndex = sampleIndex + 1;
        parserState = 3;
        return true;
    }

    private static boolean shouldParseAtom(int i)
    {
        return i == Atom.TYPE_avc1 || i == Atom.TYPE_avc3 || i == Atom.TYPE_esds || i == Atom.TYPE_hdlr || i == Atom.TYPE_mdat || i == Atom.TYPE_mdhd || i == Atom.TYPE_moof || i == Atom.TYPE_moov || i == Atom.TYPE_mp4a || i == Atom.TYPE_mvhd || i == Atom.TYPE_sidx || i == Atom.TYPE_stsd || i == Atom.TYPE_tfdt || i == Atom.TYPE_tfhd || i == Atom.TYPE_tkhd || i == Atom.TYPE_traf || i == Atom.TYPE_trak || i == Atom.TYPE_trex || i == Atom.TYPE_trun || i == Atom.TYPE_mvex || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_pssh || i == Atom.TYPE_saiz || i == Atom.TYPE_uuid || i == Atom.TYPE_senc || i == Atom.TYPE_pasp || i == Atom.TYPE_s263;
    }

    private static boolean shouldParseContainerAtom(int i)
    {
        return i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl || i == Atom.TYPE_avcC || i == Atom.TYPE_moof || i == Atom.TYPE_traf || i == Atom.TYPE_mvex;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
        trackOutput = extractoroutput.track(0);
        extractorOutput.endTracks();
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
label0:
        do
        {
            do
            {
                switch (parserState)
                {
                default:
                    continue label0;

                case 0: // '\0'
                    if (!readAtomHeader(extractorinput))
                    {
                        return -1;
                    }
                    break;

                case 1: // '\001'
                    readAtomPayload(extractorinput);
                    break;

                case 2: // '\002'
                    readEncryptionData(extractorinput);
                    break;
                }
            } while (true);
        } while (!readSample(extractorinput));
        return 0;
    }

    public final void seek()
    {
        containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    public final void setTrack(Track track1)
    {
        extendsDefaults = new DefaultSampleValues(0, 0, 0, 0);
        track = track1;
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        return Sniffer.sniffFragmented(extractorinput);
    }

}
