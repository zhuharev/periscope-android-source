// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class BigIntUtils
{

    private BigIntUtils()
    {
    }

    public static byte[] _mth02C9(BigInteger biginteger)
    {
        byte abyte0[] = biginteger.toByteArray();
        if (abyte0.length == 1 || (biginteger.bitLength() & 7) != 0)
        {
            return abyte0;
        } else
        {
            biginteger = new byte[biginteger.bitLength() >> 3];
            System.arraycopy(abyte0, 1, biginteger, 0, biginteger.length);
            return biginteger;
        }
    }
}
