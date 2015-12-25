// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import o.1427;

// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager, TestModeButton

class nit> extends InAppCallable
{

    final InAppManager this$0;
    final TestModeButton val$button;

    Object call(Object aobj[])
    {
        val$button.show(InAppManager.access$000(InAppManager.this), "marketing_test_mode_button");
        InAppManager.access$000(InAppManager.this).executePendingTransactions();
        return null;
    }

    ()
    {
        this$0 = final_inappmanager;
        val$button = TestModeButton.this;
        super();
    }
}
