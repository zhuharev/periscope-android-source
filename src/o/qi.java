// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package o:
//            qb

public final class qi
    implements android.app.Application.ActivityLifecycleCallbacks
{
    public static interface if
    {

        public abstract void _mth0211();

        public abstract void _mth021B();
    }


    private if Px;
    private boolean Py;
    private int mActivityCounter;

    public qi(qb qb)
    {
        Px = qb;
        Py = true;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public final void onActivityDestroyed(Activity activity)
    {
    }

    public final void onActivityPaused(Activity activity)
    {
    }

    public final void onActivityResumed(Activity activity)
    {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public final void onActivityStarted(Activity activity)
    {
        if (!Py)
        {
            boolean flag;
            if (mActivityCounter == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Px._mth021B();
            }
        }
        mActivityCounter = mActivityCounter + 1;
        Py = false;
    }

    public final void onActivityStopped(Activity activity)
    {
        mActivityCounter = mActivityCounter - 1;
        boolean flag;
        if (mActivityCounter == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Px._mth0211();
        }
    }
}
