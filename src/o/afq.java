// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            afp, arc, _cls0675

final class afq
    implements Runnable
{

    private boolean biN;
    private afp biO;

    afq(afp afp1, boolean flag)
    {
        biO = afp1;
        biN = flag;
        super();
    }

    public final void run()
    {
        if (PreferenceManager.getDefaultSharedPreferences(afp._mth02CA(biO).getContext()).getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVY").get(null), true))
        {
            try
            {
                biO._mth02CA(afp._mth02CA(biO), true);
                return;
            }
            catch (android.view.WindowManager.BadTokenException badtokenexception)
            {
                Object obj = biO;
                obj = afp._mth02CA(biO);
                boolean flag = biN;
                ((arc) (obj)).setActivated(flag);
                float f;
                if (flag)
                {
                    f = 1.0F;
                } else
                {
                    f = 0.3F;
                }
                ((arc) (obj)).setAlpha(f);
                _cls0675._mth02CB(badtokenexception);
            }
        }
    }
}
