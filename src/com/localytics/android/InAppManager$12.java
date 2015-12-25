// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import o.1427;

// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppMessagesAdapter, InAppManager, TestModeListView

class nit> extends InAppCallable
{

    final InAppManager this$0;
    final InAppMessagesAdapter val$adapter;
    final TestModeListView val$listView;

    Object call(Object aobj[])
    {
        val$adapter.updateDataSet();
        val$listView.show(InAppManager.access$000(InAppManager.this), "marketing_test_mode_list");
        InAppManager.access$000(InAppManager.this).executePendingTransactions();
        return null;
    }

    ()
    {
        this$0 = final_inappmanager;
        val$adapter = inappmessagesadapter;
        val$listView = TestModeListView.this;
        super();
    }
}
