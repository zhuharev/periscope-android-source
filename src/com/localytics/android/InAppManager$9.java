// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            InAppCallable, InAppManager

class init> extends InAppCallable
{

    final InAppManager this$0;
    final JSONObject val$jsonCustomDimensions;

    Object call(Object aobj[])
    {
        return val$jsonCustomDimensions.toString();
    }

    ()
    {
        this$0 = final_inappmanager;
        val$jsonCustomDimensions = JSONObject.this;
        super();
    }
}
