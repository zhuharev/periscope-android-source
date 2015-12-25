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

public class VMPCEngine
    implements StreamCipher
{

    private byte aqt[];
    private byte arC[];
    protected byte atI;
    protected byte atJ[];
    protected byte atK;

    public VMPCEngine()
    {
        atI = 0;
        atJ = null;
        atK = 0;
    }

    public final void reset()
    {
        _mth02CE(aqt, arC);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof ParametersWithIV))
        {
            throw new IllegalArgumentException("VMPC init parameters must include an IV");
        }
        cipherparameters = (ParametersWithIV)cipherparameters;
        if (!(((ParametersWithIV) (cipherparameters)).axC instanceof KeyParameter))
        {
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        KeyParameter keyparameter = (KeyParameter)((ParametersWithIV) (cipherparameters)).axC;
        arC = ((ParametersWithIV) (cipherparameters)).iv;
        if (arC == null || arC.length <= 0 || arC.length > 768)
        {
            throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
        } else
        {
            aqt = keyparameter.key;
            _mth02CE(aqt, arC);
            return;
        }
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
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
            atK = atJ[atK + atJ[atI & 0xff] & 0xff];
            byte byte1 = atJ[atJ[atJ[atK & 0xff] & 0xff] + 1 & 0xff];
            byte byte0 = atJ[atI & 0xff];
            atJ[atI & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte0;
            atI = (byte)(atI + 1);
            abyte1[l + k] = (byte)(abyte0[l + i] ^ byte1);
        }

        return j;
    }

    protected void _mth02CE(byte abyte0[], byte abyte1[])
    {
        atK = 0;
        atJ = new byte[256];
        for (int i = 0; i < 256; i++)
        {
            atJ[i] = (byte)i;
        }

        for (int j = 0; j < 768; j++)
        {
            atK = atJ[atK + atJ[j & 0xff] + abyte0[j % abyte0.length] & 0xff];
            byte byte0 = atJ[j & 0xff];
            atJ[j & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte0;
        }

        for (int k = 0; k < 768; k++)
        {
            atK = atJ[atK + atJ[k & 0xff] + abyte1[k % abyte1.length] & 0xff];
            byte byte1 = atJ[k & 0xff];
            atJ[k & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte1;
        }

        atI = 0;
    }

    public String _mth14AC()
    {
        return "VMPC";
    }
}
