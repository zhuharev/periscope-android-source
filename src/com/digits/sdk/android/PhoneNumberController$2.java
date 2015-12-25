// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            DigitsCallback, DeviceRegistrationResponse, AuthConfig, PhoneNumberController, 
//            StateButton, DigitsController

class val.context extends DigitsCallback
{

    final PhoneNumberController this$0;
    final Context val$context;

    public void success(Result result)
    {
        Object obj = (DeviceRegistrationResponse)result.data;
        Object obj1 = ((DeviceRegistrationResponse) (obj)).authConfig;
        if (obj1 != null)
        {
            voiceEnabled = ((AuthConfig) (obj1)).isVoiceEnabled;
        }
        obj1 = PhoneNumberController.this;
        if (((DeviceRegistrationResponse) (obj)).normalizedPhoneNumber == null)
        {
            obj = phoneNumber;
        } else
        {
            obj = ((DeviceRegistrationResponse) (obj)).normalizedPhoneNumber;
        }
        obj1.phoneNumber = ((String) (obj));
        sendButton.showFinish();
        PhoneNumberController.access$000(PhoneNumberController.this, val$context, (DeviceRegistrationResponse)result.data);
    }

    se(DigitsController digitscontroller, Context context2)
    {
        this$0 = final_phonenumbercontroller;
        val$context = context2;
        super(Context.this, digitscontroller);
    }
}
