// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;

// Referenced classes of package o:
//            ql, FF6A, aos, abt, 
//            abu

final class abs
{

    private final SharedPreferences aQC;
    private final Context mContext;
    private final ql mEventBus;

    public abs(Context context, ql ql1, SharedPreferences sharedpreferences)
    {
        mContext = context;
        mEventBus = ql1;
        aQC = sharedpreferences;
        mEventBus._mth02CA(this, false, 0);
    }

    public final String aC()
    {
        String s = aQC.getString("registration_id", "");
        if (s.isEmpty())
        {
            FF6A._mth02CB("GcmRegistrar", "Registration not found.");
            return "";
        }
        if (aQC.getInt("app_version", 0x80000000) != aos._mth0131(mContext))
        {
            FF6A._mth02CB("GcmRegistrar", "App version changed.");
            return "";
        } else
        {
            return s;
        }
    }

    public final void onEventMainThread(abt abt1)
    {
        abt1 = abt1.bcC;
        int i = aos._mth0131(mContext);
        aQC.edit().putString("registration_id", abt1).putInt("app_version", i).apply();
    }

    public final void onEventMainThread(abu abu)
    {
        aQC.edit().remove("registration_id").remove("app_version").apply();
    }
}
