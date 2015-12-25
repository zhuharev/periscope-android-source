// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ocsp;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.ocsp:
//            OCSPResponseStatus, ResponseBytes

public class OCSPResponse extends ASN1Object
{

    private OCSPResponseStatus aao;
    private ResponseBytes aap;

    private OCSPResponse(ASN1Sequence asn1sequence)
    {
        aao = OCSPResponseStatus._mth037A(asn1sequence._mth144B(0));
        if (asn1sequence.size() == 2)
        {
            aap = ResponseBytes._mth1FBE((ASN1TaggedObject)asn1sequence._mth144B(1), true);
        }
    }

    public static OCSPResponse _mth02CF(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new OCSPResponse(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        OCSPResponseStatus ocspresponsestatus = aao;
        asn1encodablevector.VS.addElement(ocspresponsestatus);
        if (aap != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(true, 0, aap);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        return new DERSequence(asn1encodablevector);
    }
}
