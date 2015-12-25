// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.widget.EditText;
import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            DigitsCallback, PhoneNumberController, StateButton, AuthResponse, 
//            AuthConfig, DigitsController

class val.context extends DigitsCallback
{

    final PhoneNumberController this$0;
    final Context val$context;

    public void success(final Result result)
    {
        sendButton.showFinish();
        AuthConfig authconfig = ((AuthResponse)result.data).authConfig;
        if (authconfig != null)
        {
            voiceEnabled = authconfig.isVoiceEnabled;
        }
        class _cls1
            implements Runnable
        {

            final PhoneNumberController._cls1 this$1;
            final Result val$result;

            public void run()
            {
                Object obj = (AuthResponse)result.data;
                PhoneNumberController phonenumbercontroller = this$0;
                if (((AuthResponse) (obj)).normalizedPhoneNumber == null)
                {
                    obj = phoneNumber;
                } else
                {
                    obj = ((AuthResponse) (obj)).normalizedPhoneNumber;
                }
                phonenumbercontroller.phoneNumber = ((String) (obj));
                startSignIn(context, (AuthResponse)result.data);
            }

            _cls1()
            {
                this$1 = PhoneNumberController._cls1.this;
                result = result1;
                super();
            }
        }

        editText.postDelayed(new _cls1(), 1500L);
    }

    _cls1(DigitsController digitscontroller, Context context2)
    {
        this$0 = final_phonenumbercontroller;
        val$context = context2;
        super(Context.this, digitscontroller);
    }
}
