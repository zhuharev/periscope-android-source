// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.twitter.sdk.android.core.SessionManager;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsController, UnrecoverableException, DigitsException, StateButton, 
//            ActivityClassManager, DigitsClient, ErrorCodes, DigitsSession

abstract class DigitsControllerImpl
    implements DigitsController, TextWatcher
{

    public static final int MAX_ERRORS = 5;
    static final long POST_DELAY_MS = 1500L;
    final ActivityClassManager activityClassManager;
    final DigitsClient digitsClient;
    final EditText editText;
    private int errorCount;
    final ErrorCodes errors;
    final ResultReceiver resultReceiver;
    final StateButton sendButton;
    final SessionManager sessionManager;

    DigitsControllerImpl(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, DigitsClient digitsclient, ErrorCodes errorcodes, ActivityClassManager activityclassmanager, SessionManager sessionmanager)
    {
        resultReceiver = resultreceiver;
        digitsClient = digitsclient;
        activityClassManager = activityclassmanager;
        sendButton = statebutton;
        editText = edittext;
        errors = errorcodes;
        sessionManager = sessionmanager;
        errorCount = 0;
    }

    private boolean isUnrecoverable(DigitsException digitsexception)
    {
        return errorCount == 5 || (digitsexception instanceof UnrecoverableException);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void clearError()
    {
        editText.setError(null);
    }

    Bundle getBundle(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("phone_number", s);
        return bundle;
    }

    public int getErrorCount()
    {
        return errorCount;
    }

    public ErrorCodes getErrors()
    {
        return errors;
    }

    public TextWatcher getTextWatcher()
    {
        return this;
    }

    abstract Uri getTosUri();

    public void handleError(Context context, DigitsException digitsexception)
    {
        errorCount = errorCount + 1;
        if (isUnrecoverable(digitsexception))
        {
            startFallback(context, resultReceiver, digitsexception);
            return;
        } else
        {
            editText.setError(digitsexception.getLocalizedMessage());
            sendButton.showError();
            return;
        }
    }

    void loginSuccess(final Context context, DigitsSession digitssession, final String phoneNumber)
    {
        sessionManager.setActiveSession(digitssession);
        sendButton.showFinish();
        editText.postDelayed(new _cls1(), 1500L);
    }

    public void onResume()
    {
        sendButton.showStart();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        clearError();
    }

    public void showTOS(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(getTosUri());
        context.startActivity(intent);
    }

    void startActivityForResult(Activity activity, Intent intent)
    {
        activity.startActivityForResult(intent, 140);
    }

    public void startFallback(Context context, ResultReceiver resultreceiver, DigitsException digitsexception)
    {
        Intent intent = new Intent(context, activityClassManager.getFailureActivity());
        intent.putExtra("receiver", resultreceiver);
        intent.putExtra("fallback_reason", digitsexception);
        context.startActivity(intent);
        rz._mth02BF(context, 200);
    }

    public boolean validateInput(CharSequence charsequence)
    {
        return !TextUtils.isEmpty(charsequence);
    }

    private class _cls1
        implements Runnable
    {

        final DigitsControllerImpl this$0;
        final Context val$context;
        final String val$phoneNumber;

        public void run()
        {
            resultReceiver.send(200, getBundle(phoneNumber));
            rz._mth02CB((Activity)context, 200);
        }

        _cls1()
        {
            this$0 = DigitsControllerImpl.this;
            phoneNumber = s;
            context = context1;
            super();
        }
    }

}
