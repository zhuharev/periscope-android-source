// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.cms;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.cms:
//            ContentInfo

public class SCVPReqRes extends ASN1Object
{

    private final ContentInfo XF;
    private final ContentInfo XG;

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (XF != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(true, 0, XF);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        ContentInfo contentinfo = XG;
        asn1encodablevector.VS.addElement(contentinfo);
        return new DERSequence(asn1encodablevector);
    }
}
