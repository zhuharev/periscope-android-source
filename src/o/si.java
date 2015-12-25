// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import org.json.JSONObject;

// Referenced classes of package o:
//            sj, rs, rz, ra, 
//            rl, ri, se, rr

public final class si
{
    public static final class if extends Enum
    {

        public static final if Sc;
        public static final if Sd;
        public static final if Se;
        public static final if Sf;
        public static final if Sg;
        public static final if Sh;
        public static final if Si;
        private static final if Sk[];
        public final int Sj;

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/si$if, s);
        }

        public static if[] values()
        {
            return (if[])Sk.clone();
        }

        static 
        {
            Sc = new if("WIFI_MAC_ADDRESS", 0, 1);
            Sd = new if("BLUETOOTH_MAC_ADDRESS", 1, 2);
            Se = new if("FONT_TOKEN", 2, 53);
            Sf = new if("ANDROID_ID", 3, 100);
            Sg = new if("ANDROID_DEVICE_ID", 4, 101);
            Sh = new if("ANDROID_SERIAL", 5, 102);
            Si = new if("ANDROID_ADVERTISING_ID", 6, 103);
            Sk = (new if[] {
                Sc, Sd, Se, Sf, Sg, Sh, Si
            });
        }

        private if(String s, int i, int j)
        {
            super(s, i);
            Sj = j;
        }
    }


    private static final Pattern RS = Pattern.compile("[^\\p{Alnum}]");
    private static final String RT = Pattern.quote("/");
    public final String QR;
    private final ReentrantLock RU = new ReentrantLock();
    public final sj RV = new sj();
    public final boolean RW;
    public final boolean RX;
    private final String RY;
    private rs RZ;
    private rr Sa;
    private boolean Sb;
    public final Context appContext;
    private final Collection sr;

    public si(Context context, String s, String s1, Collection collection)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null)
        {
            throw new IllegalArgumentException("kits must not be null");
        }
        appContext = context;
        QR = s;
        RY = s1;
        sr = collection;
        RZ = new rs(context);
        RW = rz._mth02CA(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!RW)
        {
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Device ID collection disabled for ")).append(context.getPackageName()).toString());
        }
        RX = rz._mth02CA(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!RX)
        {
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("User information collection disabled for ")).append(context.getPackageName()).toString());
        }
    }

    private String getSerialNumber()
    {
        if (!RW || android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        String s = (String)android/os/Build.getField("SERIAL").get(null);
        if (s == null)
        {
            return null;
        }
        s = RS.matcher(s).replaceAll("").toLowerCase(Locale.US);
        return s;
        Exception exception;
        exception;
        ra._mth0454()._mth02CB("Fabric", "Could not retrieve android.os.Build.SERIAL value", exception);
        return null;
    }

    private String _mth02CA(SharedPreferences sharedpreferences)
    {
        RU.lock();
        String s1 = sharedpreferences.getString("crashlytics.installation.id", null);
        String s;
        s = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        s = UUID.randomUUID().toString();
        if (s == null)
        {
            s = null;
            break MISSING_BLOCK_LABEL_58;
        }
        s = RS.matcher(s).replaceAll("").toLowerCase(Locale.US);
        sharedpreferences.edit().putString("crashlytics.installation.id", s).commit();
        RU.unlock();
        return s;
        sharedpreferences;
        RU.unlock();
        throw sharedpreferences;
    }

    private void _mth02CA(JSONObject jsonobject)
    {
        for (Iterator iterator = _mth0EB2().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                jsonobject.put(((if)entry.getKey()).name().toLowerCase(Locale.US), entry.getValue());
            }
            catch (Exception exception)
            {
                ra._mth0454()._mth02CB("Fabric", (new StringBuilder("Could not write value to JSON: ")).append(((if)entry.getKey()).name()).toString(), exception);
            }
        }

    }

    private String _mth1433()
    {
        Object obj = null;
        String s = obj;
        if (RW)
        {
            String s1 = android.provider.Settings.Secure.getString(appContext.getContentResolver(), "android_id");
            s = obj;
            if (!"9774d56d682e549c".equals(s1))
            {
                if (s1 == null)
                {
                    return null;
                }
                s = RS.matcher(s1).replaceAll("").toLowerCase(Locale.US);
            }
        }
        return s;
    }

    private String _mth1438()
    {
        if (RW)
        {
            boolean flag;
            if (appContext.checkCallingPermission("android.permission.READ_PHONE_STATE") == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Object obj = (TelephonyManager)appContext.getSystemService("phone");
                if (obj != null)
                {
                    obj = ((TelephonyManager) (obj)).getDeviceId();
                    if (obj == null)
                    {
                        return null;
                    } else
                    {
                        return RS.matcher(((CharSequence) (obj))).replaceAll("").toLowerCase(Locale.US);
                    }
                }
            }
        }
        return null;
    }

    private String _mth1489()
    {
        if (RW)
        {
            boolean flag;
            if (appContext.checkCallingPermission("android.permission.ACCESS_WIFI_STATE") == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Object obj = (WifiManager)appContext.getSystemService("wifi");
                if (obj != null)
                {
                    obj = ((WifiManager) (obj)).getConnectionInfo();
                    if (obj != null)
                    {
                        obj = ((WifiInfo) (obj)).getMacAddress();
                        if (obj == null)
                        {
                            return null;
                        } else
                        {
                            return RS.matcher(((CharSequence) (obj))).replaceAll("").toLowerCase(Locale.US);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String _mth1D4C(String s)
    {
        return s.replaceAll(RT, "");
    }

    public final String _mth02C9(String s, String s1)
    {
        try
        {
            s1 = s1.replaceAll("\\.", (new StringBuilder(new String(new char[] {
                's', 'l', 'c'
            }))).reverse().toString());
            s = rz._mth02CE(1, rz._mth1424((new StringBuilder()).append(s).append(s1).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ra._mth0454()._mth02CB("Fabric", "Could not create cipher to encrypt headers.", s);
            return "";
        }
        s1 = new JSONObject();
        try
        {
            s1.put("APPLICATION_INSTALLATION_UUID".toLowerCase(Locale.US), _mth0E22());
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Fabric", "Could not write application id to JSON", exception);
        }
        _mth02CA(s1);
        try
        {
            s1.put("os_version", String.format(Locale.US, "%s/%s", new Object[] {
                android.os.Build.VERSION.RELEASE.replaceAll(RT, ""), android.os.Build.VERSION.INCREMENTAL.replaceAll(RT, "")
            }));
        }
        catch (Exception exception1)
        {
            ra._mth0454()._mth02CB("Fabric", "Could not write OS version to JSON", exception1);
        }
        try
        {
            s1.put("model", String.format(Locale.US, "%s/%s", new Object[] {
                Build.MANUFACTURER.replaceAll(RT, ""), Build.MODEL.replaceAll(RT, "")
            }));
        }
        catch (Exception exception2)
        {
            ra._mth0454()._mth02CB("Fabric", "Could not write model to JSON", exception2);
        }
        if (s1.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        s = rz._mth1FBE(s.doFinal(s1.toString().getBytes()));
        return s;
        s;
        ra._mth0454()._mth02CB("Fabric", "Could not encrypt IDs", s);
        return "";
    }

    public final rr _mth0646()
    {
        this;
        JVM INSTR monitorenter ;
        rr rr1;
        if (!Sb)
        {
            Sa = RZ._mth0646();
            Sb = true;
        }
        rr1 = Sa;
        this;
        JVM INSTR monitorexit ;
        return rr1;
        Exception exception;
        exception;
        throw exception;
    }

    public final String _mth0E22()
    {
        String s1 = RY;
        String s = s1;
        if (s1 == null)
        {
            SharedPreferences sharedpreferences = rz._mth1423(appContext);
            String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
            s = s2;
            if (s2 == null)
            {
                s = _mth02CA(sharedpreferences);
            }
        }
        return s;
    }

    public final String _mth0E30()
    {
        String s = "";
        if (RW)
        {
            String s1 = _mth1433();
            s = s1;
            if (s1 == null)
            {
                SharedPreferences sharedpreferences = rz._mth1423(appContext);
                String s2 = sharedpreferences.getString("crashlytics.installation.id", null);
                s = s2;
                if (s2 == null)
                {
                    s = _mth02CA(sharedpreferences);
                }
            }
        }
        return s;
    }

    public final Map _mth0EB2()
    {
        HashMap hashmap = new HashMap();
        for (Iterator iterator = sr.iterator(); iterator.hasNext();)
        {
            Object obj1 = (ri)iterator.next();
            if (obj1 instanceof se)
            {
                obj1 = ((se)obj1)._mth14F0().entrySet().iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    Object obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
                    if if1 = (if)((java.util.Map.Entry) (obj2)).getKey();
                    obj2 = (String)((java.util.Map.Entry) (obj2)).getValue();
                    if (obj2 != null)
                    {
                        hashmap.put(if1, obj2);
                    }
                }
            }
        }

        Object obj = if.Sf;
        String s = _mth1433();
        if (s != null)
        {
            hashmap.put(obj, s);
        }
        obj = if.Sg;
        s = _mth1438();
        if (s != null)
        {
            hashmap.put(obj, s);
        }
        obj = if.Sh;
        s = getSerialNumber();
        if (s != null)
        {
            hashmap.put(obj, s);
        }
        obj = if.Sc;
        s = _mth1489();
        if (s != null)
        {
            hashmap.put(obj, s);
        }
        obj = if.Sd;
        s = _mth148B();
        if (s != null)
        {
            hashmap.put(obj, s);
        }
        if if2 = if.Si;
        s = null;
        obj = s;
        if (RW)
        {
            rr rr1 = _mth0646();
            obj = s;
            if (rr1 != null)
            {
                obj = rr1.advertisingId;
            }
        }
        if (obj != null)
        {
            hashmap.put(if2, obj);
        }
        return Collections.unmodifiableMap(hashmap);
    }

    public final String _mth148B()
    {
        if (!RW)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        boolean flag;
        if (appContext.checkCallingPermission("android.permission.BLUETOOTH") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Object obj = BluetoothAdapter.getDefaultAdapter();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = ((BluetoothAdapter) (obj)).getAddress();
        if (obj != null)
        {
            try
            {
                RS.matcher(((CharSequence) (obj))).replaceAll("").toLowerCase(Locale.US);
            }
            catch (Exception exception)
            {
                ra._mth0454()._mth02CB("Fabric", "Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", exception);
            }
        }
        return null;
    }

}
