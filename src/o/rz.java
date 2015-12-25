// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package o:
//            sa, ra, rl, _cls1EF2

public final class rz
{
    static final class if extends Enum
    {

        private static if RA;
        private static if RB;
        private static if RC;
        private static if RD;
        private static final HashMap RE;
        private static final if RF[];
        private static if Ru;
        private static if Rv;
        private static if Rw;
        private static if Rx;
        private static if Ry;
        private static if Rz;

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/rz$if, s);
        }

        public static if[] values()
        {
            return (if[])RF.clone();
        }

        static if _mth0E1A()
        {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                ra._mth0454()._mth02BE("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return RB;
            }
            obj = ((String) (obj)).toLowerCase(Locale.US);
            if if1 = (if)RE.get(obj);
            obj = if1;
            if (if1 == null)
            {
                obj = RB;
            }
            return ((if) (obj));
        }

        static 
        {
            Ru = new if("X86_32", 0);
            Rv = new if("X86_64", 1);
            Rw = new if("ARM_UNKNOWN", 2);
            Rx = new if("PPC", 3);
            Ry = new if("PPC64", 4);
            Rz = new if("ARMV6", 5);
            RA = new if("ARMV7", 6);
            RB = new if("UNKNOWN", 7);
            RC = new if("ARMV7S", 8);
            RD = new if("ARM64", 9);
            RF = (new if[] {
                Ru, Rv, Rw, Rx, Ry, Rz, RA, RB, RC, RD
            });
            HashMap hashmap = new HashMap(4);
            RE = hashmap;
            hashmap.put("armeabi-v7a", RA);
            RE.put("armeabi", Rz);
            RE.put("x86", Ru);
        }

        private if(String s, int i)
        {
            super(s, i);
        }
    }


    private static Boolean Rq = null;
    private static final char Rr[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static long Rs = -1L;
    public static final sa Rt = new sa();

    public rz()
    {
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Closeable closeable)
            {
                throw closeable;
            }
            // Misplaced declaration of an exception variable
            catch (Closeable closeable)
            {
                return;
            }
        } else
        {
            return;
        }
    }

    public static void _mth02BD(Context context, String s)
    {
        if (Rq == null)
        {
            Rq = Boolean.valueOf(_mth02CA(context, "com.crashlytics.Trace", false));
        }
        if (Rq.booleanValue())
        {
            ra._mth0454()._mth02BE("Fabric", s);
        }
    }

    public static boolean _mth02BE(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public static void _mth02BF(Context context, int i)
    {
        if (context instanceof Activity)
        {
            context = (Activity)context;
            if (context != null)
            {
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    context.finishAffinity();
                    return;
                }
                context.setResult(200);
                context.finish();
            }
        }
    }

    public static void _mth02C8(String s, String s1)
    {
        if (ra._mth04F5())
        {
            throw new IllegalStateException(s1);
        } else
        {
            ra._mth0454()._mth02CE(s, s1);
            return;
        }
    }

    public static int _mth02CA(Context context, boolean flag)
    {
        float f = _mth144A(context);
        if (!flag)
        {
            return 1;
        }
        if (flag && (double)f >= 99D)
        {
            return 3;
        }
        return !flag || (double)f >= 99D ? 0 : 2;
    }

    public static android.app.ActivityManager.RunningAppProcessInfo _mth02CA(String s, Context context)
    {
label0:
        {
            context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
            if (context == null)
            {
                break label0;
            }
            context = context.iterator();
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!context.hasNext())
                {
                    break label0;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            } while (!runningappprocessinfo.processName.equals(s));
            return runningappprocessinfo;
        }
        return null;
    }

    private static String _mth02CA(File file, String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        obj1 = null;
        obj = null;
        BufferedReader bufferedreader = new BufferedReader(new FileReader(file), 1024);
_L2:
        obj = bufferedreader;
        obj1 = bufferedreader;
        String s1 = bufferedreader.readLine();
        obj = obj2;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = bufferedreader;
        obj1 = bufferedreader;
        String as[] = Pattern.compile("\\s*:\\s*").split(s1, 2);
        obj = bufferedreader;
        obj1 = bufferedreader;
        if (as.length <= 1) goto _L2; else goto _L1
_L1:
        obj = bufferedreader;
        obj1 = bufferedreader;
        if (!as[0].equals(s)) goto _L2; else goto _L3
_L3:
        obj = as[1];
        if (bufferedreader == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        bufferedreader.close();
        return ((String) (obj));
        file;
        ra._mth0454()._mth02CB("Fabric", "Failed to close system file reader.", file);
        return ((String) (obj));
        s;
        obj1 = obj;
        ra._mth0454()._mth02CB("Fabric", (new StringBuilder("Error parsing ")).append(file).toString(), s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        ((Closeable) (obj)).close();
        return null;
        file;
        ra._mth0454()._mth02CB("Fabric", "Failed to close system file reader.", file);
        return null;
        file;
        if (obj1 != null)
        {
            try
            {
                ((Closeable) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ra._mth0454()._mth02CB("Fabric", "Failed to close system file reader.", s);
            }
        }
        throw file;
        return null;
    }

    public static String _mth02CA(FileInputStream fileinputstream)
    {
        fileinputstream = (new Scanner(fileinputstream)).useDelimiter("\\A");
        if (fileinputstream.hasNext())
        {
            return fileinputstream.next();
        } else
        {
            return "";
        }
    }

    private static String _mth02CA(byte abyte0[], String s)
    {
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ra._mth0454()._mth02CB("Fabric", (new StringBuilder("Could not create hashing algorithm: ")).append(s).append(", returning empty string.").toString(), abyte0);
            return "";
        }
        messagedigest.update(abyte0);
        return _mth1FBE(messagedigest.digest());
    }

    public static void _mth02CA(Activity activity, EditText edittext)
    {
        activity = (InputMethodManager)activity.getSystemService("input_method");
        if (activity != null)
        {
            activity.showSoftInputFromInputMethod(edittext.getWindowToken(), 0);
        }
    }

    public static void _mth02CA(Context context, TextView textview)
    {
        context = (InputMethodManager)context.getSystemService("input_method");
        if (context != null)
        {
            context.hideSoftInputFromWindow(textview.getWindowToken(), 0);
        }
    }

    public static void _mth02CA(Closeable closeable, String s)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Closeable closeable)
            {
                ra._mth0454()._mth02CB("Fabric", s, closeable);
            }
        }
    }

    public static void _mth02CA(FileInputStream fileinputstream, OutputStream outputstream, byte abyte0[])
    {
        do
        {
            int i = fileinputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public static boolean _mth02CA(Context context, String s, boolean flag)
    {
        if (context != null)
        {
            Resources resources = context.getResources();
            if (resources != null)
            {
                Resources resources1 = context.getResources();
                int i = context.getApplicationContext().getApplicationInfo().icon;
                String s1;
                if (i > 0)
                {
                    s1 = context.getResources().getResourcePackageName(i);
                } else
                {
                    s1 = context.getPackageName();
                }
                i = resources1.getIdentifier(s, "bool", s1);
                if (i > 0)
                {
                    return resources.getBoolean(i);
                }
                resources = context.getResources();
                i = context.getApplicationContext().getApplicationInfo().icon;
                if (i > 0)
                {
                    s1 = context.getResources().getResourcePackageName(i);
                } else
                {
                    s1 = context.getPackageName();
                }
                i = resources.getIdentifier(s, "string", s1);
                if (i > 0)
                {
                    return Boolean.parseBoolean(context.getString(i));
                }
            }
        }
        return flag;
    }

    public static int _mth02CB(Context context, String s, String s1)
    {
        Resources resources = context.getResources();
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0)
        {
            context = context.getResources().getResourcePackageName(i);
        } else
        {
            context = context.getPackageName();
        }
        return resources.getIdentifier(s, s1, context);
    }

    public static void _mth02CB(Activity activity, int i)
    {
        if (activity == null)
        {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            activity.finishAffinity();
            return;
        } else
        {
            activity.setResult(i);
            activity.finish();
            return;
        }
    }

    public static void _mth02CB(_cls1EF2 _pcls1ef2, String s)
    {
        if (_pcls1ef2 != null)
        {
            try
            {
                _pcls1ef2.flush();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (_cls1EF2 _pcls1ef2)
            {
                ra._mth0454()._mth02CB("Fabric", s, _pcls1ef2);
            }
        }
    }

    private static String _mth02CE(InputStream inputstream)
    {
        MessageDigest messagedigest;
        byte abyte0[];
        messagedigest = MessageDigest.getInstance("SHA-1");
        abyte0 = new byte[1024];
_L1:
        int i = inputstream.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                ra._mth0454()._mth02CB("Fabric", "Could not calculate hash for app icon.", inputstream);
                return "";
            }
        }
          goto _L1
        inputstream = _mth1FBE(messagedigest.digest());
        return inputstream;
    }

    public static Cipher _mth02CE(int i, String s)
    {
        if (s.length() < 32)
        {
            throw new InvalidKeyException("Key must be at least 32 bytes.");
        }
        s = new SecretKeySpec(s.getBytes(), 0, 32, "AES/ECB/PKCS7Padding");
        Cipher cipher;
        try
        {
            cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ra._mth0454()._mth02CB("Fabric", "Could not create Cipher for AES/ECB/PKCS7Padding - should never happen.", s);
            throw new RuntimeException(s);
        }
        cipher.init(1, s);
        return cipher;
    }

    public static void _mth02CE(Context context, int i, String s)
    {
        if (Rq == null)
        {
            Rq = Boolean.valueOf(_mth02CA(context, "com.crashlytics.Trace", false));
        }
        if (Rq.booleanValue())
        {
            ra._mth0454()._mth02CB(4, "Fabric", s);
        }
    }

    public static transient String _mth02CF(String as[])
    {
        Object obj = new ArrayList();
        for (int i = 0; i <= 0; i++)
        {
            String s = as[0];
            if (s != null)
            {
                ((List) (obj)).add(s.replace("-", "").toLowerCase(Locale.US));
            }
        }

        Collections.sort(((List) (obj)));
        as = new StringBuilder();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); as.append((String)((Iterator) (obj)).next())) { }
        as = as.toString();
        if (as.length() > 0)
        {
            return _mth02CA(as.getBytes(), "SHA-1");
        } else
        {
            return null;
        }
    }

    public static void _mth037A(Context context, String s)
    {
        if (Rq == null)
        {
            Rq = Boolean.valueOf(_mth02CA(context, "com.crashlytics.Trace", false));
        }
        if (Rq.booleanValue())
        {
            ra._mth0454()._mth02CA("Fabric", s);
        }
    }

    public static int _mth0699()
    {
        return if._mth0E1A().ordinal();
    }

    public static long _mth093D()
    {
        o/rz;
        JVM INSTR monitorenter ;
        if (Rs != -1L)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        long l1 = 0L;
        String s = _mth02CA(new File("/proc/meminfo"), "MemTotal");
        long l = l1;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_211;
        }
        s = s.toUpperCase(Locale.US);
        if (s.endsWith("KB"))
        {
            l = Long.parseLong(s.split("KB")[0].trim()) * 1024L;
            break MISSING_BLOCK_LABEL_211;
        }
        if (s.endsWith("MB"))
        {
            l = Long.parseLong(s.split("MB")[0].trim()) * 0x100000L;
            break MISSING_BLOCK_LABEL_211;
        }
        if (s.endsWith("GB"))
        {
            l = Long.parseLong(s.split("GB")[0].trim()) * 0x40000000L;
            break MISSING_BLOCK_LABEL_211;
        }
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Unexpected meminfo format while computing RAM: ")).append(s).toString());
        l = l1;
        break MISSING_BLOCK_LABEL_211;
        NumberFormatException numberformatexception;
        numberformatexception;
        ra._mth0454()._mth02CB("Fabric", (new StringBuilder("Unexpected meminfo format while computing RAM: ")).append(s).toString(), numberformatexception);
        l = l1;
        Rs = l;
        l = Rs;
        o/rz;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public static String _mth141F(Context context)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        Object obj2 = context.getResources().openRawResource(context.getApplicationContext().getApplicationInfo().icon);
        context = ((Context) (obj2));
        obj = context;
        obj1 = context;
        obj2 = _mth02CE(((InputStream) (obj2)));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        obj = context;
        obj1 = context;
        int i = ((String) (obj2)).length();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_61;
        flag = false;
        if (flag)
        {
            obj = null;
        } else
        {
            obj = obj2;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        context.close();
        return ((String) (obj));
        context;
        ra._mth0454()._mth02CB("Fabric", "Failed to close icon input stream.", context);
        return ((String) (obj));
        context;
        obj1 = obj;
        ra._mth0454()._mth02CB("Fabric", "Could not calculate hash for app icon.", context);
        if (obj != null)
        {
            try
            {
                ((Closeable) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ra._mth0454()._mth02CB("Fabric", "Failed to close icon input stream.", context);
            }
        }
        break MISSING_BLOCK_LABEL_173;
        context;
        if (obj1 != null)
        {
            try
            {
                ((Closeable) (obj1)).close();
            }
            catch (IOException ioexception)
            {
                ra._mth0454()._mth02CB("Fabric", "Failed to close icon input stream.", ioexception);
            }
        }
        throw context;
        return null;
    }

    public static int _mth1421(Context context)
    {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static SharedPreferences _mth1423(Context context)
    {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String _mth1424(String s)
    {
        return _mth02CA(s.getBytes(), "SHA-1");
    }

    public static long _mth1429(Context context)
    {
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryinfo);
        return memoryinfo.availMem;
    }

    public static String _mth142A(Context context)
    {
        String s = null;
        int j = _mth02CB(context, "io.fabric.android.build_id", "string");
        int i = j;
        if (j == 0)
        {
            i = _mth02CB(context, "com.crashlytics.android.build_id", "string");
        }
        if (i != 0)
        {
            s = context.getResources().getString(i);
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Build ID is: ")).append(s).toString());
        }
        return s;
    }

    public static float _mth144A(Context context)
    {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = context.getIntExtra("level", -1);
        int j = context.getIntExtra("scale", -1);
        return (float)i / (float)j;
    }

    public static long _mth14A1(String s)
    {
        s = new StatFs(s);
        long l = s.getBlockSize();
        return l * (long)s.getBlockCount() - l * (long)s.getAvailableBlocks();
    }

    public static boolean _mth14A2(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean _mth14BD(Context context)
    {
        boolean flag;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean flag1;
            if (context != null && context.isConnectedOrConnecting())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return flag1;
        } else
        {
            return true;
        }
    }

    public static boolean _mth1540(Context context)
    {
        if (_mth1D55(context))
        {
            return false;
        }
        return ((SensorManager)context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static boolean _mth1D55(Context context)
    {
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || context == null;
    }

    public static boolean _mth1D63(Context context)
    {
        boolean flag = _mth1D55(context);
        context = Build.TAGS;
        if (!flag && context != null && context.contains("test-keys"))
        {
            return true;
        }
        if ((new File("/system/app/Superuser.apk")).exists())
        {
            return true;
        }
        context = new File("/system/xbin/su");
        return !flag && context.exists();
    }

    public static String _mth1FBE(Context context, String s)
    {
        int i = _mth02CB(context, s, "string");
        if (i > 0)
        {
            return context.getString(i);
        } else
        {
            return "";
        }
    }

    public static String _mth1FBE(byte abyte0[])
    {
        char ac[] = new char[abyte0.length << 1];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i << 1] = Rr[j >>> 4];
            ac[(i << 1) + 1] = Rr[j & 0xf];
        }

        return new String(ac);
    }

    public static int FB1D(Context context)
    {
        int j = 0;
        if (_mth1D55(context))
        {
            j = 1;
        }
        int i = j;
        if (_mth1D63(context))
        {
            i = j | 2;
        }
        boolean flag;
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k = i;
        if (flag)
        {
            k = i | 4;
        }
        return k;
    }

    public static boolean FB39(Context context)
    {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String FB4B(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("value must be zero or greater");
        } else
        {
            return String.format(Locale.US, "%1$10s", new Object[] {
                Integer.valueOf(i)
            }).replace(' ', '0');
        }
    }

    public static String FE72(int i)
    {
        switch (i)
        {
        case 7: // '\007'
            return "A";

        case 3: // '\003'
            return "D";

        case 6: // '\006'
            return "E";

        case 4: // '\004'
            return "I";

        case 2: // '\002'
            return "V";

        case 5: // '\005'
            return "W";
        }
        return "?";
    }

}
