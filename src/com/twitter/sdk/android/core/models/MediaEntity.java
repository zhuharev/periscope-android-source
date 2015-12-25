// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


// Referenced classes of package com.twitter.sdk.android.core.models:
//            UrlEntity

public class MediaEntity extends UrlEntity
{
    public static class Size
    {

        public final int h;
        public final String resize;
        public final int w;

        public Size(int i, int j, String s)
        {
            w = i;
            h = j;
            resize = s;
        }
    }

    public static class Sizes
    {

        public final Size large;
        public final Size medium;
        public final Size small;
        public final Size thumb;

        public Sizes(Size size, Size size1, Size size2, Size size3)
        {
            thumb = size;
            small = size1;
            medium = size2;
            large = size3;
        }
    }


    public final long id;
    public final String idStr;
    public final String mediaUrl;
    public final String mediaUrlHttps;
    public final Sizes sizes;
    public final long sourceStatusId;
    public final String sourceStatusIdStr;
    public final String type;

    public MediaEntity(String s, String s1, String s2, int i, int j, long l, 
            String s3, String s4, String s5, Sizes sizes1, long l1, String s6, 
            String s7)
    {
        super(s, s1, s2, i, j);
        id = l;
        idStr = s3;
        mediaUrl = s4;
        mediaUrlHttps = s5;
        sizes = sizes1;
        sourceStatusId = l1;
        sourceStatusIdStr = s6;
        type = s7;
    }
}
