// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import o.atf;
import o.ats;

// Referenced classes of package tv.periscope.android.api:
//            PsResponse, PsBroadcast, ChannelPermissions

class CreateBroadcastResponse extends PsResponse
{

    public String accessToken;
    public String application;
    public String authToken;
    public PsBroadcast broadcast;
    public boolean canShareTwitter;
    public String channel;
    public ChannelPermissions channelPerms;
    public String cipher;
    public String credential;
    public String endpoint;
    public String host;
    public byte key[];
    public int participantIndex;
    public int port;
    public int privatePort;
    public String privateProtocol;
    public String protocol;
    public int pspVersion[];
    public String publisher;
    public boolean readOnly;
    public boolean shouldLog;
    public boolean shouldVerifySignature;
    public String signerKey;
    public String signerToken;
    public String streamName;
    public String subscriber;
    public String thumbnailUploadUrl;
    public String uploadUrl;

    CreateBroadcastResponse()
    {
    }

    public ats create()
    {
        String s = subscriber;
        String s1 = publisher;
        String s2 = authToken;
        String s3 = signerKey;
        String s4 = signerToken;
        String s5 = cipher;
        int k = participantIndex;
        String s6 = channel;
        boolean flag = shouldLog;
        boolean flag1 = shouldVerifySignature;
        o.atn atn = broadcast.create();
        String s7 = protocol;
        String s8 = host;
        int l = port;
        String s9 = application;
        String s10 = streamName;
        String s11 = credential;
        String s12 = privateProtocol;
        int i1 = privatePort;
        String s13 = uploadUrl;
        String s14 = thumbnailUploadUrl;
        boolean flag2 = canShareTwitter;
        String s15 = accessToken;
        byte abyte0[] = key;
        String s16 = endpoint;
        int i;
        if (channelPerms != null)
        {
            i = channelPerms.pubnubOpts;
        } else
        {
            i = 1;
        }
        int j;
        if (channelPerms != null)
        {
            j = channelPerms.chatmanOpts;
        } else
        {
            j = 0;
        }
        return new atf(s, s1, s2, s3, s4, s5, k, s6, flag, flag1, atn, s7, s8, l, s9, s10, s11, s12, i1, s13, s14, flag2, s15, abyte0, s16, i, j, pspVersion);
    }
}
