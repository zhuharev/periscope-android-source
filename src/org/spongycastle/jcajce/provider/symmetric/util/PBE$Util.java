// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            PBE, BCPBEKey

public static class nerator
{

    public static CipherParameters _mth02CA(PBEKeySpec pbekeyspec, int i, int j, int k)
    {
        PBEParametersGenerator pbeparametersgenerator = _mth1D36(i, j);
        byte abyte0[] = _mth02CA(i, pbekeyspec);
        pbeparametersgenerator._mth02CA(abyte0, pbekeyspec.getSalt(), pbekeyspec.getIterationCount());
        pbekeyspec = pbeparametersgenerator._mth1D52(k);
        for (i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = 0;
        }

        return pbekeyspec;
    }

    public static CipherParameters _mth02CA(PBEKeySpec pbekeyspec, int i, int j, int k, int l)
    {
        PBEParametersGenerator pbeparametersgenerator = _mth1D36(i, j);
        byte abyte0[] = _mth02CA(i, pbekeyspec);
        pbeparametersgenerator._mth02CA(abyte0, pbekeyspec.getSalt(), pbekeyspec.getIterationCount());
        if (l != 0)
        {
            pbekeyspec = pbeparametersgenerator._mth1D63(k, l);
        } else
        {
            pbekeyspec = pbeparametersgenerator._mth155D(k);
        }
        for (i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = 0;
        }

        return pbekeyspec;
    }

    public static CipherParameters _mth02CA(BCPBEKey bcpbekey, AlgorithmParameterSpec algorithmparameterspec)
    {
        if (algorithmparameterspec == null || !(algorithmparameterspec instanceof PBEParameterSpec))
        {
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }
        PBEParameterSpec pbeparameterspec = (PBEParameterSpec)algorithmparameterspec;
        PBEParametersGenerator pbeparametersgenerator = _mth1D36(bcpbekey.type, bcpbekey.aFv);
        algorithmparameterspec = bcpbekey.getEncoded();
        if (bcpbekey.aFG)
        {
            algorithmparameterspec = new byte[2];
        }
        pbeparametersgenerator._mth02CA(algorithmparameterspec, pbeparameterspec.getSalt(), pbeparameterspec.getIterationCount());
        bcpbekey = pbeparametersgenerator._mth1D52(bcpbekey.Yp);
        for (int i = 0; i != algorithmparameterspec.length; i++)
        {
            algorithmparameterspec[i] = 0;
        }

        return bcpbekey;
    }

    public static CipherParameters _mth02CA(BCPBEKey bcpbekey, AlgorithmParameterSpec algorithmparameterspec, String s)
    {
        if (algorithmparameterspec == null || !(algorithmparameterspec instanceof PBEParameterSpec))
        {
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }
        PBEParameterSpec pbeparameterspec = (PBEParameterSpec)algorithmparameterspec;
        PBEParametersGenerator pbeparametersgenerator = _mth1D36(bcpbekey.type, bcpbekey.aFv);
        algorithmparameterspec = bcpbekey.getEncoded();
        if (bcpbekey.aFG)
        {
            algorithmparameterspec = new byte[2];
        }
        pbeparametersgenerator._mth02CA(algorithmparameterspec, pbeparameterspec.getSalt(), pbeparameterspec.getIterationCount());
        if (bcpbekey.aFw != 0)
        {
            bcpbekey = pbeparametersgenerator._mth1D63(bcpbekey.Yp, bcpbekey.aFw);
        } else
        {
            bcpbekey = pbeparametersgenerator._mth155D(bcpbekey.Yp);
        }
        if (s.startsWith("DES"))
        {
            if (bcpbekey instanceof ParametersWithIV)
            {
                DESParameters._mth1D55(((KeyParameter)((ParametersWithIV)bcpbekey).axC).key);
            } else
            {
                DESParameters._mth1D55(((KeyParameter)bcpbekey).key);
            }
        }
        for (int i = 0; i != algorithmparameterspec.length; i++)
        {
            algorithmparameterspec[i] = 0;
        }

        return bcpbekey;
    }

    private static byte[] _mth02CA(int i, PBEKeySpec pbekeyspec)
    {
        if (i == 2)
        {
            return PBEParametersGenerator._mth02CF(pbekeyspec.getPassword());
        }
        if (i == 5 || i == 4)
        {
            return PBEParametersGenerator._mth02CE(pbekeyspec.getPassword());
        } else
        {
            return PBEParametersGenerator._mth02CB(pbekeyspec.getPassword());
        }
    }

    private static PBEParametersGenerator _mth1D36(int i, int j)
    {
        if (i == 0 || i == 4)
        {
            switch (j)
            {
            case 5: // '\005'
                return new PKCS5S1ParametersGenerator(new MD2Digest());

            case 0: // '\0'
                return new PKCS5S1ParametersGenerator(new MD5Digest());

            case 1: // '\001'
                return new PKCS5S1ParametersGenerator(new SHA1Digest());
            }
            throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
        }
        if (i == 1 || i == 5)
        {
            switch (j)
            {
            case 5: // '\005'
                return new PKCS5S2ParametersGenerator(new MD2Digest());

            case 0: // '\0'
                return new PKCS5S2ParametersGenerator(new MD5Digest());

            case 1: // '\001'
                return new PKCS5S2ParametersGenerator(new SHA1Digest());

            case 2: // '\002'
                return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());

            case 3: // '\003'
                return new PKCS5S2ParametersGenerator(new TigerDigest());

            case 4: // '\004'
                return new PKCS5S2ParametersGenerator(new SHA256Digest());

            case 6: // '\006'
                return new PKCS5S2ParametersGenerator(new GOST3411Digest());
            }
            throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
        }
        if (i == 2)
        {
            switch (j)
            {
            case 5: // '\005'
                return new PKCS12ParametersGenerator(new MD2Digest());

            case 0: // '\0'
                return new PKCS12ParametersGenerator(new MD5Digest());

            case 1: // '\001'
                return new PKCS12ParametersGenerator(new SHA1Digest());

            case 2: // '\002'
                return new PKCS12ParametersGenerator(new RIPEMD160Digest());

            case 3: // '\003'
                return new PKCS12ParametersGenerator(new TigerDigest());

            case 4: // '\004'
                return new PKCS12ParametersGenerator(new SHA256Digest());

            case 6: // '\006'
                return new PKCS12ParametersGenerator(new GOST3411Digest());
            }
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        } else
        {
            return new OpenSSLPBEParametersGenerator();
        }
    }

    public nerator()
    {
    }
}
