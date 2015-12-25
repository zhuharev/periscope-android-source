// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class GMac
    implements Mac
{

    private final GCMBlockCipher auK;
    private final int auL = 128;

    public GMac(GCMBlockCipher gcmblockcipher)
    {
        auK = gcmblockcipher;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        try
        {
            i = auK.doFinal(abyte0, 0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalStateException(abyte0.toString());
        }
        return i;
    }

    public final void reset()
    {
        auK._mth06E6(true);
    }

    public final void update(byte byte0)
    {
        GCMBlockCipher gcmblockcipher = auK;
        gcmblockcipher.awi[gcmblockcipher.awj] = byte0;
        int i = gcmblockcipher.awj + 1;
        gcmblockcipher.awj = i;
        if (i == 16)
        {
            byte abyte0[] = gcmblockcipher.awe;
            GCMBlockCipher._mth141D(abyte0, gcmblockcipher.awi);
            gcmblockcipher.awb._mth1429(abyte0);
            gcmblockcipher.awj = 0;
            gcmblockcipher.awk = gcmblockcipher.awk + 16L;
        }
    }

    public final void update(byte abyte0[], int i, int j)
    {
        auK._mth1428(abyte0, i, j);
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithIV)
        {
            Object obj = (ParametersWithIV)cipherparameters;
            cipherparameters = ((ParametersWithIV) (obj)).iv;
            obj = (KeyParameter)((ParametersWithIV) (obj)).axC;
            auK._mth02CA(true, new AEADParameters(((KeyParameter) (obj)), 128, cipherparameters));
            return;
        } else
        {
            throw new IllegalArgumentException("GMAC requires ParametersWithIV");
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(auK.amz._mth14AC()).append("-GMAC").toString();
    }

    public final int _mth14B3()
    {
        return 16;
    }
}
