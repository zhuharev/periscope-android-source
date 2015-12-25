// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            FailureActivityDelegate, FailureControllerImpl, DigitsException, BundleManager, 
//            FailureController

class FailureActivityDelegateImpl
    implements FailureActivityDelegate
{

    final Activity activity;
    final FailureController controller;

    public FailureActivityDelegateImpl(Activity activity1)
    {
        this(activity1, ((FailureController) (new FailureControllerImpl())));
    }

    public FailureActivityDelegateImpl(Activity activity1, FailureController failurecontroller)
    {
        activity = activity1;
        controller = failurecontroller;
    }

    private DigitsException getBundleException()
    {
        return (DigitsException)activity.getIntent().getExtras().getSerializable("fallback_reason");
    }

    private ResultReceiver getBundleResultReceiver()
    {
        return (ResultReceiver)activity.getIntent().getExtras().getParcelable("receiver");
    }

    public void init()
    {
        if (isBundleValid(activity.getIntent().getExtras()))
        {
            setContentView();
            setUpViews();
            return;
        } else
        {
            throw new IllegalAccessError("This activity can only be started from Digits");
        }
    }

    protected boolean isBundleValid(Bundle bundle)
    {
        return BundleManager.assertContains(bundle, new String[] {
            "receiver"
        });
    }

    protected void setContentView()
    {
        activity.setContentView(R.layout.dgts__activity_failure);
    }

    protected void setUpDismissButton(Button button)
    {
        button.setOnClickListener(new _cls1());
    }

    protected void setUpTryAnotherPhoneButton(TextView textview)
    {
        textview.setOnClickListener(new _cls2());
    }

    protected void setUpViews()
    {
        Button button = (Button)activity.findViewById(R.id.dgts__dismiss_button);
        TextView textview = (TextView)activity.findViewById(R.id.dgts__try_another_phone);
        setUpDismissButton(button);
        setUpTryAnotherPhoneButton(textview);
    }



    private class _cls1
        implements android.view.View.OnClickListener
    {

        final FailureActivityDelegateImpl this$0;

        public void onClick(View view)
        {
            rz._mth02CB(activity, 200);
            controller.sendFailure(getBundleResultReceiver(), getBundleException());
        }

        _cls1()
        {
            this$0 = FailureActivityDelegateImpl.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final FailureActivityDelegateImpl this$0;

        public void onClick(View view)
        {
            controller.tryAnotherNumber(activity, getBundleResultReceiver());
            activity.finish();
        }

        _cls2()
        {
            this$0 = FailureActivityDelegateImpl.this;
            super();
        }
    }

}
