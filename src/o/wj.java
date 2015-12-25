// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package o:
//            wi, vr, wn, wq

final class wj extends InputStream
{

    private wi Vy;

    wj(wi wi1)
    {
        Vy = wi1;
        super();
    }

    public final int available()
    {
        if (Vy.closed)
        {
            throw new IOException("closed");
        } else
        {
            return (int)Math.min(Vy.Vu.size, 0x7fffffffL);
        }
    }

    public final void close()
    {
        Vy.close();
    }

    public final int read()
    {
        if (Vy.closed)
        {
            throw new IOException("closed");
        }
        if (Vy.Vu.size == 0L && Vy.Vx.read(Vy.Vu, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return Vy.Vu.readByte() & 0xff;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (Vy.closed)
        {
            throw new IOException("closed");
        }
        wq.checkOffsetAndCount(abyte0.length, i, j);
        if (Vy.Vu.size == 0L && Vy.Vx.read(Vy.Vu, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return Vy.Vu.read(abyte0, i, j);
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(Vy).append(".inputStream()").toString();
    }
}
