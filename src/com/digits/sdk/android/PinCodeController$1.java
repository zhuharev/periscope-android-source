// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            DigitsCallback, DigitsSessionResponse, PinCodeController, DigitsSession, 
//            DigitsController

class > extends DigitsCallback
{

    final PinCodeController this$0;
    final Context val$context;

    public void success(Result result)
    {
        result = DigitsSession.create((DigitsSessionResponse)result.data, PinCodeController.access$000(PinCodeController.this));
        loginSuccess(val$context, result, PinCodeController.access$000(PinCodeController.this));
    }

    e(DigitsController digitscontroller, Context context2)
    {
        this$0 = final_pincodecontroller;
        val$context = context2;
        super(Context.this, digitscontroller);
    }
}
