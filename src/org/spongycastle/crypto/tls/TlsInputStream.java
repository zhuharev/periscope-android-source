// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.InputStream;

class TlsInputStream extends InputStream
{

    public int available()
    {
        throw new NullPointerException();
    }

    public void close()
    {
        throw new NullPointerException();
    }

    public int read()
    {
        if (read(null) < 0)
        {
            return -1;
        } else
        {
            throw new NullPointerException();
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        throw new NullPointerException();
    }
}
