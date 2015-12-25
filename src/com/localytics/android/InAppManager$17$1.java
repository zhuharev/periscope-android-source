// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.AsyncTask;
import android.util.SparseArray;
import android.widget.Toast;
import o.1427;

// Referenced classes of package com.localytics.android:
//            InAppManager, MarketingMessage, InAppDialogFragment, JavaScriptClient, 
//            LocalyticsManager

class val.marketingMessage extends AsyncTask
{

    final l.appContext this$1;
    final MarketingMessage val$marketingMessage;

    protected volatile Object doInBackground(Object aobj[])
    {
        return ((Object) (doInBackground((MarketingMessage[])aobj)));
    }

    protected transient Object[] doInBackground(MarketingMessage amarketingmessage[])
    {
        if (InAppManager.access$700(_fld0, amarketingmessage[0]))
        {
            amarketingmessage = amarketingmessage[0];
        } else
        {
            amarketingmessage = null;
        }
        return (new Object[] {
            amarketingmessage, InAppManager.access$800(_fld0, null)
        });
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Object[])obj);
    }

    protected void onPostExecute(Object aobj[])
    {
        MarketingMessage marketingmessage = (MarketingMessage)aobj[0];
        aobj = (SparseArray)aobj[1];
        if (marketingmessage == null)
        {
            Object obj;
            try
            {
                Toast.makeText(appContext, "The downloaded campaign file is broken.", 0).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", ((Exception) (aobj)));
            }
            break MISSING_BLOCK_LABEL_185;
        }
        if (InAppManager.access$000(_fld0) == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        obj = InAppManager.access$000(_fld0).findFragmentByTag((new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        return;
        obj = InAppDialogFragment.newInstance();
        ((InAppDialogFragment) (obj)).setRetainInstance(false);
        ((InAppDialogFragment) (obj)).setData(marketingmessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(((SparseArray) (aobj)))).show(InAppManager.access$000(_fld0), (new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString());
        InAppManager.access$000(_fld0).executePendingTransactions();
        return;
    }

    protected void onPreExecute()
    {
        int i = ((Integer)val$marketingMessage.get("_id")).intValue();
        boolean flag = InAppManager.access$500(_fld0, val$marketingMessage).endsWith(".zip");
        if (!InAppManager.access$600(_fld0, i, flag))
        {
            Toast.makeText(appContext, "Downloading the campaign...\nIt'll be shown in few seconds.", 0).show();
        }
    }

    t()
    {
        this$1 = final_t;
        val$marketingMessage = MarketingMessage.this;
        super();
    }
}
