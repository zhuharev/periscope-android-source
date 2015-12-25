// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;

// Referenced classes of package o:
//            agp, adx, ahi

final class ahc
    implements Runnable
{

    private agp ble;

    ahc(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void run()
    {
        if (ble.isFinishing())
        {
            return;
        }
        if (agp._mth037A(ble) != null && agp._mth02CF(ble) != null && agp._mth02CF(ble).bm())
        {
            agp._mth1FBE(ble)._mth02CA(ble);
            agp._mth02BE(ble).postDelayed(this, 5000L);
        }
    }
}
