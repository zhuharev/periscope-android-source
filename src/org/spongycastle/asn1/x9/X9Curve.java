// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ObjectIdentifiers, X9FieldID, X9FieldElement

public class X9Curve extends ASN1Object
    implements X9ObjectIdentifiers
{

    ECCurve alm;
    byte aln[];
    private ASN1ObjectIdentifier alo;

    public X9Curve(X9FieldID x9fieldid, ASN1Sequence asn1sequence)
    {
        alo = null;
        alo = x9fieldid.ajs;
        if (alo.equals(alA))
        {
            x9fieldid = new BigInteger(((ASN1Integer)x9fieldid.alx).bytes);
            X9FieldElement x9fieldelement = new X9FieldElement(x9fieldid, (ASN1OctetString)asn1sequence._mth144B(0));
            X9FieldElement x9fieldelement1 = new X9FieldElement(x9fieldid, (ASN1OctetString)asn1sequence._mth144B(1));
            alm = new org.spongycastle.math.ec.ECCurve.Fp(x9fieldid, x9fieldelement._mth1439().toBigInteger(), x9fieldelement1._mth1439().toBigInteger());
        } else
        if (alo.equals(alB))
        {
            x9fieldid = ASN1Sequence._mth141F(x9fieldid.alx);
            int l = (new BigInteger(((ASN1Integer)x9fieldid._mth144B(0)).bytes)).intValue();
            Object obj = (ASN1ObjectIdentifier)x9fieldid._mth144B(1);
            int i = 0;
            int j = 0;
            int k;
            if (((ASN1ObjectIdentifier) (obj)).equals(alC))
            {
                k = (new BigInteger(ASN1Integer.FB1D(x9fieldid._mth144B(2)).bytes)).intValue();
            } else
            if (((ASN1ObjectIdentifier) (obj)).equals(alD))
            {
                x9fieldid = ASN1Sequence._mth141F(x9fieldid._mth144B(2));
                k = (new BigInteger(ASN1Integer.FB1D(x9fieldid._mth144B(0)).bytes)).intValue();
                i = (new BigInteger(ASN1Integer.FB1D(x9fieldid._mth144B(1)).bytes)).intValue();
                j = (new BigInteger(ASN1Integer.FB1D(x9fieldid._mth144B(2)).bytes)).intValue();
            } else
            {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            x9fieldid = new X9FieldElement(l, k, i, j, (ASN1OctetString)asn1sequence._mth144B(0));
            obj = new X9FieldElement(l, k, i, j, (ASN1OctetString)asn1sequence._mth144B(1));
            alm = new org.spongycastle.math.ec.ECCurve.F2m(l, k, i, j, x9fieldid._mth1439().toBigInteger(), ((X9FieldElement) (obj))._mth1439().toBigInteger());
        } else
        {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        if (asn1sequence.size() == 3)
        {
            aln = ((DERBitString)asn1sequence._mth144B(2)).getBytes();
        }
    }

    public X9Curve(ECCurve eccurve, byte abyte0[])
    {
        alo = null;
        alm = eccurve;
        aln = abyte0;
        if (ECAlgorithms._mth141D(alm))
        {
            alo = alA;
            return;
        }
        if (ECAlgorithms._mth02CF(alm))
        {
            alo = alB;
            return;
        } else
        {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (alo.equals(alA))
        {
            ASN1Primitive asn1primitive = (new X9FieldElement(alm.FB46()))._mth0427();
            asn1encodablevector.VS.addElement(asn1primitive);
            asn1primitive = (new X9FieldElement(alm.FB4C()))._mth0427();
            asn1encodablevector.VS.addElement(asn1primitive);
        } else
        if (alo.equals(alB))
        {
            ASN1Primitive asn1primitive1 = (new X9FieldElement(alm.FB46()))._mth0427();
            asn1encodablevector.VS.addElement(asn1primitive1);
            asn1primitive1 = (new X9FieldElement(alm.FB4C()))._mth0427();
            asn1encodablevector.VS.addElement(asn1primitive1);
        }
        if (aln != null)
        {
            DERBitString derbitstring = new DERBitString(aln);
            asn1encodablevector.VS.addElement(derbitstring);
        }
        return new DERSequence(asn1encodablevector);
    }
}
