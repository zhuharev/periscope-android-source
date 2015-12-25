// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            DigitsController, DigitsActivityDelegateImpl

class val.activity
    implements android.widget.er
{

    final DigitsActivityDelegateImpl this$0;
    final Activity val$activity;
    final DigitsController val$controller;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 5)
        {
            val$controller.clearError();
            val$controller.executeRequest(val$activity);
            return true;
        } else
        {
            return false;
        }
    }

    _cls9()
    {
        this$0 = final_digitsactivitydelegateimpl;
        val$controller = digitscontroller;
        val$activity = Activity.this;
        super();
    }
}
