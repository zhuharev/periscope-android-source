// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package o:
//            wn, wc, vv, vr, 
//            wk, wl, wo

public final class wb
    implements wn
{

    private final Inflater Vo;
    private int Vp;
    private boolean closed;
    private final vv source;

    public wb(com.squareup.okhttp.internal.spdy.NameValueBlockReader._cls1 _pcls1, com.squareup.okhttp.internal.spdy.NameValueBlockReader._cls2 _pcls2)
    {
        this(((vv) (wc._mth02CB(_pcls1))), ((Inflater) (_pcls2)));
    }

    wb(vv vv1, Inflater inflater)
    {
        if (vv1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            source = vv1;
            Vo = inflater;
            return;
        }
    }

    private void _mth025C()
    {
        if (Vp == 0)
        {
            return;
        } else
        {
            int i = Vp - Vo.getRemaining();
            Vp = Vp - i;
            source._mth02D1(i);
            return;
        }
    }

    public final void close()
    {
        if (closed)
        {
            return;
        } else
        {
            Vo.end();
            closed = true;
            source.close();
            return;
        }
    }

    public final long read(vr vr1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = _mth025B();
        wk wk1;
        int i;
        try
        {
            wk1 = vr1._mth0406(1);
            i = Vo.inflate(wk1.data, wk1.limit, 2048 - wk1.limit);
        }
        // Misplaced declaration of an exception variable
        catch (vr vr1)
        {
            throw new IOException(vr1);
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        wk1.limit = wk1.limit + i;
        vr1.size = vr1.size + (long)i;
        return (long)i;
        if (!Vo.finished() && !Vo.needsDictionary())
        {
            continue; /* Loop/switch isn't completed */
        }
        _mth025C();
        if (wk1.pos == wk1.limit)
        {
            vr1.Vh = wk1._mth0288();
            wl._mth02CA(wk1);
        }
        return -1L;
        if (!flag) goto _L2; else goto _L1
_L1:
        throw new EOFException("source exhausted prematurely");
    }

    public final wo timeout()
    {
        return source.timeout();
    }

    public final boolean _mth025B()
    {
        if (!Vo.needsInput())
        {
            return false;
        }
        _mth025C();
        if (Vo.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (source.FF46())
        {
            return true;
        } else
        {
            wk wk1 = source.FE93().Vh;
            Vp = wk1.limit - wk1.pos;
            Vo.setInput(wk1.data, wk1.pos, Vp);
            return false;
        }
    }
}
