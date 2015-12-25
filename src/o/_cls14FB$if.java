// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Queue;

// Referenced classes of package o:
//            _cls14FB, _cls0645, _cls30CE

static final class Queue
{

    private final Queue qi = _cls0645._mth1D5B(0);

    public final _cls30CE _mth02CA(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        _cls30CE _lcls30ce1 = (_cls30CE)qi.poll();
        _cls30CE _lcls30ce;
        _lcls30ce = _lcls30ce1;
        if (_lcls30ce1 != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        _lcls30ce = new _cls30CE(obj);
        this;
        JVM INSTR monitorexit ;
        return _lcls30ce;
        obj;
        throw obj;
    }

    public final void _mth02CA(_cls30CE _pcls30ce)
    {
        this;
        JVM INSTR monitorenter ;
        _pcls30ce.kC = null;
        _pcls30ce.data = null;
        _pcls30ce.kz = null;
        _pcls30ce.kA = null;
        if (_pcls30ce.kE != null)
        {
            _pcls30ce.kD._mth02CE(_pcls30ce.kE);
        }
        _pcls30ce.kE = null;
        qi.offer(_pcls30ce);
        this;
        JVM INSTR monitorexit ;
        return;
        _pcls30ce;
        throw _pcls30ce;
    }

    Queue()
    {
    }
}
