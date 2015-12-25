// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Referenced classes of package o:
//            rp, ra, rl

public final class _cls14DB
    implements rp
{

    public _cls14DB()
    {
    }

    private static String _mth02CA(ZipInputStream zipinputstream)
    {
        do
        {
            Object obj = zipinputstream.getNextEntry();
            if (obj != null)
            {
                obj = ((ZipEntry) (obj)).getName();
                if (((String) (obj)).startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="))
                {
                    return ((String) (obj)).substring(59, ((String) (obj)).length() - 1);
                }
            } else
            {
                return "";
            }
        } while (true);
    }

    private String _mth05D9(Context context)
    {
        Object obj;
        Context context1;
        Context context2;
        Context context3;
        String s;
        long l;
        l = System.nanoTime();
        s = "";
        context2 = null;
        context3 = null;
        obj = null;
        context1 = null;
        Object obj1 = new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir));
        context = ((Context) (obj1));
        context1 = context;
        context2 = context;
        context3 = context;
        obj = context;
        obj1 = _mth02CA(((ZipInputStream) (obj1)));
        obj = obj1;
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ra._mth0454()._mth02CB("Beta", "Failed to close the APK file", context);
            context = ((Context) (obj));
            break MISSING_BLOCK_LABEL_295;
        }
        context = ((Context) (obj));
        break MISSING_BLOCK_LABEL_295;
        context;
        obj = context1;
        ra._mth0454()._mth02CB("Beta", "Failed to find this app in the PackageManager", context);
        context = s;
        if (context1 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        try
        {
            context1.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ra._mth0454()._mth02CB("Beta", "Failed to close the APK file", context);
            context = s;
            break MISSING_BLOCK_LABEL_295;
        }
        context = s;
        break MISSING_BLOCK_LABEL_295;
        context;
        obj = context2;
        ra._mth0454()._mth02CB("Beta", "Failed to find the APK file", context);
        context = s;
        if (context2 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        try
        {
            context2.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ra._mth0454()._mth02CB("Beta", "Failed to close the APK file", context);
            context = s;
            break MISSING_BLOCK_LABEL_295;
        }
        context = s;
        break MISSING_BLOCK_LABEL_295;
        context;
        obj = context3;
        ra._mth0454()._mth02CB("Beta", "Failed to read the APK file", context);
        context = s;
        if (context3 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        try
        {
            context3.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ra._mth0454()._mth02CB("Beta", "Failed to close the APK file", context);
            context = s;
            break MISSING_BLOCK_LABEL_295;
        }
        context = s;
        break MISSING_BLOCK_LABEL_295;
        context;
        if (obj != null)
        {
            try
            {
                ((ZipInputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ra._mth0454()._mth02CB("Beta", "Failed to close the APK file", ioexception);
            }
        }
        throw context;
        double d = (double)(System.nanoTime() - l) / 1000000D;
        ra._mth0454()._mth02BE("Beta", (new StringBuilder("Beta device token load took ")).append(d).append("ms").toString());
        return context;
    }

    public final String _mth0674(Context context)
    {
        return _mth05D9(context);
    }
}
