// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X962NamedCurves, X9ECParameters

public class ECNamedCurveTable
{

    public ECNamedCurveTable()
    {
    }

    public static X9ECParameters _mth141D(ASN1ObjectIdentifier asn1objectidentifier)
    {
        X9ECParameters x9ecparameters1 = X962NamedCurves._mth141D(asn1objectidentifier);
        X9ECParameters x9ecparameters = x9ecparameters1;
        if (x9ecparameters1 == null)
        {
            x9ecparameters = SECNamedCurves._mth141D(asn1objectidentifier);
        }
        x9ecparameters1 = x9ecparameters;
        if (x9ecparameters == null)
        {
            x9ecparameters1 = TeleTrusTNamedCurves._mth141D(asn1objectidentifier);
        }
        return x9ecparameters1;
    }

    public static X9ECParameters _mth14BB(String s)
    {
        X9ECParameters x9ecparameters1 = X962NamedCurves._mth14BB(s);
        X9ECParameters x9ecparameters = x9ecparameters1;
        if (x9ecparameters1 == null)
        {
            x9ecparameters = SECNamedCurves._mth14BB(s);
        }
        x9ecparameters1 = x9ecparameters;
        if (x9ecparameters == null)
        {
            x9ecparameters1 = TeleTrusTNamedCurves._mth14BB(s);
        }
        x9ecparameters = x9ecparameters1;
        if (x9ecparameters1 == null)
        {
            x9ecparameters = NISTNamedCurves._mth14BB(s);
        }
        return x9ecparameters;
    }
}
