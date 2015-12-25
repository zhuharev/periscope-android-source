// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

// Referenced classes of package org.spongycastle.crypto.signers:
//            DSAKCalculator

public class HMacDSAKCalculator
    implements DSAKCalculator
{

    private static final BigInteger ZERO = BigInteger.valueOf(0L);
    private BigInteger alr;
    private final byte anl[];
    private final byte anr[];
    private final HMac aze;

    public HMacDSAKCalculator(Digest digest)
    {
        aze = new HMac(digest);
        anr = new byte[aze.auN];
        anl = new byte[aze.auN];
    }

    private BigInteger _mth142A(byte abyte0[])
    {
        BigInteger biginteger1 = new BigInteger(1, abyte0);
        BigInteger biginteger = biginteger1;
        if (abyte0.length << 3 > alr.bitLength())
        {
            biginteger = biginteger1.shiftRight((abyte0.length << 3) - alr.bitLength());
        }
        return biginteger;
    }

    public final boolean _mth029D()
    {
        return true;
    }

    public final BigInteger _mth02AD()
    {
        byte abyte0[] = new byte[(alr.bitLength() + 7) / 8];
        do
        {
            int j;
            for (int i = 0; i < abyte0.length; i += j)
            {
                aze.update(anr, 0, anr.length);
                aze.doFinal(anr, 0);
                j = Math.min(abyte0.length - i, anr.length);
                System.arraycopy(anr, 0, abyte0, i, j);
            }

            BigInteger biginteger = _mth142A(abyte0);
            if (biginteger.compareTo(ZERO) > 0 && biginteger.compareTo(alr) < 0)
            {
                return biginteger;
            }
            aze.update(anr, 0, anr.length);
            aze.update((byte)0);
            aze.doFinal(anl, 0);
            aze._mth02CA(new KeyParameter(anl));
            aze.update(anr, 0, anr.length);
            aze.doFinal(anr, 0);
        } while (true);
    }

    public final void _mth02CA(BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        alr = biginteger;
        Arrays.fill(anr, (byte)1);
        Arrays.fill(anl, (byte)0);
        byte abyte1[] = new byte[(biginteger.bitLength() + 7) / 8];
        biginteger1 = BigIntegers._mth02D1(biginteger1);
        System.arraycopy(biginteger1, 0, abyte1, abyte1.length - biginteger1.length, biginteger1.length);
        byte abyte2[] = new byte[(biginteger.bitLength() + 7) / 8];
        abyte0 = _mth142A(abyte0);
        biginteger1 = abyte0;
        if (abyte0.compareTo(biginteger) > 0)
        {
            biginteger1 = abyte0.subtract(biginteger);
        }
        biginteger = BigIntegers._mth02D1(biginteger1);
        System.arraycopy(biginteger, 0, abyte2, abyte2.length - biginteger.length, biginteger.length);
        aze._mth02CA(new KeyParameter(anl));
        aze.update(anr, 0, anr.length);
        aze.update((byte)0);
        aze.update(abyte1, 0, abyte1.length);
        aze.update(abyte2, 0, abyte2.length);
        aze.doFinal(anl, 0);
        aze._mth02CA(new KeyParameter(anl));
        aze.update(anr, 0, anr.length);
        aze.doFinal(anr, 0);
        aze.update(anr, 0, anr.length);
        aze.update((byte)1);
        aze.update(abyte1, 0, abyte1.length);
        aze.update(abyte2, 0, abyte2.length);
        aze.doFinal(anl, 0);
        aze._mth02CA(new KeyParameter(anl));
        aze.update(anr, 0, anr.length);
        aze.doFinal(anr, 0);
    }

    public final void _mth02CE(BigInteger biginteger, SecureRandom securerandom)
    {
        throw new IllegalStateException("Operation not supported");
    }

}
