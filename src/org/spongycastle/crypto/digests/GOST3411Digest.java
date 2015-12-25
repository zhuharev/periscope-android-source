// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class GOST3411Digest
    implements ExtendedDigest, Memoable
{

    private static final byte ant[] = {
        0, -1, 0, -1, 0, -1, 0, -1, -1, 0, 
        -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, 
        -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 
        0, -1
    };
    private long VD;
    private byte anc[];
    private byte and[];
    private byte ane[];
    private byte anf[];
    private byte ang[][];
    private byte anh[];
    private int ani;
    private GOST28147Engine anj;
    private byte ank[];
    private byte anl[];
    private byte anm[];
    private short ann[];
    private short ano[];
    private byte anp[];
    private byte anq[];
    private byte anr[];
    private byte ans[];

    public GOST3411Digest()
    {
        anc = new byte[32];
        and = new byte[32];
        ane = new byte[32];
        anf = new byte[32];
        ang = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            4, 32
        });
        anh = new byte[32];
        anj = new GOST28147Engine();
        anl = new byte[32];
        anm = new byte[8];
        ann = new short[16];
        ano = new short[16];
        anp = new byte[32];
        anq = new byte[32];
        anr = new byte[32];
        ans = new byte[32];
        ank = GOST28147Engine._mth1541("D-A");
        anj._mth02CA(true, new ParametersWithSBox(null, ank));
        reset();
    }

    public GOST3411Digest(GOST3411Digest gost3411digest)
    {
        anc = new byte[32];
        and = new byte[32];
        ane = new byte[32];
        anf = new byte[32];
        ang = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            4, 32
        });
        anh = new byte[32];
        anj = new GOST28147Engine();
        anl = new byte[32];
        anm = new byte[8];
        ann = new short[16];
        ano = new short[16];
        anp = new byte[32];
        anq = new byte[32];
        anr = new byte[32];
        ans = new byte[32];
        _mth02CA(gost3411digest);
    }

    public GOST3411Digest(byte abyte0[])
    {
        anc = new byte[32];
        and = new byte[32];
        ane = new byte[32];
        anf = new byte[32];
        ang = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            4, 32
        });
        anh = new byte[32];
        anj = new GOST28147Engine();
        anl = new byte[32];
        anm = new byte[8];
        ann = new short[16];
        ano = new short[16];
        anp = new byte[32];
        anq = new byte[32];
        anr = new byte[32];
        ans = new byte[32];
        ank = Arrays._mth1D4C(abyte0);
        anj._mth02CA(true, new ParametersWithSBox(null, ank));
        reset();
    }

    private byte[] _mth02B9(byte abyte0[])
    {
        for (int i = 0; i < 8; i++)
        {
            anm[i] = (byte)(abyte0[i] ^ abyte0[i + 8]);
        }

        System.arraycopy(abyte0, 8, abyte0, 0, 24);
        System.arraycopy(anm, 0, abyte0, 24, 8);
        return abyte0;
    }

    private void _mth02CA(byte abyte0[], byte abyte1[], int i, byte abyte2[], int j)
    {
        anj._mth02CA(true, new KeyParameter(abyte0));
        anj._mth02CA(abyte2, j, abyte1, i);
    }

    private void _mth02CF(byte abyte0[], int i)
    {
        System.arraycopy(abyte0, 0, ane, 0, 32);
        System.arraycopy(anc, 0, anq, 0, 32);
        System.arraycopy(ane, 0, anr, 0, 32);
        for (i = 0; i < 32; i++)
        {
            ans[i] = (byte)(anq[i] ^ anr[i]);
        }

        _mth02CA(FF9E(ans), anp, 0, anc, 0);
        for (i = 1; i < 4; i++)
        {
            abyte0 = _mth02B9(anq);
            for (int j = 0; j < 32; j++)
            {
                anq[j] = (byte)(abyte0[j] ^ ang[i][j]);
            }

            anr = _mth02B9(_mth02B9(anr));
            for (int k = 0; k < 32; k++)
            {
                ans[k] = (byte)(anq[k] ^ anr[k]);
            }

            _mth02CA(FF9E(ans), anp, i << 3, anc, i << 3);
        }

        for (i = 0; i < 12; i++)
        {
            _mth0559(anp);
        }

        for (i = 0; i < 32; i++)
        {
            abyte0 = anp;
            abyte0[i] = (byte)(abyte0[i] ^ ane[i]);
        }

        _mth0559(anp);
        for (i = 0; i < 32; i++)
        {
            anp[i] = (byte)(anc[i] ^ anp[i]);
        }

        for (i = 0; i < 61; i++)
        {
            _mth0559(anp);
        }

        System.arraycopy(anp, 0, anc, 0, anc.length);
    }

    private void _mth0559(byte abyte0[])
    {
        short aword0[] = ann;
        for (int i = 0; i < abyte0.length / 2; i++)
        {
            aword0[i] = (short)(abyte0[(i << 1) + 1] << 8 & 0xff00 | abyte0[i << 1] & 0xff);
        }

        ano[15] = (short)(ann[0] ^ ann[1] ^ ann[2] ^ ann[3] ^ ann[12] ^ ann[15]);
        System.arraycopy(ann, 1, ano, 0, 15);
        aword0 = ano;
        for (int j = 0; j < abyte0.length / 2; j++)
        {
            abyte0[(j << 1) + 1] = (byte)(aword0[j] >> 8);
            abyte0[j << 1] = (byte)aword0[j];
        }

    }

    private void _mth05D9(byte abyte0[])
    {
        int j = 0;
        for (int i = 0; i != anf.length; i++)
        {
            j += (anf[i] & 0xff) + (abyte0[i] & 0xff);
            anf[i] = (byte)j;
            j >>>= 8;
        }

    }

    private byte[] FF9E(byte abyte0[])
    {
        for (int i = 0; i < 8; i++)
        {
            anl[i * 4] = abyte0[i];
            anl[i * 4 + 1] = abyte0[i + 8];
            anl[i * 4 + 2] = abyte0[i + 16];
            anl[i * 4 + 3] = abyte0[i + 24];
        }

        return anl;
    }

    public final int doFinal(byte abyte0[], int i)
    {
        Pack._mth141D(VD << 3, and, 0);
        while (ani != 0) 
        {
            update((byte)0);
        }
        _mth02CF(and, 0);
        _mth02CF(anf, 0);
        System.arraycopy(anc, 0, abyte0, i, anc.length);
        reset();
        return 32;
    }

    public final void reset()
    {
        VD = 0L;
        ani = 0;
        for (int i = 0; i < anc.length; i++)
        {
            anc[i] = 0;
        }

        for (int j = 0; j < and.length; j++)
        {
            and[j] = 0;
        }

        for (int k = 0; k < ane.length; k++)
        {
            ane[k] = 0;
        }

        for (int l = 0; l < ang[1].length; l++)
        {
            ang[1][l] = 0;
        }

        for (int i1 = 0; i1 < ang[3].length; i1++)
        {
            ang[3][i1] = 0;
        }

        for (int j1 = 0; j1 < anf.length; j1++)
        {
            anf[j1] = 0;
        }

        for (int k1 = 0; k1 < anh.length; k1++)
        {
            anh[k1] = 0;
        }

        System.arraycopy(ant, 0, ang[2], 0, 32);
    }

    public final void update(byte byte0)
    {
        byte abyte0[] = anh;
        int i = ani;
        ani = i + 1;
        abyte0[i] = byte0;
        if (ani == anh.length)
        {
            _mth05D9(anh);
            _mth02CF(anh, 0);
            ani = 0;
        }
        VD = VD + 1L;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        int k = j;
        int l = i;
        do
        {
            i = l;
            j = k;
            if (ani == 0)
            {
                break;
            }
            i = l;
            j = k;
            if (k <= 0)
            {
                break;
            }
            update(abyte0[l]);
            l++;
            k--;
        } while (true);
        do
        {
            k = i;
            l = j;
            if (j <= anh.length)
            {
                break;
            }
            System.arraycopy(abyte0, i, anh, 0, anh.length);
            _mth05D9(anh);
            _mth02CF(anh, 0);
            i += anh.length;
            j -= anh.length;
            VD = VD + (long)anh.length;
        } while (true);
        for (; l > 0; l--)
        {
            update(abyte0[k]);
            k++;
        }

    }

    public final void _mth02CA(Memoable memoable)
    {
        memoable = (GOST3411Digest)memoable;
        ank = ((GOST3411Digest) (memoable)).ank;
        anj._mth02CA(true, new ParametersWithSBox(null, ank));
        reset();
        System.arraycopy(((GOST3411Digest) (memoable)).anc, 0, anc, 0, ((GOST3411Digest) (memoable)).anc.length);
        System.arraycopy(((GOST3411Digest) (memoable)).and, 0, and, 0, ((GOST3411Digest) (memoable)).and.length);
        System.arraycopy(((GOST3411Digest) (memoable)).ane, 0, ane, 0, ((GOST3411Digest) (memoable)).ane.length);
        System.arraycopy(((GOST3411Digest) (memoable)).anf, 0, anf, 0, ((GOST3411Digest) (memoable)).anf.length);
        System.arraycopy(((GOST3411Digest) (memoable)).ang[1], 0, ang[1], 0, ((GOST3411Digest) (memoable)).ang[1].length);
        System.arraycopy(((GOST3411Digest) (memoable)).ang[2], 0, ang[2], 0, ((GOST3411Digest) (memoable)).ang[2].length);
        System.arraycopy(((GOST3411Digest) (memoable)).ang[3], 0, ang[3], 0, ((GOST3411Digest) (memoable)).ang[3].length);
        System.arraycopy(((GOST3411Digest) (memoable)).anh, 0, anh, 0, ((GOST3411Digest) (memoable)).anh.length);
        ani = ((GOST3411Digest) (memoable)).ani;
        VD = ((GOST3411Digest) (memoable)).VD;
    }

    public final String _mth14AC()
    {
        return "GOST3411";
    }

    public final int _mth14AF()
    {
        return 32;
    }

    public final int _mth14B2()
    {
        return 32;
    }

    public final Memoable _mth14B7()
    {
        return new GOST3411Digest(this);
    }

}
