// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;


// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeItem

static class 
{

    private String description;
    private Long id;
    private Integer itemType;

    ScribeItem build()
    {
        return new ScribeItem(itemType, id, description, null);
    }

    public description setDescription(String s)
    {
        description = s;
        return this;
    }

    public description setId(long l)
    {
        id = Long.valueOf(l);
        return this;
    }

    public id setItemType(int i)
    {
        itemType = Integer.valueOf(i);
        return this;
    }

    ()
    {
    }
}
