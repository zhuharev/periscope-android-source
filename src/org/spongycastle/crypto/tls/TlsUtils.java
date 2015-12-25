// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.asn1.x509.TBSCertificate;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;
import org.spongycastle.util.io.Streams;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsDSSSigner, TlsECDSASigner, TlsRSASigner, ProtocolVersion, 
//            TlsFatalAlert, SignatureAndHashAlgorithm, TlsHandshakeHash, TlsContext, 
//            SecurityParameters, CombinedHash, Certificate, AbstractTlsSigner, 
//            AbstractTlsContext

public class TlsUtils
{

    public static final byte WQ[] = new byte[0];
    static final byte aCA[] = {
        67, 76, 78, 84
    };
    static final byte aCB[] = {
        83, 82, 86, 82
    };
    private static byte aCC[][];
    public static final Integer aCz = Integers.valueOf(13);

    public TlsUtils()
    {
    }

    public static void _mth02BC(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)(i >>> 8);
        abyte0[j + 1] = (byte)i;
    }

    public static boolean _mth02BC(short word0)
    {
        return (word0 & 0xff) == word0;
    }

    public static ExtendedDigest _mth02BD(short word0)
    {
        switch (word0)
        {
        case 1: // '\001'
            return new MD5Digest();

        case 2: // '\002'
            return new SHA1Digest();

        case 3: // '\003'
            return new SHA224Digest();

        case 4: // '\004'
            return new SHA256Digest();

        case 5: // '\005'
            return new SHA384Digest();

        case 6: // '\006'
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unknown HashAlgorithm");
    }

    public static short _mth02BD(InputStream inputstream)
    {
        int i = inputstream.read();
        if (i < 0)
        {
            throw new EOFException();
        } else
        {
            return (short)i;
        }
    }

    public static void _mth02BD(int i, byte abyte0[], int j)
    {
        abyte0[1] = (byte)(i >>> 16);
        abyte0[2] = (byte)(i >>> 8);
        abyte0[3] = (byte)i;
    }

    public static long _mth02BE(InputStream inputstream)
    {
        int i = inputstream.read();
        int j = inputstream.read();
        int k = inputstream.read();
        int l = inputstream.read();
        if (l < 0)
        {
            throw new EOFException();
        } else
        {
            return (long)(i << 2 | j << 16 | k << 8 | l) & 0xffffffffL;
        }
    }

    public static AbstractTlsSigner _mth02BE(short word0)
    {
        switch (word0)
        {
        case 2: // '\002'
            return new TlsDSSSigner();

        case 64: // '@'
            return new TlsECDSASigner();

        case 1: // '\001'
            return new TlsRSASigner();
        }
        throw new IllegalArgumentException("'clientCertificateType' is not a type with signing capability");
    }

    public static ProtocolVersion _mth02BF(ByteArrayInputStream bytearrayinputstream)
    {
        int i = bytearrayinputstream.read();
        int j = bytearrayinputstream.read();
        if (j < 0)
        {
            throw new EOFException();
        } else
        {
            return ProtocolVersion._mth15EE(i, j);
        }
    }

    public static byte[] _mth02BF(InputStream inputstream)
    {
        int i = inputstream.read();
        if (i < 0)
        {
            throw new EOFException();
        }
        i = (short)i;
        if (i <= 0)
        {
            return WQ;
        }
        byte abyte0[] = new byte[i];
        if (i != Streams._mth02CB(inputstream, abyte0))
        {
            throw new EOFException();
        } else
        {
            return abyte0;
        }
    }

    public static byte[] _mth02C8(InputStream inputstream)
    {
        int i = inputstream.read();
        int j = inputstream.read();
        if (j < 0)
        {
            throw new EOFException();
        }
        i = i << 8 | j;
        if (i <= 0)
        {
            return WQ;
        }
        byte abyte0[] = new byte[i];
        if (i != Streams._mth02CB(inputstream, abyte0))
        {
            throw new EOFException();
        } else
        {
            return abyte0;
        }
    }

    public static byte[] _mth02C9(InputStream inputstream)
    {
        int i = _mth1FBE(inputstream);
        if (i <= 0)
        {
            return WQ;
        }
        byte abyte0[] = new byte[i];
        if (i != Streams._mth02CB(inputstream, abyte0))
        {
            throw new EOFException();
        } else
        {
            return abyte0;
        }
    }

    public static Vector _mth02CA(boolean flag, InputStream inputstream)
    {
        int i = inputstream.read();
        int k = inputstream.read();
        if (k < 0)
        {
            throw new EOFException();
        }
        i = i << 8 | k;
        if (i < 2 || (i & 1) != 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        k = i / 2;
        Vector vector = new Vector(k);
        for (int j = 0; j < k; j++)
        {
            SignatureAndHashAlgorithm signatureandhashalgorithm = SignatureAndHashAlgorithm._mth02BB(inputstream);
            if (signatureandhashalgorithm._mth09AF() == 0)
            {
                throw new TlsFatalAlert((short)47);
            }
            vector.addElement(signatureandhashalgorithm);
        }

        return vector;
    }

    public static ExtendedDigest _mth02CA(short word0, Digest digest)
    {
        switch (word0)
        {
        case 1: // '\001'
            return new MD5Digest((MD5Digest)digest);

        case 2: // '\002'
            return new SHA1Digest((SHA1Digest)digest);

        case 3: // '\003'
            return new SHA224Digest((SHA224Digest)digest);

        case 4: // '\004'
            return new SHA256Digest((SHA256Digest)digest);

        case 5: // '\005'
            return new SHA384Digest((SHA384Digest)digest);

        case 6: // '\006'
            return new SHA512Digest((SHA512Digest)digest);
        }
        throw new IllegalArgumentException("unknown HashAlgorithm");
    }

    public static void _mth02CA(long l, OutputStream outputstream)
    {
        outputstream.write((byte)(int)(l >>> 24));
        outputstream.write((byte)(int)(l >>> 16));
        outputstream.write((byte)(int)(l >>> 8));
        outputstream.write((byte)(int)l);
    }

    public static void _mth02CA(Vector vector, boolean flag, OutputStream outputstream)
    {
        if (vector == null || vector.size() <= 0 || vector.size() >= 32768)
        {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        int j = vector.size() * 2;
        boolean flag1;
        if ((j & 0xffff) == j)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            throw new TlsFatalAlert((short)80);
        }
        outputstream.write(j >>> 8);
        outputstream.write(j);
        for (int i = 0; i < vector.size(); i++)
        {
            SignatureAndHashAlgorithm signatureandhashalgorithm = (SignatureAndHashAlgorithm)vector.elementAt(i);
            if (signatureandhashalgorithm._mth09AF() == 0)
            {
                throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
            }
            signatureandhashalgorithm.encode(outputstream);
        }

    }

    static void _mth02CA(Certificate certificate, int i)
    {
        certificate = certificate.air.aii;
        if (certificate != null)
        {
            certificate = KeyUsage._mth02CA(certificate);
            if (certificate != null && (((KeyUsage) (certificate)).ajt.getBytes()[0] & 0xff & i) != i)
            {
                throw new TlsFatalAlert((short)46);
            }
        }
    }

    public static void _mth02CA(ProtocolVersion protocolversion, TlsProtocol.HandshakeMessage handshakemessage)
    {
        handshakemessage.write(protocolversion.version >> 8);
        handshakemessage.write(protocolversion.version & 0xff);
    }

    public static void _mth02CA(ProtocolVersion protocolversion, byte abyte0[], int i)
    {
        abyte0[i] = (byte)(protocolversion.version >> 8);
        abyte0[i + 1] = (byte)protocolversion.version;
    }

    static void _mth02CA(TlsHandshakeHash tlshandshakehash, Vector vector)
    {
        if (vector != null)
        {
            for (int i = 0; i < vector.size(); i++)
            {
                tlshandshakehash._mth02CB(((SignatureAndHashAlgorithm)vector.elementAt(i))._mth09AA());
            }

        }
    }

    public static void _mth02CA(short word0, OutputStream outputstream)
    {
        outputstream.write(word0);
    }

    public static void _mth02CA(short word0, byte abyte0[], int i)
    {
        abyte0[i] = (byte)word0;
    }

    public static void _mth02CA(short aword0[], OutputStream outputstream)
    {
        int i = aword0.length;
        boolean flag;
        if ((i & 0xff) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new TlsFatalAlert((short)80);
        }
        outputstream.write(aword0.length);
        for (int j = 0; j < aword0.length; j++)
        {
            outputstream.write(aword0[j]);
        }

    }

    public static boolean _mth02CA(int i, ProtocolVersion protocolversion)
    {
        ProtocolVersion protocolversion1;
        switch (i)
        {
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 103: // 'g'
        case 104: // 'h'
        case 105: // 'i'
        case 106: // 'j'
        case 107: // 'k'
        case 156: 
        case 157: 
        case 158: 
        case 159: 
        case 160: 
        case 161: 
        case 162: 
        case 163: 
        case 164: 
        case 165: 
        case 168: 
        case 169: 
        case 170: 
        case 171: 
        case 172: 
        case 173: 
        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 191: 
        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
        case 197: 
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
        case 49266: 
        case 49267: 
        case 49268: 
        case 49269: 
        case 49270: 
        case 49271: 
        case 49272: 
        case 49273: 
        case 49274: 
        case 49275: 
        case 49276: 
        case 49277: 
        case 49278: 
        case 49279: 
        case 49280: 
        case 49281: 
        case 49282: 
        case 49283: 
        case 49284: 
        case 49285: 
        case 49286: 
        case 49287: 
        case 49288: 
        case 49289: 
        case 49290: 
        case 49291: 
        case 49292: 
        case 49293: 
        case 49294: 
        case 49295: 
        case 49296: 
        case 49297: 
        case 49298: 
        case 49299: 
        case 49308: 
        case 49309: 
        case 49310: 
        case 49311: 
        case 49312: 
        case 49313: 
        case 49314: 
        case 49315: 
        case 49316: 
        case 49317: 
        case 49318: 
        case 49319: 
        case 49320: 
        case 49321: 
        case 49322: 
        case 49323: 
        case 52243: 
        case 52244: 
        case 52245: 
            protocolversion1 = ProtocolVersion.aAI;
            break;

        default:
            protocolversion1 = ProtocolVersion.aAF;
            break;
        }
        return protocolversion1._mth02CB(protocolversion._mth0993());
    }

    public static boolean _mth02CA(Hashtable hashtable, Integer integer, short word0)
    {
        if (hashtable == null)
        {
            hashtable = null;
        } else
        {
            hashtable = (byte[])hashtable.get(integer);
        }
        if (hashtable == null)
        {
            return false;
        }
        if (hashtable.length != 0)
        {
            throw new TlsFatalAlert(word0);
        } else
        {
            return true;
        }
    }

    public static byte[] _mth02CA(Hashtable hashtable, Integer integer)
    {
        if (hashtable == null)
        {
            return null;
        } else
        {
            return (byte[])hashtable.get(integer);
        }
    }

    static byte[] _mth02CA(AbstractTlsContext abstracttlscontext, String s, byte abyte0[])
    {
        boolean flag;
        if (abstracttlscontext._mth0455() == ProtocolVersion.aAF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return abyte0;
        } else
        {
            SecurityParameters securityparameters = abstracttlscontext._mth03DC();
            return _mth02CA(((TlsContext) (abstracttlscontext)), securityparameters.aBi, s, abyte0, securityparameters.aBh);
        }
    }

    static byte[] _mth02CA(TlsContext tlscontext, int i)
    {
        SecurityParameters securityparameters = tlscontext._mth03DC();
        byte abyte0[] = securityparameters.aBi;
        byte abyte2[] = securityparameters.aBk;
        byte abyte3[] = securityparameters.aBj;
        byte abyte1[] = new byte[abyte2.length + abyte3.length];
        System.arraycopy(abyte2, 0, abyte1, 0, abyte2.length);
        System.arraycopy(abyte3, 0, abyte1, abyte2.length, abyte3.length);
        boolean flag;
        if (tlscontext._mth0455() == ProtocolVersion.aAF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ExtendedDigest extendeddigest = _mth02BD((short)1);
            ExtendedDigest extendeddigest1 = _mth02BD((short)2);
            int l = extendeddigest._mth14AF();
            byte abyte4[] = new byte[extendeddigest1._mth14AF()];
            tlscontext = new byte[i + l];
            int j = 0;
            for (int k = 0; k < i;)
            {
                byte abyte5[] = aCC[j];
                extendeddigest1.update(abyte5, 0, abyte5.length);
                extendeddigest1.update(abyte0, 0, abyte0.length);
                extendeddigest1.update(abyte1, 0, abyte1.length);
                extendeddigest1.doFinal(abyte4, 0);
                extendeddigest.update(abyte0, 0, abyte0.length);
                extendeddigest.update(abyte4, 0, abyte4.length);
                extendeddigest.doFinal(tlscontext, k);
                k += l;
                j++;
            }

            abyte0 = new byte[i];
            System.arraycopy(tlscontext, 0, abyte0, 0, i);
            return abyte0;
        } else
        {
            return _mth02CA(tlscontext, abyte0, "key expansion", abyte1, i);
        }
    }

    static byte[] _mth02CA(TlsContext tlscontext, byte abyte0[])
    {
        SecurityParameters securityparameters = tlscontext._mth03DC();
        byte abyte2[] = securityparameters.aBj;
        byte abyte3[] = securityparameters.aBk;
        byte abyte1[] = new byte[abyte2.length + abyte3.length];
        System.arraycopy(abyte2, 0, abyte1, 0, abyte2.length);
        System.arraycopy(abyte3, 0, abyte1, abyte2.length, abyte3.length);
        boolean flag;
        if (tlscontext._mth0455() == ProtocolVersion.aAF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            tlscontext = _mth02BD((short)1);
            ExtendedDigest extendeddigest = _mth02BD((short)2);
            int k = tlscontext._mth14AF();
            byte abyte4[] = new byte[extendeddigest._mth14AF()];
            byte abyte5[] = new byte[k * 3];
            int j = 0;
            for (int i = 0; i < 3; i++)
            {
                byte abyte6[] = aCC[i];
                extendeddigest.update(abyte6, 0, abyte6.length);
                extendeddigest.update(abyte0, 0, abyte0.length);
                extendeddigest.update(abyte1, 0, abyte1.length);
                extendeddigest.doFinal(abyte4, 0);
                tlscontext.update(abyte0, 0, abyte0.length);
                tlscontext.update(abyte4, 0, abyte4.length);
                tlscontext.doFinal(abyte5, j);
                j += k;
            }

            return abyte5;
        } else
        {
            return _mth02CA(tlscontext, abyte0, "master secret", abyte1, 48);
        }
    }

    private static byte[] _mth02CA(TlsContext tlscontext, byte abyte0[], String s, byte abyte1[], int i)
    {
        boolean flag;
        if (tlscontext._mth0455() == ProtocolVersion.aAF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            throw new IllegalStateException("No PRF available for SSLv3 session");
        }
        byte abyte2[] = Strings.FEE7(s);
        s = new byte[abyte2.length + abyte1.length];
        System.arraycopy(abyte2, 0, s, 0, abyte2.length);
        System.arraycopy(abyte1, 0, s, abyte2.length, abyte1.length);
        int j = tlscontext._mth03DC().aBg;
        if (j == 0)
        {
            return _mth141D(abyte0, s, i);
        }
        switch (j)
        {
        case 0: // '\0'
            tlscontext = new CombinedHash();
            break;

        default:
            tlscontext = _mth02BD(_mth05E8(j));
            break;
        }
        abyte1 = new byte[i];
        _mth02CB(tlscontext, abyte0, s, abyte1);
        return abyte1;
    }

    public static short[] _mth02CA(int i, ByteArrayInputStream bytearrayinputstream)
    {
        short aword0[] = new short[i];
        for (int j = 0; j < i; j++)
        {
            int k = bytearrayinputstream.read();
            if (k < 0)
            {
                throw new EOFException();
            }
            aword0[j] = (short)k;
        }

        return aword0;
    }

    private static void _mth02CB(Digest digest, byte abyte0[], byte abyte1[], byte abyte2[])
    {
        HMac hmac = new HMac(digest);
        hmac._mth02CA(new KeyParameter(abyte0));
        abyte0 = abyte1;
        int j = digest._mth14AF();
        int k = ((abyte2.length + j) - 1) / j;
        digest = new byte[hmac.auN];
        byte abyte3[] = new byte[hmac.auN];
        for (int i = 0; i < k; i++)
        {
            hmac.update(abyte0, 0, abyte0.length);
            hmac.doFinal(digest, 0);
            abyte0 = digest;
            hmac.update(abyte0, 0, abyte0.length);
            hmac.update(abyte1, 0, abyte1.length);
            hmac.doFinal(abyte3, 0);
            System.arraycopy(abyte3, 0, abyte2, j * i, Math.min(j, abyte2.length - j * i));
        }

    }

    public static void _mth02CB(byte abyte0[], OutputStream outputstream)
    {
        int i = abyte0.length;
        boolean flag;
        if ((i & 0xff) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            outputstream.write(abyte0.length);
            outputstream.write(abyte0);
            return;
        }
    }

    public static boolean _mth02CB(TlsContext tlscontext)
    {
        return tlscontext._mth0455() == ProtocolVersion.aAF;
    }

    public static int[] _mth02CB(int i, ByteArrayInputStream bytearrayinputstream)
    {
        int ai[] = new int[i];
        for (int j = 0; j < i; j++)
        {
            int k = bytearrayinputstream.read();
            int l = bytearrayinputstream.read();
            if (l < 0)
            {
                throw new EOFException();
            }
            ai[j] = k << 8 | l;
        }

        return ai;
    }

    public static void _mth02CE(int i, OutputStream outputstream)
    {
        outputstream.write(i);
    }

    public static void _mth02CE(long l, byte abyte0[], int i)
    {
        abyte0[i] = (byte)(int)(l >>> 56);
        abyte0[i + 1] = (byte)(int)(l >>> 48);
        abyte0[i + 2] = (byte)(int)(l >>> 40);
        abyte0[i + 3] = (byte)(int)(l >>> 32);
        abyte0[i + 4] = (byte)(int)(l >>> 24);
        abyte0[i + 5] = (byte)(int)(l >>> 16);
        abyte0[i + 6] = (byte)(int)(l >>> 8);
        abyte0[i + 7] = (byte)(int)l;
    }

    public static void _mth02CE(byte abyte0[], OutputStream outputstream)
    {
        int i = abyte0.length;
        boolean flag;
        if ((i & 0xffff) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            int j = abyte0.length;
            outputstream.write(j >>> 8);
            outputstream.write(j);
            outputstream.write(abyte0);
            return;
        }
    }

    public static boolean _mth02CE(ProtocolVersion protocolversion)
    {
        return ProtocolVersion.aAI._mth02CB(protocolversion._mth0993());
    }

    public static boolean _mth02CE(TlsContext tlscontext)
    {
        return ProtocolVersion.aAH._mth02CB(tlscontext._mth0455()._mth0993());
    }

    public static byte[] _mth02CE(int i, InputStream inputstream)
    {
        byte abyte0[] = new byte[5];
        i = Streams._mth02CB(inputstream, abyte0);
        if (i == 0)
        {
            return null;
        }
        if (i != 5)
        {
            throw new EOFException();
        } else
        {
            return abyte0;
        }
    }

    public static void _mth02CF(int i, OutputStream outputstream)
    {
        outputstream.write(i >>> 8);
        outputstream.write(i);
    }

    public static void _mth02CF(byte abyte0[], OutputStream outputstream)
    {
        int i = abyte0.length;
        boolean flag;
        if ((i & 0xffffff) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            int j = abyte0.length;
            outputstream.write((byte)(j >>> 16));
            outputstream.write((byte)(j >>> 8));
            outputstream.write((byte)j);
            outputstream.write(abyte0);
            return;
        }
    }

    public static boolean _mth02CF(TlsContext tlscontext)
    {
        return ProtocolVersion.aAI._mth02CB(tlscontext._mth0455()._mth0993());
    }

    public static byte[] _mth02CF(int i, InputStream inputstream)
    {
        if (i <= 0)
        {
            return WQ;
        }
        byte abyte0[] = new byte[i];
        if (i != Streams._mth02CB(inputstream, abyte0))
        {
            throw new EOFException();
        } else
        {
            return abyte0;
        }
    }

    public static int _mth037A(InputStream inputstream)
    {
        int i = inputstream.read();
        int j = inputstream.read();
        if (j < 0)
        {
            throw new EOFException();
        } else
        {
            return i << 8 | j;
        }
    }

    public static ASN1ObjectIdentifier _mth037A(short word0)
    {
        switch (word0)
        {
        case 1: // '\001'
            return PKCSObjectIdentifiers.abC;

        case 2: // '\002'
            return X509ObjectIdentifiers.akD;

        case 3: // '\003'
            return NISTObjectIdentifiers.ZG;

        case 4: // '\004'
            return NISTObjectIdentifiers.ZD;

        case 5: // '\005'
            return NISTObjectIdentifiers.ZE;

        case 6: // '\006'
            return NISTObjectIdentifiers.ZF;
        }
        throw new IllegalArgumentException("unknown HashAlgorithm");
    }

    public static void _mth05D6(int i)
    {
        if ((i & 0xff) == i)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return;
        }
    }

    public static short _mth05D9(byte abyte0[], int i)
    {
        return (short)abyte0[i];
    }

    public static void _mth05DF(int i)
    {
        if ((i & 0xffff) == i)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return;
        }
    }

    public static void _mth05E0(int i)
    {
        if ((i & 0xffffff) == i)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return;
        }
    }

    public static short _mth05E8(int i)
    {
        switch (i)
        {
        case 0: // '\0'
            throw new IllegalArgumentException("legacy PRF not a valid algorithm");

        case 1: // '\001'
            return 4;

        case 2: // '\002'
            return 5;
        }
        throw new IllegalArgumentException("unknown PRFAlgorithm");
    }

    public static boolean _mth062F(int i)
    {
        switch (i)
        {
        case 10: // '\n'
        case 13: // '\r'
        case 16: // '\020'
        case 19: // '\023'
        case 22: // '\026'
        case 139: 
        case 143: 
        case 147: 
        case 49155: 
        case 49160: 
        case 49165: 
        case 49170: 
        case 49178: 
        case 49179: 
        case 49180: 
        case 49204: 
            i = 7;
            break;

        case 52243: 
        case 52244: 
        case 52245: 
            i = 102;
            break;

        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 140: 
        case 144: 
        case 148: 
        case 49156: 
        case 49161: 
        case 49166: 
        case 49171: 
        case 49181: 
        case 49182: 
        case 49183: 
        case 49205: 
            i = 8;
            break;

        case 60: // '<'
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 103: // 'g'
        case 174: 
        case 178: 
        case 182: 
        case 49187: 
        case 49189: 
        case 49191: 
        case 49193: 
        case 49207: 
            i = 8;
            break;

        case 49308: 
        case 49310: 
        case 49316: 
        case 49318: 
            i = 15;
            break;

        case 49312: 
        case 49314: 
        case 49320: 
        case 49322: 
            i = 16;
            break;

        case 156: 
        case 158: 
        case 160: 
        case 162: 
        case 164: 
        case 168: 
        case 170: 
        case 172: 
        case 49195: 
        case 49197: 
        case 49199: 
        case 49201: 
            i = 10;
            break;

        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 141: 
        case 145: 
        case 149: 
        case 49157: 
        case 49162: 
        case 49167: 
        case 49172: 
        case 49184: 
        case 49185: 
        case 49186: 
        case 49206: 
            i = 9;
            break;

        case 61: // '='
        case 104: // 'h'
        case 105: // 'i'
        case 106: // 'j'
        case 107: // 'k'
            i = 9;
            break;

        case 175: 
        case 179: 
        case 183: 
        case 49188: 
        case 49190: 
        case 49192: 
        case 49194: 
        case 49208: 
            i = 9;
            break;

        case 49309: 
        case 49311: 
        case 49317: 
        case 49319: 
            i = 17;
            break;

        case 49313: 
        case 49315: 
        case 49321: 
        case 49323: 
            i = 18;
            break;

        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 169: 
        case 171: 
        case 173: 
        case 49196: 
        case 49198: 
        case 49200: 
        case 49202: 
            i = 11;
            break;

        case 65: // 'A'
        case 66: // 'B'
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
            i = 12;
            break;

        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 49266: 
        case 49268: 
        case 49270: 
        case 49272: 
        case 49300: 
        case 49302: 
        case 49304: 
        case 49306: 
            i = 12;
            break;

        case 49274: 
        case 49276: 
        case 49278: 
        case 49280: 
        case 49282: 
        case 49286: 
        case 49288: 
        case 49290: 
        case 49292: 
        case 49294: 
        case 49296: 
        case 49298: 
            i = 19;
            break;

        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
            i = 13;
            break;

        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
            i = 13;
            break;

        case 49267: 
        case 49269: 
        case 49271: 
        case 49273: 
        case 49301: 
        case 49303: 
        case 49305: 
        case 49307: 
            i = 13;
            break;

        case 49275: 
        case 49277: 
        case 49279: 
        case 49281: 
        case 49283: 
        case 49287: 
        case 49289: 
        case 49291: 
        case 49293: 
        case 49295: 
        case 49297: 
        case 49299: 
            i = 20;
            break;

        case 58384: 
        case 58386: 
        case 58388: 
        case 58390: 
        case 58392: 
        case 58394: 
        case 58396: 
        case 58398: 
            i = 100;
            break;

        case 1: // '\001'
            i = 0;
            break;

        case 2: // '\002'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 49153: 
        case 49158: 
        case 49163: 
        case 49168: 
        case 49209: 
            i = 0;
            break;

        case 59: // ';'
        case 176: 
        case 180: 
        case 184: 
        case 49210: 
            i = 0;
            break;

        case 177: 
        case 181: 
        case 185: 
        case 49211: 
            i = 0;
            break;

        case 4: // '\004'
        case 24: // '\030'
            i = 2;
            break;

        case 5: // '\005'
        case 138: 
        case 142: 
        case 146: 
        case 49154: 
        case 49159: 
        case 49164: 
        case 49169: 
        case 49174: 
        case 49203: 
            i = 2;
            break;

        case 58385: 
        case 58387: 
        case 58389: 
        case 58391: 
        case 58393: 
        case 58395: 
        case 58397: 
        case 58399: 
            i = 101;
            break;

        case 150: 
        case 151: 
        case 152: 
        case 153: 
        case 154: 
            i = 14;
            break;

        default:
            throw new TlsFatalAlert((short)80);
        }
        switch (i)
        {
        case 10: // '\n'
        case 11: // '\013'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 102: // 'f'
            i = 2;
            break;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            i = 1;
            break;

        case 1: // '\001'
        case 2: // '\002'
        case 100: // 'd'
        case 101: // 'e'
            i = 0;
            break;

        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 65: // 'A'
        case 66: // 'B'
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
        case 70: // 'F'
        case 71: // 'G'
        case 72: // 'H'
        case 73: // 'I'
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
        case 77: // 'M'
        case 78: // 'N'
        case 79: // 'O'
        case 80: // 'P'
        case 81: // 'Q'
        case 82: // 'R'
        case 83: // 'S'
        case 84: // 'T'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 92: // '\\'
        case 93: // ']'
        case 94: // '^'
        case 95: // '_'
        case 96: // '`'
        case 97: // 'a'
        case 98: // 'b'
        case 99: // 'c'
        default:
            throw new TlsFatalAlert((short)80);
        }
        return 1 == i;
    }

    public static int _mth0674(byte abyte0[], int i)
    {
        return (abyte0[3] & 0xff) << 8 | abyte0[4] & 0xff;
    }

    static short _mth141D(org.spongycastle.crypto.tls.Certificate certificate)
    {
        Object obj;
        if (certificate.isEmpty())
        {
            return -1;
        }
        certificate = certificate._mth0130(0);
        obj = ((Certificate) (certificate)).air.ajP;
        obj = PublicKeyFactory._mth02CA(((org.spongycastle.asn1.x509.SubjectPublicKeyInfo) (obj)));
        if (((AsymmetricKeyParameter) (obj)).awQ)
        {
            throw new TlsFatalAlert((short)80);
        }
        if (!(obj instanceof RSAKeyParameters))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        _mth02CA(certificate, 128);
        return 1;
        if (!(obj instanceof DSAPublicKeyParameters))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        _mth02CA(certificate, 128);
        return 2;
        if (!(obj instanceof ECPublicKeyParameters))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        _mth02CA(certificate, 128);
        return 64;
_L2:
        throw new TlsFatalAlert((short)43);
        certificate;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void _mth141D(int i, OutputStream outputstream)
    {
        outputstream.write((byte)(i >>> 16));
        outputstream.write((byte)(i >>> 8));
        outputstream.write((byte)i);
    }

    private static byte[] _mth141D(byte abyte0[], byte abyte1[], int i)
    {
        int j = (abyte0.length + 1) / 2;
        byte abyte2[] = new byte[j];
        byte abyte3[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte2, 0, j);
        System.arraycopy(abyte0, abyte0.length - j, abyte3, 0, j);
        abyte0 = new byte[i];
        byte abyte4[] = new byte[i];
        _mth02CB(_mth02BD((short)1), abyte2, abyte1, abyte0);
        _mth02CB(_mth02BD((short)2), abyte3, abyte1, abyte4);
        for (int k = 0; k < i; k++)
        {
            abyte0[k] = (byte)(abyte0[k] ^ abyte4[k]);
        }

        return abyte0;
    }

    public static Vector _mth14B5()
    {
        SignatureAndHashAlgorithm signatureandhashalgorithm = new SignatureAndHashAlgorithm((short)2, (short)2);
        Vector vector = new Vector(1);
        vector.addElement(signatureandhashalgorithm);
        return vector;
    }

    public static Vector _mth14B8()
    {
        SignatureAndHashAlgorithm signatureandhashalgorithm = new SignatureAndHashAlgorithm((short)2, (short)3);
        Vector vector = new Vector(1);
        vector.addElement(signatureandhashalgorithm);
        return vector;
    }

    public static Vector _mth14B9()
    {
        SignatureAndHashAlgorithm signatureandhashalgorithm = new SignatureAndHashAlgorithm((short)2, (short)1);
        Vector vector = new Vector(1);
        vector.addElement(signatureandhashalgorithm);
        return vector;
    }

    public static ProtocolVersion _mth1D35(byte abyte0[], int i)
    {
        return ProtocolVersion._mth15EE(abyte0[1] & 0xff, abyte0[2] & 0xff);
    }

    public static byte[] _mth1D36(byte abyte0[])
    {
        int i = abyte0.length;
        boolean flag;
        if ((i & 0xff) == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return Arrays._mth02CB(abyte0, (byte)abyte0.length);
        }
    }

    public static ASN1Primitive _mth1D38(byte abyte0[])
    {
        ASN1InputStream asn1inputstream = new ASN1InputStream(abyte0);
        ASN1Primitive asn1primitive = asn1inputstream._mth04B7();
        if (asn1primitive == null)
        {
            throw new TlsFatalAlert((short)50);
        }
        if (asn1inputstream._mth04B7() != null)
        {
            throw new TlsFatalAlert((short)50);
        }
        if (!Arrays._mth1427(asn1primitive.getEncoded("DER"), abyte0))
        {
            throw new TlsFatalAlert((short)50);
        } else
        {
            return asn1primitive;
        }
    }

    public static int _mth1D4E(byte abyte0[], int i)
    {
        return abyte0[1] << 8 | abyte0[2];
    }

    public static int _mth1FBE(InputStream inputstream)
    {
        int i = inputstream.read();
        int j = inputstream.read();
        int k = inputstream.read();
        if (k < 0)
        {
            throw new EOFException();
        } else
        {
            return i << 16 | j << 8 | k;
        }
    }

    public static boolean _mth1FBE(short word0)
    {
        switch (word0)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 64: // '@'
            return true;
        }
        return false;
    }

    static 
    {
        byte abyte0[][] = new byte[10][];
        for (int i = 0; i < 10; i++)
        {
            byte abyte1[] = new byte[i + 1];
            Arrays.fill(abyte1, (byte)(i + 65));
            abyte0[i] = abyte1;
        }

        aCC = abyte0;
    }
}
