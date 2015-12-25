// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.android.gms.gcm:
//            GcmReceiver, zza

public abstract class GcmListenerService extends Service
{

    private int zzaCe;
    private int zzaCf;
    private final Object zzpd = new Object();

    public GcmListenerService()
    {
        zzaCf = 0;
    }

    static void zza(GcmListenerService gcmlistenerservice, Intent intent)
    {
        gcmlistenerservice.zzk(intent);
    }

    private final void zzk(Intent intent)
    {
        boolean flag = "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
        if (!flag)
        {
            GcmReceiver.completeWakefulIntent(intent);
            return;
        }
        String s = intent.getStringExtra("message_type");
        Object obj;
        byte byte0;
        obj = s;
        if (s == null)
        {
            obj = "gcm";
        }
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 277
    //                   -2062414158: 103
    //                   102161: 88
    //                   814694033: 133
    //                   814800675: 118;
           goto _L1 _L2 _L3 _L4 _L5
_L3:
        if (((String) (obj)).equals("gcm"))
        {
            byte0 = 0;
        }
          goto _L1
_L2:
        if (((String) (obj)).equals("deleted_messages"))
        {
            byte0 = 1;
        }
          goto _L1
_L5:
        if (((String) (obj)).equals("send_event"))
        {
            byte0 = 2;
        }
          goto _L1
_L4:
        if (((String) (obj)).equals("send_error"))
        {
            byte0 = 3;
        }
          goto _L1
_L9:
        zzt(intent.getExtras());
          goto _L6
_L10:
        onDeletedMessages();
          goto _L6
_L11:
        onMessageSent(intent.getStringExtra("google.message_id"));
          goto _L6
_L12:
        onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
          goto _L6
_L8:
        Log.w("GcmListenerService", (new StringBuilder("Received message with unknown type: ")).append(((String) (obj))).toString());
_L6:
        obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzaCf = zzaCf - 1;
        if (zzaCf == 0)
        {
            zzgA(zzaCe);
        }
        obj;
        JVM INSTR monitorexit ;
          goto _L7
        Exception exception1;
        exception1;
        throw exception1;
_L7:
        GcmReceiver.completeWakefulIntent(intent);
        return;
        Exception exception;
        exception;
        GcmReceiver.completeWakefulIntent(intent);
        throw exception;
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 308
    //                   0 148
    //                   1 159
    //                   2 166
    //                   3 179;
           goto _L8 _L9 _L10 _L11 _L12
    }

    private void zzt(Bundle bundle)
    {
        bundle.remove("message_type");
        bundle.remove("android.support.content.wakelockid");
        if (com.google.android.gms.gcm.zza.zzu(bundle))
        {
            com.google.android.gms.gcm.zza.zzaz(this).zzv(bundle);
            return;
        } else
        {
            String s = bundle.getString("from");
            bundle.remove("from");
            onMessageReceived(s, bundle);
            return;
        }
    }

    public final IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onDeletedMessages()
    {
    }

    public void onMessageReceived(String s, Bundle bundle)
    {
    }

    public void onMessageSent(String s)
    {
    }

    public void onSendError(String s, String s1)
    {
    }

    public final int onStartCommand(final Intent intent, int i, int j)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzaCe = j;
        zzaCf = zzaCf + 1;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        intent;
        throw intent;
_L1:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new _cls1());
        } else
        {
            (new _cls2()).execute(new Void[0]);
        }
        return 3;
    }

    boolean zzgA(int i)
    {
        return stopSelfResult(i);
    }

    private class _cls1
        implements Runnable
    {

        final Intent val$intent;
        final GcmListenerService zzaCg;

        public void run()
        {
            GcmListenerService.zza(zzaCg, intent);
        }

        _cls1()
        {
            zzaCg = GcmListenerService.this;
            intent = intent1;
            super();
        }
    }


    private class _cls2 extends AsyncTask
    {

        final Intent val$intent;
        final GcmListenerService zzaCg;

        protected Object doInBackground(Object aobj[])
        {
            return zzb((Void[])aobj);
        }

        protected transient Void zzb(Void avoid[])
        {
            GcmListenerService.zza(zzaCg, intent);
            return null;
        }

        _cls2()
        {
            zzaCg = GcmListenerService.this;
            intent = intent1;
            super();
        }
    }

}
