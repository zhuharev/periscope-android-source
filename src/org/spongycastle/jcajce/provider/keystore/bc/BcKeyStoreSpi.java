// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.io.DigestInputStream;
import org.spongycastle.crypto.io.DigestOutputStream;
import org.spongycastle.crypto.io.MacInputStream;
import org.spongycastle.crypto.io.MacOutputStream;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;
import org.spongycastle.util.io.TeeOutputStream;

public class BcKeyStoreSpi extends KeyStoreSpi
    implements BCKeyStore
{
    public static class BouncyCastleStore extends BcKeyStoreSpi
    {

        public void engineLoad(InputStream inputstream, char ac[])
        {
            aiq.clear();
            if (inputstream == null)
            {
                return;
            }
            Object obj = new DataInputStream(inputstream);
            int i = ((DataInputStream) (obj)).readInt();
            if (i != 2 && i != 0 && i != 1)
            {
                throw new IOException("Wrong version of key store.");
            }
            byte abyte1[] = new byte[((DataInputStream) (obj)).readInt()];
            if (abyte1.length != 20)
            {
                throw new IOException("Key store corrupted.");
            }
            ((DataInputStream) (obj)).readFully(abyte1);
            int j = ((DataInputStream) (obj)).readInt();
            if (j < 0 || j > 4096)
            {
                throw new IOException("Key store corrupted.");
            }
            if (i == 0)
            {
                inputstream = "OldPBEWithSHAAndTwofish-CBC";
            } else
            {
                inputstream = "PBEWithSHAAndTwofish-CBC";
            }
            inputstream = new CipherInputStream(((InputStream) (obj)), _mth02CA(inputstream, 2, ac, abyte1, j));
            obj = new SHA1Digest();
            _mth02CA(new DigestInputStream(inputstream, ((SHA1Digest) (obj))));
            ac = new byte[((Digest) (obj))._mth14AF()];
            ((Digest) (obj)).doFinal(ac, 0);
            byte abyte0[] = new byte[((Digest) (obj))._mth14AF()];
            Streams._mth02CB(inputstream, abyte0);
            if (!Arrays._mth1428(ac, abyte0))
            {
                aiq.clear();
                throw new IOException("KeyStore integrity check failed.");
            } else
            {
                return;
            }
        }

        public void engineStore(OutputStream outputstream, char ac[])
        {
            outputstream = new DataOutputStream(outputstream);
            byte abyte0[] = new byte[20];
            int i = (amC.nextInt() & 0x3ff) + 1024;
            amC.nextBytes(abyte0);
            outputstream.writeInt(version);
            outputstream.writeInt(20);
            outputstream.write(abyte0);
            outputstream.writeInt(i);
            outputstream = new CipherOutputStream(outputstream, _mth02CA("PBEWithSHAAndTwofish-CBC", 1, ac, abyte0, i));
            ac = new DigestOutputStream(new SHA1Digest());
            _mth02CA(new TeeOutputStream(outputstream, ac));
            outputstream.write(ac.FF97());
            outputstream.close();
        }

        public BouncyCastleStore()
        {
            super(1);
        }
    }

    public static class Std extends BcKeyStoreSpi
    {

        public Std()
        {
            super(2);
        }
    }

    class StoreEntry
    {

        String aEY;
        Certificate aEZ[];
        Date aFa;
        private BcKeyStoreSpi aFb;
        Object obj;
        int type;

        final Object _mth141D(char ac[])
        {
            if ((ac == null || ac.length == 0) && (obj instanceof Key))
            {
                return obj;
            }
            if (type != 4) goto _L2; else goto _L1
_L1:
            Object obj1 = new DataInputStream(new ByteArrayInputStream((byte[])obj));
            byte abyte1[];
            ByteArrayOutputStream bytearrayoutputstream;
            DataOutputStream dataoutputstream;
            int i;
            try
            {
                byte abyte0[] = new byte[((DataInputStream) (obj1)).readInt()];
                ((DataInputStream) (obj1)).readFully(abyte0);
                obj1 = new CipherInputStream(((InputStream) (obj1)), BcKeyStoreSpi._mth02CA("PBEWithSHAAnd3-KeyTripleDES-CBC", 2, ac, abyte0, ((DataInputStream) (obj1)).readInt()));
            }
            // Misplaced declaration of an exception variable
            catch (char ac[])
            {
                throw new UnrecoverableKeyException("no match");
            }
            obj1 = BcKeyStoreSpi._mth02CA(aFb, new DataInputStream(((InputStream) (obj1))));
            return obj1;
_L4:
            obj1 = new DataInputStream(new ByteArrayInputStream((byte[])obj));
            abyte1 = new byte[((DataInputStream) (obj1)).readInt()];
            ((DataInputStream) (obj1)).readFully(abyte1);
            i = ((DataInputStream) (obj1)).readInt();
            obj1 = new CipherInputStream(((InputStream) (obj1)), BcKeyStoreSpi._mth02CA("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, ac, abyte1, i));
            obj1 = BcKeyStoreSpi._mth02CA(aFb, new DataInputStream(((InputStream) (obj1))));
              goto _L3
_L5:
            obj1 = new DataInputStream(new ByteArrayInputStream((byte[])obj));
            abyte1 = new byte[((DataInputStream) (obj1)).readInt()];
            ((DataInputStream) (obj1)).readFully(abyte1);
            i = ((DataInputStream) (obj1)).readInt();
            obj1 = new CipherInputStream(((InputStream) (obj1)), BcKeyStoreSpi._mth02CA("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, ac, abyte1, i));
            obj1 = BcKeyStoreSpi._mth02CA(aFb, new DataInputStream(((InputStream) (obj1))));
_L3:
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_353;
            }
            bytearrayoutputstream = new ByteArrayOutputStream();
            dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            dataoutputstream.writeInt(abyte1.length);
            dataoutputstream.write(abyte1);
            dataoutputstream.writeInt(i);
            ac = new DataOutputStream(new CipherOutputStream(dataoutputstream, BcKeyStoreSpi._mth02CA("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, ac, abyte1, i)));
            BcKeyStoreSpi._mth02CA(aFb, ((Key) (obj1)), ac);
            ac.close();
            obj = bytearrayoutputstream.toByteArray();
            return obj1;
            throw new UnrecoverableKeyException("no match");
_L2:
            throw new RuntimeException("forget something!");
            Exception exception;
            exception;
              goto _L4
            exception;
              goto _L5
        }

        StoreEntry(String s, Key key, char ac[], Certificate acertificate[])
        {
            aFb = BcKeyStoreSpi.this;
            super();
            aFa = new Date();
            type = 4;
            aEY = s;
            aEZ = acertificate;
            acertificate = new byte[20];
            amC.setSeed(System.currentTimeMillis());
            amC.nextBytes(acertificate);
            int i = (amC.nextInt() & 0x3ff) + 1024;
            s = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(s);
            dataoutputstream.writeInt(20);
            dataoutputstream.write(acertificate);
            dataoutputstream.writeInt(i);
            ac = new DataOutputStream(new CipherOutputStream(dataoutputstream, BcKeyStoreSpi._mth02CA("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, ac, acertificate, i)));
            BcKeyStoreSpi._mth02CA(BcKeyStoreSpi.this, key, ac);
            ac.close();
            obj = s.toByteArray();
        }

        StoreEntry(String s, Certificate certificate)
        {
            aFb = BcKeyStoreSpi.this;
            super();
            aFa = new Date();
            type = 1;
            aEY = s;
            obj = certificate;
            aEZ = null;
        }

        StoreEntry(String s, Date date, int i, Object obj1, Certificate acertificate[])
        {
            aFb = BcKeyStoreSpi.this;
            super();
            aFa = new Date();
            aEY = s;
            aFa = date;
            type = i;
            obj = obj1;
            aEZ = acertificate;
        }

        StoreEntry(String s, Date date, int i, Certificate certificate)
        {
            aFb = BcKeyStoreSpi.this;
            super();
            aFa = new Date();
            aEY = s;
            aFa = date;
            type = 1;
            obj = certificate;
        }

        StoreEntry(String s, byte abyte0[], Certificate acertificate[])
        {
            aFb = BcKeyStoreSpi.this;
            super();
            aFa = new Date();
            type = 3;
            aEY = s;
            obj = abyte0;
            aEZ = acertificate;
        }
    }

    public static class Version1 extends BcKeyStoreSpi
    {

        public Version1()
        {
            super(1);
        }
    }


    protected Hashtable aiq;
    protected SecureRandom amC;
    protected int version;

    public BcKeyStoreSpi(int i)
    {
        aiq = new Hashtable();
        amC = new SecureRandom();
        version = i;
    }

    static Key _mth02CA(BcKeyStoreSpi bckeystorespi, DataInputStream datainputstream)
    {
        return _mth02CB(datainputstream);
    }

    private static Certificate _mth02CA(DataInputStream datainputstream)
    {
        String s = datainputstream.readUTF();
        byte abyte0[] = new byte[datainputstream.readInt()];
        datainputstream.readFully(abyte0);
        try
        {
            datainputstream = CertificateFactory.getInstance(s, "SC").generateCertificate(new ByteArrayInputStream(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (DataInputStream datainputstream)
        {
            throw new IOException(datainputstream.toString());
        }
        // Misplaced declaration of an exception variable
        catch (DataInputStream datainputstream)
        {
            throw new IOException(datainputstream.toString());
        }
        return datainputstream;
    }

    protected static Cipher _mth02CA(String s, int i, char ac[], byte abyte0[], int j)
    {
        try
        {
            ac = new PBEKeySpec(ac);
            SecretKeyFactory secretkeyfactory = SecretKeyFactory.getInstance(s, "SC");
            abyte0 = new PBEParameterSpec(abyte0, j);
            s = Cipher.getInstance(s, "SC");
            s.init(i, secretkeyfactory.generateSecret(ac), abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IOException((new StringBuilder("Error initialising store of key store: ")).append(s).toString());
        }
        return s;
    }

    private static void _mth02CA(Key key, DataOutputStream dataoutputstream)
    {
        byte abyte0[] = key.getEncoded();
        if (key instanceof PrivateKey)
        {
            dataoutputstream.write(0);
        } else
        if (key instanceof PublicKey)
        {
            dataoutputstream.write(1);
        } else
        {
            dataoutputstream.write(2);
        }
        dataoutputstream.writeUTF(key.getFormat());
        dataoutputstream.writeUTF(key.getAlgorithm());
        dataoutputstream.writeInt(abyte0.length);
        dataoutputstream.write(abyte0);
    }

    private static void _mth02CA(Certificate certificate, DataOutputStream dataoutputstream)
    {
        try
        {
            byte abyte0[] = certificate.getEncoded();
            dataoutputstream.writeUTF(certificate.getType());
            dataoutputstream.writeInt(abyte0.length);
            dataoutputstream.write(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Certificate certificate)
        {
            throw new IOException(certificate.toString());
        }
    }

    static void _mth02CA(BcKeyStoreSpi bckeystorespi, Key key, DataOutputStream dataoutputstream)
    {
        _mth02CA(key, dataoutputstream);
    }

    private static Key _mth02CB(DataInputStream datainputstream)
    {
        String s;
        int i;
        i = datainputstream.read();
        String s1 = datainputstream.readUTF();
        s = datainputstream.readUTF();
        byte abyte0[] = new byte[datainputstream.readInt()];
        datainputstream.readFully(abyte0);
        if (s1.equals("PKCS#8") || s1.equals("PKCS8"))
        {
            datainputstream = new PKCS8EncodedKeySpec(abyte0);
        } else
        if (s1.equals("X.509") || s1.equals("X509"))
        {
            datainputstream = new X509EncodedKeySpec(abyte0);
        } else
        if (s1.equals("RAW"))
        {
            return new SecretKeySpec(abyte0, s);
        } else
        {
            throw new IOException((new StringBuilder("Key format ")).append(s1).append(" not recognised!").toString());
        }
        i;
        JVM INSTR tableswitch 0 2: default 164
    //                   0 167
    //                   1 180
    //                   2 193;
           goto _L1 _L2 _L3 _L4
_L2:
        try
        {
            datainputstream = KeyFactory.getInstance(s, "SC").generatePrivate(datainputstream);
        }
        // Misplaced declaration of an exception variable
        catch (DataInputStream datainputstream)
        {
            throw new IOException((new StringBuilder("Exception creating key: ")).append(datainputstream.toString()).toString());
        }
        return datainputstream;
_L3:
        datainputstream = KeyFactory.getInstance(s, "SC").generatePublic(datainputstream);
        return datainputstream;
_L4:
        datainputstream = SecretKeyFactory.getInstance(s, "SC").generateSecret(datainputstream);
        return datainputstream;
_L1:
        throw new IOException((new StringBuilder("Key type ")).append(i).append(" not recognised!").toString());
    }

    public Enumeration engineAliases()
    {
        return aiq.keys();
    }

    public boolean engineContainsAlias(String s)
    {
        return aiq.get(s) != null;
    }

    public void engineDeleteEntry(String s)
    {
        if (aiq.get(s) == null)
        {
            return;
        } else
        {
            aiq.remove(s);
            return;
        }
    }

    public Certificate engineGetCertificate(String s)
    {
        s = (StoreEntry)aiq.get(s);
        if (s != null)
        {
            if (((StoreEntry) (s)).type == 1)
            {
                return (Certificate)((StoreEntry) (s)).obj;
            }
            s = ((StoreEntry) (s)).aEZ;
            if (s != null)
            {
                return s[0];
            }
        }
        return null;
    }

    public String engineGetCertificateAlias(Certificate certificate)
    {
        for (Enumeration enumeration = aiq.elements(); enumeration.hasMoreElements();)
        {
            StoreEntry storeentry = (StoreEntry)enumeration.nextElement();
            if (storeentry.obj instanceof Certificate)
            {
                if (((Certificate)storeentry.obj).equals(certificate))
                {
                    return storeentry.aEY;
                }
            } else
            {
                Certificate acertificate[] = storeentry.aEZ;
                if (acertificate != null && acertificate[0].equals(certificate))
                {
                    return storeentry.aEY;
                }
            }
        }

        return null;
    }

    public Certificate[] engineGetCertificateChain(String s)
    {
        s = (StoreEntry)aiq.get(s);
        if (s != null)
        {
            return ((StoreEntry) (s)).aEZ;
        } else
        {
            return null;
        }
    }

    public Date engineGetCreationDate(String s)
    {
        s = (StoreEntry)aiq.get(s);
        if (s != null)
        {
            return ((StoreEntry) (s)).aFa;
        } else
        {
            return null;
        }
    }

    public Key engineGetKey(String s, char ac[])
    {
        s = (StoreEntry)aiq.get(s);
        if (s == null || ((StoreEntry) (s)).type == 1)
        {
            return null;
        } else
        {
            return (Key)s._mth141D(ac);
        }
    }

    public boolean engineIsCertificateEntry(String s)
    {
        s = (StoreEntry)aiq.get(s);
        return s != null && ((StoreEntry) (s)).type == 1;
    }

    public boolean engineIsKeyEntry(String s)
    {
        s = (StoreEntry)aiq.get(s);
        return s != null && ((StoreEntry) (s)).type != 1;
    }

    public void engineLoad(InputStream inputstream, char ac[])
    {
        aiq.clear();
        if (inputstream == null)
        {
            return;
        }
        DataInputStream datainputstream = new DataInputStream(inputstream);
        int i = datainputstream.readInt();
        if (i != 2 && i != 0 && i != 1)
        {
            throw new IOException("Wrong version of key store.");
        }
        int j = datainputstream.readInt();
        if (j <= 0)
        {
            throw new IOException("Invalid salt detected");
        }
        inputstream = new byte[j];
        datainputstream.readFully(inputstream);
        j = datainputstream.readInt();
        HMac hmac = new HMac(new SHA1Digest());
        if (ac != null && ac.length != 0)
        {
            ac = PBEParametersGenerator._mth02CF(ac);
            PKCS12ParametersGenerator pkcs12parametersgenerator = new PKCS12ParametersGenerator(new SHA1Digest());
            pkcs12parametersgenerator._mth02CA(ac, inputstream, j);
            if (i != 2)
            {
                inputstream = pkcs12parametersgenerator._mth1D52(hmac.auN);
            } else
            {
                inputstream = pkcs12parametersgenerator._mth1D52(hmac.auN << 3);
            }
            Arrays.fill(ac, (byte)0);
            hmac._mth02CA(inputstream);
            _mth02CA(new MacInputStream(datainputstream, hmac));
            inputstream = new byte[hmac.auN];
            hmac.doFinal(inputstream, 0);
            ac = new byte[hmac.auN];
            datainputstream.readFully(ac);
            if (!Arrays._mth1428(inputstream, ac))
            {
                aiq.clear();
                throw new IOException("KeyStore integrity check failed.");
            } else
            {
                return;
            }
        } else
        {
            _mth02CA(datainputstream);
            datainputstream.readFully(new byte[hmac.auN]);
            return;
        }
    }

    public void engineSetCertificateEntry(String s, Certificate certificate)
    {
        StoreEntry storeentry = (StoreEntry)aiq.get(s);
        if (storeentry != null && storeentry.type != 1)
        {
            throw new KeyStoreException((new StringBuilder("key store already has a key entry with alias ")).append(s).toString());
        } else
        {
            aiq.put(s, new StoreEntry(s, certificate));
            return;
        }
    }

    public void engineSetKeyEntry(String s, Key key, char ac[], Certificate acertificate[])
    {
        if ((key instanceof PrivateKey) && acertificate == null)
        {
            throw new KeyStoreException("no certificate chain for private key");
        }
        try
        {
            aiq.put(s, new StoreEntry(s, key, ac, acertificate));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new KeyStoreException(s.toString());
        }
    }

    public void engineSetKeyEntry(String s, byte abyte0[], Certificate acertificate[])
    {
        aiq.put(s, new StoreEntry(s, abyte0, acertificate));
    }

    public int engineSize()
    {
        return aiq.size();
    }

    public void engineStore(OutputStream outputstream, char ac[])
    {
        outputstream = new DataOutputStream(outputstream);
        byte abyte0[] = new byte[20];
        int i = (amC.nextInt() & 0x3ff) + 1024;
        amC.nextBytes(abyte0);
        outputstream.writeInt(version);
        outputstream.writeInt(20);
        outputstream.write(abyte0);
        outputstream.writeInt(i);
        HMac hmac = new HMac(new SHA1Digest());
        MacOutputStream macoutputstream = new MacOutputStream(hmac);
        PKCS12ParametersGenerator pkcs12parametersgenerator = new PKCS12ParametersGenerator(new SHA1Digest());
        ac = PBEParametersGenerator._mth02CF(ac);
        pkcs12parametersgenerator._mth02CA(ac, abyte0, i);
        if (version < 2)
        {
            hmac._mth02CA(pkcs12parametersgenerator._mth1D52(hmac.auN));
        } else
        {
            hmac._mth02CA(pkcs12parametersgenerator._mth1D52(hmac.auN << 3));
        }
        for (int j = 0; j != ac.length; j++)
        {
            ac[j] = '\0';
        }

        _mth02CA(new TeeOutputStream(outputstream, macoutputstream));
        ac = new byte[hmac.auN];
        hmac.doFinal(ac, 0);
        outputstream.write(ac);
        outputstream.close();
    }

    protected final void _mth02CA(FilterInputStream filterinputstream)
    {
        DataInputStream datainputstream = new DataInputStream(filterinputstream);
        for (int i = datainputstream.read(); i > 0; i = datainputstream.read())
        {
            String s = datainputstream.readUTF();
            Date date = new Date(datainputstream.readLong());
            int k = datainputstream.readInt();
            filterinputstream = null;
            if (k != 0)
            {
                Certificate acertificate[] = new Certificate[k];
                int j = 0;
                do
                {
                    filterinputstream = acertificate;
                    if (j == k)
                    {
                        break;
                    }
                    acertificate[j] = _mth02CA(datainputstream);
                    j++;
                } while (true);
            }
            switch (i)
            {
            case 1: // '\001'
                filterinputstream = _mth02CA(datainputstream);
                aiq.put(s, new StoreEntry(s, date, 1, filterinputstream));
                break;

            case 2: // '\002'
                Key key = _mth02CB(datainputstream);
                aiq.put(s, new StoreEntry(s, date, 2, key, filterinputstream));
                break;

            case 3: // '\003'
            case 4: // '\004'
                byte abyte0[] = new byte[datainputstream.readInt()];
                datainputstream.readFully(abyte0);
                aiq.put(s, new StoreEntry(s, date, i, abyte0, filterinputstream));
                break;

            default:
                throw new RuntimeException("Unknown object type in store.");
            }
        }

    }

    protected final void _mth02CA(TeeOutputStream teeoutputstream)
    {
        Enumeration enumeration = aiq.elements();
        teeoutputstream = new DataOutputStream(teeoutputstream);
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break;
            }
            StoreEntry storeentry = (StoreEntry)enumeration.nextElement();
            teeoutputstream.write(storeentry.type);
            teeoutputstream.writeUTF(storeentry.aEY);
            teeoutputstream.writeLong(storeentry.aFa.getTime());
            Certificate acertificate[] = storeentry.aEZ;
            if (acertificate == null)
            {
                teeoutputstream.writeInt(0);
            } else
            {
                teeoutputstream.writeInt(acertificate.length);
                for (int i = 0; i != acertificate.length; i++)
                {
                    _mth02CA(acertificate[i], ((DataOutputStream) (teeoutputstream)));
                }

            }
            switch (storeentry.type)
            {
            case 1: // '\001'
                _mth02CA((Certificate)storeentry.obj, ((DataOutputStream) (teeoutputstream)));
                break;

            case 2: // '\002'
                _mth02CA((Key)storeentry.obj, ((DataOutputStream) (teeoutputstream)));
                break;

            case 3: // '\003'
            case 4: // '\004'
                byte abyte0[] = (byte[])storeentry.obj;
                teeoutputstream.writeInt(abyte0.length);
                teeoutputstream.write(abyte0);
                break;

            default:
                throw new RuntimeException("Unknown object type in store.");
            }
        } while (true);
        teeoutputstream.write(0);
    }
}
