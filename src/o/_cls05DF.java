// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.WindowInsets;

// Referenced classes of package o:
//            _cls0208, _cls4E36

final class _cls05DF
    implements android.view.View.OnApplyWindowInsetsListener
{

    final _cls4E36 FB82;

    _cls05DF(_cls4E36 _pcls4e36)
    {
        FB82 = _pcls4e36;
        super();
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowinsets)
    {
        windowinsets = new _cls0208(windowinsets);
        return ((_cls0208)FB82._mth02CA(view, windowinsets))._mth0131();
    }
}
