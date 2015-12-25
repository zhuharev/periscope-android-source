// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import com.twitter.sdk.android.core.Result;

// Referenced classes of package com.digits.sdk.android:
//            DigitsCallback, ConfirmationCodeController, DigitsSession, DigitsController

class val.context extends DigitsCallback
{

    final ConfirmationCodeController this$0;
    final Context val$context;

    public void success(Result result)
    {
        result = DigitsSession.create(result, ConfirmationCodeController.access$000(ConfirmationCodeController.this));
        loginSuccess(val$context, result, ConfirmationCodeController.access$000(ConfirmationCodeController.this));
    }

    _cls9(DigitsController digitscontroller, Context context2)
    {
        this$0 = final_confirmationcodecontroller;
        val$context = context2;
        super(Context.this, digitscontroller);
    }
}
