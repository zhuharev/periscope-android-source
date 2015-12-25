// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterException;
import java.lang.ref.WeakReference;
import o.ra;
import o.rl;

// Referenced classes of package com.digits.sdk.android:
//            DigitsController, DigitsException

public abstract class DigitsCallback extends Callback
{

    private final WeakReference context;
    final DigitsController controller;

    DigitsCallback(Context context1, DigitsController digitscontroller)
    {
        context = new WeakReference(context1);
        controller = digitscontroller;
    }

    public void failure(TwitterException twitterexception)
    {
        DigitsException digitsexception = DigitsException.create(controller.getErrors(), twitterexception);
        ra._mth0454()._mth02CA("Digits", (new StringBuilder("HTTP Error: ")).append(twitterexception.getMessage()).append(", API Error: ").append(digitsexception.getErrorCode()).append(", User Message: ").append(digitsexception.getMessage()).toString());
        controller.handleError((Context)context.get(), digitsexception);
    }
}
