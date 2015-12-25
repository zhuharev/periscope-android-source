// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package o:
//            _cls0285, _cls1E37

public final class _cls06C3
    implements android.widget.AdapterView.OnItemClickListener
{

    private _cls0285 _fld1F3B;
    private _cls0285.if _fld1F3C;

    public _cls06C3(_cls0285.if if1, _cls0285 _pcls0285)
    {
        _fld1F3C = if1;
        _fld1F3B = _pcls0285;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        _fld1F3C._fld1E8E.onClick(_fld1F3B._fld03C5, i);
        _fld1F3B._fld03C5.dismiss();
    }
}
