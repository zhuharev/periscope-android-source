// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Snapshot;
import com.codahale.metrics.UniformReservoir;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import tv.periscope.android.api.PsMessage;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package o:
//            oe, it, is, kd, 
//            abn, os, abo, aui, 
//            ql, acd, nx, abp, 
//            FF6A, io, iq, or

public final class abm
{
    static final class if extends nx
    {

        public final void _mth02CA(String s, io io)
        {
            (new StringBuilder("hereNow connectCallback ")).append(io);
        }

        public final void _mth02CA(String s, iq iq)
        {
            (new StringBuilder("hereNow successCallback ")).append(iq);
            abm.av()._mth1429(new abp(iq));
        }

        public final void _mth02CA(String s, or or)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("PubNub hereNow errorCallback ")).append(or).toString());
        }

        public final void _mth02CB(String s, io io)
        {
            (new StringBuilder("hereNow reconnectCallback ")).append(io);
        }

        public final void _mth02CE(String s, io io)
        {
            (new StringBuilder("hereNow disconnectCallback ")).append(io);
        }

        public final void _mth02CE(iq iq)
        {
        }

        private if()
        {
        }

        if(byte byte0)
        {
            this();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    private static ql aQE;
    private static final HashSet bcg = new HashSet();
    private static int bch;
    private static int bci;
    private static int bcj;
    private static int bck;
    private static Histogram bcl = new Histogram(new UniformReservoir());
    private static HashMap bcm = new HashMap();
    private static String bcn;
    private static String bco;
    private static String bcp;
    private static SignerService bcq;

    public static int am()
    {
        return bci;
    }

    public static int an()
    {
        return bch;
    }

    public static int ao()
    {
        return bcg.size();
    }

    public static int ap()
    {
        return bcj;
    }

    public static int aq()
    {
        return bck;
    }

    public static Snapshot ar()
    {
        return bcl.getSnapshot();
    }

    public static void as()
    {
        bcg.clear();
        bch = 0;
        bci = 0;
        bcj = 0;
        bck = 0;
        bcl = new Histogram(new UniformReservoir());
    }

    static int at()
    {
        int i = bch;
        bch = i + 1;
        return i;
    }

    static Set au()
    {
        return bcg;
    }

    static ql av()
    {
        return aQE;
    }

    static int aw()
    {
        int i = bck;
        bck = i + 1;
        return i;
    }

    static int ax()
    {
        int i = bcj;
        bcj = i + 1;
        return i;
    }

    static int ay()
    {
        int i = bci;
        bci = i + 1;
        return i;
    }

    static Histogram az()
    {
        return bcl;
    }

    public static void _mth02CA(String s, long l, acd acd, boolean flag)
    {
        oe oe1 = (oe)bcm.get(s);
        if (oe1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        } else
        {
            oe1._mth02CA(s, l, -1L, 100, true, true, new _cls02CA(String.valueOf(l), acd, flag));
            return;
        }
    }

    public static void _mth02CA(String s, String s1, String s2, ql ql, SignerService signerservice)
    {
        bcn = s;
        bco = s1;
        bcp = s2;
        aQE = ql;
        bcq = signerservice;
    }

    public static void _mth02CA(String s, String s1, acd acd, boolean flag, String s2, String s3, String s4, String s5, 
            String s6, int i)
    {
        Object obj = new oe(bcn, bco, bcp, "", false);
        ((oe) (obj))._mth15EE(s1);
        bcm.put(s, obj);
        obj = (new StringBuilder("SE-a-")).append(s2).toString();
        s1 = (oe)bcm.get(s);
        if (s1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        }
        s1._mth1D38(((String) (obj)));
        s1 = (oe)bcm.get(s);
        if (s1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        }
        s1._mth1601(30);
        as();
        it it1 = new it();
        it1._mth02BD("username", s3);
        it1._mth02BD("display_name", s4);
        it1._mth02BD("id", s2);
        it1._mth02BD("initials", s5);
        s2 = it._mth02CA(Integer.valueOf(i));
        s1 = s2;
        if (s2 == null)
        {
            s1 = is.GB;
        }
        it1.GC.put("participant_index", s1);
        it1._mth02BD("pub_nub_profile_image", s6);
        s1 = (oe)bcm.get(s);
        if (s1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        } else
        {
            s1._mth02CA(s, ((String) (obj)), it1, new abn(s, acd, flag));
            return;
        }
    }

    static void _mth02CA(String s, acd acd, boolean flag)
    {
        oe oe1 = (oe)bcm.get(s);
        if (oe1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        }
        try
        {
            oe1._mth02CA(s, new _cls02CF(acd, flag));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    static void _mth02CA(String s, it it1)
    {
        oe oe1 = (oe)bcm.get(s);
        if (oe1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        } else
        {
            oe1._mth02CA(s, it1, new _cls02CE());
            return;
        }
    }

    public static void _mth02CA(String s, PsMessage psmessage)
    {
        bcq.sign(psmessage, new abo(s, psmessage));
    }

    public static void _mth155D(String s)
    {
        if (aui.isEmpty(s))
        {
            return;
        }
        oe oe1 = (oe)bcm.get(s);
        if (oe1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        }
        oe1._mth1D36(s);
        oe1 = (oe)bcm.get(s);
        if (oe1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        } else
        {
            oe1.unsubscribe(s);
            return;
        }
    }

    static void _mth1D52(String s)
    {
        oe oe1;
        try
        {
            oe1 = (oe)bcm.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (oe1 != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        throw new IllegalStateException("Channel not initialized. Did you call init()?");
        oe1._mth02CB(s, new _cls02CB(s));
        return;
    }

    public static void _mth1D58(String s)
    {
        oe oe1 = (oe)bcm.get(s);
        if (oe1 == null)
        {
            throw new IllegalStateException("Channel not initialized. Did you call init()?");
        } else
        {
            oe1._mth02CA(s, true, true, new if((byte)0));
            return;
        }
    }

}
