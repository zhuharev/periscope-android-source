// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


// Referenced classes of package com.twitter.sdk.android.core.models:
//            Entity

public class UrlEntity extends Entity
{

    public final String displayUrl;
    public final String expandedUrl;
    public final String url;

    public UrlEntity(String s, String s1, String s2, int i, int j)
    {
        super(i, j);
        url = s;
        expandedUrl = s1;
        displayUrl = s2;
    }

    public volatile int getEnd()
    {
        return super.getEnd();
    }

    public volatile int getStart()
    {
        return super.getStart();
    }
}
