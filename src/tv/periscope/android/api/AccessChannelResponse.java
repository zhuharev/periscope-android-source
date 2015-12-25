// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import o.ate;
import o.atr;
import o.aua;

// Referenced classes of package tv.periscope.android.api:
//            PsResponse, ChannelPermissions, PsBroadcast

class AccessChannelResponse extends PsResponse
{

    public String accessToken;
    public String authToken;
    public PsBroadcast broadcast;
    public String channel;
    public ChannelPermissions channelPerms;
    public String endpoint;
    public String hlsUrl;
    public byte key[];
    public int participantIndex;
    public int pspVersion[];
    public String publisher;
    public String replayUrl;
    public String rtmpUrl;
    public String session;
    public String shareUrl;
    public boolean shouldLog;
    public boolean shouldVerifySignature;
    public String signerKey;
    public String signerToken;
    public String subscriber;
    public String type;

    AccessChannelResponse()
    {
    }

    public atr create()
    {
        int i = 1;
        int j = 0;
        if (channelPerms != null)
        {
            i = channelPerms.pubnubOpts;
            j = channelPerms.chatmanOpts;
        }
        Object obj1 = subscriber;
        String s = publisher;
        String s1 = authToken;
        int k = participantIndex;
        String s2 = channel;
        String s3 = session;
        String s4 = rtmpUrl;
        String s5 = replayUrl;
        String s6 = hlsUrl;
        o.atn atn = broadcast.create();
        String s7 = signerToken;
        String s8 = signerKey;
        Object obj = type;
        obj1 = new ate(((String) (obj1)), s, s1, k, s2, s3, s4, s5, s6, atn, s7, s8, shouldLog, shouldVerifySignature, accessToken, endpoint, shareUrl, i, j, pspVersion);
        i = -1;
        switch (((String) (obj)).hashCode())
        {
        case -812124764: 
            if (((String) (obj)).equals("StreamTypeLowLatency"))
            {
                i = 0;
            }
            break;

        case 1852164521: 
            if (((String) (obj)).equals("StreamTypeTooFull"))
            {
                i = 1;
            }
            break;

        case 972161263: 
            if (((String) (obj)).equals("StreamTypeOnlyFriends"))
            {
                i = 2;
            }
            break;
        }
        switch (i)
        {
        case 0: // '\0'
            obj = aua.bEq;
            break;

        case 1: // '\001'
            obj = aua.bEr;
            break;

        case 2: // '\002'
            obj = aua.bEs;
            break;

        default:
            obj = aua.bEp;
            break;
        }
        obj1.bEh = ((aua) (obj));
        return ((atr) (obj1));
    }
}
