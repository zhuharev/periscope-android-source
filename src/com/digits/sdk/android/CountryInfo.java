// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import java.text.Collator;
import java.util.Locale;

class CountryInfo
    implements Comparable
{

    private final Collator collator = Collator.getInstance(Locale.getDefault());
    public final String country;
    public final int countryCode;

    public CountryInfo(String s, int i)
    {
        collator.setStrength(0);
        country = s;
        countryCode = i;
    }

    public int compareTo(CountryInfo countryinfo)
    {
        return collator.compare(country, countryinfo.country);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CountryInfo)obj);
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (CountryInfo)obj;
        return countryCode == ((CountryInfo) (obj)).countryCode && (country == null ? ((CountryInfo) (obj)).country == null : country.equals(((CountryInfo) (obj)).country));
    }

    public int hashCode()
    {
        int i;
        if (country != null)
        {
            i = country.hashCode();
        } else
        {
            i = 0;
        }
        return i * 31 + countryCode;
    }

    public String toString()
    {
        return (new StringBuilder()).append(country).append(" +").append(countryCode).toString();
    }
}
