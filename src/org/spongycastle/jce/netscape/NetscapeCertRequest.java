// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.netscape;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERSequence;

public class NetscapeCertRequest extends ASN1Object
{

    private ASN1Primitive _mth1EF5()
    {
        new ByteArrayOutputStream();
        try
        {
            throw new NullPointerException();
        }
        catch (IOException ioexception)
        {
            throw new InvalidKeySpecException(ioexception.getMessage());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = new ASN1EncodableVector();
        DERIA5String deria5string;
        try
        {
            ASN1Primitive asn1primitive = _mth1EF5();
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1primitive);
        }
        catch (Exception exception) { }
        deria5string = new DERIA5String(null);
        ((ASN1EncodableVector) (obj)).VS.addElement(deria5string);
        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        asn1encodablevector.VS.addElement(null);
        obj = new DERBitString(null);
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
