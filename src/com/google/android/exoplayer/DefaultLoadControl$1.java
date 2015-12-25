// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            DefaultLoadControl

class val.loading
    implements Runnable
{

    final DefaultLoadControl this$0;
    final boolean val$loading;

    public void run()
    {
        DefaultLoadControl.access$000(DefaultLoadControl.this).onLoadingChanged(val$loading);
    }

    entListener()
    {
        this$0 = final_defaultloadcontrol;
        val$loading = Z.this;
        super();
    }
}
