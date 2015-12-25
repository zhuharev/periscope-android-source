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
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcEliecePrivateKey
    implements CipherParameters, PrivateKey
{

    String Xa;
    GF2mField aLU;
    PolynomialGF2mSmallM aLV;
    GF2Matrix aLX;
    PolynomialGF2mSmallM aLY[];
    GF2Matrix aMh;
    Permutation aMi;
    Permutation aMj;
    McElieceParameters aOd;
    int afK;
    int axg;

    private BCMcEliecePrivateKey(String s, int i, int j, GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm, GF2Matrix gf2matrix, Permutation permutation, 
            Permutation permutation1, GF2Matrix gf2matrix1, PolynomialGF2mSmallM apolynomialgf2msmallm[])
    {
        Xa = s;
        axg = i;
        afK = j;
        aLU = gf2mfield;
        aLV = polynomialgf2msmallm;
        aMh = gf2matrix;
        aMi = permutation;
        aMj = permutation1;
        aLX = gf2matrix1;
        aLY = apolynomialgf2msmallm;
    }

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcelieceprivatekeyparameters)
    {
        this(mcelieceprivatekeyparameters.Xa, mcelieceprivatekeyparameters.axg, mcelieceprivatekeyparameters.afK, mcelieceprivatekeyparameters.aLU, mcelieceprivatekeyparameters.aLV, mcelieceprivatekeyparameters.aMh, mcelieceprivatekeyparameters.aMi, mcelieceprivatekeyparameters.aMj, mcelieceprivatekeyparameters.aLX, mcelieceprivatekeyparameters.aLY);
        aOd = ((McElieceKeyParameters) (mcelieceprivatekeyparameters)).aMb;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof BCMcEliecePrivateKey))
        {
            return false;
        }
        obj = (BCMcEliecePrivateKey)obj;
        return axg == ((BCMcEliecePrivateKey) (obj)).axg && afK == ((BCMcEliecePrivateKey) (obj)).afK && aLU.equals(((BCMcEliecePrivateKey) (obj)).aLU) && aLV.equals(((BCMcEliecePrivateKey) (obj)).aLV) && aMh.equals(((BCMcEliecePrivateKey) (obj)).aMh) && aMi.equals(((BCMcEliecePrivateKey) (obj)).aMi) && aMj.equals(((BCMcEliecePrivateKey) (obj)).aMj) && aLX.equals(((BCMcEliecePrivateKey) (obj)).aLX);
    }

    public String getAlgorithm()
    {
        return "McEliece";
    }

    public byte[] getEncoded()
    {
        Object obj = new McEliecePrivateKey(new ASN1ObjectIdentifier(Xa), axg, afK, aLU, aLV, aMh, aMi, aMj, aLX, aLY);
        try
        {
            obj = new PrivateKeyInfo(new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1"), DERNull.WL), ((org.spongycastle.asn1.ASN1Object) (obj)));
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
        return afK + axg + aLU.hashCode() + aLV.hashCode() + aMh.hashCode() + aMi.hashCode() + aMj.hashCode() + aLX.hashCode();
    }

    public String toString()
    {
        String s = (new StringBuilder(" length of the code          : ")).append(axg).append("\n").toString();
        s = (new StringBuilder()).append(s).append(" dimension of the code       : ").append(afK).append("\n").toString();
        s = (new StringBuilder()).append(s).append(" irreducible Goppa polynomial: ").append(aLV).append("\n").toString();
        s = (new StringBuilder()).append(s).append(" (k x k)-matrix S^-1         : ").append(aMh).append("\n").toString();
        s = (new StringBuilder()).append(s).append(" permutation P1              : ").append(aMi).append("\n").toString();
        return (new StringBuilder()).append(s).append(" permutation P2              : ").append(aMj).toString();
    }
}
