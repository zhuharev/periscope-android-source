// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

// Referenced classes of package com.digits.sdk.android:
//            FailureController, Digits, ActivityClassManager

class FailureControllerImpl
    implements FailureController
{

    final ActivityClassManager classManager;

    public FailureControllerImpl()
    {
        this(Digits.getInstance().getActivityClassManager());
    }

    public FailureControllerImpl(ActivityClassManager activityclassmanager)
    {
        classManager = activityclassmanager;
    }

    int getFlags()
    {
        return android.os.Build.VERSION.SDK_INT < 11 ? 0x14000000 : 0x10008000;
    }

    public void sendFailure(ResultReceiver resultreceiver, Exception exception)
    {
        Bundle bundle = new Bundle();
        bundle.putString("login_error", exception.getLocalizedMessage());
        resultreceiver.send(400, bundle);
    }

    public void tryAnotherNumber(Activity activity, ResultReceiver resultreceiver)
    {
        Intent intent = new Intent(activity, classManager.getPhoneNumberActivity());
        Bundle bundle = new Bundle();
        bundle.putParcelable("receiver", resultreceiver);
        intent.putExtras(bundle);
        intent.setFlags(getFlags());
        activity.startActivity(intent);
    }
}
