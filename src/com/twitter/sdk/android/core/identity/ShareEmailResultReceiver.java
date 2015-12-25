// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;

class ShareEmailResultReceiver extends ResultReceiver
{

    private final Callback callback;

    public ShareEmailResultReceiver(Callback callback1)
    {
        super(null);
        if (callback1 == null)
        {
            throw new IllegalArgumentException("Callback must not be null");
        } else
        {
            callback = callback1;
            return;
        }
    }

    public void onReceiveResult(int i, Bundle bundle)
    {
        switch (i)
        {
        case -1: 
            callback.success(new Result(bundle.getString("email"), null));
            return;

        case 0: // '\0'
            callback.failure(new TwitterException(bundle.getString("msg")));
            return;

        case 1: // '\001'
            callback.failure((TwitterException)bundle.getSerializable("error"));
            return;
        }
        throw new IllegalArgumentException((new StringBuilder("Invalid result code ")).append(i).toString());
    }
}
