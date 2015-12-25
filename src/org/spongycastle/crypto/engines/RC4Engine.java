// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;

public class RC4Engine
    implements StreamCipher
{

    private byte aqt[];
    private byte asq[];
    private int x;
    private int y;

    public RC4Engine()
    {
        asq = null;
        x = 0;
        y = 0;
        aqt = null;
    }

    private void _mth1D54(byte abyte0[])
    {
        aqt = abyte0;
        x = 0;
        y = 0;
        if (asq == null)
        {
            asq = new byte[256];
        }
        for (int i = 0; i < 256; i++)
        {
            asq[i] = (byte)i;
        }

        int k = 0;
        int l = 0;
        for (int j = 0; j < 256; j++)
        {
            l = (abyte0[k] & 0xff) + asq[j] + l & 0xff;
            byte byte0 = asq[j];
            byte abyte1[] = asq;
            abyte1[j] = abyte1[l];
            asq[l] = byte0;
            k = (k + 1) % abyte0.length;
        }

    }

    public final void reset()
    {
        _mth1D54(aqt);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof KeyParameter)
        {
            aqt = ((KeyParameter)cipherparameters).key;
            _mth1D54(aqt);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to RC4 init - ")).append(cipherparameters.getClass().getName()).toString());
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
            x = x + 1 & 0xff;
            y = asq[x] + y & 0xff;
            byte byte0 = asq[x];
            asq[x] = asq[y];
            asq[y] = byte0;
            abyte1[l + k] = (byte)(abyte0[l + i] ^ asq[asq[x] + asq[y] & 0xff]);
        }

        return j;
    }

    public final String _mth14AC()
    {
        return "RC4";
    }
}
