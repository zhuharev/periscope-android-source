// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InputStream;

// Referenced classes of package o:
//            wn, wo, vr, wk

final class we
    implements wn
{

    private wo Vq;
    private InputStream Vs;

    we(wo wo1, InputStream inputstream)
    {
        Vq = wo1;
        Vs = inputstream;
        super();
    }

    public final void close()
    {
        Vs.close();
    }

    public final long read(vr vr1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        Vq.throwIfReached();
        wk wk1 = vr1._mth0406(1);
        int i = (int)Math.min(l, 2048 - wk1.limit);
        i = Vs.read(wk1.data, wk1.limit, i);
        if (i == -1)
        {
            return -1L;
        } else
        {
            wk1.limit = wk1.limit + i;
            vr1.size = vr1.size + (long)i;
            return (long)i;
        }
    }

    public final wo timeout()
    {
        return Vq;
    }

    public final String toString()
    {
        return (new StringBuilder("source(")).append(Vs).append(")").toString();
    }
}
