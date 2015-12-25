// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.StringReader;

// Referenced classes of package o:
//            ow, iu, iv, it, 
//            iq, kd, of, pa, 
//            ot, nx, or, oa

final class on extends ow
{

    private of.if MJ;

    on(of.if if1)
    {
        MJ = if1;
        super();
    }

    public final void _mth02CA(oa oa, String s)
    {
        oa = (new iv())._mth02CA(new StringReader(s));
        if (oa instanceof it)
        {
            oa = (iq)oa._mth0673().GC.get("message");
            MJ.MI._mth02CA(ot._mth02CA(of._mth02CE(MJ.ME).NA, ",", "-pnpres"), oa);
            return;
        }
        try
        {
            oa = or._mth02CA(or.MR, 1, s);
            MJ.MI._mth02CA(ot._mth02CA(of._mth02CE(MJ.ME).NA, ",", "-pnpres"), oa);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (oa oa)
        {
            oa = or._mth02CA(or.MR, 1, s);
        }
        MJ.MI._mth02CA(ot._mth02CA(of._mth02CE(MJ.ME).NA, ",", "-pnpres"), oa);
        return;
    }

    public final void _mth02CB(or or1)
    {
        MJ.MI._mth02CA(ot._mth02CA(of._mth02CE(MJ.ME).NA, ",", "-pnpres"), or1);
    }
}
