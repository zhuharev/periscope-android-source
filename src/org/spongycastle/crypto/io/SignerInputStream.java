// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.InputStream;

public class SignerInputStream extends FilterInputStream
{

    public int read()
    {
        byte byte0 = in.read();
        if (byte0 >= 0)
        {
            byte0 = (byte)byte0;
            throw new NullPointerException();
        } else
        {
            return byte0;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        i = in.read(abyte0, i, j);
        if (i > 0)
        {
            throw new NullPointerException();
        } else
        {
            return i;
        }
    }
}
