// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            zw, ql, xd

public final class zf
{

    public final SharedPreferences aQC;
    public AtomicBoolean aWD;
    private final ql mEventBus;

    public zf(xd xd, ql ql1)
    {
        aWD = new AtomicBoolean(false);
        aQC = PreferenceManager.getDefaultSharedPreferences(xd);
        mEventBus = ql1;
    }

    public final void _mth1D6A(int i)
    {
        aQC.edit().putInt((String)yp.CON._mth02CA("o.yp").getField("aVJ").get(null), i).apply();
        aWD.weakCompareAndSet(false, true);
        mEventBus._mth1429(zw.aYQ);
    }
}
