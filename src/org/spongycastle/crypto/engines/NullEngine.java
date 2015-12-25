// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;

public class NullEngine
    implements BlockCipher
{

    private boolean aqH;
    private final int kY;

    public NullEngine()
    {
        this(1);
    }

    private NullEngine(int i)
    {
        kY = 1;
    }

    public final int getBlockSize()
    {
        return kY;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (!aqH)
        {
            throw new IllegalStateException("Null engine not initialised");
        }
        if (kY + i > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (kY + j > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        for (int k = 0; k < kY; k++)
        {
            abyte1[j + k] = abyte0[i + k];
        }

        return kY;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        aqH = true;
    }

    public final String _mth14AC()
    {
        return "Null";
    }
}
