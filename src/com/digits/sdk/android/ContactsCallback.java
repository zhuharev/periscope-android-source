// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;

public abstract class ContactsCallback extends Callback
{

    public ContactsCallback()
    {
    }

    public abstract void failure(TwitterException twitterexception);

    public abstract void success(Result result);
}
