// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

// Referenced classes of package o:
//            og, pa, ox, oc, 
//            pc, os, or, op, 
//            iq, iv, oa, pf, 
//            nx, io, ou, ot, 
//            ov, aul, oj, oz, 
//            it, kd, ok, iu, 
//            is, om, ol, oi, 
//            oh, pb, on

abstract class of
{
    final class if extends pb
    {

        final of ME;
        nx MI;

        public final void run()
        {
            String as[] = ME._mth4E3F();
            if (as == null)
            {
                return;
            }
            Hashtable hashtable = ot._mth02BB(ME.Ma);
            if (hashtable.get("uuid") == null)
            {
                hashtable.put("uuid", ME.UUID);
            }
            String s = of._mth02CA(ME);
            if (s != null)
            {
                hashtable.put("state", s);
            }
            if (of._mth02CB(ME) > 0 && of._mth02CB(ME) < 320)
            {
                hashtable.put("heartbeat", String.valueOf(of._mth02CB(ME)));
            }
            oa oa1 = new oa(as, hashtable, new on(this));
            ME._mth02CA(oa1, ME.Mu);
        }

        if(int i, nx nx1)
        {
            ME = of.this;
            super(i);
            MI = nx1;
        }
    }


    protected static String VERSION = "";
    private int MA;
    private int MB;
    private volatile int MC;
    private og MD;
    protected Hashtable Ma;
    private String Me;
    private int Mf;
    private String Mg;
    private String Mh;
    private String Mi;
    private String Mj;
    private String Mk;
    private String Ml;
    private String Mm;
    private volatile String Mn;
    private volatile boolean Mo;
    private volatile boolean Mp;
    private boolean Mq;
    private pa Mr;
    private pa Ms;
    private ox Mt;
    protected oc Mu;
    private pc Mv;
    private volatile String Mw;
    private volatile String Mx;
    private String My;
    private Random Mz;
    protected String UUID;

    public of(String s, String s1, String s2, String s3, boolean flag)
    {
        Me = "pubsub";
        Mf = 1;
        Mg = "pubnub.com";
        Mh = null;
        Mi = "";
        Mj = "";
        Mk = "";
        Ml = "";
        Mm = null;
        Mn = null;
        Mo = true;
        Mq = true;
        UUID = null;
        Mw = "0";
        Mx = "0";
        My = "-pnpres";
        Mz = new Random();
        MA = 0;
        MB = 320;
        MC = 0;
        MD = new og(this);
        Mi = s;
        Mj = s1;
        Mk = s2;
        Ml = s3;
        Mq = flag;
        if (UUID == null)
        {
            UUID = _mth1F35();
        }
        if (Mr == null)
        {
            Mr = new pa();
        }
        if (Ms == null)
        {
            Ms = new pa();
        }
        if (Mt == null)
        {
            Mt = new ox((new StringBuilder("Subscribe-Manager-")).append(System.identityHashCode(this)).toString(), 10000, 0x4baf0);
        }
        if (Mu == null)
        {
            Mu = new oc((new StringBuilder("Non-Subscribe-Manager-")).append(System.identityHashCode(this)).toString(), 10000, 15000);
        }
        if (Mv == null)
        {
            Mv = new pc();
        }
        if (Ma == null)
        {
            Ma = new Hashtable();
        }
        Ma.put("pnsdk", getUserAgent());
        Mt._mth1FBE("V", VERSION);
        Mt._mth1FBE("Accept-Encoding", "gzip");
        Mt._mth1FBE("User-Agent", getUserAgent());
        Mu._mth1FBE("V", VERSION);
        Mu._mth1FBE("Accept-Encoding", "gzip");
        Mu._mth1FBE("User-Agent", getUserAgent());
    }

    static pa _mth02BB(of of1)
    {
        return of1.Ms;
    }

    static String _mth02CA(of of1)
    {
        return of1.FB31();
    }

    static String _mth02CA(of of1, String s)
    {
        of1.Mw = s;
        return s;
    }

    static or _mth02CA(of of1, os os1, or or1, int i, String s)
    {
        os1 = os1.Nq;
        of1 = os1;
        if (os1 == null)
        {
            of1 = or._mth02CA(or1, 10, s);
        }
        return of1;
    }

    private static void _mth02CA(Hashtable hashtable)
    {
        String s = (String)hashtable.get("channel");
        String s1 = (String)hashtable.get("group");
        if (s != null && !s.equals(""))
        {
            hashtable.put("channels", new String[] {
                s
            });
            hashtable.remove("channel");
        }
        if (s1 != null && !s1.equals(""))
        {
            hashtable.put("groups", new String[] {
                s1
            });
            hashtable.remove("group");
        }
    }

    static void _mth02CA(of of1, String s, nx nx1, iq iq1, String s1, oa oa1)
    {
        if (of1.Ml.length() <= 0 || s.endsWith(of1.My)) goto _L2; else goto _L1
_L1:
        boolean flag;
        of1 = new op(of1.Ml, null);
        try
        {
            of1 = of1._mth1D40(iq1.toString());
            of1 = (new iv())._mth02CA(new StringReader(of1));
        }
        // Misplaced declaration of an exception variable
        catch (of of1)
        {
            if (oa1 == null || oa1.Md == null)
            {
                flag = false;
            } else
            {
                flag = oa1.Md.NI;
            }
            if (!flag)
            {
                nx1._mth02CA(s, or._mth02CA(or.MQ, 12, iq1.toString()));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (of of1)
        {
            if (oa1 == null || oa1.Md == null)
            {
                flag = false;
            } else
            {
                flag = oa1.Md.NI;
            }
            if (!flag)
            {
                s1 = or.MQ;
                oa1 = (new StringBuilder()).append(iq1.toString()).append(" : ").append(of1.toString()).toString();
                iq1 = ((os) (of1)).Nq;
                of1 = iq1;
                if (iq1 == null)
                {
                    of1 = or._mth02CA(s1, 16, oa1);
                }
                nx1._mth02CA(s, of1);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (of of1)
        {
            if (oa1 == null || oa1.Md == null)
            {
                flag = false;
            } else
            {
                flag = oa1.Md.NI;
            }
            if (!flag)
            {
                nx1._mth02CA(s, or._mth02CA(or.MQ, 15, (new StringBuilder()).append(iq1.toString()).append(" : ").append(of1.toString()).toString()));
            }
            return;
        }
        if (oa1 == null) goto _L4; else goto _L3
_L3:
        if (oa1.Md != null) goto _L5; else goto _L4
_L5:
        flag = oa1.Md.NI;
_L7:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        nx1._mth02CA(s, of1);
        nx1._mth02CE(of1);
        return;
_L2:
        if (oa1 == null || oa1.Md == null)
        {
            flag = false;
        } else
        {
            flag = oa1.Md.NI;
        }
        if (!flag)
        {
            nx1._mth02CA(s, iq1);
            nx1._mth02CE(iq1);
        }
        return;
_L4:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void _mth02CA(of of1, io io1)
    {
        if (of1.Ml.length() > 0)
        {
            for (int i = 0; i < io1.GA.size(); i++)
            {
                Object obj = (new op(of1.Ml, null))._mth1D40(((iq)io1.GA.get(i)).toString());
                obj = (new iv())._mth02CA(new StringReader(((String) (obj))));
                io1.GA.set(i, obj);
            }

        }
    }

    static void _mth02CA(of of1, boolean flag)
    {
        of1._mth02CA(false, false, ((pf) (null)));
    }

    static void _mth02CA(of of1, boolean flag, pf pf1)
    {
        of1._mth02CA(false, false, pf1);
    }

    static void _mth02CA(of of1, boolean flag, boolean flag1, pf pf1)
    {
        of1._mth02CA(false, flag1, pf1);
    }

    private void _mth02CA(boolean flag, boolean flag1, pf pf1)
    {
        Object obj = ou._mth02CA(Mr.NA, ",", null);
        Object obj1 = ou._mth02CA(Ms.NA, ",", null);
        String as1[] = ot._mth141D(Mr.NA);
        String as[] = ot._mth141D(Ms.NA);
        if (as1.length <= 0 && as.length <= 0)
        {
            pf1 = Mt;
            pf1._mth1F34();
            pf1.FBA3();
            return;
        }
        if (obj == null)
        {
            _mth02CA(as1, or.Nf);
            return;
        }
        if (((String) (obj)).equals(""))
        {
            obj = ",";
        } else
        {
            obj = ot._mth02CB(((String) (obj)));
        }
        String s = FB69();
        String s1 = Mj;
        String s2 = Mw;
        Hashtable hashtable = ot._mth02BB(Ma);
        hashtable.put("uuid", UUID);
        if (as.length > 0)
        {
            hashtable.put("channel-group", obj1);
        }
        obj1 = FB31();
        if (obj1 != null)
        {
            hashtable.put("state", obj1);
        }
        if (MB > 5 && MB < 320)
        {
            hashtable.put("heartbeat", String.valueOf(MB));
        }
        aul._mth02BF("PubNub", (new StringBuilder("Subscribing with timetoken : ")).append(Mw).toString());
        obj1 = new oj(this);
        obj = new oa(new String[] {
            s, "subscribe", s1, obj, "0", s2
        }, hashtable, ((ow) (obj1)));
        if (Mw.equals("0"))
        {
            obj.Mc = true;
            aul._mth02BF("PubNub", "This is a subscribe 0 request");
        }
        obj.Mb = flag1;
        if (pf1 != null && (pf1 instanceof pf))
        {
            obj.Md = pf1;
        }
        pf1 = Mt;
        if (flag)
        {
            pf1.FEB0();
        }
        pf1._mth02CA(((oa) (obj)));
    }

    private void _mth02CA(String as[], or or1)
    {
        for (int i = 0; i < as.length; i++)
        {
            String s = as[i];
            ((oz)Mr.NA.get(s)).MI._mth02CA(s, or1);
        }

    }

    static boolean _mth02CA(of of1, oa oa1)
    {
        if (oa1 == null || oa1.Md == null)
        {
            return false;
        } else
        {
            return oa1.Md.NI;
        }
    }

    static int _mth02CB(of of1)
    {
        return of1.MB;
    }

    static String _mth02CB(of of1, String s)
    {
        of1.Mx = s;
        return s;
    }

    private static boolean _mth02CB(Hashtable hashtable)
    {
        if (!(hashtable.get("callback") instanceof nx) || hashtable.get("callback") == null)
        {
            throw new os("Invalid Callback");
        }
        String as[] = (String[])hashtable.get("channels");
        hashtable = (String[])hashtable.get("groups");
        boolean flag;
        if (as != null && as.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (hashtable != null && hashtable.length > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag && !flag1)
        {
            throw new os("Channel or Channel Group Missing");
        } else
        {
            return true;
        }
    }

    static pa _mth02CE(of of1)
    {
        return of1.Mr;
    }

    private void _mth02CE(Hashtable hashtable)
    {
        _mth02CA(hashtable);
        _mth02CB(hashtable);
        _mth02CF(hashtable);
    }

    static String _mth02CF(of of1)
    {
        return of1.Mx;
    }

    private void _mth02CF(Hashtable hashtable)
    {
        String as1[] = (String[])hashtable.get("channels");
        String as2[] = (String[])hashtable.get("groups");
        String as[] = as1;
        if (as1 == null)
        {
            as = new String[0];
        }
        as1 = as2;
        if (as2 == null)
        {
            as1 = new String[0];
        }
        nx nx1 = (nx)hashtable.get("callback");
        hashtable = (String)hashtable.get("timetoken");
        if (!Mw.equals("0"))
        {
            Mx = Mw;
        }
        if (hashtable == null)
        {
            hashtable = "0";
        }
        Mw = hashtable;
        for (int i = 0; i < as.length; i++)
        {
            hashtable = as[i];
            if ((oz)Mr.NA.get(hashtable) == null)
            {
                hashtable = new oz(hashtable, nx1);
                Mr.NA.put(((oz) (hashtable)).name, hashtable);
            }
        }

        for (int j = 0; j < as1.length; j++)
        {
            hashtable = as1[j];
            if ((oz)Ms.NA.get(hashtable) == null)
            {
                hashtable = new oz(hashtable, nx1);
                Ms.NA.put(((oz) (hashtable)).name, hashtable);
            }
        }

        _mth02CA(true, false, ((pf) (null)));
    }

    static String _mth141D(of of1)
    {
        return of1.Mw;
    }

    private void _mth141D(boolean flag, boolean flag1)
    {
        _mth02CA(true, true, ((pf) (null)));
    }

    private String FB31()
    {
        if (Mr.NB.GC.entrySet().size() > 0)
        {
            return Mr.NB.toString();
        } else
        {
            return null;
        }
    }

    private String FB69()
    {
        if (Mh == null)
        {
            if (Mq)
            {
                Mh = "https://";
            } else
            {
                Mh = "http://";
            }
            Mh = (new StringBuilder()).append(Mh).append(Me).toString();
            StringBuilder stringbuilder = (new StringBuilder()).append(Mh);
            String s;
            if (!Mo)
            {
                s = "";
            } else
            {
                s = (new StringBuilder("-")).append(String.valueOf(Mf)).toString();
            }
            Mh = stringbuilder.append(s).toString();
            Mh = (new StringBuilder()).append(Mh).append(".").append(Mg).toString();
        }
        return Mh;
    }

    private void FB87()
    {
        Mh = null;
        Mf = Math.abs(Mz.nextInt());
        if (!Mw.equals("0"))
        {
            Mx = Mw;
        }
        Mw = "0";
        aul._mth02BF("PubNub", (new StringBuilder("Before Resubscribe Timetoken : ")).append(Mw).toString());
        aul._mth02BF("PubNub", (new StringBuilder("Before Resubscribe Saved Timetoken : ")).append(Mx).toString());
        _mth141D(true, true);
    }

    protected abstract String getUserAgent();

    public void unsubscribe(String s)
    {
        _mth02CA(new String[] {
            s
        });
    }

    public void _mth02CA(int i, nx nx1)
    {
        if (nx1 == null)
        {
            nx1 = MD;
        }
        if (i > 0 && i < 5)
        {
            i = 5;
        }
        MB = i;
        if (MC == 0)
        {
            if (MB - 3 > 0)
            {
                i = MB - 3;
            } else
            {
                i = 1;
            }
            MC = i;
        }
        if (MA == 0)
        {
            MA = Mv._mth02CA("Presence-Heartbeat", new if(MC, nx1));
        } else
        if (MC == 0 || MC > 320)
        {
            Mv._mth1D5E(MA);
        } else
        {
            Mv._mth1540(MA, MC);
        }
        _mth2110();
    }

    public void _mth02CA(String s, long l, long l1, int i, boolean flag, 
            boolean flag1, nx nx1)
    {
        if (nx1 == null)
        {
            nx1 = MD;
        }
        Hashtable hashtable = ot._mth02BB(Ma);
        int j = i;
        if (i == -1)
        {
            j = 100;
        }
        hashtable.put("count", String.valueOf(j));
        hashtable.put("reverse", String.valueOf(flag));
        hashtable.put("include_token", String.valueOf(flag1));
        if (l != -1L)
        {
            hashtable.put("start", Long.toString(l).toLowerCase());
        }
        if (l1 != -1L)
        {
            hashtable.put("end", Long.toString(l1).toLowerCase());
        }
        String s1 = FB69();
        String s2 = Mj;
        String s3 = ot._mth02CB(s);
        s = new ok(this, nx1, s);
        s = new oa(new String[] {
            s1, "v2", "history", "sub-key", s2, "channel", s3
        }, hashtable, s);
        Mu._mth02CA(s);
    }

    protected final void _mth02CA(String s, String s1, String s2, nx nx1, int i)
    {
        Object obj;
        try
        {
            obj = (new iv())._mth02CA(new StringReader(s1));
            if (!(obj instanceof it))
            {
                nx1._mth02CA(s, or._mth02CA(or.MS, i, s1));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s2)
        {
            nx1._mth02CA(s, or._mth02CA(or.MS, i, s1));
            return;
        }
        obj = ((iq) (obj))._mth0673();
        aul._mth02BF("PubNub", (new StringBuilder("Looking for ")).append(s2).append(" in ").append(obj).toString());
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (s2.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        s2 = (iq)((it) (obj)).GC.get(s2);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (s2 instanceof it)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        nx1._mth02CA(s, ((iq) (obj)));
        return;
        nx1._mth02CA(s, s2._mth0673());
    }

    public void _mth02CA(String s, String s1, it it1, nx nx1)
    {
        Object obj = Mr;
        String s2 = ot._mth02CB(s);
        oz oz1 = (oz)((pa) (obj)).NA.get(s2);
        if (nx1 == null)
        {
            s = MD;
        } else
        {
            s = nx1;
        }
        nx1 = ot._mth02BB(Ma);
        String s3 = FB69();
        String s4 = Mj;
        String s5 = ot._mth02CB(s1);
        if (it1 != null)
        {
            nx1.put("state", it1.toString());
        }
        if (oz1 != null)
        {
            obj = ((pa) (obj)).NB;
            s1 = it1;
            if (it1 == null)
            {
                s1 = is.GB;
            }
            ((it) (obj)).GC.put(s2, s1);
        }
        s = new om(this, s);
        s = new oa(new String[] {
            s3, "v2", "presence", "sub-key", s4, "channel", s2, "uuid", s5, "data"
        }, nx1, s);
        Mu._mth02CA(s);
    }

    public void _mth02CA(String s, it it1, nx nx1)
    {
        Object obj;
        String s3;
        Hashtable hashtable;
        Object obj1 = new Hashtable();
        ((Hashtable) (obj1)).put("channel", s);
        ((Hashtable) (obj1)).put("message", it1);
        ((Hashtable) (obj1)).put("callback", nx1);
        s3 = (String)((Hashtable) (obj1)).get("channel");
        obj = ((Hashtable) (obj1)).get("message");
        nx1 = (nx)((Hashtable) (obj1)).get("callback");
        if (nx1 == null)
        {
            nx1 = MD;
        }
        s = (String)((Hashtable) (obj1)).get("storeInHistory");
        it1 = obj.toString();
        hashtable = ot._mth02BB(Ma);
        if (s != null && s.length() > 0)
        {
            hashtable.put("store", s);
        }
        if (Ml.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        obj1 = new op(Ml, null);
        s = it1;
        if (obj instanceof String)
        {
            obj = it1;
            try
            {
                s = (new StringBuilder("\"")).append(it1).append("\"").toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                or or1 = or.MP;
                obj = (new StringBuilder()).append(((String) (obj))).append(" : ").append(s.toString()).toString();
                it1 = ((os) (s)).Nq;
                s = it1;
                if (it1 == null)
                {
                    s = or._mth02CA(or1, 4, ((String) (obj)));
                }
                nx1._mth02CA(s3, s);
                return;
            }
        }
        obj = s;
        s = (new StringBuilder("\"")).append(((op) (obj1))._mth1D4B(s)).append("\"").toString();
        break MISSING_BLOCK_LABEL_326;
        s = it1;
        if (obj instanceof String)
        {
            s = (new StringBuilder("\"")).append(it1).append("\"").toString();
        }
        String s1 = "0";
        it1 = s1;
        if (Mk.length() > 0)
        {
            it1 = new StringBuffer();
            it1.append(Mi).append('/').append(Mj).append('/').append(Mk).append('/').append(s3).append('/').append(s);
            try
            {
                it1 = new String(op._mth02BD(op._mth1D57(it1.toString())), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (it it1)
            {
                nx1._mth02CA(s3, or._mth02CA(or.MP, 6, (new StringBuilder()).append(s).append(" : ").append(it1.toString()).toString()));
                it1 = s1;
            }
            // Misplaced declaration of an exception variable
            catch (it it1)
            {
                or or3 = or.MP;
                String s5 = (new StringBuilder()).append(s).append(" : ").append(it1.toString()).toString();
                or or2 = ((os) (it1)).Nq;
                it1 = or2;
                if (or2 == null)
                {
                    it1 = or._mth02CA(or3, 5, s5);
                }
                nx1._mth02CA(s3, it1);
                it1 = s1;
            }
        }
        s1 = FB69();
        String s2 = Mi;
        String s4 = Mj;
        it1 = ot._mth02CB(it1);
        String s6 = ot._mth02CB(s3);
        s = ot._mth02CB(s);
        nx1 = new ol(this, nx1, s3);
        s = new oa(new String[] {
            s1, "publish", s2, s4, it1, s6, "0", s
        }, hashtable, nx1);
        Mu._mth02CA(s);
        return;
    }

    public void _mth02CA(String s, nx nx1)
    {
        _mth02CA(s, nx1, "0");
    }

    public void _mth02CA(String s, nx nx1, String s1)
    {
        _mth02CA(new String[] {
            s
        }, nx1, s1);
    }

    public void _mth02CA(String s, boolean flag, boolean flag1, nx nx1)
    {
        _mth02CA(new String[] {
            s
        }, ((String []) (null)), flag, flag1, nx1);
    }

    protected final void _mth02CA(oa oa1, oc oc1)
    {
        oc1._mth02CA(oa1);
    }

    public void _mth02CA(or or1)
    {
        aul._mth02BF("PubNub", (new StringBuilder("Received disconnectAndResubscribe ")).append(or1).toString());
        Mr._mth02CE(or1);
        Ms._mth02CE(or1);
        FB87();
    }

    public void _mth02CA(String as[])
    {
        for (int i = 0; i < as.length; i++)
        {
            Object obj = as[i];
            Mr.NA.remove(obj);
            Mr.NB.GC.remove(obj);
            obj = ot._mth02CB(((String) (obj)));
            Hashtable hashtable = new Hashtable();
            String s = FB69();
            String s1 = Mj;
            hashtable.put("uuid", UUID);
            Object obj1 = _mth1FD6();
            if (obj1 != null && ((String) (obj1)).length() > 0)
            {
                hashtable.put("auth", obj1);
            }
            obj1 = new oi(this);
            obj = new oa(new String[] {
                s, "v2/presence/sub_key", s1, "channel", obj, "leave"
            }, hashtable, ((ow) (obj1)));
            Mu._mth02CA(((oa) (obj)));
        }

        FB87();
    }

    public void _mth02CA(String as[], nx nx1, String s)
    {
        Hashtable hashtable = new Hashtable();
        hashtable.put("channels", as);
        hashtable.put("callback", nx1);
        hashtable.put("timetoken", s);
        _mth02CE(hashtable);
    }

    public void _mth02CA(String as[], String as1[], boolean flag, boolean flag1, nx nx1)
    {
        if (nx1 == null)
        {
            nx1 = MD;
        }
        Hashtable hashtable = ot._mth02BB(Ma);
        ArrayList arraylist = new ArrayList();
        arraylist.add(FB69());
        arraylist.add("v2");
        arraylist.add("presence");
        arraylist.add("sub_key");
        arraylist.add(Mj);
        if (as != null || as1 != null)
        {
            as = ot._mth02CA(as, ",");
            if ("".equals(as))
            {
                as = ",";
            } else
            {
                as = ot._mth02CB(as);
            }
            arraylist.add("channel");
            arraylist.add(as);
        }
        if (flag)
        {
            hashtable.put("state", "1");
        }
        if (!flag1)
        {
            hashtable.put("disable_uuids", "1");
        }
        if (as1 != null && as1.length > 0)
        {
            hashtable.put("channel-group", ot._mth02CA(as1, ","));
        }
        as = new oa((String[])arraylist.toArray(new String[arraylist.size()]), hashtable, new oh(this, nx1));
        Mu._mth02CA(as);
    }

    public void _mth02CB(String s, nx nx1)
    {
        Hashtable hashtable = new Hashtable(2);
        hashtable.put("channels", new String[] {
            (new StringBuilder()).append(s).append(My).toString()
        });
        hashtable.put("callback", nx1);
        _mth02CE(hashtable);
    }

    public void _mth15EE(String s)
    {
        Mn = s;
        if (s == null || s.length() == 0)
        {
            Ma.remove("auth");
        } else
        {
            Ma.put("auth", Mn);
        }
        FB87();
    }

    public void _mth1601(int i)
    {
        _mth02CA(i, ((nx) (null)));
    }

    public void _mth1D36(String s)
    {
        _mth02CA(new String[] {
            (new StringBuilder()).append(s).append(My).toString()
        });
    }

    public void _mth1D38(String s)
    {
        UUID = s;
    }

    abstract String _mth1F35();

    public String _mth1FD6()
    {
        return Mn;
    }

    public void _mth2110()
    {
        _mth02CA(or.Ng);
    }

    public boolean _mth3031()
    {
        return Mp;
    }

    final String[] _mth4E3F()
    {
        String s = ot._mth02CA(Mr.NA, ",", "-pnpres");
        if (s.length() <= 0)
        {
            return null;
        } else
        {
            return (new String[] {
                FB69(), "v2", "presence", "sub-key", Mj, "channel", ot._mth02CB(s), "heartbeat"
            });
        }
    }

}
