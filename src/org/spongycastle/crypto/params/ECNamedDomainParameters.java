// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

// Referenced classes of package org.spongycastle.crypto.params:
//            ECDomainParameters

public class ECNamedDomainParameters extends ECDomainParameters
{

    private ASN1ObjectIdentifier aho;

    public ECNamedDomainParameters(ASN1ObjectIdentifier asn1objectidentifier, ECCurve eccurve, ECPoint ecpoint, BigInteger biginteger, BigInteger biginteger1, byte abyte0[])
    {
        super(eccurve, ecpoint, biginteger, biginteger1, abyte0);
        aho = asn1objectidentifier;
    }
}
