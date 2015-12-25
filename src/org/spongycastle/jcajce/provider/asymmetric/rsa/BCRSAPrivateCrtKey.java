// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.rsa:
//            BCRSAPrivateKey

public class BCRSAPrivateCrtKey extends BCRSAPrivateKey
    implements RSAPrivateCrtKey
{

    private BigInteger aDQ;
    private BigInteger aDR;
    private BigInteger aDS;
    private BigInteger aDT;
    private BigInteger aDU;
    private BigInteger adj;

    BCRSAPrivateCrtKey(RSAPrivateCrtKey rsaprivatecrtkey)
    {
        adi = rsaprivatecrtkey.getModulus();
        adj = rsaprivatecrtkey.getPublicExponent();
        adk = rsaprivatecrtkey.getPrivateExponent();
        aDQ = rsaprivatecrtkey.getPrimeP();
        aDR = rsaprivatecrtkey.getPrimeQ();
        aDS = rsaprivatecrtkey.getPrimeExponentP();
        aDT = rsaprivatecrtkey.getPrimeExponentQ();
        aDU = rsaprivatecrtkey.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec rsaprivatecrtkeyspec)
    {
        adi = rsaprivatecrtkeyspec.getModulus();
        adj = rsaprivatecrtkeyspec.getPublicExponent();
        adk = rsaprivatecrtkeyspec.getPrivateExponent();
        aDQ = rsaprivatecrtkeyspec.getPrimeP();
        aDR = rsaprivatecrtkeyspec.getPrimeQ();
        aDS = rsaprivatecrtkeyspec.getPrimeExponentP();
        aDT = rsaprivatecrtkeyspec.getPrimeExponentQ();
        aDU = rsaprivatecrtkeyspec.getCrtCoefficient();
    }

    BCRSAPrivateCrtKey(PrivateKeyInfo privatekeyinfo)
    {
        this(RSAPrivateKey._mth1D4B(ASN1Primitive._mth0640(privatekeyinfo.acY._mth0501())));
    }

    BCRSAPrivateCrtKey(RSAPrivateKey rsaprivatekey)
    {
        adi = rsaprivatekey.adi;
        adj = rsaprivatekey.adj;
        adk = rsaprivatekey.adk;
        aDQ = rsaprivatekey.adl;
        aDR = rsaprivatekey.adm;
        aDS = rsaprivatekey.adn;
        aDT = rsaprivatekey.ado;
        aDU = rsaprivatekey.adp;
    }

    BCRSAPrivateCrtKey(RSAPrivateCrtKeyParameters rsaprivatecrtkeyparameters)
    {
        super(rsaprivatecrtkeyparameters);
        adj = rsaprivatecrtkeyparameters.axF;
        aDQ = rsaprivatecrtkeyparameters.amM;
        aDR = rsaprivatecrtkeyparameters.amN;
        aDS = rsaprivatecrtkeyparameters.axG;
        aDT = rsaprivatecrtkeyparameters.axH;
        aDU = rsaprivatecrtkeyparameters.axI;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey))
        {
            return false;
        }
        obj = (RSAPrivateCrtKey)obj;
        return getModulus().equals(((RSAPrivateCrtKey) (obj)).getModulus()) && getPublicExponent().equals(((RSAPrivateCrtKey) (obj)).getPublicExponent()) && getPrivateExponent().equals(((RSAPrivateCrtKey) (obj)).getPrivateExponent()) && getPrimeP().equals(((RSAPrivateCrtKey) (obj)).getPrimeP()) && getPrimeQ().equals(((RSAPrivateCrtKey) (obj)).getPrimeQ()) && getPrimeExponentP().equals(((RSAPrivateCrtKey) (obj)).getPrimeExponentP()) && getPrimeExponentQ().equals(((RSAPrivateCrtKey) (obj)).getPrimeExponentQ()) && getCrtCoefficient().equals(((RSAPrivateCrtKey) (obj)).getCrtCoefficient());
    }

    public BigInteger getCrtCoefficient()
    {
        return aDU;
    }

    public byte[] getEncoded()
    {
        return KeyUtil._mth02CB(new AlgorithmIdentifier(PKCSObjectIdentifiers.aaX, DERNull.WL), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public BigInteger getPrimeExponentP()
    {
        return aDS;
    }

    public BigInteger getPrimeExponentQ()
    {
        return aDT;
    }

    public BigInteger getPrimeP()
    {
        return aDQ;
    }

    public BigInteger getPrimeQ()
    {
        return aDR;
    }

    public BigInteger getPublicExponent()
    {
        return adj;
    }

    public int hashCode()
    {
        return getModulus().hashCode() ^ getPublicExponent().hashCode() ^ getPrivateExponent().hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("RSA Private CRT Key").append(s);
        stringbuffer.append("            modulus: ").append(getModulus().toString(16)).append(s);
        stringbuffer.append("    public exponent: ").append(getPublicExponent().toString(16)).append(s);
        stringbuffer.append("   private exponent: ").append(getPrivateExponent().toString(16)).append(s);
        stringbuffer.append("             primeP: ").append(getPrimeP().toString(16)).append(s);
        stringbuffer.append("             primeQ: ").append(getPrimeQ().toString(16)).append(s);
        stringbuffer.append("     primeExponentP: ").append(getPrimeExponentP().toString(16)).append(s);
        stringbuffer.append("     primeExponentQ: ").append(getPrimeExponentQ().toString(16)).append(s);
        stringbuffer.append("     crtCoefficient: ").append(getCrtCoefficient().toString(16)).append(s);
        return stringbuffer.toString();
    }
}
