// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.Polynomial;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Integers;
import org.spongycastle.util.io.TeeInputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, TlsFatalAlert, TlsProtocol, ECBasisType, 
//            NamedCurve, DigestInputBuffer

public class TlsECCUtils
{

    private static Integer aBM = Integers.valueOf(10);
    private static Integer aBN = Integers.valueOf(11);
    private static final String aBO[] = {
        "sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", 
        "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", 
        "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1"
    };

    public TlsECCUtils()
    {
    }

    public static ECDomainParameters _mth02B6(int i)
    {
        boolean flag;
        if (i > 0 && i <= 28)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Object obj;
        if (flag)
        {
            obj = aBO[i - 1];
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            return null;
        }
        Object obj1 = CustomNamedCurves._mth14BB(((String) (obj)));
        X9ECParameters x9ecparameters = ((X9ECParameters) (obj1));
        if (obj1 == null)
        {
            obj = ECNamedCurveTable._mth14BB(((String) (obj)));
            x9ecparameters = ((X9ECParameters) (obj));
            if (obj == null)
            {
                return null;
            }
        }
        obj1 = x9ecparameters.alm;
        ECPoint ecpoint = x9ecparameters.alq;
        BigInteger biginteger = x9ecparameters.alr;
        if (x9ecparameters.als == null)
        {
            obj = X9ECParameters.ONE;
        } else
        {
            obj = x9ecparameters.als;
        }
        return new ECDomainParameters(((ECCurve) (obj1)), ecpoint, biginteger, ((BigInteger) (obj)), x9ecparameters.aln);
    }

    public static short[] _mth02BE(Hashtable hashtable)
    {
        hashtable = TlsUtils._mth02CA(hashtable, aBN);
        if (hashtable == null)
        {
            return null;
        }
        if (hashtable == null)
        {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        hashtable = new ByteArrayInputStream(hashtable);
        short word0 = TlsUtils._mth02BD(hashtable);
        if (word0 <= 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        short aword0[] = TlsUtils._mth02CA(word0, hashtable);
        TlsProtocol._mth037A(hashtable);
        if (!Arrays._mth02CB(aword0, (short)0))
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            return aword0;
        }
    }

    private static int _mth02CA(int i, InputStream inputstream)
    {
        inputstream = new BigInteger(1, TlsUtils._mth02BF(inputstream));
        if (inputstream.bitLength() < 32)
        {
            int j = inputstream.intValue();
            if (j > 0 && j < i)
            {
                return j;
            }
        }
        throw new TlsFatalAlert((short)47);
    }

    public static AsymmetricCipherKeyPair _mth02CA(SecureRandom securerandom, ECDomainParameters ecdomainparameters)
    {
        ECKeyPairGenerator eckeypairgenerator = new ECKeyPairGenerator();
        eckeypairgenerator._mth02CA(new ECKeyGenerationParameters(ecdomainparameters, securerandom));
        return eckeypairgenerator._mth1491();
    }

    public static ECDomainParameters _mth02CA(int ai[], short aword0[], TeeInputStream teeinputstream)
    {
        TlsUtils._mth02BD(teeinputstream);
        JVM INSTR tableswitch 1 3: default 445
    //                   1 32
    //                   2 163
    //                   3 366;
           goto _L1 _L2 _L3 _L4
_L2:
        if (ai == null) goto _L6; else goto _L5
_L5:
        if (!Arrays._mth02BD(ai, 65281))
        {
            throw new TlsFatalAlert((short)47);
        }
_L6:
        Object obj = new BigInteger(1, TlsUtils._mth02BF(teeinputstream));
        BigInteger biginteger2 = _mth02CB(((BigInteger) (obj)).bitLength(), teeinputstream);
        BigInteger biginteger4 = _mth02CB(((BigInteger) (obj)).bitLength(), teeinputstream);
        ai = TlsUtils._mth02BF(teeinputstream);
        BigInteger biginteger = new BigInteger(1, TlsUtils._mth02BF(teeinputstream));
        teeinputstream = new BigInteger(1, TlsUtils._mth02BF(teeinputstream));
        obj = new org.spongycastle.math.ec.ECCurve.Fp(((BigInteger) (obj)), biginteger2, biginteger4, biginteger, teeinputstream);
        ai = new ECDomainParameters(((ECCurve) (obj)), _mth02CA(aword0, ((ECCurve) (obj)), ((byte []) (ai))), biginteger, teeinputstream);
        return ai;
_L3:
        if (ai == null) goto _L8; else goto _L7
_L7:
        if (!Arrays._mth02BD(ai, 65282))
        {
            throw new TlsFatalAlert((short)47);
        }
_L8:
        short word0;
        int k;
        int l;
        k = TlsUtils._mth037A(teeinputstream);
        word0 = TlsUtils._mth02BD(teeinputstream);
        if (!ECBasisType._mth02CF(word0))
        {
            throw new TlsFatalAlert((short)47);
        }
        l = _mth02CA(k, ((InputStream) (teeinputstream)));
        int i;
        int j;
        i = -1;
        j = -1;
        if (word0 != 2) goto _L10; else goto _L9
_L9:
        i = _mth02CA(k, ((InputStream) (teeinputstream)));
        j = _mth02CA(k, ((InputStream) (teeinputstream)));
_L10:
        byte abyte0[];
        BigInteger biginteger1;
        BigInteger biginteger3;
        ai = _mth02CB(k, teeinputstream);
        biginteger3 = _mth02CB(k, teeinputstream);
        abyte0 = TlsUtils._mth02BF(teeinputstream);
        biginteger1 = new BigInteger(1, TlsUtils._mth02BF(teeinputstream));
        teeinputstream = new BigInteger(1, TlsUtils._mth02BF(teeinputstream));
        if (word0 != 2) goto _L12; else goto _L11
_L11:
        try
        {
            ai = new org.spongycastle.math.ec.ECCurve.F2m(k, l, i, j, ai, biginteger3, biginteger1, teeinputstream);
        }
        // Misplaced declaration of an exception variable
        catch (int ai[])
        {
            throw new TlsFatalAlert((short)47);
        }
          goto _L13
_L12:
        ai = new org.spongycastle.math.ec.ECCurve.F2m(k, l, ai, biginteger3, biginteger1, teeinputstream);
_L13:
        ai = new ECDomainParameters(ai, _mth02CA(aword0, ((ECCurve) (ai)), abyte0), biginteger1, teeinputstream);
        return ai;
_L4:
        i = TlsUtils._mth037A(teeinputstream);
        if (!NamedCurve._mth0279(i))
        {
            throw new TlsFatalAlert((short)47);
        }
        if (ai == null) goto _L15; else goto _L14
_L14:
        if (!Arrays._mth02BD(ai, i))
        {
            throw new TlsFatalAlert((short)47);
        }
_L15:
        ai = _mth02B6(i);
        return ai;
_L1:
        throw new TlsFatalAlert((short)47);
    }

    public static ECPrivateKeyParameters _mth02CA(SecureRandom securerandom, short aword0[], ECDomainParameters ecdomainparameters, OutputStream outputstream)
    {
        ECKeyPairGenerator eckeypairgenerator = new ECKeyPairGenerator();
        eckeypairgenerator._mth02CA(new ECKeyGenerationParameters(ecdomainparameters, securerandom));
        securerandom = eckeypairgenerator._mth1491();
        TlsUtils._mth02CB(_mth02CA(aword0, ((ECPublicKeyParameters)((AsymmetricCipherKeyPair) (securerandom)).amu).axk), outputstream);
        return (ECPrivateKeyParameters)((AsymmetricCipherKeyPair) (securerandom)).amv;
    }

    public static ECPublicKeyParameters _mth02CA(ECPublicKeyParameters ecpublickeyparameters)
    {
        return ecpublickeyparameters;
    }

    public static ECPublicKeyParameters _mth02CA(short aword0[], ECDomainParameters ecdomainparameters, byte abyte0[])
    {
        try
        {
            aword0 = new ECPublicKeyParameters(_mth02CA(aword0, ecdomainparameters.alm, abyte0), ecdomainparameters);
        }
        // Misplaced declaration of an exception variable
        catch (short aword0[])
        {
            throw new TlsFatalAlert((short)47);
        }
        return aword0;
    }

    private static ECPoint _mth02CA(short aword0[], ECCurve eccurve, byte abyte0[])
    {
        if (abyte0 == null || abyte0.length <= 0)
        {
            throw new TlsFatalAlert((short)47);
        }
        short word0;
        switch (abyte0[0])
        {
        case 2: // '\002'
        case 3: // '\003'
            if (ECAlgorithms._mth02CF(eccurve))
            {
                word0 = 2;
            } else
            if (ECAlgorithms._mth141D(eccurve))
            {
                word0 = 1;
            } else
            {
                throw new TlsFatalAlert((short)47);
            }
            break;

        case 4: // '\004'
            word0 = 0;
            break;

        default:
            throw new TlsFatalAlert((short)47);
        }
        if (!Arrays._mth02CB(aword0, word0))
        {
            throw new TlsFatalAlert((short)47);
        } else
        {
            return eccurve._mth01C3(abyte0);
        }
    }

    public static void _mth02CA(int i, DigestInputBuffer digestinputbuffer)
    {
        if (!NamedCurve._mth0279(i))
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            TlsUtils._mth02CA((short)3, digestinputbuffer);
            TlsUtils._mth05DF(i);
            TlsUtils._mth02CF(i, digestinputbuffer);
            return;
        }
    }

    public static void _mth02CA(short aword0[], ECDomainParameters ecdomainparameters, DigestInputBuffer digestinputbuffer)
    {
        Object obj = ecdomainparameters.alm;
        if (ECAlgorithms._mth141D(((ECCurve) (obj))))
        {
            TlsUtils._mth02CA((short)1, digestinputbuffer);
            TlsUtils._mth02CB(BigIntegers._mth02D1(((ECCurve) (obj)).FB25()._mth0506()), digestinputbuffer);
        } else
        if (ECAlgorithms._mth02CF(((ECCurve) (obj))))
        {
            int ai[] = ((PolynomialExtensionField)((ECCurve) (obj)).FB25())._mth057D()._mth0578();
            TlsUtils._mth02CA((short)2, digestinputbuffer);
            int i = ai[ai.length - 1];
            TlsUtils._mth05DF(i);
            TlsUtils._mth02CF(i, digestinputbuffer);
            if (ai.length == 3)
            {
                TlsUtils._mth02CA((short)1, digestinputbuffer);
                TlsUtils._mth02CB(BigIntegers._mth02D1(BigInteger.valueOf(ai[1])), digestinputbuffer);
            } else
            if (ai.length == 5)
            {
                TlsUtils._mth02CA((short)2, digestinputbuffer);
                TlsUtils._mth02CB(BigIntegers._mth02D1(BigInteger.valueOf(ai[1])), digestinputbuffer);
                TlsUtils._mth02CB(BigIntegers._mth02D1(BigInteger.valueOf(ai[2])), digestinputbuffer);
                TlsUtils._mth02CB(BigIntegers._mth02D1(BigInteger.valueOf(ai[3])), digestinputbuffer);
            } else
            {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else
        {
            throw new IllegalArgumentException("'ecParameters' not a known curve type");
        }
        ECFieldElement ecfieldelement = ((ECCurve) (obj)).FB46();
        TlsUtils._mth02CB(BigIntegers._mth02BB((ecfieldelement.getFieldSize() + 7) / 8, ecfieldelement.toBigInteger()), digestinputbuffer);
        obj = ((ECCurve) (obj)).FB4C();
        TlsUtils._mth02CB(BigIntegers._mth02BB((((ECFieldElement) (obj)).getFieldSize() + 7) / 8, ((ECFieldElement) (obj)).toBigInteger()), digestinputbuffer);
        TlsUtils._mth02CB(_mth02CA(aword0, ecdomainparameters.axi), digestinputbuffer);
        TlsUtils._mth02CB(BigIntegers._mth02D1(ecdomainparameters.alr), digestinputbuffer);
        TlsUtils._mth02CB(BigIntegers._mth02D1(ecdomainparameters.als), digestinputbuffer);
    }

    public static void _mth02CA(short aword0[], ECPoint ecpoint, OutputStream outputstream)
    {
        TlsUtils._mth02CB(_mth02CA(aword0, ecpoint), outputstream);
    }

    private static boolean _mth02CA(short aword0[], short word0)
    {
        if (aword0 == null)
        {
            return false;
        }
        for (int i = 0; i < aword0.length; i++)
        {
            short word1 = aword0[i];
            if (word1 == 0)
            {
                return false;
            }
            if (word1 == word0)
            {
                return true;
            }
        }

        return false;
    }

    public static byte[] _mth02CA(ECPublicKeyParameters ecpublickeyparameters, ECPrivateKeyParameters ecprivatekeyparameters)
    {
        ECDHBasicAgreement ecdhbasicagreement = new ECDHBasicAgreement();
        ecdhbasicagreement.amK = (ECPrivateKeyParameters)ecprivatekeyparameters;
        ecpublickeyparameters = ecdhbasicagreement._mth02CB(ecpublickeyparameters);
        return BigIntegers._mth02BB((((ECKeyParameters) (ecdhbasicagreement.amK)).aub.alm.getFieldSize() + 7) / 8, ecpublickeyparameters);
    }

    private static byte[] _mth02CA(short aword0[], ECPoint ecpoint)
    {
        ECCurve eccurve = ecpoint.FF79();
        boolean flag = false;
        if (ECAlgorithms._mth141D(eccurve))
        {
            flag = _mth02CA(aword0, (short)1);
        } else
        if (ECAlgorithms._mth02CF(eccurve))
        {
            flag = _mth02CA(aword0, (short)2);
        }
        return ecpoint._mth15AE(flag);
    }

    private static BigInteger _mth02CB(int i, InputStream inputstream)
    {
        inputstream = TlsUtils._mth02BF(inputstream);
        i = (i + 7) / 8;
        if (inputstream.length != i)
        {
            throw new TlsFatalAlert((short)50);
        } else
        {
            return new BigInteger(1, inputstream);
        }
    }

    public static boolean _mth03CA(int i)
    {
        switch (i)
        {
        case 49153: 
        case 49154: 
        case 49155: 
        case 49156: 
        case 49157: 
        case 49158: 
        case 49159: 
        case 49160: 
        case 49161: 
        case 49162: 
        case 49163: 
        case 49164: 
        case 49165: 
        case 49166: 
        case 49167: 
        case 49168: 
        case 49169: 
        case 49170: 
        case 49171: 
        case 49172: 
        case 49173: 
        case 49174: 
        case 49175: 
        case 49176: 
        case 49177: 
        case 49187: 
        case 49188: 
        case 49189: 
        case 49190: 
        case 49191: 
        case 49192: 
        case 49193: 
        case 49194: 
        case 49195: 
        case 49196: 
        case 49197: 
        case 49198: 
        case 49199: 
        case 49200: 
        case 49201: 
        case 49202: 
        case 49203: 
        case 49204: 
        case 49205: 
        case 49206: 
        case 49207: 
        case 49208: 
        case 49209: 
        case 49210: 
        case 49211: 
        case 49266: 
        case 49267: 
        case 49268: 
        case 49269: 
        case 49270: 
        case 49271: 
        case 49272: 
        case 49273: 
        case 49286: 
        case 49287: 
        case 49288: 
        case 49289: 
        case 49290: 
        case 49291: 
        case 49292: 
        case 49293: 
        case 49306: 
        case 49307: 
        case 52243: 
        case 52244: 
        case 58386: 
        case 58387: 
        case 58388: 
        case 58389: 
        case 58392: 
        case 58393: 
            return true;
        }
        return false;
    }

    public static boolean _mth05D2(int i)
    {
        return i > 0 && i <= 28;
    }

    public static int[] _mth1FBE(Hashtable hashtable)
    {
        hashtable = TlsUtils._mth02CA(hashtable, aBM);
        if (hashtable == null)
        {
            return null;
        }
        if (hashtable == null)
        {
            throw new IllegalArgumentException("'extensionData' cannot be null");
        }
        hashtable = new ByteArrayInputStream(hashtable);
        int i = TlsUtils._mth037A(hashtable);
        if (i < 2 || (i & 1) != 0)
        {
            throw new TlsFatalAlert((short)50);
        } else
        {
            int ai[] = TlsUtils._mth02CB(i / 2, hashtable);
            TlsProtocol._mth037A(hashtable);
            return ai;
        }
    }

}
