// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcElieceCCA2PrivateKey
    implements CipherParameters, PrivateKey
{

    String Xa;
    GF2mField aLU;
    PolynomialGF2mSmallM aLV;
    Permutation aLW;
    GF2Matrix aLX;
    PolynomialGF2mSmallM aLY[];
    McElieceCCA2Parameters aOb;
    int afK;
    int axg;

    private BCMcElieceCCA2PrivateKey(String s, int i, int j, GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm, Permutation permutation, GF2Matrix gf2matrix, 
            PolynomialGF2mSmallM apolynomialgf2msmallm[])
    {
        Xa = s;
        axg = i;
        afK = j;
        aLU = gf2mfield;
        aLV = polynomialgf2msmallm;
        aLW = permutation;
        aLX = gf2matrix;
        aLY = apolynomialgf2msmallm;
    }

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mceliececca2privatekeyparameters)
    {
        this(mceliececca2privatekeyparameters.Xa, mceliececca2privatekeyparameters.axg, mceliececca2privatekeyparameters.afK, mceliececca2privatekeyparameters.aLU, mceliececca2privatekeyparameters.aLV, mceliececca2privatekeyparameters.aLW, mceliececca2privatekeyparameters.aLX, mceliececca2privatekeyparameters.aLY);
        aOb = ((McElieceCCA2KeyParameters) (mceliececca2privatekeyparameters)).aLQ;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PrivateKey))
        {
            return false;
        }
        obj = (BCMcElieceCCA2PrivateKey)obj;
        return axg == ((BCMcElieceCCA2PrivateKey) (obj)).axg && afK == ((BCMcElieceCCA2PrivateKey) (obj)).afK && aLU.equals(((BCMcElieceCCA2PrivateKey) (obj)).aLU) && aLV.equals(((BCMcElieceCCA2PrivateKey) (obj)).aLV) && aLW.equals(((BCMcElieceCCA2PrivateKey) (obj)).aLW) && aLX.equals(((BCMcElieceCCA2PrivateKey) (obj)).aLX);
    }

    public String getAlgorithm()
    {
        return "McEliece";
    }

    public byte[] getEncoded()
    {
        Object obj = new McElieceCCA2PrivateKey(new ASN1ObjectIdentifier(Xa), axg, afK, aLU, aLV, aLW, aLX, aLY);
        try
        {
            obj = new PrivateKeyInfo(new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2"), DERNull.WL), ((org.spongycastle.asn1.ASN1Object) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = ((PrivateKeyInfo) (obj)).getEncoded();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public String getFormat()
    {
        return null;
    }

    public int hashCode()
    {
        return afK + axg + aLU.hashCode() + aLV.hashCode() + aLW.hashCode() + aLX.hashCode();
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("").append(" extension degree of the field      : ").append(axg).append("\n").toString();
        s = (new StringBuilder()).append(s).append(" dimension of the code              : ").append(afK).append("\n").toString();
        return (new StringBuilder()).append(s).append(" irreducible Goppa polynomial       : ").append(aLV).append("\n").toString();
    }
}
