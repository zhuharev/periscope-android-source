// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package o:
//            acm, acl, ada

public final class abb
{

    private final SharedPreferences aQC;
    private final acm mSettingsStore;

    private abb(SharedPreferences sharedpreferences, acm acm1)
    {
        aQC = sharedpreferences;
        mSettingsStore = acm1;
    }

    public abb(ada ada)
    {
        this(PreferenceManager.getDefaultSharedPreferences(ada), new acm(ada));
    }

    public final void _mth02BB(String as[])
    {
        HashSet hashset = new HashSet();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            hashset.add(as[i]);
        }

        as = Locale.getDefault().getLanguage();
        Set set = aQC.getStringSet((String)yp.CON._mth02CA("o.yp").getField("aVS").get(null), null);
        if (set == null || hashset.size() != set.size() || !hashset.containsAll(set))
        {
            if (hashset.contains(as))
            {
                acl acl1 = mSettingsStore.aH();
                if (acl1.bdk.contains("other") && !acl1.bdk.contains(as))
                {
                    acl1.bdk.add(as);
                    mSettingsStore._mth02CA(acl1);
                }
            }
            as = aQC.edit();
            as.putStringSet((String)yp.CON._mth02CA("o.yp").getField("aVS").get(null), hashset);
            as.apply();
        }
    }
}
