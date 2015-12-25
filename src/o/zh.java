// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import java.lang.reflect.Field;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            zr, zs, zp

public final class zh extends zr
{

    public zh(zp zp1)
    {
        super(zp1);
        aWz = zs.aXf;
        aUN = zp1.aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVC").get(null), null);
    }

    public final void A()
    {
    }

    public final String id()
    {
        return null;
    }

    public final int v()
    {
        return mUserManager._mth02CA(aUN, aWz);
    }

    public final Object _mth1D4A(int i)
    {
        return mUserManager._mth02CA(aWz, aUN, i);
    }

    public final PsUser _mth1E2F(int i)
    {
        return mUserManager._mth02CA(aWz, aUN, i);
    }
}
