// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Field;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            acr, aos, zp, _cls0993, 
//            aqc, acp

public final class acq
{

    private final Context mContext;
    private final zp mUserManager;

    public acq(acp acp, zp zp1)
    {
        mContext = acp.getApplicationContext();
        mUserManager = zp1;
    }

    private int aL()
    {
        Exception exception;
        int i;
        try
        {
            i = (new File("/sys/devices/system/cpu/")).listFiles(new acr(this)).length;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return 1;
        }
        return i;
    }

    private void _mth02CA(StringBuilder stringbuilder)
    {
        stringbuilder.append((new StringBuilder("\nDevice: ")).append(Build.DEVICE).toString());
        stringbuilder.append((new StringBuilder("\nModel: ")).append(Build.MODEL).toString());
        stringbuilder.append("\nSupported ABIs: ");
        String as[];
        int j;
        as = Build.SUPPORTED_ABIS;
        j = as.length;
        int i = 0;
_L2:
        String s;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[i];
        stringbuilder.append((new StringBuilder("\n")).append(s).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L4:
        stringbuilder.append("\nNo Supported ABIs");
_L1:
        stringbuilder.append((new StringBuilder("\nHardware: ")).append(Build.HARDWARE).toString());
        stringbuilder.append((new StringBuilder("\nBrand: ")).append(Build.BRAND).toString());
        stringbuilder.append((new StringBuilder("\nProduct: ")).append(Build.PRODUCT).toString());
        stringbuilder.append((new StringBuilder("\nManufacturer: ")).append(Build.MANUFACTURER).toString());
        stringbuilder.append((new StringBuilder("\nBoard: ")).append(Build.BOARD).toString());
        stringbuilder.append((new StringBuilder("\nCores: ")).append(aL()).append("\n").toString());
        stringbuilder.append((new StringBuilder("\nAndroid OS Version: ")).append(aos.dF()).toString());
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final String aK()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("\npackage: ").append(mContext.getPackageName());
        stringbuilder.append("\nversion: ").append(aos._mth0131(mContext));
        stringbuilder.append("\n");
        if (mUserManager.aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVP").get(null), false))
        {
            PsUser psuser = mUserManager.H();
            stringbuilder.append("\nusername: ").append(psuser.username);
            if (psuser.isVerified)
            {
                stringbuilder.append("\nVerified Twitter User");
            }
        } else
        {
            stringbuilder.append("\nuserId: <none -- logged out>");
        }
        stringbuilder.append("\n");
        _mth02CA(stringbuilder);
        stringbuilder.append("\n");
        int i = _cls0993._mth1D4E(mContext);
        stringbuilder.append((new StringBuilder("\nGoogle play services status: ")).append(_cls0993._mth02B5(i)).toString());
        stringbuilder.append("\n");
        Object obj = new StringBuilder("\nMaps supported: ");
        boolean flag;
        if (_cls0993._mth1D4E(mContext) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stringbuilder.append(((StringBuilder) (obj)).append(flag).toString());
        obj = new StringBuilder("\nMaps created successfully: ");
        if (!aqc.bzG)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stringbuilder.append(((StringBuilder) (obj)).append(flag).toString());
        stringbuilder.append("\n");
        obj = new DisplayMetrics();
        ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        stringbuilder.append("\nScreen Density: ");
        switch (((DisplayMetrics) (obj)).densityDpi)
        {
        case 120: // 'x'
            stringbuilder.append(" LDPI");
            break;

        case 160: 
            stringbuilder.append(" MDPI");
            break;

        case 240: 
            stringbuilder.append(" HDPI");
            break;

        case 213: 
            stringbuilder.append(" TVDPI");
            break;

        case 320: 
            stringbuilder.append(" XHDPI");
            break;

        case 480: 
            stringbuilder.append(" XXHDPI");
            break;

        default:
            stringbuilder.append((new StringBuilder(" UNKNOWN: ")).append(((DisplayMetrics) (obj)).densityDpi).toString());
            break;
        }
        stringbuilder.append((new StringBuilder("\nScreen Size: ")).append(((DisplayMetrics) (obj)).widthPixels).append("x").append(((DisplayMetrics) (obj)).heightPixels).toString());
        stringbuilder.append("\n");
        obj = (ActivityManager)mContext.getSystemService("activity");
        ((ActivityManager) (obj)).getMemoryInfo(new android.app.ActivityManager.MemoryInfo());
        i = ((ActivityManager) (obj)).getMemoryClass();
        stringbuilder.append((new StringBuilder("\nMemory Info: ")).append(i).append("MB").toString());
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder("\nVM: ")).append(System.getProperty("java.vm.name")).append(" ").append(System.getProperty("java.vm.version")).toString());
        return stringbuilder.toString();
    }
}
