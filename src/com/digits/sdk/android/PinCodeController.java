// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.net.Uri;
import android.os.ResultReceiver;
import android.widget.EditText;
import com.twitter.sdk.android.core.SessionManager;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsControllerImpl, Digits, ConfirmationErrorCodes, StateButton, 
//            DigitsClient, ErrorCodes, ActivityClassManager

class PinCodeController extends DigitsControllerImpl
{

    private final String phoneNumber;
    private final String requestId;
    private final long userId;

    PinCodeController(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, SessionManager sessionmanager, DigitsClient digitsclient, String s, long l, String s1, ErrorCodes errorcodes, ActivityClassManager activityclassmanager)
    {
        super(resultreceiver, statebutton, edittext, digitsclient, errorcodes, activityclassmanager, sessionmanager);
        requestId = s;
        userId = l;
        phoneNumber = s1;
    }

    PinCodeController(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, String s, long l, String s1)
    {
        this(resultreceiver, statebutton, edittext, Digits.getSessionManager(), Digits.getInstance().getDigitsClient(), s, l, s1, ((ErrorCodes) (new ConfirmationErrorCodes(statebutton.getContext().getResources()))), Digits.getInstance().getActivityClassManager());
    }

    public void executeRequest(final Context final_context1)
    {
        if (validateInput(editText.getText()))
        {
            sendButton.showProgress();
            rz._mth02CA(final_context1, editText);
            String s = editText.getText().toString();
            digitsClient.verifyPin(requestId, userId, s, new _cls1(this, final_context1));
        }
    }

    Uri getTosUri()
    {
        return null;
    }

    public void showTOS(Context context)
    {
    }


    private class _cls1 extends DigitsCallback
    {

        final PinCodeController this$0;
        final Context val$context;

        public void success(Result result)
        {
            result = DigitsSession.create((DigitsSessionResponse)result.data, phoneNumber);
            loginSuccess(context, result, phoneNumber);
        }

        _cls1(DigitsController digitscontroller, Context context2)
        {
            this$0 = PinCodeController.this;
            context = context2;
            super(final_context1, digitscontroller);
        }
    }

}
