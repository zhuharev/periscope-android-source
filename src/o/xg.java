// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.localytics.android.AnalyticsListener;
import java.util.Map;

// Referenced classes of package o:
//            xf, zp, ack

final class xg
    implements AnalyticsListener
{

    private zp aQP;
    private ack aQQ;

    xg(zp zp, ack ack)
    {
        aQP = zp;
        aQQ = ack;
        super();
    }

    public final void localyticsDidTagEvent(String s, Map map, long l)
    {
    }

    public final void localyticsSessionDidOpen(boolean flag, boolean flag1, boolean flag2)
    {
    }

    public final void localyticsSessionWillClose()
    {
    }

    public final void localyticsSessionWillOpen(boolean flag, boolean flag1, boolean flag2)
    {
        if (flag)
        {
            xf._mth30C8();
            return;
        }
        if (flag1)
        {
            xf._mth02CA(aQP, aQQ);
        }
    }
}
