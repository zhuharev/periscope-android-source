// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.crypto.prng.drbg:
//            SP80090DRBG, Utils

public class HashSP800DRBG
    implements SP80090DRBG
{

    private static final byte ayU[] = {
        1
    };
    private static final Hashtable ayV;
    private Digest ayJ;
    private int ayK;
    private byte ayW[];
    private EntropySource ayl;
    private int ayo;
    private byte ayq[];
    private long ayr;

    public HashSP800DRBG(Digest digest, int i, EntropySource entropysource, byte abyte0[], byte abyte1[])
    {
        if (i > Utils._mth02CA(digest))
        {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (entropysource._mth021A() < i)
        {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        } else
        {
            ayJ = digest;
            ayl = entropysource;
            ayK = i;
            ayo = ((Integer)ayV.get(digest._mth14AC())).intValue();
            digest = Arrays._mth02CE(entropysource._mth01B3(), abyte1, abyte0);
            ayq = Utils._mth02CA(ayJ, digest, ayo);
            digest = new byte[ayq.length + 1];
            System.arraycopy(ayq, 0, digest, 1, ayq.length);
            ayW = Utils._mth02CA(ayJ, digest, ayo);
            ayr = 1L;
            return;
        }
    }

    private byte[] _mth02B9(byte abyte0[], int i)
    {
        int j = ayJ._mth14AF();
        int l = i / 8 / j;
        byte abyte1[] = new byte[abyte0.length];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        abyte0 = new byte[i / 8];
        byte abyte2[] = new byte[ayJ._mth14AF()];
        for (i = 0; i <= l; i++)
        {
            ayJ.update(abyte1, 0, abyte1.length);
            ayJ.doFinal(abyte2, 0);
            int k;
            if (abyte0.length - abyte2.length * i > abyte2.length)
            {
                k = abyte2.length;
            } else
            {
                k = abyte0.length - abyte2.length * i;
            }
            System.arraycopy(abyte2, 0, abyte0, abyte2.length * i, k);
            _mth02BD(abyte1, ayU);
        }

        return abyte0;
    }

    private static void _mth02BD(byte abyte0[], byte abyte1[])
    {
        int i = 0;
        for (int j = 1; j <= abyte1.length; j++)
        {
            int l = (abyte0[abyte0.length - j] & 0xff) + (abyte1[abyte1.length - j] & 0xff) + i;
            if (l > 255)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            abyte0[abyte0.length - j] = (byte)l;
        }

        for (int k = abyte1.length + 1; k <= abyte0.length; k++)
        {
            int i1 = (abyte0[abyte0.length - k] & 0xff) + i;
            if (i1 > 255)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            abyte0[abyte0.length - k] = (byte)i1;
        }

    }

    public final int _mth02CA(byte abyte0[], byte abyte1[], boolean flag)
    {
        int i = abyte0.length << 3;
        if (i > 0x40000)
        {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (ayr > 0x800000000000L)
        {
            return -1;
        }
        if (flag)
        {
            _mth141F(null);
        }
        abyte1 = _mth02B9(ayq, i);
        byte abyte2[] = new byte[ayq.length + 1];
        System.arraycopy(ayq, 0, abyte2, 1, ayq.length);
        abyte2[0] = 3;
        byte abyte3[] = new byte[ayJ._mth14AF()];
        ayJ.update(abyte2, 0, abyte2.length);
        ayJ.doFinal(abyte3, 0);
        _mth02BD(ayq, abyte3);
        _mth02BD(ayq, ayW);
        byte byte0 = (byte)(int)(ayr >> 24);
        byte byte1 = (byte)(int)(ayr >> 16);
        byte byte2 = (byte)(int)(ayr >> 8);
        byte byte3 = (byte)(int)ayr;
        _mth02BD(ayq, new byte[] {
            byte0, byte1, byte2, byte3
        });
        ayr = ayr + 1L;
        System.arraycopy(abyte1, 0, abyte0, 0, abyte0.length);
        return i;
    }

    public final void _mth141F(byte abyte0[])
    {
        byte abyte1[] = ayl._mth01B3();
        abyte0 = Arrays._mth02CE(ayU, ayq, abyte1, abyte0);
        ayq = Utils._mth02CA(ayJ, abyte0, ayo);
        abyte0 = new byte[ayq.length + 1];
        abyte0[0] = 0;
        System.arraycopy(ayq, 0, abyte0, 1, ayq.length);
        ayW = Utils._mth02CA(ayJ, abyte0, ayo);
        ayr = 1L;
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        ayV = hashtable;
        hashtable.put("SHA-1", Integers.valueOf(440));
        ayV.put("SHA-224", Integers.valueOf(440));
        ayV.put("SHA-256", Integers.valueOf(440));
        ayV.put("SHA-512/256", Integers.valueOf(440));
        ayV.put("SHA-512/224", Integers.valueOf(440));
        ayV.put("SHA-384", Integers.valueOf(888));
        ayV.put("SHA-512", Integers.valueOf(888));
    }
}
