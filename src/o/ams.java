// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import java.util.Random;

// Referenced classes of package o:
//            amr

final class ams
    implements Runnable
{

    private amr btd;

    ams(amr amr1)
    {
        btd = amr1;
        super();
    }

    public final void run()
    {
        switch (amr._mth02CA(btd).nextInt(5))
        {
        case 0: // '\0'
        case 1: // '\001'
            amr._mth02CB(btd);
            break;

        default:
            amr._mth02CE(btd);
            break;
        }
        btd.btb.postDelayed(this, amr._mth02CA(btd).nextInt(1000));
    }
}
