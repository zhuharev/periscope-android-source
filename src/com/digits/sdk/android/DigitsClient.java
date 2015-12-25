// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.digits.sdk.android:
//            Digits, DigitsAuthRequestQueue, LoginResultReceiver, ActivityClassManager, 
//            DigitsSession, DigitsScribeService, AuthCallback, DigitsGuestSessionProvider, 
//            DigitsApiClient, DigitsUserAgent, Verification

public class DigitsClient
{
    static abstract class CallbackWrapper extends Callback
    {

        final Callback callback;

        public void failure(TwitterException twitterexception)
        {
            if (callback != null)
            {
                callback.failure(twitterexception);
            }
        }

        public CallbackWrapper(Callback callback1)
        {
            callback = callback1;
        }
    }


    public static final String CLIENT_IDENTIFIER = "digits_sdk";
    public static final String EXTRA_AUTH_CONFIG = "auth_config";
    public static final String EXTRA_FALLBACK_REASON = "fallback_reason";
    public static final String EXTRA_PHONE = "phone_number";
    public static final String EXTRA_REQUEST_ID = "request_id";
    public static final String EXTRA_RESULT_RECEIVER = "receiver";
    public static final String EXTRA_USER_ID = "user_id";
    public static final String THIRD_PARTY_CONFIRMATION_CODE = "third_party_confirmation_code";
    private final DigitsAuthRequestQueue authRequestQueue;
    private final Digits digits;
    private DigitsApiClient digitsApiClient;
    private final SessionManager sessionManager;
    private final TwitterCore twitterCore;

    DigitsClient()
    {
        this(Digits.getInstance(), TwitterCore.getInstance(), Digits.getSessionManager(), null);
    }

    DigitsClient(Digits digits1, TwitterCore twittercore, SessionManager sessionmanager, DigitsAuthRequestQueue digitsauthrequestqueue)
    {
        if (twittercore == null)
        {
            throw new IllegalArgumentException("twitter must not be null");
        }
        if (digits1 == null)
        {
            throw new IllegalArgumentException("digits must not be null");
        }
        if (sessionmanager == null)
        {
            throw new IllegalArgumentException("sessionManager must not be null");
        }
        twitterCore = twittercore;
        digits = digits1;
        sessionManager = sessionmanager;
        if (digitsauthrequestqueue == null)
        {
            authRequestQueue = createAuthRequestQueue(sessionmanager);
            authRequestQueue.sessionRestored(null);
            return;
        } else
        {
            authRequestQueue = digitsauthrequestqueue;
            return;
        }
    }

    private Bundle createBundleForAuthFlow(AuthCallback authcallback)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("receiver", new LoginResultReceiver(authcallback, sessionManager));
        return bundle;
    }

    private Bundle createBundleForAuthFlow(AuthCallback authcallback, String s)
    {
        authcallback = createBundleForAuthFlow(authcallback);
        authcallback.putString("phone_number", s);
        return authcallback;
    }

    private void startPhoneNumberActivity(Context context, Bundle bundle)
    {
        Intent intent = new Intent(context, digits.getActivityClassManager().getPhoneNumberActivity());
        intent.putExtras(bundle);
        intent.setFlags(0x14000000);
        context.startActivity(intent);
    }

    private void startSignUpWithBundle(AuthCallback authcallback, Bundle bundle)
    {
        DigitsSession digitssession = (DigitsSession)sessionManager.getActiveSession();
        digits.getScribeService().dailyPing();
        if (digitssession != null && !digitssession.isLoggedOutUser())
        {
            authcallback.success(digitssession, null);
            return;
        } else
        {
            startPhoneNumberActivity(twitterCore.getContext(), bundle);
            return;
        }
    }

    protected void authDevice(final String phoneNumber, Verification verification, final Callback final_callback)
    {
        authRequestQueue.addClientRequest(new _cls1(verification));
    }

    protected void createAccount(String s, final String phoneNumber, final Callback final_callback)
    {
        authRequestQueue.addClientRequest(new _cls2(s));
    }

    protected DigitsAuthRequestQueue createAuthRequestQueue(SessionManager sessionmanager)
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(sessionmanager);
        return new DigitsAuthRequestQueue(this, new DigitsGuestSessionProvider(sessionmanager, arraylist));
    }

    DigitsApiClient getApiClient(Session session)
    {
        if (digitsApiClient != null && digitsApiClient.getSession().equals(session))
        {
            return digitsApiClient;
        } else
        {
            digitsApiClient = new DigitsApiClient(session, twitterCore.getAuthConfig(), twitterCore.getSSLSocketFactory(), digits.getExecutorService(), new DigitsUserAgent(digits.getVersion(), android.os.Build.VERSION.RELEASE));
            return digitsApiClient;
        }
    }

    protected void loginDevice(final String requestId, final long userId, String s, final Callback final_callback)
    {
        authRequestQueue.addClientRequest(new _cls3(s));
    }

    protected void registerDevice(final String phoneNumber, Verification verification, final Callback final_callback)
    {
        authRequestQueue.addClientRequest(new _cls4(verification));
    }

    protected void startSignUp(AuthCallback authcallback)
    {
        startSignUpWithBundle(authcallback, createBundleForAuthFlow(authcallback));
    }

    protected void startSignUp(AuthCallback authcallback, String s)
    {
        if (s == null)
        {
            s = "";
        }
        startSignUpWithBundle(authcallback, createBundleForAuthFlow(authcallback, s));
    }

    protected void verifyPin(final String requestId, final long userId, String s, final Callback final_callback)
    {
        authRequestQueue.addClientRequest(new _cls5(s));
    }

    private class _cls1 extends CallbackWrapper
    {

        final DigitsClient this$0;
        final String val$phoneNumber;
        final Verification val$verificationType;

        public void success(Result result)
        {
            ((DigitsApiClient)result.data).getSdkService().auth(phoneNumber, verificationType.name(), callback);
        }

        _cls1(Verification verification)
        {
            this$0 = DigitsClient.this;
            phoneNumber = s;
            verificationType = verification;
            super(final_callback);
        }
    }


    private class _cls2 extends CallbackWrapper
    {

        final DigitsClient this$0;
        final String val$phoneNumber;
        final String val$pin;

        public void success(Result result)
        {
            ((DigitsApiClient)result.data).getSdkService().account(phoneNumber, pin, callback);
        }

        _cls2(String s1)
        {
            this$0 = DigitsClient.this;
            phoneNumber = s;
            pin = s1;
            super(final_callback);
        }
    }


    private class _cls3 extends CallbackWrapper
    {

        final DigitsClient this$0;
        final String val$code;
        final String val$requestId;
        final long val$userId;

        public void success(Result result)
        {
            ((DigitsApiClient)result.data).getSdkService().login(requestId, userId, code, callback);
        }

        _cls3(String s1)
        {
            this$0 = DigitsClient.this;
            requestId = s;
            userId = l;
            code = s1;
            super(final_callback);
        }
    }


    private class _cls4 extends CallbackWrapper
    {

        final DigitsClient this$0;
        final String val$phoneNumber;
        final Verification val$verificationType;

        public void success(Result result)
        {
            ((DigitsApiClient)result.data).getDeviceService().register(phoneNumber, "third_party_confirmation_code", Boolean.valueOf(true), Locale.getDefault().getLanguage(), "digits_sdk", verificationType.name(), callback);
        }

        _cls4(Verification verification)
        {
            this$0 = DigitsClient.this;
            phoneNumber = s;
            verificationType = verification;
            super(final_callback);
        }
    }


    private class _cls5 extends CallbackWrapper
    {

        final DigitsClient this$0;
        final String val$pin;
        final String val$requestId;
        final long val$userId;

        public void success(Result result)
        {
            ((DigitsApiClient)result.data).getSdkService().verifyPin(requestId, userId, pin, callback);
        }

        _cls5(String s1)
        {
            this$0 = DigitsClient.this;
            requestId = s;
            userId = l;
            pin = s1;
            super(final_callback);
        }
    }

}
