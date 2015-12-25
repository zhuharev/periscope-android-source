// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import tv.periscope.android.LaunchActivity;

// Referenced classes of package o:
//            ajk

public final class xc
    implements android.content.DialogInterface.OnDismissListener
{

    private LaunchActivity aQD;

    public xc(LaunchActivity launchactivity)
    {
        aQD = launchactivity;
        super();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        dialoginterface = aQD;
        dialoginterface.startActivity(new Intent(dialoginterface, o/ajk));
        dialoginterface.finish();
    }
}
