// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.format.Formatter;
import android.util.Log;

public final class _cls1500
{
    /* member class not found */
    class if {}


    private final Context context;
    public final int og;
    public final int oh;

    public _cls1500(Context context1)
    {
        this(context1, (ActivityManager)context1.getSystemService("activity"), new if(context1.getResources().getDisplayMetrics()));
    }

    private _cls1500(Context context1, ActivityManager activitymanager, if if1)
    {
        context = context1;
        int j = activitymanager.getMemoryClass();
        int i = android.os.Build.VERSION.SDK_INT;
        boolean flag;
        if (i < 11 || i >= 19 && activitymanager.isLowRamDevice())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        float f1 = j << 10 << 10;
        float f;
        if (flag)
        {
            f = 0.33F;
        } else
        {
            f = 0.4F;
        }
        flag = Math.round(f1 * f);
        int k = if1._mth1F77() * if1._mth1FD0() << 2;
        j = k << 2;
        k <<= 1;
        if (k + j <= flag)
        {
            oh = k;
            og = j;
        } else
        {
            int l = Math.round((float)flag / 6F);
            oh = l << 1;
            og = l << 2;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3))
        {
            context1 = new StringBuilder("Calculated memory cache size: ");
            int i1 = oh;
            context1 = context1.append(Formatter.formatFileSize(context, i1)).append(" pool size: ");
            i1 = og;
            context1 = context1.append(Formatter.formatFileSize(context, i1)).append(" memory class limited? ");
            boolean flag1;
            if (k + j > flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            context1 = context1.append(flag1).append(" max size: ").append(Formatter.formatFileSize(context, flag)).append(" memoryClass: ").append(activitymanager.getMemoryClass()).append(" isLowMemoryDevice: ");
            flag = android.os.Build.VERSION.SDK_INT;
            if (flag < 11 || flag >= 19 && activitymanager.isLowRamDevice())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            Log.d("MemorySizeCalculator", context1.append(flag1).toString());
        }
    }
}
