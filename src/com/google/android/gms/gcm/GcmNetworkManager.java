// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.gcm:
//            GoogleCloudMessaging, Task

public class GcmNetworkManager
{

    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager zzaCh;
    private Context mContext;
    private final PendingIntent mPendingIntent;

    private GcmNetworkManager(Context context)
    {
        mContext = context;
        mPendingIntent = PendingIntent.getBroadcast(mContext, 0, new Intent(), 0);
    }

    public static GcmNetworkManager getInstance(Context context)
    {
        if (zzaCh == null)
        {
            zzaCh = new GcmNetworkManager(context.getApplicationContext());
        }
        return zzaCh;
    }

    static void zzdh(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Must provide a valid tag.");
        }
        if (100 < s.length())
        {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        } else
        {
            return;
        }
    }

    private void zzdi(String s)
    {
        if (s == null)
        {
            throw new NullPointerException(String.valueOf("GcmTaskService must not be null."));
        }
        Object obj = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
        ((Intent) (obj)).setPackage(mContext.getPackageName());
        obj = mContext.getPackageManager().queryIntentServices(((Intent) (obj)), 0);
        boolean flag;
        if (obj != null && ((List) (obj)).size() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?"));
        }
        boolean flag1 = false;
        obj = ((List) (obj)).iterator();
        do
        {
            flag = flag1;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (!((ResolveInfo)((Iterator) (obj)).next()).serviceInfo.name.equals(s))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        s = (new StringBuilder("The GcmTaskService class you provided ")).append(s).append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.").toString();
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf(s));
        } else
        {
            return;
        }
    }

    private Intent zzvV()
    {
        int i = GoogleCloudMessaging.zzaB(mContext);
        if (i < GoogleCloudMessaging.zzaCs)
        {
            Log.e("GcmNetworkManager", (new StringBuilder("Google Play Services is not available, dropping GcmNetworkManager request. code=")).append(i).toString());
            return null;
        } else
        {
            Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
            intent.setPackage(GoogleCloudMessaging.zzaA(mContext));
            intent.putExtra("app", mPendingIntent);
            return intent;
        }
    }

    public void cancelAllTasks(Class class1)
    {
        zzdi(class1.getName());
        Intent intent = zzvV();
        if (intent == null)
        {
            return;
        } else
        {
            intent.putExtra("scheduler_action", "CANCEL_ALL");
            intent.putExtra("component", new ComponentName(mContext, class1));
            mContext.sendBroadcast(intent);
            return;
        }
    }

    public void cancelTask(String s, Class class1)
    {
        zzdh(s);
        zzdi(class1.getName());
        Intent intent = zzvV();
        if (intent == null)
        {
            return;
        } else
        {
            intent.putExtra("scheduler_action", "CANCEL_TASK");
            intent.putExtra("tag", s);
            intent.putExtra("component", new ComponentName(mContext, class1));
            mContext.sendBroadcast(intent);
            return;
        }
    }

    public void schedule(Task task)
    {
        zzdi(task.getServiceName());
        Intent intent = zzvV();
        if (intent == null)
        {
            return;
        } else
        {
            Bundle bundle = intent.getExtras();
            bundle.putString("scheduler_action", "SCHEDULE_TASK");
            task.toBundle(bundle);
            intent.putExtras(bundle);
            mContext.sendBroadcast(intent);
            return;
        }
    }
}
