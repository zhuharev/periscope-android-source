// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x509:
//            AlgorithmIdentifier, Time, SubjectPublicKeyInfo, Extensions

public class TBSCertificate extends ASN1Object
{

    private ASN1Sequence adC;
    public ASN1Integer ada;
    public AlgorithmIdentifier aid;
    public ASN1Integer aie;
    public Extensions aii;
    public X500Name ajE;
    public Time ajM;
    public Time ajN;
    public X500Name ajO;
    public SubjectPublicKeyInfo ajP;
    public DERBitString ajQ;
    public DERBitString ajR;

    private TBSCertificate(ASN1Sequence asn1sequence)
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
                aii = Extensions.FE7A(ASN1Sequence._mth141D(dertaggedobject, true));
                break;
            }
        }

    }

    public static TBSCertificate _mth02C7(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof TBSCertificate)
        {
            return (TBSCertificate)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new TBSCertificate(ASN1Sequence._mth141F(asn1encodable));
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
