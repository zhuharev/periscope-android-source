// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.AsyncTask;
import o.1427;

// Referenced classes of package com.localytics.android:
//            InAppManager, MarketingHandler, InAppDialogFragment, JavaScriptClient, 
//            Constants, MessagingListener

class val.campaignId extends AsyncTask
{

    final onPostExecute this$1;
    final int val$campaignId;

    protected transient Boolean doInBackground(Void avoid[])
    {
        return Boolean.valueOf(InAppManager.access$200(_fld0).setInAppAsDisplayed(val$campaignId));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            if (InAppManager.access$000(_fld0) != null)
            {
                InAppDialogFragment.newInstance().setData(inAppMessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(jsCallbacks)).show(InAppManager.access$000(_fld0), "marketing_dialog");
                if (!Constants.isTestModeEnabled())
                {
                    ((MessagingListener)InAppManager.access$200(_fld0).listeners).localyticsWillDisplayInAppMessage();
                }
                InAppManager.access$000(_fld0).executePendingTransactions();
            } else
            {
                InAppManager.access$200(_fld0).setInAppMessageAsNotDisplayed(val$campaignId);
            }
        }
        InAppManager.access$102(_fld0, false);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    ()
    {
        this$1 = final_;
        val$campaignId = I.this;
        super();
    }
}
