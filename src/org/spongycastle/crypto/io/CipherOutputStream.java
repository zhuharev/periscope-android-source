// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CipherOutputStream extends FilterOutputStream
{

    private final byte aoj[];
    private byte buf[];

    public void close()
    {
        if (buf == null || buf.length < 0)
        {
            buf = new byte[0];
        }
        IOException ioexception = null;
        try
        {
            flush();
            out.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        if (ioexception != null)
        {
            throw ioexception;
        } else
        {
            return;
        }
    }

    public void flush()
    {
        out.flush();
    }

    public void write(int i)
    {
        aoj[0] = (byte)i;
        write(aoj, 0, 1);
    }

    public void write(byte abyte0[])
    {
        write(abyte0, 0, abyte0.length);
    }

    public void write(byte abyte0[], int i, int j)
    {
        if (buf == null || buf.length < j)
        {
            buf = new byte[j];
        }
        abyte0 = buf;
        throw new NullPointerException();
    }
}
