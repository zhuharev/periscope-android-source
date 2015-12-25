// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            AuthResponse, PhoneNumberController

class val.result
    implements Runnable
{

    final val.result this$1;
    final Result val$result;

    public void run()
    {
        Object obj = (AuthResponse)val$result.data;
        PhoneNumberController phonenumbercontroller = _fld0;
        if (((AuthResponse) (obj)).normalizedPhoneNumber == null)
        {
            obj = phoneNumber;
        } else
        {
            obj = ((AuthResponse) (obj)).normalizedPhoneNumber;
        }
        phonenumbercontroller.phoneNumber = ((String) (obj));
        startSignIn(context, (AuthResponse)val$result.data);
    }

    ()
    {
        this$1 = final_;
        val$result = Result.this;
        super();
    }
}
