// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ajb, ey, aco, aig, 
//            ake, akj, xf, er, 
//            eq, fc, aed, fa, 
//            fk, ara, aqc, ev, 
//            are, aqe, adc, asm, 
//            ajk, ql, aqo, akt, 
//            akb

final class aki extends ajb
    implements ey, aig.aux, aig._cls02CB
{

    private static final long bqw;
    private static final LatLng bqx = new LatLng(30D, -77.567403999999996D);
    private are bkm;
    private final aig bnf;
    private aka.if._cls02CA bph;
    private aka.if.if bpi;
    private final ake bqA;
    private final akj bqB;
    private aqc bqC;
    private final int bqy;
    private final aco bqz;

    aki(ajk ajk, ql ql, ApiManager apimanager, aig aig1, ake ake1, String s, aqo aqo, 
            akt akt, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2)
    {
        super(s, aqo, akt, 0x7f0c004b, 0x7f0c004c, 0x7f0c0049, 0x7f0c004a, 0x7f0c00a4, 0x7f020068, 0x7f0200d4, 0, 0, 0);
        bqy = ajk.getResources().getColor(0x7f0c005a);
        bqz = new aco(ajk);
        bnf = aig1;
        bnf.bmX = this;
        bnf.bmV = this;
        bqA = ake1;
        bqA._mth02CA(this);
        bqB = new akj(this, apimanager, ql);
    }

    static long da()
    {
        return bqw;
    }

    static aka.if.if _mth02CA(aki aki1, aka.if.if if1)
    {
        aki1.bpi = if1;
        return if1;
    }

    static aka.if._cls02CA _mth02CA(aki aki1, aka.if._cls02CA _pcls02ca)
    {
        aki1.bph = _pcls02ca;
        return _pcls02ca;
    }

    static ake _mth02CA(aki aki1)
    {
        return aki1.bqA;
    }

    static aqc _mth02CB(aki aki1)
    {
        return aki1.bqC;
    }

    public final int cA()
    {
        if (bqA.cX())
        {
            return 0x7f02006e;
        } else
        {
            return super.cA();
        }
    }

    public final int cB()
    {
        if (bqA.cX())
        {
            return 0x7f02010b;
        } else
        {
            return super.cB();
        }
    }

    public final int cC()
    {
        if (bqA.cX())
        {
            return bqy;
        } else
        {
            return super.cC();
        }
    }

    protected final void cF()
    {
        xf._mth02CA(xf.if.aSw);
        super.cF();
    }

    public final android.support.v7.widget.RecyclerView.if cO()
    {
        return bnf;
    }

    public final aka.if cP()
    {
        return bqB;
    }

    public final akb cQ()
    {
        return null;
    }

    public final void cR()
    {
        if (bpi != null)
        {
            bpi.cJ();
        }
    }

    public final void cS()
    {
        if (bph != null)
        {
            bph._mth1D65();
        }
    }

    public final Intent _mth02CA(ajk ajk)
    {
        if (bqA.cX())
        {
            Object obj = bqA;
            ajk = ((ake) (obj)).JV;
            obj = _cls141D.if._mth02CA(((ake) (obj)).JV._mth0453());
            try
            {
                ((er) (ajk)).DV._mth02CE(((eq) (obj)).DU);
            }
            // Misplaced declaration of an exception variable
            catch (ajk ajk)
            {
                throw new android.support.v4.app.Fragment.if(ajk);
            }
            return null;
        } else
        {
            return aed._mth1FBE((Activity)ajk);
        }
    }

    public final void _mth02CA(er er1)
    {
        try
        {
            er1.DV._mth14BB(1);
        }
        // Misplaced declaration of an exception variable
        catch (er er1)
        {
            throw new android.support.v4.app.Fragment.if(er1);
        }
        Object obj = _cls141D.if._mth02CA(bqx);
        try
        {
            er1.DV._mth02CB(((eq) (obj)).DU);
        }
        // Misplaced declaration of an exception variable
        catch (er er1)
        {
            throw new android.support.v4.app.Fragment.if(er1);
        }
        obj = er1._mth05D1();
        try
        {
            ((fa) (obj)).EH.FB39(false);
        }
        // Misplaced declaration of an exception variable
        catch (er er1)
        {
            throw new android.support.v4.app.Fragment.if(er1);
        }
        try
        {
            ((fa) (obj)).EH._mth1507(false);
        }
        // Misplaced declaration of an exception variable
        catch (er er1)
        {
            throw new android.support.v4.app.Fragment.if(er1);
        }
        try
        {
            ((fa) (obj)).EH._mth1D36(false);
        }
        // Misplaced declaration of an exception variable
        catch (er er1)
        {
            throw new android.support.v4.app.Fragment.if(er1);
        }
        try
        {
            ((fa) (obj)).EH._mth14BD(false);
        }
        // Misplaced declaration of an exception variable
        catch (er er1)
        {
            throw new android.support.v4.app.Fragment.if(er1);
        }
        bqA._mth02CA(er1, bkm);
    }

    public final boolean _mth02CA(ViewGroup viewgroup, int i, aqe aqe1)
    {
        ara ara1 = (ara)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030059, viewgroup, false);
        ara1.setId(i);
        ara1.setGestureListener(bqA);
        boF = ara1;
        bqC = new aqc((ev)ara1.findViewById(0x7f0d006d));
        bkm = (are)ara1.findViewById(0x7f0d011c);
        if (bqC._mth02BD(null))
        {
            aqc aqc1 = bqC;
            if (aqc1.mCreated)
            {
                aqc1.bzH.onResume();
            }
            aqc1 = bqC;
            if (aqc1.mCreated)
            {
                aqc1.bzH._mth02CA(this);
            }
        } else
        {
            bqC.bzH.setVisibility(8);
        }
        if (bqC.mCreated)
        {
            aqe1.bzU.add(this);
            viewgroup.addView(ara1, 0);
            viewgroup = bqB;
            viewgroup.init();
            viewgroup._mth02CA(null);
            return true;
        } else
        {
            return false;
        }
    }

    public final Intent _mth02CB(ajk ajk)
    {
        return null;
    }

    public final void _mth02CE(String s, boolean flag)
    {
        xf._mth02CA(xf.if.aRE);
        bqz._mth02CE(s, flag);
    }

    public final void _mth0640(int i)
    {
        super._mth0640(i);
        if (!boG)
        {
            bqA.cY();
        }
    }

    public final void _mth14D2(String s)
    {
        super.boI._mth1D65(new adc(s, null));
    }

    public final void _mth1D64(String s)
    {
        xf._mth02CA(xf.if.aRE);
        bqz._mth1D64(s);
    }

    static 
    {
        bqw = TimeUnit.SECONDS.toMillis(10L);
    }
}
