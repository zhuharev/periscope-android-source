// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aed

final class <init>
    implements Runnable
{

    private aed bhH;

    public final void run()
    {
        if (!aed.FE7A(bhH))
        {
            aed._mth02B3(bhH).pingBroadcast(aed._mth1427(bhH), aed.FF70(bhH));
            aed._mth02CF(bhH).postDelayed(this, 30000L);
        }
    }

    private Handler(aed aed1)
    {
        bhH = aed1;
        super();
    }

    bject(aed aed1, byte byte0)
    {
        this(aed1);
    }
}
