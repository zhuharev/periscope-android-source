// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            agp, adx, atn, ato, 
//            qh

final class ahb
    implements Runnable
{

    private agp ble;

    ahb(agp agp1)
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
        if (agp._mth02CF(ble) != null && agp._mth02CF(ble).bm())
        {
            boolean flag;
            if (agp._mth141D(ble).bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                agp._mth02CA(ble, true, ble.getString(0x7f060164));
            } else
            {
                agp._mth02CA(ble, true, ble.getString(0x7f0600e3));
            }
            switch (agp._cls1.blk[agp._mth02BB(ble).ordinal()])
            {
            case 1: // '\001'
                agp._mth02BC(ble)._mth0E40("Summary.TimeWatched");
                break;

            case 2: // '\002'
            case 3: // '\003'
                agp._mth02BD(ble)._mth0E40("Summary.ReplayTimeWatched");
                break;
            }
        }
        agp._mth02CA(ble, false);
    }
}
