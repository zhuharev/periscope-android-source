// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes:
//            AEADBlockCipher, SICBlockCipher

public class CCMBlockCipher
    implements AEADBlockCipher
{
    class ExposedByteArrayOutputStream extends ByteArrayOutputStream
    {

        private CCMBlockCipher avP;

        public final byte[] _mth0109()
        {
            return buf;
        }

        public ExposedByteArrayOutputStream()
        {
            avP = CCMBlockCipher.this;
            super();
        }
    }


    private byte XD[];
    private boolean amy;
    private BlockCipher amz;
    private int auF;
    private byte avK[];
    private CipherParameters avL;
    private byte avM[];
    private ExposedByteArrayOutputStream avN;
    private ExposedByteArrayOutputStream avO;
    private int kY;

    public CCMBlockCipher(BlockCipher blockcipher)
    {
        avN = new ExposedByteArrayOutputStream();
        avO = new ExposedByteArrayOutputStream();
        amz = blockcipher;
        kY = blockcipher.getBlockSize();
        avM = new byte[kY];
        if (kY != 16)
        {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        } else
        {
            return;
        }
    }

    private int _mth02CA(byte abyte0[], int i, int j, byte abyte1[])
    {
        CBCBlockCipherMac cbcblockciphermac = new CBCBlockCipherMac(amz, auF << 3);
        cbcblockciphermac._mth02CA(avL);
        byte abyte2[] = new byte[16];
        int i1 = avN.size();
        int k;
        if (avK == null)
        {
            k = 0;
        } else
        {
            k = avK.length;
        }
        boolean flag;
        if (i1 + k > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            abyte2[0] = (byte)(abyte2[0] | 0x40);
        }
        abyte2[0] = (byte)(abyte2[0] | ((cbcblockciphermac._mth14B3() - 2) / 2 & 7) << 3);
        abyte2[0] = (byte)(abyte2[0] | 15 - XD.length - 1 & 7);
        System.arraycopy(XD, 0, abyte2, 1, XD.length);
        i1 = j;
        for (flag = true; i1 > 0; flag++)
        {
            abyte2[16 - flag] = (byte)i1;
            i1 >>>= 8;
        }

        cbcblockciphermac.update(abyte2, 0, 16);
        i1 = avN.size();
        if (avK == null)
        {
            flag = false;
        } else
        {
            flag = avK.length;
        }
        if (i1 + flag > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            int j1 = avN.size();
            int l;
            if (avK == null)
            {
                l = 0;
            } else
            {
                l = avK.length;
            }
            j1 += l;
            if (j1 < 65280)
            {
                cbcblockciphermac.update((byte)(j1 >> 8));
                cbcblockciphermac.update((byte)j1);
                l = 2;
            } else
            {
                cbcblockciphermac.update((byte)-1);
                cbcblockciphermac.update((byte)-2);
                cbcblockciphermac.update(j1 >> 24);
                cbcblockciphermac.update((byte)(j1 >> 16));
                cbcblockciphermac.update((byte)(j1 >> 8));
                cbcblockciphermac.update((byte)j1);
                l = 6;
            }
            if (avK != null)
            {
                cbcblockciphermac.update(avK, 0, avK.length);
            }
            if (avN.size() > 0)
            {
                cbcblockciphermac.update(avN._mth0109(), 0, avN.size());
            }
            j1 = (l + j1) % 16;
            l = j1;
            if (j1 != 0)
            {
                for (; l != 16; l++)
                {
                    cbcblockciphermac.update((byte)0);
                }

            }
        }
        cbcblockciphermac.update(abyte0, i, j);
        return cbcblockciphermac.doFinal(abyte1, 0);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = avO._mth0109();
        int l1 = avO.size();
        if (avL == null)
        {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
        int j = 15 - XD.length;
        if (j < 4 && l1 >= 1 << j * 8)
        {
            throw new IllegalStateException("CCM packet too large for choice of q.");
        }
        byte abyte2[] = new byte[kY];
        abyte2[0] = (byte)(j - 1 & 7);
        System.arraycopy(XD, 0, abyte2, 1, XD.length);
        SICBlockCipher sicblockcipher = new SICBlockCipher(amz);
        sicblockcipher._mth02CA(amy, new ParametersWithIV(avL, abyte2));
        boolean flag1 = false;
        boolean flag = false;
        j = i;
        if (amy)
        {
            int i1 = l1 + auF;
            if (abyte0.length < i1 + i)
            {
                throw new OutputLengthException("Output buffer too short.");
            }
            _mth02CA(abyte1, 0, l1, avM);
            sicblockcipher._mth02CA(avM, 0, avM, 0);
            int k = j;
            for (j = ((flag) ? 1 : 0); j < (l1 + 0) - kY; j += kY)
            {
                sicblockcipher._mth02CA(abyte1, j, abyte0, k);
                k += kY;
            }

            byte abyte3[] = new byte[kY];
            System.arraycopy(abyte1, j, abyte3, 0, l1 - j);
            sicblockcipher._mth02CA(abyte3, 0, abyte3, 0);
            System.arraycopy(abyte3, 0, abyte0, k, l1 - j);
            System.arraycopy(avM, 0, abyte0, i + l1, auF);
            i = i1;
        } else
        {
            if (l1 < auF)
            {
                throw new InvalidCipherTextException("data too short");
            }
            l1 -= auF;
            if (abyte0.length < l1 + i)
            {
                throw new OutputLengthException("Output buffer too short.");
            }
            System.arraycopy(abyte1, l1 + 0, avM, 0, auF);
            sicblockcipher._mth02CA(avM, 0, avM, 0);
            int j1 = auF;
            int l;
            int k1;
            do
            {
                l = ((flag1) ? 1 : 0);
                k1 = j;
                if (j1 == avM.length)
                {
                    break;
                }
                avM[j1] = 0;
                j1++;
            } while (true);
            for (; l < (l1 + 0) - kY; l += kY)
            {
                sicblockcipher._mth02CA(abyte1, l, abyte0, k1);
                k1 += kY;
            }

            byte abyte4[] = new byte[kY];
            System.arraycopy(abyte1, l, abyte4, 0, l1 - l);
            sicblockcipher._mth02CA(abyte4, 0, abyte4, 0);
            System.arraycopy(abyte4, 0, abyte0, k1, l1 - l);
            abyte1 = new byte[kY];
            _mth02CA(abyte0, i, l1, abyte1);
            i = l1;
            if (!Arrays._mth1428(avM, abyte1))
            {
                throw new InvalidCipherTextException("mac check in CCM failed");
            }
        }
        amz.reset();
        avN.reset();
        avO.reset();
        return i;
    }

    public final int getOutputSize(int i)
    {
        i += avO.size();
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
        if (cipherparameters instanceof AEADParameters)
        {
            cipherparameters = (AEADParameters)cipherparameters;
            XD = ((AEADParameters) (cipherparameters)).XD;
            avK = ((AEADParameters) (cipherparameters)).awP;
            auF = ((AEADParameters) (cipherparameters)).auF / 8;
            cipherparameters = ((AEADParameters) (cipherparameters)).avZ;
        } else
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters = (ParametersWithIV)cipherparameters;
            XD = ((ParametersWithIV) (cipherparameters)).iv;
            avK = null;
            auF = avM.length / 2;
            cipherparameters = ((ParametersWithIV) (cipherparameters)).axC;
        } else
        {
            throw new IllegalArgumentException("invalid parameters passed to CCM");
        }
        if (cipherparameters != null)
        {
            avL = cipherparameters;
        }
        if (XD == null || XD.length < 7 || XD.length > 13)
        {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        } else
        {
            amz.reset();
            avN.reset();
            avO.reset();
            return;
        }
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (abyte0.length < i + j)
        {
            throw new DataLengthException("Input buffer too short");
        } else
        {
            avO.write(abyte0, i, j);
            return 0;
        }
    }

    public final void _mth1428(byte abyte0[], int i, int j)
    {
        avN.write(abyte0, i, j);
    }

    public final BlockCipher _mth14AD()
    {
        return amz;
    }

    public final int _mth1550(int i)
    {
        return 0;
    }
}
