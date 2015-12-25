// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Null;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;

// Referenced classes of package org.spongycastle.jce.provider:
//            BouncyCastleProvider

public class JCEECPublicKey
    implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{

    private String aDc;
    private java.security.spec.ECParameterSpec aDd;
    private GOST3410PublicKeyAlgParameters aDw;
    private boolean aHv;
    private org.spongycastle.math.ec.ECPoint ayu;

    private void readObject(ObjectInputStream objectinputstream)
    {
label0:
        {
            Object obj1;
            Object obj2;
label1:
            {
                Object obj3 = SubjectPublicKeyInfo._mth13A5(ASN1Primitive._mth0640((byte[])objectinputstream.readObject()));
                if (((SubjectPublicKeyInfo) (obj3)).aaK._mth072C().equals(CryptoProObjectIdentifiers.XW))
                {
                    Object obj = ((SubjectPublicKeyInfo) (obj3)).ajD;
                    aDc = "ECGOST3410";
                    try
                    {
                        obj = (ASN1OctetString)ASN1Primitive._mth0640(((DERBitString) (obj)).getBytes());
                    }
                    // Misplaced declaration of an exception variable
                    catch (ObjectInputStream objectinputstream)
                    {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                    byte abyte2[] = ((ASN1OctetString) (obj))._mth0501();
                    byte abyte0[] = new byte[32];
                    byte abyte1[] = new byte[32];
                    for (int i = 0; i != 32; i++)
                    {
                        abyte0[i] = abyte2[31 - i];
                    }

                    for (int j = 0; j != 32; j++)
                    {
                        abyte1[j] = abyte2[63 - j];
                    }

                    aDw = new GOST3410PublicKeyAlgParameters((ASN1Sequence)((SubjectPublicKeyInfo) (obj3)).aaK.ahQ);
                    obj3 = ECGOST3410NamedCurveTable.FE72(ECGOST3410NamedCurves._mth02CE(aDw.Yt));
                    ECCurve eccurve2 = ((ECParameterSpec) (obj3)).alm;
                    EllipticCurve ellipticcurve2 = EC5Util._mth02CE(eccurve2);
                    ayu = eccurve2._mth02CA(new BigInteger(1, abyte0), new BigInteger(1, abyte1), false);
                    aDd = new ECNamedCurveSpec(ECGOST3410NamedCurves._mth02CE(aDw.Yt), ellipticcurve2, new ECPoint(((ECParameterSpec) (obj3)).axi.FF8A().toBigInteger(), ((ECParameterSpec) (obj3)).axi.FF93().toBigInteger()), ((ECParameterSpec) (obj3)).alr, ((ECParameterSpec) (obj3)).als);
                    break label0;
                }
                obj1 = new X962Parameters((ASN1Primitive)((SubjectPublicKeyInfo) (obj3)).aaK.ahQ);
                if (((X962Parameters) (obj1)).alk instanceof ASN1ObjectIdentifier)
                {
                    Object obj4 = (ASN1ObjectIdentifier)((X962Parameters) (obj1)).alk;
                    obj1 = ECUtil._mth1FBE(((ASN1ObjectIdentifier) (obj4)));
                    ECCurve eccurve = ((X9ECParameters) (obj1)).alm;
                    EllipticCurve ellipticcurve = EC5Util._mth02CE(eccurve);
                    obj4 = ECUtil._mth02BE(((ASN1ObjectIdentifier) (obj4)));
                    ECPoint ecpoint1 = new ECPoint(((X9ECParameters) (obj1)).alq.FF8A().toBigInteger(), ((X9ECParameters) (obj1)).alq.FF93().toBigInteger());
                    BigInteger biginteger1 = ((X9ECParameters) (obj1)).alr;
                    if (((X9ECParameters) (obj1)).als == null)
                    {
                        obj1 = X9ECParameters.ONE;
                    } else
                    {
                        obj1 = ((X9ECParameters) (obj1)).als;
                    }
                    aDd = new ECNamedCurveSpec(((String) (obj4)), ellipticcurve, ecpoint1, biginteger1, ((BigInteger) (obj1)));
                    obj1 = eccurve;
                } else
                if (((X962Parameters) (obj1)).alk instanceof ASN1Null)
                {
                    aDd = null;
                    obj1 = BouncyCastleProvider.aGZ._mth1623().alm;
                } else
                {
                    obj1 = X9ECParameters._mth0640(((X962Parameters) (obj1)).alk);
                    ECCurve eccurve1 = ((X9ECParameters) (obj1)).alm;
                    EllipticCurve ellipticcurve1 = EC5Util._mth02CE(eccurve1);
                    ECPoint ecpoint = new ECPoint(((X9ECParameters) (obj1)).alq.FF8A().toBigInteger(), ((X9ECParameters) (obj1)).alq.FF93().toBigInteger());
                    BigInteger biginteger = ((X9ECParameters) (obj1)).alr;
                    if (((X9ECParameters) (obj1)).als == null)
                    {
                        obj1 = X9ECParameters.ONE;
                    } else
                    {
                        obj1 = ((X9ECParameters) (obj1)).als;
                    }
                    aDd = new java.security.spec.ECParameterSpec(ellipticcurve1, ecpoint, biginteger, ((BigInteger) (obj1)).intValue());
                    obj1 = eccurve1;
                }
                byte abyte3[] = ((SubjectPublicKeyInfo) (obj3)).ajD.getBytes();
                obj3 = new DEROctetString(abyte3);
                obj2 = obj3;
                if (abyte3[0] != 4)
                {
                    break label1;
                }
                obj2 = obj3;
                if (abyte3[1] != abyte3.length - 2)
                {
                    break label1;
                }
                if (abyte3[2] != 2)
                {
                    obj2 = obj3;
                    if (abyte3[2] != 3)
                    {
                        break label1;
                    }
                }
                new X9IntegerConverter();
                obj2 = obj3;
                if (X9IntegerConverter._mth02CB(((ECCurve) (obj1))) >= abyte3.length - 3)
                {
                    try
                    {
                        obj2 = (ASN1OctetString)ASN1Primitive._mth0640(abyte3);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ObjectInputStream objectinputstream)
                    {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                }
            }
            ayu = (new X9ECPoint(((ECCurve) (obj1)), ((ASN1OctetString) (obj2)))).alu;
        }
        aDc = (String)objectinputstream.readObject();
        aHv = objectinputstream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(getEncoded());
        objectoutputstream.writeObject(aDc);
        objectoutputstream.writeBoolean(aHv);
    }

    private static void _mth02CA(byte abyte0[], int i, BigInteger biginteger)
    {
        byte abyte1[] = biginteger.toByteArray();
        biginteger = abyte1;
        if (abyte1.length < 32)
        {
            biginteger = new byte[32];
            System.arraycopy(abyte1, 0, biginteger, 32 - abyte1.length, abyte1.length);
        }
        for (int j = 0; j != 32; j++)
        {
            abyte0[i + j] = biginteger[biginteger.length - 1 - j];
        }

    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof JCEECPublicKey))
        {
            return false;
        }
        Object obj1 = (JCEECPublicKey)obj;
        if (ayu._mth02CF(((JCEECPublicKey) (obj1)).ayu))
        {
            if (aDd != null)
            {
                obj = EC5Util._mth02CA(aDd, aHv);
            } else
            {
                obj = BouncyCastleProvider.aGZ._mth1623();
            }
            if (((JCEECPublicKey) (obj1)).aDd != null)
            {
                obj1 = EC5Util._mth02CA(((JCEECPublicKey) (obj1)).aDd, ((JCEECPublicKey) (obj1)).aHv);
            } else
            {
                obj1 = BouncyCastleProvider.aGZ._mth1623();
            }
            if (((ECParameterSpec) (obj)).equals(obj1))
            {
                return true;
            }
        }
        return false;
    }

    public String getAlgorithm()
    {
        return aDc;
    }

    public byte[] getEncoded()
    {
        IOException ioexception;
        Object obj;
        if (aDc.equals("ECGOST3410"))
        {
            if (aDw != null)
            {
                obj = aDw;
            } else
            if (aDd instanceof ECNamedCurveSpec)
            {
                obj = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves._mth1422(((ECNamedCurveSpec)aDd).name), CryptoProObjectIdentifiers.XZ);
            } else
            {
                obj = EC5Util._mth02CA(aDd.getCurve());
                obj = new X962Parameters(new X9ECParameters(((ECCurve) (obj)), EC5Util._mth02CA(((ECCurve) (obj)), aDd.getGenerator(), aHv), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
            }
            BigInteger biginteger = ayu.FF8A().toBigInteger();
            BigInteger biginteger1 = ayu.FF93().toBigInteger();
            byte abyte0[] = new byte[64];
            _mth02CA(abyte0, 0, biginteger);
            _mth02CA(abyte0, 32, biginteger1);
            try
            {
                obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.XW, ((org.spongycastle.asn1.ASN1Encodable) (obj))), new DEROctetString(abyte0));
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception)
            {
                return null;
            }
        } else
        {
            if (aDd instanceof ECNamedCurveSpec)
            {
                ASN1ObjectIdentifier asn1objectidentifier = ECUtil._mth157D(((ECNamedCurveSpec)aDd).name);
                obj = asn1objectidentifier;
                if (asn1objectidentifier == null)
                {
                    obj = new ASN1ObjectIdentifier(((ECNamedCurveSpec)aDd).name);
                }
                obj = new X962Parameters(((ASN1ObjectIdentifier) (obj)));
            } else
            if (aDd == null)
            {
                obj = new X962Parameters(DERNull.WL);
            } else
            {
                obj = EC5Util._mth02CA(aDd.getCurve());
                obj = new X962Parameters(new X9ECParameters(((ECCurve) (obj)), EC5Util._mth02CA(((ECCurve) (obj)), aDd.getGenerator(), aHv), aDd.getOrder(), BigInteger.valueOf(aDd.getCofactor()), aDd.getCurve().getSeed()));
            }
            ECCurve eccurve = ayu.FF79();
            Object obj1;
            if (aDd == null)
            {
                obj1 = ayu.FF78();
            } else
            {
                obj1 = ayu;
            }
            BigInteger biginteger2 = ((org.spongycastle.math.ec.ECPoint) (obj1)).FF8A().toBigInteger();
            if (aDd == null)
            {
                obj1 = ayu.FF78();
            } else
            {
                obj1 = ayu;
            }
            obj1 = (ASN1OctetString)(new X9ECPoint(eccurve._mth02CA(biginteger2, ((org.spongycastle.math.ec.ECPoint) (obj1)).FF93().toBigInteger(), aHv)))._mth0427();
            obj = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.alH, ((org.spongycastle.asn1.ASN1Encodable) (obj))), ((ASN1OctetString) (obj1))._mth0501());
        }
        return KeyUtil._mth02CF(((SubjectPublicKeyInfo) (obj)));
    }

    public String getFormat()
    {
        return "X.509";
    }

    public java.security.spec.ECParameterSpec getParams()
    {
        return aDd;
    }

    public ECPoint getW()
    {
        return new ECPoint(ayu.FF8A().toBigInteger(), ayu.FF93().toBigInteger());
    }

    public int hashCode()
    {
        int i = ayu.hashCode();
        ECParameterSpec ecparameterspec;
        if (aDd != null)
        {
            ecparameterspec = EC5Util._mth02CA(aDd, aHv);
        } else
        {
            ecparameterspec = BouncyCastleProvider.aGZ._mth1623();
        }
        return i ^ ecparameterspec.hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = System.getProperty("line.separator");
        stringbuffer.append("EC Public Key").append(s);
        stringbuffer.append("            X: ").append(ayu.FF8A().toBigInteger().toString(16)).append(s);
        stringbuffer.append("            Y: ").append(ayu.FF93().toBigInteger().toString(16)).append(s);
        return stringbuffer.toString();
    }

    public final ECParameterSpec _mth15A7()
    {
        if (aDd == null)
        {
            return null;
        } else
        {
            return EC5Util._mth02CA(aDd, aHv);
        }
    }

    public final org.spongycastle.math.ec.ECPoint _mth15AA()
    {
        if (aDd == null)
        {
            return ayu.FF78();
        } else
        {
            return ayu;
        }
    }
}
