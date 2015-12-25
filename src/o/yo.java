// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            zp

public final class yo
{

    public static yq.if aVs = yq.if.valueOf("production");

    public yo()
    {
    }

    public static retrofit.RestAdapter.LogLevel getLogLevel()
    {
        byte byte0 = -1;
        switch ("none".hashCode())
        {
        case 3154575: 
            if ("none".equals("full"))
            {
                byte0 = 0;
            }
            break;

        case 93508654: 
            if ("none".equals("basic"))
            {
                byte0 = 1;
            }
            break;
        }
        switch (byte0)
        {
        case 0: // '\0'
            return retrofit.RestAdapter.LogLevel.FULL;

        case 1: // '\001'
            return retrofit.RestAdapter.LogLevel.BASIC;
        }
        return retrofit.RestAdapter.LogLevel.NONE;
    }

    public static boolean h()
    {
        return true;
    }

    public static boolean i()
    {
        return "release".equals("debug") || "release".equals("dev");
    }

    public static boolean j()
    {
        return "release".equals("beta");
    }

    public static boolean _mth02CA(Context context, zp zp1)
    {
        return _mth02CA(zp1) && PreferenceManager.getDefaultSharedPreferences(context).getBoolean("pref_show_block_counts", false);
    }

    public static boolean _mth02CA(zp zp1)
    {
        boolean flag;
        if ("release".equals("debug") || "release".equals("dev"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag || ("release".equals("alpha") || "release".equals("beta")) && zp1 != null && zp1.aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVN").get(null), false);
    }

}
