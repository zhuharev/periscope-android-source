// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;

// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager

class nit> extends InAppCallable
{

    final InAppManager this$0;
    final Context val$appContext;

    Object call(Object aobj[])
    {
        class _cls1 extends AsyncTask
        {

            final InAppManager._cls15 this$1;

            protected volatile Object doInBackground(Object aobj1[])
            {
                return doInBackground((Void[])aobj1);
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

            _cls1()
            {
                this$1 = InAppManager._cls15.this;
                super();
            }
        }

        (new _cls1()).execute(new Void[0]);
        return null;
    }

    _cls1()
    {
        this$0 = final_inappmanager;
        val$appContext = Context.this;
        super();
    }
}
