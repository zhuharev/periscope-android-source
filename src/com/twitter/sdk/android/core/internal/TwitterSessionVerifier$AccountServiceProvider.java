// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.services.AccountService;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            TwitterSessionVerifier

public static class Y
{

    public AccountService getAccountService(Session session)
    {
        return (new TwitterApiClient(session)).getAccountService();
    }

    protected Y()
    {
    }
}
