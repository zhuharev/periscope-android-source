// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.eac;

import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.asn1.eac:
//            EACObjectIdentifiers, BidirectionalMap

public class CertificateHolderAuthorization extends ASN1Object
{

    private static Hashtable YG;
    private static BidirectionalMap YH;

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.VS.addElement(null);
        asn1encodablevector.VS.addElement(null);
        return new DERApplicationSpecific(76, asn1encodablevector);
    }

    static 
    {
        new ASN1ObjectIdentifier(EACObjectIdentifiers.Xo, "3.1.2.1");
        YG = new Hashtable();
        YH = new BidirectionalMap();
        new Hashtable();
        YG.put(Integers.valueOf(2), "RADG4");
        YG.put(Integers.valueOf(1), "RADG3");
        YH.put(Integers.valueOf(192), "CVCA");
        YH.put(Integers.valueOf(128), "DV_DOMESTIC");
        YH.put(Integers.valueOf(64), "DV_FOREIGN");
        YH.put(Integers.valueOf(0), "IS");
    }
}
