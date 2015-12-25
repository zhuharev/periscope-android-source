// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import java.util.Locale;

// Referenced classes of package com.digits.sdk.android:
//            DigitsApiClient, Verification, DigitsClient

class llbackWrapper extends llbackWrapper
{

    final DigitsClient this$0;
    final String val$phoneNumber;
    final Verification val$verificationType;

    public void success(Result result)
    {
        ((DigitsApiClient)result.data).getDeviceService().register(val$phoneNumber, "third_party_confirmation_code", Boolean.valueOf(true), Locale.getDefault().getLanguage(), "digits_sdk", val$verificationType.name(), callback);
    }

    .DeviceService(Verification verification)
    {
        this$0 = final_digitsclient;
        val$phoneNumber = String.this;
        val$verificationType = verification;
        super(final_callback);
    }
}
