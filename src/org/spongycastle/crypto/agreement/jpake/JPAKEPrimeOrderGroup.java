// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.crypto.agreement.jpake:
//            JPAKEUtil

public class JPAKEPrimeOrderGroup
{

    private final BigInteger amM;
    private final BigInteger amN;
    private final BigInteger amO;

    JPAKEPrimeOrderGroup(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, boolean flag)
    {
        JPAKEUtil._mth02CA(biginteger, "p");
        JPAKEUtil._mth02CA(biginteger1, "q");
        JPAKEUtil._mth02CA(biginteger2, "g");
        amM = biginteger;
        amN = biginteger1;
        amO = biginteger2;
    }
}
