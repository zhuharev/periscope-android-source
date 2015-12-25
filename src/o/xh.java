// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;

// Referenced classes of package o:
//            qd, qg

public final class xh extends qd
{

    public xh(String s)
    {
        super(s);
        super.Pq.put("Summary.BroadcastID", "Undefined");
        super.Pq.put("Summary.BroadcasterUserId", "Undefined");
        super.Pq.put("Summary.State", "Undefined");
        super.Pq.put("Summary.BroadcasterFollowed", "Undefined");
        super.Pq.put("Summary.LiveViewersAtJoin", Integer.toString(-1));
        super.Pq.put("Summary.LiveViewersAtExit", Integer.toString(-1));
        s = new qg("Summary.TimeWatched");
        super.Pr.put(((qg) (s)).Pn, s);
        super.Pq.put("Summary.ReplayDuration", Integer.toString(-1));
        super.Pq.put("Summary.ReplayTimeWatched", Float.toString(-1F));
        _mth02CE(new String[] {
            "Summary.ReplayPauses", "Summary.ReplayScrubs"
        });
        _mth02CE(new String[] {
            "Chat.ChatCommentTapped", "Chat.ChatCommentReplied", "Chat.ChatCommentViewProfile", "Chat.ChatCommentBlockUser", "Chat.ChatCommentCancel"
        });
        _mth02CE(new String[] {
            "Chat.Hearts", "Chat.Comments", "Chat.Screenshots"
        });
        _mth02CB(new String[] {
            "Chat.ScreenshotTwitterPrompt", "Chat.ScreenshotTwitterPost", "Chat.FollowBroadcaster", "Chat.Share"
        });
        _mth02CE(new String[] {
            "InfoPanel..SwipeIn", "InfoPanel..BroadcasterProfileViewed", "InfoPanel..MapZoom", "InfoPanel..ShareTwitter", "InfoPanel..ShareAllFollowers", "InfoPanel..ShareSpecificFollowers", "InfoPanel..ShareCopyLink", "InfoPanel..ShareFacebook", "InfoPanel..ShareMutuals", "InfoPanel..HideChat", 
            "InfoPanel..Reported", "InfoPanel..LiveViewerProfileViewed", "InfoPanel..ReplayViewerProfileViewed"
        });
        _mth02CB(new String[] {
            "InfoPanel..LocationAvailable"
        });
    }

    public final String getName()
    {
        return "Broadcast Viewed";
    }

    public final boolean _mth03C5()
    {
        return true;
    }
}
