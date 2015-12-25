// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcElieceCCA2PublicKey
    implements CipherParameters, PublicKey
{

    String Xa;
    int aJP;
    GF2Matrix aMk;
    McElieceCCA2Parameters aOc;
    int axg;

    private BCMcElieceCCA2PublicKey(String s, int i, int j, GF2Matrix gf2matrix)
    {
        Xa = s;
        axg = i;
        aJP = j;
        aMk = gf2matrix;
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mceliececca2publickeyparameters)
    {
        this(mceliececca2publickeyparameters.Xa, mceliececca2publickeyparameters.axg, mceliececca2publickeyparameters.aJP, mceliececca2publickeyparameters.aLZ);
        aOc = ((McElieceCCA2KeyParameters) (mceliececca2publickeyparameters)).aLQ;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey))
        {
            return false;
        }
        obj = (BCMcElieceCCA2PublicKey)obj;
        return axg == ((BCMcElieceCCA2PublicKey) (obj)).axg && aJP == ((BCMcElieceCCA2PublicKey) (obj)).aJP && aMk.equals(((BCMcElieceCCA2PublicKey) (obj)).aMk);
    }

    public String getAlgorithm()
    {
        return "McEliece";
    }

    public byte[] getEncoded()
    {
        IOException ioexception;
        McElieceCCA2PublicKey mceliececca2publickey = new McElieceCCA2PublicKey(new ASN1ObjectIdentifier(Xa), axg, aJP, aMk);
        AlgorithmIdentifier algorithmidentifier = new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2"), DERNull.WL);
        byte abyte0[];
        try
        {
            abyte0 = (new SubjectPublicKeyInfo(algorithmidentifier, mceliececca2publickey)).getEncoded();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
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
        return axg + aJP + aMk.hashCode();
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("McEliecePublicKey:\n").append(" length of the code         : ").append(axg).append("\n").toString();
        s = (new StringBuilder()).append(s).append(" error correction capability: ").append(aJP).append("\n").toString();
        return (new StringBuilder()).append(s).append(" generator matrix           : ").append(aMk.toString()).toString();
    }
}
