// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.eac;

import java.io.IOException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DEROctetString;

public class CVCertificate extends ASN1Object
{

    private static int YE = 1;
    private static int YF = 2;

    public final ASN1Primitive _mth0427()
    {
        IOException ioexception;
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if ((YF | YE) != 0)
        {
            return null;
        }
        asn1encodablevector.VS.addElement(null);
        try
        {
            DERApplicationSpecific derapplicationspecific = new DERApplicationSpecific(false, 55, new DEROctetString(null));
            asn1encodablevector.VS.addElement(derapplicationspecific);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new IllegalStateException("unable to convert signature!");
        }
        return new DERApplicationSpecific(33, asn1encodablevector);
    }

}
