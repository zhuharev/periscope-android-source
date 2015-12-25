// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

// Referenced classes of package o:
//            _cls0645, _cls0699

public final class _cls0505 extends InputStream
{

    private static final Queue se = _cls0645._mth1D5B(0);
    private InputStream sf;
    public IOException sg;

    _cls0505()
    {
    }

    public static _cls0505 _mth02CA(_cls0699 _pcls0699)
    {
        Queue queue = se;
        queue;
        JVM INSTR monitorenter ;
        _cls0505 _lcls0505 = (_cls0505)se.poll();
        queue;
        JVM INSTR monitorexit ;
          goto _L1
        _pcls0699;
        throw _pcls0699;
_L1:
        _cls0505 _lcls0505_1 = _lcls0505;
        if (_lcls0505 == null)
        {
            _lcls0505_1 = new _cls0505();
        }
        _lcls0505_1.sf = _pcls0699;
        return _lcls0505_1;
    }

    public final int available()
    {
        return sf.available();
    }

    public final void close()
    {
        sf.close();
    }

    public final void mark(int i)
    {
        sf.mark(i);
    }

    public final boolean markSupported()
    {
        return sf.markSupported();
    }

    public final int read()
    {
        int i;
        try
        {
            i = sf.read();
        }
        catch (IOException ioexception)
        {
            sg = ioexception;
            return -1;
        }
        return i;
    }

    public final int read(byte abyte0[])
    {
        int i;
        try
        {
            i = sf.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            sg = abyte0;
            return -1;
        }
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        try
        {
            i = sf.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            sg = abyte0;
            return -1;
        }
        return i;
    }

    public final void release()
    {
        sg = null;
        sf = null;
        Queue queue = se;
        queue;
        JVM INSTR monitorenter ;
        se.offer(this);
        queue;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void reset()
    {
        this;
        JVM INSTR monitorenter ;
        sf.reset();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final long skip(long l)
    {
        try
        {
            l = sf.skip(l);
        }
        catch (IOException ioexception)
        {
            sg = ioexception;
            return 0L;
        }
        return l;
    }

}
