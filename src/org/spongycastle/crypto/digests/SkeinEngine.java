// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Memoable;

public class SkeinEngine
    implements Memoable
{
    static class Configuration
    {

        byte bytes[];

        public Configuration(long l)
        {
            bytes = new byte[32];
            bytes[0] = 83;
            bytes[1] = 72;
            bytes[2] = 65;
            bytes[3] = 51;
            bytes[4] = 1;
            bytes[5] = 0;
            ThreefishEngine._mth02CB(l, bytes, 8);
        }
    }

    public static class Parameter
    {

        byte VP[];
        int type;

        public Parameter(int i, byte abyte0[])
        {
            type = i;
            VP = abyte0;
        }
    }

    public class UBI
    {

        final UbiTweak aoL = new UbiTweak();
        private byte aoM[];
        int aoN;
        private long aoO[];
        private SkeinEngine aoP;

        private void _mth02BC(long al[])
        {
            ThreefishEngine threefishengine = aoP.aoD;
            long al1[] = aoP.aoF;
            long al2[] = aoL.aoQ;
            threefishengine.amy = true;
            if (al1 != null)
            {
                threefishengine._mth1FBE(al1);
            }
            if (al2 != null)
            {
                threefishengine._mth02BE(al2);
            }
            for (int i = 0; i < aoO.length; i++)
            {
                aoO[i] = ThreefishEngine._mth02CC(aoM, i << 3);
            }

            aoP.aoD._mth02CA(aoO, al);
            for (int j = 0; j < al.length; j++)
            {
                al[j] = al[j] ^ aoO[j];
            }

        }

        public final void _mth02BD(long al[])
        {
            for (int i = aoN; i < aoM.length; i++)
            {
                aoM[i] = 0;
            }

            long al1[] = aoL.aoQ;
            al1[1] = al1[1] | 0x8000000000000000L;
            _mth02BC(al);
        }

        public final void _mth02CA(UBI ubi)
        {
            aoM = Arrays.FE73(ubi.aoM, aoM);
            aoN = ubi.aoN;
            aoO = Arrays._mth141D(ubi.aoO, aoO);
            UbiTweak ubitweak = aoL;
            ubi = ubi.aoL;
            ubitweak.aoQ = Arrays._mth141D(((UbiTweak) (ubi)).aoQ, ubitweak.aoQ);
            ubitweak.aoR = ((UbiTweak) (ubi)).aoR;
        }

        public final void _mth02CA(byte abyte0[], int i, int j, long al[])
        {
            for (int k = 0; j > k;)
            {
                if (aoN == aoM.length)
                {
                    _mth02BC(al);
                    long al1[] = aoL.aoQ;
                    al1[1] = al1[1] & 0xbfffffffffffffffL;
                    aoN = 0;
                }
                int l = Math.min(j - k, aoM.length - aoN);
                System.arraycopy(abyte0, i + k, aoM, aoN, l);
                k += l;
                aoN = aoN + l;
                aoL._mth1D64(l);
            }

        }

        public UBI(int i)
        {
            aoP = SkeinEngine.this;
            super();
            aoM = new byte[i];
            aoO = new long[aoM.length / 8];
        }
    }

    static class UbiTweak
    {

        long aoQ[];
        boolean aoR;

        public String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder()).append((int)(aoQ[1] >>> 56 & 63L)).append(" first: ");
            boolean flag;
            if ((aoQ[1] & 0x4000000000000000L) != 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            stringbuilder = stringbuilder.append(flag).append(", final: ");
            if ((aoQ[1] & 0x8000000000000000L) != 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return stringbuilder.append(flag).toString();
        }

        public final void _mth1D64(int i)
        {
            if (aoR)
            {
                long al[] = new long[3];
                al[0] = aoQ[0] & 0xffffffffL;
                al[1] = aoQ[0] >>> 32 & 0xffffffffL;
                al[2] = aoQ[1] & 0xffffffffL;
                long l = i;
                for (i = 0; i < 3; i++)
                {
                    l += al[i];
                    al[i] = l;
                    l >>>= 32;
                }

                aoQ[0] = (al[1] & 0xffffffffL) << 32 | al[0] & 0xffffffffL;
                aoQ[1] = aoQ[1] & 0xffffffff00000000L | al[2] & 0xffffffffL;
                return;
            }
            long l1 = aoQ[0] + (long)i;
            aoQ[0] = l1;
            if (l1 > 0x7fffffff80000000L)
            {
                aoR = true;
            }
        }

        public UbiTweak()
        {
            aoQ = new long[2];
            aoQ[0] = 0L;
            aoQ[1] = 0L;
            aoR = false;
            long al[] = aoQ;
            al[1] = al[1] | 0x4000000000000000L;
        }
    }


    private static final Hashtable aoC = new Hashtable();
    public final ThreefishEngine aoD;
    public final int aoE;
    public long aoF[];
    long aoG[];
    private Parameter aoH[];
    private Parameter aoI[];
    public final UBI aoJ;
    final byte aoK[];
    private byte key[];

    public SkeinEngine(int i, int j)
    {
        aoK = new byte[1];
        if (j % 8 != 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Output size must be a multiple of 8 bits. :")).append(j).toString());
        } else
        {
            aoE = j / 8;
            aoD = new ThreefishEngine(i);
            aoJ = new UBI(aoD.atu);
            return;
        }
    }

    public SkeinEngine(SkeinEngine skeinengine)
    {
        this(skeinengine.aoD.atu << 3, skeinengine.aoE << 3);
        _mth02CA(skeinengine);
    }

    private void _mth02BD(Hashtable hashtable)
    {
        Enumeration enumeration = hashtable.keys();
        Vector vector = new Vector();
        Vector vector1 = new Vector();
        while (enumeration.hasMoreElements()) 
        {
            Integer integer = (Integer)enumeration.nextElement();
            byte abyte0[] = (byte[])hashtable.get(integer);
            if (integer.intValue() == 0)
            {
                key = abyte0;
            } else
            if (integer.intValue() < 48)
            {
                vector.addElement(new Parameter(integer.intValue(), abyte0));
            } else
            {
                vector1.addElement(new Parameter(integer.intValue(), abyte0));
            }
        }
        aoH = new Parameter[vector.size()];
        vector.copyInto(aoH);
        _mth02CA(aoH);
        aoI = new Parameter[vector1.size()];
        vector1.copyInto(aoI);
        _mth02CA(aoI);
    }

    private static void _mth02CA(int i, int j, long al[])
    {
        Hashtable hashtable = aoC;
        i /= 8;
        hashtable.put(new Integer(j / 8 << 16 | i), al);
    }

    private void _mth02CA(int i, byte abyte0[])
    {
        UBI ubi = aoJ;
        UbiTweak ubitweak = ubi.aoL;
        ubitweak.aoQ[0] = 0L;
        ubitweak.aoQ[1] = 0L;
        ubitweak.aoR = false;
        long al[] = ubitweak.aoQ;
        al[1] = al[1] | 0x4000000000000000L;
        al = ubi.aoL;
        ((UbiTweak) (al)).aoQ[1] = ((UbiTweak) (al)).aoQ[1] & 0xffffffc000000000L | ((long)i & 63L) << 56;
        ubi.aoN = 0;
        aoJ._mth02CA(abyte0, 0, abyte0.length, aoF);
        aoJ._mth02BD(aoF);
    }

    private void _mth02CA(SkeinEngine skeinengine)
    {
        aoJ._mth02CA(skeinengine.aoJ);
        aoF = Arrays._mth141D(skeinengine.aoF, aoF);
        aoG = Arrays._mth141D(skeinengine.aoG, aoG);
        key = Arrays.FE73(skeinengine.key, key);
        aoH = _mth02CA(skeinengine.aoH, aoH);
        aoI = _mth02CA(skeinengine.aoI, aoI);
    }

    private static void _mth02CA(Parameter aparameter[])
    {
        if (aparameter == null)
        {
            return;
        }
        for (int i = 1; i < aparameter.length; i++)
        {
            Parameter parameter = aparameter[i];
            int j;
            for (j = i; j > 0 && parameter.type < aparameter[j - 1].type; j--)
            {
                aparameter[j] = aparameter[j - 1];
            }

            aparameter[j] = parameter;
        }

    }

    private static Parameter[] _mth02CA(Parameter aparameter[], Parameter aparameter1[])
    {
        Parameter aparameter2[];
label0:
        {
            if (aparameter == null)
            {
                return null;
            }
            if (aparameter1 != null)
            {
                aparameter2 = aparameter1;
                if (aparameter1.length == aparameter.length)
                {
                    break label0;
                }
            }
            aparameter2 = new Parameter[aparameter.length];
        }
        System.arraycopy(aparameter, 0, aparameter2, 0, aparameter2.length);
        return aparameter2;
    }

    private void _mth02CB(long l, byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[8];
        ThreefishEngine._mth02CB(l, abyte1, 0);
        long al[] = new long[aoF.length];
        _mth1D58(63);
        aoJ._mth02CA(abyte1, 0, 8, al);
        aoJ._mth02BD(al);
        int i1 = ((j + 8) - 1) / 8;
        for (int k = 0; k < i1; k++)
        {
            int j1 = Math.min(8, j - (k << 3));
            if (j1 == 8)
            {
                ThreefishEngine._mth02CB(al[k], abyte0, (k << 3) + i);
            } else
            {
                ThreefishEngine._mth02CB(al[k], abyte1, 0);
                System.arraycopy(abyte1, 0, abyte0, (k << 3) + i, j1);
            }
        }

    }

    private void _mth14DB()
    {
        Hashtable hashtable = aoC;
        int i = aoD.atu;
        long al[] = (long[])hashtable.get(new Integer(aoE << 16 | i));
        if (key == null && al != null)
        {
            aoF = Arrays._mth02BF(al);
        } else
        {
            aoF = new long[aoD.atu / 8];
            if (key != null)
            {
                _mth02CA(0, key);
            }
            _mth02CA(4, (new Configuration(aoE << 3)).bytes);
        }
        if (aoH != null)
        {
            for (int j = 0; j < aoH.length; j++)
            {
                Parameter parameter = aoH[j];
                _mth02CA(parameter.type, parameter.VP);
            }

        }
        aoG = Arrays._mth02BF(aoF);
    }

    private void _mth152B()
    {
        aoJ._mth02BD(aoF);
    }

    private void _mth1D58(int i)
    {
        UBI ubi = aoJ;
        UbiTweak ubitweak = ubi.aoL;
        ubitweak.aoQ[0] = 0L;
        ubitweak.aoQ[1] = 0L;
        ubitweak.aoR = false;
        long al[] = ubitweak.aoQ;
        al[1] = al[1] | 0x4000000000000000L;
        al = ubi.aoL;
        ((UbiTweak) (al)).aoQ[1] = ((UbiTweak) (al)).aoQ[1] & 0xffffffc000000000L | ((long)i & 63L) << 56;
        ubi.aoN = 0;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        if (abyte0.length < aoE + i)
        {
            throw new DataLengthException((new StringBuilder("Output buffer is too short to hold output of ")).append(aoE).append(" bytes").toString());
        }
        _mth152B();
        if (aoI != null)
        {
            for (int j = 0; j < aoI.length; j++)
            {
                Parameter parameter = aoI[j];
                _mth02CA(parameter.type, parameter.VP);
            }

        }
        int l = aoD.atu;
        int i1 = ((aoE + l) - 1) / l;
        for (int k = 0; k < i1; k++)
        {
            int j1 = Math.min(l, aoE - k * l);
            _mth02CB(k, abyte0, k * l + i, j1);
        }

        reset();
        return aoE;
    }

    public final void reset()
    {
        System.arraycopy(aoG, 0, aoF, 0, aoF.length);
        UBI ubi = aoJ;
        UbiTweak ubitweak = ubi.aoL;
        ubitweak.aoQ[0] = 0L;
        ubitweak.aoQ[1] = 0L;
        ubitweak.aoR = false;
        long al[] = ubitweak.aoQ;
        al[1] = al[1] | 0x4000000000000000L;
        al = ubi.aoL;
        ((UbiTweak) (al)).aoQ[1] = ((UbiTweak) (al)).aoQ[1] & 0xffffffc000000000L | 0x3000000000000000L;
        ubi.aoN = 0;
    }

    public final void update(byte byte0)
    {
        aoK[0] = byte0;
        byte abyte0[] = aoK;
        aoJ._mth02CA(abyte0, 0, 1, aoF);
    }

    public final void _mth02CA(SkeinParameters skeinparameters)
    {
        aoF = null;
        key = null;
        aoH = null;
        aoI = null;
        if (skeinparameters != null)
        {
            if (((byte[])skeinparameters.axJ.get(Integers.valueOf(0))).length < 16)
            {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
            _mth02BD(skeinparameters.axJ);
        }
        _mth14DB();
        skeinparameters = aoJ;
        UbiTweak ubitweak = ((UBI) (skeinparameters)).aoL;
        ubitweak.aoQ[0] = 0L;
        ubitweak.aoQ[1] = 0L;
        ubitweak.aoR = false;
        long al[] = ubitweak.aoQ;
        al[1] = al[1] | 0x4000000000000000L;
        al = ((UBI) (skeinparameters)).aoL;
        ((UbiTweak) (al)).aoQ[1] = ((UbiTweak) (al)).aoQ[1] & 0xffffffc000000000L | 0x3000000000000000L;
        skeinparameters.aoN = 0;
    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (SkeinEngine)memoable;
        if (aoD.atu != ((SkeinEngine) (memoable)).aoD.atu || aoE != ((SkeinEngine) (memoable)).aoE)
        {
            throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
        } else
        {
            _mth02CA(((SkeinEngine) (memoable)));
            return;
        }
    }

    public final Memoable _mth14B7()
    {
        return new SkeinEngine(this);
    }

    static 
    {
        _mth02CA(256, 128, new long[] {
            0xe1111906964d7260L, 0x883daaa77c8d811cL, 0x10080df491960f7aL, 0xccf7dde5b45bc1c2L
        });
        _mth02CA(256, 160, new long[] {
            0x1420231472825e98L, 0x2ac4e9a25a77e590L, 0xd47a58568838d63eL, 0x2dd2e4968586ab7dL
        });
        _mth02CA(256, 224, new long[] {
            0xc6098a8c9ae5ea0bL, 0x876d568608c5191cL, 0x99cb88d7d7f53884L, 0x384bddb1aeddb5deL
        });
        _mth02CA(256, 256, new long[] {
            0xfc9da860d048b449L, 0x2fca66479fa7d833L, 0xb33bc3896656840fL, 0x6a54e920fde8da69L
        });
        _mth02CA(512, 128, new long[] {
            0xa8bc7bf36fbf9f52L, 0x1e9872cebd1af0aaL, 0x309b1790b32190d3L, 0xbcfbb8543f94805cL, 0xda61bcd6e31b11bL, 0x1a18ebead46a32e3L, 0xa2cc5b18ce84aa82L, 0x6982ab289d46982dL
        });
        _mth02CA(512, 160, new long[] {
            0x28b81a2ae013bd91L, 0xc2f11668b5bdf78fL, 0x1760d8f3f6a56f12L, 0x4fb747588239904fL, 0x21ede07f7eaf5056L, 0xd908922e63ed70b8L, 0xb8ec76ffeccb52faL, 0x1a47bb8a3f27a6eL
        });
        _mth02CA(512, 224, new long[] {
            0xccd0616248677224L, 0xcba65cf3a92339efL, 0x8ccd69d652ff4b64L, 0x398aed7b3ab890b4L, 0xf59d1b1457d2bd0L, 0x6776fe6575d4eb3dL, 0x99fbc70e997413e9L, 0x9e2cfccfe1c41ef7L
        });
        _mth02CA(512, 384, new long[] {
            0xa3f6c6bf3a75ef5fL, 0xb0fef9ccfd84faa4L, 0x9d77dd663d770cfeL, 0xd798cbf3b468fddaL, 0x1bc4a6668a0e4465L, 0x7ed7d434e5807407L, 0x548fc1acd4ec44d6L, 0x266e17546aa18ff8L
        });
        _mth02CA(512, 512, new long[] {
            0x4903adff749c51ceL, 0xd95de399746df03L, 0x8fd1934127c79bceL, 0x9a255629ff352cb1L, 0x5db62599df6ca7b0L, 0xeabe394ca9d5c3f4L, 0x991112c71a75b523L, 0xae18a40b660fcc33L
        });
    }
}
