// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            DistributionPoint

public class CRLDistPoint extends ASN1Object
{

    private ASN1Sequence adC;

    private CRLDistPoint(ASN1Sequence asn1sequence)
    {
        adC = null;
        adC = asn1sequence;
    }

    public static CRLDistPoint _mth02BE(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new CRLDistPoint(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("CRLDistPoint:");
        stringbuffer.append(s);
        DistributionPoint adistributionpoint[] = _mth09BD();
        for (int i = 0; i != adistributionpoint.length; i++)
        {
            stringbuffer.append("    ");
            stringbuffer.append(adistributionpoint[i]);
            stringbuffer.append(s);
        }

        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return adC;
    }

    public final DistributionPoint[] _mth09BD()
    {
        DistributionPoint adistributionpoint[] = new DistributionPoint[adC.size()];
        for (int i = 0; i != adC.size(); i++)
        {
            adistributionpoint[i] = DistributionPoint.FE76(adC._mth144B(i));
        }

        return adistributionpoint;
    }
}
