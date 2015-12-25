// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.encodings;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class OAEPEncoding
    implements AsymmetricBlockCipher
{

    private SecureRandom amC;
    private boolean amy;
    private AsymmetricBlockCipher apO;
    private byte apQ[];
    private Digest apR;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricblockcipher, Digest digest, Digest digest1, byte abyte0[])
    {
        apO = asymmetricblockcipher;
        apR = digest1;
        apQ = new byte[digest._mth14AF()];
        digest.reset();
        if (abyte0 != null)
        {
            digest.update(abyte0, 0, abyte0.length);
        }
        digest.doFinal(apQ, 0);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricblockcipher, Digest digest, byte abyte0[])
    {
        this(asymmetricblockcipher, digest, digest, abyte0);
    }

    private byte[] _mth02CA(byte abyte0[], int i, int j, int k)
    {
        byte abyte1[] = new byte[k];
        byte abyte2[] = new byte[apR._mth14AF()];
        byte abyte3[] = new byte[4];
        int l = 0;
        apR.reset();
        for (; l < k / abyte2.length; l++)
        {
            abyte3[0] = l >> 24;
            abyte3[1] = (byte)(l >>> 16);
            abyte3[2] = (byte)(l >>> 8);
            abyte3[3] = (byte)l;
            apR.update(abyte0, i, j);
            apR.update(abyte3, 0, 4);
            apR.doFinal(abyte2, 0);
            System.arraycopy(abyte2, 0, abyte1, abyte2.length * l, abyte2.length);
        }

        if (abyte2.length * l < k)
        {
            abyte3[0] = l >> 24;
            abyte3[1] = (byte)(l >>> 16);
            abyte3[2] = (byte)(l >>> 8);
            abyte3[3] = (byte)l;
            apR.update(abyte0, i, j);
            apR.update(abyte3, 0, 4);
            apR.doFinal(abyte2, 0);
            System.arraycopy(abyte2, 0, abyte1, abyte2.length * l, abyte1.length - abyte2.length * l);
        }
        return abyte1;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithRandom)
        {
            amC = ((ParametersWithRandom)cipherparameters).amC;
        } else
        {
            amC = new SecureRandom();
        }
        apO._mth02CA(flag, cipherparameters);
        amy = flag;
    }

    public final int _mth148C()
    {
        int i = apO._mth148C();
        if (amy)
        {
            return i - 1 - apQ.length * 2;
        } else
        {
            return i;
        }
    }

    public final int _mth148E()
    {
        int i = apO._mth148E();
        if (amy)
        {
            return i;
        } else
        {
            return i - 1 - apQ.length * 2;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (amy)
        {
            int k = apO._mth148C();
            if (amy)
            {
                k = k - 1 - apQ.length * 2;
            }
            byte abyte1[] = new byte[k + 1 + apQ.length * 2];
            System.arraycopy(abyte0, i, abyte1, abyte1.length - j, j);
            abyte1[abyte1.length - j - 1] = 1;
            System.arraycopy(apQ, 0, abyte1, apQ.length, apQ.length);
            abyte0 = new byte[apQ.length];
            amC.nextBytes(abyte0);
            byte abyte5[] = _mth02CA(abyte0, 0, abyte0.length, abyte1.length - apQ.length);
            for (i = apQ.length; i != abyte1.length; i++)
            {
                abyte1[i] = (byte)(abyte1[i] ^ abyte5[i - apQ.length]);
            }

            System.arraycopy(abyte0, 0, abyte1, 0, apQ.length);
            abyte0 = _mth02CA(abyte1, apQ.length, abyte1.length - apQ.length, apQ.length);
            for (i = 0; i != apQ.length; i++)
            {
                abyte1[i] = (byte)(abyte1[i] ^ abyte0[i]);
            }

            return apO._mth1FBE(abyte1, 0, abyte1.length);
        }
        abyte0 = apO._mth1FBE(abyte0, i, j);
        if (abyte0.length < apO._mth148E())
        {
            byte abyte2[] = new byte[apO._mth148E()];
            System.arraycopy(abyte0, 0, abyte2, abyte2.length - abyte0.length, abyte0.length);
            abyte0 = abyte2;
        }
        if (abyte0.length < apQ.length * 2 + 1)
        {
            throw new InvalidCipherTextException("data too short");
        }
        byte abyte3[] = _mth02CA(abyte0, apQ.length, abyte0.length - apQ.length, apQ.length);
        for (i = 0; i != apQ.length; i++)
        {
            abyte0[i] = (byte)(abyte0[i] ^ abyte3[i]);
        }

        abyte3 = _mth02CA(abyte0, 0, apQ.length, abyte0.length - apQ.length);
        for (i = apQ.length; i != abyte0.length; i++)
        {
            abyte0[i] = (byte)(abyte0[i] ^ abyte3[i - apQ.length]);
        }

        j = 0;
        for (i = 0; i != apQ.length; i++)
        {
            if (apQ[i] != abyte0[apQ.length + i])
            {
                j = 1;
            }
        }

        if (j != 0)
        {
            throw new InvalidCipherTextException("data hash wrong");
        }
        for (i = apQ.length * 2; i != abyte0.length && abyte0[i] == 0; i++) { }
        if (i >= abyte0.length - 1 || abyte0[i] != 1)
        {
            throw new InvalidCipherTextException((new StringBuilder("data start wrong ")).append(i).toString());
        } else
        {
            i++;
            byte abyte4[] = new byte[abyte0.length - i];
            System.arraycopy(abyte0, i, abyte4, 0, abyte4.length);
            return abyte4;
        }
    }
}
