// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package o:
//            _cls0692, _cls14AE, si, rr, 
//            rz, _cls14AC, _cls14AD, sc, 
//            _cls072A, un, uc, _cls1434, 
//            _cls09A2, ra, rl

final class _cls06CA
    implements Runnable
{

    private _cls0692 sE;

    _cls06CA(_cls0692 _pcls0692)
    {
        sE = _pcls0692;
        super();
    }

    public final void run()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        String s;
        String s1;
        Object obj5;
        Object obj6;
        Object obj7;
        try
        {
            obj2 = sE.sz;
            obj5 = ((_cls14AE) (obj2)).idManager._mth0EB2();
            obj3 = ((_cls14AE) (obj2)).context.getPackageName();
            obj4 = ((_cls14AE) (obj2)).idManager._mth0E22();
            s = (String)((Map) (obj5)).get(si.if.Sf);
            s1 = (String)((Map) (obj5)).get(si.if.Si);
            obj6 = ((_cls14AE) (obj2)).idManager;
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to enable events", exception);
            return;
        }
        obj1 = null;
        obj = obj1;
        if (!((si) (obj6)).RW)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj6 = ((si) (obj6))._mth0646();
        obj = obj1;
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = Boolean.valueOf(((rr) (obj6)).Rj);
        obj1 = (String)((Map) (obj5)).get(si.if.Se);
        obj5 = rz._mth142A(((_cls14AE) (obj2)).context);
        obj6 = ((_cls14AE) (obj2)).idManager;
        obj6 = String.format(Locale.US, "%s/%s", new Object[] {
            si._mth1D4C(android.os.Build.VERSION.RELEASE), si._mth1D4C(android.os.Build.VERSION.INCREMENTAL)
        });
        obj7 = ((_cls14AE) (obj2)).idManager;
        obj7 = String.format(Locale.US, "%s/%s", new Object[] {
            si._mth1D4C(Build.MANUFACTURER), si._mth1D4C(Build.MODEL)
        });
        obj = new _cls14AC(((String) (obj3)), UUID.randomUUID().toString(), ((String) (obj4)), s, s1, ((Boolean) (obj)), ((String) (obj1)), ((String) (obj5)), ((String) (obj6)), ((String) (obj7)), ((_cls14AE) (obj2)).st, ((_cls14AE) (obj2)).versionName);
        obj1 = sE.sy;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        } else
        {
            obj2 = new _cls14AD();
            obj3 = new sc();
            obj4 = ((_cls072A) (obj1)).sH.getFilesDir();
            obj4 = new uc(((_cls072A) (obj1)).context, ((java.io.File) (obj4)), "session_analytics.tap", "session_analytics_to_send");
            obj1 = new _cls1434(((_cls072A) (obj1)).context, ((_cls14AD) (obj2)), ((sc) (obj3)), ((uc) (obj4)));
            ((_cls1434) (obj1)).registerRollOverListener(sE);
            sE.sB = new _cls09A2(sE.kit, sE.context, sE.executor, ((_cls1434) (obj1)), sE.sA, ((_cls14AC) (obj)));
            return;
        }
    }
}
