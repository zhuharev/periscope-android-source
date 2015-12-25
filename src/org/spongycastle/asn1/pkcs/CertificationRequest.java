// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            CertificationRequestInfo

public class CertificationRequest extends ASN1Object
{

    private CertificationRequestInfo aaD;
    private AlgorithmIdentifier aaE;
    private DERBitString aaF;

    protected CertificationRequest()
    {
        aaD = null;
        aaE = null;
        aaF = null;
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.VS.addElement(null);
        asn1encodablevector.VS.addElement(null);
        asn1encodablevector.VS.addElement(null);
        return new DERSequence(asn1encodablevector);
    }
}
