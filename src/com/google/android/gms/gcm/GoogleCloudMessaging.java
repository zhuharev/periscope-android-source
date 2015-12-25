// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import o.bj;
import o.bp;
import o.br;

// Referenced classes of package com.google.android.gms.gcm:
//            zza

public class GoogleCloudMessaging
{

    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    public static int zzaCs = 0;
    public static int zzaCt = 0;
    public static int zzaCu = 0;
    static GoogleCloudMessaging zzaCv;
    private static final AtomicInteger zzaCy = new AtomicInteger(1);
    private Context context;
    final Messenger zzaCA = new Messenger(new _cls1(Looper.getMainLooper()));
    private PendingIntent zzaCw;
    private Map zzaCx;
    private final BlockingQueue zzaCz = new LinkedBlockingQueue();

    public GoogleCloudMessaging()
    {
        zzaCx = Collections.synchronizedMap(new HashMap());
    }

    public static GoogleCloudMessaging getInstance(Context context1)
    {
        com/google/android/gms/gcm/GoogleCloudMessaging;
        JVM INSTR monitorenter ;
        if (zzaCv == null)
        {
            GoogleCloudMessaging googlecloudmessaging = new GoogleCloudMessaging();
            zzaCv = googlecloudmessaging;
            googlecloudmessaging.context = context1.getApplicationContext();
        }
        context1 = zzaCv;
        com/google/android/gms/gcm/GoogleCloudMessaging;
        JVM INSTR monitorexit ;
        return context1;
        context1;
        throw context1;
    }

    static String zza(Intent intent, String s)
    {
        if (intent == null)
        {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        s = intent.getStringExtra(s);
        if (s != null)
        {
            return s;
        }
        intent = intent.getStringExtra("error");
        if (intent != null)
        {
            throw new IOException(intent);
        } else
        {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    static BlockingQueue zza(GoogleCloudMessaging googlecloudmessaging)
    {
        return googlecloudmessaging.zzaCz;
    }

    private void zza(String s, String s1, long l, int i, Bundle bundle)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Object obj = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null)
        {
            ((Intent) (obj)).putExtras(bundle);
        }
        zzm(((Intent) (obj)));
        ((Intent) (obj)).setPackage(zzaA(context));
        ((Intent) (obj)).putExtra("google.to", s);
        ((Intent) (obj)).putExtra("google.message_id", s1);
        ((Intent) (obj)).putExtra("google.ttl", Long.toString(l));
        ((Intent) (obj)).putExtra("google.delay", Integer.toString(i));
        if (zzaA(context).contains(".gsf"))
        {
            obj = new Bundle();
            Iterator iterator = bundle.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s2 = (String)iterator.next();
                Object obj1 = bundle.get(s2);
                if (obj1 instanceof String)
                {
                    ((Bundle) (obj)).putString((new StringBuilder("gcm.")).append(s2).toString(), (String)obj1);
                }
            } while (true);
            ((Bundle) (obj)).putString("google.to", s);
            ((Bundle) (obj)).putString("google.message_id", s1);
            bj.FF70(context)._mth02CE("GCM", "upstream", ((Bundle) (obj)));
            return;
        } else
        {
            context.sendOrderedBroadcast(((Intent) (obj)), "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
    }

    static boolean zza(GoogleCloudMessaging googlecloudmessaging, Intent intent)
    {
        return googlecloudmessaging.zzl(intent);
    }

    public static String zzaA(Context context1)
    {
        return bp._mth02B4(context1);
    }

    public static int zzaB(Context context1)
    {
        PackageManager packagemanager = context1.getPackageManager();
        int i;
        try
        {
            i = packagemanager.getPackageInfo(zzaA(context1), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return -1;
        }
        return i;
    }

    static Context zzb(GoogleCloudMessaging googlecloudmessaging)
    {
        return googlecloudmessaging.context;
    }

    private boolean zzl(Intent intent)
    {
        String s = intent.getStringExtra("In-Reply-To");
        Object obj = s;
        if (s == null)
        {
            obj = s;
            if (intent.hasExtra("error"))
            {
                obj = intent.getStringExtra("google.message_id");
            }
        }
        if (obj != null)
        {
            obj = (Handler)zzaCx.remove(obj);
            if (obj != null)
            {
                Message message = Message.obtain();
                message.obj = intent;
                return ((Handler) (obj)).sendMessage(message);
            }
        }
        return false;
    }

    private String zzvX()
    {
        return (new StringBuilder("google.rpc")).append(String.valueOf(zzaCy.getAndIncrement())).toString();
    }

    public void close()
    {
        zzaCv = null;
        zza.zzaCi = null;
        zzvY();
    }

    public String getMessageType(Intent intent)
    {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()))
        {
            return null;
        }
        intent = intent.getStringExtra("message_type");
        if (intent != null)
        {
            return intent;
        } else
        {
            return "gcm";
        }
    }

    public transient String register(String as[])
    {
        this;
        JVM INSTR monitorenter ;
        Bundle bundle;
        as = zzc(as);
        bundle = new Bundle();
        if (!zzaA(context).contains(".gsf"))
        {
            break MISSING_BLOCK_LABEL_58;
        }
        bundle.putString("legacy.sender", as);
        as = bj.FF70(context)._mth02CB(as, "GCM", bundle);
        this;
        JVM INSTR monitorexit ;
        return as;
        bundle.putString("sender", as);
        as = zza(zzy(bundle), "registration_id");
        this;
        JVM INSTR monitorexit ;
        return as;
        as;
        throw as;
    }

    public void send(String s, String s1, long l, Bundle bundle)
    {
        zza(s, s1, l, -1, bundle);
    }

    public void send(String s, String s1, Bundle bundle)
    {
        send(s, s1, -1L, bundle);
    }

    public void unregister()
    {
        this;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        bj bj1 = bj.FF70(context);
        bj1._mth02CA("*", "*", null);
        bj1.zJ = 0L;
        br br1 = bj.zF;
        String s = bj1.zI;
        br1._mth02C7((new StringBuilder()).append(s).append("|").toString());
        bj1.zH = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    transient String zzc(String as[])
    {
        if (as == null || as.length == 0)
        {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringbuilder = new StringBuilder(as[0]);
        for (int i = 1; i < as.length; i++)
        {
            stringbuilder.append(',').append(as[i]);
        }

        return stringbuilder.toString();
    }

    void zzm(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaCw == null)
        {
            Intent intent1 = new Intent();
            intent1.setPackage("com.google.example.invalidpackage");
            zzaCw = PendingIntent.getBroadcast(context, 0, intent1, 0);
        }
        intent.putExtra("app", zzaCw);
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        throw intent;
    }

    void zzvY()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaCw != null)
        {
            zzaCw.cancel();
            zzaCw = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    Intent zzy(Bundle bundle)
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            throw new IOException("MAIN_THREAD");
        }
        if (zzaB(context) < 0)
        {
            throw new IOException("Google Play Services missing");
        }
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle = new Intent("com.google.android.c2dm.intent.REGISTER");
        bundle.setPackage(zzaA(context));
        zzm(bundle);
        bundle.putExtra("google.message_id", zzvX());
        bundle.putExtras(bundle1);
        bundle.putExtra("google.messenger", zzaCA);
        context.startService(bundle);
        try
        {
            bundle = (Intent)zzaCz.poll(30000L, TimeUnit.MILLISECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new IOException(bundle.getMessage());
        }
        return bundle;
    }

    static 
    {
        zzaCs = 0x4c4b40;
        zzaCt = 0x632ea0;
        zzaCu = 0x6acfc0;
    }

    private class _cls1 extends Handler
    {

        final GoogleCloudMessaging zzaCB;

        public void handleMessage(Message message)
        {
            if (message == null || !(message.obj instanceof Intent))
            {
                Log.w("GCM", "Dropping invalid message");
            }
            message = (Intent)message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(message.getAction()))
            {
                GoogleCloudMessaging.zza(zzaCB).add(message);
                return;
            }
            if (!GoogleCloudMessaging.zza(zzaCB, message))
            {
                message.setPackage(GoogleCloudMessaging.zzb(zzaCB).getPackageName());
                GoogleCloudMessaging.zzb(zzaCB).sendBroadcast(message);
            }
        }

        _cls1(Looper looper)
        {
            zzaCB = GoogleCloudMessaging.this;
            super(looper);
        }
    }

}
