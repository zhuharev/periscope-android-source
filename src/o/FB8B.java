// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package o:
//            _cls5FC4

final class FB8B
    implements android.content.DialogInterface.OnClickListener
{

    private _cls5FC4 uu;

    FB8B(_cls5FC4 _pcls5fc4)
    {
        uu = _pcls5fc4;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        _cls1EF4._cls02CA _lcls02ca = uu.ur;
        _lcls02ca.uv = false;
        _lcls02ca.latch.countDown();
        dialoginterface.dismiss();
    }
}
