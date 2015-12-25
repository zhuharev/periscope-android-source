// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x509:
//            X509ObjectIdentifiers, AlgorithmIdentifier, Time, SubjectPublicKeyInfo, 
//            X509Extensions

public class TBSCertificateStructure extends ASN1Object
    implements X509ObjectIdentifiers, PKCSObjectIdentifiers
{

    private ASN1Sequence adC;
    private ASN1Integer ada;
    private AlgorithmIdentifier aid;
    private ASN1Integer aie;
    public X500Name ajE;
    private Time ajM;
    private Time ajN;
    public X500Name ajO;
    private SubjectPublicKeyInfo ajP;
    private DERBitString ajQ;
    private DERBitString ajR;
    private X509Extensions ajS;

    private TBSCertificateStructure(ASN1Sequence asn1sequence)
    {
        byte byte0 = 0;
        adC = asn1sequence;
        if (asn1sequence._mth144B(0) instanceof DERTaggedObject)
        {
            ada = ASN1Integer._mth02CB((ASN1TaggedObject)asn1sequence._mth144B(0), true);
        } else
        {
            byte0 = -1;
            ada = new ASN1Integer(0L);
        }
        aie = ASN1Integer.FB1D(asn1sequence._mth144B(byte0 + 1));
        aid = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(byte0 + 2));
        ajE = X500Name._mth0131(asn1sequence._mth144B(byte0 + 3));
        ASN1Sequence asn1sequence1 = (ASN1Sequence)asn1sequence._mth144B(byte0 + 4);
        ajM = Time._mth02E1(asn1sequence1._mth144B(0));
        ajN = Time._mth02E1(asn1sequence1._mth144B(1));
        ajO = X500Name._mth0131(asn1sequence._mth144B(byte0 + 5));
        ajP = SubjectPublicKeyInfo._mth13A5(asn1sequence._mth144B(byte0 + 6));
        for (int i = asn1sequence.size() - (byte0 + 6) - 1; i > 0; i--)
        {
            DERTaggedObject dertaggedobject = (DERTaggedObject)asn1sequence._mth144B(byte0 + 6 + i);
            switch (((ASN1TaggedObject) (dertaggedobject)).Wk)
            {
            case 1: // '\001'
                ajQ = DERBitString._mth02BD(dertaggedobject, false);
                break;

            case 2: // '\002'
                ajR = DERBitString._mth02BD(dertaggedobject, false);
                break;

            case 3: // '\003'
                ajS = X509Extensions._mth02CC(dertaggedobject);
                break;
            }
        }

    }

    public static TBSCertificateStructure _mth02C8(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new TBSCertificateStructure(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return adC;
    }
}
