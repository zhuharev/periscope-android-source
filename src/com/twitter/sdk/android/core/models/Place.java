// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.List;
import java.util.Map;

public class Place
{
    public static class BoundingBox
    {

        public final List coordinates;
        public final String type;

        public BoundingBox(List list, String s)
        {
            coordinates = list;
            type = s;
        }
    }


    public final Map attributes;
    public final BoundingBox boundingBox;
    public final String country;
    public final String countryCode;
    public final String fullName;
    public final String id;
    public final String name;
    public final String placeType;
    public final String url;

    public Place(Map map, BoundingBox boundingbox, String s, String s1, String s2, String s3, String s4, 
            String s5, String s6)
    {
        attributes = map;
        boundingBox = boundingbox;
        country = s;
        countryCode = s1;
        fullName = s2;
        id = s3;
        name = s4;
        placeType = s5;
        url = s6;
    }
}
