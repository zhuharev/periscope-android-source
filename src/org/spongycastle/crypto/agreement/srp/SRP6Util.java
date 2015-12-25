// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.BigIntegers;

public class SRP6Util
{

    private static BigInteger ONE = BigInteger.valueOf(1L);
    private static BigInteger ZERO = BigInteger.valueOf(0L);

    public SRP6Util()
    {
    }

    public static BigInteger _mth02CA(BigInteger biginteger, BigInteger biginteger1)
    {
        biginteger = biginteger1.mod(biginteger);
        if (biginteger.equals(ZERO))
        {
            throw new CryptoException("Invalid public value: 0");
        } else
        {
            return biginteger;
        }
    }

    public static BigInteger _mth02CA(BigInteger biginteger, SecureRandom securerandom)
    {
        int i = Math.min(256, biginteger.bitLength() / 2);
        return BigIntegers._mth02CB(ONE.shiftLeft(i - 1), biginteger.subtract(ONE), securerandom);
    }

    public static BigInteger _mth02CA(Digest digest, BigInteger biginteger, BigInteger biginteger1)
    {
        return _mth02CB(digest, biginteger, biginteger, biginteger1);
    }

    public static BigInteger _mth02CA(Digest digest, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        return _mth02CB(digest, biginteger, biginteger1, biginteger2);
    }

    public static BigInteger _mth02CA(Digest digest, byte abyte0[], byte abyte1[], byte abyte2[])
    {
        byte abyte3[] = new byte[digest._mth14AF()];
        digest.update(abyte1, 0, abyte1.length);
        digest.update((byte)58);
        digest.update(abyte2, 0, abyte2.length);
        digest.doFinal(abyte3, 0);
        digest.update(abyte0, 0, abyte0.length);
        digest.update(abyte3, 0, abyte3.length);
        digest.doFinal(abyte3, 0);
        return new BigInteger(1, abyte3);
    }

    private static BigInteger _mth02CB(Digest digest, BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2)
    {
        int i = (biginteger.bitLength() + 7) / 8;
        biginteger1 = BigIntegers._mth02D1(biginteger1);
        biginteger = biginteger1;
        if (biginteger1.length < i)
        {
            biginteger = new byte[i];
            System.arraycopy(biginteger1, 0, biginteger, i - biginteger1.length, biginteger1.length);
        }
        biginteger2 = BigIntegers._mth02D1(biginteger2);
        biginteger1 = biginteger2;
        if (biginteger2.length < i)
        {
            biginteger1 = new byte[i];
            System.arraycopy(biginteger2, 0, biginteger1, i - biginteger2.length, biginteger2.length);
        }
        digest.update(biginteger, 0, biginteger.length);
        digest.update(biginteger1, 0, biginteger1.length);
        biginteger = new byte[digest._mth14AF()];
        digest.doFinal(biginteger, 0);
        return new BigInteger(1, biginteger);
    }

}
