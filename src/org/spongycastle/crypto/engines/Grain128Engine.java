// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class Grain128Engine
    implements StreamCipher
{

    private boolean aqH;
    private byte aqt[];
    private byte arC[];
    private byte arD[];
    private int arE[];
    private int arF[];
    private int arG;
    private int index;

    public Grain128Engine()
    {
        index = 4;
        aqH = false;
    }

    private int _mth1E3A()
    {
        int i = arF[0];
        int j = arF[0];
        int k = arF[1];
        int l = arF[0];
        int i1 = arF[1];
        int j1 = arF[0];
        int k1 = arF[1];
        int l1 = arF[0];
        int i2 = arF[1];
        int j2 = arF[0];
        int k2 = arF[1];
        int l2 = arF[0];
        int i3 = arF[1];
        int j3 = arF[0];
        int k3 = arF[1];
        int l3 = arF[1];
        int i4 = arF[2];
        int j4 = arF[1];
        int k4 = arF[2];
        int l4 = arF[1];
        int i5 = arF[2];
        int j5 = arF[1];
        int k5 = arF[2];
        int l5 = arF[1];
        int i6 = arF[2];
        int j6 = arF[2];
        int k6 = arF[3];
        int l6 = arF[2];
        int i7 = arF[3];
        int j7 = arF[2];
        int k7 = arF[3];
        int l7 = arF[2];
        int i8 = arF[3];
        return i ^ (l2 >>> 26 | i3 << 6) ^ (l4 >>> 24 | i5 << 8) ^ (arF[2] >>> 27 | arF[3] << 5) ^ arF[3] ^ (j >>> 3 | k << 29) & (l6 >>> 3 | i7 << 29) ^ (l >>> 11 | i1 << 21) & (j1 >>> 13 | k1 << 19) ^ (l1 >>> 17 | i2 << 15) & (j2 >>> 18 | k2 << 14) ^ (j3 >>> 27 | k3 << 5) & (j5 >>> 27 | k5 << 5) ^ (l3 >>> 8 | i4 << 24) & (j4 >>> 16 | k4 << 16) ^ (l5 >>> 29 | i6 << 3) & (j6 >>> 1 | k6 << 31) ^ (j7 >>> 4 | k7 << 28) & (l7 >>> 20 | i8 << 12);
    }

    private int _mth1E6A()
    {
        return arE[0] ^ (arE[0] >>> 7 | arE[1] << 25) ^ (arE[1] >>> 6 | arE[2] << 26) ^ (arE[2] >>> 6 | arE[3] << 26) ^ (arE[2] >>> 17 | arE[3] << 15) ^ arE[3];
    }

    private int _mth1EF2()
    {
        int i = arF[0];
        int j = arF[1];
        int k = arF[0] >>> 12 | arF[1] << 20;
        int l = arF[0];
        int i1 = arF[1];
        int j1 = arF[1];
        int k1 = arF[2];
        int l1 = arF[1];
        int i2 = arF[2];
        int j2 = arF[2];
        int k2 = arF[2];
        int l2 = arF[3];
        int i3 = arF[2];
        int j3 = arF[3];
        int k3 = arF[2] >>> 31 | arF[3] << 1;
        int l3 = arE[0];
        int i4 = arE[1];
        int j4 = arE[0];
        int k4 = arE[1];
        int l4 = arE[0];
        int i5 = arE[1];
        int j5 = arE[1];
        int k5 = arE[2];
        int l5 = arE[1];
        int i6 = arE[2];
        int j6 = arE[2];
        int k6 = arE[3];
        int l6 = arE[2];
        int i7 = arE[3];
        return k & (l3 >>> 8 | i4 << 24) ^ (j4 >>> 13 | k4 << 19) & (l4 >>> 20 | i5 << 12) ^ k3 & (j5 >>> 10 | k5 << 22) ^ (l5 >>> 28 | i6 << 4) & (j6 >>> 15 | k6 << 17) ^ k & k3 & (arE[2] >>> 31 | arE[3] << 1) ^ (l6 >>> 29 | i7 << 3) ^ (i >>> 2 | j << 30) ^ (l >>> 15 | i1 << 17) ^ (j1 >>> 4 | k1 << 28) ^ (l1 >>> 13 | i2 << 19) ^ j2 ^ (k2 >>> 9 | l2 << 23) ^ (i3 >>> 25 | j3 << 7);
    }

    private void _mth1EF4()
    {
        arG = _mth1EF2();
        arD[0] = (byte)arG;
        arD[1] = (byte)(arG >> 8);
        arD[2] = (byte)(arG >> 16);
        arD[3] = arG >> 24;
        int ai[] = arF;
        int i = _mth1E3A();
        int j = arE[0];
        ai[0] = ai[1];
        ai[1] = ai[2];
        ai[2] = ai[3];
        ai[3] = i ^ j;
        arF = ai;
        ai = arE;
        i = _mth1E6A();
        ai[0] = ai[1];
        ai[1] = ai[2];
        ai[2] = ai[3];
        ai[3] = i;
        arE = ai;
    }

    private byte _mth1F36()
    {
        if (index > 3)
        {
            _mth1EF4();
            index = 0;
        }
        byte abyte0[] = arD;
        int i = index;
        index = i + 1;
        return abyte0[i];
    }

    public final void reset()
    {
        index = 4;
        byte abyte0[] = aqt;
        byte abyte1[] = arC;
        abyte1[12] = -1;
        abyte1[13] = -1;
        abyte1[14] = -1;
        abyte1[15] = -1;
        aqt = abyte0;
        arC = abyte1;
        int k = 0;
        for (int i = 0; i < arF.length; i++)
        {
            arF[i] = aqt[k + 3] << 24 | aqt[k + 2] << 16 & 0xff0000 | aqt[k + 1] << 8 & 0xff00 | aqt[k] & 0xff;
            arE[i] = arC[k + 3] << 24 | arC[k + 2] << 16 & 0xff0000 | arC[k + 1] << 8 & 0xff00 | arC[k] & 0xff;
            k += 4;
        }

        for (int j = 0; j < 8; j++)
        {
            arG = _mth1EF2();
            int ai[] = arF;
            int l = _mth1E3A();
            int i1 = arE[0];
            int j1 = arG;
            ai[0] = ai[1];
            ai[1] = ai[2];
            ai[2] = ai[3];
            ai[3] = l ^ i1 ^ j1;
            arF = ai;
            ai = arE;
            l = _mth1E6A();
            i1 = arG;
            ai[0] = ai[1];
            ai[1] = ai[2];
            ai[2] = ai[3];
            ai[3] = l ^ i1;
            arE = ai;
        }

        aqH = true;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof ParametersWithIV))
        {
            throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
        }
        Object obj = (ParametersWithIV)cipherparameters;
        cipherparameters = ((ParametersWithIV) (obj)).iv;
        if (cipherparameters == null || cipherparameters.length != 12)
        {
            throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
        }
        if (!(((ParametersWithIV) (obj)).axC instanceof KeyParameter))
        {
            throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
        } else
        {
            obj = (KeyParameter)((ParametersWithIV) (obj)).axC;
            arC = new byte[((KeyParameter) (obj)).key.length];
            aqt = new byte[((KeyParameter) (obj)).key.length];
            arE = new int[4];
            arF = new int[4];
            arD = new byte[4];
            System.arraycopy(cipherparameters, 0, arC, 0, cipherparameters.length);
            System.arraycopy(((KeyParameter) (obj)).key, 0, aqt, 0, ((KeyParameter) (obj)).key.length);
            reset();
            return;
        }
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (!aqH)
        {
            throw new IllegalStateException((new StringBuilder()).append("Grain-128 not initialised").toString());
        }
        if (i + j > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (k + j > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        for (int l = 0; l < j; l++)
        {
            abyte1[k + l] = (byte)(abyte0[i + l] ^ _mth1F36());
        }

        return j;
    }

    public final String _mth14AC()
    {
        return "Grain-128";
    }
}
