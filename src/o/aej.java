// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aed, zp, xx, apb, 
//            auf, aok, aix, aib, 
//            aip, xw

final class aej
    implements Runnable
{

    private aed bhH;

    aej(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void run()
    {
        aed._mth1D54(bhH);
        if (aed._mth1FBE(bhH))
        {
            Object obj = aed._mth1D62(bhH).H();
            obj = auf._mth02CA(aed._mth02BE(bhH).aUj, ((PsUser) (obj)).username, ((PsUser) (obj)).displayName, ((PsUser) (obj)).id, aed._mth2071(bhH), apb.ec().getTime(), apb.ec().getTime());
            aib aib1 = aed._mth02BC(bhH);
            int i = aok._mth02CA(bhH.getResources(), aed._mth2071(bhH));
            aix aix1 = new aix(aib1.getContext());
            aix1.setColorAndDrawables(i, 0x7f020119, 0x7f02011a);
            aib1.bmI._mth02CA(aix1, aib1, true);
            aed._mth02BF(bhH)._mth02CA(aed.FE76(bhH), ((auf) (obj)));
        }
    }
}
