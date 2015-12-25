// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package o:
//            up, _cls5FC4

final class FE8F
    implements android.content.DialogInterface.OnClickListener
{

    private _cls5FC4 uu;

    FE8F(_cls5FC4 _pcls5fc4)
    {
        uu = _pcls5fc4;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        Object obj = new up(uu.uq);
        ((up) (obj))._mth02CA(((up) (obj)).edit().putBoolean("always_send_reports_opt_in", true));
        obj = uu.ur;
        obj.uv = true;
        ((_cls1EF4._cls02CA) (obj)).latch.countDown();
        dialoginterface.dismiss();
    }
}
