// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.EditText;
import android.widget.TextView;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsActivityDelegateImpl, StateButton, AuthConfig, LoginCodeController, 
//            BundleManager, DigitsController, SmsBroadcastReceiver

class LoginCodeActivityDelegate extends DigitsActivityDelegateImpl
{

    Activity activity;
    AuthConfig config;
    DigitsController controller;
    EditText editText;
    SmsBroadcastReceiver receiver;
    StateButton stateButton;
    TextView termsText;

    LoginCodeActivityDelegate()
    {
    }

    public int getLayoutId()
    {
        return R.layout.dgts__activity_confirmation;
    }

    public void init(Activity activity1, Bundle bundle)
    {
        activity = activity1;
        editText = (EditText)activity1.findViewById(R.id.dgts__confirmationEditText);
        stateButton = (StateButton)activity1.findViewById(R.id.dgts__createAccount);
        termsText = (TextView)activity1.findViewById(R.id.dgts__termsTextCreateAccount);
        TextView textview = (TextView)activity1.findViewById(R.id.dgts__resendConfirmation);
        config = (AuthConfig)bundle.getParcelable("auth_config");
        controller = initController(bundle);
        setUpEditText(activity1, controller, editText);
        setUpSendButton(activity1, controller, stateButton);
        setUpTermsText(activity1, controller, termsText);
        setUpResendText(activity1, textview);
        setUpSmsIntercept(activity1, editText);
        rz._mth02CA(activity1, editText);
    }

    DigitsController initController(Bundle bundle)
    {
        return new LoginCodeController((ResultReceiver)bundle.getParcelable("receiver"), stateButton, editText, bundle.getString("request_id"), bundle.getLong("user_id"), bundle.getString("phone_number"));
    }

    public boolean isValid(Bundle bundle)
    {
        return BundleManager.assertContains(bundle, new String[] {
            "receiver", "phone_number", "request_id", "user_id"
        });
    }

    public void onDestroy()
    {
        if (receiver != null)
        {
            activity.unregisterReceiver(receiver);
        }
    }

    public void onResume()
    {
        controller.onResume();
    }

    protected void setUpResendText(final Activity activity, TextView textview)
    {
        textview.setOnClickListener(new _cls1());
    }

    public void setUpSendButton(Activity activity1, DigitsController digitscontroller, StateButton statebutton)
    {
        statebutton.setStatesText(R.string.dgts__sign_in, R.string.dgts__signing_in, R.string.dgts__sign_in);
        statebutton.showStart();
        super.setUpSendButton(activity1, digitscontroller, statebutton);
    }

    protected void setUpSmsIntercept(Activity activity1, EditText edittext)
    {
        if (rz._mth02BE(activity1, "android.permission.RECEIVE_SMS"))
        {
            IntentFilter intentfilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
            receiver = new SmsBroadcastReceiver(edittext);
            activity1.registerReceiver(receiver, intentfilter);
        }
    }

    public void setUpTermsText(Activity activity1, DigitsController digitscontroller, TextView textview)
    {
        if (config != null && config.tosUpdate)
        {
            textview.setText(getFormattedTerms(activity1, R.string.dgts__terms_text_sign_in));
            super.setUpTermsText(activity1, digitscontroller, textview);
            return;
        } else
        {
            textview.setVisibility(8);
            return;
        }
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final LoginCodeActivityDelegate this$0;
        final Activity val$activity;

        public void onClick(View view)
        {
            activity.setResult(300);
            activity.finish();
        }

        _cls1()
        {
            this$0 = LoginCodeActivityDelegate.this;
            activity = activity1;
            super();
        }
    }

}
