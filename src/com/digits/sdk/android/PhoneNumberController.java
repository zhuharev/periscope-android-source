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
import android.widget.EditText;
import com.twitter.sdk.android.core.SessionManager;
import java.util.Locale;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            DigitsControllerImpl, Digits, PhoneNumberErrorCodes, StateButton, 
//            Verification, ActivityClassManager, DeviceRegistrationResponse, CountryListSpinner, 
//            DigitsClient, DigitsConstants, CouldNotAuthenticateException, OperatorUnsupportedException, 
//            DigitsException, AuthConfig, TosView, PhoneNumber, 
//            AuthResponse, ErrorCodes

class PhoneNumberController extends DigitsControllerImpl
    implements PhoneNumberTask.Listener
{

    final CountryListSpinner countryCodeSpinner;
    String phoneNumber;
    boolean resendState;
    private final TosView tosView;
    boolean voiceEnabled;

    PhoneNumberController(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, CountryListSpinner countrylistspinner, DigitsClient digitsclient, ErrorCodes errorcodes, ActivityClassManager activityclassmanager, 
            SessionManager sessionmanager, TosView tosview)
    {
        super(resultreceiver, statebutton, edittext, digitsclient, errorcodes, activityclassmanager, sessionmanager);
        countryCodeSpinner = countrylistspinner;
        tosView = tosview;
    }

    PhoneNumberController(ResultReceiver resultreceiver, StateButton statebutton, EditText edittext, CountryListSpinner countrylistspinner, TosView tosview)
    {
        this(resultreceiver, statebutton, edittext, countrylistspinner, Digits.getInstance().getDigitsClient(), ((ErrorCodes) (new PhoneNumberErrorCodes(statebutton.getContext().getResources()))), Digits.getInstance().getActivityClassManager(), Digits.getSessionManager(), tosview);
        voiceEnabled = false;
        resendState = false;
    }

    private Bundle getBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("phone_number", phoneNumber);
        bundle.putParcelable("receiver", resultReceiver);
        return bundle;
    }

    private String getNumber(long l, String s)
    {
        return (new StringBuilder("+")).append(String.valueOf(l)).append(s).toString();
    }

    private Verification getVerificationType()
    {
        if (resendState && voiceEnabled)
        {
            return Verification.voicecall;
        } else
        {
            return Verification.sms;
        }
    }

    private void startNextStep(Context context, DeviceRegistrationResponse deviceregistrationresponse)
    {
        Intent intent = new Intent(context, activityClassManager.getConfirmationActivity());
        Bundle bundle = getBundle();
        if (deviceregistrationresponse.authConfig != null)
        {
            bundle.putParcelable("auth_config", deviceregistrationresponse.authConfig);
        }
        intent.putExtras(bundle);
        startActivityForResult((Activity)context, intent);
    }

    public void executeRequest(final Context final_context1)
    {
        if (validateInput(editText.getText()))
        {
            sendButton.showProgress();
            rz._mth02CA(final_context1, editText);
            int i = ((Integer)countryCodeSpinner.getTag()).intValue();
            String s = editText.getText().toString();
            phoneNumber = getNumber(i, s);
            digitsClient.authDevice(phoneNumber, getVerificationType(), new _cls1(this, final_context1));
        }
    }

    Uri getTosUri()
    {
        return DigitsConstants.DIGITS_TOS;
    }

    public void handleError(final Context final_context1, DigitsException digitsexception)
    {
        if (digitsexception instanceof CouldNotAuthenticateException)
        {
            digitsClient.registerDevice(phoneNumber, getVerificationType(), new _cls2(this, final_context1));
            return;
        }
        if (digitsexception instanceof OperatorUnsupportedException)
        {
            voiceEnabled = digitsexception.getConfig().isVoiceEnabled;
            resend();
        }
        super.handleError(final_context1, digitsexception);
    }

    public void onLoadComplete(PhoneNumber phonenumber)
    {
        setPhoneNumber(phonenumber);
        setCountryCode(phonenumber);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        if (Verification.voicecall.equals(getVerificationType()))
        {
            resendState = false;
            sendButton.setStatesText(R.string.dgts__confirmation_send_text, R.string.dgts__confirmation_sending_text, R.string.dgts__confirmation_sent_text);
            sendButton.showStart();
            tosView.setText(R.string.dgts__terms_text);
        }
    }

    public void resend()
    {
        resendState = true;
        if (voiceEnabled)
        {
            sendButton.setStatesText(R.string.dgts__call_me, R.string.dgts__calling, R.string.dgts__calling);
            tosView.setText(R.string.dgts__terms_text_call_me);
        }
    }

    public void setCountryCode(PhoneNumber phonenumber)
    {
        if (PhoneNumber.isCountryValid(phonenumber))
        {
            countryCodeSpinner.setSelectedForCountry((new Locale("", phonenumber.getCountryIso())).getDisplayName(), phonenumber.getCountryCode());
        }
    }

    public void setPhoneNumber(PhoneNumber phonenumber)
    {
        if (PhoneNumber.isValid(phonenumber))
        {
            editText.setText(phonenumber.getPhoneNumber());
            editText.setSelection(phonenumber.getPhoneNumber().length());
        }
    }

    void startSignIn(Context context, AuthResponse authresponse)
    {
        Intent intent = new Intent(context, activityClassManager.getLoginCodeActivity());
        Bundle bundle = getBundle();
        bundle.putString("request_id", authresponse.requestId);
        bundle.putLong("user_id", authresponse.userId);
        bundle.putParcelable("auth_config", authresponse.authConfig);
        intent.putExtras(bundle);
        startActivityForResult((Activity)context, intent);
    }


    private class _cls1 extends DigitsCallback
    {

        final PhoneNumberController this$0;
        final Context val$context;

        public void success(final Result result)
        {
            sendButton.showFinish();
            AuthConfig authconfig = ((AuthResponse)result.data).authConfig;
            if (authconfig != null)
            {
                voiceEnabled = authconfig.isVoiceEnabled;
            }
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final Result val$result;

                public void run()
                {
                    Object obj = (AuthResponse)result.data;
                    PhoneNumberController phonenumbercontroller = _fld0;
                    if (((AuthResponse) (obj)).normalizedPhoneNumber == null)
                    {
                        obj = phoneNumber;
                    } else
                    {
                        obj = ((AuthResponse) (obj)).normalizedPhoneNumber;
                    }
                    phonenumbercontroller.phoneNumber = ((String) (obj));
                    startSignIn(context, (AuthResponse)result.data);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    result = result1;
                    super();
                }
            }

            editText.postDelayed(new _cls1(), 1500L);
        }

        _cls1(DigitsController digitscontroller, Context context2)
        {
            this$0 = PhoneNumberController.this;
            context = context2;
            super(final_context1, digitscontroller);
        }
    }


    private class _cls2 extends DigitsCallback
    {

        final PhoneNumberController this$0;
        final Context val$context;

        public void success(Result result)
        {
            Object obj = (DeviceRegistrationResponse)result.data;
            Object obj1 = ((DeviceRegistrationResponse) (obj)).authConfig;
            if (obj1 != null)
            {
                voiceEnabled = ((AuthConfig) (obj1)).isVoiceEnabled;
            }
            obj1 = PhoneNumberController.this;
            if (((DeviceRegistrationResponse) (obj)).normalizedPhoneNumber == null)
            {
                obj = phoneNumber;
            } else
            {
                obj = ((DeviceRegistrationResponse) (obj)).normalizedPhoneNumber;
            }
            obj1.phoneNumber = ((String) (obj));
            sendButton.showFinish();
            startNextStep(context, (DeviceRegistrationResponse)result.data);
        }

        _cls2(DigitsController digitscontroller, Context context2)
        {
            this$0 = PhoneNumberController.this;
            context = context2;
            super(final_context1, digitscontroller);
        }
    }

}
