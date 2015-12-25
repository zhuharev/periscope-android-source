// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.prng.drbg:
//            SP80090DRBG, Utils

public class HMacSP800DRBG
    implements SP80090DRBG
{

    private byte ayS[];
    private Mac ayT;
    private EntropySource ayl;
    private byte ayq[];
    private long ayr;

    public HMacSP800DRBG(Mac mac, int i, EntropySource entropysource, byte abyte0[], byte abyte1[])
    {
        if (i > Utils._mth02CA(mac))
        {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (entropysource._mth021A() < i)
        {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        ayl = entropysource;
        ayT = mac;
        entropysource = Arrays._mth02CE(entropysource._mth01B3(), abyte1, abyte0);
        ayS = new byte[mac._mth14B3()];
        ayq = new byte[ayS.length];
        Arrays.fill(ayq, (byte)1);
        _mth02CA(entropysource, (byte)0);
        if (entropysource != null)
        {
            _mth02CA(entropysource, (byte)1);
        }
        ayr = 1L;
    }

    private void _mth02CA(byte abyte0[], byte byte0)
    {
        ayT._mth02CA(new KeyParameter(ayS));
        ayT.update(ayq, 0, ayq.length);
        ayT.update(byte0);
        if (abyte0 != null)
        {
            ayT.update(abyte0, 0, abyte0.length);
        }
        ayT.doFinal(ayS, 0);
        ayT._mth02CA(new KeyParameter(ayS));
        ayT.update(ayq, 0, ayq.length);
        ayT.doFinal(ayq, 0);
    }

    public final int _mth02CA(byte abyte0[], byte abyte1[], boolean flag)
    {
        int j = abyte0.length << 3;
        if (j > 0x40000)
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
        abyte1 = new byte[abyte0.length];
        int k = abyte0.length / ayq.length;
        ayT._mth02CA(new KeyParameter(ayS));
        for (int i = 0; i < k; i++)
        {
            ayT.update(ayq, 0, ayq.length);
            ayT.doFinal(ayq, 0);
            System.arraycopy(ayq, 0, abyte1, ayq.length * i, ayq.length);
        }

        if (ayq.length * k < abyte1.length)
        {
            ayT.update(ayq, 0, ayq.length);
            ayT.doFinal(ayq, 0);
            System.arraycopy(ayq, 0, abyte1, ayq.length * k, abyte1.length - ayq.length * k);
        }
        _mth02CA(null, (byte)0);
        ayr = ayr + 1L;
        System.arraycopy(abyte1, 0, abyte0, 0, abyte0.length);
        return j;
    }

    public final void _mth141F(byte abyte0[])
    {
        abyte0 = Arrays._mth0640(ayl._mth01B3(), abyte0);
        _mth02CA(abyte0, (byte)0);
        if (abyte0 != null)
        {
            _mth02CA(abyte0, (byte)1);
        }
        ayr = 1L;
    }
}
