// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.digits.sdk.android:
//            CountryInfo

class CountryListAdapter extends ArrayAdapter
    implements SectionIndexer
{

    private final HashMap alphaIndex = new LinkedHashMap();
    private final HashMap countryPosition = new LinkedHashMap();
    private String sections[];

    public CountryListAdapter(Context context)
    {
        super(context, R.layout.dgts__country_row, 0x1020014);
    }

    public int getPositionForCountry(String s)
    {
        s = (Integer)countryPosition.get(s);
        if (s == null)
        {
            return 0;
        } else
        {
            return s.intValue();
        }
    }

    public int getPositionForSection(int i)
    {
        if (sections == null)
        {
            return 0;
        }
        if (i <= 0)
        {
            return 0;
        }
        int j = i;
        if (i >= sections.length)
        {
            j = sections.length - 1;
        }
        return ((Integer)alphaIndex.get(sections[j])).intValue();
    }

    public int getSectionForPosition(int i)
    {
        return 0;
    }

    public Object[] getSections()
    {
        return sections;
    }

    public void setData(List list)
    {
        int i = 0;
        CountryInfo countryinfo;
        for (list = list.iterator(); list.hasNext(); add(countryinfo))
        {
            countryinfo = (CountryInfo)list.next();
            String s = countryinfo.country.substring(0, 1).toUpperCase(Locale.getDefault());
            if (!alphaIndex.containsKey(s))
            {
                alphaIndex.put(s, Integer.valueOf(i));
            }
            countryPosition.put(countryinfo.country, Integer.valueOf(i));
            i++;
        }

        sections = new String[alphaIndex.size()];
        alphaIndex.keySet().toArray(sections);
        notifyDataSetChanged();
    }
}
