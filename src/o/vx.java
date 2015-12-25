// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.zip.Deflater;

// Referenced classes of package o:
//            wm, wc, vu, vr, 
//            wk, wl, wq, wo

public final class vx
    implements wm
{

    private final Deflater Vm;
    private boolean closed;
    private final vu sink;

    public vx(vr vr1, Deflater deflater)
    {
        this(((vu) (wc._mth02CA(vr1))), deflater);
    }

    private vx(vu vu1, Deflater deflater)
    {
        if (vu1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            sink = vu1;
            Vm = deflater;
            return;
        }
    }

    private void _mth02D0(boolean flag)
    {
        vr vr1 = sink.FE93();
        wk wk1;
        do
        {
            do
            {
                wk1 = vr1._mth0406(1);
                int i;
                if (flag)
                {
                    i = Vm.deflate(wk1.data, wk1.limit, 2048 - wk1.limit, 2);
                } else
                {
                    i = Vm.deflate(wk1.data, wk1.limit, 2048 - wk1.limit);
                }
                if (i <= 0)
                {
                    break;
                }
                wk1.limit = wk1.limit + i;
                vr1.size = vr1.size + (long)i;
                sink._mth0165();
            } while (true);
        } while (!Vm.needsInput());
        if (wk1.pos == wk1.limit)
        {
            vr1.Vh = wk1._mth0288();
            wl._mth02CA(wk1);
        }
    }

    public final void close()
    {
        Throwable throwable1;
        if (closed)
        {
            return;
        }
        throwable1 = null;
        try
        {
            Vm.finish();
            _mth02D0(false);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
        Vm.end();
        Throwable throwable;
        throwable = throwable1;
        break MISSING_BLOCK_LABEL_47;
        Throwable throwable2;
        throwable2;
        throwable = throwable1;
        if (throwable1 == null)
        {
            throwable = throwable2;
        }
        sink.close();
        throwable1 = throwable;
        break MISSING_BLOCK_LABEL_70;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
        closed = true;
        if (throwable1 != null)
        {
            wq._mth141D(throwable1);
        }
        return;
    }

    public final void flush()
    {
        _mth02D0(true);
        sink.flush();
    }

    public final wo timeout()
    {
        return sink.timeout();
    }

    public final String toString()
    {
        return (new StringBuilder("DeflaterSink(")).append(sink).append(")").toString();
    }

    public final void write(vr vr1, long l)
    {
        wq.checkOffsetAndCount(vr1.size, 0L, l);
        int i;
        for (; l > 0L; l -= i)
        {
            wk wk1 = vr1.Vh;
            i = (int)Math.min(l, wk1.limit - wk1.pos);
            Vm.setInput(wk1.data, wk1.pos, i);
            _mth02D0(false);
            vr1.size = vr1.size - (long)i;
            wk1.pos = wk1.pos + i;
            if (wk1.pos == wk1.limit)
            {
                vr1.Vh = wk1._mth0288();
                wl._mth02CA(wk1);
            }
        }

    }
}
