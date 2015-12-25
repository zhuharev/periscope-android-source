// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            DigitsActivityDelegate, DigitsController, StateButton

abstract class DigitsActivityDelegateImpl
    implements DigitsActivityDelegate
{

    DigitsActivityDelegateImpl()
    {
    }

    protected String getFormattedTerms(Activity activity, int i)
    {
        return activity.getString(i, new Object[] {
            "\""
        });
    }

    public void onActivityResult(int i, int j, Activity activity)
    {
    }

    public void onDestroy()
    {
    }

    public void setUpEditText(final Activity activity, final DigitsController controller, EditText edittext)
    {
        edittext.setOnEditorActionListener(new _cls2());
        edittext.addTextChangedListener(controller.getTextWatcher());
    }

    public void setUpSendButton(final Activity activity, final DigitsController controller, StateButton statebutton)
    {
        statebutton.setOnClickListener(new _cls1());
    }

    public void setUpTermsText(final Activity activity, final DigitsController controller, TextView textview)
    {
        textview.setOnClickListener(new _cls3());
    }

    private class _cls2
        implements android.widget.TextView.OnEditorActionListener
    {

        final DigitsActivityDelegateImpl this$0;
        final Activity val$activity;
        final DigitsController val$controller;

        public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
        {
            if (i == 5)
            {
                controller.clearError();
                controller.executeRequest(activity);
                return true;
            } else
            {
                return false;
            }
        }

        _cls2()
        {
            this$0 = DigitsActivityDelegateImpl.this;
            controller = digitscontroller;
            activity = activity1;
            super();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final DigitsActivityDelegateImpl this$0;
        final Activity val$activity;
        final DigitsController val$controller;

        public void onClick(View view)
        {
            controller.clearError();
            controller.executeRequest(activity);
        }

        _cls1()
        {
            this$0 = DigitsActivityDelegateImpl.this;
            controller = digitscontroller;
            activity = activity1;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final DigitsActivityDelegateImpl this$0;
        final Activity val$activity;
        final DigitsController val$controller;

        public void onClick(View view)
        {
            controller.clearError();
            controller.showTOS(activity);
        }

        _cls3()
        {
            this$0 = DigitsActivityDelegateImpl.this;
            controller = digitscontroller;
            activity = activity1;
            super();
        }
    }

}
