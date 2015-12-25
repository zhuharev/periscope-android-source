// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            up, sc, ux, ra, 
//            rl, rx, _cls14B7, si, 
//            _cls14BA, _cls14B6, rz, _cls14D8, 
//            uj

abstract class _cls1602
{

    Context context;
    sc currentTimeProvider;
    si idManager;
    up preferenceStore;
    uj sK;
    _cls14B6 sp;
    final AtomicBoolean tQ;
    final AtomicBoolean tR;
    ux tS;
    _cls14B7 tT;
    long tU;

    public _cls1602()
    {
        this(false);
    }

    public _cls1602(boolean flag)
    {
        tQ = new AtomicBoolean();
        tU = 0L;
        tR = new AtomicBoolean(flag);
    }

    void _mth02BD(long l)
    {
        tU = l;
    }

    public void _mth02CA(Context context1, _cls14B6 _pcls14b6, si si1, ux ux1, _cls14B7 _pcls14b7, up up1, sc sc1, 
            uj uj)
    {
        context = context1;
        sp = _pcls14b6;
        idManager = si1;
        tS = ux1;
        tT = _pcls14b7;
        preferenceStore = up1;
        currentTimeProvider = sc1;
        sK = uj;
        if (_mth14F5())
        {
            _mth153F();
        }
    }

    protected boolean _mth14F2()
    {
        tR.set(true);
        return tQ.get();
    }

    boolean _mth14F5()
    {
        tQ.set(true);
        return tR.get();
    }

    protected void _mth153F()
    {
        up up1 = preferenceStore;
        up1;
        JVM INSTR monitorenter ;
        if (preferenceStore._mth1E97().contains("last_update_check"))
        {
            preferenceStore._mth02CA(preferenceStore.edit().remove("last_update_check"));
        }
        up1;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception1;
        exception1;
        throw exception1;
_L1:
        long l;
        l = currentTimeProvider.getCurrentTimeMillis();
        long l1 = (long)tS.Uq * 1000L;
        ra._mth0454()._mth02BE("Beta", (new StringBuilder("Check for updates delay: ")).append(l1).toString());
        ra._mth0454()._mth02BE("Beta", (new StringBuilder("Check for updates last check time: ")).append(_mth1D04()).toString());
        l1 = _mth1D04() + l1;
        ra._mth0454()._mth02BE("Beta", (new StringBuilder("Check for updates current time: ")).append(l).append(", next check time: ").append(l1).toString());
        if (l < l1)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        _mth157B();
        _mth02BD(l);
        return;
        Exception exception;
        exception;
        _mth02BD(l);
        throw exception;
        ra._mth0454()._mth02BE("Beta", "Check for updates next check time was not passed");
        return;
    }

    void _mth157B()
    {
        ra._mth0454()._mth02BE("Beta", "Performing update check");
        String s = (new rx())._mth06E5(context);
        String s1 = idManager._mth02C9(s, tT.packageName);
        (new _cls14BA(sp, rz._mth1FBE(sp.getContext(), "com.crashlytics.ApiEndpoint"), tS.Up, sK, new _cls14D8()))._mth02CA(s, s1, tT);
    }

    long _mth1D04()
    {
        return tU;
    }
}
