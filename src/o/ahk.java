// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            xd, ahy, zp, yo, 
//            ahm, auf, aug, aht, 
//            aie, aos, aok, aui, 
//            ahz, aid, ath, atu, 
//            arp, aev, adf, ada

public final class ahk extends android.support.v7.widget.RecyclerView.if
{
    final class if
    {

        final int blI = 4;
        final TreeMap blJ = new TreeMap(new _cls02CA());
        final LinkedList blK = new LinkedList();
        final ahk blL;

        final void _mth02CA(atu atu1)
        {
            atu1 = (aht.if)blJ.remove(atu1);
            if (atu1 != null)
            {
                blL.mHandler.removeCallbacks(atu1);
                if (((aht.if) (atu1)).bme != null)
                {
                    ((aht.if) (atu1)).bme.cancel();
                }
                atu1.bme = null;
                atu1.bmc = null;
                atu1.bmd = null;
            }
        }

        if(int i)
        {
            blL = ahk.this;
            super();
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final aev blC;
    private final if blD = new if(4);
    private final ahy blE;
    private final adf blF;
    private long blG;
    private aug blH;
    private final Context mContext;
    final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ArrayList FF89 = new ArrayList();

    public ahk(ada ada, aev aev, adf adf)
    {
        mContext = ada;
        blC = aev;
        blF = adf;
        aev = xd._mth1FEA();
        blE = new ahy(((zp) (aev)).aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), null), true, yo._mth02CA(ada, aev));
        if (super.ey._mth30FC())
        {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else
        {
            super.ez = true;
            return;
        }
    }

    public final void clear()
    {
        FF89.clear();
        if if1 = blD;
        for (Iterator iterator = if1.blJ.values().iterator(); iterator.hasNext();)
        {
            aht.if if2 = (aht.if)iterator.next();
            if1.blL.mHandler.removeCallbacks(if2);
            if (if2.bme != null)
            {
                if2.bme.cancel();
            }
            if2.bme = null;
            if2.bmc = null;
            if2.bmd = null;
        }

        if1.blJ.clear();
        if1.blK.clear();
        blH = null;
    }

    public final int getItemCount()
    {
        return FF89.size();
    }

    public final long getItemId(int i)
    {
        return ((ahm)FF89.get(i)).id;
    }

    public final int getItemViewType(int i)
    {
        ahm ahm1 = (ahm)FF89.get(i);
        static final class _cls1
        {

            static final int aUJ[];

            static 
            {
                aUJ = new int[aug.values().length];
                try
                {
                    aUJ[aug.bEK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    aUJ[aug.bEE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    aUJ[aug.bEL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    aUJ[aug.bEB.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    aUJ[aug.bEz.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    aUJ[aug.bEO.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    aUJ[aug.bEF.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    aUJ[aug.bEP.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
            }
        }

        switch (_cls1.aUJ[ahm1.aVl.go().ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return 2;

        case 7: // '\007'
            return 3;

        case 6: // '\006'
            return 4;

        case 8: // '\b'
            return 5;
        }
        return 1;
    }

    public final void _mth02CA(android.support.v7.widget.RecyclerView._cls02CC _pcls02cc, int i)
    {
        Object obj = (aht)_pcls02cc;
        if (i >= 0)
        {
            Object obj1 = (ahm)FF89.get(i);
            Object obj2 = mContext.getResources();
            switch (_cls1.aUJ[((ahm) (obj1)).aVl.go().ordinal()])
            {
            case 1: // '\001'
                _pcls02cc = (aie)obj;
                ((aie) (_pcls02cc)).fy.getBackground().mutate().setColorFilter(((Resources) (obj2)).getColor(0x7f0c0037), android.graphics.PorterDuff.Mode.SRC_ATOP);
                ((aie) (_pcls02cc)).bmR.setText(aos._mth1D37(mContext.getString(0x7f060063, new Object[] {
                    ((ahm) (obj1)).aVl.gA()
                })));
                ((aie) (_pcls02cc)).bmS.setVisibility(8);
                break;

            case 2: // '\002'
                aie aie1 = (aie)obj;
                i = aok._mth02CA(((Resources) (obj2)), ((ahm) (obj1)).aVl.gp().intValue());
                aie1.fy.getBackground().mutate().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
                if (((ahm) (obj1)).aVl.gx().intValue() > 0)
                {
                    TextView textview = aie1.bmR;
                    i = ((ahm) (obj1)).aVl.gx().intValue();
                    auf auf1 = ((ahm) (obj1)).aVl;
                    _pcls02cc = auf1.gj();
                    if (aui.isEmpty(_pcls02cc))
                    {
                        _pcls02cc = auf1.displayName();
                    }
                    textview.setText(aos._mth1D37(((Resources) (obj2)).getQuantityString(0x7f070001, i, new Object[] {
                        _pcls02cc, aos._mth02CA(((Resources) (obj2)), ((ahm) (obj1)).aVl.gx().intValue(), true)
                    })));
                } else
                {
                    TextView textview1 = aie1.bmR;
                    auf auf2 = ((ahm) (obj1)).aVl;
                    _pcls02cc = auf2.gj();
                    if (aui.isEmpty(_pcls02cc))
                    {
                        _pcls02cc = auf2.displayName();
                    }
                    textview1.setText(aos._mth1D37(((Resources) (obj2)).getString(0x7f0600df, new Object[] {
                        _pcls02cc
                    })));
                }
                aie1.bmS.setVisibility(8);
                aie1.bmB = ((ahm) (obj1));
                break;

            case 3: // '\003'
                aie aie2 = (aie)obj;
                i = aok._mth02CA(((Resources) (obj2)), ((ahm) (obj1)).aVl.gp().intValue());
                aie2.fy.getBackground().mutate().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
                TextView textview2 = aie2.bmR;
                auf auf3 = ((ahm) (obj1)).aVl;
                _pcls02cc = auf3.gj();
                if (aui.isEmpty(_pcls02cc))
                {
                    _pcls02cc = auf3.displayName();
                }
                textview2.setText(aos._mth1D37(((Resources) (obj2)).getString(0x7f060156, new Object[] {
                    _pcls02cc
                })));
                aie2.bmB = ((ahm) (obj1));
                aie2.bmS.setVisibility(0);
                break;

            case 4: // '\004'
                aie aie3 = (aie)obj;
                if (((ahm) (obj1)).blT > 0)
                {
                    i = ((Resources) (obj2)).getColor(0x7f0c0037);
                } else
                {
                    i = aok._mth02CA(((Resources) (obj2)), ((ahm) (obj1)).aVl.gp().intValue());
                }
                aie3.fy.getBackground().mutate().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_ATOP);
                obj2 = aie3.bmR;
                Context context = mContext;
                auf auf4 = ((ahm) (obj1)).aVl;
                _pcls02cc = auf4.gj();
                if (aui.isEmpty(_pcls02cc))
                {
                    _pcls02cc = auf4.displayName();
                }
                ((TextView) (obj2)).setText(aos._mth1D37(context.getString(0x7f060078, new Object[] {
                    _pcls02cc
                })));
                aie3.bmB = ((ahm) (obj1));
                aie3.bmS.setVisibility(8);
                break;

            case 5: // '\005'
                _pcls02cc = (ahz)obj;
                blE._mth02CA(_pcls02cc, ((ahm) (obj1)).aVl);
                _pcls02cc.bmB = ((ahm) (obj1));
                break;

            case 6: // '\006'
                _pcls02cc = (aid)obj;
                ((aid) (_pcls02cc)).bmQ.setText(aos._mth1D37(mContext.getString(0x7f060079)));
                _pcls02cc.bmB = ((ahm) (obj1));
                break;
            }
            if (((aht) (obj)).bmb != null)
            {
                blD._mth02CA(((aht) (obj)).bmb);
            }
            ((aht) (obj)).fy.setAlpha(((ahm) (obj1)).blR);
            _pcls02cc = new aht.if(((aht) (obj)).fy, ((ahm) (obj1)));
            obj1 = new ath(((aht) (obj)).getItemId(), ((ahm) (obj1)).blT);
            obj.bmb = ((atu) (obj1));
            obj = blD;
            ((if) (obj)).blJ.put(obj1, _pcls02cc);
            if (((if) (obj)).blI > 0)
            {
                ((if) (obj)).blK.addAll(((if) (obj)).blJ.keySet());
                i = 0;
                for (Iterator iterator = ((if) (obj)).blJ.values().iterator(); iterator.hasNext();)
                {
                    int j = i;
                    if (!((aht.if)iterator.next()).bmf)
                    {
                        j = i + 1;
                    }
                    i = j;
                }

                long l = Math.max((long)(4500F * ((float)((if) (obj)).blI / (float)i)), 300L);
                Iterator iterator1 = ((if) (obj)).blK.descendingIterator();
                for (i = 0; iterator1.hasNext(); i++)
                {
                    Object obj3 = (atu)iterator1.next();
                    obj3 = (aht.if)((if) (obj)).blJ.get(obj3);
                    if (i < ((if) (obj)).blI)
                    {
                        continue;
                    }
                    if (((aht.if) (obj3)).bme != null)
                    {
                        if (((aht.if) (obj3)).bmg)
                        {
                            long l1 = (long)((float)l * ((Float)((aht.if) (obj3)).bme.getAnimatedValue()).floatValue());
                            ((aht.if) (obj3)).bme.removeAllListeners();
                            ((aht.if) (obj3)).bme.removeAllUpdateListeners();
                            ((aht.if) (obj3)).bme.cancel();
                            ((aht.if) (obj3)).bmd.blS = l1;
                            obj3.bme = ((aht.if) (obj3))._mth02CA(((aht.if) (obj3)).bmc, ((aht.if) (obj3)).bmd);
                            ((aht.if) (obj3)).bme.start();
                        } else
                        {
                            ((aht.if) (obj3)).bme.setDuration(l);
                        }
                    }
                    if (((aht.if) (obj3)).cq())
                    {
                        ((if) (obj)).blL.mHandler.removeCallbacks(((Runnable) (obj3)));
                    }
                }

                ((if) (obj)).blK.clear();
            }
            ((if) (obj)).blL.mHandler.postDelayed(_pcls02cc, TimeUnit.SECONDS.toMillis(7L));
        }
    }

    public final android.support.v7.widget.RecyclerView._cls02CC _mth02CB(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        case 2: // '\002'
            return new aie(LayoutInflater.from(mContext).inflate(0x7f030034, viewgroup, false), blC);

        case 3: // '\003'
            return new aht(LayoutInflater.from(mContext).inflate(0x7f03002a, viewgroup, false));

        case 4: // '\004'
            return new aid(LayoutInflater.from(mContext).inflate(0x7f030035, viewgroup, false), blC);

        case 5: // '\005'
            viewgroup = LayoutInflater.from(mContext).inflate(0x7f030031, viewgroup, false);
            ((arp)viewgroup.findViewById(0x7f0d000c)).setText(aos._mth1D37(mContext.getString(0x7f060138)));
            return new aht(viewgroup);
        }
        return new ahz(LayoutInflater.from(mContext).inflate(0x7f030033, viewgroup, false), blC, blF);
    }

    public final void _mth141D(auf auf1)
    {
        switch (_cls1.aUJ[auf1.go().ordinal()])
        {
        case 3: // '\003'
        case 5: // '\005'
        default:
            break;

        case 2: // '\002'
        case 4: // '\004'
            if (auf1.go() == aug.bEB && auf1.go() == blH)
            {
                int i = FF89.size() - 1;
                ahm ahm1 = (ahm)FF89.remove(i);
                ahm ahm2 = new ahm(auf1, ahm1.id);
                if (blD.blJ.size() > 0)
                {
                    Object obj = blD;
                    if (((if) (obj)).blJ.isEmpty())
                    {
                        obj = null;
                    } else
                    {
                        obj = (aht.if)((if) (obj)).blJ.get(((if) (obj)).blJ.lastKey());
                    }
                    if (!((aht.if) (obj)).bmf)
                    {
                        ath ath1 = new ath(ahm1.id, ahm1.blT);
                        blD._mth02CA(ath1);
                        ahm2.blT = ahm1.blT + 1;
                        FF89.add(ahm2);
                        super.ey._mth1D4E(i, 1);
                        blH = auf1.go();
                        return;
                    }
                }
            }
            break;

        case 6: // '\006'
            if (blH != aug.bEO)
            {
                break;
            }
            int j = FF89.size();
            if (((ahm)FF89.get(j - 1)).blR > 0.2F)
            {
                return;
            }
            break;
        }
        ArrayList arraylist = FF89;
        long l = blG;
        blG = 1L + l;
        arraylist.add(new ahm(auf1, l));
        int k = FF89.size();
        super.ey._mth1D54(k, 1);
        blH = auf1.go();
    }
}
