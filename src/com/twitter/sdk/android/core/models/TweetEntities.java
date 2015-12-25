// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

public class TweetEntities
{

    public final List hashtags;
    public final List media;
    public final List urls;
    public final List userMentions;

    public TweetEntities(List list, List list1, List list2, List list3)
    {
        urls = getSafeList(list);
        userMentions = getSafeList(list1);
        media = getSafeList(list2);
        hashtags = getSafeList(list3);
    }

    private List getSafeList(List list)
    {
        if (list == null)
        {
            return Collections.EMPTY_LIST;
        } else
        {
            return Collections.unmodifiableList(list);
        }
    }
}
