// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.transition.Transition;

final class _cls1D62 extends android.transition.Transition.EpicenterCallback
{

    final Rect _fld09F2;

    _cls1D62(Rect rect)
    {
        _fld09F2 = rect;
        super();
    }

    public final Rect onGetEpicenter(Transition transition)
    {
        return _fld09F2;
    }
}
