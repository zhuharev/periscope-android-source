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
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.engines:
//            RC2Engine

public class RC2WrapEngine
    implements Wrapper
{

    private static final byte arp[] = {
        74, -35, -94, 44, 121, -24, 33, 5
    };
    private byte aiy[];
    private CBCBlockCipher arl;
    private ParametersWithIV arn;
    private boolean aro;
    private SHA1Digest arq;
    private CipherParameters aso;
    private SecureRandom asp;
    private byte iv[];

    public RC2WrapEngine()
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

    public final byte[] _mth02C8(byte abyte0[], int i, int j)
    {
        if (!aro)
        {
            throw new IllegalStateException("Not initialized for wrapping");
        }
        int k1 = j + 1;
        int k = k1;
        int j1 = k;
        if (k1 % 8 != 0)
        {
            j1 = k + (8 - k % 8);
        }
        byte abyte1[] = new byte[j1];
        abyte1[0] = (byte)j;
        System.arraycopy(abyte0, i, abyte1, 1, j);
        abyte0 = new byte[abyte1.length - j - 1];
        if (abyte0.length > 0)
        {
            asp.nextBytes(abyte0);
            System.arraycopy(abyte0, 0, abyte1, j + 1, abyte0.length);
        }
        byte abyte2[] = _mth2071(abyte1);
        abyte0 = new byte[abyte1.length + 8];
        System.arraycopy(abyte1, 0, abyte0, 0, abyte1.length);
        System.arraycopy(abyte2, 0, abyte0, abyte1.length, 8);
        abyte1 = new byte[abyte0.length];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        j = abyte0.length / arl.amz.getBlockSize();
        if (abyte0.length % arl.amz.getBlockSize() != 0)
        {
            throw new IllegalStateException("Not multiple of block length");
        }
        arl._mth02CA(true, arn);
        for (i = 0; i < j; i++)
        {
            int l = i * arl.amz.getBlockSize();
            arl._mth02CA(abyte1, l, abyte1, l);
        }

        abyte0 = new byte[iv.length + abyte1.length];
        System.arraycopy(iv, 0, abyte0, 0, iv.length);
        System.arraycopy(abyte1, 0, abyte0, iv.length, abyte1.length);
        abyte1 = new byte[abyte0.length];
        for (i = 0; i < abyte0.length; i++)
        {
            abyte1[i] = abyte0[abyte0.length - (i + 1)];
        }

        abyte0 = new ParametersWithIV(aso, arp);
        arl._mth02CA(true, abyte0);
        for (i = 0; i < j + 1; i++)
        {
            int i1 = i * arl.amz.getBlockSize();
            arl._mth02CA(abyte1, i1, abyte1, i1);
        }

        return abyte1;
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
        if (j % arl.amz.getBlockSize() != 0)
        {
            throw new InvalidCipherTextException((new StringBuilder("Ciphertext not multiple of ")).append(arl.amz.getBlockSize()).toString());
        }
        ParametersWithIV parameterswithiv = new ParametersWithIV(aso, arp);
        arl._mth02CA(false, parameterswithiv);
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte1, 0, j);
        for (i = 0; i < abyte1.length / arl.amz.getBlockSize(); i++)
        {
            j = i * arl.amz.getBlockSize();
            arl._mth02CA(abyte1, j, abyte1, j);
        }

        abyte0 = new byte[abyte1.length];
        for (i = 0; i < abyte1.length; i++)
        {
            abyte0[i] = abyte1[abyte1.length - (i + 1)];
        }

        iv = new byte[8];
        abyte1 = new byte[abyte0.length - 8];
        System.arraycopy(abyte0, 0, iv, 0, 8);
        System.arraycopy(abyte0, 8, abyte1, 0, abyte0.length - 8);
        arn = new ParametersWithIV(aso, iv);
        arl._mth02CA(false, arn);
        abyte0 = new byte[abyte1.length];
        System.arraycopy(abyte1, 0, abyte0, 0, abyte1.length);
        for (i = 0; i < abyte0.length / arl.amz.getBlockSize(); i++)
        {
            j = i * arl.amz.getBlockSize();
            arl._mth02CA(abyte0, j, abyte0, j);
        }

        abyte1 = new byte[abyte0.length - 8];
        byte abyte2[] = new byte[8];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length - 8);
        System.arraycopy(abyte0, abyte0.length - 8, abyte2, 0, 8);
        if (!Arrays._mth1428(_mth2071(abyte1), abyte2))
        {
            throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        }
        if (abyte1.length - ((abyte1[0] & 0xff) + 1) > 7)
        {
            throw new InvalidCipherTextException((new StringBuilder("too many pad bytes (")).append(abyte1.length - ((abyte1[0] & 0xff) + 1)).append(")").toString());
        } else
        {
            abyte0 = new byte[abyte1[0]];
            System.arraycopy(abyte1, 1, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aro = flag;
        arl = new CBCBlockCipher(new RC2Engine());
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (ParametersWithRandom)cipherparameters;
            asp = ((ParametersWithRandom) (cipherparameters)).amC;
            cipherparameters = ((ParametersWithRandom) (cipherparameters)).axC;
        } else
        {
            asp = new SecureRandom();
        }
        if (cipherparameters instanceof ParametersWithIV)
        {
            arn = (ParametersWithIV)cipherparameters;
            iv = arn.iv;
            aso = arn.axC;
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
        } else
        {
            aso = cipherparameters;
            if (aro)
            {
                iv = new byte[8];
                asp.nextBytes(iv);
                arn = new ParametersWithIV(aso, iv);
            }
        }
    }

    public final String _mth14AC()
    {
        return "RC2";
    }

}
