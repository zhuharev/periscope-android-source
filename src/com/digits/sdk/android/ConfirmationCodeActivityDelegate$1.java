// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.digits.sdk.android:
//            ConfirmationCodeActivityDelegate

class val.activity
    implements android.view.elegate._cls1
{

    final ConfirmationCodeActivityDelegate this$0;
    final Activity val$activity;

    public void onClick(View view)
    {
        val$activity.setResult(300);
        val$activity.finish();
    }

    ()
    {
        this$0 = final_confirmationcodeactivitydelegate;
        val$activity = Activity.this;
        super();
    }
}
