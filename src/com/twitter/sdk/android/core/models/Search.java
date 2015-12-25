// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.List;

// Referenced classes of package com.twitter.sdk.android.core.models:
//            SearchMetadata

public class Search
{

    public final SearchMetadata searchMetadata;
    public final List tweets;

    public Search(List list, SearchMetadata searchmetadata)
    {
        tweets = list;
        searchMetadata = searchmetadata;
    }
}
