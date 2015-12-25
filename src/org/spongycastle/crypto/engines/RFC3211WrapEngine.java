// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class RFC3211WrapEngine
    implements Wrapper
{

    private CBCBlockCipher arl;
    private boolean aro;
    private ParametersWithIV asu;
    private SecureRandom asv;

    public RFC3211WrapEngine(BlockCipher blockcipher)
    {
        arl = new CBCBlockCipher(blockcipher);
    }

    public final byte[] _mth02C8(byte abyte0[], int i, int j)
    {
        if (!aro)
        {
            throw new IllegalStateException("not set for wrapping");
        }
        arl._mth02CA(true, asu);
        int l = arl.amz.getBlockSize();
        int k;
        if (j + 4 < l << 1)
        {
            k = l << 1;
        } else
        if ((j + 4) % l == 0)
        {
            k = j + 4;
        } else
        {
            k = ((j + 4) / l + 1) * l;
        }
        byte abyte1[] = new byte[k];
        abyte1[0] = (byte)j;
        abyte1[1] = (byte)(~abyte0[i]);
        abyte1[2] = (byte)(~abyte0[i + 1]);
        abyte1[3] = (byte)(~abyte0[i + 2]);
        System.arraycopy(abyte0, i, abyte1, 4, j);
        for (i = j + 4; i < abyte1.length; i++)
        {
            abyte1[i] = (byte)asv.nextInt();
        }

        for (i = 0; i < abyte1.length; i += l)
        {
            arl._mth02CA(abyte1, i, abyte1, i);
        }

        for (i = 0; i < abyte1.length; i += l)
        {
            arl._mth02CA(abyte1, i, abyte1, i);
        }

        return abyte1;
    }

    public final byte[] _mth02C9(byte abyte0[], int i, int j)
    {
        if (aro)
        {
            throw new IllegalStateException("not set for unwrapping");
        }
        int k = arl.amz.getBlockSize();
        if (j < k * 2)
        {
            throw new InvalidCipherTextException("input too short");
        }
        byte abyte1[] = new byte[j];
        byte abyte2[] = new byte[k];
        System.arraycopy(abyte0, 0, abyte1, 0, j);
        System.arraycopy(abyte0, 0, abyte2, 0, abyte2.length);
        arl._mth02CA(false, new ParametersWithIV(asu.axC, abyte2));
        for (i = k; i < abyte1.length; i += k)
        {
            arl._mth02CA(abyte1, i, abyte1, i);
        }

        System.arraycopy(abyte1, abyte1.length - abyte2.length, abyte2, 0, abyte2.length);
        arl._mth02CA(false, new ParametersWithIV(asu.axC, abyte2));
        arl._mth02CA(abyte1, 0, abyte1, 0);
        arl._mth02CA(false, asu);
        for (i = 0; i < abyte1.length; i += k)
        {
            arl._mth02CA(abyte1, i, abyte1, i);
        }

        if ((abyte1[0] & 0xff) > abyte1.length - 4)
        {
            throw new InvalidCipherTextException("wrapped key corrupted");
        }
        abyte0 = new byte[abyte1[0] & 0xff];
        System.arraycopy(abyte1, 4, abyte0, 0, abyte1[0]);
        j = 0;
        for (i = 0; i != 3; i++)
        {
            byte byte0 = (byte)(~abyte1[i + 1]);
            j |= abyte0[i] ^ byte0;
        }

        if (j != 0)
        {
            throw new InvalidCipherTextException("wrapped key fails checksum");
        } else
        {
            return abyte0;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aro = flag;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            asv = ((ParametersWithRandom) (cipherparameters)).amC;
            asu = (ParametersWithIV)((ParametersWithRandom) (cipherparameters)).axC;
            return;
        }
        if (flag)
        {
            asv = new SecureRandom();
        }
        asu = (ParametersWithIV)cipherparameters;
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(arl.amz._mth14AC()).append("/RFC3211Wrap").toString();
    }
}
