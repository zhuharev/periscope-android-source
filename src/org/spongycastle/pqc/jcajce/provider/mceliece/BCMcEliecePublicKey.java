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
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcEliecePublicKey
    implements CipherParameters, PublicKey
{

    String Xa;
    int aJP;
    GF2Matrix aMk;
    McElieceParameters aOe;
    int axg;

    private BCMcEliecePublicKey(String s, int i, int j, GF2Matrix gf2matrix)
    {
        Xa = s;
        axg = i;
        aJP = j;
        aMk = gf2matrix;
    }

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mceliecepublickeyparameters)
    {
        this(mceliecepublickeyparameters.Xa, mceliecepublickeyparameters.axg, mceliecepublickeyparameters.aJP, mceliecepublickeyparameters.aMk);
        aOe = ((McElieceKeyParameters) (mceliecepublickeyparameters)).aMb;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof BCMcEliecePublicKey))
        {
            return false;
        }
        obj = (BCMcEliecePublicKey)obj;
        return axg == ((BCMcEliecePublicKey) (obj)).axg && aJP == ((BCMcEliecePublicKey) (obj)).aJP && aMk.equals(((BCMcEliecePublicKey) (obj)).aMk);
    }

    public String getAlgorithm()
    {
        return "McEliece";
    }

    public byte[] getEncoded()
    {
        IOException ioexception;
        McEliecePublicKey mceliecepublickey = new McEliecePublicKey(new ASN1ObjectIdentifier(Xa), axg, aJP, aMk);
        AlgorithmIdentifier algorithmidentifier = new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1"), DERNull.WL);
        byte abyte0[];
        try
        {
            abyte0 = (new SubjectPublicKeyInfo(algorithmidentifier, mceliecepublickey)).getEncoded();
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
