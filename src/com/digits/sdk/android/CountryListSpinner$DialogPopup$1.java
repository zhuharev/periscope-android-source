// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.widget.ListView;

class val.selected
    implements Runnable
{

    final val.selected this$1;
    final ListView val$listView;
    final int val$selected;

    public void run()
    {
        val$listView.setSelection(val$selected);
    }

    ()
    {
        this$1 = final_;
        val$listView = listview;
        val$selected = I.this;
        super();
    }
}
