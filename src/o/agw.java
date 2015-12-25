// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package o:
//            xf, agp, aey

public final class agw
    implements android.content.DialogInterface.OnClickListener
{

    private agp ble;

    agw(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        xf._mth02CA(xf.if.aRX);
        dialoginterface = agp._mth02CC(ble);
        dialoginterface.bA();
        ((aey) (dialoginterface)).bhX.setVisibility(4);
    }
}
