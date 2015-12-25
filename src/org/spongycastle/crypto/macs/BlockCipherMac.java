// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;

public class BlockCipherMac
    implements Mac
{

    private int amw;

    public final int doFinal(byte abyte0[], int i)
    {
        throw new NullPointerException();
    }

    public final void reset()
    {
        amw = 0;
        throw new NullPointerException();
    }

    public final void update(byte byte0)
    {
        if (amw == null.length)
        {
            throw new NullPointerException();
        } else
        {
            amw = amw + 1;
            return;
        }
    }

    public final void update(byte abyte0[], int i, int j)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        } else
        {
            throw new NullPointerException();
        }
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        amw = 0;
        throw new NullPointerException();
    }

    public final String _mth14AC()
    {
        throw new NullPointerException();
    }

    public final int _mth14B3()
    {
        return 0;
    }
}
