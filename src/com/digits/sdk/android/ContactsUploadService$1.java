// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.digits.sdk.android:
//            ContactsUploadService, ContactsClient, Vcards

public class val.successCount
    implements Runnable
{

    final ContactsUploadService this$0;
    final AtomicInteger val$successCount;
    final Vcards val$vCards;

    public void run()
    {
        ContactsUploadService.access$000(ContactsUploadService.this).uploadContacts(val$vCards);
        val$successCount.addAndGet(val$vCards.vcards.size());
    }

    ()
    {
        this$0 = final_contactsuploadservice;
        val$vCards = vcards;
        val$successCount = AtomicInteger.this;
        super();
    }
}
