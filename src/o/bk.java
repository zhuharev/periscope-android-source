// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.util.Map;

// Referenced classes of package o:
//            bl, bm, br, bp, 
//            bo, bj

public class bk extends Service
{

    private static String zN = "google.com/iid";
    private static String zO = "CMD";
    private static String zzaCn = "gcm.googleapis.com/refresh";
    private MessengerCompat zL;
    private bm zM;
    private int zP;
    private int zQ;

    public bk()
    {
        zL = new MessengerCompat(new bl(this, Looper.getMainLooper()));
        zM = new bm(this);
    }

    static void _mth02B3(Context context)
    {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zO, "SYNC");
        context.startService(intent);
    }

    static void _mth02CA(Context context, br br1)
    {
        br1._mth1E9B();
        br1 = new Intent("com.google.android.gms.iid.InstanceID");
        br1.putExtra(zO, "RST");
        br1.setPackage(context.getPackageName());
        context.startService(br1);
    }

    static void _mth02CA(bk bk1, Message message, int i)
    {
        bp._mth02B4(bk1);
        bk1.getPackageManager();
        if (i != bp.zX && i != bp.zW)
        {
            Log.w("InstanceID", (new StringBuilder("Message from unexpected caller ")).append(i).append(" mine=").append(bp.zW).append(" appid=").append(bp.zX).toString());
            return;
        } else
        {
            bk1._mth02CB((Intent)message.obj);
            return;
        }
    }

    public IBinder onBind(Intent intent)
    {
        if (intent != null && "com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            intent = zL;
            if (((MessengerCompat) (intent)).zS != null)
            {
                return ((MessengerCompat) (intent)).zS.getBinder();
            } else
            {
                return ((MessengerCompat) (intent)).zT.asBinder();
            }
        } else
        {
            return null;
        }
    }

    public void onCreate()
    {
        IntentFilter intentfilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentfilter.addCategory(getPackageName());
        registerReceiver(zM, intentfilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy()
    {
        unregisterReceiver(zM);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        zP = zP + 1;
        if (j > zQ)
        {
            zQ = j;
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        intent;
        throw intent;
_L1:
        if (intent == null)
        {
            stop();
            return 2;
        }
        Intent intent1;
        if (!"com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (android.os.Build.VERSION.SDK_INT > 18)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        intent1 = (Intent)intent.getParcelableExtra("GSF");
        if (intent1 == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        startService(intent1);
        stop();
        return 1;
        _mth02CB(intent);
        stop();
        break MISSING_BLOCK_LABEL_113;
        intent;
        stop();
        throw intent;
        if (intent.getStringExtra("from") != null)
        {
            GcmReceiver.completeWakefulIntent(intent);
        }
        return 2;
    }

    final void stop()
    {
        this;
        JVM INSTR monitorenter ;
        zP = zP - 1;
        if (zP == 0)
        {
            stopSelf(zQ);
        }
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder("Stop ")).append(zP).append(" ").append(zQ).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CB(Intent intent)
    {
        String s = intent.getStringExtra("subtype");
        Object obj;
        if (s == null)
        {
            obj = bj.FF70(this);
        } else
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("subtype", s);
            obj = bj._mth02CA(this, ((Bundle) (obj)));
        }
        Object obj1 = intent.getStringExtra(zO);
        if (intent.getStringExtra("error") != null || intent.getStringExtra("registration_id") != null)
        {
            if (Log.isLoggable("InstanceID", 3))
            {
                Log.d("InstanceID", (new StringBuilder("Register result in service ")).append(s).toString());
            }
            bj._mth1D60()._mth02BB(intent);
            return;
        }
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder("Service command ")).append(s).append(" ").append(((String) (obj1))).append(" ").append(intent.getExtras()).toString());
        }
        if (intent.getStringExtra("unregistered") != null)
        {
            obj1 = bj._mth1D3B();
            if (s == null)
            {
                obj = "";
            } else
            {
                obj = s;
            }
            ((br) (obj1))._mth02C7((new StringBuilder()).append(((String) (obj))).append("|T|").toString());
            bj._mth1D60()._mth02BB(intent);
            return;
        }
        if (zzaCn.equals(intent.getStringExtra("from")))
        {
            bj._mth1D3B()._mth02C7((new StringBuilder()).append(s).append("|T|").toString());
            _mth1E3B();
            return;
        }
        if ("RST".equals(obj1))
        {
            ((bj) (obj))._mth1D30();
            _mth1E3B();
            return;
        }
        if ("RST_FULL".equals(obj1))
        {
            if (!bj._mth1D3B().Ai.getAll().isEmpty())
            {
                bj._mth1D3B()._mth1E9B();
                _mth1E3B();
                return;
            }
        } else
        {
            if ("SYNC".equals(obj1))
            {
                bj._mth1D3B()._mth02C7((new StringBuilder()).append(s).append("|T|").toString());
                _mth1E3B();
                return;
            }
            if ("PING".equals(obj1))
            {
                try
                {
                    GoogleCloudMessaging.getInstance(this).send(zN, bp._mth1E5F(), 0L, intent.getExtras());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    Log.w("InstanceID", "Failed to send ping response");
                }
            }
        }
    }

    public void _mth1E3B()
    {
    }

}
