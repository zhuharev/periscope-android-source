// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Queue;

// Referenced classes of package o:
//            _cls05D7, _cls1F35

final class _cls1FD6 extends _cls05D7
{

    private _cls1F35 oN;

    _cls1FD6(_cls1F35 _pcls1f35, int i)
    {
        oN = _pcls1f35;
        super(i);
    }

    protected final void _mth02CF(Object obj, Object obj1)
    {
        obj = (_cls1F35.if)obj;
        _cls1F35.if.oO.offer(obj);
    }
}
