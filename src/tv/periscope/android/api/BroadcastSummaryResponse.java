// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import o.atc;
import o.atp;

// Referenced classes of package tv.periscope.android.api:
//            PsResponse, PsBroadcast, PsMeta

class BroadcastSummaryResponse extends PsResponse
{

    public PsBroadcast broadcast;
    public PsMeta meta;

    BroadcastSummaryResponse()
    {
    }

    public atp create()
    {
        return new atc(broadcast.create(), meta.get());
    }
}
