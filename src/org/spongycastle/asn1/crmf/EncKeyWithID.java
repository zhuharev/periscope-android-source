// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.crmf;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;

public class EncKeyWithID extends ASN1Object
{

    private final PrivateKeyInfo XK;
    private final ASN1Encodable XL;

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        PrivateKeyInfo privatekeyinfo = XK;
        asn1encodablevector.VS.addElement(privatekeyinfo);
        if (XL != null)
        {
            ASN1Encodable asn1encodable = XL;
            asn1encodablevector.VS.addElement(asn1encodable);
        }
        return new DERSequence(asn1encodablevector);
    }
}
