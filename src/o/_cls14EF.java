// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.Window;

// Referenced classes of package o:
//            _cls14ED, _cls0E45

class _cls14EF extends _cls14ED
{
    /* member class not found */
    class if {}


    private boolean FF7A;

    _cls14EF(Context context, Window window, _cls0E45 _pcls0e45)
    {
        super(context, window, _pcls0e45);
        FF7A = true;
    }

    public boolean _mth02B8()
    {
        return FF7A;
    }

    android.view.Window.Callback _mth02CA(android.view.Window.Callback callback)
    {
        return new if(callback);
    }
}
