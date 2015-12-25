// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.util.ArrayList;

// Referenced classes of package tv.periscope.android.api:
//            PsResponse

public class GetBroadcastViewersResponse extends PsResponse
{

    public transient String broadcastId;
    public transient String broadcasterId;
    public ArrayList live;
    public int numLiveWatched;
    public int numReplayWatched;
    public int numWebWatched;
    public ArrayList replay;

    public GetBroadcastViewersResponse()
    {
    }
}
