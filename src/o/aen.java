// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            aed, arx, adh

final class aen
    implements android.view.View.OnSystemUiVisibilityChangeListener
{

    private aed bhH;

    aen(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void onSystemUiVisibilityChange(int i)
    {
        if ((i & 1) == 0)
        {
            aed._mth02CC(bhH);
            if (!arx._mth1424(aed._mth02C9(bhH)) && !aed._mth02CD(bhH).aO())
            {
                aed._mth02CF(bhH).removeCallbacks(aed._mth02D1(bhH));
                aed._mth02CF(bhH).postDelayed(aed._mth02D1(bhH), TimeUnit.SECONDS.toMillis(5L));
            }
        }
    }
}
