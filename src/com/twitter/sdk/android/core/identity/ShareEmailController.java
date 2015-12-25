// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            ShareEmailClient

class ShareEmailController
{

    private static final String EMPTY_EMAIL = "";
    private final ShareEmailClient emailClient;
    private final ResultReceiver resultReceiver;

    public ShareEmailController(ShareEmailClient shareemailclient, ResultReceiver resultreceiver)
    {
        emailClient = shareemailclient;
        resultReceiver = resultreceiver;
    }

    public void cancelRequest()
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("msg", "The user chose not to share their email address at this time.");
        resultReceiver.send(0, bundle);
    }

    public void executeRequest()
    {
        emailClient.getEmail(newCallback());
    }

    void handleSuccess(User user)
    {
        if (user.email == null)
        {
            sendResultCodeError(new TwitterException("Your application may not have access to email addresses or the user may not have an email address. To request access, please visit https://support.twitter.com/forms/platform."));
            return;
        }
        if ("".equals(user.email))
        {
            sendResultCodeError(new TwitterException("This user does not have an email address."));
            return;
        } else
        {
            sendResultCodeOk(user.email);
            return;
        }
    }

    Callback newCallback()
    {
        return new _cls1();
    }

    void sendResultCodeError(TwitterException twitterexception)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("error", twitterexception);
        resultReceiver.send(1, bundle);
    }

    void sendResultCodeOk(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("email", s);
        resultReceiver.send(-1, bundle);
    }

    private class _cls1 extends Callback
    {

        final ShareEmailController this$0;

        public void failure(TwitterException twitterexception)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to get email address.", twitterexception);
            sendResultCodeError(new TwitterException("Failed to get email address."));
        }

        public void success(Result result)
        {
            handleSuccess((User)result.data);
        }

        _cls1()
        {
            this$0 = ShareEmailController.this;
            super();
        }
    }

}
