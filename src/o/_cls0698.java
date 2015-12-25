// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Queue;

// Referenced classes of package o:
//            _cls0645, _cls13A2

abstract class _cls0698
{

    final Queue nu = _cls0645._mth1D5B(20);

    _cls0698()
    {
    }

    protected abstract _cls13A2 _mth1D5F();

    protected final _cls13A2 _mth1E37()
    {
        _cls13A2 _lcls13a2_1 = (_cls13A2)nu.poll();
        _cls13A2 _lcls13a2 = _lcls13a2_1;
        if (_lcls13a2_1 == null)
        {
            _lcls13a2 = _mth1D5F();
        }
        return _lcls13a2;
    }
}
