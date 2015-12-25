// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes:
//            AEADBlockCipher, SICBlockCipher

public class EAXBlockCipher
    implements AEADBlockCipher
{

    private int amw;
    private boolean amy;
    private int auF;
    private byte avK[];
    private byte avM[];
    private SICBlockCipher avS;
    private CMac avT;
    private byte avU[];
    private byte avV[];
    private byte avW[];
    private boolean avX;
    private int kY;

    public EAXBlockCipher(BlockCipher blockcipher)
    {
        kY = blockcipher.getBlockSize();
        avT = new CMac(blockcipher);
        avM = new byte[kY];
        avV = new byte[avT._mth14B3()];
        avU = new byte[avT._mth14B3()];
        avS = new SICBlockCipher(blockcipher);
    }

    private void _mth010D()
    {
        if (avX)
        {
            return;
        } else
        {
            avX = true;
            avT.doFinal(avV, 0);
            byte abyte0[] = new byte[kY];
            abyte0[kY - 1] = 2;
            avT.update(abyte0, 0, kY);
            return;
        }
    }

    private void _mth0176()
    {
        byte abyte0[] = new byte[kY];
        avT.doFinal(abyte0, 0);
        for (int i = 0; i < avM.length; i++)
        {
            avM[i] = (byte)(avU[i] ^ avV[i] ^ abyte0[i]);
        }

    }

    private void _mth06E6(boolean flag)
    {
        avS.reset();
        avT.reset();
        amw = 0;
        Arrays.fill(avW, (byte)0);
        if (flag)
        {
            Arrays.fill(avM, (byte)0);
        }
        byte abyte0[] = new byte[kY];
        abyte0[kY - 1] = 1;
        avT.update(abyte0, 0, kY);
        avX = false;
        if (avK != null)
        {
            byte abyte1[] = avK;
            int i = avK.length;
            if (avX)
            {
                throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
            }
            avT.update(abyte1, 0, i);
        }
    }

    public final int doFinal(byte abyte0[], int i)
    {
        _mth010D();
        int k = amw;
        byte abyte1[] = new byte[avW.length];
        amw = 0;
        if (amy)
        {
            if (abyte0.length < i + k + auF)
            {
                throw new OutputLengthException("Output buffer too short");
            } else
            {
                avS._mth02CA(avW, 0, abyte1, 0);
                System.arraycopy(abyte1, 0, abyte0, i, k);
                avT.update(abyte1, 0, k);
                _mth0176();
                System.arraycopy(avM, 0, abyte0, i + k, auF);
                _mth06E6(false);
                return auF + k;
            }
        }
        if (abyte0.length < (i + k) - auF)
        {
            throw new OutputLengthException("Output buffer too short");
        }
        if (k < auF)
        {
            throw new InvalidCipherTextException("data too short");
        }
        if (k > auF)
        {
            avT.update(avW, 0, k - auF);
            avS._mth02CA(avW, 0, abyte1, 0);
            System.arraycopy(abyte1, 0, abyte0, i, k - auF);
        }
        _mth0176();
        abyte0 = avW;
        int l = auF;
        int j = 0;
        for (i = 0; i < auF; i++)
        {
            j |= avM[i] ^ abyte0[(k - l) + i];
        }

        if (j == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            throw new InvalidCipherTextException("mac check in EAX failed");
        } else
        {
            _mth06E6(false);
            return k - auF;
        }
    }

    public final int getOutputSize(int i)
    {
        i += amw;
        if (amy)
        {
            return auF + i;
        }
        if (i < auF)
        {
            return 0;
        } else
        {
            return i - auF;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        byte abyte0[];
        if (cipherparameters instanceof AEADParameters)
        {
            cipherparameters = (AEADParameters)cipherparameters;
            abyte0 = ((AEADParameters) (cipherparameters)).XD;
            avK = ((AEADParameters) (cipherparameters)).awP;
            auF = ((AEADParameters) (cipherparameters)).auF / 8;
            cipherparameters = ((AEADParameters) (cipherparameters)).avZ;
        } else
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters = (ParametersWithIV)cipherparameters;
            abyte0 = ((ParametersWithIV) (cipherparameters)).iv;
            avK = null;
            auF = avT._mth14B3() / 2;
            cipherparameters = ((ParametersWithIV) (cipherparameters)).axC;
        } else
        {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        int i;
        if (flag)
        {
            i = kY;
        } else
        {
            i = kY + auF;
        }
        avW = new byte[i];
        byte abyte1[] = new byte[kY];
        avT._mth02CA(cipherparameters);
        abyte1[kY - 1] = 0;
        avT.update(abyte1, 0, kY);
        avT.update(abyte0, 0, abyte0.length);
        avT.doFinal(avU, 0);
        avS._mth02CA(true, new ParametersWithIV(null, avU));
        _mth06E6(true);
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        _mth010D();
        if (abyte0.length < i + j)
        {
            throw new DataLengthException("Input buffer too short");
        }
        int j1 = 0;
        for (int i1 = 0; i1 != j; i1++)
        {
            byte byte0 = abyte0[i + i1];
            int k1 = k + j1;
            byte abyte2[] = avW;
            int l = amw;
            amw = l + 1;
            abyte2[l] = byte0;
            if (amw == avW.length)
            {
                if (abyte1.length < kY + k1)
                {
                    throw new OutputLengthException("Output buffer is too short");
                }
                if (amy)
                {
                    l = avS._mth02CA(avW, 0, abyte1, k1);
                    avT.update(abyte1, k1, kY);
                } else
                {
                    avT.update(avW, 0, kY);
                    l = avS._mth02CA(avW, 0, abyte1, k1);
                }
                amw = 0;
                if (!amy)
                {
                    System.arraycopy(avW, kY, avW, 0, auF);
                    amw = auF;
                }
            } else
            {
                l = 0;
            }
            j1 += l;
        }

        return j1;
    }

    public final void _mth1428(byte abyte0[], int i, int j)
    {
        if (avX)
        {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        } else
        {
            avT.update(abyte0, i, j);
            return;
        }
    }

    public final BlockCipher _mth14AD()
    {
        return ((StreamBlockCipher) (avS)).amz;
    }

    public final int _mth1550(int i)
    {
        int j = i + amw;
        i = j;
        if (!amy)
        {
            if (j < auF)
            {
                return 0;
            }
            i = j - auF;
        }
        return i - i % kY;
    }
}
