// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.transition.Transition;

// Referenced classes of package o:
//            _cls1D54

final class FE76 extends android.transition.Transition.EpicenterCallback
{

    private Rect _fld1551;
    final _cls1D54.if _fld157D;

    FE76(_cls1D54.if if1)
    {
        _fld157D = if1;
        super();
    }

    public final Rect onGetEpicenter(Transition transition)
    {
        if (_fld1551 == null && _fld157D.FB4B != null)
        {
            _fld1551 = _cls1D54._mth02CE(_fld157D.FB4B);
        }
        return _fld1551;
    }
}
