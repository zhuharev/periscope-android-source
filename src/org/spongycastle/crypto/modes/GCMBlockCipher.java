// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.modes.gcm.GCMExponentiator;
import org.spongycastle.crypto.modes.gcm.GCMMultiplier;
import org.spongycastle.crypto.modes.gcm.Tables1kGCMExponentiator;
import org.spongycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.modes:
//            AEADBlockCipher

public class GCMBlockCipher
    implements AEADBlockCipher
{

    private byte XD[];
    private int amw;
    private boolean amy;
    public BlockCipher amz;
    private byte anc[];
    private byte anp[];
    private int auF;
    private byte avK[];
    private byte avM[];
    private byte avW[];
    public GCMMultiplier awb;
    private Tables1kGCMExponentiator awc;
    private byte awd[];
    public byte awe[];
    private byte awf[];
    private byte awg[];
    private long awh;
    public byte awi[];
    public int awj;
    public long awk;
    private long awl;

    public GCMBlockCipher(BlockCipher blockcipher)
    {
        this(blockcipher, null);
    }

    private GCMBlockCipher(BlockCipher blockcipher, GCMMultiplier gcmmultiplier)
    {
        if (blockcipher.getBlockSize() != 16)
        {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        } else
        {
            gcmmultiplier = new Tables8kGCMMultiplier();
            amz = blockcipher;
            awb = gcmmultiplier;
            return;
        }
    }

    private void _mth010D()
    {
        if (awk > 0L)
        {
            System.arraycopy(awe, 0, awf, 0, 16);
            awl = awk;
        }
        if (awj > 0)
        {
            byte abyte0[] = awf;
            byte abyte1[] = awi;
            int i = awj;
            do
            {
                int j = i - 1;
                if (i <= 0)
                {
                    break;
                }
                abyte0[j] = (byte)(abyte0[j] ^ abyte1[j + 0]);
                i = j;
            } while (true);
            awb._mth1429(abyte0);
            awl = awl + (long)awj;
        }
        if (awl > 0L)
        {
            System.arraycopy(awf, 0, anp, 0, 16);
        }
    }

    private byte[] _mth017C()
    {
        int i = 15;
        do
        {
            if (i < 12)
            {
                break;
            }
            byte byte0 = (byte)(awg[i] + 1);
            awg[i] = byte0;
            if (byte0 != 0)
            {
                break;
            }
            i--;
        } while (true);
        byte abyte0[] = new byte[16];
        amz._mth02CA(awg, 0, abyte0, 0);
        return abyte0;
    }

    private void _mth02CF(byte abyte0[], byte abyte1[], int i)
    {
        for (int k = 0; k < i; k += 16)
        {
            int j = Math.min(i - k, 16);
            do
            {
                int l = j - 1;
                if (j <= 0)
                {
                    break;
                }
                abyte0[l] = (byte)(abyte0[l] ^ abyte1[k + l]);
                j = l;
            } while (true);
            awb._mth1429(abyte0);
        }

    }

    public static void _mth141D(byte abyte0[], byte abyte1[])
    {
        for (int i = 15; i >= 0; i--)
        {
            abyte0[i] = (byte)(abyte0[i] ^ abyte1[i]);
        }

    }

    public final int doFinal(byte abyte0[], int i)
    {
        if (awh == 0L)
        {
            _mth010D();
        }
        int k = amw;
        int j = k;
        if (!amy)
        {
            if (k < auF)
            {
                throw new InvalidCipherTextException("data too short");
            }
            j = k - auF;
        }
        if (j > 0)
        {
            if (abyte0.length < i + j)
            {
                throw new OutputLengthException("Output buffer too short");
            }
            byte abyte1[] = avW;
            byte abyte6[] = _mth017C();
            k = j;
            do
            {
                int l = k - 1;
                if (k <= 0)
                {
                    break;
                }
                abyte6[l] = (byte)(abyte6[l] ^ abyte1[l + 0]);
                k = l;
            } while (true);
            System.arraycopy(abyte6, 0, abyte0, i, j);
            byte abyte11[] = anp;
            if (amy)
            {
                abyte1 = abyte6;
            }
            k = j;
            do
            {
                int i1 = k - 1;
                if (k <= 0)
                {
                    break;
                }
                abyte11[i1] = (byte)(abyte11[i1] ^ abyte1[i1 + 0]);
                k = i1;
            } while (true);
            awb._mth1429(abyte11);
            awh = awh + (long)j;
        }
        awk = awk + (long)awj;
        if (awk > awl)
        {
            if (awj > 0)
            {
                byte abyte2[] = awe;
                byte abyte7[] = awi;
                k = awj;
                do
                {
                    int j1 = k - 1;
                    if (k <= 0)
                    {
                        break;
                    }
                    abyte2[j1] = (byte)(abyte2[j1] ^ abyte7[j1 + 0]);
                    k = j1;
                } while (true);
                awb._mth1429(abyte2);
            }
            if (awl > 0L)
            {
                byte abyte3[] = awe;
                byte abyte8[] = awf;
                for (k = 15; k >= 0; k--)
                {
                    abyte3[k] = (byte)(abyte3[k] ^ abyte8[k]);
                }

            }
            long l2 = awh;
            byte abyte4[] = new byte[16];
            if (awc == null)
            {
                awc = new Tables1kGCMExponentiator();
                awc.init(anc);
            }
            awc._mth02CB((l2 << 3) + 127L >>> 7, abyte4);
            byte abyte9[] = awe;
            byte abyte12[] = Arrays._mth1D4C(abyte9);
            byte abyte13[] = new byte[16];
            for (k = 0; k < 16; k++)
            {
                byte byte0 = abyte4[k];
                for (int k1 = 7; k1 >= 0; k1--)
                {
                    if ((1 << k1 & byte0) != 0)
                    {
                        for (int l1 = 15; l1 >= 0; l1--)
                        {
                            abyte13[l1] = (byte)(abyte13[l1] ^ abyte12[l1]);
                        }

                    }
                    boolean flag;
                    if ((abyte12[15] & 1) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    int i2 = 0;
                    int j2 = 0;
                    do
                    {
                        int k2 = abyte12[i2] & 0xff;
                        abyte12[i2] = (byte)(k2 >>> 1 | j2);
                        i2++;
                        if (i2 == 16)
                        {
                            break;
                        }
                        j2 = (k2 & 1) << 7;
                    } while (true);
                    if (flag)
                    {
                        abyte12[0] = (byte)(abyte12[0] ^ 0xffffffe1);
                    }
                }

            }

            System.arraycopy(abyte13, 0, abyte9, 0, 16);
            abyte4 = anp;
            abyte9 = awe;
            for (k = 15; k >= 0; k--)
            {
                abyte4[k] = (byte)(abyte4[k] ^ abyte9[k]);
            }

        }
        byte abyte5[] = new byte[16];
        Pack._mth02CF(awk << 3, abyte5, 0);
        Pack._mth02CF(awh << 3, abyte5, 8);
        byte abyte10[] = anp;
        for (k = 15; k >= 0; k--)
        {
            abyte10[k] = (byte)(abyte10[k] ^ abyte5[k]);
        }

        awb._mth1429(abyte10);
        abyte5 = new byte[16];
        amz._mth02CA(awd, 0, abyte5, 0);
        abyte10 = anp;
        for (k = 15; k >= 0; k--)
        {
            abyte5[k] = (byte)(abyte5[k] ^ abyte10[k]);
        }

        k = j;
        avM = new byte[auF];
        System.arraycopy(abyte5, 0, avM, 0, auF);
        if (amy)
        {
            if (abyte0.length < i + j + auF)
            {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(avM, 0, abyte0, amw + i, auF);
            k += auF;
        } else
        {
            abyte0 = new byte[auF];
            System.arraycopy(avW, j, abyte0, 0, auF);
            if (!Arrays._mth1428(avM, abyte0))
            {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        _mth06E6(false);
        return k;
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
        avM = null;
        if (cipherparameters instanceof AEADParameters)
        {
            cipherparameters = (AEADParameters)cipherparameters;
            XD = ((AEADParameters) (cipherparameters)).XD;
            avK = ((AEADParameters) (cipherparameters)).awP;
            int i = ((AEADParameters) (cipherparameters)).auF;
            if (i < 32 || i > 128 || i % 8 != 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Invalid value for MAC size: ")).append(i).toString());
            }
            auF = i / 8;
            cipherparameters = ((AEADParameters) (cipherparameters)).avZ;
        } else
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters = (ParametersWithIV)cipherparameters;
            XD = ((ParametersWithIV) (cipherparameters)).iv;
            avK = null;
            auF = 16;
            cipherparameters = (KeyParameter)((ParametersWithIV) (cipherparameters)).axC;
        } else
        {
            throw new IllegalArgumentException("invalid parameters passed to GCM");
        }
        int j;
        if (flag)
        {
            j = 16;
        } else
        {
            j = auF + 16;
        }
        avW = new byte[j];
        if (XD == null || XD.length <= 0)
        {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (cipherparameters != null)
        {
            amz._mth02CA(true, cipherparameters);
            anc = new byte[16];
            amz._mth02CA(anc, 0, anc, 0);
            awb.init(anc);
            awc = null;
        } else
        if (anc == null)
        {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        awd = new byte[16];
        if (XD.length == 12)
        {
            System.arraycopy(XD, 0, awd, 0, XD.length);
            awd[15] = 1;
        } else
        {
            _mth02CF(awd, XD, XD.length);
            cipherparameters = new byte[16];
            Pack._mth02CF((long)XD.length << 3, cipherparameters, 8);
            _mth02CF(awd, cipherparameters);
        }
        anp = new byte[16];
        awe = new byte[16];
        awf = new byte[16];
        awi = new byte[16];
        awj = 0;
        awk = 0L;
        awl = 0L;
        awg = Arrays._mth1D4C(awd);
        amw = 0;
        awh = 0L;
        if (avK != null)
        {
            _mth1428(avK, 0, avK.length);
        }
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (abyte0.length < i + j)
        {
            throw new DataLengthException("Input buffer too short");
        }
        int i1 = 0;
        for (int l = 0; l < j;)
        {
            avW[amw] = abyte0[i + l];
            int k1 = amw + 1;
            amw = k1;
            int j1 = i1;
            if (k1 == avW.length)
            {
                int l1 = k + i1;
                if (abyte1.length < l1 + 16)
                {
                    throw new OutputLengthException("Output buffer too short");
                }
                if (awh == 0L)
                {
                    _mth010D();
                }
                byte abyte2[] = avW;
                byte abyte3[] = _mth017C();
                for (j1 = 15; j1 >= 0; j1--)
                {
                    abyte3[j1] = (byte)(abyte3[j1] ^ abyte2[j1]);
                }

                System.arraycopy(abyte3, 0, abyte1, l1, 16);
                byte abyte4[] = anp;
                if (amy)
                {
                    abyte2 = abyte3;
                }
                for (j1 = 15; j1 >= 0; j1--)
                {
                    abyte4[j1] = (byte)(abyte4[j1] ^ abyte2[j1]);
                }

                awb._mth1429(abyte4);
                awh = awh + 16L;
                if (amy)
                {
                    amw = 0;
                } else
                {
                    System.arraycopy(avW, 16, avW, 0, auF);
                    amw = auF;
                }
                j1 = i1 + 16;
            }
            l++;
            i1 = j1;
        }

        return i1;
    }

    public void _mth02CF(byte abyte0[], byte abyte1[])
    {
        for (int i = 15; i >= 0; i--)
        {
            abyte0[i] = (byte)(abyte0[i] ^ abyte1[i]);
        }

        awb._mth1429(abyte0);
    }

    public void _mth06E6(boolean flag)
    {
        amz.reset();
        anp = new byte[16];
        awe = new byte[16];
        awf = new byte[16];
        awi = new byte[16];
        awj = 0;
        awk = 0L;
        awl = 0L;
        awg = Arrays._mth1D4C(awd);
        amw = 0;
        awh = 0L;
        if (avW != null)
        {
            Arrays.fill(avW, (byte)0);
        }
        if (flag)
        {
            avM = null;
        }
        if (avK != null)
        {
            _mth1428(avK, 0, avK.length);
        }
    }

    public final void _mth1428(byte abyte0[], int i, int j)
    {
        for (int k = 0; k < j; k++)
        {
            awi[awj] = abyte0[i + k];
            int l = awj + 1;
            awj = l;
            if (l != 16)
            {
                continue;
            }
            byte abyte1[] = awe;
            byte abyte2[] = awi;
            for (int i1 = 15; i1 >= 0; i1--)
            {
                abyte1[i1] = (byte)(abyte1[i1] ^ abyte2[i1]);
            }

            awb._mth1429(abyte1);
            awj = 0;
            awk = awk + 16L;
        }

    }

    public final BlockCipher _mth14AD()
    {
        return amz;
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
        return i - i % 16;
    }
}
