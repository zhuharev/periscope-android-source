// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Queue;

// Referenced classes of package o:
//            _cls14FB, _cls0645, _cls51AB

static final class eue
{

    private final Queue qi = _cls0645._mth1D5B(0);

    public final void _mth02CA(_cls51AB _pcls51ab)
    {
        this;
        JVM INSTR monitorenter ;
        _pcls51ab.ku = null;
        _pcls51ab.kC = null;
        qi.offer(_pcls51ab);
        this;
        JVM INSTR monitorexit ;
        return;
        _pcls51ab;
        throw _pcls51ab;
    }

    public final _cls51AB _mth02CE(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        _cls51AB _lcls51ab1 = (_cls51AB)qi.poll();
        _cls51AB _lcls51ab;
        _lcls51ab = _lcls51ab1;
        if (_lcls51ab1 != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        _lcls51ab = new _cls51AB();
        abyte0 = _lcls51ab._mth02CA(abyte0);
        this;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        throw abyte0;
    }

    eue()
    {
    }
}
