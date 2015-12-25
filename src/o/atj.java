// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atw

final class atj extends atw
{

    private final String city;
    private final String country;
    private final String countryState;

    atj(String s, String s1, String s2)
    {
        country = s;
        city = s1;
        countryState = s2;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atw)
        {
            obj = (atw)obj;
            return (country != null ? country.equals(((atw) (obj)).gb()) : ((atw) (obj)).gb() == null) && (city != null ? city.equals(((atw) (obj)).gd()) : ((atw) (obj)).gd() == null) && (countryState != null ? countryState.equals(((atw) (obj)).ge()) : ((atw) (obj)).ge() == null);
        } else
        {
            return false;
        }
    }

    public final String gb()
    {
        return country;
    }

    public final String gd()
    {
        return city;
    }

    public final String ge()
    {
        return countryState;
    }

    public final int hashCode()
    {
        int i;
        if (country == null)
        {
            i = 0;
        } else
        {
            i = country.hashCode();
        }
        int j;
        if (city == null)
        {
            j = 0;
        } else
        {
            j = city.hashCode();
        }
        int k;
        if (countryState == null)
        {
            k = 0;
        } else
        {
            k = countryState.hashCode();
        }
        return ((i ^ 0xf4243) * 0xf4243 ^ j) * 0xf4243 ^ k;
    }
}
