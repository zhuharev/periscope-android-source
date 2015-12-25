// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class IntentUtils
{

    public IntentUtils()
    {
    }

    public static boolean isActivityAvailable(Context context, Intent intent)
    {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public static boolean safeStartActivity(Context context, Intent intent)
    {
        if (isActivityAvailable(context, intent))
        {
            context.startActivity(intent);
            return true;
        } else
        {
            return false;
        }
    }
}
