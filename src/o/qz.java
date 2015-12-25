// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Bundle;

final class qz
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private qy._cls02CA QA;
    private qy.if QB;

    qz(qy.if if1, qy._cls02CA _pcls02ca)
    {
        QB = if1;
        QA = _pcls02ca;
        super();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        QA.onActivityCreated(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity)
    {
        QA.onActivityDestroyed(activity);
    }

    public final void onActivityPaused(Activity activity)
    {
        QA.onActivityPaused(activity);
    }

    public final void onActivityResumed(Activity activity)
    {
        QA.onActivityResumed(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
        QA.onActivitySaveInstanceState(activity, bundle);
    }

    public final void onActivityStarted(Activity activity)
    {
        QA.onActivityStarted(activity);
    }

    public final void onActivityStopped(Activity activity)
    {
        QA.onActivityStopped(activity);
    }
}
