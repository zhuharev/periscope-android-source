// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            SignatureSpi

static class <init>
    implements DSAEncoder
{

    public final byte[] _mth02CB(BigInteger biginteger, BigInteger biginteger1)
    {
        biginteger = biginteger.toByteArray();
        if (biginteger[0] == 0)
        {
            byte abyte0[] = new byte[biginteger.length - 1];
            System.arraycopy(biginteger, 1, abyte0, 0, abyte0.length);
            biginteger = abyte0;
        }
        biginteger1 = biginteger1.toByteArray();
        if (biginteger1[0] == 0)
        {
            byte abyte1[] = new byte[biginteger1.length - 1];
            System.arraycopy(biginteger1, 1, abyte1, 0, abyte1.length);
            biginteger1 = abyte1;
        }
        byte abyte2[];
        if (biginteger.length > biginteger1.length)
        {
            abyte2 = new byte[biginteger.length << 1];
        } else
        {
            abyte2 = new byte[biginteger1.length << 1];
        }
        System.arraycopy(biginteger, 0, abyte2, abyte2.length / 2 - biginteger.length, biginteger.length);
        System.arraycopy(biginteger1, 0, abyte2, abyte2.length - biginteger1.length, biginteger1.length);
        return abyte2;
    }

    public final BigInteger[] _mth1D57(byte abyte0[])
    {
        byte abyte1[] = new byte[abyte0.length / 2];
        byte abyte2[] = new byte[abyte0.length / 2];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
        System.arraycopy(abyte0, abyte1.length, abyte2, 0, abyte2.length);
        return (new BigInteger[] {
            new BigInteger(1, abyte1), new BigInteger(1, abyte2)
        });
    }

    private Q()
    {
    }

    Q(byte byte0)
    {
        this();
    }
}
