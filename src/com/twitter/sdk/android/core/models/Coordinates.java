// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.ArrayList;
import java.util.List;

public class Coordinates
{

    public static final int INDEX_LATITUDE = 1;
    public static final int INDEX_LONGITUDE = 0;
    public final List coordinates;
    public final String type;

    public Coordinates(Double double1, Double double2, String s)
    {
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(0, double1);
        arraylist.add(1, double2);
        coordinates = arraylist;
        type = s;
    }

    public Double getLatitude()
    {
        return (Double)coordinates.get(1);
    }

    public Double getLongitude()
    {
        return (Double)coordinates.get(0);
    }
}
