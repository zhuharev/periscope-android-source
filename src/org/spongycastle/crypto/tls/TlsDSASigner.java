// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSADigestSigner;

// Referenced classes of package org.spongycastle.crypto.tls:
//            AbstractTlsSigner, TlsUtils, SignatureAndHashAlgorithm, TlsContext

public abstract class TlsDSASigner extends AbstractTlsSigner
{

    public TlsDSASigner()
    {
    }

    private DSADigestSigner _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, boolean flag, boolean flag1, CipherParameters cipherparameters)
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
        if (signatureandhashalgorithm != null && (signatureandhashalgorithm._mth09AA() != 2 || signatureandhashalgorithm._mth09AF() != _mth0E05()))
        {
            throw new IllegalStateException();
        }
        short word0;
        if (signatureandhashalgorithm == null)
        {
            word0 = 2;
        } else
        {
            word0 = signatureandhashalgorithm._mth09AA();
        }
        if (flag)
        {
            signatureandhashalgorithm = new NullDigest();
        } else
        {
            signatureandhashalgorithm = TlsUtils._mth02BD(word0);
        }
        signatureandhashalgorithm = new DSADigestSigner(_mth141D(word0), signatureandhashalgorithm);
        signatureandhashalgorithm._mth02CA(flag1, cipherparameters);
        return signatureandhashalgorithm;
    }

    public final Signer _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, AsymmetricKeyParameter asymmetrickeyparameter)
    {
        return _mth02CA(signatureandhashalgorithm, false, false, ((CipherParameters) (asymmetrickeyparameter)));
    }

    public final boolean _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, byte abyte0[], AsymmetricKeyParameter asymmetrickeyparameter, byte abyte1[])
    {
        asymmetrickeyparameter = _mth02CA(signatureandhashalgorithm, true, false, ((CipherParameters) (asymmetrickeyparameter)));
        if (signatureandhashalgorithm == null)
        {
            asymmetrickeyparameter.update(abyte1, 16, 20);
        } else
        {
            asymmetrickeyparameter.update(abyte1, 0, abyte1.length);
        }
        return asymmetrickeyparameter.FE73(abyte0);
    }

    public final byte[] _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, AsymmetricKeyParameter asymmetrickeyparameter, byte abyte0[])
    {
        asymmetrickeyparameter = _mth02CA(signatureandhashalgorithm, true, true, ((CipherParameters) (new ParametersWithRandom(asymmetrickeyparameter, azJ._mth03D2()))));
        if (signatureandhashalgorithm == null)
        {
            asymmetrickeyparameter.update(abyte0, 16, 20);
        } else
        {
            asymmetrickeyparameter.update(abyte0, 0, abyte0.length);
        }
        return asymmetrickeyparameter._mth14B6();
    }

    protected abstract short _mth0E05();

    protected abstract DSA _mth141D(short word0);
}
