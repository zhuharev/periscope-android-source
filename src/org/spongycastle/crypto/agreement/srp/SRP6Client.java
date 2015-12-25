// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;

// Referenced classes of package org.spongycastle.crypto.agreement.srp:
//            SRP6Util

public class SRP6Client
{

    private SecureRandom amC;
    private BigInteger amO;
    private Digest amS;
    private BigInteger amV;
    private BigInteger amW;
    private BigInteger amX;
    private BigInteger amY;
    private BigInteger amZ;
    private BigInteger ana;
    private BigInteger anb;

    public SRP6Client()
    {
    }

    public final BigInteger _mth02CA(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        amZ = SRP6Util._mth02CA(amS, abyte0, abyte1, abyte2);
        amW = SRP6Util._mth02CA(amV, amC);
        amX = amO.modPow(amW, amV);
        return amX;
    }

    public final void _mth02CA(BigInteger biginteger, BigInteger biginteger1, Digest digest, SecureRandom securerandom)
    {
        amV = biginteger;
        amO = biginteger1;
        amS = digest;
        amC = securerandom;
    }

    public final BigInteger _mth02CB(BigInteger biginteger)
    {
        amY = SRP6Util._mth02CA(amV, biginteger);
        ana = SRP6Util._mth02CA(amS, amV, amX, amY);
        BigInteger biginteger1 = SRP6Util._mth02CA(amS, amV, amO);
        biginteger = ana.multiply(amZ).add(amW);
        biginteger1 = amO.modPow(amZ, amV).multiply(biginteger1).mod(amV);
        anb = amY.subtract(biginteger1).mod(amV).modPow(biginteger, amV);
        return anb;
    }
}
