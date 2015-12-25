// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.OutputStream;

class TlsOutputStream extends OutputStream
{

    public void close()
    {
        throw new NullPointerException();
    }

    public void flush()
    {
        throw new NullPointerException();
    }

    public void write(int i)
    {
        write(null, 0, 1);
    }

    public void write(byte abyte0[], int i, int j)
    {
        throw new NullPointerException();
    }
}
