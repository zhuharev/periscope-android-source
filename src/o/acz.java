// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            xf, acy

final class acz
    implements android.content.DialogInterface.OnClickListener
{

    private String bdL;
    private acy bdM;

    acz(acy acy1, String s)
    {
        bdM = acy1;
        bdL = s;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        xf._mth02CA(xf.if.aSH);
        bdM.bcW.unblock(bdL);
    }
}
