// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

public interface DSAKCalculator
{

    public abstract boolean _mth029D();

    public abstract BigInteger _mth02AD();

    public abstract void _mth02CA(BigInteger biginteger, BigInteger biginteger1, byte abyte0[]);

    public abstract void _mth02CE(BigInteger biginteger, SecureRandom securerandom);
}
