// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterApiException, Result, TwitterException

public abstract class Callback
    implements retrofit.Callback
{

    public Callback()
    {
    }

    public abstract void failure(TwitterException twitterexception);

    public final void failure(RetrofitError retrofiterror)
    {
        failure(((TwitterException) (TwitterApiException.convert(retrofiterror))));
    }

    public abstract void success(Result result);

    public final void success(Object obj, Response response)
    {
        success(new Result(obj, response));
    }
}
