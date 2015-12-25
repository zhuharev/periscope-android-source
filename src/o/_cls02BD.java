// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package o:
//            _cls141D

final class _cls02BD
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private View _fld02B9;
    private _cls141D._cls02CA _fld0674;
    private int _fld1D54;
    private Object _fld1D62;
    private _cls141D FF9E;

    _cls02BD(_cls141D _pcls141d, View view, _cls141D._cls02CA _pcls02ca, int i, Object obj)
    {
        FF9E = _pcls141d;
        _fld02B9 = view;
        _fld0674 = _pcls02ca;
        _fld1D54 = i;
        _fld1D62 = obj;
        super();
    }

    public final boolean onPreDraw()
    {
        _fld02B9.getViewTreeObserver().removeOnPreDrawListener(this);
        _cls141D._mth02CA(FF9E, _fld0674, _fld1D54, _fld1D62);
        return true;
    }
}
