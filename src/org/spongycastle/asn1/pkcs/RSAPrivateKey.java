// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class RSAPrivateKey extends ASN1Object
{

    private BigInteger adh;
    public BigInteger adi;
    public BigInteger adj;
    public BigInteger adk;
    public BigInteger adl;
    public BigInteger adm;
    public BigInteger adn;
    public BigInteger ado;
    public BigInteger adp;
    private ASN1Sequence adq;

    public RSAPrivateKey(BigInteger biginteger, BigInteger biginteger1, BigInteger biginteger2, BigInteger biginteger3, BigInteger biginteger4, BigInteger biginteger5, BigInteger biginteger6, 
            BigInteger biginteger7)
    {
        adq = null;
        adh = BigInteger.valueOf(0L);
        adi = biginteger;
        adj = biginteger1;
        adk = biginteger2;
        adl = biginteger3;
        adm = biginteger4;
        adn = biginteger5;
        ado = biginteger6;
        adp = biginteger7;
    }

    private RSAPrivateKey(ASN1Sequence asn1sequence)
    {
        adq = null;
        asn1sequence = asn1sequence._mth0675();
        BigInteger biginteger = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        if (biginteger.intValue() != 0 && biginteger.intValue() != 1)
        {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        adh = biginteger;
        adi = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        adj = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        adk = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        adl = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        adm = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        adn = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        ado = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        adp = new BigInteger(((ASN1Integer)asn1sequence.nextElement()).bytes);
        if (asn1sequence.hasMoreElements())
        {
            adq = (ASN1Sequence)asn1sequence.nextElement();
        }
    }

    public static RSAPrivateKey _mth1D4B(Object obj)
    {
        if (obj instanceof RSAPrivateKey)
        {
            return (RSAPrivateKey)obj;
        }
        if (obj != null)
        {
            return new RSAPrivateKey(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        ASN1Integer asn1integer = new ASN1Integer(adh);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adi);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adj);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adk);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adl);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adm);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adn);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(ado);
        asn1encodablevector.VS.addElement(asn1integer);
        asn1integer = new ASN1Integer(adp);
        asn1encodablevector.VS.addElement(asn1integer);
        if (adq != null)
        {
            ASN1Sequence asn1sequence = adq;
            asn1encodablevector.VS.addElement(asn1sequence);
        }
        return new DERSequence(asn1encodablevector);
    }
}
