// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


// Referenced classes of package com.twitter.sdk.android.core.models:
//            Entity

public class MentionEntity extends Entity
{

    public final long id;
    public final String idStr;
    public final String name;
    public final String screenName;

    public MentionEntity(long l, String s, String s1, String s2, int i, int j)
    {
        super(i, j);
        id = l;
        idStr = s;
        name = s1;
        screenName = s2;
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
