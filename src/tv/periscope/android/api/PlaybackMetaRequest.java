// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.util.HashMap;

// Referenced classes of package tv.periscope.android.api:
//            PsRequest, ChatStats

public class PlaybackMetaRequest extends PsRequest
{

    public HashMap behaviorStats;
    public String broadcastId;
    public ChatStats chatStats;
    public HashMap pubnubStats;
    public HashMap stats;

    public PlaybackMetaRequest()
    {
    }
}
