// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.widget.NestedScrollView;
import android.view.View;

// Referenced classes of package o:
//            _cls0285

public class _cls05D3
    implements android.support.v4.widget.NestedScrollView._cls02CA
{

    public static final int abc_max_action_buttons = 0x7f0b0000;
    private _cls0285 _fld1D42;
    private View _fld1E2C;
    private View _fld1E2D;

    public _cls05D3()
    {
    }

    _cls05D3(_cls0285 _pcls0285, View view, View view1)
    {
        _fld1D42 = _pcls0285;
        _fld1E2C = view;
        _fld1E2D = view1;
        super();
    }

    public final void _mth02CB(NestedScrollView nestedscrollview)
    {
        _cls0285._mth02CA(nestedscrollview, _fld1E2C, _fld1E2D);
    }
}
