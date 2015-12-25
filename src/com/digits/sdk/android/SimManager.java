// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
import o.rz;

class SimManager
{

    private final boolean canReadPhoneState;
    private final TelephonyManager telephonyManager;

    protected SimManager(TelephonyManager telephonymanager, boolean flag)
    {
        telephonyManager = telephonymanager;
        canReadPhoneState = flag;
    }

    public static SimManager createSimManager(Context context)
    {
        return new SimManager((TelephonyManager)context.getSystemService("phone"), rz._mth02BE(context, "android.permission.READ_PHONE_STATE"));
    }

    private boolean isCdma()
    {
        return telephonyManager.getPhoneType() == 2;
    }

    private boolean isIso2(String s)
    {
        return s != null && s.length() == 2;
    }

    private String normalizeNumber(String s)
    {
label0:
        do
        {
            if (TextUtils.isEmpty(s))
            {
                return "";
            }
            StringBuilder stringbuilder = new StringBuilder();
            int j = s.length();
            for (int i = 0; i < j; i++)
            {
                char c = s.charAt(i);
                int k = Character.digit(c, 10);
                if (k != -1)
                {
                    stringbuilder.append(k);
                    continue;
                }
                if (i == 0 && c == '+')
                {
                    stringbuilder.append(c);
                    continue;
                }
                if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                {
                    continue;
                }
                s = PhoneNumberUtils.convertKeypadLettersToDigits(s);
                continue label0;
            }

            return stringbuilder.toString();
        } while (true);
    }

    protected String getCountryIso()
    {
        if (telephonyManager != null)
        {
            String s = telephonyManager.getSimCountryIso();
            if (isIso2(s))
            {
                return s.toUpperCase(Locale.getDefault());
            }
            if (!isCdma())
            {
                String s1 = telephonyManager.getNetworkCountryIso();
                if (isIso2(s1))
                {
                    return s1.toUpperCase(Locale.getDefault());
                }
            }
        }
        return "";
    }

    protected String getRawPhoneNumber()
    {
        if (telephonyManager == null || !canReadPhoneState)
        {
            return "";
        } else
        {
            return normalizeNumber(telephonyManager.getLine1Number());
        }
    }
}
