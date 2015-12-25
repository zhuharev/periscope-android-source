// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.signers.GenericSigner;
import org.spongycastle.crypto.signers.RSADigestSigner;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsSigner, TlsUtils, SignatureAndHashAlgorithm, CombinedHash, 
//            TlsContext

public class TlsRSASigner extends AbstractTlsSigner
{

    public TlsRSASigner()
    {
    }

    private Signer _mth02CB(SignatureAndHashAlgorithm signatureandhashalgorithm, boolean flag, boolean flag1, CipherParameters cipherparameters)
    {
        boolean flag2;
        if (signatureandhashalgorithm != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2 != TlsUtils._mth02CF(azJ))
        {
            throw new IllegalStateException();
        }
        if (signatureandhashalgorithm != null && signatureandhashalgorithm._mth09AF() != 1)
        {
            throw new IllegalStateException();
        }
        Object obj;
        if (flag)
        {
            obj = new NullDigest();
        } else
        if (signatureandhashalgorithm == null)
        {
            obj = new CombinedHash();
        } else
        {
            obj = TlsUtils._mth02BD(signatureandhashalgorithm._mth09AA());
        }
        if (signatureandhashalgorithm != null)
        {
            signatureandhashalgorithm = new RSADigestSigner(((org.spongycastle.crypto.Digest) (obj)), TlsUtils._mth037A(signatureandhashalgorithm._mth09AA()));
        } else
        {
            signatureandhashalgorithm = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), ((org.spongycastle.crypto.Digest) (obj)));
        }
        signatureandhashalgorithm._mth02CA(flag1, cipherparameters);
        return signatureandhashalgorithm;
    }

    public final Signer _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, AsymmetricKeyParameter asymmetrickeyparameter)
    {
        return _mth02CB(signatureandhashalgorithm, false, false, asymmetrickeyparameter);
    }

    public final boolean _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, byte abyte0[], AsymmetricKeyParameter asymmetrickeyparameter, byte abyte1[])
    {
        signatureandhashalgorithm = _mth02CB(signatureandhashalgorithm, true, false, asymmetrickeyparameter);
        signatureandhashalgorithm.update(abyte1, 0, abyte1.length);
        return signatureandhashalgorithm.FE73(abyte0);
    }

    public final byte[] _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, AsymmetricKeyParameter asymmetrickeyparameter, byte abyte0[])
    {
        signatureandhashalgorithm = _mth02CB(signatureandhashalgorithm, true, true, new ParametersWithRandom(asymmetrickeyparameter, azJ._mth03D2()));
        signatureandhashalgorithm.update(abyte0, 0, abyte0.length);
        return signatureandhashalgorithm._mth14B6();
    }

    public final boolean _mth02CE(AsymmetricKeyParameter asymmetrickeyparameter)
    {
        return (asymmetrickeyparameter instanceof RSAKeyParameters) && !asymmetrickeyparameter.awQ;
    }
}
