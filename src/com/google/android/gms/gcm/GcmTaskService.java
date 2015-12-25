// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.gcm:
//            PendingCallback, TaskParams, zzb

public abstract class GcmTaskService extends Service
{
    class zza extends Thread
    {

        private final Bundle mExtras;
        private final String mTag;
        private final zzb zzaCq;
        final GcmTaskService zzaCr;

        public void run()
        {
            int i = zzaCr.onRunTask(new TaskParams(mTag, mExtras));
            zzaCq.zzgB(i);
            GcmTaskService.zza(zzaCr, mTag);
            return;
_L2:
            Log.e("GcmTaskService", (new StringBuilder("Error reporting result of operation to scheduler for ")).append(mTag).toString());
            GcmTaskService.zza(zzaCr, mTag);
            return;
            Object obj;
            obj;
            GcmTaskService.zza(zzaCr, mTag);
            throw obj;
            obj;
            if (true) goto _L2; else goto _L1
_L1:
        }

        zza(String s, IBinder ibinder, Bundle bundle)
        {
            zzaCr = GcmTaskService.this;
            super();
            mTag = s;
            zzaCq = zzb.zza.zzbR(ibinder);
            mExtras = bundle;
        }
    }


    public static final String SERVICE_ACTION_EXECUTE_TASK = "com.google.android.gms.gcm.ACTION_TASK_READY";
    public static final String SERVICE_ACTION_INITIALIZE = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE";
    public static final String SERVICE_PERMISSION = "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE";
    private final Set zzaCo = new HashSet();
    private int zzaCp;

    public GcmTaskService()
    {
    }

    static void zza(GcmTaskService gcmtaskservice, String s)
    {
        gcmtaskservice.zzdm(s);
    }

    private void zzdm(String s)
    {
        Set set = zzaCo;
        set;
        JVM INSTR monitorenter ;
        zzaCo.remove(s);
        if (zzaCo.size() == 0)
        {
            stopSelf(zzaCp);
        }
        set;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onInitializeTasks()
    {
    }

    public abstract int onRunTask(TaskParams taskparams);

    public int onStartCommand(Intent intent, int i, int j)
    {
        Object obj;
        android.os.Parcelable parcelable;
        Bundle bundle;
        intent.setExtrasClassLoader(com/google/android/gms/gcm/PendingCallback.getClassLoader());
        if (!"com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = intent.getStringExtra("tag");
        parcelable = intent.getParcelableExtra("callback");
        bundle = (Bundle)intent.getParcelableExtra("extras");
        if (parcelable == null || !(parcelable instanceof PendingCallback))
        {
            Log.e("GcmTaskService", (new StringBuilder()).append(getPackageName()).append(" ").append(((String) (obj))).append(": Could not process request, invalid callback.").toString());
            return 2;
        }
        intent = zzaCo;
        intent;
        JVM INSTR monitorenter ;
        zzaCo.add(obj);
        stopSelf(zzaCp);
        zzaCp = j;
        intent;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        (new zza(((String) (obj)), ((PendingCallback)parcelable).getIBinder(), bundle)).start();
        break MISSING_BLOCK_LABEL_231;
        if (!"com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        onInitializeTasks();
        intent = zzaCo;
        intent;
        JVM INSTR monitorenter ;
        zzaCp = j;
        if (zzaCo.size() == 0)
        {
            stopSelf(zzaCp);
        }
        intent;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_231;
        Exception exception;
        exception;
        throw exception;
        return 2;
    }
}
