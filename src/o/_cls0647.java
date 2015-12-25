// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package o:
//            _cls010B

final class _cls0647
    implements android.widget.TextView.OnEditorActionListener
{

    private _cls010B hb;

    _cls0647(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        _cls010B._mth1FBE(hb);
        return true;
    }
}
