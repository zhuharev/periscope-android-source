// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsActivityDelegateImpl, TosView, PhoneNumberTask, Digits, 
//            CountryListSpinner, StateButton, PhoneNumberUtils, SimManager, 
//            PhoneNumberController, BundleManager, PhoneNumber, DigitsController

class PhoneNumberActivityDelegate extends DigitsActivityDelegateImpl
    implements PhoneNumberTask.Listener, TosView
{

    private Activity activity;
    PhoneNumberController controller;
    CountryListSpinner countryCodeSpinner;
    EditText phoneEditText;
    StateButton sendButton;
    TextView termsTextView;

    PhoneNumberActivityDelegate()
    {
    }

    private void executePhoneNumberTask(PhoneNumberUtils phonenumberutils, Bundle bundle)
    {
        bundle = bundle.getString("phone_number");
        if (TextUtils.isEmpty(bundle))
        {
            (new PhoneNumberTask(phonenumberutils, this)).executeOnExecutor(Digits.getInstance().getExecutorService(), new Void[0]);
            return;
        } else
        {
            (new PhoneNumberTask(phonenumberutils, bundle, this)).executeOnExecutor(Digits.getInstance().getExecutorService(), new Void[0]);
            return;
        }
    }

    public int getLayoutId()
    {
        return R.layout.dgts__activity_phone_number;
    }

    public void init(Activity activity1, Bundle bundle)
    {
        activity = activity1;
        countryCodeSpinner = (CountryListSpinner)activity1.findViewById(R.id.dgts__countryCode);
        sendButton = (StateButton)activity1.findViewById(R.id.dgts__sendCodeButton);
        phoneEditText = (EditText)activity1.findViewById(R.id.dgts__phoneNumberEditText);
        termsTextView = (TextView)activity1.findViewById(R.id.dgts__termsText);
        controller = initController(bundle);
        setUpEditText(activity1, controller, phoneEditText);
        setUpSendButton(activity1, controller, sendButton);
        setUpTermsText(activity1, controller, termsTextView);
        setUpCountrySpinner(countryCodeSpinner);
        executePhoneNumberTask(new PhoneNumberUtils(SimManager.createSimManager(activity1)), bundle);
        rz._mth02CA(activity1, phoneEditText);
    }

    PhoneNumberController initController(Bundle bundle)
    {
        return new PhoneNumberController((ResultReceiver)bundle.getParcelable("receiver"), sendButton, phoneEditText, countryCodeSpinner, this);
    }

    public boolean isValid(Bundle bundle)
    {
        return BundleManager.assertContains(bundle, new String[] {
            "receiver"
        });
    }

    public void onActivityResult(int i, int j, Activity activity1)
    {
        if (j == 300 && i == 140)
        {
            controller.resend();
        }
    }

    public void onLoadComplete(PhoneNumber phonenumber)
    {
        controller.setPhoneNumber(phonenumber);
        controller.setCountryCode(phonenumber);
    }

    public void onResume()
    {
        controller.onResume();
    }

    public void setText(int i)
    {
        termsTextView.setText(getFormattedTerms(activity, i));
    }

    protected void setUpCountrySpinner(CountryListSpinner countrylistspinner)
    {
        countrylistspinner.setOnClickListener(new _cls1());
    }

    public void setUpTermsText(Activity activity1, DigitsController digitscontroller, TextView textview)
    {
        textview.setText(getFormattedTerms(activity1, R.string.dgts__terms_text));
        super.setUpTermsText(activity1, digitscontroller, textview);
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PhoneNumberActivityDelegate this$0;

        public void onClick(View view)
        {
            controller.clearError();
        }

        _cls1()
        {
            this$0 = PhoneNumberActivityDelegate.this;
            super();
        }
    }

}
