// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;

// Referenced classes of package o:
//            ra, rl, rz

public final class rx
{

    public rx()
    {
    }

    private static String _mth1420(Context context)
    {
        String s = null;
        Object obj = null;
        Context context1 = s;
        Object obj1;
        try
        {
            obj1 = context.getPackageName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Caught non-fatal exception while retrieving apiKey: ")).append(context).toString());
            return context1;
        }
        context1 = s;
        obj1 = context.getPackageManager().getApplicationInfo(((String) (obj1)), 128).metaData;
        context1 = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        context1 = s;
        s = ((Bundle) (obj1)).getString("io.fabric.ApiKey");
        context = s;
        context1 = context;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        context1 = context;
        ra._mth0454()._mth02BE("Fabric", "Falling back to Crashlytics key lookup from Manifest");
        context1 = context;
        context = ((Bundle) (obj1)).getString("com.crashlytics.ApiKey");
        context1 = context;
        return context1;
    }

    public final String _mth06E5(Context context)
    {
        String s1 = _mth1420(context);
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = null;
            int j = rz._mth02CB(context, "io.fabric.ApiKey", "string");
            int i = j;
            if (j == 0)
            {
                ra._mth0454()._mth02BE("Fabric", "Falling back to Crashlytics key lookup from Strings");
                i = rz._mth02CB(context, "com.crashlytics.ApiKey", "string");
            }
            if (i != 0)
            {
                s = context.getResources().getString(i);
            }
        }
        if (TextUtils.isEmpty(s))
        {
            if (ra._mth04F5() || rz.FB39(context))
            {
                throw new IllegalArgumentException("Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
            }
            ra._mth0454()._mth02CA("Fabric", "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>");
        }
        return s;
    }
}
