// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;

public class BufferingOutputStream extends OutputStream
{

    private final OutputStream aPA;
    private int amw;
    private final byte buf[];

    public void close()
    {
        flush();
        aPA.close();
    }

    public void flush()
    {
        aPA.write(buf, 0, amw);
        amw = 0;
        Arrays.fill(buf, (byte)0);
    }

    public void write(int i)
    {
        byte abyte0[] = buf;
        int j = amw;
        amw = j + 1;
        abyte0[j] = (byte)i;
        if (amw == buf.length)
        {
            flush();
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        if (j < buf.length - amw)
        {
            System.arraycopy(abyte0, i, buf, amw, j);
            amw = amw + j;
            return;
        }
        int l = buf.length - amw;
        System.arraycopy(abyte0, i, buf, amw, l);
        amw = amw + l;
        flush();
        int k = i + l;
        i = j - l;
        j = k;
        for (; i >= buf.length; i -= buf.length)
        {
            aPA.write(abyte0, j, buf.length);
            j += buf.length;
        }

        if (i > 0)
        {
            System.arraycopy(abyte0, j, buf, amw, i);
            amw = amw + i;
        }
    }
}
