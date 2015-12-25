// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            TBSCertList, AlgorithmIdentifier

public class CertificateList extends ASN1Object
{

    public AlgorithmIdentifier aaE;
    private int agg;
    public DERBitString ais;
    public TBSCertList ait;
    private boolean aiu;

    private CertificateList(ASN1Sequence asn1sequence)
    {
        aiu = false;
        if (asn1sequence.size() == 3)
        {
            ait = TBSCertList._mth02C6(asn1sequence._mth144B(0));
            aaE = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(1));
            ais = DERBitString._mth14BD(asn1sequence._mth144B(2));
            return;
        } else
        {
            throw new IllegalArgumentException("sequence wrong size for CertificateList");
        }
    }

    public static CertificateList _mth1D54(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof CertificateList)
        {
            return (CertificateList)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new CertificateList(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        if (!aiu)
        {
            agg = super.hashCode();
            aiu = true;
        }
        return agg;
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = ait;
        asn1encodablevector.VS.addElement(obj);
        obj = aaE;
        asn1encodablevector.VS.addElement(obj);
        obj = ais;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }

    public final Enumeration _mth0E01()
    {
        TBSCertList tbscertlist = ait;
        if (tbscertlist.ajH == null)
        {
            return new TBSCertList.EmptyEnumeration(tbscertlist, (byte)0);
        } else
        {
            return new TBSCertList.RevokedCertificatesEnumeration(tbscertlist, tbscertlist.ajH._mth0675());
        }
    }

    public final int _mth10D9()
    {
        TBSCertList tbscertlist = ait;
        if (tbscertlist.ada == null)
        {
            return 1;
        } else
        {
            return (new BigInteger(tbscertlist.ada.bytes)).intValue() + 1;
        }
    }
}
