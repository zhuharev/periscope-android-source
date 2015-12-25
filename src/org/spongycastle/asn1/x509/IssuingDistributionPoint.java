// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            DistributionPointName, ReasonFlags

public class IssuingDistributionPoint extends ASN1Object
{

    private ASN1Sequence adC;
    public DistributionPointName aiz;
    public boolean ajm;
    public boolean ajn;
    public ReasonFlags ajo;
    public boolean ajp;
    public boolean ajq;

    private IssuingDistributionPoint(ASN1Sequence asn1sequence)
    {
        adC = asn1sequence;
        for (int i = 0; i != asn1sequence.size(); i++)
        {
            ASN1TaggedObject asn1taggedobject = ASN1TaggedObject._mth142A(asn1sequence._mth144B(i));
            switch (asn1taggedobject.Wk)
            {
            case 0: // '\0'
                aiz = DistributionPointName._mth02CB(asn1taggedobject);
                break;

            case 1: // '\001'
                boolean flag;
                if (ASN1Boolean._mth02CA(asn1taggedobject, false).VP[0] != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ajm = flag;
                break;

            case 2: // '\002'
                boolean flag1;
                if (ASN1Boolean._mth02CA(asn1taggedobject, false).VP[0] != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ajn = flag1;
                break;

            case 3: // '\003'
                ajo = new ReasonFlags(ReasonFlags._mth02BD(asn1taggedobject, false));
                break;

            case 4: // '\004'
                boolean flag2;
                if (ASN1Boolean._mth02CA(asn1taggedobject, false).VP[0] != 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                ajp = flag2;
                break;

            case 5: // '\005'
                boolean flag3;
                if (ASN1Boolean._mth02CA(asn1taggedobject, false).VP[0] != 0)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                ajq = flag3;
                break;

            default:
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }

    }

    private static void _mth02CA(StringBuffer stringbuffer, String s, String s1, String s2)
    {
        stringbuffer.append("    ");
        stringbuffer.append(s1);
        stringbuffer.append(":");
        stringbuffer.append(s);
        stringbuffer.append("    ");
        stringbuffer.append("    ");
        stringbuffer.append(s2);
        stringbuffer.append(s);
    }

    public static IssuingDistributionPoint _mth06E6(Object obj)
    {
        if (obj instanceof IssuingDistributionPoint)
        {
            return (IssuingDistributionPoint)obj;
        }
        if (obj != null)
        {
            return new IssuingDistributionPoint(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        String s4 = System.getProperty("line.separator");
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("IssuingDistributionPoint: [");
        stringbuffer.append(s4);
        if (aiz != null)
        {
            _mth02CA(stringbuffer, s4, "distributionPoint", aiz.toString());
        }
        if (ajm)
        {
            String s;
            if (ajm)
            {
                s = "true";
            } else
            {
                s = "false";
            }
            _mth02CA(stringbuffer, s4, "onlyContainsUserCerts", s);
        }
        if (ajn)
        {
            String s1;
            if (ajn)
            {
                s1 = "true";
            } else
            {
                s1 = "false";
            }
            _mth02CA(stringbuffer, s4, "onlyContainsCACerts", s1);
        }
        if (ajo != null)
        {
            _mth02CA(stringbuffer, s4, "onlySomeReasons", ajo.toString());
        }
        if (ajq)
        {
            String s2;
            if (ajq)
            {
                s2 = "true";
            } else
            {
                s2 = "false";
            }
            _mth02CA(stringbuffer, s4, "onlyContainsAttributeCerts", s2);
        }
        if (ajp)
        {
            String s3;
            if (ajp)
            {
                s3 = "true";
            } else
            {
                s3 = "false";
            }
            _mth02CA(stringbuffer, s4, "indirectCRL", s3);
        }
        stringbuffer.append("]");
        stringbuffer.append(s4);
        return stringbuffer.toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return adC;
    }
}
