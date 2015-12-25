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

public class Grainv1Engine
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

    public Grainv1Engine()
    {
        index = 2;
        aqH = false;
    }

    private int _mth1E3A()
    {
        int i = arF[0];
        int j = arF[0] >>> 9 | arF[1] << 7;
        int k = arF[0];
        int l = arF[1];
        int i1 = arF[0] >>> 15 | arF[1] << 1;
        int j1 = arF[1] >>> 5 | arF[2] << 11;
        int k1 = arF[1] >>> 12 | arF[2] << 4;
        int l1 = arF[2] >>> 1 | arF[3] << 15;
        int i2 = arF[2] >>> 5 | arF[3] << 11;
        int j2 = arF[2] >>> 13 | arF[3] << 3;
        int k2 = arF[3] >>> 4 | arF[4] << 12;
        int l2 = arF[3] >>> 12 | arF[4] << 4;
        int i3 = arF[3];
        int j3 = arF[4];
        int k3 = arF[3] >>> 15 | arF[4] << 1;
        return ((i3 >>> 14 | j3 << 2) ^ l2 ^ k2 ^ j2 ^ i2 ^ l1 ^ k1 ^ j1 ^ (k >>> 14 | l << 2) ^ j ^ i ^ k3 & l2 ^ i2 & l1 ^ i1 & j ^ l2 & k2 & j2 ^ l1 & k1 & j1 ^ k3 & j2 & k1 & j ^ l2 & k2 & i2 & l1 ^ k3 & l2 & j1 & i1 ^ k3 & l2 & k2 & j2 & i2 ^ l1 & k1 & j1 & i1 & j ^ k2 & j2 & i2 & l1 & k1 & j1) & 0xffff;
    }

    private int _mth1E6A()
    {
        return (arE[0] ^ (arE[0] >>> 13 | arE[1] << 3) ^ (arE[1] >>> 7 | arE[2] << 9) ^ (arE[2] >>> 6 | arE[3] << 10) ^ (arE[3] >>> 3 | arE[4] << 13) ^ (arE[3] >>> 14 | arE[4] << 2)) & 0xffff;
    }

    private int _mth1EF2()
    {
        int i = arF[0];
        int j = arF[1];
        int k = arF[0];
        int l = arF[1];
        int i1 = arF[0];
        int j1 = arF[1];
        int k1 = arF[0];
        int l1 = arF[1];
        int i2 = arF[1];
        int j2 = arF[2];
        int k2 = arF[2];
        int l2 = arF[3];
        int i3 = arF[3];
        int j3 = arF[4];
        int k3 = arF[3] >>> 15 | arF[4] << 1;
        int l3 = arE[0] >>> 3 | arE[1] << 13;
        int i4 = arE[1] >>> 9 | arE[2] << 7;
        int j4 = arE[2] >>> 14 | arE[3] << 2;
        int k4 = arE[4];
        return (i4 ^ k3 ^ l3 & k4 ^ j4 & k4 ^ k4 & k3 ^ l3 & i4 & j4 ^ l3 & j4 & k4 ^ l3 & j4 & k3 ^ i4 & j4 & k3 ^ j4 & k4 & k3 ^ (i >>> 1 | j << 15) ^ (k >>> 2 | l << 14) ^ (i1 >>> 4 | j1 << 12) ^ (k1 >>> 10 | l1 << 6) ^ (i2 >>> 15 | j2 << 1) ^ (k2 >>> 11 | l2 << 5) ^ (i3 >>> 8 | j3 << 8)) & 0xffff;
    }

    private void _mth1EF4()
    {
        arG = _mth1EF2();
        arD[0] = (byte)arG;
        arD[1] = (byte)(arG >> 8);
        int ai[] = arF;
        int i = _mth1E3A();
        int j = arE[0];
        ai[0] = ai[1];
        ai[1] = ai[2];
        ai[2] = ai[3];
        ai[3] = ai[4];
        ai[4] = i ^ j;
        arF = ai;
        ai = arE;
        i = _mth1E6A();
        ai[0] = ai[1];
        ai[1] = ai[2];
        ai[2] = ai[3];
        ai[3] = ai[4];
        ai[4] = i;
        arE = ai;
    }

    private byte _mth1F36()
    {
        if (index > 1)
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
        index = 2;
        byte abyte0[] = aqt;
        byte abyte1[] = arC;
        abyte1[8] = -1;
        abyte1[9] = -1;
        aqt = abyte0;
        arC = abyte1;
        int k = 0;
        for (int i = 0; i < arF.length; i++)
        {
            arF[i] = (aqt[k + 1] << 8 | aqt[k] & 0xff) & 0xffff;
            arE[i] = (arC[k + 1] << 8 | arC[k] & 0xff) & 0xffff;
            k += 2;
        }

        for (int j = 0; j < 10; j++)
        {
            arG = _mth1EF2();
            int ai[] = arF;
            int l = _mth1E3A();
            int i1 = arE[0];
            int j1 = arG;
            ai[0] = ai[1];
            ai[1] = ai[2];
            ai[2] = ai[3];
            ai[3] = ai[4];
            ai[4] = l ^ i1 ^ j1;
            arF = ai;
            ai = arE;
            l = _mth1E6A();
            i1 = arG;
            ai[0] = ai[1];
            ai[1] = ai[2];
            ai[2] = ai[3];
            ai[3] = ai[4];
            ai[4] = l ^ i1;
            arE = ai;
        }

        aqH = true;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof ParametersWithIV))
        {
            throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
        }
        Object obj = (ParametersWithIV)cipherparameters;
        cipherparameters = ((ParametersWithIV) (obj)).iv;
        if (cipherparameters == null || cipherparameters.length != 8)
        {
            throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
        }
        if (!(((ParametersWithIV) (obj)).axC instanceof KeyParameter))
        {
            throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
        } else
        {
            obj = (KeyParameter)((ParametersWithIV) (obj)).axC;
            arC = new byte[((KeyParameter) (obj)).key.length];
            aqt = new byte[((KeyParameter) (obj)).key.length];
            arE = new int[5];
            arF = new int[5];
            arD = new byte[2];
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
            throw new IllegalStateException((new StringBuilder()).append("Grain v1 not initialised").toString());
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
        return "Grain v1";
    }
}
