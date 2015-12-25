// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.tls.SignerInputBuffer;

public class TeeInputStream extends InputStream
{

    private final InputStream aPB;
    private final OutputStream ud;

    public TeeInputStream(InputStream inputstream, SignerInputBuffer signerinputbuffer)
    {
        aPB = inputstream;
        ud = signerinputbuffer;
    }

    public void close()
    {
        aPB.close();
        ud.close();
    }

    public int read()
    {
        int i = aPB.read();
        if (i >= 0)
        {
            ud.write(i);
        }
        return i;
    }

    public int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = aPB.read(abyte0, i, j);
        if (j > 0)
        {
            ud.write(abyte0, i, j);
        }
        return j;
    }
}
