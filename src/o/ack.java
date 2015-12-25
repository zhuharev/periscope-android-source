// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            aui, acj, xd

public final class ack
{

    public SharedPreferences aQC;
    public acj bde;

    private ack(SharedPreferences sharedpreferences)
    {
        aQC = sharedpreferences;
    }

    public ack(xd xd)
    {
        this(PreferenceManager.getDefaultSharedPreferences(xd));
    }

    public void aG()
    {
        String s2 = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVT").get(null), null);
        String s1 = aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVU").get(null), null);
        if (aui._mth02BF(s2))
        {
            String s = s1;
            if (aui.isEmpty(s1))
            {
                s = acj.if.bdb.name();
                android.content.SharedPreferences.Editor editor = aQC.edit();
                editor.putString((String)yp.CON._mth02CA("o.yp").getField("aVU").get(null), s);
                editor.apply();
            }
            bde = new acj(s2, acj.if.valueOf(s));
        }
    }
}
