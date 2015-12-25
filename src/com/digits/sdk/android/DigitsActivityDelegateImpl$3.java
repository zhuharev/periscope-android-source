// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.digits.sdk.android:
//            DigitsController, DigitsActivityDelegateImpl

class val.activity
    implements android.view.ateImpl._cls3
{

    final DigitsActivityDelegateImpl this$0;
    final Activity val$activity;
    final DigitsController val$controller;

    public void onClick(View view)
    {
        val$controller.clearError();
        val$controller.showTOS(val$activity);
    }

    _cls9()
    {
        this$0 = final_digitsactivitydelegateimpl;
        val$controller = digitscontroller;
        val$activity = Activity.this;
        super();
    }
}
