// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers, ContentInfo, MacData

public class Pfx extends ASN1Object
    implements PKCSObjectIdentifiers
{

    public ContentInfo acW;
    public MacData acX;

    private Pfx(ASN1Sequence asn1sequence)
    {
        acX = null;
        if ((new BigInteger(((ASN1Integer)asn1sequence._mth144B(0)).bytes)).intValue() != 3)
        {
            throw new IllegalArgumentException("wrong version for PFX PDU");
        }
        acW = ContentInfo._mth1508(asn1sequence._mth144B(1));
        if (asn1sequence.size() == 3)
        {
            acX = MacData._mth02C9(asn1sequence._mth144B(2));
        }
    }

    public Pfx(ContentInfo contentinfo, MacData macdata)
    {
        acX = null;
        acW = contentinfo;
        acX = macdata;
    }

    public static Pfx _mth02CE(ASN1Sequence asn1sequence)
    {
        if (asn1sequence != null)
        {
            return new Pfx(ASN1Sequence._mth141F(asn1sequence));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = new ASN1Integer(3L);
        asn1encodablevector.VS.addElement(obj);
        obj = acW;
        asn1encodablevector.VS.addElement(obj);
        if (acX != null)
        {
            MacData macdata = acX;
            asn1encodablevector.VS.addElement(macdata);
        }
        return new BERSequence(asn1encodablevector);
    }
}
