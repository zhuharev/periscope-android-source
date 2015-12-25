// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.twitter.sdk.android.core.SessionManager;

// Referenced classes of package com.digits.sdk.android:
//            WeakAuthCallback, DigitsSession, DigitsException, AuthCallback

class LoginResultReceiver extends ResultReceiver
{

    static final String KEY_ERROR = "login_error";
    static final int RESULT_ERROR = 400;
    static final int RESULT_OK = 200;
    final WeakAuthCallback callback;
    final SessionManager sessionManager;

    LoginResultReceiver(AuthCallback authcallback, SessionManager sessionmanager)
    {
        super(null);
        callback = new WeakAuthCallback(authcallback);
        sessionManager = sessionmanager;
    }

    public void onReceiveResult(int i, Bundle bundle)
    {
        if (callback != null)
        {
            if (i == 200)
            {
                callback.success((DigitsSession)sessionManager.getActiveSession(), bundle.getString("phone_number"));
                return;
            }
            if (i == 400)
            {
                callback.failure(new DigitsException(bundle.getString("login_error")));
            }
        }
    }
}
