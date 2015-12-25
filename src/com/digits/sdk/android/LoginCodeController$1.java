// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            DigitsCallback, DigitsSessionResponse, LoginCodeController, DigitsSession, 
//            DigitsController

class val.context extends DigitsCallback
{

    final LoginCodeController this$0;
    final Context val$context;

    public void success(Result result)
    {
        if (((DigitsSessionResponse)result.data).isEmpty())
        {
            LoginCodeController.access$000(LoginCodeController.this, val$context);
            return;
        } else
        {
            result = DigitsSession.create((DigitsSessionResponse)result.data, LoginCodeController.access$100(LoginCodeController.this));
            loginSuccess(val$context, result, LoginCodeController.access$100(LoginCodeController.this));
            return;
        }
    }

    (DigitsController digitscontroller, Context context2)
    {
        this$0 = final_logincodecontroller;
        val$context = context2;
        super(Context.this, digitscontroller);
    }
}
