// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            DigitsApiClient, DigitsClient

class llbackWrapper extends llbackWrapper
{

    final DigitsClient this$0;
    final String val$phoneNumber;
    final String val$pin;

    public void success(Result result)
    {
        ((DigitsApiClient)result.data).getSdkService().account(val$phoneNumber, val$pin, callback);
    }

    .SdkService(String s1)
    {
        this$0 = final_digitsclient;
        val$phoneNumber = String.this;
        val$pin = s1;
        super(final_callback);
    }
}
