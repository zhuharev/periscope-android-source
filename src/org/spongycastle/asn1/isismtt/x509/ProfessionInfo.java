// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.isismtt.x509;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.isismtt.x509:
//            NamingAuthority

public class ProfessionInfo extends ASN1Object
{

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        asn1encodablevector.VS.addElement(null);
        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".1").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".2").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".3").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".4").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".5").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".6").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".7").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".8").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".9").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".10").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".11").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".12").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".13").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".14").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".15").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".16").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".17").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".18").toString());
        new ASN1ObjectIdentifier((new StringBuilder()).append(NamingAuthority.Zp).append(".19").toString());
    }
}
