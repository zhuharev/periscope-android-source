// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.internal.AuthRequestQueue;
import com.twitter.sdk.android.core.internal.SessionProvider;

// Referenced classes of package com.digits.sdk.android:
//            DigitsClient

class DigitsAuthRequestQueue extends AuthRequestQueue
{

    final DigitsClient digitsClient;

    DigitsAuthRequestQueue(DigitsClient digitsclient, SessionProvider sessionprovider)
    {
        super(sessionprovider);
        digitsClient = digitsclient;
    }

    protected boolean addClientRequest(final Callback callback)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = addRequest(new _cls1());
        this;
        JVM INSTR monitorexit ;
        return flag;
        callback;
        throw callback;
    }

    private class _cls1 extends Callback
    {

        final DigitsAuthRequestQueue this$0;
        final Callback val$callback;

        public void failure(TwitterException twitterexception)
        {
            callback.failure(twitterexception);
        }

        public void success(Result result)
        {
            callback.success(new Result(digitsClient.getApiClient((Session)result.data), null));
        }

        _cls1()
        {
            this$0 = DigitsAuthRequestQueue.this;
            callback = callback1;
            super();
        }
    }

}
