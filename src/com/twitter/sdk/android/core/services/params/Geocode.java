// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services.params;


public class Geocode
{
    public static final class Distance extends Enum
    {

        private static final Distance $VALUES[];
        public static final Distance KILOMETERS;
        public static final Distance MILES;
        public final String identifier;

        public static Distance valueOf(String s)
        {
            return (Distance)Enum.valueOf(com/twitter/sdk/android/core/services/params/Geocode$Distance, s);
        }

        public static Distance[] values()
        {
            return (Distance[])$VALUES.clone();
        }

        static 
        {
            MILES = new Distance("MILES", 0, "mi");
            KILOMETERS = new Distance("KILOMETERS", 1, "km");
            $VALUES = (new Distance[] {
                MILES, KILOMETERS
            });
        }

        private Distance(String s, int i, String s1)
        {
            super(s, i);
            identifier = s1;
        }
    }


    public final Distance distance;
    public final double latitude;
    public final double longitude;
    public final int radius;

    public Geocode(double d, double d1, int i, Distance distance1)
    {
        latitude = d;
        longitude = d1;
        radius = i;
        distance = distance1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(latitude).append(",").append(longitude).append(",").append(radius).append(distance.identifier).toString();
    }
}
