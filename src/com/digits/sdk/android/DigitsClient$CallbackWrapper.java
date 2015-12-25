// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterException;

// Referenced classes of package com.digits.sdk.android:
//            DigitsClient

static abstract class callback extends Callback
{

    final Callback callback;

    public void failure(TwitterException twitterexception)
    {
        if (callback != null)
        {
            callback.failure(twitterexception);
        }
    }

    public _cls9(Callback callback1)
    {
        callback = callback1;
    }
}
