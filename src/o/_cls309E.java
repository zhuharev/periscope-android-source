// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;

// Referenced classes of package o:
//            vh, va, up, _cls1EF4

final class _cls309E
    implements ve._cls02CA
{

    private _cls1EF4 uq;

    _cls309E(_cls1EF4 _pcls1ef4)
    {
        uq = _pcls1ef4;
        super();
    }

    public final Boolean _mth02CB(vh vh1)
    {
        if (vh1.UV.Ur)
        {
            boolean flag;
            if (!(new up(uq))._mth1E97().getBoolean("always_send_reports_opt_in", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        } else
        {
            return Boolean.valueOf(false);
        }
    }
}
