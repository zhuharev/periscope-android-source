// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.engines:
//            DESedeEngine

public class DESedeWrapEngine
    implements Wrapper
{

    private static final byte arp[] = {
        74, -35, -94, 44, 121, -24, 33, 5
    };
    private byte aiy[];
    private CBCBlockCipher arl;
    private KeyParameter arm;
    private ParametersWithIV arn;
    private boolean aro;
    private SHA1Digest arq;
    private byte iv[];

    public DESedeWrapEngine()
    {
        arq = new SHA1Digest();
        aiy = new byte[20];
    }

    private byte[] _mth2071(byte abyte0[])
    {
        byte abyte1[] = new byte[8];
        arq.update(abyte0, 0, abyte0.length);
        arq.doFinal(aiy, 0);
        System.arraycopy(aiy, 0, abyte1, 0, 8);
        return abyte1;
    }

    private static byte[] FE76(byte abyte0[])
    {
        byte abyte1[] = new byte[abyte0.length];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte1[i] = abyte0[abyte0.length - (i + 1)];
        }

        return abyte1;
    }

    public final byte[] _mth02C8(byte abyte0[], int i, int j)
    {
        if (!aro)
        {
            throw new IllegalStateException("Not initialized for wrapping");
        }
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        byte abyte2[] = _mth2071(abyte1);
        abyte0 = new byte[abyte1.length + 8];
        System.arraycopy(abyte1, 0, abyte0, 0, abyte1.length);
        System.arraycopy(abyte2, 0, abyte0, abyte1.length, 8);
        j = arl.amz.getBlockSize();
        if (abyte0.length % j != 0)
        {
            throw new IllegalStateException("Not multiple of block length");
        }
        arl._mth02CA(true, arn);
        abyte1 = new byte[abyte0.length];
        for (i = 0; i != abyte0.length; i += j)
        {
            arl._mth02CA(abyte0, i, abyte1, i);
        }

        abyte0 = new byte[iv.length + abyte1.length];
        System.arraycopy(iv, 0, abyte0, 0, iv.length);
        System.arraycopy(abyte1, 0, abyte0, iv.length, abyte1.length);
        abyte0 = FE76(abyte0);
        ParametersWithIV parameterswithiv = new ParametersWithIV(arm, arp);
        arl._mth02CA(true, parameterswithiv);
        for (i = 0; i != abyte0.length; i += j)
        {
            arl._mth02CA(abyte0, i, abyte0, i);
        }

        return abyte0;
    }

    public final byte[] _mth02C9(byte abyte0[], int i, int j)
    {
        if (aro)
        {
            throw new IllegalStateException("Not set for unwrapping");
        }
        if (abyte0 == null)
        {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
        int k = arl.amz.getBlockSize();
        if (j % k != 0)
        {
            throw new InvalidCipherTextException((new StringBuilder("Ciphertext not multiple of ")).append(k).toString());
        }
        ParametersWithIV parameterswithiv = new ParametersWithIV(arm, arp);
        arl._mth02CA(false, parameterswithiv);
        byte abyte1[] = new byte[j];
        for (i = 0; i != j; i += k)
        {
            arl._mth02CA(abyte0, i + 0, abyte1, i);
        }

        abyte0 = FE76(abyte1);
        iv = new byte[8];
        abyte1 = new byte[abyte0.length - 8];
        System.arraycopy(abyte0, 0, iv, 0, 8);
        System.arraycopy(abyte0, 8, abyte1, 0, abyte0.length - 8);
        arn = new ParametersWithIV(arm, iv);
        arl._mth02CA(false, arn);
        abyte0 = new byte[abyte1.length];
        for (i = 0; i != abyte0.length; i += k)
        {
            arl._mth02CA(abyte1, i, abyte0, i);
        }

        abyte1 = new byte[abyte0.length - 8];
        byte abyte2[] = new byte[8];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length - 8);
        System.arraycopy(abyte0, abyte0.length - 8, abyte2, 0, 8);
        if (!Arrays._mth1428(_mth2071(abyte1), abyte2))
        {
            throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        } else
        {
            return abyte1;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aro = flag;
        arl = new CBCBlockCipher(new DESedeEngine());
        CipherParameters cipherparameters1;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            cipherparameters1 = ((ParametersWithRandom) (cipherparameters)).axC;
            cipherparameters = ((ParametersWithRandom) (cipherparameters)).amC;
        } else
        {
            SecureRandom securerandom = new SecureRandom();
            cipherparameters1 = cipherparameters;
            cipherparameters = securerandom;
        }
        if (cipherparameters1 instanceof KeyParameter)
        {
            arm = (KeyParameter)cipherparameters1;
            if (aro)
            {
                iv = new byte[8];
                cipherparameters.nextBytes(iv);
                arn = new ParametersWithIV(arm, iv);
                return;
            }
        } else
        if (cipherparameters1 instanceof ParametersWithIV)
        {
            arn = (ParametersWithIV)cipherparameters1;
            iv = arn.iv;
            arm = (KeyParameter)arn.axC;
            if (aro)
            {
                if (iv == null || iv.length != 8)
                {
                    throw new IllegalArgumentException("IV is not 8 octets");
                }
            } else
            {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            }
        }
    }

    public final String _mth14AC()
    {
        return "DESede";
    }

}
