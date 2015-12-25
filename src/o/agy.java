// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;

// Referenced classes of package o:
//            agp, anq

final class agy
    implements ans.if
{

    private agp ble;
    private String val$broadcastId;

    agy(agp agp1, String s)
    {
        ble = agp1;
        val$broadcastId = s;
        super();
    }

    public final void _mth1FBE(ArrayList arraylist)
    {
        if (!arraylist.isEmpty())
        {
            ble._mth02CB(val$broadcastId, arraylist);
            agp._mth2071(ble).clear();
        }
    }
}
