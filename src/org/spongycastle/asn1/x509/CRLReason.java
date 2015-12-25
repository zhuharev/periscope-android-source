// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.util.Integers;

public class CRLReason extends ASN1Object
{

    private static final String aip[] = {
        "unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", 
        "aACompromise"
    };
    private static final Hashtable aiq = new Hashtable();
    private ASN1Enumerated YC;

    private CRLReason(int i)
    {
        YC = new ASN1Enumerated(i);
    }

    public static CRLReason _mth02CA(ASN1Enumerated asn1enumerated)
    {
        if (asn1enumerated != null)
        {
            return _mth14EB((new BigInteger(ASN1Enumerated._mth1D63(asn1enumerated).bytes)).intValue());
        } else
        {
            return null;
        }
    }

    public static CRLReason _mth14EB(int i)
    {
        Integer integer = Integers.valueOf(i);
        if (!aiq.containsKey(integer))
        {
            aiq.put(integer, new CRLReason(i));
        }
        return (CRLReason)aiq.get(integer);
    }

    public String toString()
    {
        int i = (new BigInteger(YC.bytes)).intValue();
        String s;
        if (i < 0 || i > 10)
        {
            s = "invalid";
        } else
        {
            s = aip[i];
        }
        return (new StringBuilder("CRLReason: ")).append(s).toString();
    }

    public final ASN1Primitive _mth0427()
    {
        return YC;
    }

}
