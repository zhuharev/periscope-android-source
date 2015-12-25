// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import com.twitter.sdk.android.core.TwitterCore;
import java.util.List;
import o.si;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            DefaultScribeClient

public class TwitterCoreScribeClientHolder
{

    private static final String KIT_NAME = "TwitterCore";
    private static DefaultScribeClient instance;

    public TwitterCoreScribeClientHolder()
    {
    }

    public static DefaultScribeClient getScribeClient()
    {
        return instance;
    }

    public static void initialize(TwitterCore twittercore, List list, si si)
    {
        instance = new DefaultScribeClient(twittercore, "TwitterCore", list, si);
    }
}
