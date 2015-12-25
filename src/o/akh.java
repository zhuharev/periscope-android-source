// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ake, zc, aos

final class akh
    implements Runnable
{

    private long bpb;
    private ake bqs;

    akh(ake ake1, long l)
    {
        bqs = ake1;
        bpb = l;
        super();
    }

    public final void run()
    {
        if (System.currentTimeMillis() - ake._mth141D(bqs) > ake.cZ())
        {
            ake._mth02CA(bqs, false, 0L);
            ake._mth02CA(bqs, System.currentTimeMillis());
        } else
        {
            ArrayList arraylist = bqs._mth02C7(bpb);
            if (!arraylist.isEmpty())
            {
                bqs.bcW.refreshLiveBroadcasts(arraylist);
            }
        }
        aos._mth02CA(bqs.bmU.id(), bqs.boZ, bpb);
    }
}
