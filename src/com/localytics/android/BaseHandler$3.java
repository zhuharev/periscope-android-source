// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            BaseHandler

class val.responseString
    implements Runnable
{

    final BaseHandler this$0;
    final String val$responseString;
    final int val$rowsToDelete;

    public void run()
    {
        _uploadCallback(val$rowsToDelete, val$responseString);
    }

    ()
    {
        this$0 = final_basehandler;
        val$rowsToDelete = i;
        val$responseString = String.this;
        super();
    }
}
