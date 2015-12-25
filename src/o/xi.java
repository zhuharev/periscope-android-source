// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;

// Referenced classes of package o:
//            qd

public final class xi extends qd
{

    public xi(String s)
    {
        super(s);
        super.Pq.put("Summary.BroadcastID", "Undefined");
        super.Pq.put("Summary.BroadcasterUserID", "Undefined");
        super.Pq.put("PreBroadcast.Title", "Undefined");
        super.Po.put("PreBroadcast.Cancelled", Boolean.valueOf(true));
        super.Po.put("PreBroadcast.Location", Boolean.valueOf(true));
        super.Pq.put("PreBroadcast.Type", "Undefined");
        super.Pq.put("PreBroadcast.Mutuals", "Undefined");
        super.Pq.put("PreBroadcast.MutualsNumber", Integer.toString(-1));
        super.Pq.put("PreBroadcast.ChatSetting", "Undefined");
        _mth02CB(new String[] {
            "PreBroadcast.Twitter", "PreBroadcast.StartBroadcast"
        });
        super.Pq.put("Broadcast.CameraFlip", Integer.toString(-1));
        super.Pq.put("Broadcast.AudioMuted", Integer.toString(-1));
        super.Pq.put("Broadcast.HideChat", Integer.toString(-1));
        super.Pq.put("Broadcast.ViewerBlock", Integer.toString(-1));
        super.Pq.put("Broadcast.ViewerProfileViewed", Integer.toString(-1));
        super.Pq.put("Broadcast.ViewerFollowed", Integer.toString(-1));
        super.Pq.put("Broadcast.ViewerCancel", Integer.toString(-1));
        super.Pq.put("Broadcast.StopBroadcast", Integer.toString(-1));
        _mth02CB(new String[] {
            "PostBroadcast.SaveCameraRoll", "PostBroadcast.PlayReplay", "PostBroadcast.DeleteReplay", "PostBroadcast.DeleteBroadcast"
        });
        super.Pq.put("Metrics.TotalLiveViewers", Integer.toString(-1));
        super.Pq.put("Metrics.TotalLiveAppViewers", Integer.toString(-1));
        super.Pq.put("Metrics.TotalLiveWebViewers", Integer.toString(-1));
        super.Pq.put("Metrics.TotalLiveTvViewers", Integer.toString(-1));
        super.Pq.put("Metrics.TotalLiveTwitterViewers", Integer.toString(-1));
        super.Pq.put("Metrics.TotalReplayViewers", Integer.toString(-1));
        super.Pq.put("Metrics.Retention", Integer.toString(-1));
        super.Pq.put("Metrics.TimeWatched(sec)", Integer.toString(-1));
        super.Pq.put("Metrics.Duration(sec)", Integer.toString(-1));
    }

    public final String getName()
    {
        return "BroadcastCreated";
    }

    public final boolean _mth03C5()
    {
        return true;
    }
}
