// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.ec:
//            SignatureSpi

static class <init>
    implements DSAEncoder
{

    public final byte[] _mth02CB(BigInteger biginteger, BigInteger biginteger1)
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        biginteger = new ASN1Integer(biginteger);
        asn1encodablevector.VS.addElement(biginteger);
        biginteger = new ASN1Integer(biginteger1);
        asn1encodablevector.VS.addElement(biginteger);
        return (new DERSequence(asn1encodablevector)).getEncoded("DER");
    }

    public final BigInteger[] _mth1D57(byte abyte0[])
    {
        abyte0 = (ASN1Sequence)ASN1Primitive._mth0640(abyte0);
        return (new BigInteger[] {
            new BigInteger(ASN1Integer.FB1D(abyte0._mth144B(0)).bytes), new BigInteger(ASN1Integer.FB1D(abyte0._mth144B(1)).bytes)
        });
    }

    private ()
    {
    }

    (byte byte0)
    {
        this();
    }
}
