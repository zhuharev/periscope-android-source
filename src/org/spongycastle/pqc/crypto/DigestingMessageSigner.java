// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

// Referenced classes of package org.spongycastle.pqc.crypto:
//            MessageSigner

public class DigestingMessageSigner
    implements Signer
{

    private final Digest aKp;
    private final MessageSigner aKq;
    private boolean ayZ;

    public final void update(byte byte0)
    {
        aKp.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        aKp.update(abyte0, i, j);
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
            throw new IllegalArgumentException("Signing Requires Private Key.");
        }
        if (!flag && asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        } else
        {
            aKp.reset();
            aKq._mth02CA(flag, cipherparameters);
            return;
        }
    }

    public final byte[] _mth14B6()
    {
        if (!ayZ)
        {
            throw new IllegalStateException("RainbowDigestSigner not initialised for signature generation.");
        } else
        {
            byte abyte0[] = new byte[aKp._mth14AF()];
            aKp.doFinal(abyte0, 0);
            return aKq._mth02B2(abyte0);
        }
    }

    public final boolean FE73(byte abyte0[])
    {
        if (ayZ)
        {
            throw new IllegalStateException("RainbowDigestSigner not initialised for verification");
        } else
        {
            byte abyte1[] = new byte[aKp._mth14AF()];
            aKp.doFinal(abyte1, 0);
            return aKq._mth02C9(abyte1, abyte0);
        }
    }
}
