// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            InAppMessagesAdapter, InAppManager, MarketingMessage

class this._cls0
    implements Callable
{

    final InAppMessagesAdapter this$0;

    public Boolean call()
    {
        boolean flag = false;
        MarketingMessage marketingmessage;
        for (Iterator iterator = InAppMessagesAdapter.access$000(InAppMessagesAdapter.this).getInAppMessages().iterator(); iterator.hasNext(); InAppMessagesAdapter.access$100(InAppMessagesAdapter.this).add(marketingmessage))
        {
            marketingmessage = (MarketingMessage)iterator.next();
            flag = true;
        }

        return Boolean.valueOf(flag);
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = InAppMessagesAdapter.this;
        super();
    }
}
