// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.MaxBytesExceededException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;

public class Salsa20Engine
    implements SkippingStreamCipher
{

    protected static final byte asW[] = Strings.FEE7("expand 32-byte k");
    protected static final byte asX[] = Strings.FEE7("expand 16-byte k");
    private boolean aqH;
    protected int arY[];
    protected int asY;
    protected int asZ[];
    private byte asd[];
    private int ata;
    private int atb;
    private int atc;
    private int index;

    public Salsa20Engine()
    {
        this(20);
    }

    public Salsa20Engine(int i)
    {
        index = 0;
        arY = new int[16];
        asZ = new int[16];
        asd = new byte[64];
        aqH = false;
        if (i <= 0 || (i & 1) != 0)
        {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        } else
        {
            asY = i;
            return;
        }
    }

    public static void _mth02CA(int i, int ai[], int ai1[])
    {
        if (ai.length != 16)
        {
            throw new IllegalArgumentException();
        }
        if (ai1.length != 16)
        {
            throw new IllegalArgumentException();
        }
        if (i % 2 != 0)
        {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        int j3 = ai[0];
        int k2 = ai[1];
        int l1 = ai[2];
        int i1 = ai[3];
        int i4 = ai[4];
        int j2 = ai[5];
        int k1 = ai[6];
        int l = ai[7];
        int l3 = ai[8];
        int i3 = ai[9];
        int j1 = ai[10];
        int k = ai[11];
        int k3 = ai[12];
        int l2 = ai[13];
        int i2 = ai[14];
        int j = ai[15];
        for (; i > 0; i -= 2)
        {
            int j4 = j3 + k3;
            i4 ^= j4 << 7 | j4 >>> -7;
            j4 = i4 + j3;
            l3 ^= j4 << 9 | j4 >>> -9;
            j4 = l3 + i4;
            k3 ^= j4 << 13 | j4 >>> -13;
            j4 = k3 + l3;
            j3 ^= j4 << 18 | j4 >>> -18;
            j4 = j2 + k2;
            i3 ^= j4 << 7 | j4 >>> -7;
            j4 = i3 + j2;
            l2 ^= j4 << 9 | j4 >>> -9;
            j4 = l2 + i3;
            k2 ^= j4 << 13 | j4 >>> -13;
            j4 = k2 + l2;
            j2 ^= j4 << 18 | j4 >>> -18;
            j4 = j1 + k1;
            i2 ^= j4 << 7 | j4 >>> -7;
            j4 = i2 + j1;
            l1 ^= j4 << 9 | j4 >>> -9;
            j4 = l1 + i2;
            k1 ^= j4 << 13 | j4 >>> -13;
            j4 = k1 + l1;
            j1 ^= j4 << 18 | j4 >>> -18;
            j4 = j + k;
            i1 ^= j4 << 7 | j4 >>> -7;
            j4 = i1 + j;
            l ^= j4 << 9 | j4 >>> -9;
            j4 = l + i1;
            k ^= j4 << 13 | j4 >>> -13;
            j4 = k + l;
            j ^= j4 << 18 | j4 >>> -18;
            j4 = j3 + i1;
            k2 ^= j4 << 7 | j4 >>> -7;
            j4 = k2 + j3;
            l1 ^= j4 << 9 | j4 >>> -9;
            j4 = l1 + k2;
            i1 ^= j4 << 13 | j4 >>> -13;
            j4 = i1 + l1;
            j3 ^= j4 << 18 | j4 >>> -18;
            j4 = j2 + i4;
            k1 ^= j4 << 7 | j4 >>> -7;
            j4 = k1 + j2;
            l ^= j4 << 9 | j4 >>> -9;
            j4 = l + k1;
            i4 ^= j4 << 13 | j4 >>> -13;
            j4 = i4 + l;
            j2 ^= j4 << 18 | j4 >>> -18;
            j4 = j1 + i3;
            k ^= j4 << 7 | j4 >>> -7;
            j4 = k + j1;
            l3 ^= j4 << 9 | j4 >>> -9;
            j4 = l3 + k;
            i3 ^= j4 << 13 | j4 >>> -13;
            j4 = i3 + l3;
            j1 ^= j4 << 18 | j4 >>> -18;
            j4 = j + i2;
            k3 ^= j4 << 7 | j4 >>> -7;
            j4 = k3 + j;
            l2 ^= j4 << 9 | j4 >>> -9;
            j4 = l2 + k3;
            i2 ^= j4 << 13 | j4 >>> -13;
            j4 = i2 + l2;
            j ^= j4 << 18 | j4 >>> -18;
        }

        ai1[0] = ai[0] + j3;
        ai1[1] = ai[1] + k2;
        ai1[2] = ai[2] + l1;
        ai1[3] = ai[3] + i1;
        ai1[4] = ai[4] + i4;
        ai1[5] = ai[5] + j2;
        ai1[6] = ai[6] + k1;
        ai1[7] = ai[7] + l;
        ai1[8] = ai[8] + l3;
        ai1[9] = ai[9] + i3;
        ai1[10] = ai[10] + j1;
        ai1[11] = ai[11] + k;
        ai1[12] = ai[12] + k3;
        ai1[13] = ai[13] + l2;
        ai1[14] = ai[14] + i2;
        ai1[15] = ai[15] + j;
    }

    public final void reset()
    {
        index = 0;
        ata = 0;
        atb = 0;
        atc = 0;
        _mth1D2B();
        _mth1D62(asd);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof ParametersWithIV))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(_mth14AC()).append(" Init parameters must include an IV").toString());
        }
        Object obj = (ParametersWithIV)cipherparameters;
        cipherparameters = ((ParametersWithIV) (obj)).iv;
        if (cipherparameters == null || cipherparameters.length != _mth2164())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(_mth14AC()).append(" requires exactly ").append(_mth2164()).append(" bytes of IV").toString());
        }
        obj = ((ParametersWithIV) (obj)).axC;
        if (obj == null)
        {
            if (!aqH)
            {
                throw new IllegalStateException((new StringBuilder()).append(_mth14AC()).append(" KeyParameter can not be null for first initialisation").toString());
            }
            _mth02CB(null, cipherparameters);
        } else
        if (obj instanceof KeyParameter)
        {
            _mth02CB(((KeyParameter)obj).key, cipherparameters);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append(_mth14AC()).append(" Init parameters must contain a KeyParameter (or null for re-init)").toString());
        }
        reset();
        aqH = true;
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        boolean flag;
label0:
        {
            if (!aqH)
            {
                throw new IllegalStateException((new StringBuilder()).append(_mth14AC()).append(" not initialised").toString());
            }
            if (i + j > abyte0.length)
            {
                throw new DataLengthException("input buffer too short");
            }
            if (k + j > abyte1.length)
            {
                throw new OutputLengthException("output buffer too short");
            }
            ata = ata + j;
            if (ata < j && ata >= 0)
            {
                int l = atb + 1;
                atb = l;
                if (l == 0)
                {
                    int i1 = atc + 1;
                    atc = i1;
                    if ((i1 & 0x20) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    break label0;
                }
            }
            flag = false;
        }
        if (flag)
        {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
        for (int j1 = 0; j1 < j; j1++)
        {
            abyte1[j1 + k] = (byte)(asd[index] ^ abyte0[j1 + i]);
            index = index + 1 & 0x3f;
            if (index == 0)
            {
                _mth1D12();
                _mth1D62(asd);
            }
        }

        return j;
    }

    protected void _mth02CB(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != null)
        {
            if (abyte0.length != 16 && abyte0.length != 32)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(_mth14AC()).append(" requires 128 bit or 256 bit key").toString());
            }
            arY[1] = Pack._mth02C6(abyte0, 0);
            arY[2] = Pack._mth02C6(abyte0, 4);
            arY[3] = Pack._mth02C6(abyte0, 8);
            arY[4] = Pack._mth02C6(abyte0, 12);
            byte abyte2[];
            byte byte0;
            if (abyte0.length == 32)
            {
                abyte2 = asW;
                byte0 = 16;
            } else
            {
                abyte2 = asX;
                byte0 = 0;
            }
            arY[11] = Pack._mth02C6(abyte0, byte0);
            arY[12] = Pack._mth02C6(abyte0, byte0 + 4);
            arY[13] = Pack._mth02C6(abyte0, byte0 + 8);
            arY[14] = Pack._mth02C6(abyte0, byte0 + 12);
            arY[0] = Pack._mth02C6(abyte2, 0);
            arY[5] = Pack._mth02C6(abyte2, 4);
            arY[10] = Pack._mth02C6(abyte2, 8);
            arY[15] = Pack._mth02C6(abyte2, 12);
        }
        arY[6] = Pack._mth02C6(abyte1, 0);
        arY[7] = Pack._mth02C6(abyte1, 4);
    }

    public String _mth14AC()
    {
        String s = "Salsa20";
        if (asY != 20)
        {
            s = (new StringBuilder()).append("Salsa20").append("/").append(asY).toString();
        }
        return s;
    }

    protected void _mth1D12()
    {
        int ai[] = arY;
        int i = ai[8] + 1;
        ai[8] = i;
        if (i == 0)
        {
            int ai1[] = arY;
            ai1[9] = ai1[9] + 1;
        }
    }

    protected void _mth1D2B()
    {
        int ai[] = arY;
        arY[9] = 0;
        ai[8] = 0;
    }

    protected void _mth1D62(byte abyte0[])
    {
        _mth02CA(asY, arY, asZ);
        Pack._mth02CE(asZ, abyte0, 0);
    }

    protected int _mth2164()
    {
        return 8;
    }

}
