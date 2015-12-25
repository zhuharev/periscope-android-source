// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

class ShareEmailClient extends TwitterApiClient
{
    static interface EmailService
    {

        public abstract void verifyCredentials(Boolean boolean1, Boolean boolean2, Callback callback);
    }


    static final int RESULT_CODE_CANCELED = 0;
    static final int RESULT_CODE_ERROR = 1;
    static final int RESULT_CODE_OK = -1;
    static final String RESULT_DATA_EMAIL = "email";
    static final String RESULT_DATA_ERROR = "error";
    static final String RESULT_DATA_MSG = "msg";

    ShareEmailClient(TwitterSession twittersession)
    {
        super(twittersession);
    }

    protected void getEmail(Callback callback)
    {
        ((EmailService)getService(com/twitter/sdk/android/core/identity/ShareEmailClient$EmailService)).verifyCredentials(Boolean.valueOf(true), Boolean.valueOf(true), callback);
    }
}
