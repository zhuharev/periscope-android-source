// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls0192

public final class _cls0284
    implements _cls0192
{
    /* member class not found */
    class if {}


    private final if rN;

    _cls0284(if if1)
    {
        rN = if1;
    }

    public final boolean _mth02CA(Object obj, _cls0192.if if1)
    {
        obj = if1.getView();
        if (obj != null)
        {
            ((View) (obj)).clearAnimation();
            ((View) (obj)).startAnimation(rN._mth0441());
        }
        return false;
    }
}
