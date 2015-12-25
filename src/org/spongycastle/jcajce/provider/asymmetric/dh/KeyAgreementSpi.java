// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.dh:
//            BCDHPublicKey

public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi
{

    private static final Hashtable aCU;
    private BigInteger aCT;
    private BigInteger amM;
    private BigInteger amO;
    private BigInteger amZ;

    public KeyAgreementSpi()
    {
    }

    private byte[] _mth141D(BigInteger biginteger)
    {
        int i = (amM.bitLength() + 7) / 8;
        biginteger = biginteger.toByteArray();
        if (biginteger.length == i)
        {
            return biginteger;
        }
        if (biginteger[0] == 0 && biginteger.length == i + 1)
        {
            byte abyte0[] = new byte[biginteger.length - 1];
            System.arraycopy(biginteger, 1, abyte0, 0, abyte0.length);
            return abyte0;
        } else
        {
            byte abyte1[] = new byte[i];
            System.arraycopy(biginteger, 0, abyte1, i - biginteger.length, biginteger.length);
            return abyte1;
        }
    }

    protected Key engineDoPhase(Key key, boolean flag)
    {
        if (amZ == null)
        {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        if (!(key instanceof DHPublicKey))
        {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        DHPublicKey dhpublickey = (DHPublicKey)key;
        if (!dhpublickey.getParams().getG().equals(amO) || !dhpublickey.getParams().getP().equals(amM))
        {
            throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
        }
        if (flag)
        {
            aCT = ((DHPublicKey)key).getY().modPow(amZ, amM);
            return null;
        } else
        {
            aCT = ((DHPublicKey)key).getY().modPow(amZ, amM);
            return new BCDHPublicKey(aCT, dhpublickey.getParams());
        }
    }

    protected int engineGenerateSecret(byte abyte0[], int i)
    {
        if (amZ == null)
        {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        byte abyte1[] = _mth141D(aCT);
        if (abyte0.length - i < abyte1.length)
        {
            throw new ShortBufferException("DHKeyAgreement - buffer too short");
        } else
        {
            System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
            return abyte1.length;
        }
    }

    protected SecretKey engineGenerateSecret(String s)
    {
        if (amZ == null)
        {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        String s1 = Strings.FE7C(s);
        byte abyte0[] = _mth141D(aCT);
        if (aCU.containsKey(s1))
        {
            byte abyte1[] = new byte[((Integer)aCU.get(s1)).intValue() / 8];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
            if (s1.startsWith("DES"))
            {
                DESParameters._mth1D55(abyte1);
            }
            return new SecretKeySpec(abyte1, s);
        } else
        {
            return new SecretKeySpec(abyte0, s);
        }
    }

    protected byte[] engineGenerateSecret()
    {
        if (amZ == null)
        {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else
        {
            return _mth141D(aCT);
        }
    }

    protected void engineInit(Key key, SecureRandom securerandom)
    {
        if (!(key instanceof DHPrivateKey))
        {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
        } else
        {
            key = (DHPrivateKey)key;
            amM = key.getParams().getP();
            amO = key.getParams().getG();
            key = key.getX();
            aCT = key;
            amZ = key;
            return;
        }
    }

    protected void engineInit(Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(key instanceof DHPrivateKey))
        {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
        }
        key = (DHPrivateKey)key;
        if (algorithmparameterspec != null)
        {
            if (!(algorithmparameterspec instanceof DHParameterSpec))
            {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            algorithmparameterspec = (DHParameterSpec)algorithmparameterspec;
            amM = algorithmparameterspec.getP();
            amO = algorithmparameterspec.getG();
        } else
        {
            amM = key.getParams().getP();
            amO = key.getParams().getG();
        }
        key = key.getX();
        aCT = key;
        amZ = key;
    }

    static 
    {
        aCU = new Hashtable();
        Integer integer = Integers.valueOf(64);
        Integer integer1 = Integers.valueOf(192);
        Integer integer2 = Integers.valueOf(128);
        Integer integer3 = Integers.valueOf(256);
        aCU.put("DES", integer);
        aCU.put("DESEDE", integer1);
        aCU.put("BLOWFISH", integer2);
        aCU.put("AES", integer3);
    }
}
