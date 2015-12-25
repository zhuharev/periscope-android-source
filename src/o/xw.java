// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Snapshot;
import com.codahale.metrics.UniformReservoir;
import java.util.concurrent.BlockingDeque;
import tv.periscope.android.api.ChatStats;
import tv.periscope.android.api.PsMessage;
import tv.periscope.android.signer.SignerService;
import tv.periscope.chatman.api.ChatMessage;
import tv.periscope.chatman.api.ControlMessage;
import tv.periscope.chatman.api.HistoryRequest;
import tv.periscope.chatman.api.HttpService;
import tv.periscope.chatman.api.WireMessage;

// Referenced classes of package o:
//            aul, aso, asq, aui, 
//            abm, FF6A, auf, auh, 
//            is, ig, xx, asp, 
//            acd, ql

public final class xw
{

    private final boolean aUc;
    private final boolean aUd;
    private final Histogram aUe = new Histogram(new UniformReservoir());
    private aso aUf;
    private acd aUg;
    private boolean aUh;
    private boolean aUi;

    public xw(boolean flag, boolean flag1)
    {
        aUc = flag;
        aUd = flag1;
    }

    public final void kill()
    {
        if (aUf != null)
        {
            aso aso1 = aUf;
            aul._mth02BF("ChatMan", "kill client");
            aso1.aUv = false;
            if (aso1.bDi != null)
            {
                aso1.bDi.bDs = false;
            }
            aso1.bCZ.clear();
            aUf = null;
        }
    }

    public final void _mth02CA(String s, String s1, String s2, String s3, acd acd, boolean flag, int i, 
            int j, ql ql, SignerService signerservice, retrofit.RestAdapter.LogLevel loglevel)
    {
        aUg = acd;
        aUh = flag;
        if (aUd && i > 0 && (aui._mth02BF(s) || aui._mth02BF(s1)))
        {
            abm._mth02CA(s, s1, "", ql, signerservice);
            aUi = true;
            FF6A._mth02CB("RTMP", "PubNub will be used");
        } else
        {
            FF6A._mth02CB("RTMP", "PubNub will not be used");
        }
        if (aUc && j > 0 && aui._mth02BF(s2) && aui._mth02BF(s3))
        {
            aUf = aso._mth02CA(new aso._cls02CA(ql, aUi, aUe), s2, s3, j, loglevel);
            FF6A._mth02CB("RTMP", "ChatMan will be used");
            return;
        } else
        {
            FF6A._mth02CB("RTMP", "ChatMan will not be used.");
            return;
        }
    }

    public final void _mth02CA(String s, auf auf1)
    {
        s = new PsMessage(s, auf1);
        if (aUi)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("PubNub: sending message ")).append(((PsMessage) (s)).type).toString());
            abm._mth02CA(auf1.fx(), s);
        }
        if (aUf != null)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("ChatMan: sending message ")).append(((PsMessage) (s)).type).toString());
            Object obj = aUf;
            if ((((aso) (obj)).bDe & 4) == 0)
            {
                aul._mth02BF("ChatMan", (new StringBuilder("send not allowed: cap=")).append(((aso) (obj)).bDe).toString());
                return;
            }
            if (((aso) (obj)).bDh == null)
            {
                aul._mth02CA("ChatMan", "no room to send message");
                return;
            }
            if (((aso) (obj)).bCZ.size() >= 100)
            {
                aul._mth02CE("ChatMan", (new StringBuilder("queue full, drop message:")).append(s).toString());
                return;
            }
            auf1 = ((aso) (obj)).bCZ;
            obj = ((aso) (obj)).bDh;
            ig ig1 = auh.bFf;
            if (s == null)
            {
                s = ig1._mth02CA(is.GB);
            } else
            {
                s = ig1._mth02CA(s, s.getClass());
            }
            auf1.offer(WireMessage.create(new ChatMessage(((String) (obj)), s)));
        }
    }

    public final void _mth02CA(xx xx1)
    {
        if (aUi)
        {
            FF6A._mth02CB("RTMP", "PubNub: leaving channel");
            abm._mth155D(xx1.aUj);
        }
        if (aUf != null)
        {
            FF6A._mth02CB("RTMP", "ChatMan: leaving channel");
            aso aso1 = aUf;
            xx1 = xx1.aUk;
            if ((aso1.bDe & 1) == 0)
            {
                aul._mth02BF("ChatMan", (new StringBuilder("leave room=")).append(xx1).append(" not allowed: cap=").append(aso1.bDe).toString());
                return;
            }
            if (!xx1.equals(aso1.bDh))
            {
                aul._mth02CA("ChatMan", "leaveroom", new IllegalStateException((new StringBuilder("not in room=")).append(xx1).append(" to leave it").toString()));
                return;
            }
            aul._mth02BF("ChatMan", (new StringBuilder("queue leave room ")).append(xx1).toString());
            aso1.bDh = null;
            aso1.bCZ.offer(WireMessage.create(ControlMessage.create(new tv.periscope.chatman.api.ControlMessage.Leave(xx1))));
            aso1.bDa.eE();
        }
    }

    public final void _mth02CA(xx xx1, String s, String s1, String s2)
    {
        if (aUi && xx1 != null && aui._mth02BF(xx1.aUj) && s1 != null)
        {
            FF6A._mth02CB("RTMP", "PubNub: fetching history");
            abm._mth02CA(xx1.aUj, Long.valueOf(s1).longValue(), aUg, aUh);
        }
        if (aUf != null && s != null && s2 != null)
        {
            FF6A._mth02CB("RTMP", "ChatMan: fetching history");
            xx1 = aUf;
            if ((((aso) (xx1)).bDe & 2) == 0)
            {
                aul._mth02BF("ChatMan", (new StringBuilder("history read not allowed. cap=")).append(((aso) (xx1)).bDe).toString());
                return;
            }
            if (((aso) (xx1)).bDc != null && !aui.isEmpty(s))
            {
                ((aso) (xx1)).bDc.history(new HistoryRequest(s, s2, Integer.valueOf(1000)), new asp(xx1, s2));
            }
        }
    }

    public final void _mth02CA(xx xx1, String s, String s1, String s2, String s3, String s4, String s5, 
            int i)
    {
        if (aUi)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("PubNub: joining channel ")).append(xx1.aUj).toString());
            abm._mth02CA(xx1.aUj, s, aUg, aUh, s1, s2, s3, s4, s5, i);
        }
        if (aUf != null)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("ChatMan: joining channel ")).append(xx1.aUk).toString());
            s = aUf;
            xx1 = xx1.aUk;
            if ((((aso) (s)).bDe & 1) == 0)
            {
                aul._mth02BF("ChatMan", (new StringBuilder("join room=")).append(xx1).append(" not allowed: cap=").append(((aso) (s)).bDe).toString());
                return;
            }
            if (((aso) (s)).bDh != null)
            {
                aul._mth02CA("ChatMan", "invalid joinroom", new IllegalStateException((new StringBuilder("join another room=")).append(xx1).append(" while still on room=").append(((aso) (s)).bDh).toString()));
                s.bDh = null;
            }
            ((aso) (s)).bCZ.offer(WireMessage.create(ControlMessage.create(new tv.periscope.chatman.api.ControlMessage.Join(xx1))));
            aul._mth02BF("ChatMan", (new StringBuilder("queue join room ")).append(xx1).toString());
            s.bDh = xx1;
            ((aso) (s)).bDa.eC();
        }
    }

    public final void _mth02CB(xx xx1)
    {
        if (aUi)
        {
            FF6A._mth02CB("RTMP", "PubNub: here now");
            abm._mth1D58(xx1.aUj);
        }
        if (aUf != null)
        {
            FF6A._mth02CB("RTMP", "ChatMan: roster");
            aso aso1 = aUf;
            xx1 = xx1.aUk;
            if ((aso1.bDe & 2) == 0)
            {
                aul._mth02BF("ChatMan", (new StringBuilder("roster read not allowed. cap=")).append(aso1.bDe).toString());
                return;
            }
            if (aso1.bDh == null)
            {
                aul._mth02CA("ChatMan", "roster message before joining a room");
                return;
            }
            aso1.bCZ.offer(WireMessage.create(ControlMessage.create(new tv.periscope.chatman.api.ControlMessage.Roster(xx1))));
        }
    }

    public final ChatStats FED0()
    {
        if (aUf != null)
        {
            Snapshot snapshot = aUe.getSnapshot();
            ChatStats chatstats = new ChatStats();
            chatstats.sent = aUf.bDg;
            chatstats.received = aUf.bDf;
            chatstats.latencyMin = snapshot.getMin();
            chatstats.latencyMax = snapshot.getMax();
            chatstats.latencyMedian = snapshot.getMedian();
            chatstats.latencyMean = snapshot.getMean();
            chatstats.latencyStdDev = snapshot.getStdDev();
            chatstats.latencyP95 = snapshot.get95thPercentile();
            chatstats.latencyP99 = snapshot.get99thPercentile();
            return chatstats;
        } else
        {
            return null;
        }
    }
}
