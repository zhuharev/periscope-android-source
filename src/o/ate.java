// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Arrays;

// Referenced classes of package o:
//            atr, atn

public final class ate extends atr
{

    private final String accessToken;
    private final String authToken;
    private final int bDL;
    private final int bDM;
    private final atn bfm;
    private final String channel;
    private final String endpoint;
    private final String hlsUrl;
    private final int participantIndex;
    private final int pspVersion[];
    private final String publisher;
    private final String replayUrl;
    private final String rtmpUrl;
    private final String session;
    private final String shareUrl;
    private final boolean shouldLog;
    private final boolean shouldVerifySignature;
    private final String signerKey;
    private final String signerToken;
    private final String subscriber;

    public ate(String s, String s1, String s2, int i, String s3, String s4, String s5, 
            String s6, String s7, atn atn, String s8, String s9, boolean flag, boolean flag1, 
            String s10, String s11, String s12, int j, int k, int ai[])
    {
        subscriber = s;
        publisher = s1;
        authToken = s2;
        participantIndex = i;
        channel = s3;
        session = s4;
        rtmpUrl = s5;
        replayUrl = s6;
        hlsUrl = s7;
        if (atn == null)
        {
            throw new NullPointerException("Null broadcast");
        } else
        {
            bfm = atn;
            signerToken = s8;
            signerKey = s9;
            shouldLog = flag;
            shouldVerifySignature = flag1;
            accessToken = s10;
            endpoint = s11;
            shareUrl = s12;
            bDL = j;
            bDM = k;
            pspVersion = ai;
            return;
        }
    }

    public final String eF()
    {
        return endpoint;
    }

    public final String eG()
    {
        return accessToken;
    }

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof atr)
        {
            obj = (atr)obj;
            if ((subscriber != null ? subscriber.equals(((atr) (obj)).ft()) : ((atr) (obj)).ft() == null) && (publisher != null ? publisher.equals(((atr) (obj)).fu()) : ((atr) (obj)).fu() == null) && (authToken != null ? authToken.equals(((atr) (obj)).fv()) : ((atr) (obj)).fv() == null) && participantIndex == ((atr) (obj)).fw() && (channel != null ? channel.equals(((atr) (obj)).fx()) : ((atr) (obj)).fx() == null) && (session != null ? session.equals(((atr) (obj)).fy()) : ((atr) (obj)).fy() == null) && (rtmpUrl != null ? rtmpUrl.equals(((atr) (obj)).fz()) : ((atr) (obj)).fz() == null) && (replayUrl != null ? replayUrl.equals(((atr) (obj)).fA()) : ((atr) (obj)).fA() == null) && (hlsUrl != null ? hlsUrl.equals(((atr) (obj)).fB()) : ((atr) (obj)).fB() == null) && bfm.equals(((atr) (obj)).fo()) && (signerToken != null ? signerToken.equals(((atr) (obj)).fC()) : ((atr) (obj)).fC() == null) && (signerKey != null ? signerKey.equals(((atr) (obj)).fD()) : ((atr) (obj)).fD() == null) && (shouldLog == ((atr) (obj)).fE() && shouldVerifySignature == ((atr) (obj)).fF()) && (accessToken != null ? accessToken.equals(((atr) (obj)).eG()) : ((atr) (obj)).eG() == null) && (endpoint != null ? endpoint.equals(((atr) (obj)).eF()) : ((atr) (obj)).eF() == null) && (shareUrl != null ? shareUrl.equals(((atr) (obj)).fG()) : ((atr) (obj)).fG() == null) && (bDL == ((atr) (obj)).fH() && bDM == ((atr) (obj)).fI()))
            {
                int ai[] = pspVersion;
                if (obj instanceof ate)
                {
                    obj = ((ate)obj).pspVersion;
                } else
                {
                    obj = ((atr) (obj)).fJ();
                }
                if (Arrays.equals(ai, ((int []) (obj))))
                {
                    return true;
                }
            }
            return false;
        } else
        {
            return false;
        }
    }

    public final String fA()
    {
        return replayUrl;
    }

    public final String fB()
    {
        return hlsUrl;
    }

    public final String fC()
    {
        return signerToken;
    }

    public final String fD()
    {
        return signerKey;
    }

    public final boolean fE()
    {
        return shouldLog;
    }

    public final boolean fF()
    {
        return shouldVerifySignature;
    }

    public final String fG()
    {
        return shareUrl;
    }

    public final int fH()
    {
        return bDL;
    }

    public final int fI()
    {
        return bDM;
    }

    public final int[] fJ()
    {
        if (pspVersion == null)
        {
            return null;
        } else
        {
            return (int[])pspVersion.clone();
        }
    }

    public final atn fo()
    {
        return bfm;
    }

    public final String ft()
    {
        return subscriber;
    }

    public final String fu()
    {
        return publisher;
    }

    public final String fv()
    {
        return authToken;
    }

    public final int fw()
    {
        return participantIndex;
    }

    public final String fx()
    {
        return channel;
    }

    public final String fy()
    {
        return session;
    }

    public final String fz()
    {
        return rtmpUrl;
    }

    public final int hashCode()
    {
        int i;
        if (subscriber == null)
        {
            i = 0;
        } else
        {
            i = subscriber.hashCode();
        }
        int j;
        if (publisher == null)
        {
            j = 0;
        } else
        {
            j = publisher.hashCode();
        }
        int k;
        if (authToken == null)
        {
            k = 0;
        } else
        {
            k = authToken.hashCode();
        }
        int j3 = participantIndex;
        int l;
        if (channel == null)
        {
            l = 0;
        } else
        {
            l = channel.hashCode();
        }
        int i1;
        if (session == null)
        {
            i1 = 0;
        } else
        {
            i1 = session.hashCode();
        }
        int j1;
        if (rtmpUrl == null)
        {
            j1 = 0;
        } else
        {
            j1 = rtmpUrl.hashCode();
        }
        int k1;
        if (replayUrl == null)
        {
            k1 = 0;
        } else
        {
            k1 = replayUrl.hashCode();
        }
        int l1;
        if (hlsUrl == null)
        {
            l1 = 0;
        } else
        {
            l1 = hlsUrl.hashCode();
        }
        int k3 = bfm.hashCode();
        int i2;
        if (signerToken == null)
        {
            i2 = 0;
        } else
        {
            i2 = signerToken.hashCode();
        }
        int j2;
        if (signerKey == null)
        {
            j2 = 0;
        } else
        {
            j2 = signerKey.hashCode();
        }
        char c;
        if (shouldLog)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        char c1;
        if (shouldVerifySignature)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        int k2;
        if (accessToken == null)
        {
            k2 = 0;
        } else
        {
            k2 = accessToken.hashCode();
        }
        int l2;
        if (endpoint == null)
        {
            l2 = 0;
        } else
        {
            l2 = endpoint.hashCode();
        }
        int i3;
        if (shareUrl == null)
        {
            i3 = 0;
        } else
        {
            i3 = shareUrl.hashCode();
        }
        return (((((((((((((((((((i ^ 0xf4243) * 0xf4243 ^ j) * 0xf4243 ^ k) * 0xf4243 ^ j3) * 0xf4243 ^ l) * 0xf4243 ^ i1) * 0xf4243 ^ j1) * 0xf4243 ^ k1) * 0xf4243 ^ l1) * 0xf4243 ^ k3) * 0xf4243 ^ i2) * 0xf4243 ^ j2) * 0xf4243 ^ c) * 0xf4243 ^ c1) * 0xf4243 ^ k2) * 0xf4243 ^ l2) * 0xf4243 ^ i3) * 0xf4243 ^ bDL) * 0xf4243 ^ bDM) * 0xf4243 ^ Arrays.hashCode(pspVersion);
    }

    public final String toString()
    {
        return (new StringBuilder("ChannelAccess{subscriber=")).append(subscriber).append(", publisher=").append(publisher).append(", authToken=").append(authToken).append(", participantIndex=").append(participantIndex).append(", channel=").append(channel).append(", session=").append(session).append(", rtmpUrl=").append(rtmpUrl).append(", replayUrl=").append(replayUrl).append(", hlsUrl=").append(hlsUrl).append(", broadcast=").append(bfm).append(", signerToken=").append(signerToken).append(", signerKey=").append(signerKey).append(", shouldLog=").append(shouldLog).append(", shouldVerifySignature=").append(shouldVerifySignature).append(", accessToken=").append(accessToken).append(", endpoint=").append(endpoint).append(", shareUrl=").append(shareUrl).append(", pubnubPerms=").append(bDL).append(", chatmanPerms=").append(bDM).append(", pspVersion=").append(Arrays.toString(pspVersion)).append("}").toString();
    }
}
