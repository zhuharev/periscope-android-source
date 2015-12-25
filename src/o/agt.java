// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            agp, xh, xf, adx, 
//            atr, apb, auf, atn, 
//            ahw, ahk, arm, aok, 
//            aix, aib, aip, aug, 
//            abc, xw

final class agt
    implements Runnable
{

    private agp ble;
    private String blh;

    agt(agp agp1, String s)
    {
        ble = agp1;
        blh = s;
        super();
    }

    public final void run()
    {
        agp._mth02B9(ble);
        xf._mth02CB((xh)agp._mth0559(ble));
        if (agp._mth02CF(ble) == null || !agp._mth02CF(ble).bfL)
        {
            return;
        }
        agp._mth02CA(ble, blh);
        if (agp._mth02CD(ble) != null)
        {
            Object obj = agp._mth02CD(ble).fx();
            String s = agp._mth1427(ble).username;
            String s1 = agp._mth1427(ble).displayName;
            String s2 = agp._mth1427(ble).id;
            int i = agp._mth02CD(ble).fw();
            adx adx1 = agp._mth02CF(ble);
            long l1;
            if (adx1.bfX == 0.0D)
            {
                l1 = apb.ec().getTime();
            } else
            {
                l1 = (long)((adx1.bfX - 2208988800D) * 1000D);
            }
            obj = auf._mth02CA(((String) (obj)), s, s1, s2, i, l1, apb.ec().getTime());
            if (!agp._mth141D(ble).fe() && agp._mth05D9(ble) != null)
            {
                ahw ahw1 = agp._mth0674(ble);
                ahw1.bml._mth141D(((auf) (obj)));
                int j = ahw1.bml.getItemCount();
                ahw1.bmk._mth1507(j - 1);
            }
            if (agp._mth02BB(ble) == ahi.if.blu)
            {
                aib aib2 = agp._mth1D35(ble);
                int k = aok._mth02CA(ble.getResources(), agp._mth02CD(ble).fw());
                aix aix2 = new aix(aib2.getContext());
                aix2.setColorAndDrawables(k, 0x7f020119, 0x7f02011a);
                aib2.bmI._mth02CA(aix2, aib2, true);
                if (agp._mth02CA(ble, aug.bEO))
                {
                    agp.FE73(ble).log("send screenshot");
                    agp.FF9E(ble)._mth02CA(agp._mth02CD(ble).fC(), ((auf) (obj)));
                    return;
                }
            } else
            {
                aib aib1 = agp._mth1D35(ble);
                int l = aok._mth02CA(ble.getResources(), -1);
                aix aix1 = new aix(aib1.getContext());
                aix1.setColorAndDrawables(l, 0x7f020119, 0x7f02011a);
                aib1.bmI._mth02CA(aix1, aib1, true);
            }
        }
    }
}
