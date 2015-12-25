// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            ne, nq, mw, akv, 
//            yv, atn, ato, gj, 
//            _cls0675, er, my, gi, 
//            mx

public final class akw extends ne
{
    public static final class if extends Enum
    {

        public static final if brb;
        public static final if brc;
        public static final if brd;
        private static final if bre[];

        public static if valueOf(String s)
        {
            return (if)Enum.valueOf(o/akw$if, s);
        }

        public static if[] values()
        {
            return (if[])bre.clone();
        }

        static 
        {
            brb = new if("Live", 0);
            brc = new if("Replay", 1);
            brd = new if("Mixed", 2);
            bre = (new if[] {
                brb, brc, brd
            });
        }

        private if(String s, int i)
        {
            super(s, i);
        }
    }


    private final nq KE;
    public final nq bqS;
    private final nq bqT;
    public final nq bqU;
    private final nq bqV;
    public final nq bqW;
    public HashMap bqX;
    public HashMap bqY;
    public HashMap bqZ;
    public final yv mBroadcastCacheManager;
    private final Context mContext;

    public akw(Context context, er er, my my, yv yv1)
    {
        super(context, er, my);
        bqX = new HashMap();
        bqY = new HashMap();
        bqZ = new HashMap();
        mContext = context;
        KE = new nq(context);
        bqS = new nq(context);
        bqT = new nq(context);
        bqU = new nq(context);
        bqV = new nq(context);
        bqW = new nq(context);
        mBroadcastCacheManager = yv1;
        context = LayoutInflater.from(mContext).inflate(0x7f03005a, null);
        KE.setContentView(context);
        KE.setBackground(null);
        context = LayoutInflater.from(mContext).inflate(0x7f03005b, null);
        bqS.setContentView(context);
        bqS.setBackground(null);
        context = LayoutInflater.from(mContext).inflate(0x7f03005e, null);
        bqT.setContentView(context);
        bqT.setBackground(null);
        context = LayoutInflater.from(mContext).inflate(0x7f03005f, null);
        bqU.setContentView(context);
        bqU.setBackground(null);
        context = LayoutInflater.from(mContext).inflate(0x7f03005c, null);
        bqV.setContentView(context);
        bqV.setBackground(null);
        context = LayoutInflater.from(mContext).inflate(0x7f03005d, null);
        bqW.setContentView(context);
        bqW.setBackground(null);
    }

    private gi _mth02CA(if if1, int i, int j)
    {
        public static final class _cls1
        {

            public static final int bra[];

            static 
            {
                bra = new int[if.values().length];
                try
                {
                    bra[if.brc.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bra[if.brd.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bra[if.brb.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
            }
        }

        switch (_cls1.bra[if1.ordinal()])
        {
        case 1: // '\001'
            if1 = bqT;
            if (((nq) (if1)).LJ != null)
            {
                ((nq) (if1)).LJ.setText(String.valueOf(i));
            }
            if1 = if1._mth1F32();
            break;

        case 2: // '\002'
            if1 = bqV;
            if (((nq) (if1)).LJ != null)
            {
                ((nq) (if1)).LJ.setText(String.valueOf(j));
            }
            if1 = if1._mth1F32();
            break;

        default:
            if1 = KE;
            if (((nq) (if1)).LJ != null)
            {
                ((nq) (if1)).LJ.setText(String.valueOf(j));
            }
            if1 = if1._mth1F32();
            break;
        }
        return _cls141D.if._mth02CA(if1);
    }

    private int _mth02CE(mw mw1)
    {
        int i = 0;
        mw1 = mw1._mth1595().iterator();
        do
        {
            if (!mw1.hasNext())
            {
                break;
            }
            Object obj1 = (akv)mw1.next();
            Object obj = mBroadcastCacheManager;
            obj1 = ((akv) (obj1)).broadcastId;
            obj = (atn)((yv) (obj)).aWg.get(obj1);
            if (obj != null)
            {
                boolean flag;
                if (((atn) (obj)).bDW == ato.bEd)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                int j = i;
                if (flag)
                {
                    j = i + 1;
                }
                i = j;
            }
        } while (true);
        return i;
    }

    protected final void _mth02CA(mw mw1, MarkerOptions markeroptions)
    {
        super._mth02CA(mw1, markeroptions);
        int i = _mth02CE(mw1);
        int j = mw1.getSize();
        if (i > 0)
        {
            if (i == mw1.getSize())
            {
                mw1 = if.brb;
            } else
            {
                mw1 = if.brd;
            }
        } else
        {
            mw1 = if.brc;
        }
        markeroptions.Fm = _mth02CA(((if) (mw1)), j, i);
        markeroptions.Ff = 0.5F;
        markeroptions.Fg = 0.5F;
        markeroptions.Fo = true;
    }

    protected final void _mth02CA(mw mw1, gj gj1)
    {
        super._mth02CA(mw1, gj1);
        int i = _mth02CE(mw1);
        Object obj;
        if (i > 0)
        {
            if (i == mw1.getSize())
            {
                obj = if.brb;
            } else
            {
                obj = if.brd;
            }
        } else
        {
            obj = if.brc;
        }
        bqY.put(gj1.getId(), obj);
        obj = bqX;
        gj1 = gj1.getId();
        if (i <= 0)
        {
            i = mw1.getSize();
        }
        ((HashMap) (obj)).put(gj1, Integer.valueOf(i));
    }

    protected final void _mth02CA(mx mx, MarkerOptions markeroptions)
    {
        mx = (akv)mx;
        super._mth02CA(mx, markeroptions);
        Object obj = mBroadcastCacheManager;
        String s = ((akv) (mx)).broadcastId;
        obj = (atn)((yv) (obj)).aWg.get(s);
        if (obj == null)
        {
            _cls0675._mth02CB(new Exception((new StringBuilder("onBeforeClusterItemRendered: Broadcast wasn't in cache ")).append(((akv) (mx)).broadcastId).toString()));
            return;
        }
        boolean flag;
        if (((atn) (obj)).bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int i;
        if (flag)
        {
            i = 0x7f0200bc;
        } else
        {
            i = 0x7f0200bd;
        }
        markeroptions.Fm = _cls141D.if._mth02CE(i);
        markeroptions.Ff = 0.5F;
        markeroptions.Fg = 0.5F;
        markeroptions.Fo = true;
    }

    protected final void _mth02CA(mx mx, gj gj1)
    {
        mx = (akv)mx;
        super._mth02CA(mx, gj1);
        bqX.put(gj1.getId(), Integer.valueOf(0));
        bqZ.put(gj1.getId(), ((akv) (mx)).broadcastId);
    }

    protected final boolean _mth02CB(mw mw1)
    {
        return mw1.getSize() > 1;
    }

    public final void _mth02CE(Set set)
    {
        bqX.clear();
        bqZ.clear();
        super._mth02CE(set);
    }

    public final gi _mth156A(String s)
    {
        Integer integer = (Integer)bqX.get(s);
        if (integer == null)
        {
            return null;
        }
        if (integer.intValue() == 0)
        {
            s = (String)bqZ.get(s);
            s = (atn)mBroadcastCacheManager.aWg.get(s);
            if (s == null)
            {
                return null;
            }
            boolean flag;
            if (((atn) (s)).bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int i;
            if (flag)
            {
                i = 0x7f0200bc;
            } else
            {
                i = 0x7f0200bd;
            }
            return _cls141D.if._mth02CE(i);
        } else
        {
            return _mth02CA((if)bqY.get(s), integer.intValue(), integer.intValue());
        }
    }
}
