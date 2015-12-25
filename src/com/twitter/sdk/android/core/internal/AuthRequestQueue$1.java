// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterException;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            AuthRequestQueue

class this._cls0 extends Callback
{

    final AuthRequestQueue this$0;

    public void failure(TwitterException twitterexception)
    {
        flushQueueOnError(twitterexception);
    }

    public void success(Result result)
    {
        flushQueueOnSuccess((Session)result.data);
    }

    ()
    {
        this$0 = AuthRequestQueue.this;
        super();
    }
}
