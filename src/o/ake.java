// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aje, akf, aos, er, 
//            asc, gj, gi, gq, 
//            _cls0675, ez, akv, my, 
//            yv, zc, atv, atn, 
//            akw, akh, nd, aku, 
//            mz, nb, fc, et, 
//            eu, zw, aji, are, 
//            mw, ajk, akk, mx

public final class ake extends aje
    implements my._cls02CA, my._cls02CB, _cls141F.if, android.view.GestureDetector.OnGestureListener, er._cls02CA
{
    final class if
        implements Runnable
    {

        private ake bqs;
        boolean bqu;

        public final void run()
        {
            if (ake._mth02BE(bqs) != null)
            {
                ake._mth02CF(bqs, true);
                if (bqu)
                {
                    are are1 = ake._mth02BF(bqs);
                    are1.setVisibility(0);
                    are1.FE7B = false;
                    are1.bBk.addUpdateListener(are1.bBj);
                    are1.bBk.start();
                }
                Object obj = ake._mth02BE(bqs)._mth05F0()._mth0689();
                if (obj != null)
                {
                    obj = ((VisibleRegion) (obj)).FK;
                    bqs.bcW.getGlobalMap((float)((LatLngBounds) (obj)).Fi.latitude, (float)((LatLngBounds) (obj)).Fi.longitude, (float)((LatLngBounds) (obj)).Fh.latitude, (float)((LatLngBounds) (obj)).Fh.longitude);
                }
            }
        }

        private if()
        {
            bqs = ake.this;
            super();
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


    private static final long bpY;
    er JV;
    private are bkm;
    private boolean boH;
    private final akf bpZ;
    private final ArrayList bqa = new ArrayList();
    private final RectF bqb;
    private final ajk.if bqc;
    private final _cls02CB bqd;
    private final HashMap bqe = new HashMap(1);
    private _cls02CA bqf;
    private CameraPosition bqg;
    private akw bqh;
    private boolean bqi;
    private long bqj;
    private gj bqk;
    private MotionEvent bql;
    private boolean bqm;
    private long bqn;
    private float bqo;
    private float bqp;
    private if bqq;
    private final Context mContext;

    public ake(ajk ajk, ApiManager apimanager, yv yv1, zc zc1, long l, akk akk, 
            RectF rectf, ajk.if if1)
    {
        super(apimanager, yv1, zc1, 1000L);
        bqq = new if((byte)0);
        mContext = ajk;
        bpZ = new akf(this, akk);
        bqb = rectf;
        bqc = if1;
        bqo = (float)aos._mth02B2(mContext).x * 0.3333333F;
        bqp = (float)aos._mth02B2(mContext).y * 0.3333333F;
        bqd = new _cls02CB(bpZ);
    }

    static long cZ()
    {
        return bpY;
    }

    static asc _mth02BB(ake ake1)
    {
        return ake1.bpZ;
    }

    static CameraPosition _mth02BC(ake ake1)
    {
        return ake1.bqg;
    }

    static gj _mth02BD(ake ake1)
    {
        return ake1.bqk;
    }

    static er _mth02BE(ake ake1)
    {
        return ake1.JV;
    }

    static are _mth02BF(ake ake1)
    {
        return ake1.bkm;
    }

    private void _mth02C8(LatLng latlng)
    {
        if (!bqa.isEmpty())
        {
            boolean flag1 = true;
            boolean flag = flag1;
            if (bql != null)
            {
                flag = flag1;
                if (bqb.contains(bql.getX(), bql.getY()))
                {
                    flag = false;
                }
            }
            if (flag)
            {
                JV._mth02CA(_cls141D.if._mth02CA(latlng), 300, null);
            }
            if (bqj != 0L)
            {
                latlng = bqd.obtainMessage(100, bqa);
                bqd.sendMessageDelayed(latlng, bqj);
                return;
            }
            bpZ._mth1D65(bqa);
        }
    }

    static long _mth02CA(ake ake1, long l)
    {
        ake1.bqn = l;
        return l;
    }

    static CameraPosition _mth02CA(ake ake1, CameraPosition cameraposition)
    {
        ake1.bqg = cameraposition;
        return cameraposition;
    }

    static ajk.if _mth02CA(ake ake1)
    {
        return ake1.bqc;
    }

    static gj _mth02CA(ake ake1, gj gj1)
    {
        ake1.bqk = gj1;
        return gj1;
    }

    static void _mth02CA(ake ake1, gj gj1, gi gi1)
    {
        _mth02CA(gj1, gi1);
    }

    static void _mth02CA(ake ake1, boolean flag, long l)
    {
        ake1._mth02CA(flag, l);
    }

    private static void _mth02CA(gj gj1, gi gi1)
    {
        gj1.Fj._mth02C8(gi1.DU);
        return;
        gj1;
        try
        {
            throw new android.support.v4.app.Fragment.if(gj1);
        }
        // Misplaced declaration of an exception variable
        catch (gj gj1)
        {
            _cls0675._mth02CB(new Exception("Failed to set marker icon", gj1));
        }
        return;
    }

    private void _mth02CA(boolean flag, long l)
    {
        if (bqm)
        {
            return;
        }
        bqd.removeCallbacks(bqq);
        bqq.bqu = flag;
        if (l > 0L)
        {
            bqd.postDelayed(bqq, 400L);
            return;
        } else
        {
            bqd.post(bqq);
            return;
        }
    }

    static boolean _mth02CA(ake ake1, CameraPosition cameraposition, CameraPosition cameraposition1)
    {
        return Math.round(cameraposition.EL) != Math.round(cameraposition1.EL);
    }

    static boolean _mth02CA(ake ake1, boolean flag)
    {
        ake1.boH = false;
        return false;
    }

    static long _mth02CB(ake ake1, long l)
    {
        ake1.bqj = l;
        return l;
    }

    static void _mth02CB(ake ake1, boolean flag)
    {
        ake1._mth02E2(true);
    }

    static boolean _mth02CB(ake ake1)
    {
        return ake1.bqi;
    }

    static boolean _mth02CB(ake ake1, CameraPosition cameraposition, CameraPosition cameraposition1)
    {
        if (cameraposition == null || cameraposition1 == null)
        {
            return false;
        }
        ez ez1 = ake1.JV._mth05F0();
        cameraposition = ez1._mth02CE(cameraposition.EK);
        cameraposition1 = ez1._mth02CE(cameraposition1.EK);
        int i = Math.abs(((Point) (cameraposition)).x - ((Point) (cameraposition1)).x);
        int j = Math.abs(((Point) (cameraposition)).y - ((Point) (cameraposition1)).y);
        return (float)i > ake1.bqo || (float)j > ake1.bqp;
    }

    private boolean _mth02CB(akv akv1)
    {
        bqa.clear();
        bqa.add(akv1);
        _mth02C8(akv1.Ku);
        return true;
    }

    static void _mth02CE(ake ake1, boolean flag)
    {
        ake1.bqi = true;
        ake1.cY();
        if (ake1.bpZ.aO())
        {
            ake1.bpZ.aN();
        }
    }

    static boolean _mth02CE(ake ake1)
    {
        return ake1.boH;
    }

    static Handler _mth02CF(ake ake1)
    {
        return ake1.bqd;
    }

    static boolean _mth02CF(ake ake1, boolean flag)
    {
        ake1.bqm = true;
        return true;
    }

    private void _mth02E2(boolean flag)
    {
        if (bqf == null)
        {
            return;
        }
        if (!flag && bpZ.aO())
        {
            boH = true;
            return;
        }
        bqf._mth1606();
        Iterator iterator = ((zc) (boW.aWf)).FF89.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj1 = (atv)iterator.next();
            static final class _cls1
            {

                static final int bcB[];
                static final int bnc[];

                static 
                {
                    bnc = new int[atv.if.values().length];
                    try
                    {
                        bnc[atv.if.bEi.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                    try
                    {
                        bnc[atv.if.bEj.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    bcB = new int[zw.values().length];
                    try
                    {
                        bcB[zw.aYM.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                }
            }

            switch (_cls1.bnc[((atv) (obj1)).fZ().ordinal()])
            {
            case 1: // '\001'
            case 2: // '\002'
                Object obj = boW;
                obj1 = ((atv) (obj1)).ga();
                obj = akv._mth037A((atn)((yv) (obj)).aWg.get(obj1));
                if (obj != null)
                {
                    bqf._mth02CA(((akv) (obj)));
                }
                break;
            }
        } while (true);
        bqf._mth1D0B();
    }

    static akw _mth037A(ake ake1)
    {
        return ake1.bqh;
    }

    static long _mth141D(ake ake1)
    {
        return ake1.bqn;
    }

    static HashMap _mth1FBE(ake ake1)
    {
        return ake1.bqe;
    }

    public final void cM()
    {
        _mth02CA(true, 0L);
    }

    public final boolean cX()
    {
        return JV != null && JV._mth0447().EL != JV._mth0453();
    }

    final void cY()
    {
        if (bqk != null)
        {
            gi gi1 = bqh._mth156A(bqk.getId());
            if (gi1 != null)
            {
                gj gj1 = bqk;
                try
                {
                    gj1._mth02CA(gi1);
                }
                catch (Exception exception)
                {
                    _cls0675._mth02CB(new Exception("Failed to set marker icon", exception));
                }
            }
            bqk = null;
        }
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public final void onLongPress(MotionEvent motionevent)
    {
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        bqi = false;
        cY();
        if (bpZ.aO())
        {
            bpZ.aN();
        }
        return false;
    }

    public final void onShowPress(MotionEvent motionevent)
    {
    }

    public final boolean onSingleTapUp(MotionEvent motionevent)
    {
        bql = motionevent;
        return false;
    }

    public final void _mth02C6(long l)
    {
        if (boZ == null)
        {
            boZ = new akh(this, l);
        }
        aos._mth02CA(bmU.id(), boZ, boX);
    }

    public final void _mth02CA(er er1, are are1)
    {
        _cls02CA _lcls02ca;
        aku aku1;
        bqf = new _cls02CA(mContext, er1);
        _lcls02ca = bqf;
        _lcls02ca.Kn = this;
        ((my) (_lcls02ca)).Kh._mth02CA(this);
        _lcls02ca = bqf;
        _lcls02ca.Kl = this;
        ((my) (_lcls02ca)).Kh._mth02CA(this);
        _lcls02ca = bqf;
        _lcls02ca.Km = this;
        ((my) (_lcls02ca)).Kh._mth02CA(this);
        _lcls02ca = bqf;
        aku1 = new aku();
        ((my) (_lcls02ca)).Kg.writeLock().lock();
        if (((my) (_lcls02ca)).Kf != null)
        {
            aku1._mth02CA(((my) (_lcls02ca)).Kf._mth1595());
        }
        _lcls02ca.Kf = new nb(aku1);
        ((my) (_lcls02ca)).Kg.writeLock().unlock();
        break MISSING_BLOCK_LABEL_175;
        er1;
        ((my) (_lcls02ca)).Kg.writeLock().unlock();
        throw er1;
        _lcls02ca._mth1D0B();
        bqh = new akw(mContext, er1, bqf, boW);
        _lcls02ca = bqf;
        akw akw1 = bqh;
        ((my) (_lcls02ca)).Kh._mth02CA(null);
        ((my) (_lcls02ca)).Kh._mth02CA(null);
        ((my) (_lcls02ca)).Ke.clear();
        ((my) (_lcls02ca)).Kd.clear();
        ((my) (_lcls02ca)).Kh._mth1E36();
        _lcls02ca.Kh = akw1;
        ((my) (_lcls02ca)).Kh._mth1E1F();
        ((my) (_lcls02ca)).Kh._mth02CA(((my) (_lcls02ca)).Kn);
        ((my) (_lcls02ca)).Kh._mth02CA(null);
        ((my) (_lcls02ca)).Kh._mth02CA(((my) (_lcls02ca)).Kl);
        ((my) (_lcls02ca)).Kh._mth02CA(((my) (_lcls02ca)).Km);
        _lcls02ca._mth1D0B();
        JV = er1;
        er1 = JV;
        _lcls02ca = bqf;
        if (_lcls02ca == null)
        {
            try
            {
                er1.DV._mth02CA(null);
            }
            // Misplaced declaration of an exception variable
            catch (er er1)
            {
                throw new android.support.v4.app.Fragment.if(er1);
            }
            break MISSING_BLOCK_LABEL_388;
        }
        er1.DV._mth02CA(new et(er1, _lcls02ca));
        JV._mth02CA(bqf);
        er1 = JV;
        if (this == null)
        {
            try
            {
                er1.DV._mth02CA(null);
            }
            // Misplaced declaration of an exception variable
            catch (er er1)
            {
                throw new android.support.v4.app.Fragment.if(er1);
            }
            break MISSING_BLOCK_LABEL_452;
        }
        er1.DV._mth02CA(new eu(er1, this));
        bkm = are1;
        return;
    }

    protected final void _mth02CA(boolean flag, zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (flag)
        {
            cL();
        } else
        {
            cK();
        }
        _mth02E2(false);
        if (boY != null)
        {
            boY.cG();
        }
        if (bkm != null)
        {
            bkm.bBl.start();
        }
        bqm = false;
    }

    public final boolean _mth02CA(mw mw1)
    {
        bqa.clear();
        bqa.addAll(mw1._mth1595());
        _mth02C8(mw1.FC60());
        return true;
    }

    public final boolean _mth02CA(mx mx)
    {
        return _mth02CB((akv)mx);
    }

    public final void _mth0647()
    {
        bqi = false;
        cY();
        if (bpZ.aO())
        {
            bpZ.aN();
        }
    }

    static 
    {
        bpY = TimeUnit.SECONDS.toMillis(60L);
    }
}
