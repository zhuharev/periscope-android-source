// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            adl, apl

final class adp
    implements android.content.DialogInterface.OnClickListener
{

    private adl bez;
    private String val$broadcastId;

    adp(adl adl1, String s)
    {
        bez = adl1;
        val$broadcastId = s;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        bez.bcW.deleteBroadcast(val$broadcastId);
        dialoginterface = bez;
        if (((adl) (dialoginterface)).bev != null)
        {
            ((adl) (dialoginterface)).bev.dC();
        }
    }
}
