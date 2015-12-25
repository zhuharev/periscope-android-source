// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.EditText;
import android.widget.TextView;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsActivityDelegateImpl, StateButton, PinCodeController, BundleManager, 
//            DigitsController

class PinCodeActivityDelegate extends DigitsActivityDelegateImpl
{

    DigitsController controller;
    EditText editText;
    StateButton stateButton;
    TextView termsText;

    PinCodeActivityDelegate()
    {
    }

    public int getLayoutId()
    {
        return R.layout.dgts__activity_pin_code;
    }

    public void init(Activity activity, Bundle bundle)
    {
        editText = (EditText)activity.findViewById(R.id.dgts__confirmationEditText);
        stateButton = (StateButton)activity.findViewById(R.id.dgts__createAccount);
        termsText = (TextView)activity.findViewById(R.id.dgts__termsTextCreateAccount);
        controller = initController(bundle);
        setUpEditText(activity, controller, editText);
        setUpSendButton(activity, controller, stateButton);
        setUpTermsText(activity, controller, termsText);
        rz._mth02CA(activity, editText);
    }

    DigitsController initController(Bundle bundle)
    {
        return new PinCodeController((ResultReceiver)bundle.getParcelable("receiver"), stateButton, editText, bundle.getString("request_id"), bundle.getLong("user_id"), bundle.getString("phone_number"));
    }

    public boolean isValid(Bundle bundle)
    {
        return BundleManager.assertContains(bundle, new String[] {
            "receiver", "phone_number", "request_id", "user_id"
        });
    }

    public void onResume()
    {
        controller.onResume();
    }
}
