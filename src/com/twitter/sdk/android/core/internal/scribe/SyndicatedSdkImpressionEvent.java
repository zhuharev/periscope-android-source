// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeEvent, EventNamespace

public class SyndicatedSdkImpressionEvent extends ScribeEvent
{
    public class ExternalIds
    {

        public final String adId;
        final SyndicatedSdkImpressionEvent this$0;

        public ExternalIds(String s)
        {
            this$0 = SyndicatedSdkImpressionEvent.this;
            super();
            adId = s;
        }
    }


    public static final String CLIENT_NAME = "android";
    private static final String SCRIBE_CATEGORY = "syndicated_sdk_impression";
    public final long deviceIdCreatedAt;
    public final ExternalIds externalIds;
    public final String language;

    public SyndicatedSdkImpressionEvent(EventNamespace eventnamespace, long l, String s, String s1)
    {
        this(eventnamespace, l, s, s1, Collections.emptyList());
    }

    public SyndicatedSdkImpressionEvent(EventNamespace eventnamespace, long l, String s, String s1, List list)
    {
        super("syndicated_sdk_impression", eventnamespace, l, list);
        language = s;
        externalIds = new ExternalIds(s1);
        deviceIdCreatedAt = 0L;
    }
}
