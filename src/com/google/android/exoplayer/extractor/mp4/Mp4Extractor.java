// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            TrackSampleTable, Atom, AtomParsers, Track, 
//            Sniffer

public final class Mp4Extractor
    implements Extractor, SeekMap
{
    static final class Mp4Track
    {

        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track1, TrackSampleTable tracksampletable, TrackOutput trackoutput)
        {
            track = track1;
            sampleTable = tracksampletable;
            trackOutput = trackoutput;
        }
    }


    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 0x40000L;
    private static final int STATE_AFTER_SEEK = 0;
    private static final int STATE_READING_ATOM_HEADER = 1;
    private static final int STATE_READING_ATOM_PAYLOAD = 2;
    private static final int STATE_READING_SAMPLE = 3;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader = new ParsableByteArray(16);
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final Stack containerAtoms = new Stack();
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength = new ParsableByteArray(4);
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private Mp4Track tracks[];

    public Mp4Extractor()
    {
        nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        enterReadingAtomHeaderState();
    }

    private void enterReadingAtomHeaderState()
    {
        parserState = 1;
        atomHeaderBytesRead = 0;
    }

    private int getTrackIndexOfEarliestCurrentSample()
    {
        int j = -1;
        long l1 = 0x7fffffffffffffffL;
        for (int i = 0; i < tracks.length;)
        {
            Mp4Track mp4track = tracks[i];
            int l = mp4track.sampleIndex;
            int k = j;
            long l2 = l1;
            if (l != mp4track.sampleTable.sampleCount)
            {
                long l3 = mp4track.sampleTable.offsets[l];
                k = j;
                l2 = l1;
                if (l3 < l1)
                {
                    l2 = l3;
                    k = i;
                }
            }
            i++;
            j = k;
            l1 = l2;
        }

        return j;
    }

    private void processMoovAtom(Atom.ContainerAtom containeratom)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < containeratom.containerChildren.size(); i++)
        {
            Object obj = (Atom.ContainerAtom)containeratom.containerChildren.get(i);
            if (((Atom.ContainerAtom) (obj)).type != Atom.TYPE_trak)
            {
                continue;
            }
            Track track = AtomParsers.parseTrak(((Atom.ContainerAtom) (obj)), containeratom.getLeafAtomOfType(Atom.TYPE_mvhd));
            if (track == null)
            {
                continue;
            }
            obj = AtomParsers.parseStbl(track, ((Atom.ContainerAtom) (obj)).getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl));
            if (((TrackSampleTable) (obj)).sampleCount != 0)
            {
                obj = new Mp4Track(track, ((TrackSampleTable) (obj)), extractorOutput.track(i));
                ((Mp4Track) (obj)).trackOutput.format(track.mediaFormat);
                arraylist.add(obj);
            }
        }

        tracks = (Mp4Track[])arraylist.toArray(new Mp4Track[0]);
        extractorOutput.endTracks();
        extractorOutput.seekMap(this);
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
        if (shouldParseContainerAtom(atomType))
        {
            long l = extractorinput.getPosition();
            long l1 = atomSize;
            long l2 = atomHeaderBytesRead;
            containerAtoms.add(new Atom.ContainerAtom(atomType, (l + l1) - l2));
            enterReadingAtomHeaderState();
        } else
        if (shouldParseLeafAtom(atomType))
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
            parserState = 2;
        } else
        {
            atomData = null;
            parserState = 2;
        }
        return true;
    }

    private boolean readAtomPayload(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        long l = atomSize - (long)atomHeaderBytesRead;
        long l1 = extractorinput.getPosition();
        boolean flag1 = false;
        boolean flag;
        if (atomData != null)
        {
            extractorinput.readFully(atomData.data, atomHeaderBytesRead, (int)l);
            flag = flag1;
            if (!containerAtoms.isEmpty())
            {
                ((Atom.ContainerAtom)containerAtoms.peek()).add(new Atom.LeafAtom(atomType, atomData));
                flag = flag1;
            }
        } else
        if (l < 0x40000L)
        {
            extractorinput.skipFully((int)l);
            flag = flag1;
        } else
        {
            positionholder.position = extractorinput.getPosition() + l;
            flag = true;
        }
        do
        {
            if (containerAtoms.isEmpty() || ((Atom.ContainerAtom)containerAtoms.peek()).endPosition != l1 + l)
            {
                break;
            }
            extractorinput = (Atom.ContainerAtom)containerAtoms.pop();
            if (((Atom.ContainerAtom) (extractorinput)).type == Atom.TYPE_moov)
            {
                processMoovAtom(extractorinput);
                containerAtoms.clear();
                parserState = 3;
                return false;
            }
            if (!containerAtoms.isEmpty())
            {
                ((Atom.ContainerAtom)containerAtoms.peek()).add(extractorinput);
            }
        } while (true);
        enterReadingAtomHeaderState();
        return flag;
    }

    private int readSample(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        int i = getTrackIndexOfEarliestCurrentSample();
        if (i == -1)
        {
            return -1;
        }
        Mp4Track mp4track = tracks[i];
        TrackOutput trackoutput = mp4track.trackOutput;
        i = mp4track.sampleIndex;
        long l1 = mp4track.sampleTable.offsets[i];
        long l2 = (l1 - extractorinput.getPosition()) + (long)sampleBytesWritten;
        if (l2 < 0L || l2 >= 0x40000L)
        {
            positionholder.position = l1;
            return 1;
        }
        extractorinput.skipFully((int)l2);
        sampleSize = mp4track.sampleTable.sizes[i];
        if (mp4track.track.nalUnitLengthFieldLength != -1)
        {
            positionholder = nalLength.data;
            positionholder[0] = 0;
            positionholder[1] = 0;
            positionholder[2] = 0;
            int j = mp4track.track.nalUnitLengthFieldLength;
            int l = 4 - mp4track.track.nalUnitLengthFieldLength;
            while (sampleBytesWritten < sampleSize) 
            {
                if (sampleCurrentNalBytesRemaining == 0)
                {
                    extractorinput.readFully(nalLength.data, l, j);
                    nalLength.setPosition(0);
                    sampleCurrentNalBytesRemaining = nalLength.readUnsignedIntToInt();
                    nalStartCode.setPosition(0);
                    trackoutput.sampleData(nalStartCode, 4);
                    sampleBytesWritten = sampleBytesWritten + 4;
                    sampleSize = sampleSize + l;
                } else
                {
                    int i1 = trackoutput.sampleData(extractorinput, sampleCurrentNalBytesRemaining, false);
                    sampleBytesWritten = sampleBytesWritten + i1;
                    sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - i1;
                }
            }
        } else
        {
            while (sampleBytesWritten < sampleSize) 
            {
                int k = trackoutput.sampleData(extractorinput, sampleSize - sampleBytesWritten, false);
                sampleBytesWritten = sampleBytesWritten + k;
                sampleCurrentNalBytesRemaining = sampleCurrentNalBytesRemaining - k;
            }
        }
        trackoutput.sampleMetadata(mp4track.sampleTable.timestampsUs[i], mp4track.sampleTable.flags[i], sampleSize, 0, null);
        mp4track.sampleIndex = mp4track.sampleIndex + 1;
        sampleBytesWritten = 0;
        sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private static boolean shouldParseContainerAtom(int i)
    {
        return i == Atom.TYPE_moov || i == Atom.TYPE_trak || i == Atom.TYPE_mdia || i == Atom.TYPE_minf || i == Atom.TYPE_stbl;
    }

    private static boolean shouldParseLeafAtom(int i)
    {
        return i == Atom.TYPE_mdhd || i == Atom.TYPE_mvhd || i == Atom.TYPE_hdlr || i == Atom.TYPE_vmhd || i == Atom.TYPE_smhd || i == Atom.TYPE_stsd || i == Atom.TYPE_avc1 || i == Atom.TYPE_avcC || i == Atom.TYPE_mp4a || i == Atom.TYPE_esds || i == Atom.TYPE_stts || i == Atom.TYPE_stss || i == Atom.TYPE_ctts || i == Atom.TYPE_stsc || i == Atom.TYPE_stsz || i == Atom.TYPE_stco || i == Atom.TYPE_co64 || i == Atom.TYPE_tkhd || i == Atom.TYPE_s263;
    }

    public final long getPosition(long l)
    {
        long l1 = 0x7fffffffffffffffL;
        for (int i = 0; i < tracks.length;)
        {
            TrackSampleTable tracksampletable = tracks[i].sampleTable;
            int k = tracksampletable.getIndexOfEarlierOrEqualSynchronizationSample(l);
            int j = k;
            if (k == -1)
            {
                j = tracksampletable.getIndexOfLaterOrEqualSynchronizationSample(l);
            }
            tracks[i].sampleIndex = j;
            long l3 = tracksampletable.offsets[tracks[i].sampleIndex];
            long l2 = l1;
            if (l3 < l1)
            {
                l2 = l3;
            }
            i++;
            l1 = l2;
        }

        return l1;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
    }

    public final boolean isSeekable()
    {
        return true;
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
_L8:
        parserState;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 35
    //                   1 61
    //                   2 71;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        continue; /* Loop/switch isn't completed */
_L2:
        if (extractorinput.getPosition() == 0L)
        {
            enterReadingAtomHeaderState();
        } else
        {
            parserState = 3;
        }
        break; /* Loop/switch isn't completed */
_L3:
        if (readAtomHeader(extractorinput)) goto _L6; else goto _L5
_L6:
        if (true) goto _L8; else goto _L7
_L5:
        return -1;
        if (!readAtomPayload(extractorinput, positionholder)) goto _L8; else goto _L9
_L9:
        return 1;
_L7:
        return readSample(extractorinput, positionholder);
    }

    public final void seek()
    {
        containerAtoms.clear();
        atomHeaderBytesRead = 0;
        sampleBytesWritten = 0;
        sampleCurrentNalBytesRemaining = 0;
        parserState = 0;
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        return Sniffer.sniffUnfragmented(extractorinput);
    }
}
