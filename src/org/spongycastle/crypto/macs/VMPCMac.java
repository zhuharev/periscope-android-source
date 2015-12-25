// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCMac
    implements Mac
{

    private byte aqt[];
    private byte arC[];
    private byte atI;
    private byte atJ[];
    private byte atK;
    private byte avC;
    private byte avD[];
    private byte avE;
    private byte avF;
    private byte avG;
    private byte avH;

    public VMPCMac()
    {
        atI = 0;
        atJ = null;
        atK = 0;
    }

    private void _mth02CE(byte abyte0[], byte abyte1[])
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

    public final int doFinal(byte abyte0[], int i)
    {
        for (i = 1; i < 25; i++)
        {
            atK = atJ[atK + atJ[atI & 0xff] & 0xff];
            avH = atJ[avH + avG + i & 0xff];
            avG = atJ[avG + avF + i & 0xff];
            avF = atJ[avF + avE + i & 0xff];
            avE = atJ[avE + atK + i & 0xff];
            avD[avC & 0x1f] = (byte)(avD[avC & 0x1f] ^ avE);
            avD[avC + 1 & 0x1f] = (byte)(avD[avC + 1 & 0x1f] ^ avF);
            avD[avC + 2 & 0x1f] = (byte)(avD[avC + 2 & 0x1f] ^ avG);
            avD[avC + 3 & 0x1f] = (byte)(avD[avC + 3 & 0x1f] ^ avH);
            avC = (byte)(avC + 4 & 0x1f);
            byte byte0 = atJ[atI & 0xff];
            atJ[atI & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte0;
            atI = (byte)(atI + 1);
        }

        for (i = 0; i < 768; i++)
        {
            atK = atJ[atK + atJ[i & 0xff] + avD[i & 0x1f] & 0xff];
            byte byte1 = atJ[i & 0xff];
            atJ[i & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte1;
        }

        byte abyte1[] = new byte[20];
        for (i = 0; i < 20; i++)
        {
            atK = atJ[atK + atJ[i & 0xff] & 0xff];
            abyte1[i] = atJ[atJ[atJ[atK & 0xff] & 0xff] + 1 & 0xff];
            byte byte2 = atJ[i & 0xff];
            atJ[i & 0xff] = atJ[atK & 0xff];
            atJ[atK & 0xff] = byte2;
        }

        System.arraycopy(abyte1, 0, abyte0, 0, 20);
        reset();
        return 20;
    }

    public final void reset()
    {
        _mth02CE(aqt, arC);
        atI = 0;
        avH = 0;
        avG = 0;
        avF = 0;
        avE = 0;
        avC = 0;
        avD = new byte[32];
        for (int i = 0; i < 32; i++)
        {
            avD[i] = 0;
        }

    }

    public final void update(byte byte0)
    {
        atK = atJ[atK + atJ[atI & 0xff] & 0xff];
        byte0 = (byte)(atJ[atJ[atJ[atK & 0xff] & 0xff] + 1 & 0xff] ^ byte0);
        avH = atJ[avH + avG & 0xff];
        avG = atJ[avG + avF & 0xff];
        avF = atJ[avF + avE & 0xff];
        avE = atJ[avE + atK + byte0 & 0xff];
        avD[avC & 0x1f] = (byte)(avD[avC & 0x1f] ^ avE);
        avD[avC + 1 & 0x1f] = (byte)(avD[avC + 1 & 0x1f] ^ avF);
        avD[avC + 2 & 0x1f] = (byte)(avD[avC + 2 & 0x1f] ^ avG);
        avD[avC + 3 & 0x1f] = (byte)(avD[avC + 3 & 0x1f] ^ avH);
        avC = (byte)(avC + 4 & 0x1f);
        byte byte1 = atJ[atI & 0xff];
        atJ[atI & 0xff] = atJ[atK & 0xff];
        atJ[atK & 0xff] = byte1;
        atI = (byte)(atI + 1);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        if (i + j > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        for (i = 0; i < j; i++)
        {
            update(abyte0[i]);
        }

    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof ParametersWithIV))
        {
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
        }
        cipherparameters = (ParametersWithIV)cipherparameters;
        KeyParameter keyparameter = (KeyParameter)((ParametersWithIV) (cipherparameters)).axC;
        if (!(((ParametersWithIV) (cipherparameters)).axC instanceof KeyParameter))
        {
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        arC = ((ParametersWithIV) (cipherparameters)).iv;
        if (arC == null || arC.length <= 0 || arC.length > 768)
        {
            throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
        } else
        {
            aqt = keyparameter.key;
            reset();
            return;
        }
    }

    public final String _mth14AC()
    {
        return "VMPC-MAC";
    }

    public final int _mth14B3()
    {
        return 20;
    }
}
