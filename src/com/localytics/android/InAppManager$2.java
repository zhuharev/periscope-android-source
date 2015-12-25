// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.util.SparseArray;
import o.1427;

// Referenced classes of package com.localytics.android:
//            InAppManager, MarketingMessage, LocalyticsManager

class val.jsCallbacks
    implements Runnable
{

    final InAppManager this$0;
    final MarketingMessage val$inAppMessage;
    final SparseArray val$jsCallbacks;

    public void run()
    {
        if (InAppManager.access$000(InAppManager.this) == null)
        {
            return;
        }
        android.support.v4.app.Fragment fragment = InAppManager.access$000(InAppManager.this).findFragmentByTag("marketing_dialog");
        if (fragment != null)
        {
            return;
        }
        try
        {
            if (!InAppManager.access$100(InAppManager.this))
            {
                InAppManager.access$102(InAppManager.this, true);
                class _cls1 extends AsyncTask
                {

                    final InAppManager._cls2 this$1;
                    final int val$campaignId;

                    protected transient Boolean doInBackground(Void avoid[])
                    {
                        return Boolean.valueOf(InAppManager.access$200(this$0).setInAppAsDisplayed(campaignId));
                    }

                    protected volatile Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected void onPostExecute(Boolean boolean1)
                    {
                        if (boolean1.booleanValue())
                        {
                            if (InAppManager.access$000(this$0) != null)
                            {
                                InAppDialogFragment.newInstance().setData(inAppMessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(jsCallbacks)).show(InAppManager.access$000(this$0), "marketing_dialog");
                                if (!Constants.isTestModeEnabled())
                                {
                                    ((MessagingListener)InAppManager.access$200(this$0).listeners).localyticsWillDisplayInAppMessage();
                                }
                                InAppManager.access$000(this$0).executePendingTransactions();
                            } else
                            {
                                InAppManager.access$200(this$0).setInAppMessageAsNotDisplayed(campaignId);
                            }
                        }
                        InAppManager.access$102(this$0, false);
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Boolean)obj);
                    }

            _cls1()
            {
                this$1 = InAppManager._cls2.this;
                campaignId = i;
                super();
            }
                }

                (new _cls1()).execute(new Void[0]);
            }
            return;
        }
        catch (Exception exception)
        {
            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", exception);
        }
        return;
    }

    e()
    {
        this$0 = final_inappmanager;
        val$inAppMessage = marketingmessage;
        val$jsCallbacks = SparseArray.this;
        super();
    }
}
