// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.widget.Toast;

// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager, LocalyticsDao, DatapointHelper

class nit> extends InAppCallable
{

    final InAppManager this$0;
    final Context val$appContext;

    Object call(Object aobj[])
    {
        aobj = mLocalyticsDao.getInstallationId();
        if (!TextUtils.isEmpty(((CharSequence) (aobj))))
        {
            if (DatapointHelper.getApiLevel() < 11)
            {
                ((ClipboardManager)val$appContext.getSystemService("clipboard")).setText(((CharSequence) (aobj)));
            } else
            {
                ((android.content.ClipboardManager)val$appContext.getSystemService("clipboard")).setText(((CharSequence) (aobj)));
            }
            Toast.makeText(val$appContext, (new StringBuilder()).append(((String) (aobj))).append(" has been copied to the clipboard.").toString(), 1).show();
        } else
        {
            Toast.makeText(val$appContext, "No install id found. Please check your integration.", 1).show();
        }
        return null;
    }

    ()
    {
        this$0 = final_inappmanager;
        val$appContext = Context.this;
        super();
    }
}
