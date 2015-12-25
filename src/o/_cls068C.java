// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.AbsListView;

// Referenced classes of package o:
//            _cls0285

final class _cls068C
    implements android.widget.AbsListView.OnScrollListener
{

    private _cls0285 _fld1D42;
    private View _fld1E2C;
    private View _fld1E2D;

    _cls068C(_cls0285 _pcls0285, View view, View view1)
    {
        _fld1D42 = _pcls0285;
        _fld1E2C = view;
        _fld1E2D = view1;
        super();
    }

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        _cls0285._mth02CA(abslistview, _fld1E2C, _fld1E2D);
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }
}
