// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package o:
//            bj, bk, bq, bo

public final class bp
{

    private static String zV = null;
    static int zW = 0;
    static int zX = 0;
    private static int zY = 0;
    Messenger Aa;
    MessengerCompat Ab;
    private long Ac;
    private long Ad;
    private int Ae;
    private int Af;
    private long Ag;
    private Context context;
    private HashMap zZ;
    private Messenger zzaCA;
    private PendingIntent zzaCw;

    public bp(Context context1)
    {
        zZ = new HashMap();
        context = context1;
    }

    public static String _mth02B4(Context context1)
    {
        Iterator iterator;
        if (zV != null)
        {
            return zV;
        }
        zW = Process.myUid();
        context1 = context1.getPackageManager();
        iterator = context1.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
_L2:
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_179;
        }
        obj1 = (ResolveInfo)iterator.next();
        if (context1.checkPermission("com.google.android.c2dm.permission.RECEIVE", ((ResolveInfo) (obj1)).serviceInfo.packageName) != 0)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        ApplicationInfo applicationinfo = context1.getApplicationInfo(((ResolveInfo) (obj1)).serviceInfo.packageName, 0);
        Log.w("InstanceID/Rpc", (new StringBuilder("Found ")).append(applicationinfo.uid).toString());
        zX = applicationinfo.uid;
        obj1 = ((ResolveInfo) (obj1)).serviceInfo.packageName;
        zV = ((String) (obj1));
        return ((String) (obj1));
        Log.w("InstanceID/Rpc", (new StringBuilder("Possible malicious package ")).append(((ResolveInfo) (obj1)).serviceInfo.packageName).append(" declares com.google.android.c2dm.intent.REGISTER").append(" without permission").toString());
        continue; /* Loop/switch isn't completed */
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        Object obj;
        try
        {
            obj = context1.getApplicationInfo("com.google.android.gms", 0);
            zV = ((ApplicationInfo) (obj)).packageName;
            zX = ((ApplicationInfo) (obj)).uid;
            obj = zV;
        }
        // Misplaced declaration of an exception variable
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            try
            {
                context1 = context1.getApplicationInfo("com.google.android.gsf", 0);
                zV = ((ApplicationInfo) (context1)).packageName;
                zX = ((ApplicationInfo) (context1)).uid;
                context1 = zV;
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
            return context1;
        }
        return ((String) (obj));
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1;
        namenotfoundexception1;
        if (true) goto _L2; else goto _L1
_L1:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
    }

    private static transient String _mth02CA(KeyPair keypair, String as[])
    {
        try
        {
            as = TextUtils.join("\n", as).getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (KeyPair keypair)
        {
            Log.e("InstanceID/Rpc", "Unable to encode string", keypair);
            return null;
        }
        java.security.PrivateKey privatekey = keypair.getPrivate();
        if (privatekey instanceof RSAPrivateKey)
        {
            keypair = "SHA256withRSA";
        } else
        {
            keypair = "SHA256withECDSA";
        }
        try
        {
            keypair = Signature.getInstance(keypair);
            keypair.initSign(privatekey);
            keypair.update(as);
            keypair = bj._mth02BB(keypair.sign());
        }
        // Misplaced declaration of an exception variable
        catch (KeyPair keypair)
        {
            Log.e("InstanceID/Rpc", "Unable to sign registration request", keypair);
            return null;
        }
        return keypair;
    }

    private void _mth02CB(String s, Object obj)
    {
        Class class1 = getClass();
        class1;
        JVM INSTR monitorenter ;
        Object obj1 = zZ.get(s);
        zZ.put(s, obj);
        _mth141D(obj1, obj);
        class1;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void _mth02CE(Intent intent)
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

    static String _mth02CF(Intent intent)
    {
        if (intent == null)
        {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String s1 = intent.getStringExtra("registration_id");
        String s = s1;
        if (s1 == null)
        {
            s = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0L);
        if (s == null)
        {
            s = intent.getStringExtra("error");
            if (s != null)
            {
                throw new IOException(s);
            } else
            {
                Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected response from GCM ")).append(intent.getExtras()).toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else
        {
            return s;
        }
    }

    private void _mth02EE(Object obj)
    {
        Class class1 = getClass();
        class1;
        JVM INSTR monitorenter ;
        Object obj1;
        for (Iterator iterator = zZ.keySet().iterator(); iterator.hasNext(); _mth141D(obj1, obj))
        {
            String s = (String)iterator.next();
            obj1 = zZ.get(s);
            zZ.put(s, obj);
        }

        class1;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    private void _mth141D(Intent intent)
    {
        String s1 = intent.getStringExtra("error");
        if (s1 == null)
        {
            Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected response, no error or registration id ")).append(intent.getExtras()).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            Log.d("InstanceID/Rpc", (new StringBuilder("Received InstanceID error ")).append(s1).toString());
        }
        String s = null;
        Object obj1 = null;
        Object obj = s1;
        if (s1.startsWith("|"))
        {
            obj = s1.split("\\|");
            if (!"ID".equals(obj[1]))
            {
                Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected structured response ")).append(s1).toString());
            }
            if (obj.length > 2)
            {
                obj1 = obj[2];
                String s2 = obj[3];
                obj = s2;
                s = obj1;
                if (s2.startsWith(":"))
                {
                    obj = s2.substring(1);
                    s = obj1;
                }
            } else
            {
                obj = "UNKNOWN";
                s = obj1;
            }
            intent.putExtra("error", ((String) (obj)));
        }
        if (s == null)
        {
            _mth02EE(obj);
        } else
        {
            _mth02CB(s, obj);
        }
        long l = intent.getLongExtra("Retry-After", 0L);
        if (l > 0L)
        {
            Ad = SystemClock.elapsedRealtime();
            Af = (int)l * 1000;
            Ag = SystemClock.elapsedRealtime() + (long)Af;
            Log.w("InstanceID/Rpc", (new StringBuilder("Explicit request from server to backoff: ")).append(Af).toString());
            return;
        }
        if (("SERVICE_NOT_AVAILABLE".equals(obj) || "AUTHENTICATION_FAILED".equals(obj)) && "com.google.android.gsf".equals(zV))
        {
            Ae = Ae + 1;
            if (Ae >= 3)
            {
                if (Ae == 3)
                {
                    Af = (new Random()).nextInt(1000) + 1000;
                }
                Af = Af << 1;
                Ag = SystemClock.elapsedRealtime() + (long)Af;
                Log.w("InstanceID/Rpc", (new StringBuilder("Backoff due to ")).append(((String) (obj))).append(" for ").append(Af).toString());
            }
        }
    }

    private static void _mth141D(Object obj, Object obj1)
    {
        if (obj instanceof ConditionVariable)
        {
            ((ConditionVariable)obj).open();
        }
        if (obj instanceof Messenger)
        {
            obj = (Messenger)obj;
            Message message = Message.obtain();
            message.obj = obj1;
            try
            {
                ((Messenger) (obj)).send(message);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.w("InstanceID/Rpc", (new StringBuilder("Failed to send response ")).append(obj).toString());
            }
        }
    }

    public static String _mth1E5F()
    {
        o/bp;
        JVM INSTR monitorenter ;
        String s;
        int i = zY;
        zY = i + 1;
        s = Integer.toString(i);
        o/bp;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    final void _mth02BB(Intent intent)
    {
        if (intent == null)
        {
            if (Log.isLoggable("InstanceID/Rpc", 3))
            {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
            }
            return;
        }
        Object obj = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(obj) && !"com.google.android.gms.iid.InstanceID".equals(obj))
        {
            if (Log.isLoggable("InstanceID/Rpc", 3))
            {
                Log.d("InstanceID/Rpc", (new StringBuilder("Unexpected response ")).append(intent.getAction()).toString());
            }
            return;
        }
        String s = intent.getStringExtra("registration_id");
        obj = s;
        if (s == null)
        {
            obj = intent.getStringExtra("unregistered");
        }
        if (obj == null)
        {
            _mth141D(intent);
            return;
        }
        Ac = SystemClock.elapsedRealtime();
        Ag = 0L;
        Ae = 0;
        Af = 0;
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            Log.d("InstanceID/Rpc", (new StringBuilder("AppIDResponse: ")).append(((String) (obj))).append(" ").append(intent.getExtras()).toString());
        }
        s = null;
        if (((String) (obj)).startsWith("|"))
        {
            String as[] = ((String) (obj)).split("\\|");
            if (!"ID".equals(as[1]))
            {
                Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected structured response ")).append(((String) (obj))).toString());
            }
            s = as[2];
            if (as.length > 4)
            {
                if ("SYNC".equals(as[3]))
                {
                    bk._mth02B3(context);
                } else
                if ("RST".equals(as[3]))
                {
                    obj = context;
                    bj.FF70(context);
                    bk._mth02CA(((Context) (obj)), bj._mth1D3B());
                    intent.removeExtra("registration_id");
                    _mth02CB(s, intent);
                    return;
                }
            }
            String s1 = as[as.length - 1];
            obj = s1;
            if (s1.startsWith(":"))
            {
                obj = s1.substring(1);
            }
            intent.putExtra("registration_id", ((String) (obj)));
        }
        if (s == null)
        {
            _mth02EE(intent);
            return;
        } else
        {
            _mth02CB(s, intent);
            return;
        }
    }

    Intent _mth02CA(Bundle bundle, KeyPair keypair)
    {
        String s;
        ConditionVariable conditionvariable;
        conditionvariable = new ConditionVariable();
        s = _mth1E5F();
        Object obj = getClass();
        obj;
        JVM INSTR monitorenter ;
        zZ.put(s, conditionvariable);
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        bundle;
        throw bundle;
_L1:
        boolean flag;
        long l = SystemClock.elapsedRealtime();
        if (Ag != 0L && l <= Ag)
        {
            Log.w("InstanceID/Rpc", (new StringBuilder("Backoff mode, next request attempt: ")).append(Ag - l).append(" interval: ").append(Af).toString());
            throw new IOException("RETRY_LATER");
        }
        if (zzaCA == null)
        {
            _mth02B4(context);
            zzaCA = new Messenger(new bq(this, Looper.getMainLooper()));
        }
        if (zV == null)
        {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
        Ac = SystemClock.elapsedRealtime();
        obj = new Intent("com.google.android.c2dm.intent.REGISTER");
        ((Intent) (obj)).setPackage(zV);
        bundle.putString("gmsv", Integer.toString(GoogleCloudMessaging.zzaB(context)));
        bundle.putString("osv", Integer.toString(android.os.Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(bj.FE7A(context)));
        bundle.putString("cliv", "1");
        bundle.putString("appid", bj._mth02CA(keypair));
        String s1 = bj._mth02BB(keypair.getPublic().getEncoded());
        bundle.putString("pub2", s1);
        bundle.putString("sig", _mth02CA(keypair, new String[] {
            context.getPackageName(), s1
        }));
        ((Intent) (obj)).putExtras(bundle);
        _mth02CE(((Intent) (obj)));
        Ac = SystemClock.elapsedRealtime();
        ((Intent) (obj)).putExtra("kid", (new StringBuilder("|ID|")).append(s).append("|").toString());
        ((Intent) (obj)).putExtra("X-kid", (new StringBuilder("|ID|")).append(s).append("|").toString());
        flag = "com.google.android.gsf".equals(zV);
        bundle = ((Intent) (obj)).getStringExtra("useGsf");
        if (bundle != null)
        {
            flag = "1".equals(bundle);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            Log.d("InstanceID/Rpc", (new StringBuilder("Sending ")).append(((Intent) (obj)).getExtras()).toString());
        }
        if (Aa == null) goto _L3; else goto _L2
_L2:
        ((Intent) (obj)).putExtra("google.messenger", zzaCA);
        bundle = Message.obtain();
        bundle.obj = obj;
        Aa.send(bundle);
          goto _L4
_L11:
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
        }
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        bundle = new Intent("com.google.android.gms.iid.InstanceID");
        bundle.setPackage(context.getPackageName());
        bundle.putExtra("GSF", ((android.os.Parcelable) (obj)));
        context.startService(bundle);
          goto _L4
_L6:
        ((Intent) (obj)).putExtra("google.messenger", zzaCA);
        ((Intent) (obj)).putExtra("messenger2", "1");
        if (Ab == null) goto _L8; else goto _L7
_L7:
        bundle = Message.obtain();
        bundle.obj = obj;
        keypair = Ab;
        if (((MessengerCompat) (keypair)).zS == null) goto _L10; else goto _L9
_L9:
        ((MessengerCompat) (keypair)).zS.send(bundle);
          goto _L4
_L10:
        ((MessengerCompat) (keypair)).zT.send(bundle);
          goto _L4
_L12:
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
        }
_L8:
        context.startService(((Intent) (obj)));
_L4:
        conditionvariable.block(30000L);
        bundle = getClass();
        bundle;
        JVM INSTR monitorenter ;
        keypair = ((KeyPair) (zZ.remove(s)));
        if (!(keypair instanceof Intent))
        {
            break MISSING_BLOCK_LABEL_736;
        }
        keypair = (Intent)keypair;
        bundle;
        JVM INSTR monitorexit ;
        return keypair;
        if (!(keypair instanceof String))
        {
            break MISSING_BLOCK_LABEL_755;
        }
        throw new IOException((String)keypair);
        Log.w("InstanceID/Rpc", (new StringBuilder("No response ")).append(keypair).toString());
        throw new IOException("TIMEOUT");
        keypair;
        bundle;
        JVM INSTR monitorexit ;
        throw keypair;
        bundle;
          goto _L11
        bundle;
          goto _L12
    }

}
