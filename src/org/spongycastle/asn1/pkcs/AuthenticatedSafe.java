// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DLSequence;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            ContentInfo

public class AuthenticatedSafe extends ASN1Object
{

    private boolean aaA;
    public ContentInfo aaz[];

    private AuthenticatedSafe(ASN1Sequence asn1sequence)
    {
        aaA = true;
        aaz = new ContentInfo[asn1sequence.size()];
        for (int i = 0; i != aaz.length; i++)
        {
            aaz[i] = ContentInfo._mth1508(asn1sequence._mth144B(i));
        }

        aaA = asn1sequence instanceof BERSequence;
    }

    public AuthenticatedSafe(ContentInfo acontentinfo[])
    {
        aaA = true;
        aaz = acontentinfo;
    }

    public static AuthenticatedSafe _mth141D(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new AuthenticatedSafe(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        for (int i = 0; i != aaz.length; i++)
        {
            ContentInfo contentinfo = aaz[i];
            asn1encodablevector.VS.addElement(contentinfo);
        }

        if (aaA)
        {
            return new BERSequence(asn1encodablevector);
        } else
        {
            return new DLSequence(asn1encodablevector);
        }
    }
}
