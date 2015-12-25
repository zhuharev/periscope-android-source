// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            nd, nq, ns, _cls1FD3, 
//            nl, mw, gi, my, 
//            nf, ng, nh, ni, 
//            er, nm, gj, mx, 
//            ez, nn, mv

public class ne
    implements nd
{
    final class aux
        implements Runnable
    {

        final ne KW;
        private Set Lo;
        Runnable Lp;
        ez Lq;
        nn Lr;
        float Ls;

        public final void run()
        {
            if (Lo.equals(ne._mth02BC(KW)))
            {
                Lp.run();
                return;
            }
            _cls02CE _lcls02ce = new _cls02CE(KW, (byte)0);
            float f = Ls;
            boolean flag;
            if (f > ne._mth02BB(KW))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            float f1 = ne._mth02BB(KW);
            Set set1 = ne._mth02BD(KW);
            LatLngBounds latlngbounds = Lq._mth0689().FK;
            Object obj1 = null;
            Object obj = obj1;
            if (ne._mth02BC(KW) != null)
            {
                obj = obj1;
                if (ne._mth1E39())
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator2 = ne._mth02BC(KW).iterator();
                    do
                    {
                        obj = arraylist;
                        if (!iterator2.hasNext())
                        {
                            break;
                        }
                        obj = (mw)iterator2.next();
                        if (KW._mth02CB(((mw) (obj))) && latlngbounds._mth02BD(((mw) (obj)).FC60()))
                        {
                            arraylist.add(Lr._mth02BE(((mw) (obj)).FC60()));
                        }
                    } while (true);
                }
            }
            Set set = Collections.newSetFromMap(new ConcurrentHashMap());
            for (Iterator iterator = Lo.iterator(); iterator.hasNext();)
            {
                mw mw1 = (mw)iterator.next();
                boolean flag1 = latlngbounds._mth02BD(mw1.FC60());
                if (flag && flag1 && ne._mth1E39())
                {
                    Object obj4 = ne._mth02CA(((ArrayList) (obj)), Lr._mth02BE(mw1.FC60()));
                    if (obj4 != null)
                    {
                        obj4 = Lr._mth02CA(((nl) (obj4)));
                        _lcls02ce._mth02CA(true, new _cls02CA(KW, mw1, set, ((LatLng) (obj4))));
                    } else
                    {
                        _lcls02ce._mth02CA(true, new _cls02CA(KW, mw1, set, null));
                    }
                } else
                {
                    _lcls02ce._mth02CA(flag1, new _cls02CA(KW, mw1, set, null));
                }
            }

            _lcls02ce._mth1E5D();
            set1.removeAll(set);
            obj = null;
            if (ne._mth1E39())
            {
                ArrayList arraylist1 = new ArrayList();
                Iterator iterator3 = Lo.iterator();
                do
                {
                    obj = arraylist1;
                    if (!iterator3.hasNext())
                    {
                        break;
                    }
                    obj = (mw)iterator3.next();
                    if (KW._mth02CB(((mw) (obj))) && latlngbounds._mth02BD(((mw) (obj)).FC60()))
                    {
                        arraylist1.add(Lr._mth02BE(((mw) (obj)).FC60()));
                    }
                } while (true);
            }
            for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();)
            {
                Object obj2 = (_cls02CF)iterator1.next();
                boolean flag2 = latlngbounds._mth02BD(((_cls02CF) (obj2)).FA);
                if (!flag && f - f1 > -3F && flag2 && ne._mth1E39())
                {
                    Object obj3 = ne._mth02CA(((ArrayList) (obj)), Lr._mth02BE(((_cls02CF) (obj2)).FA));
                    if (obj3 != null)
                    {
                        obj3 = Lr._mth02CA(((nl) (obj3)));
                        LatLng latlng = ((_cls02CF) (obj2)).FA;
                        _lcls02ce.nX.lock();
                        obj2 = _lcls02ce.KW. new if(((_cls02CF) (obj2)), latlng, ((LatLng) (obj3)), (byte)0);
                        obj2.Kc = ne._mth037A(_lcls02ce.KW).Kc;
                        obj2.Lb = true;
                        _lcls02ce.Lm.add(obj2);
                        _lcls02ce.nX.unlock();
                    } else
                    {
                        _lcls02ce._mth02CA(true, ((_cls02CF) (obj2)).KY);
                    }
                } else
                {
                    _lcls02ce._mth02CA(flag2, ((_cls02CF) (obj2)).KY);
                }
            }

            _lcls02ce._mth1E5D();
            ne._mth02CA(KW, set);
            ne._mth02CB(KW, Lo);
            ne._mth02CA(KW, f);
            Lp.run();
        }

        private aux(Set set)
        {
            KW = ne.this;
            super();
            Lo = set;
        }

        aux(Set set, byte byte0)
        {
            this(set);
        }
    }

    final class if extends AnimatorListenerAdapter
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        private ne KW;
        private final _cls02CF KX;
        private final gj KY;
        private final LatLng KZ;
        mv Kc;
        private final LatLng La;
        boolean Lb;

        public final void onAnimationEnd(Animator animator)
        {
            if (Lb)
            {
                animator = (mw)ne._mth02CF(KW).get(KY);
                ne._mth1FBE(KW).remove(animator);
                ne._mth02CB(KW)._mth02CE(KY);
                ne._mth02CF(KW).remove(KY);
                Kc._mth02CB(KY);
            }
            KX.FA = La;
        }

        public final void onAnimationUpdate(ValueAnimator valueanimator)
        {
            float f = valueanimator.getAnimatedFraction();
            double d3 = La.latitude;
            double d4 = KZ.latitude;
            double d5 = f;
            double d6 = KZ.latitude;
            double d2 = La.longitude - KZ.longitude;
            double d = d2;
            double d1 = d;
            if (Math.abs(d2) > 180D)
            {
                d1 = d - Math.signum(d) * 360D;
            }
            valueanimator = new LatLng((d3 - d4) * d5 + d6, (double)f * d1 + KZ.longitude);
            KY._mth02BB(valueanimator);
        }

        private if(_cls02CF _pcls02cf, LatLng latlng, LatLng latlng1)
        {
            KW = ne.this;
            super();
            KX = _pcls02cf;
            KY = _pcls02cf.KY;
            KZ = latlng;
            La = latlng1;
        }

        if(_cls02CF _pcls02cf, LatLng latlng, LatLng latlng1, byte byte0)
        {
            this(_pcls02cf, latlng, latlng1);
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

    /* member class not found */
    class _cls141D {}


    private static final boolean KD;
    private static final int KH[] = {
        10, 20, 50, 100, 200, 500, 1000
    };
    private static final DecelerateInterpolator KV = new DecelerateInterpolator();
    private final er JV;
    private final nq KE;
    private final my KF;
    private final float KG;
    private ShapeDrawable KI;
    private Set KJ;
    private SparseArray KK;
    private _cls02CB KL;
    private Set KM;
    private HashMap KN;
    private HashMap KO;
    private float KP;
    private final _cls141D KQ = new _cls141D((byte)0);
    private my._cls02CA KR;
    private _cls1427.if KS;
    private my._cls02CB KT;
    private _cls141F.if KU;

    public ne(Context context, er er, my my1)
    {
        KJ = Collections.newSetFromMap(new ConcurrentHashMap());
        KK = new SparseArray();
        KL = new _cls02CB((byte)0);
        KN = new HashMap();
        KO = new HashMap();
        JV = er;
        KG = context.getResources().getDisplayMetrics().density;
        KE = new nq(context);
        er = KE;
        context = new ns(context);
        context.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        context.setId(_cls10D0._cls02CA.text);
        int i = (int)(KG * 12F);
        context.setPadding(i, i, i, i);
        er.setContentView(context);
        context = KE;
        i = _cls1FD3.dt;
        er = ((nq) (context)).mContext;
        if (((nq) (context)).LJ != null)
        {
            ((nq) (context)).LJ.setTextAppearance(er, i);
        }
        context = KE;
        KI = new ShapeDrawable(new OvalShape());
        er = new ShapeDrawable(new OvalShape());
        er.getPaint().setColor(0x80ffffff);
        er = new LayerDrawable(new Drawable[] {
            er, KI
        });
        i = (int)(KG * 3F);
        er.setLayerInset(1, i, i, i, i);
        context.setBackground(er);
        KF = my1;
    }

    static float _mth02BB(ne ne1)
    {
        return ne1.KP;
    }

    static Set _mth02BC(ne ne1)
    {
        return ne1.KM;
    }

    static Set _mth02BD(ne ne1)
    {
        return ne1.KJ;
    }

    static float _mth02CA(ne ne1, float f)
    {
        ne1.KP = f;
        return f;
    }

    static Set _mth02CA(ne ne1, Set set)
    {
        ne1.KJ = set;
        return set;
    }

    static my._cls02CB _mth02CA(ne ne1)
    {
        return ne1.KT;
    }

    static nl _mth02CA(ArrayList arraylist, nm nm)
    {
        if (arraylist == null || arraylist.isEmpty())
        {
            return null;
        }
        double d = 10000D;
        Object obj = null;
        Iterator iterator = arraylist.iterator();
        arraylist = obj;
        while (iterator.hasNext()) 
        {
            nl nl1 = (nl)iterator.next();
            double d2 = (nl1.x - ((nl) (nm)).x) * (nl1.x - ((nl) (nm)).x) + (nl1.y - ((nl) (nm)).y) * (nl1.y - ((nl) (nm)).y);
            double d1 = d;
            if (d2 < d)
            {
                arraylist = nl1;
                d1 = d2;
            }
            d = d1;
        }
        return arraylist;
    }

    static Set _mth02CB(ne ne1, Set set)
    {
        ne1.KM = set;
        return set;
    }

    static _cls02CB _mth02CB(ne ne1)
    {
        return ne1.KL;
    }

    static my._cls02CA _mth02CE(ne ne1)
    {
        return ne1.KR;
    }

    static Map _mth02CF(ne ne1)
    {
        return ne1.KN;
    }

    static my _mth037A(ne ne1)
    {
        return ne1.KF;
    }

    static er _mth141D(ne ne1)
    {
        return ne1.JV;
    }

    static boolean _mth1E39()
    {
        return KD;
    }

    static TimeInterpolator _mth1E3D()
    {
        return KV;
    }

    static Map _mth1FBE(ne ne1)
    {
        return ne1.KO;
    }

    public void _mth02CA(mw mw1, MarkerOptions markeroptions)
    {
        int i;
label0:
        {
            int j = mw1.getSize();
            if (j <= KH[0])
            {
                i = j;
                break label0;
            }
            i = 0;
            do
            {
                if (i >= 6)
                {
                    break;
                }
                if (j < KH[i + 1])
                {
                    i = KH[i];
                    break label0;
                }
                i++;
            } while (true);
            i = KH[6];
        }
        gi gi1 = (gi)KK.get(i);
        mw1 = gi1;
        if (gi1 == null)
        {
            mw1 = KI.getPaint();
            float f = Math.min(i, 300F);
            mw1.setColor(Color.HSVToColor(new float[] {
                (((300F - f) * (300F - f)) / 90000F) * 220F, 1.0F, 0.6F
            }));
            nq nq1 = KE;
            if (i < KH[0])
            {
                mw1 = String.valueOf(i);
            } else
            {
                mw1 = (new StringBuilder()).append(String.valueOf(i)).append("+").toString();
            }
            if (nq1.LJ != null)
            {
                nq1.LJ.setText(mw1);
            }
            mw1 = o._cls141D.if._mth02CA(nq1._mth1F32());
            KK.put(i, mw1);
        }
        markeroptions._mth02CB(mw1);
    }

    public void _mth02CA(mw mw1, gj gj)
    {
    }

    public void _mth02CA(mx mx, MarkerOptions markeroptions)
    {
    }

    public void _mth02CA(mx mx, gj gj)
    {
    }

    public final void _mth02CA(my._cls02CA _pcls02ca)
    {
        KR = _pcls02ca;
    }

    public final void _mth02CA(my._cls02CB _pcls02cb)
    {
        KT = _pcls02cb;
    }

    public final void _mth02CA(_cls141F.if if1)
    {
        KU = if1;
    }

    public final void _mth02CA(_cls1427.if if1)
    {
        KS = if1;
    }

    public boolean _mth02CB(mw mw1)
    {
        return mw1.getSize() > 4;
    }

    public void _mth02CE(Set set)
    {
        _cls141D _lcls141d = KQ;
        _lcls141d;
        JVM INSTR monitorenter ;
        _lcls141d.Lu = _lcls141d.KW. new aux(set, (byte)0);
        _lcls141d;
        JVM INSTR monitorexit ;
          goto _L1
        set;
        throw set;
_L1:
        _lcls141d.sendEmptyMessage(0);
        return;
    }

    public final void _mth1E1F()
    {
        KF.Kd.Ka = new nf(this);
        KF.Kd.JZ = new ng(this);
        KF.Ke.Ka = new nh(this);
        KF.Ke.JZ = new ni(this);
    }

    public final void _mth1E36()
    {
        KF.Kd.Ka = null;
        KF.Ke.Ka = null;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        KD = flag;
    }
}
