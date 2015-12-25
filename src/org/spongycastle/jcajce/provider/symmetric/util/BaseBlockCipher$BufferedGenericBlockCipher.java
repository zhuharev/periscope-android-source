// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import javax.crypto.BadPaddingException;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseBlockCipher

static class arO
    implements arO
{

    private BufferedBlockCipher arO;

    public final int doFinal(byte abyte0[], int i)
    {
        try
        {
            i = arO.doFinal(abyte0, i);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new BadPaddingException(abyte0.getMessage());
        }
        return i;
    }

    public final int getOutputSize(int i)
    {
        return arO.getOutputSize(i);
    }

    public final void updateAAD(byte abyte0[], int i, int j)
    {
        throw new UnsupportedOperationException("AAD is not supported in the current mode.");
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        arO._mth02CA(flag, cipherparameters);
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        return arO._mth02CB(abyte0, i, j, abyte1, k);
    }

    public final BlockCipher _mth14AD()
    {
        return arO._mth14AD();
    }

    public final int _mth1550(int i)
    {
        return arO._mth1550(i);
    }

    public final boolean _mth1D09()
    {
        return !(arO instanceof CTSBlockCipher);
    }

    (BlockCipher blockcipher)
    {
        arO = new PaddedBufferedBlockCipher(blockcipher);
    }

    arO(BlockCipher blockcipher, BlockCipherPadding blockcipherpadding)
    {
        arO = new PaddedBufferedBlockCipher(blockcipher, blockcipherpadding);
    }

    arO(BufferedBlockCipher bufferedblockcipher)
    {
        arO = bufferedblockcipher;
    }
}
