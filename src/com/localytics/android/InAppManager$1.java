// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.localytics.android:
//            InAppManager, InAppMessagesAdapter

class apter extends Thread
{

    final InAppManager this$0;
    final InAppMessagesAdapter val$adapter;

    public void run()
    {
        class _cls1
            implements Runnable
        {

            final InAppManager._cls1 this$1;

            public void run()
            {
                adapter.updateDataSet();
                adapter.notifyDataSetChanged();
            }

            _cls1()
            {
                this$1 = InAppManager._cls1.this;
                super();
            }
        }

        (new Handler(Looper.getMainLooper())).post(new _cls1());
    }

    apter()
    {
        this$0 = final_inappmanager;
        val$adapter = InAppMessagesAdapter.this;
        super();
    }
}
