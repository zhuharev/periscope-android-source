// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.ies;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Arrays;

public class CipherSpi extends javax.crypto.CipherSpi
{
    public static class IES extends CipherSpi
    {

        public IES()
        {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }


    private ByteArrayOutputStream aCM;
    private AlgorithmParameters aCN;
    private IESEngine aDL;
    private IESParameterSpec aDM;
    private Class aDN[] = {
        org/spongycastle/jce/spec/IESParameterSpec
    };
    private int state;

    public CipherSpi(IESEngine iesengine)
    {
        state = -1;
        aCM = new ByteArrayOutputStream();
        aCN = null;
        aDM = null;
        aDL = iesengine;
    }

    protected int engineDoFinal(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (j != 0)
        {
            aCM.write(abyte0, i, j);
        }
        try
        {
            abyte0 = aCM.toByteArray();
            aCM.reset();
            abyte0 = aDL._mth1FBE(abyte0, 0, abyte0.length);
            System.arraycopy(abyte0, 0, abyte1, k, abyte0.length);
            i = abyte0.length;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BadPaddingException(abyte0.getMessage());
        }
        return i;
    }

    protected byte[] engineDoFinal(byte abyte0[], int i, int j)
    {
        if (j != 0)
        {
            aCM.write(abyte0, i, j);
        }
        try
        {
            abyte0 = aCM.toByteArray();
            aCM.reset();
            abyte0 = aDL._mth1FBE(abyte0, 0, abyte0.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BadPaddingException(abyte0.getMessage());
        }
        return abyte0;
    }

    protected int engineGetBlockSize()
    {
        return 0;
    }

    protected byte[] engineGetIV()
    {
        return null;
    }

    protected int engineGetKeySize(Key key)
    {
        if (!(key instanceof IESKey))
        {
            throw new IllegalArgumentException("must be passed IE key");
        }
        key = (IESKey)key;
        if (key.getPrivate() instanceof DHPrivateKey)
        {
            return ((DHPrivateKey)key.getPrivate()).getX().bitLength();
        }
        if (key.getPrivate() instanceof ECPrivateKey)
        {
            return ((ECPrivateKey)key.getPrivate())._mth15A8().bitLength();
        } else
        {
            throw new IllegalArgumentException("not an IE key!");
        }
    }

    protected int engineGetOutputSize(int i)
    {
        if (state == 1 || state == 3)
        {
            return aCM.size() + i + 20;
        }
        if (state == 2 || state == 4)
        {
            return (aCM.size() + i) - 20;
        } else
        {
            throw new IllegalStateException("cipher not initialised");
        }
    }

    protected AlgorithmParameters engineGetParameters()
    {
        if (aCN == null && aDM != null)
        {
            try
            {
                aCN = AlgorithmParameters.getInstance("IES", "SC");
                aCN.init(aDM);
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception.toString());
            }
        }
        return aCN;
    }

    protected void engineInit(int i, Key key, AlgorithmParameters algorithmparameters, SecureRandom securerandom)
    {
        Exception exception;
        AlgorithmParameterSpec algorithmparameterspec1 = null;
        Object obj = null;
        if (algorithmparameters != null)
        {
            int j = 0;
            AlgorithmParameterSpec algorithmparameterspec;
            do
            {
                algorithmparameterspec = obj;
                if (j == aDN.length)
                {
                    break;
                }
                try
                {
                    algorithmparameterspec = algorithmparameters.getParameterSpec(aDN[j]);
                    break;
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    j++;
                }
            } while (true);
            algorithmparameterspec1 = algorithmparameterspec;
            if (algorithmparameterspec == null)
            {
                throw new InvalidAlgorithmParameterException((new StringBuilder("can't handle parameter ")).append(algorithmparameters.toString()).toString());
            }
        }
        aCN = algorithmparameters;
        engineInit(i, key, algorithmparameterspec1, securerandom);
    }

    protected void engineInit(int i, Key key, SecureRandom securerandom)
    {
        if (i == 1 || i == 3)
        {
            try
            {
                engineInit(i, key, ((AlgorithmParameterSpec) (null)), securerandom);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Key key) { }
        }
        throw new IllegalArgumentException("can't handle null parameter spec in IES");
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmparameterspec, SecureRandom securerandom)
    {
        if (!(key instanceof IESKey))
        {
            throw new InvalidKeyException("must be passed IES key");
        }
        if (algorithmparameterspec == null && (i == 1 || i == 3))
        {
            byte abyte0[] = new byte[16];
            byte abyte1[] = new byte[16];
            algorithmparameterspec = securerandom;
            if (securerandom == null)
            {
                algorithmparameterspec = new SecureRandom();
            }
            algorithmparameterspec.nextBytes(abyte0);
            algorithmparameterspec.nextBytes(abyte1);
            securerandom = new IESParameterSpec(abyte0, abyte1, 128);
        } else
        {
            securerandom = algorithmparameterspec;
            if (!(algorithmparameterspec instanceof IESParameterSpec))
            {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
        }
        algorithmparameterspec = (IESKey)key;
        if (algorithmparameterspec.getPublic() instanceof ECPublicKey)
        {
            key = ECUtil._mth02CF(algorithmparameterspec.getPublic());
            algorithmparameterspec = ECUtil._mth02CF(algorithmparameterspec.getPrivate());
        } else
        {
            key = DHUtil._mth02CE(algorithmparameterspec.getPublic());
            algorithmparameterspec = DHUtil._mth02CE(algorithmparameterspec.getPrivate());
        }
        aDM = (IESParameterSpec)securerandom;
        securerandom = new IESParameters(Arrays._mth1D4C(aDM.axp), Arrays._mth1D4C(aDM.axq), aDM.axr);
        state = i;
        aCM.reset();
        switch (i)
        {
        case 1: // '\001'
        case 3: // '\003'
            IESEngine iesengine = aDL;
            iesengine.amy = true;
            iesengine.arQ = algorithmparameterspec;
            iesengine.arR = key;
            iesengine.anr = new byte[0];
            iesengine._mth02CE(securerandom);
            return;

        case 2: // '\002'
        case 4: // '\004'
            IESEngine iesengine1 = aDL;
            iesengine1.amy = false;
            iesengine1.arQ = algorithmparameterspec;
            iesengine1.arR = key;
            iesengine1.anr = new byte[0];
            iesengine1._mth02CE(securerandom);
            return;
        }
        System.out.println("eeek!");
    }

    protected void engineSetMode(String s)
    {
        throw new IllegalArgumentException((new StringBuilder("can't support mode ")).append(s).toString());
    }

    protected void engineSetPadding(String s)
    {
        throw new NoSuchPaddingException((new StringBuilder()).append(s).append(" unavailable with RSA.").toString());
    }

    protected int engineUpdate(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        aCM.write(abyte0, i, j);
        return 0;
    }

    protected byte[] engineUpdate(byte abyte0[], int i, int j)
    {
        aCM.write(abyte0, i, j);
        return null;
    }
}
