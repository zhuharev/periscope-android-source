// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager, LocalyticsDao

class nit> extends InAppCallable
{

    final InAppManager this$0;

    Object call(Object aobj[])
    {
        int i = ((Integer)aobj[0]).intValue();
        aobj = (String)aobj[1];
        mLocalyticsDao.setCustomDimension(i, ((String) (aobj)));
        return null;
    }

    ()
    {
        this$0 = InAppManager.this;
        super();
    }
}
