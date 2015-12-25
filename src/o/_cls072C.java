// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package o:
//            _cls148C

final class _cls072C extends qy._cls02CA
{

    private final _cls148C sw;

    public _cls072C(_cls148C _pcls148c)
    {
        sw = _pcls148c;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.th);
    }

    public final void onActivityDestroyed(Activity activity)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.tn);
    }

    public final void onActivityPaused(Activity activity)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.tl);
    }

    public final void onActivityResumed(Activity activity)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.tj);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.tk);
    }

    public final void onActivityStarted(Activity activity)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.ti);
    }

    public final void onActivityStopped(Activity activity)
    {
        sw._mth02CA(activity, _cls1491._cls02CA.tm);
    }
}
