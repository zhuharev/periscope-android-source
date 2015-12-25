// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aje, zc, aos

final class ajf
    implements Runnable
{

    private long bpb;
    private aje bpc;

    ajf(aje aje1, long l)
    {
        bpc = aje1;
        bpb = l;
        super();
    }

    public final void run()
    {
        ArrayList arraylist = bpc._mth02C7(bpb);
        if (!arraylist.isEmpty())
        {
            bpc.bcW.refreshLiveBroadcasts(arraylist);
        }
        aos._mth02CA(bpc.bmU.id(), bpc.boZ, bpb);
    }
}
