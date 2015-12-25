// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;

// Referenced classes of package com.digits.sdk.vcard:
//            VCardUtils

public static class 
{

    public static String formatNumber(String s, int i)
    {
        s = new SpannableStringBuilder(s);
        PhoneNumberUtils.formatNumber(s, i);
        return s.toString();
    }

    public ()
    {
    }
}
