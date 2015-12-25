// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            BaseHandler

class val.customerId
    implements Runnable
{

    final BaseHandler this$0;
    final Boolean val$adjustMaxRowToUpload;
    final String val$customerId;

    public void run()
    {
        _upload(val$adjustMaxRowToUpload.booleanValue(), val$customerId);
    }

    ()
    {
        this$0 = final_basehandler;
        val$adjustMaxRowToUpload = boolean1;
        val$customerId = String.this;
        super();
    }
}
