// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class _cls02C6
{

    _cls02C6()
    {
    }

    public static Intent _mth02BB(Activity activity)
    {
        return activity.getParentActivityIntent();
    }

    public static String _mth02CA(ActivityInfo activityinfo)
    {
        return activityinfo.parentActivityName;
    }

    public static boolean _mth02CA(Activity activity, Intent intent)
    {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void _mth02CB(Activity activity, Intent intent)
    {
        activity.navigateUpTo(intent);
    }
}
