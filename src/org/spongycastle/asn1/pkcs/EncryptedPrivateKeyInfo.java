// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo extends ASN1Object
{

    public AlgorithmIdentifier aaK;
    public ASN1OctetString aaL;

    private EncryptedPrivateKeyInfo(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        aaK = AlgorithmIdentifier._mth01C3(asn1sequence.nextElement());
        aaL = ASN1OctetString.FB39(asn1sequence.nextElement());
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier algorithmidentifier, byte abyte0[])
    {
        aaK = algorithmidentifier;
        aaL = new DEROctetString(abyte0);
    }

    public static EncryptedPrivateKeyInfo _mth02C8(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof EncryptedPrivateKeyInfo)
        {
            return (EncryptedPrivateKeyInfo)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new EncryptedPrivateKeyInfo(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaK;
        asn1encodablevector.VS.addElement(obj);
        obj = aaL;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
