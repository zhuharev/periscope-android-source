// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls1E3B

final class _cls1E5F
    implements Runnable
{

    private _cls1E3B cR;

    _cls1E5F(_cls1E3B _pcls1e3b)
    {
        cR = _pcls1e3b;
        super();
    }

    public final void run()
    {
        View view = cR.getAnchorView();
        if (view != null && view.getWindowToken() != null)
        {
            cR.show();
        }
    }
}
