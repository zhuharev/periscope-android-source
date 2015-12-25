// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            agp, adx, atr

final class <init>
    implements Runnable
{

    private agp ble;

    public final void run()
    {
        if (agp._mth1D4E(ble) || ble.isFinishing())
        {
            return;
        }
        if (agp._mth02BB(ble) == u && agp._mth02CF(ble) != null && agp._mth02CF(ble).bfL && agp._mth02CD(ble) != null)
        {
            agp._mth1D62(ble).pingWatching(agp._mth037A(ble), agp._mth02CD(ble).fy(), agp._mth1D54(ble));
            agp._mth02BE(ble).postDelayed(this, 30000L);
        }
    }

    private Handler(agp agp1)
    {
        ble = agp1;
        super();
    }

    bject(agp agp1, byte byte0)
    {
        this(agp1);
    }
}
