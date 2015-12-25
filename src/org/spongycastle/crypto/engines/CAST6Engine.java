// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;


// Referenced classes of package org.spongycastle.crypto.engines:
//            CAST5Engine

public final class CAST6Engine extends CAST5Engine
{

    private int aqA[];
    private int aqE[];
    private int aqF[];
    private int aqG[];
    private int aqz[];

    public CAST6Engine()
    {
        aqz = new int[48];
        aqA = new int[48];
        aqE = new int[192];
        aqF = new int[192];
        aqG = new int[8];
    }

    public final int getBlockSize()
    {
        return 16;
    }

    public final void reset()
    {
    }

    protected final int _mth02CF(byte abyte0[], int i, byte abyte1[], int j)
    {
        int ai[] = new int[4];
        int i1 = _mth037A(abyte0, i);
        int k1 = _mth037A(abyte0, i + 4);
        int l = _mth037A(abyte0, i + 8);
        int k = _mth037A(abyte0, i + 12);
        i = k1;
        for (k1 = 0; k1 < 6; k1++)
        {
            int l1 = k1 << 2;
            l ^= _mth02D1(k, aqA[l1], aqz[l1]);
            i ^= _mth0640(l, aqA[l1 + 1], aqz[l1 + 1]);
            i1 ^= _mth1427(i, aqA[l1 + 2], aqz[l1 + 2]);
            k ^= _mth02D1(i1, aqA[l1 + 3], aqz[l1 + 3]);
        }

        byte byte0 = 6;
        k1 = i1;
        for (int j1 = byte0; j1 < 12; j1++)
        {
            int i2 = j1 << 2;
            k ^= _mth02D1(k1, aqA[i2 + 3], aqz[i2 + 3]);
            k1 ^= _mth1427(i, aqA[i2 + 2], aqz[i2 + 2]);
            i ^= _mth0640(l, aqA[i2 + 1], aqz[i2 + 1]);
            l ^= _mth02D1(k, aqA[i2], aqz[i2]);
        }

        ai[0] = k1;
        ai[1] = i;
        ai[2] = l;
        ai[3] = k;
        _mth02CB(ai[0], abyte1, j);
        _mth02CB(ai[1], abyte1, j + 4);
        _mth02CB(ai[2], abyte1, j + 8);
        _mth02CB(ai[3], abyte1, j + 12);
        return 16;
    }

    protected final int _mth141D(byte abyte0[], int i, byte abyte1[], int j)
    {
        int ai[] = new int[4];
        int i1 = _mth037A(abyte0, i);
        int k1 = _mth037A(abyte0, i + 4);
        int l = _mth037A(abyte0, i + 8);
        int k = _mth037A(abyte0, i + 12);
        i = k1;
        for (k1 = 0; k1 < 6; k1++)
        {
            int l1 = 11 - k1 << 2;
            l ^= _mth02D1(k, aqA[l1], aqz[l1]);
            i ^= _mth0640(l, aqA[l1 + 1], aqz[l1 + 1]);
            i1 ^= _mth1427(i, aqA[l1 + 2], aqz[l1 + 2]);
            k ^= _mth02D1(i1, aqA[l1 + 3], aqz[l1 + 3]);
        }

        byte byte0 = 6;
        k1 = i1;
        for (int j1 = byte0; j1 < 12; j1++)
        {
            int i2 = 11 - j1 << 2;
            k ^= _mth02D1(k1, aqA[i2 + 3], aqz[i2 + 3]);
            k1 ^= _mth1427(i, aqA[i2 + 2], aqz[i2 + 2]);
            i ^= _mth0640(l, aqA[i2 + 1], aqz[i2 + 1]);
            l ^= _mth02D1(k, aqA[i2], aqz[i2]);
        }

        ai[0] = k1;
        ai[1] = i;
        ai[2] = l;
        ai[3] = k;
        _mth02CB(ai[0], abyte1, j);
        _mth02CB(ai[1], abyte1, j + 4);
        _mth02CB(ai[2], abyte1, j + 8);
        _mth02CB(ai[3], abyte1, j + 12);
        return 16;
    }

    public final String _mth14AC()
    {
        return "CAST6";
    }

    protected final void _mth1D54(byte abyte0[])
    {
        int k1 = 0x5a827999;
        int l = 19;
        for (int i = 0; i < 24; i++)
        {
            for (int j1 = 0; j1 < 8; j1++)
            {
                aqF[(i << 3) + j1] = k1;
                k1 += 0x6ed9eba1;
                aqE[(i << 3) + j1] = l;
                l = l + 17 & 0x1f;
            }

        }

        byte abyte1[] = new byte[64];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        for (int j = 0; j < 8; j++)
        {
            aqG[j] = _mth037A(abyte1, j << 2);
        }

        for (int k = 0; k < 12; k++)
        {
            int i1 = k << 1 << 3;
            abyte0 = aqG;
            abyte0[6] = abyte0[6] ^ _mth02D1(aqG[7], aqF[i1], aqE[i1]);
            abyte0 = aqG;
            abyte0[5] = abyte0[5] ^ _mth0640(aqG[6], aqF[i1 + 1], aqE[i1 + 1]);
            abyte0 = aqG;
            abyte0[4] = abyte0[4] ^ _mth1427(aqG[5], aqF[i1 + 2], aqE[i1 + 2]);
            abyte0 = aqG;
            abyte0[3] = abyte0[3] ^ _mth02D1(aqG[4], aqF[i1 + 3], aqE[i1 + 3]);
            abyte0 = aqG;
            abyte0[2] = abyte0[2] ^ _mth0640(aqG[3], aqF[i1 + 4], aqE[i1 + 4]);
            abyte0 = aqG;
            abyte0[1] = abyte0[1] ^ _mth1427(aqG[2], aqF[i1 + 5], aqE[i1 + 5]);
            abyte0 = aqG;
            abyte0[0] = abyte0[0] ^ _mth02D1(aqG[1], aqF[i1 + 6], aqE[i1 + 6]);
            abyte0 = aqG;
            abyte0[7] = abyte0[7] ^ _mth0640(aqG[0], aqF[i1 + 7], aqE[i1 + 7]);
            i1 = (k << 1) + 1 << 3;
            abyte0 = aqG;
            abyte0[6] = abyte0[6] ^ _mth02D1(aqG[7], aqF[i1], aqE[i1]);
            abyte0 = aqG;
            abyte0[5] = abyte0[5] ^ _mth0640(aqG[6], aqF[i1 + 1], aqE[i1 + 1]);
            abyte0 = aqG;
            abyte0[4] = abyte0[4] ^ _mth1427(aqG[5], aqF[i1 + 2], aqE[i1 + 2]);
            abyte0 = aqG;
            abyte0[3] = abyte0[3] ^ _mth02D1(aqG[4], aqF[i1 + 3], aqE[i1 + 3]);
            abyte0 = aqG;
            abyte0[2] = abyte0[2] ^ _mth0640(aqG[3], aqF[i1 + 4], aqE[i1 + 4]);
            abyte0 = aqG;
            abyte0[1] = abyte0[1] ^ _mth1427(aqG[2], aqF[i1 + 5], aqE[i1 + 5]);
            abyte0 = aqG;
            abyte0[0] = abyte0[0] ^ _mth02D1(aqG[1], aqF[i1 + 6], aqE[i1 + 6]);
            abyte0 = aqG;
            abyte0[7] = abyte0[7] ^ _mth0640(aqG[0], aqF[i1 + 7], aqE[i1 + 7]);
            aqz[k << 2] = aqG[0] & 0x1f;
            aqz[(k << 2) + 1] = aqG[2] & 0x1f;
            aqz[(k << 2) + 2] = aqG[4] & 0x1f;
            aqz[(k << 2) + 3] = aqG[6] & 0x1f;
            aqA[k << 2] = aqG[7];
            aqA[(k << 2) + 1] = aqG[5];
            aqA[(k << 2) + 2] = aqG[3];
            aqA[(k << 2) + 3] = aqG[1];
        }

    }
}
