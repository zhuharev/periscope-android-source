// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.nist;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.sec.SECObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.util.Strings;

public class NISTNamedCurves
{

    private static Hashtable Yi;
    private static Hashtable Yj;

    public NISTNamedCurves()
    {
    }

    public static String _mth02CE(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return (String)Yj.get(asn1objectidentifier);
    }

    public static X9ECParameters _mth141D(ASN1ObjectIdentifier asn1objectidentifier)
    {
        return SECNamedCurves._mth141D(asn1objectidentifier);
    }

    public static ASN1ObjectIdentifier _mth1422(String s)
    {
        return (ASN1ObjectIdentifier)Yi.get(Strings.FE7C(s));
    }

    public static X9ECParameters _mth14BB(String s)
    {
        s = (ASN1ObjectIdentifier)Yi.get(Strings.FE7C(s));
        if (s != null)
        {
            return SECNamedCurves._mth141D(s);
        } else
        {
            return null;
        }
    }

    static 
    {
        Yi = new Hashtable();
        Yj = new Hashtable();
        ASN1ObjectIdentifier asn1objectidentifier = SECObjectIdentifiers.aeQ;
        Yi.put("B-571", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "B-571");
        asn1objectidentifier = SECObjectIdentifiers.aeO;
        Yi.put("B-409", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "B-409");
        asn1objectidentifier = SECObjectIdentifiers.aey;
        Yi.put("B-283", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "B-283");
        asn1objectidentifier = SECObjectIdentifiers.aeE;
        Yi.put("B-233", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "B-233");
        asn1objectidentifier = SECObjectIdentifiers.aew;
        Yi.put("B-163", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "B-163");
        asn1objectidentifier = SECObjectIdentifiers.aeP;
        Yi.put("K-571", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "K-571");
        asn1objectidentifier = SECObjectIdentifiers.aeN;
        Yi.put("K-409", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "K-409");
        asn1objectidentifier = SECObjectIdentifiers.aex;
        Yi.put("K-283", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "K-283");
        asn1objectidentifier = SECObjectIdentifiers.aeD;
        Yi.put("K-233", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "K-233");
        asn1objectidentifier = SECObjectIdentifiers.aem;
        Yi.put("K-163", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "K-163");
        asn1objectidentifier = SECObjectIdentifiers.aeM;
        Yi.put("P-521", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "P-521");
        asn1objectidentifier = SECObjectIdentifiers.aeL;
        Yi.put("P-384", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "P-384");
        asn1objectidentifier = SECObjectIdentifiers.aeS;
        Yi.put("P-256", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "P-256");
        asn1objectidentifier = SECObjectIdentifiers.aeK;
        Yi.put("P-224", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "P-224");
        asn1objectidentifier = SECObjectIdentifiers.aeR;
        Yi.put("P-192", asn1objectidentifier);
        Yj.put(asn1objectidentifier, "P-192");
    }
}
