// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;

public class JPAKEUtil
{

    static final BigInteger ONE = BigInteger.valueOf(1L);
    static final BigInteger ZERO = BigInteger.valueOf(0L);

    public JPAKEUtil()
    {
    }

    public static void _mth02CA(BigInteger biginteger, String s)
    {
        if (biginteger == null)
        {
            throw new NullPointerException((new StringBuilder()).append(s).append(" must not be null").toString());
        } else
        {
            return;
        }
    }

}
