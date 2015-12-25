// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls010B

final class _cls03DB
    implements android.view.View.OnFocusChangeListener
{

    private _cls010B hb;

    _cls03DB(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final void onFocusChange(View view, boolean flag)
    {
        if (_cls010B._mth02CE(hb) != null)
        {
            _cls010B._mth02CE(hb).onFocusChange(hb, flag);
        }
    }
}
