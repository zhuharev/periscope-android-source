// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterException;

// Referenced classes of package com.digits.sdk.android:
//            DigitsAuthRequestQueue, DigitsClient

class val.callback extends Callback
{

    final DigitsAuthRequestQueue this$0;
    final Callback val$callback;

    public void failure(TwitterException twitterexception)
    {
        val$callback.failure(twitterexception);
    }

    public void success(Result result)
    {
        val$callback.success(new Result(digitsClient.getApiClient((Session)result.data), null));
    }

    ()
    {
        this$0 = final_digitsauthrequestqueue;
        val$callback = Callback.this;
        super();
    }
}
