// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.util.Ac3Util;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.CodecSpecificDataUtil;
import com.google.android.exoplayer.util.NalUnitUtil;
import com.google.android.exoplayer.util.ParsableBitArray;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom, TrackEncryptionBox, TrackSampleTable, Track

final class AtomParsers
{
    static final class AvcCData
    {

        public final List initializationData;
        public final int nalUnitLengthFieldLength;
        public final float pixelWidthAspectRatio;

        public AvcCData(List list, int i, float f)
        {
            initializationData = list;
            nalUnitLengthFieldLength = i;
            pixelWidthAspectRatio = f;
        }
    }

    static final class StsdData
    {

        public MediaFormat mediaFormat;
        public int nalUnitLengthFieldLength;
        public final TrackEncryptionBox trackEncryptionBoxes[];

        public StsdData(int i)
        {
            trackEncryptionBoxes = new TrackEncryptionBox[i];
            nalUnitLengthFieldLength = -1;
        }
    }

    static final class TkhdData
    {

        private final long duration;
        private final int id;
        private final int rotationDegrees;




        public TkhdData(int i, long l, int j)
        {
            id = i;
            duration = l;
            rotationDegrees = j;
        }
    }


    private AtomParsers()
    {
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsablebytearray, int i, int j, int k, int l, long l1, String s, 
            StsdData stsddata, int i1)
    {
        parsablebytearray.setPosition(j + 8);
        parsablebytearray.skipBytes(16);
        int k1 = parsablebytearray.readUnsignedShort();
        int l2 = parsablebytearray.readUnsignedShort();
        parsablebytearray.skipBytes(4);
        int j1 = parsablebytearray.readUnsignedFixedPoint1616();
        Object obj = null;
        if (i == Atom.TYPE_ac_3)
        {
            obj = "audio/ac3";
        } else
        if (i == Atom.TYPE_ec_3)
        {
            obj = "audio/eac3";
        } else
        if (i == Atom.TYPE_dtsc || i == Atom.TYPE_dtse)
        {
            obj = "audio/vnd.dts";
        } else
        if (i == Atom.TYPE_dtsh || i == Atom.TYPE_dtsl)
        {
            obj = "audio/vnd.dts.hd";
        }
        byte abyte0[] = null;
        for (int i2 = parsablebytearray.getPosition(); i2 - j < k;)
        {
            Object obj1;
            byte abyte1[];
            int j2;
            int k2;
            int i3;
label0:
            {
                parsablebytearray.setPosition(i2);
                int j3 = parsablebytearray.getPosition();
                i3 = parsablebytearray.readInt();
                boolean flag;
                if (i3 > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkArgument(flag, "childAtomSize should be positive");
                int k3 = parsablebytearray.readInt();
                if (i == Atom.TYPE_mp4a || i == Atom.TYPE_enca)
                {
                    if (k3 == Atom.TYPE_esds)
                    {
                        obj = parseEsdsFromParent(parsablebytearray, j3);
                        obj1 = (String)((Pair) (obj)).first;
                        abyte1 = (byte[])((Pair) (obj)).second;
                        if ("audio/mp4a-latm".equals(obj1))
                        {
                            obj = CodecSpecificDataUtil.parseAacAudioSpecificConfig(abyte1);
                            j1 = ((Integer)((Pair) (obj)).first).intValue();
                            k1 = ((Integer)((Pair) (obj)).second).intValue();
                        }
                        j2 = k1;
                        k2 = j1;
                    } else
                    {
                        j2 = k1;
                        k2 = j1;
                        obj1 = obj;
                        abyte1 = abyte0;
                        if (k3 == Atom.TYPE_sinf)
                        {
                            stsddata.trackEncryptionBoxes[i1] = parseSinfFromParent(parsablebytearray, j3, i3);
                            j2 = k1;
                            k2 = j1;
                            obj1 = obj;
                            abyte1 = abyte0;
                        }
                    }
                    break label0;
                }
                if (i == Atom.TYPE_ac_3 && k3 == Atom.TYPE_dac3)
                {
                    parsablebytearray.setPosition(j3 + 8);
                    stsddata.mediaFormat = Ac3Util.parseAnnexFAc3Format(parsablebytearray, l, l1, s);
                    return;
                }
                if (i == Atom.TYPE_ec_3 && k3 == Atom.TYPE_dec3)
                {
                    parsablebytearray.setPosition(j3 + 8);
                    stsddata.mediaFormat = Ac3Util.parseAnnexFEAc3Format(parsablebytearray, l, l1, s);
                    return;
                }
                if (i != Atom.TYPE_dtsc && i != Atom.TYPE_dtse && i != Atom.TYPE_dtsh)
                {
                    j2 = k1;
                    k2 = j1;
                    obj1 = obj;
                    abyte1 = abyte0;
                    if (i != Atom.TYPE_dtsl)
                    {
                        break label0;
                    }
                }
                j2 = k1;
                k2 = j1;
                obj1 = obj;
                abyte1 = abyte0;
                if (k3 == Atom.TYPE_ddts)
                {
                    stsddata.mediaFormat = MediaFormat.createAudioFormat(l, ((String) (obj)), -1, -1, l1, k1, j1, null, s);
                    return;
                }
            }
            i2 += i3;
            k1 = j2;
            j1 = k2;
            obj = obj1;
            abyte0 = abyte1;
        }

        if (obj == null)
        {
            return;
        }
        if (abyte0 == null)
        {
            parsablebytearray = null;
        } else
        {
            parsablebytearray = Collections.singletonList(abyte0);
        }
        stsddata.mediaFormat = MediaFormat.createAudioFormat(l, ((String) (obj)), -1, l2, l1, k1, j1, parsablebytearray, s);
    }

    private static AvcCData parseAvcCFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8 + 4);
        int j = (parsablebytearray.readUnsignedByte() & 3) + 1;
        if (j == 3)
        {
            throw new IllegalStateException();
        }
        ArrayList arraylist = new ArrayList();
        float f = 1.0F;
        int k = parsablebytearray.readUnsignedByte() & 0x1f;
        for (i = 0; i < k; i++)
        {
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
        }

        int l = parsablebytearray.readUnsignedByte();
        for (i = 0; i < l; i++)
        {
            arraylist.add(NalUnitUtil.parseChildNalUnit(parsablebytearray));
        }

        if (k > 0)
        {
            parsablebytearray = new ParsableBitArray((byte[])arraylist.get(0));
            parsablebytearray.setPosition((j + 1) * 8);
            f = CodecSpecificDataUtil.parseSpsNalUnit(parsablebytearray).pixelWidthAspectRatio;
        }
        return new AvcCData(arraylist, j, f);
    }

    private static Pair parseEsdsFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8 + 4);
        parsablebytearray.skipBytes(1);
        for (i = parsablebytearray.readUnsignedByte(); i > 127; i = parsablebytearray.readUnsignedByte()) { }
        parsablebytearray.skipBytes(2);
        i = parsablebytearray.readUnsignedByte();
        if ((i & 0x80) != 0)
        {
            parsablebytearray.skipBytes(2);
        }
        if ((i & 0x40) != 0)
        {
            parsablebytearray.skipBytes(parsablebytearray.readUnsignedShort());
        }
        if ((i & 0x20) != 0)
        {
            parsablebytearray.skipBytes(2);
        }
        parsablebytearray.skipBytes(1);
        for (i = parsablebytearray.readUnsignedByte(); i > 127; i = parsablebytearray.readUnsignedByte()) { }
        String s;
        switch (parsablebytearray.readUnsignedByte())
        {
        case 107: // 'k'
            return Pair.create("audio/mpeg", null);

        case 32: // ' '
            s = "video/mp4v-es";
            break;

        case 33: // '!'
            s = "video/avc";
            break;

        case 35: // '#'
            s = "video/hevc";
            break;

        case 64: // '@'
        case 102: // 'f'
        case 103: // 'g'
        case 104: // 'h'
            s = "audio/mp4a-latm";
            break;

        case 165: 
            s = "audio/ac3";
            break;

        case 166: 
            s = "audio/eac3";
            break;

        case 169: 
        case 172: 
            return Pair.create("audio/vnd.dts", null);

        case 170: 
        case 171: 
            return Pair.create("audio/vnd.dts.hd", null);

        default:
            s = null;
            break;
        }
        parsablebytearray.skipBytes(12);
        parsablebytearray.skipBytes(1);
        int j = parsablebytearray.readUnsignedByte();
        i = j;
        int k = j & 0x7f;
        j = i;
        for (i = k; j > 127; i = i << 8 | j & 0x7f)
        {
            j = parsablebytearray.readUnsignedByte();
        }

        byte abyte0[] = new byte[i];
        parsablebytearray.readBytes(abyte0, 0, i);
        return Pair.create(s, abyte0);
    }

    private static int parseHdlr(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(16);
        return parsablebytearray.readInt();
    }

    private static Pair parseHvcCFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8 + 21);
        int k1 = parsablebytearray.readUnsignedByte();
        int l1 = parsablebytearray.readUnsignedByte();
        i = 0;
        int j1 = parsablebytearray.getPosition();
        for (int j = 0; j < l1; j++)
        {
            parsablebytearray.skipBytes(1);
            int i2 = parsablebytearray.readUnsignedShort();
            for (int l = 0; l < i2; l++)
            {
                int k2 = parsablebytearray.readUnsignedShort();
                i += k2 + 4;
                parsablebytearray.skipBytes(k2);
            }

        }

        parsablebytearray.setPosition(j1);
        byte abyte0[] = new byte[i];
        j1 = 0;
        for (int k = 0; k < l1; k++)
        {
            parsablebytearray.skipBytes(1);
            int j2 = parsablebytearray.readUnsignedShort();
            for (int i1 = 0; i1 < j2; i1++)
            {
                int l2 = parsablebytearray.readUnsignedShort();
                System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, abyte0, j1, NalUnitUtil.NAL_START_CODE.length);
                j1 += NalUnitUtil.NAL_START_CODE.length;
                System.arraycopy(parsablebytearray.data, parsablebytearray.getPosition(), abyte0, j1, l2);
                j1 += l2;
                parsablebytearray.skipBytes(l2);
            }

        }

        if (i == 0)
        {
            parsablebytearray = null;
        } else
        {
            parsablebytearray = Collections.singletonList(abyte0);
        }
        return Pair.create(parsablebytearray, Integer.valueOf((k1 & 3) + 1));
    }

    private static Pair parseMdhd(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        int j = Atom.parseFullAtomVersion(parsablebytearray.readInt());
        int i;
        if (j == 0)
        {
            i = 8;
        } else
        {
            i = 16;
        }
        parsablebytearray.skipBytes(i);
        long l = parsablebytearray.readUnsignedInt();
        if (j == 0)
        {
            i = 4;
        } else
        {
            i = 8;
        }
        parsablebytearray.skipBytes(i);
        i = parsablebytearray.readUnsignedShort();
        return Pair.create(Long.valueOf(l), (new StringBuilder()).append((char)((i >> 10 & 0x1f) + 96)).append((char)((i >> 5 & 0x1f) + 96)).append((char)((i & 0x1f) + 96)).toString());
    }

    private static long parseMvhd(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        byte byte0;
        if (Atom.parseFullAtomVersion(parsablebytearray.readInt()) == 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 16;
        }
        parsablebytearray.skipBytes(byte0);
        return parsablebytearray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsablebytearray, int i)
    {
        parsablebytearray.setPosition(i + 8);
        i = parsablebytearray.readUnsignedIntToInt();
        int j = parsablebytearray.readUnsignedIntToInt();
        return (float)i / (float)j;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsablebytearray, int i, int j)
    {
        int l;
        for (int k = i + 8; k - i < j; k += l)
        {
            parsablebytearray.setPosition(k);
            l = parsablebytearray.readInt();
            if (parsablebytearray.readInt() == Atom.TYPE_tenc)
            {
                parsablebytearray.skipBytes(4);
                i = parsablebytearray.readInt();
                boolean flag;
                if (i >> 8 == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                byte abyte0[] = new byte[16];
                parsablebytearray.readBytes(abyte0, 0, 16);
                return new TrackEncryptionBox(flag, i & 0xff, abyte0);
            }
        }

        return null;
    }

    private static TrackEncryptionBox parseSinfFromParent(ParsableByteArray parsablebytearray, int i, int j)
    {
        int k = i + 8;
        TrackEncryptionBox trackencryptionbox = null;
        int l;
        for (; k - i < j; k += l)
        {
            parsablebytearray.setPosition(k);
            l = parsablebytearray.readInt();
            int i1 = parsablebytearray.readInt();
            if (i1 == Atom.TYPE_frma)
            {
                parsablebytearray.readInt();
                continue;
            }
            if (i1 == Atom.TYPE_schm)
            {
                parsablebytearray.skipBytes(4);
                parsablebytearray.readInt();
                parsablebytearray.readInt();
                continue;
            }
            if (i1 == Atom.TYPE_schi)
            {
                trackencryptionbox = parseSchiFromParent(parsablebytearray, k, l);
            }
        }

        return trackencryptionbox;
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containeratom)
    {
        ParsableByteArray parsablebytearray = containeratom.getLeafAtomOfType(Atom.TYPE_stsz).data;
        Object obj = containeratom.getLeafAtomOfType(Atom.TYPE_stco);
        Atom.LeafAtom leafatom = ((Atom.LeafAtom) (obj));
        if (obj == null)
        {
            leafatom = containeratom.getLeafAtomOfType(Atom.TYPE_co64);
        }
        ParsableByteArray parsablebytearray1 = leafatom.data;
        ParsableByteArray parsablebytearray2 = containeratom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsablebytearray3 = containeratom.getLeafAtomOfType(Atom.TYPE_stts).data;
        obj = containeratom.getLeafAtomOfType(Atom.TYPE_stss);
        if (obj != null)
        {
            obj = ((Atom.LeafAtom) (obj)).data;
        } else
        {
            obj = null;
        }
        containeratom = containeratom.getLeafAtomOfType(Atom.TYPE_ctts);
        if (containeratom != null)
        {
            containeratom = ((Atom.LeafAtom) (containeratom)).data;
        } else
        {
            containeratom = null;
        }
        parsablebytearray.setPosition(12);
        int k5 = parsablebytearray.readUnsignedIntToInt();
        int l5 = parsablebytearray.readUnsignedIntToInt();
        long al[] = new long[l5];
        int ai[] = new int[l5];
        long al1[] = new long[l5];
        int ai1[] = new int[l5];
        if (l5 == 0)
        {
            return new TrackSampleTable(al, ai, al1, ai1);
        }
        parsablebytearray1.setPosition(12);
        int i6 = parsablebytearray1.readUnsignedIntToInt();
        parsablebytearray2.setPosition(12);
        int l2 = parsablebytearray2.readUnsignedIntToInt() - 1;
        boolean flag;
        if (parsablebytearray2.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag, "stsc first chunk must be 1");
        int j2 = parsablebytearray2.readUnsignedIntToInt();
        parsablebytearray2.skipBytes(4);
        int j = -1;
        if (l2 > 0)
        {
            j = parsablebytearray2.readUnsignedIntToInt() - 1;
        }
        int j3 = 0;
        int l1 = j2;
        parsablebytearray3.setPosition(12);
        int i4 = parsablebytearray3.readUnsignedIntToInt() - 1;
        int k4 = parsablebytearray3.readUnsignedIntToInt();
        int j4 = parsablebytearray3.readUnsignedIntToInt();
        int i = 0;
        int k = 0;
        int l = 0;
        if (containeratom != null)
        {
            containeratom.setPosition(12);
            k = containeratom.readUnsignedIntToInt() - 1;
            i = containeratom.readUnsignedIntToInt();
            l = containeratom.readInt();
        }
        int i1 = -1;
        int j1 = 0;
        if (obj != null)
        {
            ((ParsableByteArray) (obj)).setPosition(12);
            j1 = ((ParsableByteArray) (obj)).readUnsignedIntToInt();
            i1 = ((ParsableByteArray) (obj)).readUnsignedIntToInt() - 1;
        }
        long l6;
        if (leafatom.type == Atom.TYPE_stco)
        {
            l6 = parsablebytearray1.readUnsignedInt();
        } else
        {
            l6 = parsablebytearray1.readUnsignedLongToLong();
        }
        long l7 = 0L;
        int i2 = 0;
        int l3 = j1;
        int k1 = l;
        j1 = k;
        int k3 = i;
        l = k4;
        i = j2;
        k = l2;
        while (i2 < l5) 
        {
            al[i2] = l6;
            int k2;
            if (k5 == 0)
            {
                k2 = parsablebytearray.readUnsignedIntToInt();
            } else
            {
                k2 = k5;
            }
            ai[i2] = k2;
            al1[i2] = (long)k1 + l7;
            if (obj == null)
            {
                k2 = 1;
            } else
            {
                k2 = 0;
            }
            ai1[i2] = k2;
            int i3 = i1;
            k2 = l3;
            if (i2 == i1)
            {
                ai1[i2] = 1;
                l3--;
                i3 = i1;
                k2 = l3;
                if (l3 > 0)
                {
                    i3 = ((ParsableByteArray) (obj)).readUnsignedIntToInt() - 1;
                    k2 = l3;
                }
            }
            long l8 = l7 + (long)j4;
            i1 = l - 1;
            int l4 = i4;
            l = i1;
            l3 = j4;
            if (i1 == 0)
            {
                l4 = i4;
                l = i1;
                l3 = j4;
                if (i4 > 0)
                {
                    l = parsablebytearray3.readUnsignedIntToInt();
                    l3 = parsablebytearray3.readUnsignedIntToInt();
                    l4 = i4 - 1;
                }
            }
            i1 = k3;
            int j5 = j1;
            int i5 = k1;
            if (containeratom != null)
            {
                k3--;
                i1 = k3;
                j5 = j1;
                i5 = k1;
                if (k3 == 0)
                {
                    i1 = k3;
                    j5 = j1;
                    i5 = k1;
                    if (j1 > 0)
                    {
                        i1 = containeratom.readUnsignedIntToInt();
                        i5 = containeratom.readInt();
                        j5 = j1 - 1;
                    }
                }
            }
            l1--;
            if (l1 == 0)
            {
                i4 = j3 + 1;
                if (i4 < i6)
                {
                    if (leafatom.type == Atom.TYPE_stco)
                    {
                        l6 = parsablebytearray1.readUnsignedInt();
                    } else
                    {
                        l6 = parsablebytearray1.readUnsignedLongToLong();
                    }
                }
                j1 = k;
                k1 = j;
                if (i4 == j)
                {
                    j3 = parsablebytearray2.readUnsignedIntToInt();
                    parsablebytearray2.skipBytes(4);
                    k--;
                    j1 = k;
                    i = j3;
                    k1 = j;
                    if (k > 0)
                    {
                        k1 = parsablebytearray2.readUnsignedIntToInt() - 1;
                        i = j3;
                        j1 = k;
                    }
                }
                k = j1;
                k3 = i;
                j = k1;
                j3 = i4;
                l7 = l6;
                if (i4 < i6)
                {
                    l1 = i;
                    k = j1;
                    k3 = i;
                    j = k1;
                    j3 = i4;
                    l7 = l6;
                }
            } else
            {
                l7 = l6 + (long)ai[i2];
                k3 = i;
            }
            i2++;
            i = k3;
            i4 = l4;
            j4 = l3;
            k3 = i1;
            j1 = j5;
            k1 = i5;
            i1 = i3;
            l3 = k2;
            l6 = l7;
            l7 = l8;
        }
        Util.scaleLargeTimestampsInPlace(al1, 0xf4240L, track.timescale);
        if (l3 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (l == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (l1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i4 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (j1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return new TrackSampleTable(al, ai, al1, ai1);
    }

    private static StsdData parseStsd(ParsableByteArray parsablebytearray, int i, long l, int j, String s)
    {
        parsablebytearray.setPosition(12);
        int i1 = parsablebytearray.readInt();
        StsdData stsddata = new StsdData(i1);
        for (int k = 0; k < i1; k++)
        {
            int j1 = parsablebytearray.getPosition();
            int k1 = parsablebytearray.readInt();
            boolean flag;
            if (k1 > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkArgument(flag, "childAtomSize should be positive");
            int l1 = parsablebytearray.readInt();
            if (l1 == Atom.TYPE_avc1 || l1 == Atom.TYPE_avc3 || l1 == Atom.TYPE_encv || l1 == Atom.TYPE_mp4v || l1 == Atom.TYPE_hvc1 || l1 == Atom.TYPE_hev1 || l1 == Atom.TYPE_s263)
            {
                parseVideoSampleEntry(parsablebytearray, j1, k1, i, l, j, stsddata, k);
            } else
            if (l1 == Atom.TYPE_mp4a || l1 == Atom.TYPE_enca || l1 == Atom.TYPE_ac_3 || l1 == Atom.TYPE_ec_3 || l1 == Atom.TYPE_dtsc || l1 == Atom.TYPE_dtse || l1 == Atom.TYPE_dtsh || l1 == Atom.TYPE_dtsl)
            {
                parseAudioSampleEntry(parsablebytearray, l1, j1, k1, i, l, s, stsddata, k);
            } else
            if (l1 == Atom.TYPE_TTML)
            {
                stsddata.mediaFormat = MediaFormat.createTextFormat(i, "application/ttml+xml", -1, l, s);
            } else
            if (l1 == Atom.TYPE_tx3g)
            {
                stsddata.mediaFormat = MediaFormat.createTextFormat(i, "application/x-quicktime-tx3g", -1, l, s);
            } else
            if (l1 == Atom.TYPE_stpp)
            {
                stsddata.mediaFormat = MediaFormat.createTextFormat(i, "application/ttml+xml", -1, l, s, 0L);
            }
            parsablebytearray.setPosition(j1 + k1);
        }

        return stsddata;
    }

    private static TkhdData parseTkhd(ParsableByteArray parsablebytearray)
    {
        parsablebytearray.setPosition(8);
        int j1 = Atom.parseFullAtomVersion(parsablebytearray.readInt());
        int i;
        if (j1 == 0)
        {
            i = 8;
        } else
        {
            i = 16;
        }
        parsablebytearray.skipBytes(i);
        int i1 = parsablebytearray.readInt();
        parsablebytearray.skipBytes(4);
        int l = 1;
        int k1 = parsablebytearray.getPosition();
        if (j1 == 0)
        {
            i = 4;
        } else
        {
            i = 8;
        }
        int j = 0;
        boolean flag;
        do
        {
            flag = l;
            if (j >= i)
            {
                break;
            }
            if (parsablebytearray.data[k1 + j] != -1)
            {
                flag = false;
                break;
            }
            j++;
        } while (true);
        long l1;
        if (flag)
        {
            parsablebytearray.skipBytes(i);
            l1 = -1L;
        } else
        if (j1 == 0)
        {
            l1 = parsablebytearray.readUnsignedInt();
        } else
        {
            l1 = parsablebytearray.readUnsignedLongToLong();
        }
        parsablebytearray.skipBytes(16);
        i = parsablebytearray.readInt();
        j = parsablebytearray.readInt();
        parsablebytearray.skipBytes(4);
        int k = parsablebytearray.readInt();
        l = parsablebytearray.readInt();
        if (i == 0 && j == 0x10000 && k == 0xffff0000 && l == 0)
        {
            i = 90;
        } else
        if (i == 0 && j == 0xffff0000 && k == 0x10000 && l == 0)
        {
            i = 270;
        } else
        if (i == 0xffff0000 && j == 0 && k == 0 && l == 0xffff0000)
        {
            i = 180;
        } else
        {
            i = 0;
        }
        return new TkhdData(i1, l1, i);
    }

    public static Track parseTrak(Atom.ContainerAtom containeratom, Atom.LeafAtom leafatom)
    {
        Object obj = containeratom.getContainerAtomOfType(Atom.TYPE_mdia);
        int i = parseHdlr(((Atom.ContainerAtom) (obj)).getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (i != Track.TYPE_soun && i != Track.TYPE_vide && i != Track.TYPE_text && i != Track.TYPE_sbtl && i != Track.TYPE_subt)
        {
            return null;
        }
        containeratom = parseTkhd(containeratom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long l = ((TkhdData) (containeratom)).duration;
        long l1 = parseMvhd(leafatom.data);
        if (l == -1L)
        {
            l = -1L;
        } else
        {
            l = Util.scaleLargeTimestamp(l, 0xf4240L, l1);
        }
        leafatom = ((Atom.ContainerAtom) (obj)).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        obj = parseMdhd(((Atom.ContainerAtom) (obj)).getLeafAtomOfType(Atom.TYPE_mdhd).data);
        leafatom = parseStsd(leafatom.getLeafAtomOfType(Atom.TYPE_stsd).data, ((TkhdData) (containeratom)).id, l, ((TkhdData) (containeratom)).rotationDegrees, (String)((Pair) (obj)).second);
        if (((StsdData) (leafatom)).mediaFormat == null)
        {
            return null;
        } else
        {
            return new Track(((TkhdData) (containeratom)).id, i, ((Long)((Pair) (obj)).first).longValue(), l, ((StsdData) (leafatom)).mediaFormat, ((StsdData) (leafatom)).trackEncryptionBoxes, ((StsdData) (leafatom)).nalUnitLengthFieldLength);
        }
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsablebytearray, int i, int j, int k, long l, int i1, StsdData stsddata, 
            int j1)
    {
        parsablebytearray.setPosition(i + 8);
        parsablebytearray.skipBytes(24);
        int l1 = parsablebytearray.readUnsignedShort();
        int i2 = parsablebytearray.readUnsignedShort();
        boolean flag = false;
        float f = 1.0F;
        parsablebytearray.skipBytes(50);
        Object obj1 = null;
        int k1 = parsablebytearray.getPosition();
        String s;
        String s1;
        for (s1 = null; k1 - i < j; s1 = s)
        {
            parsablebytearray.setPosition(k1);
            int k2 = parsablebytearray.getPosition();
            int j2 = parsablebytearray.readInt();
            if (j2 == 0 && parsablebytearray.getPosition() - i == j)
            {
                break;
            }
            boolean flag1;
            if (j2 > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Assertions.checkArgument(flag1, "childAtomSize should be positive");
            int l2 = parsablebytearray.readInt();
            Object obj;
            if (l2 == Atom.TYPE_avcC)
            {
                boolean flag2;
                if (s1 == null)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                Assertions.checkState(flag2);
                s = "video/avc";
                obj1 = parseAvcCFromParent(parsablebytearray, k2);
                obj = ((AvcCData) (obj1)).initializationData;
                stsddata.nalUnitLengthFieldLength = ((AvcCData) (obj1)).nalUnitLengthFieldLength;
                if (!flag)
                {
                    f = ((AvcCData) (obj1)).pixelWidthAspectRatio;
                }
            } else
            if (l2 == Atom.TYPE_hvcC)
            {
                boolean flag3;
                if (s1 == null)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                Assertions.checkState(flag3);
                s = "video/hevc";
                obj1 = parseHvcCFromParent(parsablebytearray, k2);
                obj = (List)((Pair) (obj1)).first;
                stsddata.nalUnitLengthFieldLength = ((Integer)((Pair) (obj1)).second).intValue();
            } else
            if (l2 == Atom.TYPE_d263)
            {
                boolean flag4;
                if (s1 == null)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
                Assertions.checkState(flag4);
                s = "video/3gpp";
                obj = obj1;
            } else
            if (l2 == Atom.TYPE_esds)
            {
                boolean flag5;
                if (s1 == null)
                {
                    flag5 = true;
                } else
                {
                    flag5 = false;
                }
                Assertions.checkState(flag5);
                obj = parseEsdsFromParent(parsablebytearray, k2);
                s = (String)((Pair) (obj)).first;
                obj = Collections.singletonList(((Pair) (obj)).second);
            } else
            if (l2 == Atom.TYPE_sinf)
            {
                stsddata.trackEncryptionBoxes[j1] = parseSinfFromParent(parsablebytearray, k2, j2);
                obj = obj1;
                s = s1;
            } else
            {
                obj = obj1;
                s = s1;
                if (l2 == Atom.TYPE_pasp)
                {
                    f = parsePaspFromParent(parsablebytearray, k2);
                    flag = true;
                    s = s1;
                    obj = obj1;
                }
            }
            k1 += j2;
            obj1 = obj;
        }

        if (s1 == null)
        {
            return;
        } else
        {
            stsddata.mediaFormat = MediaFormat.createVideoFormat(k, s1, -1, -1, l, l1, i2, ((List) (obj1)), i1, f);
            return;
        }
    }
}
