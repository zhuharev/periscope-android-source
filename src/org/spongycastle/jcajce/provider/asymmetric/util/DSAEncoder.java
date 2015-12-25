// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;

public interface DSAEncoder
{

    public abstract byte[] _mth02CB(BigInteger biginteger, BigInteger biginteger1);

    public abstract BigInteger[] _mth1D57(byte abyte0[]);
}
