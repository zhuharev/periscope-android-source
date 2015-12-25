// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.os.AsyncTask;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.widget.Toast;

// Referenced classes of package com.localytics.android:
//            InAppManager, LocalyticsDao, DatapointHelper

class this._cls1 extends AsyncTask
{

    final l.appContext this$1;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return mLocalyticsDao.getPushRegistrationId();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (DatapointHelper.getApiLevel() < 11)
            {
                ((ClipboardManager)appContext.getSystemService("clipboard")).setText(s);
            } else
            {
                ((android.content.ClipboardManager)appContext.getSystemService("clipboard")).setText(s);
            }
            Toast.makeText(appContext, (new StringBuilder()).append(s).append(" has been copied to the clipboard.").toString(), 1).show();
            return;
        } else
        {
            Toast.makeText(appContext, "No push token found. Please check your integration.", 1).show();
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
