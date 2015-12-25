// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;

// Referenced classes of package o:
//            xf, agp, auf

public final class agv
    implements android.content.DialogInterface.OnClickListener
{

    private agp ble;
    private String bli;
    private auf blj;

    agv(agp agp1, String s, auf auf)
    {
        ble = agp1;
        bli = s;
        blj = auf;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        xf._mth02CA(xf.if.aRW);
        agp._mth02CA(ble, bli, blj);
    }
}
