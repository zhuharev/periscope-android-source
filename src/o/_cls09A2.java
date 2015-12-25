// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package o:
//            to, _cls148E, _cls09B6, rx, 
//            _cls098C, _cls1439, ut, _cls0E01, 
//            tl, _cls09BD, ti, tk, 
//            _cls1434, ra, rl, _cls10D9, 
//            _cls1491, _cls09AC, ri, uj, 
//            _cls14AC, ub

final class _cls09A2 extends to
    implements _cls148E
{

    private final ri kit;
    private final uj sK;
    private _cls14AC sL;
    private _cls09AC sM;
    private _cls098C sN;
    private rx sO;
    private boolean sP;
    private boolean sQ;

    public _cls09A2(ri ri, Context context, ScheduledExecutorService scheduledexecutorservice, _cls1434 _pcls1434, uj uj, _cls14AC _pcls14ac)
    {
        super(context, scheduledexecutorservice, _pcls1434);
        sM = new _cls09B6();
        sO = new rx();
        sP = true;
        sQ = true;
        kit = ri;
        sK = uj;
        sL = _pcls14ac;
    }

    public final ub getFilesSender()
    {
        return sN;
    }

    public final void _mth02CA(ut ut1, String s)
    {
        sN = new _cls098C(new _cls1439(kit, s, ut1.TW, sK, sO._mth06E5(context)), new _cls0E01(new tl(new _cls09BD(new ti(1000L, 8), 0.10000000000000001D), new tk(5))));
        ((_cls1434)filesManager).sW = ut1;
        sP = ut1.Ub;
        rl rl1 = ra._mth0454();
        StringBuilder stringbuilder = new StringBuilder("Custom event tracking ");
        if (sP)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        rl1._mth02BE("Answers", stringbuilder.append(s).toString());
        sQ = ut1.Uc;
        rl1 = ra._mth0454();
        stringbuilder = new StringBuilder("Predefined event tracking ");
        if (sQ)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        rl1._mth02BE("Answers", stringbuilder.append(s).toString());
        if (ut1.samplingRate > 1)
        {
            ra._mth0454()._mth02BE("Answers", "Event sampling enabled");
            sM = new _cls10D9(ut1.samplingRate);
        }
        configureRollover(ut1.TX);
    }

    public final void _mth02CB(_cls1491.if if1)
    {
        if1 = new _cls1491(sL, if1.timestamp, if1.ta, if1.tb, null, if1.td, null, if1.tf, (byte)0);
        if (!sP && _cls1491._cls02CA.tr.equals(((_cls1491) (if1)).ta))
        {
            ra._mth0454()._mth02BE("Answers", (new StringBuilder("Custom events tracking disabled - skipping event: ")).append(if1).toString());
            return;
        }
        if (!sQ && _cls1491._cls02CA.ts.equals(((_cls1491) (if1)).ta))
        {
            ra._mth0454()._mth02BE("Answers", (new StringBuilder("Predefined events tracking disabled - skipping event: ")).append(if1).toString());
            return;
        }
        if (sM._mth02CA(if1))
        {
            ra._mth0454()._mth02BE("Answers", (new StringBuilder("Skipping filtered event: ")).append(if1).toString());
            return;
        } else
        {
            recordEvent(if1);
            return;
        }
    }
}
