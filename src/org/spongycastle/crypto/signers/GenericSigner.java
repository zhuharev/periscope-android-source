// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class GenericSigner
    implements Signer
{

    private final Digest amS;
    private final AsymmetricBlockCipher apO;
    private boolean ayZ;

    public GenericSigner(AsymmetricBlockCipher asymmetricblockcipher, Digest digest)
    {
        apO = asymmetricblockcipher;
        amS = digest;
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        ayZ = flag;
        AsymmetricKeyParameter asymmetrickeyparameter;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            asymmetrickeyparameter = (AsymmetricKeyParameter)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            asymmetrickeyparameter = (AsymmetricKeyParameter)cipherparameters;
        }
        if (flag && !asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!flag && asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("verification requires public key");
        } else
        {
            amS.reset();
            apO._mth02CA(flag, cipherparameters);
            return;
        }
    }

    public final byte[] _mth14B6()
    {
        if (!ayZ)
        {
            throw new IllegalStateException("GenericSigner not initialised for signature generation.");
        } else
        {
            byte abyte0[] = new byte[amS._mth14AF()];
            amS.doFinal(abyte0, 0);
            return apO._mth1FBE(abyte0, 0, abyte0.length);
        }
    }

    public final boolean FE73(byte abyte0[])
    {
        if (ayZ)
        {
            throw new IllegalStateException("GenericSigner not initialised for verification");
        }
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        boolean flag;
        try
        {
            flag = Arrays._mth1428(apO._mth1FBE(abyte0, 0, abyte0.length), abyte1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return false;
        }
        return flag;
    }
}
