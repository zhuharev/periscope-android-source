// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            PolicyInformation

public class CertificatePolicies extends ASN1Object
{

    private final PolicyInformation aix[];

    public String toString()
    {
        String s = null;
        for (int i = 0; i < aix.length; i++)
        {
            String s1 = s;
            if (s != null)
            {
                s1 = (new StringBuilder()).append(s).append(", ").toString();
            }
            s = (new StringBuilder()).append(s1).append(aix[i]).toString();
        }

        return (new StringBuilder("CertificatePolicies: ")).append(s).toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return new DERSequence(aix);
    }
}
