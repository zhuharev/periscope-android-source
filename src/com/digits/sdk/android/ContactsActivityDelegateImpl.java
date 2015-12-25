// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.digits.sdk.android:
//            ContactsActivityDelegate, ContactsControllerImpl, ContactsController

class ContactsActivityDelegateImpl
    implements ContactsActivityDelegate
{

    final Activity activity;
    final ContactsController controller;

    public ContactsActivityDelegateImpl(Activity activity1)
    {
        this(activity1, ((ContactsController) (new ContactsControllerImpl())));
    }

    public ContactsActivityDelegateImpl(Activity activity1, ContactsController contactscontroller)
    {
        activity = activity1;
        controller = contactscontroller;
    }

    protected String getApplicationName()
    {
        return activity.getApplicationInfo().loadLabel(activity.getPackageManager()).toString();
    }

    protected String getFormattedDescription()
    {
        return activity.getString(R.string.dgts__upload_contacts, new Object[] {
            getApplicationName()
        });
    }

    public void init()
    {
        setContentView();
        setUpViews();
    }

    protected void setContentView()
    {
        activity.setContentView(R.layout.dgts__activity_contacts);
    }

    protected void setUpDescription(TextView textview)
    {
        textview.setText(getFormattedDescription());
    }

    protected void setUpNotNowButton(Button button)
    {
        button.setOnClickListener(new _cls1());
    }

    protected void setUpOkayButton(Button button)
    {
        button.setOnClickListener(new _cls2());
    }

    protected void setUpViews()
    {
        Button button = (Button)activity.findViewById(R.id.dgts__not_now);
        Button button1 = (Button)activity.findViewById(R.id.dgts__okay);
        TextView textview = (TextView)activity.findViewById(R.id.dgts__upload_contacts);
        setUpNotNowButton(button);
        setUpOkayButton(button1);
        setUpDescription(textview);
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final ContactsActivityDelegateImpl this$0;

        public void onClick(View view)
        {
            activity.finish();
        }

        _cls1()
        {
            this$0 = ContactsActivityDelegateImpl.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final ContactsActivityDelegateImpl this$0;

        public void onClick(View view)
        {
            controller.startUploadService(activity);
            activity.finish();
        }

        _cls2()
        {
            this$0 = ContactsActivityDelegateImpl.this;
            super();
        }
    }

}
