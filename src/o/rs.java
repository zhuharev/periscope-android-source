// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

// Referenced classes of package o:
//            up, rr, ra, rl, 
//            rt, ru, rw, rv

final class rs
{

    private final up Rk;
    private final Context context;

    public rs(Context context1)
    {
        context = context1.getApplicationContext();
        Rk = new up(context1, "TwitterAdvertisingInfoPreferences");
    }

    void _mth02CA(rr rr1)
    {
        boolean flag;
        if (rr1 != null && !TextUtils.isEmpty(rr1.advertisingId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            Rk._mth02CA(Rk.edit().putString("advertising_id", rr1.advertisingId).putBoolean("limit_ad_tracking_enabled", rr1.Rj));
            return;
        } else
        {
            Rk._mth02CA(Rk.edit().remove("advertising_id").remove("limit_ad_tracking_enabled"));
            return;
        }
    }

    public final rr _mth0646()
    {
        rr rr1 = new rr(Rk._mth1E97().getString("advertising_id", ""), Rk._mth1E97().getBoolean("limit_ad_tracking_enabled", false));
        boolean flag;
        if (rr1 != null && !TextUtils.isEmpty(rr1.advertisingId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ra._mth0454()._mth02BE("Fabric", "Using AdvertisingInfo from Preference Store");
            (new Thread(new rt(this, rr1))).start();
            return rr1;
        } else
        {
            rr rr2 = _mth066E();
            _mth02CA(rr2);
            return rr2;
        }
    }

    rr _mth066E()
    {
        rr rr1 = (new ru(context))._mth0646();
        boolean flag;
        if (rr1 != null && !TextUtils.isEmpty(rr1.advertisingId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            rr1 = (new rv(context))._mth0646();
            boolean flag1;
            if (rr1 != null && !TextUtils.isEmpty(rr1.advertisingId))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                ra._mth0454()._mth02BE("Fabric", "AdvertisingInfo not present");
                return rr1;
            } else
            {
                ra._mth0454()._mth02BE("Fabric", "Using AdvertisingInfo from Service Provider");
                return rr1;
            }
        } else
        {
            ra._mth0454()._mth02BE("Fabric", "Using AdvertisingInfo from Reflection Provider");
            return rr1;
        }
    }
}
