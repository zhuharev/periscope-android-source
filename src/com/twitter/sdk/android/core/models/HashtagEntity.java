// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


// Referenced classes of package com.twitter.sdk.android.core.models:
//            Entity

public class HashtagEntity extends Entity
{

    public final String text;

    public HashtagEntity(String s, int i, int j)
    {
        super(i, j);
        text = s;
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
