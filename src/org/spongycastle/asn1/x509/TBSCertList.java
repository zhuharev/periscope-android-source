// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x509:
//            AlgorithmIdentifier, Time, Extensions

public class TBSCertList extends ASN1Object
{
    public static class CRLEntry extends ASN1Object
    {

        public ASN1Sequence adC;
        private Extensions ajJ;

        public static CRLEntry _mth1424(Object obj)
        {
            if (obj instanceof CRLEntry)
            {
                return (CRLEntry)obj;
            }
            if (obj != null)
            {
                return new CRLEntry(ASN1Sequence._mth141F(obj));
            } else
            {
                return null;
            }
        }

        public final ASN1Primitive _mth0427()
        {
            return adC;
        }

        public final Extensions _mth142F()
        {
            if (ajJ == null && adC.size() == 3)
            {
                ajJ = Extensions.FE7A(adC._mth144B(2));
            }
            return ajJ;
        }

        private CRLEntry(ASN1Sequence asn1sequence)
        {
            if (asn1sequence.size() < 2 || asn1sequence.size() > 3)
            {
                throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
            } else
            {
                adC = asn1sequence;
                return;
            }
        }
    }

    class EmptyEnumeration
        implements Enumeration
    {

        private TBSCertList ajK;

        public boolean hasMoreElements()
        {
            return false;
        }

        public Object nextElement()
        {
            return null;
        }

        private EmptyEnumeration()
        {
            ajK = TBSCertList.this;
            super();
        }

        EmptyEnumeration(byte byte0)
        {
            this();
        }
    }

    class RevokedCertificatesEnumeration
        implements Enumeration
    {

        private TBSCertList ajK;
        private final Enumeration ajL;

        public boolean hasMoreElements()
        {
            return ajL.hasMoreElements();
        }

        public Object nextElement()
        {
            return CRLEntry._mth1424(ajL.nextElement());
        }

        RevokedCertificatesEnumeration(Enumeration enumeration)
        {
            ajK = TBSCertList.this;
            super();
            ajL = enumeration;
        }
    }


    ASN1Integer ada;
    public AlgorithmIdentifier aid;
    public X500Name ajE;
    public Time ajF;
    public Time ajG;
    ASN1Sequence ajH;
    public Extensions ajI;

    private TBSCertList(ASN1Sequence asn1sequence)
    {
        int i;
label0:
        {
            super();
            if (asn1sequence.size() < 3 || asn1sequence.size() > 7)
            {
                throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
            }
            i = 0;
            if (asn1sequence._mth144B(0) instanceof ASN1Integer)
            {
                i = 0 + 1;
                ada = ASN1Integer.FB1D(asn1sequence._mth144B(0));
            } else
            {
                ada = null;
            }
            int j = i + 1;
            aid = AlgorithmIdentifier._mth01C3(asn1sequence._mth144B(i));
            i = j + 1;
            ajE = X500Name._mth0131(asn1sequence._mth144B(j));
            j = i + 1;
            ajF = Time._mth02E1(asn1sequence._mth144B(i));
            i = j;
            if (j >= asn1sequence.size())
            {
                break label0;
            }
            if (!(asn1sequence._mth144B(j) instanceof ASN1UTCTime) && !(asn1sequence._mth144B(j) instanceof ASN1GeneralizedTime))
            {
                i = j;
                if (!(asn1sequence._mth144B(j) instanceof Time))
                {
                    break label0;
                }
            }
            i = j + 1;
            ajG = Time._mth02E1(asn1sequence._mth144B(j));
        }
        int k = i;
        if (i < asn1sequence.size())
        {
            k = i;
            if (!(asn1sequence._mth144B(i) instanceof DERTaggedObject))
            {
                k = i + 1;
                ajH = ASN1Sequence._mth141F(asn1sequence._mth144B(i));
            }
        }
        if (k < asn1sequence.size() && (asn1sequence._mth144B(k) instanceof DERTaggedObject))
        {
            ajI = Extensions.FE7A(ASN1Sequence._mth141D((ASN1TaggedObject)asn1sequence._mth144B(k), true));
        }
    }

    public static TBSCertList _mth02C6(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof TBSCertList)
        {
            return (TBSCertList)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new TBSCertList(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (ada != null)
        {
            ASN1Integer asn1integer = ada;
            asn1encodablevector.VS.addElement(asn1integer);
        }
        Object obj = aid;
        asn1encodablevector.VS.addElement(obj);
        obj = ajE;
        asn1encodablevector.VS.addElement(obj);
        obj = ajF;
        asn1encodablevector.VS.addElement(obj);
        if (ajG != null)
        {
            Time time = ajG;
            asn1encodablevector.VS.addElement(time);
        }
        if (ajH != null)
        {
            ASN1Sequence asn1sequence = ajH;
            asn1encodablevector.VS.addElement(asn1sequence);
        }
        if (ajI != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(0, ajI);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        return new DERSequence(asn1encodablevector);
    }
}
