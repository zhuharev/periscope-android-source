// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Map;

// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager, LocalyticsDao

class init> extends InAppCallable
{

    final InAppManager this$0;

    public Object call(Object aobj[])
    {
        String s = (String)aobj[0];
        aobj = (Map)aobj[1];
        mLocalyticsDao.tagEvent(s, ((Map) (aobj)));
        return null;
    }

    ()
    {
        this$0 = InAppManager.this;
        super();
    }
}
