// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            apw, _cls0142, FB61, FE70, 
//            _cls153E, _cls0675, _cls05E3

public class arx extends ViewGroup
{
    final class if extends apw
    {

        private arx bCl;

        final boolean ei()
        {
            return bzq && view.getTop() >= bCl.getHeight();
        }

        final boolean ej()
        {
            return view.getTop() < bCl.getHeight();
        }

        if()
        {
            bCl = arx.this;
            super();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final int FE7D[] = {
        0x10100b3
    };
    public float bBW;
    public float bBX;
    private _cls02CE bBY;
    private _cls0142 bBZ;
    private _cls02CB bCa;
    private View bCb;
    private boolean bCc;
    private float bCd;
    private ArrayList bCe;
    private ArrayList bCf;
    private _cls05E3 bCg;
    private float bCh;
    private final ArrayList bCi;
    private int bCj;
    private Paint bCk;
    private boolean mInLayout;
    private float _fld14F2;
    private boolean _fld1D68;

    public arx(Context context)
    {
        super(context);
        bCe = new ArrayList();
        bCf = new ArrayList();
        _fld1D68 = true;
        bCi = new ArrayList(1);
        bCj = 0x99000000;
        bCk = new Paint();
        init(context);
    }

    public arx(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bCe = new ArrayList();
        bCf = new ArrayList();
        _fld1D68 = true;
        bCi = new ArrayList(1);
        bCj = 0x99000000;
        bCk = new Paint();
        init(context);
    }

    public arx(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bCe = new ArrayList();
        bCf = new ArrayList();
        _fld1D68 = true;
        bCi = new ArrayList(1);
        bCj = 0x99000000;
        bCk = new Paint();
        init(context);
    }

    private View ey()
    {
        for (Iterator iterator = bCe.iterator(); iterator.hasNext();)
        {
            apw apw1 = (apw)iterator.next();
            if (apw1.bzr && ((_cls02CA)apw1.view.getLayoutParams()).bCm > 0.0F)
            {
                return apw1.view;
            }
        }

        return null;
    }

    private void init(Context context)
    {
        bBY = new _cls02CE((byte)0);
        bCd = 1.0F;
        bBW = context.getResources().getDimension(0x7f090095);
        bBX = bBW / 2.0F;
        float f = getResources().getDisplayMetrics().density;
        bBZ = _cls0142._mth02CA(this, 1.0F, bBY);
        bBZ._fld013D = f * 400F;
    }

    static View _mth02BB(arx arx1)
    {
        return arx1.bCb;
    }

    static _cls05E3 _mth02BC(arx arx1)
    {
        return arx1.bCg;
    }

    private static View _mth02C8(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            apw apw1 = (apw)list.next();
            boolean flag;
            if (apw1.bzq && apw1.ei())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return apw1.view;
            }
        }

        return null;
    }

    private static View _mth02C9(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            apw apw1 = (apw)list.next();
            if (apw1.ej())
            {
                return apw1.view;
            }
        }

        return null;
    }

    static _cls02CB _mth02CA(arx arx1)
    {
        return arx1.bCa;
    }

    private void _mth02CA(int i, boolean flag, boolean flag1)
    {
        View view = findViewById(i);
        if (view != null)
        {
            if if1 = new if();
            if1.view = view;
            if1.bzq = flag;
            if1.bzr = flag1;
            bCf.add(if1);
            bCe.add(if1);
        }
    }

    static void _mth02CA(arx arx1, View view, boolean flag)
    {
        arx1._mth02CF(view, flag);
    }

    static boolean _mth02CA(arx arx1, View view)
    {
        return _mth02CB(arx1.bCf, view) != null;
    }

    private static apw _mth02CB(List list, View view)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            apw apw1 = (apw)list.next();
            if (apw1.view == view)
            {
                return apw1;
            }
        }

        return null;
    }

    static _cls0142 _mth02CB(arx arx1)
    {
        return arx1.bBZ;
    }

    private void _mth02CB(int i, float f)
    {
        if (bBZ._mth02BD(2, i) && bBZ._fld0211 == null)
        {
            if (f - _fld14F2 > 0.0F)
            {
                if (bCb != null && bCb.getTop() <= 0 && !_mth13A5(bCb))
                {
                    bBZ._mth02CF(bCb, i);
                    return;
                }
                View view = _mth02C9(bCf);
                if (view != null && !_mth13A5(view))
                {
                    bBZ._mth02CF(view, i);
                }
                return;
            }
            if (bCb != null && bCb.getTop() > 0 && !_mth13A5(bCb))
            {
                bBZ._mth02CF(bCb, i);
                return;
            }
            View view1 = _mth02C8(bCf);
            if (view1 != null && !_mth13A5(view1))
            {
                bBZ._mth02CF(view1, i);
            }
        }
    }

    static boolean _mth02CB(arx arx1, View view)
    {
        return arx1._mth13A5(view);
    }

    static float _mth02CE(arx arx1)
    {
        return arx1.bCd;
    }

    static float _mth02CF(arx arx1)
    {
        return arx1._fld14F2;
    }

    private void _mth02CF(View view, boolean flag)
    {
        if (bCa != null)
        {
            if (flag)
            {
                bCa._mth06E6(view);
                return;
            }
            bCa._mth05D5(view);
        }
    }

    private boolean _mth0E40(View view)
    {
        return _mth02CB(bCf, view) != null;
    }

    private boolean _mth13A5(View view)
    {
        for (Iterator iterator = bCe.iterator(); iterator.hasNext();)
        {
            Object obj = (apw)iterator.next();
            if (view != ((apw) (obj)).view)
            {
                obj = ((apw) (obj)).view;
                boolean flag;
                if (obj != null && ((_cls02CA)((View) (obj)).getLayoutParams()).bCm > 0.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    return true;
                }
            }
        }

        return false;
    }

    static float _mth141D(arx arx1)
    {
        return arx1.bCh;
    }

    public static boolean _mth1424(View view)
    {
        if (view == null)
        {
            return false;
        }
        return ((_cls02CA)view.getLayoutParams()).bCm > 0.0F;
    }

    static int[] FB30()
    {
        return FE7D;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof _cls02CA) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        _cls0142 _lcls0142 = bBZ;
        if (_lcls0142.FBA3 == 2)
        {
            boolean flag2 = _lcls0142.FEAE.computeScrollOffset();
            int i = _lcls0142.FEAE.getCurrX();
            int j = _lcls0142.FEAE.getCurrY();
            int k = i - _lcls0142._fld0211.getLeft();
            int l = j - _lcls0142._fld0211.getTop();
            if (k != 0)
            {
                _lcls0142._fld0211.offsetLeftAndRight(k);
            }
            if (l != 0)
            {
                _lcls0142._fld0211.offsetTopAndBottom(l);
            }
            if (k != 0 || l != 0)
            {
                _lcls0142._fld01AC._mth02CB(_lcls0142._fld0211, i, j, k, l);
            }
            boolean flag1 = flag2;
            if (flag2)
            {
                flag1 = flag2;
                if (i == _lcls0142.FEAE.getFinalX())
                {
                    flag1 = flag2;
                    if (j == _lcls0142.FEAE.getFinalY())
                    {
                        _lcls0142.FEAE.abortAnimation();
                        flag1 = false;
                    }
                }
            }
            if (!flag1)
            {
                _lcls0142._fld0264.post(_lcls0142._fld03A4);
            }
        }
        boolean flag;
        if (_lcls0142.FBA3 == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            FE70._mth1FBE(this);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l)
    {
        boolean flag = super.drawChild(canvas, view, l);
        apw apw1 = _mth02CB(bCe, view);
        if (apw1 != null && apw1.bzr)
        {
            float f = ((_cls02CA)view.getLayoutParams()).bCm;
            if (f > 0.0F)
            {
                int i = (int)((float)((bCj & 0xff000000) >>> 24) * f);
                int j = bCj;
                bCk.setColor(i << 24 | j & 0xffffff);
                canvas.drawRect(0.0F, 0.0F, getWidth(), view.getTop(), bCk);
            }
        }
        return flag;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new _cls02CA(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new _cls02CA(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof _cls02CA)
        {
            return new _cls02CA((_cls02CA)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new _cls02CA((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new _cls02CA(layoutparams);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        _fld1D68 = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        _fld1D68 = true;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        bCb = findViewById(0x7f0d0095);
        _mth02CA(0x7f0d00a6, true, false);
        _mth02CA(0x7f0d00a9, false, true);
        _mth02CA(0x7f0d0119, false, false);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        _cls0142 _lcls0142;
        int i;
        int j;
        _lcls0142 = bBZ;
        j = _cls153E._mth02CA(motionevent);
        i = _cls153E._mth02CB(motionevent);
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        _lcls0142.cancel();
        if (_lcls0142._fld14EF == null)
        {
            _lcls0142._fld14EF = VelocityTracker.obtain();
        }
        _lcls0142._fld14EF.addMovement(motionevent);
        j;
        JVM INSTR tableswitch 0 6: default 781
    //                   0 100
    //                   1 510
    //                   2 261
    //                   3 510
    //                   4 515
    //                   5 179
    //                   6 496;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        j = _cls153E._mth02CB(motionevent, i);
        float f1 = _cls153E._mth02CE(motionevent, i);
        float f5 = _cls153E._mth02CF(motionevent, i);
        _lcls0142._mth02CA(f1, f5, j);
        if (_lcls0142.FBA3 == 0 || _lcls0142.FBA3 != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        View view1 = _lcls0142._mth037A((int)f1, (int)f5);
        if (view1 == _lcls0142._fld0211)
        {
            _lcls0142._mth141D(view1, j);
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (_lcls0142.FEB0 == null || _lcls0142.FEEA == null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = _cls153E._mth02CE(motionevent);
        i = 0;
_L19:
        if (i >= k) goto _L8; else goto _L7
_L7:
        i1 = _cls153E._mth02CB(motionevent, i);
        float f2 = _cls153E._mth02CE(motionevent, i);
        float f6 = _cls153E._mth02CF(motionevent, i);
        f8 = f2 - _lcls0142.FEB0[i1];
        f10 = f6 - _lcls0142.FEEA[i1];
        view2 = _lcls0142._mth037A((int)f2, (int)f6);
        if (view2 == null) goto _L10; else goto _L9
_L9:
        if (!_lcls0142._mth02CA(view2, f8, f10)) goto _L10; else goto _L11
_L11:
        j = 1;
_L17:
        if (j == 0) goto _L13; else goto _L12
_L12:
        view2.getLeft();
        j1 = view2.getTop();
        k1 = (int)f10;
        k1 = _lcls0142._fld01AC._mth02CF(view2, j1 + k1, (int)f10);
        l1 = _lcls0142._fld01AC._mth06E5(view2);
        if (l1 == 0 || l1 > 0 && k1 == j1) goto _L8; else goto _L13
_L13:
        _lcls0142._mth02CB(f8, f10, i1);
        if (_lcls0142.FBA3 == 1) goto _L8; else goto _L14
_L14:
        if (j == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!_lcls0142._mth141D(view2, i1))
        {
            break; /* Loop/switch isn't completed */
        }
_L8:
        _lcls0142._mth02BB(motionevent);
        break; /* Loop/switch isn't completed */
_L6:
        _lcls0142._mth1D62(_cls153E._mth02CB(motionevent, i));
        break; /* Loop/switch isn't completed */
_L3:
        _lcls0142.cancel();
        i = _lcls0142.FBA3;
        if (i == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
          goto _L15
_L2:
        float f8;
        float f10;
        View view2;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        try
        {
            float f = motionevent.getX();
            float f4 = motionevent.getY();
            i = _cls153E._mth02CB(motionevent, 0);
            _lcls0142._mth02CA(f, f4, i);
            View view = _lcls0142._mth037A((int)f, (int)f4);
            if (view == _lcls0142._fld0211 && _lcls0142.FBA3 == 2)
            {
                _lcls0142._mth141D(view, i);
            }
            i = _lcls0142.FF7F[i];
            break; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            _cls0675._mth02CB(new Exception("Crash while attempting to intercept touch event", exception));
        }
        i = ((flag) ? 1 : 0);
_L15:
        if (!bCc || _cls153E._mth02CE(motionevent) > 1)
        {
            return false;
        }
        j = _cls153E._mth02CA(motionevent);
        int l = _cls153E._mth02CB(motionevent, 0);
        float f7 = motionevent.getX();
        float f9 = motionevent.getY();
        bCh = f9;
        boolean flag1 = false;
        switch (j)
        {
        default:
            j = ((flag1) ? 1 : 0);
            break;

        case 0: // '\0'
            _fld14F2 = f9;
            motionevent = ey();
            float f3;
            if (motionevent != null)
            {
                f3 = ((_cls02CA)motionevent.getLayoutParams()).bCm;
            } else
            {
                f3 = 0.0F;
            }
            j = ((flag1) ? 1 : 0);
            if (f3 > 0.0F)
            {
                j = ((flag1) ? 1 : 0);
                if (bBZ._mth037A((int)f7, (int)f9) != ey())
                {
                    j = 1;
                }
            }
            break;

        case 2: // '\002'
            motionevent = bBZ._mth037A((int)f7, (int)f9);
            if (motionevent == null || !motionevent.canScrollVertically((int)(_fld14F2 - f9)))
            {
                _mth02CB(l, f9);
            }
            _fld14F2 = f9;
            j = ((flag1) ? 1 : 0);
            break;
        }
        return i != 0 || j != 0;
_L10:
        j = 0;
        if (true) goto _L17; else goto _L16
_L16:
        i++;
        if (true) goto _L19; else goto _L18
_L18:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        mInLayout = true;
        int l1 = getChildCount();
        int k2 = getPaddingLeft();
        int i3 = k - i - getPaddingRight();
        int j3 = getPaddingTop();
        int k3 = l - j - getPaddingBottom();
        for (int i1 = 0; i1 < l1; i1++)
        {
            View view = getChildAt(i1);
            if (view == bCb)
            {
                continue;
            }
            if (_mth02CB(bCf, view) != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0 || view.getVisibility() == 8)
            {
                continue;
            }
            _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
            int l3 = view.getMeasuredWidth();
            int i4 = view.getMeasuredHeight();
            k = _lcls02ca.gravity;
            i = k;
            if (k == -1)
            {
                i = 0x800033;
            }
            switch (Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7)
            {
            case 1: // '\001'
                k = ((i3 - k2 - l3) / 2 + k2 + _lcls02ca.leftMargin) - _lcls02ca.rightMargin;
                break;

            case 5: // '\005'
                k = i3 - l3 - _lcls02ca.rightMargin;
                break;

            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            default:
                k = k2 + _lcls02ca.leftMargin;
                break;
            }
            switch (i & 0x70)
            {
            case 48: // '0'
                i = j3 + _lcls02ca.topMargin;
                break;

            case 16: // '\020'
                i = ((k3 - j3 - i4) / 2 + j3 + _lcls02ca.topMargin) - _lcls02ca.bottomMargin;
                break;

            case 80: // 'P'
                i = k3 - i4 - _lcls02ca.bottomMargin;
                break;

            default:
                i = j3 + _lcls02ca.topMargin;
                break;
            }
            view.layout(k, i, k + l3, i + i4);
        }

        Object obj = bCb;
        if (obj != null)
        {
            _cls02CA _lcls02ca1 = (_cls02CA)((View) (obj)).getLayoutParams();
            i = (int)(bBW * _lcls02ca1.bCm);
            k = ((View) (obj)).getMeasuredWidth();
            int j1 = ((View) (obj)).getMeasuredHeight();
            int i2 = _lcls02ca1.leftMargin;
            ((View) (obj)).layout(i2, i, i2 + k, i + j1);
        }
        obj = bCf.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            View view1 = ((apw)((Iterator) (obj)).next()).view;
            if (view1 != null)
            {
                i = l - j;
                k = view1.getMeasuredHeight();
                int k1 = view1.getMeasuredWidth();
                _cls02CA _lcls02ca2 = (_cls02CA)view1.getLayoutParams();
                int j2 = i - (int)((float)k * _lcls02ca2.bCm);
                float f = (float)(i - j2) / (float)k;
                if (f != _lcls02ca2.bCm)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                int l2 = _lcls02ca2.leftMargin;
                view1.layout(l2, j2, l2 + k1, j2 + k);
                if (i != 0)
                {
                    _lcls02ca2.bCm = f;
                }
            }
        } while (true);
        mInLayout = false;
        _fld1D68 = false;
    }

    protected void onMeasure(int i, int j)
    {
        int k3 = getChildCount();
        int k;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000 || android.view.View.MeasureSpec.getMode(j) != 0x40000000)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        bCi.clear();
        int k2 = 0;
        int j2 = 0;
        int i1 = 0;
        for (int k1 = 0; k1 < k3;)
        {
            int l2;
            int i3;
            int j3;
label0:
            {
                View view = getChildAt(k1);
                l2 = k2;
                i3 = j2;
                j3 = i1;
                if (view.getVisibility() == 8)
                {
                    break label0;
                }
                measureChildWithMargins(view, i, 0, j, 0);
                _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
                j2 = Math.max(j2, view.getMeasuredWidth() + _lcls02ca.leftMargin + _lcls02ca.rightMargin);
                k2 = Math.max(k2, view.getMeasuredHeight() + _lcls02ca.topMargin + _lcls02ca.bottomMargin);
                i1 = combineMeasuredStates(i1, view.getMeasuredState());
                l2 = k2;
                i3 = j2;
                j3 = i1;
                if (!k)
                {
                    break label0;
                }
                if (_lcls02ca.width != -1)
                {
                    l2 = k2;
                    i3 = j2;
                    j3 = i1;
                    if (_lcls02ca.height != -1)
                    {
                        break label0;
                    }
                }
                bCi.add(view);
                j3 = i1;
                i3 = j2;
                l2 = k2;
            }
            k1++;
            k2 = l2;
            j2 = i3;
            i1 = j3;
        }

        k = getPaddingLeft();
        int l1 = getPaddingRight();
        k2 = Math.max(getPaddingTop() + getPaddingBottom() + k2, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(Math.max(j2 + (k + l1), getSuggestedMinimumWidth()), i, i1), resolveSizeAndState(k2, j, i1 << 16));
        j2 = bCi.size();
        if (j2 > 1)
        {
            for (int l = 0; l < j2; l++)
            {
                View view1 = (View)bCi.get(l);
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view1.getLayoutParams();
                int j1;
                if (marginlayoutparams.width == -1)
                {
                    j1 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - marginlayoutparams.leftMargin - marginlayoutparams.rightMargin, 0x40000000);
                } else
                {
                    j1 = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin, marginlayoutparams.width);
                }
                int i2;
                if (marginlayoutparams.height == -1)
                {
                    i2 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - marginlayoutparams.topMargin - marginlayoutparams.bottomMargin, 0x40000000);
                } else
                {
                    i2 = getChildMeasureSpec(j, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, marginlayoutparams.height);
                }
                view1.measure(j1, i2);
            }

        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!bCc)
        {
            return false;
        }
        _cls0142 _lcls0142;
        int i;
        int j;
        _lcls0142 = bBZ;
        j = _cls153E._mth02CA(motionevent);
        i = _cls153E._mth02CB(motionevent);
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        _lcls0142.cancel();
        if (_lcls0142._fld14EF == null)
        {
            _lcls0142._fld14EF = VelocityTracker.obtain();
        }
        _lcls0142._fld14EF.addMovement(motionevent);
        j;
        JVM INSTR tableswitch 0 6: default 1001
    //                   0 108
    //                   1 802
    //                   2 314
    //                   3 824
    //                   4 845
    //                   5 168
    //                   6 657;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        int i1;
        int j1;
        float f1;
        float f4;
        float f6;
        float f7;
        View view2;
        int k;
        int l;
        int k1;
        int l1;
        try
        {
            float f = motionevent.getX();
            float f3 = motionevent.getY();
            i = _cls153E._mth02CB(motionevent, 0);
            View view1 = _lcls0142._mth037A((int)f, (int)f3);
            _lcls0142._mth02CA(f, f3, i);
            _lcls0142._mth141D(view1, i);
            i = _lcls0142.FF7F[i];
        }
        catch (Exception exception)
        {
            _cls0675._mth02CB(new Exception("Crash while processing touch event", exception));
        }
        break; /* Loop/switch isn't completed */
_L6:
        k = _cls153E._mth02CB(motionevent, i);
        f1 = _cls153E._mth02CE(motionevent, i);
        f4 = _cls153E._mth02CF(motionevent, i);
        _lcls0142._mth02CA(f1, f4, k);
        if (_lcls0142.FBA3 == 0)
        {
            _lcls0142._mth141D(_lcls0142._mth037A((int)f1, (int)f4), k);
            break; /* Loop/switch isn't completed */
        }
        i = (int)f1;
        l = (int)f4;
        view2 = _lcls0142._fld0211;
        if (view2 == null) goto _L9; else goto _L8
_L8:
        if (i < view2.getLeft() || i >= view2.getRight() || l < view2.getTop() || l >= view2.getBottom()) goto _L9; else goto _L10
_L10:
        i = 1;
_L26:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        _lcls0142._mth141D(_lcls0142._fld0211, k);
        break; /* Loop/switch isn't completed */
_L4:
        if (_lcls0142.FBA3 != 1) goto _L12; else goto _L11
_L11:
        i = _cls153E._mth02CA(motionevent, _lcls0142._fld157B);
        f1 = _cls153E._mth02CE(motionevent, i);
        f4 = _cls153E._mth02CF(motionevent, i);
        i1 = (int)(f1 - _lcls0142.FF6F[_lcls0142._fld157B]);
        j1 = (int)(f4 - _lcls0142.FF7C[_lcls0142._fld157B]);
        k = _lcls0142._fld0211.getLeft() + i1;
        l = _lcls0142._fld0211.getTop() + j1;
        i = l;
        k1 = _lcls0142._fld0211.getLeft();
        l1 = _lcls0142._fld0211.getTop();
        if (i1 == 0) goto _L14; else goto _L13
_L13:
        k = 0;
        _lcls0142._fld0211.offsetLeftAndRight(0 - k1);
_L14:
        if (j1 == 0) goto _L16; else goto _L15
_L15:
        i = _lcls0142._fld01AC._mth02CF(_lcls0142._fld0211, l, j1);
        _lcls0142._fld0211.offsetTopAndBottom(i - l1);
          goto _L16
_L27:
        _lcls0142._fld01AC._mth02CB(_lcls0142._fld0211, k, i, k - k1, i - l1);
_L28:
        _lcls0142._mth02BB(motionevent);
        break; /* Loop/switch isn't completed */
_L12:
        k = _cls153E._mth02CE(motionevent);
        i = 0;
_L29:
        if (i >= k) goto _L18; else goto _L17
_L17:
        l = _cls153E._mth02CB(motionevent, i);
        f1 = _cls153E._mth02CE(motionevent, i);
        f4 = _cls153E._mth02CF(motionevent, i);
        f6 = f1 - _lcls0142.FEB0[l];
        f7 = f4 - _lcls0142.FEEA[l];
        _lcls0142._mth02CB(f6, f7, l);
        if (_lcls0142.FBA3 == 1) goto _L18; else goto _L19
_L19:
        view2 = _lcls0142._mth037A((int)f1, (int)f4);
        if (_lcls0142._mth02CA(view2, f6, f7) && _lcls0142._mth141D(view2, l)) goto _L18; else goto _L20
_L18:
        _lcls0142._mth02BB(motionevent);
        break; /* Loop/switch isn't completed */
_L7:
        i1 = _cls153E._mth02CB(motionevent, i);
        if (_lcls0142.FBA3 != 1 || i1 != _lcls0142._fld157B) goto _L22; else goto _L21
_L21:
        l = -1;
        j1 = _cls153E._mth02CE(motionevent);
        i = 0;
_L30:
        k = l;
        if (i >= j1) goto _L24; else goto _L23
_L23:
        k = _cls153E._mth02CB(motionevent, i);
        if (k == _lcls0142._fld157B)
        {
            break MISSING_BLOCK_LABEL_1032;
        }
        f1 = _cls153E._mth02CE(motionevent, i);
        f4 = _cls153E._mth02CF(motionevent, i);
        if (_lcls0142._mth037A((int)f1, (int)f4) != _lcls0142._fld0211 || !_lcls0142._mth141D(_lcls0142._fld0211, k))
        {
            break MISSING_BLOCK_LABEL_1032;
        }
        k = _lcls0142._fld157B;
_L24:
        if (k != -1) goto _L22; else goto _L25
_L25:
        _lcls0142.FBE8();
_L22:
        _lcls0142._mth1D62(i1);
        break; /* Loop/switch isn't completed */
_L3:
        if (_lcls0142.FBA3 == 1)
        {
            _lcls0142.FBE8();
        }
        _lcls0142.cancel();
        break; /* Loop/switch isn't completed */
_L5:
        if (_lcls0142.FBA3 == 1)
        {
            _lcls0142._mth02CF(0.0F, 0.0F);
        }
        _lcls0142.cancel();
        if (_cls153E._mth02CE(motionevent) > 1)
        {
            return false;
        }
        float f2 = motionevent.getX();
        float f5 = motionevent.getY();
        bCh = f5;
        switch (_cls153E._mth02CA(motionevent))
        {
        default:
            break;

        case 0: // '\0'
            _fld14F2 = motionevent.getY();
            break;

        case 2: // '\002'
            View view = bBZ._mth037A((int)f2, (int)f5);
            if (view == null || !view.canScrollVertically((int)(_fld14F2 - f5)))
            {
                _mth02CB(_cls153E._mth02CB(motionevent, 0), f5);
            }
            _fld14F2 = f5;
            break;

        case 1: // '\001'
            motionevent = ey();
            if (motionevent != null)
            {
                _mth14A2(motionevent);
            }
            break;
        }
        return true;
_L9:
        i = 0;
          goto _L26
_L16:
        if (i1 == 0 && j1 == 0) goto _L28; else goto _L27
_L20:
        i++;
          goto _L29
        i++;
          goto _L30
    }

    public void requestLayout()
    {
        if (!mInLayout)
        {
            super.requestLayout();
        }
    }

    public void setDragRecorder$72371c23(_cls05E3 _pcls05e3)
    {
        bCg = _pcls05e3;
    }

    public void setDraggable(boolean flag)
    {
        bCc = flag;
    }

    public void setFriction(float f)
    {
        bCd = f;
    }

    public void setOnViewDragListener(_cls02CB _pcls02cb)
    {
        bCa = _pcls02cb;
    }

    public final void _mth02BD(ViewGroup viewgroup)
    {
        switch (viewgroup.getId())
        {
        case 2131558549: 
            if (viewgroup.getTop() <= 0)
            {
                _mth14A1(viewgroup);
                return;
            } else
            {
                _mth14A2(viewgroup);
                return;
            }
        }
        boolean flag;
        if (_mth02CB(bCf, viewgroup) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (viewgroup.getTop() >= getHeight())
            {
                _mth14A1(viewgroup);
                return;
            } else
            {
                _mth14A2(viewgroup);
                return;
            }
        } else
        {
            throw new IllegalArgumentException("Not a drag child");
        }
    }

    public final void _mth14A1(View view)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (!_fld1D68)
                    {
                        break label1;
                    }
                    if (view.getId() != 0x7f0d0095)
                    {
                        boolean flag;
                        if (_mth02CB(bCe, view) != null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (!flag)
                        {
                            break label2;
                        }
                    }
                    ((_cls02CA)view.getLayoutParams()).bCm = 1.0F;
                    break label0;
                }
                throw new IllegalArgumentException("Not a drag child");
            }
            switch (view.getId())
            {
            case 2131558549: 
                bBZ._mth02CE(view, view.getLeft(), (int)bBW);
                break;

            default:
                if (_mth0E40(view))
                {
                    bBZ._mth02CE(view, view.getLeft(), getHeight() - view.getHeight());
                } else
                {
                    throw new IllegalArgumentException("Not a drag child");
                }
                break;
            }
        }
        invalidate();
        _mth02CF(view, false);
    }

    public final void _mth14A2(View view)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (!_fld1D68)
                    {
                        break label1;
                    }
                    if (view.getId() != 0x7f0d0095)
                    {
                        boolean flag;
                        if (_mth02CB(bCe, view) != null)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (!flag)
                        {
                            break label2;
                        }
                    }
                    ((_cls02CA)view.getLayoutParams()).bCm = 0.0F;
                    break label0;
                }
                throw new IllegalArgumentException("Not a drag child");
            }
            switch (view.getId())
            {
            case 2131558549: 
                bBZ._mth02CE(view, view.getLeft(), 0);
                break;

            default:
                if (_mth0E40(view))
                {
                    bBZ._mth02CE(view, view.getLeft(), getHeight());
                } else
                {
                    throw new IllegalArgumentException("Not a drag child");
                }
                break;
            }
        }
        invalidate();
        _mth02CF(view, true);
    }

}
