// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class _cls0501 extends FilterInputStream
{

    private final long contentLength;
    private int sd;

    public _cls0501(InputStream inputstream, long l)
    {
        super(inputstream);
        contentLength = l;
    }

    private int _mth1D59(int i)
    {
        if (i >= 0)
        {
            sd = sd + i;
            return i;
        }
        if (contentLength - (long)sd > 0L)
        {
            throw new IOException((new StringBuilder("Failed to read all expected data, expected: ")).append(contentLength).append(", but read: ").append(sd).toString());
        } else
        {
            return i;
        }
    }

    public final int available()
    {
        this;
        JVM INSTR monitorenter ;
        long l = Math.max(contentLength - (long)sd, in.available());
        int i = (int)l;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int read()
    {
        this;
        JVM INSTR monitorenter ;
        int i = _mth1D59(super.read());
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        i = _mth1D59(super.read(abyte0, i, j));
        this;
        JVM INSTR monitorexit ;
        return i;
        abyte0;
        throw abyte0;
    }
}
