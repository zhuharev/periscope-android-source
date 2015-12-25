// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import tv.periscope.chatman.api.AuthMessage;
import tv.periscope.chatman.api.ChatMessage;
import tv.periscope.chatman.api.ControlMessage;
import tv.periscope.chatman.api.HttpClient;
import tv.periscope.chatman.api.HttpService;
import tv.periscope.chatman.api.WireMessage;

// Referenced classes of package o:
//            ast, aui, asu, auh, 
//            ig, aul, asq, asv, 
//            ass

public final class aso
{
    final class if
        implements asq.if
    {

        private aso bDl;

        public final void eB()
        {
            aso._mth037A(bDl);
        }

        public final void _mth02CA(asq asq1, IOException ioexception)
        {
            if (aso._mth141D(bDl) != null && aso._mth141D(bDl).bDn == asq1)
            {
                asq1 = aso._mth141D(bDl);
                aul._mth02BF("ChatMan", (new StringBuilder("Stopping Writer=")).append(asq1).toString());
                asq1.mStopped = true;
                aso._mth02CA(bDl, null);
            }
            if (!aso._mth02CB(bDl))
            {
                return;
            }
            if (ioexception instanceof EOFException)
            {
                bDl.kill();
                return;
            } else
            {
                aso._mth02CA(bDl, aso._mth02BB(bDl));
                return;
            }
        }

        public final void _mth02CA(asq asq1, String s)
        {
            aso._mth02CA(bDl, null);
            aso._mth02CA(bDl, new _cls02CB(bDl, asq1));
            if (aui._mth02BF(s))
            {
                aul._mth02BF("ChatMan", (new StringBuilder("connected, queue rejoin room=")).append(s).toString());
                aso._mth02CE(bDl).offerFirst(WireMessage.create(ControlMessage.create(new tv.periscope.chatman.api.ControlMessage.Join(s))));
                aso._mth02CA(bDl).eD();
            }
            aso._mth02CE(bDl).offerFirst(WireMessage.create(new AuthMessage(asq1.accessToken)));
            aso.eA().execute(aso._mth141D(bDl));
        }

        public final void _mth02CA(WireMessage wiremessage)
        {
            switch (wiremessage.kind)
            {
            case 1: // '\001'
                if ((aso._mth02BC(bDl) & 2) == 0)
                {
                    aul._mth02BF("ChatMan", (new StringBuilder("read not allowed. cap=")).append(aso._mth02BC(bDl)).toString());
                } else
                {
                    ChatMessage chatmessage = (ChatMessage)auh.bFf._mth02CA(wiremessage.payload, tv/periscope/chatman/api/ChatMessage);
                    aul._mth02BF("ChatMan", (new StringBuilder("decoded chat message: ")).append(chatmessage).toString());
                    aso._mth02CA(bDl)._mth02CA(new asv(chatmessage.room, chatmessage.body, chatmessage.sender, chatmessage.timestamp, wiremessage.payload));
                }
                break;

            case 2: // '\002'
                wiremessage = (ControlMessage)auh.bFf._mth02CA(wiremessage.payload, tv/periscope/chatman/api/ControlMessage);
                aul._mth02BF("ChatMan", (new StringBuilder("decoded control message: ")).append(wiremessage).toString());
                aso._mth02CA(bDl, wiremessage);
                break;

            default:
                throw new ass((new StringBuilder("Unexpected message kind=")).append(wiremessage.kind).toString());
            }
            aso._mth02BD(bDl);
        }

        if()
        {
            bDl = aso.this;
            super();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private static final ExecutorService aQL = Executors.newCachedThreadPool();
    public volatile boolean aUv;
    public final LinkedBlockingDeque bCZ = new LinkedBlockingDeque();
    public final _cls02CA bDa;
    private final ast bDb;
    public final HttpService bDc;
    private final if bDd = new if();
    public final int bDe;
    public int bDf;
    public int bDg;
    public volatile String bDh;
    public volatile asq bDi;
    private volatile _cls02CB bDj;

    private aso(_cls02CA _pcls02ca, ast ast1, int i, retrofit.RestAdapter.LogLevel loglevel)
    {
        aUv = true;
        bDa = _pcls02ca;
        bDb = ast1;
        bDc = (new HttpClient(aQL, ast1.eF(), loglevel)).getService();
        aUv = true;
        bDe = i;
    }

    static Executor eA()
    {
        return aQL;
    }

    static String _mth02BB(aso aso1)
    {
        return aso1.bDh;
    }

    static int _mth02BC(aso aso1)
    {
        return aso1.bDe;
    }

    static int _mth02BD(aso aso1)
    {
        int i = aso1.bDf;
        aso1.bDf = i + 1;
        return i;
    }

    static _cls02CA _mth02CA(aso aso1)
    {
        return aso1.bDa;
    }

    static _cls02CB _mth02CA(aso aso1, _cls02CB _pcls02cb)
    {
        aso1.bDj = _pcls02cb;
        return _pcls02cb;
    }

    public static aso _mth02CA(_cls02CA _pcls02ca, String s, String s1, int i, retrofit.RestAdapter.LogLevel loglevel)
    {
        if (aui.isEmpty(s) || aui.isEmpty(s1))
        {
            throw new IllegalArgumentException((new StringBuilder("accessToken=")).append(s).append(", endpoint=").append(s1).toString());
        } else
        {
            _pcls02ca = new aso(_pcls02ca, new asu(s1, s), i, loglevel);
            _pcls02ca.FE92(null);
            return _pcls02ca;
        }
    }

    static asq _mth02CA(aso aso1, asq asq1)
    {
        aso1.bDi = null;
        return null;
    }

    static void _mth02CA(aso aso1, String s)
    {
        aso1.FE92(s);
    }

    static void _mth02CA(aso aso1, ControlMessage controlmessage)
    {
        switch (controlmessage.bodyKind)
        {
        case 4: // '\004'
            controlmessage = (tv.periscope.chatman.api.ControlMessage.Presence)auh.bFf._mth02CA(controlmessage.body, tv/periscope/chatman/api/ControlMessage$Presence);
            asx.if if1 = new asx.if();
            if1.bDy = Integer.valueOf(-1);
            controlmessage = if1._mth02CD(Collections.emptyList())._mth013C(((tv.periscope.chatman.api.ControlMessage.Presence) (controlmessage)).occupancy).eR();
            aso1.bDa._mth02CB(controlmessage);
            return;

        case 3: // '\003'
            controlmessage = (tv.periscope.chatman.api.ControlMessage.Roster)auh.bFf._mth02CA(controlmessage.body, tv/periscope/chatman/api/ControlMessage$Roster);
            asx.if if2 = new asx.if();
            if2.bDy = Integer.valueOf(-1);
            controlmessage = if2._mth02CD(Collections.emptyList())._mth02CD(Collections.unmodifiableList(((tv.periscope.chatman.api.ControlMessage.Roster) (controlmessage)).occupants)).eR();
            aso1.bDa._mth02CA(controlmessage);
            return;
        }
        aul._mth02CE("ChatMan", (new StringBuilder("Unknown control message, kind=?")).append(controlmessage.bodyKind).toString());
    }

    static boolean _mth02CB(aso aso1)
    {
        return aso1.aUv;
    }

    static BlockingDeque _mth02CE(aso aso1)
    {
        return aso1.bCZ;
    }

    static if _mth02CF(aso aso1)
    {
        return aso1.bDd;
    }

    static int _mth037A(aso aso1)
    {
        int i = aso1.bDg;
        aso1.bDg = i + 1;
        return i;
    }

    static _cls02CB _mth141D(aso aso1)
    {
        return aso1.bDj;
    }

    private void FE92(String s)
    {
        if ((bDe & 1) == 0)
        {
            aul._mth02BF("ChatMan", (new StringBuilder("connect not allowed: cap=")).append(bDe).toString());
            return;
        }
        if (bDi != null)
        {
            aul._mth02BF("ChatMan", "already connecting");
            return;
        }
        if (bDj != null)
        {
            aul._mth02BF("ChatMan", "already connected");
            return;
        } else
        {
            Object obj = bDb;
            ExecutorService executorservice = aQL;
            obj = new asq(bDd, ((ast) (obj)));
            executorservice.execute(new asq._cls02CB(((asq) (obj)), s));
            bDi = ((asq) (obj));
            return;
        }
    }

    public final void kill()
    {
        aul._mth02BF("ChatMan", "kill client");
        aUv = false;
        if (bDi != null)
        {
            bDi.bDs = false;
        }
        bCZ.clear();
    }

}
