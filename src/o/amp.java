// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            ada, yo, xd, zp

public class amp extends ada
{

    public amp()
    {
    }

    protected void dr()
    {
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (yo.h())
        {
            finish();
            return;
        }
        if (yo.j() && !xd._mth1FEA().aQC.getBoolean((String)yp.CON._mth02CA("o.yp").getField("aVN").get(null), false))
        {
            finish();
            return;
        } else
        {
            dr();
            return;
        }
    }

    public final void onResume()
    {
        super.onResume();
        isFinishing();
    }

    public final void onStart()
    {
        super.onStart();
        isFinishing();
    }
}
