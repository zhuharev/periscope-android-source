// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;

// Referenced classes of package o:
//            agp

public final class agx
    implements android.content.DialogInterface.OnDismissListener
{

    private agp ble;

    agx(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        agp._mth02CA(ble, null);
    }
}
