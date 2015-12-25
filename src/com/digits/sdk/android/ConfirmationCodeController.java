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
//            DigitsClient, DigitsConstants, ErrorCodes, ActivityClassManager

class ConfirmationCodeController extends DigitsControllerImpl
{

    private final String phoneNumber;

    ConfirmationCodeController(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, String s)
    {
        this(resultreceiver, statebutton, edittext, s, Digits.getSessionManager(), Digits.getInstance().getDigitsClient(), ((ErrorCodes) (new ConfirmationErrorCodes(statebutton.getContext().getResources()))), Digits.getInstance().getActivityClassManager());
    }

    ConfirmationCodeController(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, String s, SessionManager sessionmanager, DigitsClient digitsclient, ErrorCodes errorcodes, 
            ActivityClassManager activityclassmanager)
    {
        super(resultreceiver, statebutton, edittext, digitsclient, errorcodes, activityclassmanager, sessionmanager);
        phoneNumber = s;
    }

    public void executeRequest(final Context final_context1)
    {
        if (validateInput(editText.getText()))
        {
            sendButton.showProgress();
            rz._mth02CA(final_context1, editText);
            String s = editText.getText().toString();
            digitsClient.createAccount(s, phoneNumber, new _cls1(this, final_context1));
        }
    }

    Uri getTosUri()
    {
        return DigitsConstants.TWITTER_TOS;
    }


    private class _cls1 extends DigitsCallback
    {

        final ConfirmationCodeController this$0;
        final Context val$context;

        public void success(Result result)
        {
            result = DigitsSession.create(result, phoneNumber);
            loginSuccess(context, result, phoneNumber);
        }

        _cls1(DigitsController digitscontroller, Context context2)
        {
            this$0 = ConfirmationCodeController.this;
            context = context2;
            super(final_context1, digitscontroller);
        }
    }

}
