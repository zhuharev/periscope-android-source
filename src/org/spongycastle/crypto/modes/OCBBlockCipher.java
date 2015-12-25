// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import java.util.Vector;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes:
//            AEADBlockCipher

public class OCBBlockCipher
    implements AEADBlockCipher
{

    private boolean amy;
    private byte anf[];
    private int auF;
    private byte avK[];
    private byte avM[];
    private int awA;
    private int awB;
    private long awC;
    private long awD;
    private byte awE[];
    private byte awF[];
    private byte awG[];
    private BlockCipher awq;
    private BlockCipher awr;
    private Vector aws;
    private byte awt[];
    private byte awu[];
    private byte awv[];
    private byte aww[];
    private byte awx[];
    private byte awy[];
    private byte awz[];

    public OCBBlockCipher(BlockCipher blockcipher, BlockCipher blockcipher1)
    {
        awv = null;
        aww = new byte[24];
        awx = new byte[16];
        awF = new byte[16];
        if (blockcipher == null)
        {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        }
        if (blockcipher.getBlockSize() != 16)
        {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        }
        if (blockcipher1 == null)
        {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        }
        if (blockcipher1.getBlockSize() != 16)
        {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        if (!blockcipher._mth14AC().equals(blockcipher1._mth14AC()))
        {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        } else
        {
            awq = blockcipher;
            awr = blockcipher1;
            return;
        }
    }

    private static int _mth02BB(byte abyte0[], byte abyte1[])
    {
        int j = 16;
        int i = 0;
        do
        {
            j--;
            if (j >= 0)
            {
                int k = abyte0[j] & 0xff;
                abyte1[j] = (byte)(k << 1 | i);
                i = k >>> 7 & 1;
            } else
            {
                return i;
            }
        } while (true);
    }

    private int _mth06E5(byte abyte0[])
    {
        byte abyte1[] = new byte[16];
        System.arraycopy(abyte0, 0, abyte1, 16 - abyte0.length, abyte0.length);
        abyte1[0] = (byte)(auF << 4);
        int i = 15 - abyte0.length;
        abyte1[i] = (byte)(abyte1[i] | 1);
        byte byte0 = abyte1[15];
        abyte1[15] = (byte)(abyte1[15] & 0xc0);
        if (awv == null || !Arrays._mth1427(abyte1, awv))
        {
            abyte0 = new byte[16];
            awv = abyte1;
            awq._mth02CA(awv, 0, abyte0, 0);
            System.arraycopy(abyte0, 0, aww, 0, 16);
            for (int j = 0; j < 8; j++)
            {
                aww[j + 16] = (byte)(abyte0[j] ^ abyte0[j + 1]);
            }

        }
        return byte0 & 0x3f;
    }

    private void _mth1420(byte abyte0[])
    {
        byte abyte1[] = awE;
        for (int i = 15; i >= 0; i--)
        {
            abyte1[i] = (byte)(abyte1[i] ^ abyte0[i]);
        }

        abyte0 = awy;
        abyte1 = awE;
        for (int j = 15; j >= 0; j--)
        {
            abyte0[j] = (byte)(abyte0[j] ^ abyte1[j]);
        }

        awq._mth02CA(awy, 0, awy, 0);
        abyte0 = anf;
        abyte1 = awy;
        for (int k = 15; k >= 0; k--)
        {
            abyte0[k] = (byte)(abyte0[k] ^ abyte1[k]);
        }

    }

    private static byte[] _mth1423(byte abyte0[])
    {
        byte abyte1[] = new byte[16];
        int i = _mth02BB(abyte0, abyte1);
        abyte1[15] = (byte)(abyte1[15] ^ 135 >>> (1 - i << 3));
        return abyte1;
    }

    private byte[] FF86(int i)
    {
        Vector vector;
        byte abyte1[];
        for (; i >= aws.size(); vector.addElement(abyte1))
        {
            vector = aws;
            byte abyte0[] = (byte[])aws.lastElement();
            abyte1 = new byte[16];
            int j = _mth02BB(abyte0, abyte1);
            abyte1[15] = (byte)(abyte1[15] ^ 135 >>> (1 - j << 3));
        }

        return (byte[])aws.elementAt(i);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = null;
        if (!amy)
        {
            if (awB < auF)
            {
                throw new InvalidCipherTextException("data too short");
            }
            awB = awB - auF;
            abyte1 = new byte[auF];
            System.arraycopy(awz, awB, abyte1, 0, auF);
        }
        if (awA > 0)
        {
            byte abyte2[] = awy;
            int j = awA;
            abyte2[j] = -128;
            do
            {
                j++;
                if (j >= 16)
                {
                    break;
                }
                abyte2[j] = 0;
            } while (true);
            _mth1420(awt);
        }
        if (awB > 0)
        {
            if (amy)
            {
                byte abyte3[] = awz;
                int k = awB;
                abyte3[k] = -128;
                do
                {
                    k++;
                    if (k >= 16)
                    {
                        break;
                    }
                    abyte3[k] = 0;
                } while (true);
                abyte3 = awG;
                byte abyte7[] = awz;
                for (int l = 15; l >= 0; l--)
                {
                    abyte3[l] = (byte)(abyte3[l] ^ abyte7[l]);
                }

            }
            byte abyte4[] = awF;
            byte abyte8[] = awt;
            for (int i1 = 15; i1 >= 0; i1--)
            {
                abyte4[i1] = (byte)(abyte4[i1] ^ abyte8[i1]);
            }

            abyte4 = new byte[16];
            awq._mth02CA(awF, 0, abyte4, 0);
            abyte8 = awz;
            for (int j1 = 15; j1 >= 0; j1--)
            {
                abyte8[j1] = (byte)(abyte8[j1] ^ abyte4[j1]);
            }

            if (abyte0.length < awB + i)
            {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(awz, 0, abyte0, i, awB);
            if (!amy)
            {
                byte abyte5[] = awz;
                int k1 = awB;
                abyte5[k1] = -128;
                do
                {
                    k1++;
                    if (k1 >= 16)
                    {
                        break;
                    }
                    abyte5[k1] = 0;
                } while (true);
                abyte5 = awG;
                byte abyte9[] = awz;
                for (int l1 = 15; l1 >= 0; l1--)
                {
                    abyte5[l1] = (byte)(abyte5[l1] ^ abyte9[l1]);
                }

            }
        }
        byte abyte6[] = awG;
        byte abyte10[] = awF;
        for (int i2 = 15; i2 >= 0; i2--)
        {
            abyte6[i2] = (byte)(abyte6[i2] ^ abyte10[i2]);
        }

        abyte6 = awG;
        abyte10 = awu;
        for (int j2 = 15; j2 >= 0; j2--)
        {
            abyte6[j2] = (byte)(abyte6[j2] ^ abyte10[j2]);
        }

        awq._mth02CA(awG, 0, awG, 0);
        abyte6 = awG;
        abyte10 = anf;
        for (int k2 = 15; k2 >= 0; k2--)
        {
            abyte6[k2] = (byte)(abyte6[k2] ^ abyte10[k2]);
        }

        avM = new byte[auF];
        System.arraycopy(awG, 0, avM, 0, auF);
        int l2 = awB;
        if (amy)
        {
            if (abyte0.length < i + l2 + auF)
            {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(avM, 0, abyte0, i + l2, auF);
            i = l2 + auF;
        } else
        {
            i = l2;
            if (!Arrays._mth1428(avM, abyte1))
            {
                throw new InvalidCipherTextException("mac check in OCB failed");
            }
        }
        awq.reset();
        awr.reset();
        abyte0 = awy;
        if (abyte0 != null)
        {
            Arrays.fill(abyte0, (byte)0);
        }
        abyte0 = awz;
        if (abyte0 != null)
        {
            Arrays.fill(abyte0, (byte)0);
        }
        awA = 0;
        awB = 0;
        awC = 0L;
        awD = 0L;
        abyte0 = awE;
        if (abyte0 != null)
        {
            Arrays.fill(abyte0, (byte)0);
        }
        abyte0 = anf;
        if (abyte0 != null)
        {
            Arrays.fill(abyte0, (byte)0);
        }
        System.arraycopy(awx, 0, awF, 0, 16);
        abyte0 = awG;
        if (abyte0 != null)
        {
            Arrays.fill(abyte0, (byte)0);
        }
        if (avK != null)
        {
            _mth1428(avK, 0, avK.length);
        }
        return i;
    }

    public final int getOutputSize(int i)
    {
        i += awB;
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
        boolean flag1 = amy;
        amy = flag;
        avM = null;
        Object obj;
        if (cipherparameters instanceof AEADParameters)
        {
            obj = (AEADParameters)cipherparameters;
            cipherparameters = ((AEADParameters) (obj)).XD;
            avK = ((AEADParameters) (obj)).awP;
            int i = ((AEADParameters) (obj)).auF;
            if (i < 64 || i > 128 || i % 8 != 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Invalid value for MAC size: ")).append(i).toString());
            }
            auF = i / 8;
            obj = ((AEADParameters) (obj)).avZ;
        } else
        if (cipherparameters instanceof ParametersWithIV)
        {
            obj = (ParametersWithIV)cipherparameters;
            cipherparameters = ((ParametersWithIV) (obj)).iv;
            avK = null;
            auF = 16;
            obj = (KeyParameter)((ParametersWithIV) (obj)).axC;
        } else
        {
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        awy = new byte[16];
        int j;
        if (flag)
        {
            j = 16;
        } else
        {
            j = auF + 16;
        }
        awz = new byte[j];
        byte abyte0[] = cipherparameters;
        if (cipherparameters == null)
        {
            abyte0 = new byte[0];
        }
        if (abyte0.length > 15)
        {
            throw new IllegalArgumentException("IV must be no more than 15 bytes");
        }
        if (obj != null)
        {
            awq._mth02CA(true, ((CipherParameters) (obj)));
            awr._mth02CA(flag, ((CipherParameters) (obj)));
            awv = null;
        } else
        if (flag1 != flag)
        {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
        awt = new byte[16];
        awq._mth02CA(awt, 0, awt, 0);
        awu = _mth1423(awt);
        aws = new Vector();
        aws.addElement(_mth1423(awu));
        j = _mth06E5(abyte0);
        int i1 = j % 8;
        int l = j / 8;
        if (i1 == 0)
        {
            System.arraycopy(aww, l, awx, 0, 16);
        } else
        {
            for (int k = 0; k < 16; k++)
            {
                byte byte0 = aww[l];
                cipherparameters = aww;
                l++;
                byte byte1 = cipherparameters[l];
                awx[k] = (byte)((byte0 & 0xff) << i1 | (byte1 & 0xff) >>> 8 - i1);
            }

        }
        awA = 0;
        awB = 0;
        awC = 0L;
        awD = 0L;
        awE = new byte[16];
        anf = new byte[16];
        System.arraycopy(awx, 0, awF, 0, 16);
        awG = new byte[16];
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
        int j1 = 0;
        for (int i1 = 0; i1 < j;)
        {
            awz[awB] = abyte0[i + i1];
            int k1 = awB + 1;
            awB = k1;
            int l = j1;
            if (k1 == awz.length)
            {
                int l1 = k + j1;
                if (abyte1.length < l1 + 16)
                {
                    throw new OutputLengthException("Output buffer too short");
                }
                if (amy)
                {
                    byte abyte2[] = awG;
                    byte abyte5[] = awz;
                    for (l = 15; l >= 0; l--)
                    {
                        abyte2[l] = (byte)(abyte2[l] ^ abyte5[l]);
                    }

                    awB = 0;
                }
                byte abyte3[] = awF;
                long l3 = awD + 1L;
                awD = l3;
                long l2 = l3;
                if (l3 == 0L)
                {
                    l = 64;
                } else
                {
                    l = 0;
                    for (; (1L & l2) == 0L; l2 >>>= 1)
                    {
                        l++;
                    }

                }
                byte abyte6[] = FF86(l);
                for (l = 15; l >= 0; l--)
                {
                    abyte3[l] = (byte)(abyte3[l] ^ abyte6[l]);
                }

                abyte3 = awz;
                abyte6 = awF;
                for (l = 15; l >= 0; l--)
                {
                    abyte3[l] = (byte)(abyte3[l] ^ abyte6[l]);
                }

                awr._mth02CA(awz, 0, awz, 0);
                abyte3 = awz;
                abyte6 = awF;
                for (l = 15; l >= 0; l--)
                {
                    abyte3[l] = (byte)(abyte3[l] ^ abyte6[l]);
                }

                System.arraycopy(awz, 0, abyte1, l1, 16);
                if (!amy)
                {
                    byte abyte4[] = awG;
                    byte abyte7[] = awz;
                    for (l = 15; l >= 0; l--)
                    {
                        abyte4[l] = (byte)(abyte4[l] ^ abyte7[l]);
                    }

                    System.arraycopy(awz, 16, awz, 0, auF);
                    awB = auF;
                }
                l = j1 + 16;
            }
            i1++;
            j1 = l;
        }

        return j1;
    }

    public final void _mth1428(byte abyte0[], int i, int j)
    {
        for (int l = 0; l < j; l++)
        {
            awy[awA] = abyte0[i + l];
            int k = awA + 1;
            awA = k;
            if (k != awy.length)
            {
                continue;
            }
            long l2 = awC + 1L;
            awC = l2;
            long l1 = l2;
            if (l2 == 0L)
            {
                k = 64;
            } else
            {
                k = 0;
                for (; (1L & l1) == 0L; l1 >>>= 1)
                {
                    k++;
                }

            }
            _mth1420(FF86(k));
            awA = 0;
        }

    }

    public final BlockCipher _mth14AD()
    {
        return awr;
    }

    public final int _mth1550(int i)
    {
        int j = i + awB;
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
