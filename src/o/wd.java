// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.OutputStream;

// Referenced classes of package o:
//            wm, vr, wq, wo, 
//            wk, wl

final class wd
    implements wm
{

    private wo Vq;
    private OutputStream Vr;

    wd(wo wo1, OutputStream outputstream)
    {
        Vq = wo1;
        Vr = outputstream;
        super();
    }

    public final void close()
    {
        Vr.close();
    }

    public final void flush()
    {
        Vr.flush();
    }

    public final wo timeout()
    {
        return Vq;
    }

    public final String toString()
    {
        return (new StringBuilder("sink(")).append(Vr).append(")").toString();
    }

    public final void write(vr vr1, long l)
    {
        wq.checkOffsetAndCount(vr1.size, 0L, l);
        do
        {
            if (l <= 0L)
            {
                break;
            }
            Vq.throwIfReached();
            wk wk1 = vr1.Vh;
            int i = (int)Math.min(l, wk1.limit - wk1.pos);
            Vr.write(wk1.data, wk1.pos, i);
            wk1.pos = wk1.pos + i;
            l -= i;
            vr1.size = vr1.size - (long)i;
            if (wk1.pos == wk1.limit)
            {
                vr1.Vh = wk1._mth0288();
                wl._mth02CA(wk1);
            }
        } while (true);
    }
}
