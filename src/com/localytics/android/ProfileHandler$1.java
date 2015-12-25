// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            ProfileHandler

class val.customerID
    implements Runnable
{

    final ProfileHandler this$0;
    final String val$attribute;
    final String val$customerID;
    final String val$database;

    public void run()
    {
        ProfileHandler.access$100(ProfileHandler.this, val$attribute, val$database, val$customerID);
    }

    ()
    {
        this$0 = final_profilehandler;
        val$attribute = s;
        val$database = s1;
        val$customerID = String.this;
        super();
    }
}
