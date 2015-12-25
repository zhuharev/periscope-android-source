// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import com.twitter.sdk.android.core.services.AccountService;
import retrofit.RetrofitError;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            SessionVerifier

public class TwitterSessionVerifier
    implements SessionVerifier
{
    public static class AccountServiceProvider
    {

        public AccountService getAccountService(Session session)
        {
            return (new TwitterApiClient(session)).getAccountService();
        }

        protected AccountServiceProvider()
        {
        }
    }


    static final String SCRIBE_ACTION = "impression";
    static final String SCRIBE_CLIENT = "android";
    static final String SCRIBE_COMPONENT = "";
    static final String SCRIBE_ELEMENT = "";
    static final String SCRIBE_PAGE = "credentials";
    static final String SCRIBE_SECTION = "";
    private final AccountServiceProvider accountServiceProvider;
    private final DefaultScribeClient scribeClient;

    public TwitterSessionVerifier()
    {
        accountServiceProvider = new AccountServiceProvider();
        scribeClient = TwitterCoreScribeClientHolder.getScribeClient();
    }

    TwitterSessionVerifier(AccountServiceProvider accountserviceprovider, DefaultScribeClient defaultscribeclient)
    {
        accountServiceProvider = accountserviceprovider;
        scribeClient = defaultscribeclient;
    }

    private void scribeVerifySession()
    {
        if (scribeClient == null)
        {
            return;
        } else
        {
            EventNamespace eventnamespace = (new com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder()).setClient("android").setPage("credentials").setSection("").setComponent("").setElement("").setAction("impression").builder();
            scribeClient.scribeSyndicatedSdkImpressionEvents(new EventNamespace[] {
                eventnamespace
            });
            return;
        }
    }

    public void verifySession(Session session)
    {
        session = accountServiceProvider.getAccountService(session);
        try
        {
            scribeVerifySession();
            session.verifyCredentials(Boolean.valueOf(true), Boolean.valueOf(false));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Session session)
        {
            return;
        }
    }
}
