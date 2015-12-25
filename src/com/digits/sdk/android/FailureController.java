// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.os.ResultReceiver;

interface FailureController
{

    public abstract void sendFailure(ResultReceiver resultreceiver, Exception exception);

    public abstract void tryAnotherNumber(Activity activity, ResultReceiver resultreceiver);
}
