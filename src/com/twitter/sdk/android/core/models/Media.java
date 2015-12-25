// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


// Referenced classes of package com.twitter.sdk.android.core.models:
//            Image

public class Media
{

    public final Image image;
    public final long mediaId;
    public final String mediaIdString;
    public final long size;

    public Media(long l, String s, long l1, Image image1)
    {
        mediaId = l;
        mediaIdString = s;
        size = l1;
        image = image1;
    }
}
