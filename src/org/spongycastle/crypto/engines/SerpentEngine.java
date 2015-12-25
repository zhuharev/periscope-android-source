// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class SerpentEngine
    implements BlockCipher
{

    private boolean aqs;
    private int asV[];
    private int atd;
    private int ate;
    private int atf;
    private int atg;

    public SerpentEngine()
    {
    }

    private void _mth02B9(int i, int j, int k, int l)
    {
        int i1 = k | i & j;
        int j1 = l & (i | j);
        atg = i1 ^ j1;
        j ^= j1;
        ate = i ^ (j | atg ^ ~l);
        atd = k ^ j ^ (ate | l);
        atf = ate ^ i1 ^ (atd ^ atg & i);
    }

    private void _mth02BD(int i, int j, int k, int l)
    {
        int k1 = i ^ l;
        int i1 = k ^ k1;
        int j1 = j ^ i1;
        atg = i & l ^ j1;
        i ^= j & k1;
        atf = (k | i) ^ j1;
        j = atg & (i1 ^ i);
        ate = ~i1 ^ j;
        atd = ~i ^ j;
    }

    private void _mth02BE(int i, int j, int k, int l)
    {
        l ^= j;
        int i1 = i ^ j & l;
        i = l ^ i1;
        atg = k ^ i;
        j ^= l & i1;
        ate = i1 ^ (atg | j);
        k = ~ate;
        j ^= atg;
        atd = k ^ j;
        atf = (k | j) ^ i;
    }

    private void _mth02BF(int i, int j, int k, int l)
    {
        int i1 = ~i;
        int j1 = j ^ l;
        atd = j1 ^ k & i1;
        int k1 = k ^ i1;
        j &= k ^ atd;
        atg = k1 ^ j;
        atf = (l | j) & (atd | k1) ^ i;
        ate = atg ^ j1 ^ (atf ^ (l | i1));
    }

    private void _mth02C8(int i, int j, int k, int l)
    {
        int j1 = j ^ l;
        int i1 = i ^ k;
        k ^= j1;
        atd = i1 ^ j & k;
        atg = j1 ^ ((i | ~j1) ^ l | i1);
        i = ~k;
        j = atd | atg;
        ate = i ^ j;
        atf = l & i ^ (i1 ^ j);
    }

    private static int _mth02C9(byte abyte0[], int i)
    {
        return (abyte0[i] & 0xff) << 24 | (abyte0[i + 1] & 0xff) << 16 | (abyte0[i + 2] & 0xff) << 8 | abyte0[i + 3] & 0xff;
    }

    private void _mth02C9(int i, int j, int k, int l)
    {
        int j1 = i ^ j;
        int k1 = i | l;
        int i1 = k ^ l;
        i = i & k | j1 & k1;
        atf = i1 ^ i;
        i = k1 ^ j ^ i;
        atd = j1 ^ i1 & i;
        k = atf & atd;
        ate = i ^ k;
        atg = (j | l) ^ (i1 ^ k);
    }

    private void _mth02CC(int i, int j, int k, int l)
    {
        int j1 = j ^ k;
        int i1 = i ^ j & j1;
        int k1 = l | i1;
        atd = j1 ^ k1;
        l = (k1 | j1) ^ l;
        atf = k ^ i1 ^ l;
        i = (i | j) ^ l;
        atg = i1 ^ atd & i;
        ate = atg ^ (atd ^ i);
    }

    private void _mth02CD(int i, int j, int k, int l)
    {
        int i1 = i ^ l;
        k ^= l & i1;
        l = j | k;
        atg = i1 ^ l;
        int j1 = ~j;
        atd = k ^ (i1 | j1);
        j = atd;
        i1 = j1 ^ i1;
        atf = i & j ^ l & i1;
        ate = i ^ k ^ atf & i1;
    }

    private void _mth02D1(int i, int j, int k, int l)
    {
        j ^= (k | l) & i;
        k ^= i & j;
        ate = l ^ k;
        i = ~i;
        atg = j ^ k & ate;
        k = (ate | i) ^ l;
        atd = atg ^ k;
        atf = j & k ^ (ate ^ i);
    }

    private void _mth037A(int i, int j, int k, int l)
    {
        int i1 = ~i;
        int j1 = j ^ i;
        j = l ^ (i1 | j1);
        k ^= j;
        atf = j1 ^ k;
        l = i1 ^ l & j1;
        ate = atf & l ^ j;
        atg = i & j ^ (ate | k);
        atd = atg ^ (k ^ l);
    }

    private void _mth0640(int i, int j, int k, int l)
    {
        int j1 = ~i;
        int i1 = i ^ j;
        i ^= l;
        atd = k ^ j1 ^ (i1 | i);
        k = l & atd;
        ate = k ^ (i1 ^ atd);
        i ^= j1 | atd;
        atf = (i1 | k) ^ i;
        atg = j ^ k ^ ate & i;
    }

    private static void _mth141D(int i, byte abyte0[], int j)
    {
        abyte0[j + 3] = (byte)i;
        abyte0[j + 2] = (byte)(i >>> 8);
        abyte0[j + 1] = (byte)(i >>> 16);
        abyte0[j] = i >> 24;
    }

    private void _mth1427(int i, int j, int k, int l)
    {
        int i1 = ~k;
        int l1 = j & i1 ^ l;
        int j1 = i & l1;
        atg = j1 ^ (j ^ i1);
        int k1 = j | atg;
        ate = l1 ^ i & k1;
        l |= i;
        atd = l ^ (i1 ^ k1);
        atf = j & l ^ (i ^ k | j1);
    }

    private void _mth1428(int i, int j, int k, int l)
    {
        int j1 = i ^ l;
        int i1 = j ^ j1;
        i = k ^ (~i | j1);
        ate = j ^ i;
        j = (j1 | ate) ^ l;
        atf = i1 ^ i & j;
        j ^= i;
        atd = atf ^ j;
        atg = ~i ^ i1 & j;
    }

    private void _mth1FBE(int i, int j, int k, int l)
    {
        int i1 = j ^ ~i;
        i = k ^ (i | i1);
        atf = l ^ i;
        j ^= l | i1;
        k = i1 ^ atf;
        atg = i & j ^ k;
        j ^= i;
        ate = atg ^ j;
        atd = k & j ^ i;
    }

    private void _mth309E()
    {
        int i = atd;
        i = i << 13 | i >>> -13;
        int j = atf;
        j = j << 3 | j >>> -3;
        int k = ate ^ i ^ j;
        int l = atg ^ j ^ i << 3;
        ate = k << 1 | k >>> -1;
        atg = l << 7 | l >>> -7;
        i = ate ^ i ^ atg;
        atd = i << 5 | i >>> -5;
        i = atg ^ j ^ ate << 7;
        atf = i << 22 | i >>> -22;
    }

    private void _mth30A4()
    {
        int i = atf;
        i = (i >>> 22 | i << -22) ^ atg ^ ate << 7;
        int j = atd;
        j = (j >>> 5 | j << -5) ^ ate ^ atg;
        int k = atg;
        int l = ate;
        atg = (k >>> 7 | k << -7) ^ i ^ j << 3;
        ate = (l >>> 1 | l << -1) ^ j ^ i;
        atf = i >>> 3 | i << -3;
        atd = j >>> 13 | j << -13;
    }

    private void FE73(int i, int j, int k, int l)
    {
        int i1 = ~i;
        int j1 = i ^ j;
        i = k ^ j1;
        k = (k | i1) ^ l;
        ate = i ^ k;
        j1 ^= i & k;
        atg = k ^ (j | j1);
        j |= atg;
        atd = j1 ^ j;
        atf = l & i1 ^ (i ^ j);
    }

    private void FF9E(int i, int j, int k, int l)
    {
        int i1 = j ^ k;
        k = k & i1 ^ l;
        int j1 = i ^ k;
        ate = j ^ (l | i1) & j1;
        j = ate;
        atg = i1 ^ i & j1;
        i = j1 ^ (k | j);
        atf = k ^ atg & i;
        atd = ~i ^ atg & atf;
    }

    public final int getBlockSize()
    {
        return 16;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (asV == null)
        {
            throw new IllegalStateException("Serpent not initialised");
        }
        if (i + 16 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 16 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        if (aqs)
        {
            atg = _mth02C9(abyte0, i);
            atf = _mth02C9(abyte0, i + 4);
            ate = _mth02C9(abyte0, i + 8);
            atd = _mth02C9(abyte0, i + 12);
            _mth02BD(asV[0] ^ atd, asV[1] ^ ate, asV[2] ^ atf, asV[3] ^ atg);
            _mth309E();
            _mth1FBE(asV[4] ^ atd, asV[5] ^ ate, asV[6] ^ atf, asV[7] ^ atg);
            _mth309E();
            _mth02BF(asV[8] ^ atd, asV[9] ^ ate, asV[10] ^ atf, asV[11] ^ atg);
            _mth309E();
            _mth02C9(asV[12] ^ atd, asV[13] ^ ate, asV[14] ^ atf, asV[15] ^ atg);
            _mth309E();
            _mth02CD(asV[16] ^ atd, asV[17] ^ ate, asV[18] ^ atf, asV[19] ^ atg);
            _mth309E();
            _mth0640(asV[20] ^ atd, asV[21] ^ ate, asV[22] ^ atf, asV[23] ^ atg);
            _mth309E();
            _mth1428(asV[24] ^ atd, asV[25] ^ ate, asV[26] ^ atf, asV[27] ^ atg);
            _mth309E();
            FF9E(asV[28] ^ atd, asV[29] ^ ate, asV[30] ^ atf, asV[31] ^ atg);
            _mth309E();
            _mth02BD(asV[32] ^ atd, asV[33] ^ ate, asV[34] ^ atf, asV[35] ^ atg);
            _mth309E();
            _mth1FBE(asV[36] ^ atd, asV[37] ^ ate, asV[38] ^ atf, asV[39] ^ atg);
            _mth309E();
            _mth02BF(asV[40] ^ atd, asV[41] ^ ate, asV[42] ^ atf, asV[43] ^ atg);
            _mth309E();
            _mth02C9(asV[44] ^ atd, asV[45] ^ ate, asV[46] ^ atf, asV[47] ^ atg);
            _mth309E();
            _mth02CD(asV[48] ^ atd, asV[49] ^ ate, asV[50] ^ atf, asV[51] ^ atg);
            _mth309E();
            _mth0640(asV[52] ^ atd, asV[53] ^ ate, asV[54] ^ atf, asV[55] ^ atg);
            _mth309E();
            _mth1428(asV[56] ^ atd, asV[57] ^ ate, asV[58] ^ atf, asV[59] ^ atg);
            _mth309E();
            FF9E(asV[60] ^ atd, asV[61] ^ ate, asV[62] ^ atf, asV[63] ^ atg);
            _mth309E();
            _mth02BD(asV[64] ^ atd, asV[65] ^ ate, asV[66] ^ atf, asV[67] ^ atg);
            _mth309E();
            _mth1FBE(asV[68] ^ atd, asV[69] ^ ate, asV[70] ^ atf, asV[71] ^ atg);
            _mth309E();
            _mth02BF(asV[72] ^ atd, asV[73] ^ ate, asV[74] ^ atf, asV[75] ^ atg);
            _mth309E();
            _mth02C9(asV[76] ^ atd, asV[77] ^ ate, asV[78] ^ atf, asV[79] ^ atg);
            _mth309E();
            _mth02CD(asV[80] ^ atd, asV[81] ^ ate, asV[82] ^ atf, asV[83] ^ atg);
            _mth309E();
            _mth0640(asV[84] ^ atd, asV[85] ^ ate, asV[86] ^ atf, asV[87] ^ atg);
            _mth309E();
            _mth1428(asV[88] ^ atd, asV[89] ^ ate, asV[90] ^ atf, asV[91] ^ atg);
            _mth309E();
            FF9E(asV[92] ^ atd, asV[93] ^ ate, asV[94] ^ atf, asV[95] ^ atg);
            _mth309E();
            _mth02BD(asV[96] ^ atd, asV[97] ^ ate, asV[98] ^ atf, asV[99] ^ atg);
            _mth309E();
            _mth1FBE(asV[100] ^ atd, asV[101] ^ ate, asV[102] ^ atf, asV[103] ^ atg);
            _mth309E();
            _mth02BF(asV[104] ^ atd, asV[105] ^ ate, asV[106] ^ atf, asV[107] ^ atg);
            _mth309E();
            _mth02C9(asV[108] ^ atd, asV[109] ^ ate, asV[110] ^ atf, asV[111] ^ atg);
            _mth309E();
            _mth02CD(asV[112] ^ atd, asV[113] ^ ate, asV[114] ^ atf, asV[115] ^ atg);
            _mth309E();
            _mth0640(asV[116] ^ atd, asV[117] ^ ate, asV[118] ^ atf, asV[119] ^ atg);
            _mth309E();
            _mth1428(asV[120] ^ atd, asV[121] ^ ate, asV[122] ^ atf, asV[123] ^ atg);
            _mth309E();
            FF9E(asV[124] ^ atd, asV[125] ^ ate, asV[126] ^ atf, asV[127] ^ atg);
            _mth141D(asV[131] ^ atg, abyte1, j);
            _mth141D(asV[130] ^ atf, abyte1, j + 4);
            _mth141D(asV[129] ^ ate, abyte1, j + 8);
            _mth141D(asV[128] ^ atd, abyte1, j + 12);
        } else
        {
            atg = asV[131] ^ _mth02C9(abyte0, i);
            atf = asV[130] ^ _mth02C9(abyte0, i + 4);
            ate = asV[129] ^ _mth02C9(abyte0, i + 8);
            atd = asV[128] ^ _mth02C9(abyte0, i + 12);
            _mth02B9(atd, ate, atf, atg);
            atd = atd ^ asV[124];
            ate = ate ^ asV[125];
            atf = atf ^ asV[126];
            atg = atg ^ asV[127];
            _mth30A4();
            FE73(atd, ate, atf, atg);
            atd = atd ^ asV[120];
            ate = ate ^ asV[121];
            atf = atf ^ asV[122];
            atg = atg ^ asV[123];
            _mth30A4();
            _mth1427(atd, ate, atf, atg);
            atd = atd ^ asV[116];
            ate = ate ^ asV[117];
            atf = atf ^ asV[118];
            atg = atg ^ asV[119];
            _mth30A4();
            _mth02D1(atd, ate, atf, atg);
            atd = atd ^ asV[112];
            ate = ate ^ asV[113];
            atf = atf ^ asV[114];
            atg = atg ^ asV[115];
            _mth30A4();
            _mth02CC(atd, ate, atf, atg);
            atd = atd ^ asV[108];
            ate = ate ^ asV[109];
            atf = atf ^ asV[110];
            atg = atg ^ asV[111];
            _mth30A4();
            _mth02C8(atd, ate, atf, atg);
            atd = atd ^ asV[104];
            ate = ate ^ asV[105];
            atf = atf ^ asV[106];
            atg = atg ^ asV[107];
            _mth30A4();
            _mth02BE(atd, ate, atf, atg);
            atd = atd ^ asV[100];
            ate = ate ^ asV[101];
            atf = atf ^ asV[102];
            atg = atg ^ asV[103];
            _mth30A4();
            _mth037A(atd, ate, atf, atg);
            atd = atd ^ asV[96];
            ate = ate ^ asV[97];
            atf = atf ^ asV[98];
            atg = atg ^ asV[99];
            _mth30A4();
            _mth02B9(atd, ate, atf, atg);
            atd = atd ^ asV[92];
            ate = ate ^ asV[93];
            atf = atf ^ asV[94];
            atg = atg ^ asV[95];
            _mth30A4();
            FE73(atd, ate, atf, atg);
            atd = atd ^ asV[88];
            ate = ate ^ asV[89];
            atf = atf ^ asV[90];
            atg = atg ^ asV[91];
            _mth30A4();
            _mth1427(atd, ate, atf, atg);
            atd = atd ^ asV[84];
            ate = ate ^ asV[85];
            atf = atf ^ asV[86];
            atg = atg ^ asV[87];
            _mth30A4();
            _mth02D1(atd, ate, atf, atg);
            atd = atd ^ asV[80];
            ate = ate ^ asV[81];
            atf = atf ^ asV[82];
            atg = atg ^ asV[83];
            _mth30A4();
            _mth02CC(atd, ate, atf, atg);
            atd = atd ^ asV[76];
            ate = ate ^ asV[77];
            atf = atf ^ asV[78];
            atg = atg ^ asV[79];
            _mth30A4();
            _mth02C8(atd, ate, atf, atg);
            atd = atd ^ asV[72];
            ate = ate ^ asV[73];
            atf = atf ^ asV[74];
            atg = atg ^ asV[75];
            _mth30A4();
            _mth02BE(atd, ate, atf, atg);
            atd = atd ^ asV[68];
            ate = ate ^ asV[69];
            atf = atf ^ asV[70];
            atg = atg ^ asV[71];
            _mth30A4();
            _mth037A(atd, ate, atf, atg);
            atd = atd ^ asV[64];
            ate = ate ^ asV[65];
            atf = atf ^ asV[66];
            atg = atg ^ asV[67];
            _mth30A4();
            _mth02B9(atd, ate, atf, atg);
            atd = atd ^ asV[60];
            ate = ate ^ asV[61];
            atf = atf ^ asV[62];
            atg = atg ^ asV[63];
            _mth30A4();
            FE73(atd, ate, atf, atg);
            atd = atd ^ asV[56];
            ate = ate ^ asV[57];
            atf = atf ^ asV[58];
            atg = atg ^ asV[59];
            _mth30A4();
            _mth1427(atd, ate, atf, atg);
            atd = atd ^ asV[52];
            ate = ate ^ asV[53];
            atf = atf ^ asV[54];
            atg = atg ^ asV[55];
            _mth30A4();
            _mth02D1(atd, ate, atf, atg);
            atd = atd ^ asV[48];
            ate = ate ^ asV[49];
            atf = atf ^ asV[50];
            atg = atg ^ asV[51];
            _mth30A4();
            _mth02CC(atd, ate, atf, atg);
            atd = atd ^ asV[44];
            ate = ate ^ asV[45];
            atf = atf ^ asV[46];
            atg = atg ^ asV[47];
            _mth30A4();
            _mth02C8(atd, ate, atf, atg);
            atd = atd ^ asV[40];
            ate = ate ^ asV[41];
            atf = atf ^ asV[42];
            atg = atg ^ asV[43];
            _mth30A4();
            _mth02BE(atd, ate, atf, atg);
            atd = atd ^ asV[36];
            ate = ate ^ asV[37];
            atf = atf ^ asV[38];
            atg = atg ^ asV[39];
            _mth30A4();
            _mth037A(atd, ate, atf, atg);
            atd = atd ^ asV[32];
            ate = ate ^ asV[33];
            atf = atf ^ asV[34];
            atg = atg ^ asV[35];
            _mth30A4();
            _mth02B9(atd, ate, atf, atg);
            atd = atd ^ asV[28];
            ate = ate ^ asV[29];
            atf = atf ^ asV[30];
            atg = atg ^ asV[31];
            _mth30A4();
            FE73(atd, ate, atf, atg);
            atd = atd ^ asV[24];
            ate = ate ^ asV[25];
            atf = atf ^ asV[26];
            atg = atg ^ asV[27];
            _mth30A4();
            _mth1427(atd, ate, atf, atg);
            atd = atd ^ asV[20];
            ate = ate ^ asV[21];
            atf = atf ^ asV[22];
            atg = atg ^ asV[23];
            _mth30A4();
            _mth02D1(atd, ate, atf, atg);
            atd = atd ^ asV[16];
            ate = ate ^ asV[17];
            atf = atf ^ asV[18];
            atg = atg ^ asV[19];
            _mth30A4();
            _mth02CC(atd, ate, atf, atg);
            atd = atd ^ asV[12];
            ate = ate ^ asV[13];
            atf = atf ^ asV[14];
            atg = atg ^ asV[15];
            _mth30A4();
            _mth02C8(atd, ate, atf, atg);
            atd = atd ^ asV[8];
            ate = ate ^ asV[9];
            atf = atf ^ asV[10];
            atg = atg ^ asV[11];
            _mth30A4();
            _mth02BE(atd, ate, atf, atg);
            atd = atd ^ asV[4];
            ate = ate ^ asV[5];
            atf = atf ^ asV[6];
            atg = atg ^ asV[7];
            _mth30A4();
            _mth037A(atd, ate, atf, atg);
            _mth141D(atg ^ asV[3], abyte1, j);
            _mth141D(atf ^ asV[2], abyte1, j + 4);
            _mth141D(ate ^ asV[1], abyte1, j + 8);
            _mth141D(atd ^ asV[0], abyte1, j + 12);
        }
        return 16;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            aqs = flag;
            int ai[] = ((KeyParameter)cipherparameters).key;
            cipherparameters = new int[16];
            int i = 0;
            int l;
            for (l = ai.length - 4; l > 0;)
            {
                int l1 = i + 1;
                cipherparameters[i] = _mth02C9(ai, l);
                l -= 4;
                i = l1;
            }

            if (l == 0)
            {
                int i1 = i + 1;
                cipherparameters[i] = _mth02C9(ai, 0);
                if (i1 < 8)
                {
                    cipherparameters[i1] = 1;
                }
            } else
            {
                throw new IllegalArgumentException("key must be a multiple of 4 bytes");
            }
            ai = new int[132];
            for (int j = 8; j < 16; j++)
            {
                int j1 = cipherparameters[j - 8] ^ cipherparameters[j - 5] ^ cipherparameters[j - 3] ^ cipherparameters[j - 1] ^ 0x9e3779b9 ^ j - 8;
                cipherparameters[j] = j1 << 11 | j1 >>> -11;
            }

            System.arraycopy(cipherparameters, 8, ai, 0, 8);
            for (int k = 8; k < 132; k++)
            {
                int k1 = ai[k - 8] ^ ai[k - 5] ^ ai[k - 3] ^ ai[k - 1] ^ 0x9e3779b9 ^ k;
                ai[k] = k1 << 11 | k1 >>> -11;
            }

            _mth02C9(ai[0], ai[1], ai[2], ai[3]);
            ai[0] = atd;
            ai[1] = ate;
            ai[2] = atf;
            ai[3] = atg;
            _mth02BF(ai[4], ai[5], ai[6], ai[7]);
            ai[4] = atd;
            ai[5] = ate;
            ai[6] = atf;
            ai[7] = atg;
            _mth1FBE(ai[8], ai[9], ai[10], ai[11]);
            ai[8] = atd;
            ai[9] = ate;
            ai[10] = atf;
            ai[11] = atg;
            _mth02BD(ai[12], ai[13], ai[14], ai[15]);
            ai[12] = atd;
            ai[13] = ate;
            ai[14] = atf;
            ai[15] = atg;
            FF9E(ai[16], ai[17], ai[18], ai[19]);
            ai[16] = atd;
            ai[17] = ate;
            ai[18] = atf;
            ai[19] = atg;
            _mth1428(ai[20], ai[21], ai[22], ai[23]);
            ai[20] = atd;
            ai[21] = ate;
            ai[22] = atf;
            ai[23] = atg;
            _mth0640(ai[24], ai[25], ai[26], ai[27]);
            ai[24] = atd;
            ai[25] = ate;
            ai[26] = atf;
            ai[27] = atg;
            _mth02CD(ai[28], ai[29], ai[30], ai[31]);
            ai[28] = atd;
            ai[29] = ate;
            ai[30] = atf;
            ai[31] = atg;
            _mth02C9(ai[32], ai[33], ai[34], ai[35]);
            ai[32] = atd;
            ai[33] = ate;
            ai[34] = atf;
            ai[35] = atg;
            _mth02BF(ai[36], ai[37], ai[38], ai[39]);
            ai[36] = atd;
            ai[37] = ate;
            ai[38] = atf;
            ai[39] = atg;
            _mth1FBE(ai[40], ai[41], ai[42], ai[43]);
            ai[40] = atd;
            ai[41] = ate;
            ai[42] = atf;
            ai[43] = atg;
            _mth02BD(ai[44], ai[45], ai[46], ai[47]);
            ai[44] = atd;
            ai[45] = ate;
            ai[46] = atf;
            ai[47] = atg;
            FF9E(ai[48], ai[49], ai[50], ai[51]);
            ai[48] = atd;
            ai[49] = ate;
            ai[50] = atf;
            ai[51] = atg;
            _mth1428(ai[52], ai[53], ai[54], ai[55]);
            ai[52] = atd;
            ai[53] = ate;
            ai[54] = atf;
            ai[55] = atg;
            _mth0640(ai[56], ai[57], ai[58], ai[59]);
            ai[56] = atd;
            ai[57] = ate;
            ai[58] = atf;
            ai[59] = atg;
            _mth02CD(ai[60], ai[61], ai[62], ai[63]);
            ai[60] = atd;
            ai[61] = ate;
            ai[62] = atf;
            ai[63] = atg;
            _mth02C9(ai[64], ai[65], ai[66], ai[67]);
            ai[64] = atd;
            ai[65] = ate;
            ai[66] = atf;
            ai[67] = atg;
            _mth02BF(ai[68], ai[69], ai[70], ai[71]);
            ai[68] = atd;
            ai[69] = ate;
            ai[70] = atf;
            ai[71] = atg;
            _mth1FBE(ai[72], ai[73], ai[74], ai[75]);
            ai[72] = atd;
            ai[73] = ate;
            ai[74] = atf;
            ai[75] = atg;
            _mth02BD(ai[76], ai[77], ai[78], ai[79]);
            ai[76] = atd;
            ai[77] = ate;
            ai[78] = atf;
            ai[79] = atg;
            FF9E(ai[80], ai[81], ai[82], ai[83]);
            ai[80] = atd;
            ai[81] = ate;
            ai[82] = atf;
            ai[83] = atg;
            _mth1428(ai[84], ai[85], ai[86], ai[87]);
            ai[84] = atd;
            ai[85] = ate;
            ai[86] = atf;
            ai[87] = atg;
            _mth0640(ai[88], ai[89], ai[90], ai[91]);
            ai[88] = atd;
            ai[89] = ate;
            ai[90] = atf;
            ai[91] = atg;
            _mth02CD(ai[92], ai[93], ai[94], ai[95]);
            ai[92] = atd;
            ai[93] = ate;
            ai[94] = atf;
            ai[95] = atg;
            _mth02C9(ai[96], ai[97], ai[98], ai[99]);
            ai[96] = atd;
            ai[97] = ate;
            ai[98] = atf;
            ai[99] = atg;
            _mth02BF(ai[100], ai[101], ai[102], ai[103]);
            ai[100] = atd;
            ai[101] = ate;
            ai[102] = atf;
            ai[103] = atg;
            _mth1FBE(ai[104], ai[105], ai[106], ai[107]);
            ai[104] = atd;
            ai[105] = ate;
            ai[106] = atf;
            ai[107] = atg;
            _mth02BD(ai[108], ai[109], ai[110], ai[111]);
            ai[108] = atd;
            ai[109] = ate;
            ai[110] = atf;
            ai[111] = atg;
            FF9E(ai[112], ai[113], ai[114], ai[115]);
            ai[112] = atd;
            ai[113] = ate;
            ai[114] = atf;
            ai[115] = atg;
            _mth1428(ai[116], ai[117], ai[118], ai[119]);
            ai[116] = atd;
            ai[117] = ate;
            ai[118] = atf;
            ai[119] = atg;
            _mth0640(ai[120], ai[121], ai[122], ai[123]);
            ai[120] = atd;
            ai[121] = ate;
            ai[122] = atf;
            ai[123] = atg;
            _mth02CD(ai[124], ai[125], ai[126], ai[127]);
            ai[124] = atd;
            ai[125] = ate;
            ai[126] = atf;
            ai[127] = atg;
            _mth02C9(ai[128], ai[129], ai[130], ai[131]);
            ai[128] = atd;
            ai[129] = ate;
            ai[130] = atf;
            ai[131] = atg;
            asV = ai;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to Serpent init - ")).append(cipherparameters.getClass().getName()).toString());
        }
    }

    public final String _mth14AC()
    {
        return "Serpent";
    }
}
