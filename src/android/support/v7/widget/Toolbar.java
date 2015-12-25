// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import o.02E0;
import o.03F3;
import o.0491;
import o.0621;
import o.0715;
import o.09A3;
import o.0E08;
import o.0E41;
import o.0E46;
import o.13AB;
import o.13B1;
import o.144B;
import o.14AB;
import o.14BE;
import o.153E;
import o.1541;
import o.1D10;
import o.1D3A;
import o.1FD1;
import o.706C;
import o.FE70;
import o.FE7C;
import o.FF72;

public class Toolbar extends ViewGroup
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls13AB();
        int iI;
        boolean iJ;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(iI);
            if (iJ)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            iI = parcel.readInt();
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            iJ = flag;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public class if
        implements _cls0491
    {

        private Toolbar iF;
        public _cls03F3 iG;
        private _cls02E0 FB30;

        public static int _mth02B2(int i)
        {
            if (i >= 200 && i <= 299)
            {
                return 0;
            }
            if (i >= 300 && i <= 399)
            {
                return 1;
            }
            if (i >= 400 && i <= 499)
            {
                return 0;
            }
            return i < 500 ? 1 : 1;
        }

        public final void _mth02CA(Context context, _cls02E0 _pcls02e0)
        {
            if (FB30 != null && iG != null)
            {
                FB30._mth02BB(iG);
            }
            FB30 = _pcls02e0;
        }

        public final boolean _mth02CA(_cls0621 _pcls0621)
        {
            return false;
        }

        public final void _mth02CB(_cls02E0 _pcls02e0, boolean flag)
        {
        }

        public final boolean _mth02CB(_cls03F3 _pcls03f3)
        {
            Toolbar._mth02CB(iF);
            if (Toolbar._mth02CE(iF).getParent() != iF)
            {
                iF.addView(Toolbar._mth02CE(iF));
            }
            iF._fldif = _pcls03f3.getActionView();
            iG = _pcls03f3;
            if (iF._fldif.getParent() != iF)
            {
                _cls02CA _lcls02ca = Toolbar.FEF4();
                _lcls02ca.gravity = Toolbar._mth02CF(iF) & 0x70 | 0x800003;
                _lcls02ca.iH = 2;
                iF._fldif.setLayoutParams(_lcls02ca);
                iF.addView(iF._fldif);
            }
            Toolbar toolbar = iF;
            for (int i = toolbar.getChildCount() - 1; i >= 0; i--)
            {
                View view = toolbar.getChildAt(i);
                if (((_cls02CA)view.getLayoutParams()).iH != 2 && view != toolbar._fld039B)
                {
                    toolbar.removeViewAt(i);
                    toolbar.iw.add(view);
                }
            }

            iF.requestLayout();
            _pcls03f3.FECC = true;
            _pcls03f3.FB30.FF9E(false);
            if (iF._fldif instanceof _cls706C)
            {
                ((_cls706C)iF._fldif).onActionViewExpanded();
            }
            return true;
        }

        public final boolean _mth02CE(_cls03F3 _pcls03f3)
        {
            if (iF._fldif instanceof _cls706C)
            {
                ((_cls706C)iF._fldif).onActionViewCollapsed();
            }
            iF.removeView(iF._fldif);
            iF.removeView(Toolbar._mth02CE(iF));
            iF._fldif = null;
            iF._mth012B();
            iG = null;
            iF.requestLayout();
            _pcls03f3.FECC = false;
            _pcls03f3.FB30.FF9E(false);
            return true;
        }

        public final boolean _mth05F2()
        {
            return false;
        }

        public final void _mth1427(boolean flag)
        {
            if (iG != null)
            {
                boolean flag2 = false;
                boolean flag1 = flag2;
                if (FB30 != null)
                {
                    int j = FB30.size();
                    int i = 0;
                    do
                    {
                        flag1 = flag2;
                        if (i >= j)
                        {
                            break;
                        }
                        if (FB30.getItem(i) == iG)
                        {
                            flag1 = true;
                            break;
                        }
                        i++;
                    } while (true);
                }
                if (!flag1)
                {
                    _mth02CE(iG);
                }
            }
        }

        public if()
        {
        }

        private if(Toolbar toolbar)
        {
            iF = toolbar;
            super();
        }

        if(Toolbar toolbar, byte byte0)
        {
            this(toolbar);
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final _cls0715 E;
    private int bB;
    private TextView hX;
    private TextView hY;
    public ImageButton hZ;
    public _cls13B1 iA;
    private _cls1D10 iB;
    public if iC;
    private boolean iD;
    private final _cls0E41 iE;
    private ImageView ia;
    private Drawable ib;
    private CharSequence ic;
    private ImageButton ie;
    View _fldif;
    private int ig;
    private int ih;
    private int ii;
    private int ij;
    private int ik;
    private int il;
    private int im;
    private int io;
    private final FF72 ip;
    public CharSequence iq;
    public CharSequence ir;
    private int is;
    private int it;
    private final ArrayList iu;
    final ArrayList iw;
    private final int ix[];
    private o._cls1D3A._cls02CF iy;
    private final _cls0E08 iz;
    private Context _fld039A;
    public _cls1D3A _fld039B;
    private boolean _fld03EF;
    private boolean _fld03F5;
    private int _fld216D;
    private o._cls0491.if _fld304F;
    private o._cls02E0.if _fld3063;

    public Toolbar(Context context)
    {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, _cls1541.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        ip = new FF72();
        bB = 0x800013;
        iu = new ArrayList();
        iw = new ArrayList();
        ix = new int[2];
        iz = new _cls0E08(this);
        iE = new _cls0E41(this);
        context = getContext();
        context = new _cls09A3(context, context.obtainStyledAttributes(attributeset, _cls1FD1.Toolbar, i, 0));
        i = _cls1FD1.Toolbar_titleTextAppearance;
        ig = ((_cls09A3) (context)).hU.getResourceId(i, 0);
        i = _cls1FD1.Toolbar_subtitleTextAppearance;
        ih = ((_cls09A3) (context)).hU.getResourceId(i, 0);
        i = _cls1FD1.Toolbar_android_gravity;
        int j = bB;
        bB = ((_cls09A3) (context)).hU.getInteger(i, j);
        ii = 48;
        i = _cls1FD1.Toolbar_titleMargins;
        i = ((_cls09A3) (context)).hU.getDimensionPixelOffset(i, 0);
        io = i;
        im = i;
        il = i;
        ik = i;
        i = _cls1FD1.Toolbar_titleMarginStart;
        i = ((_cls09A3) (context)).hU.getDimensionPixelOffset(i, -1);
        if (i >= 0)
        {
            ik = i;
        }
        i = _cls1FD1.Toolbar_titleMarginEnd;
        i = ((_cls09A3) (context)).hU.getDimensionPixelOffset(i, -1);
        if (i >= 0)
        {
            il = i;
        }
        i = _cls1FD1.Toolbar_titleMarginTop;
        i = ((_cls09A3) (context)).hU.getDimensionPixelOffset(i, -1);
        if (i >= 0)
        {
            im = i;
        }
        i = _cls1FD1.Toolbar_titleMarginBottom;
        i = ((_cls09A3) (context)).hU.getDimensionPixelOffset(i, -1);
        if (i >= 0)
        {
            io = i;
        }
        i = _cls1FD1.Toolbar_maxButtonHeight;
        ij = ((_cls09A3) (context)).hU.getDimensionPixelSize(i, -1);
        i = _cls1FD1.Toolbar_contentInsetStart;
        i = ((_cls09A3) (context)).hU.getDimensionPixelOffset(i, 0x80000000);
        j = _cls1FD1.Toolbar_contentInsetEnd;
        j = ((_cls09A3) (context)).hU.getDimensionPixelOffset(j, 0x80000000);
        int k = _cls1FD1.Toolbar_contentInsetLeft;
        k = ((_cls09A3) (context)).hU.getDimensionPixelSize(k, 0);
        int l = _cls1FD1.Toolbar_contentInsetRight;
        l = ((_cls09A3) (context)).hU.getDimensionPixelSize(l, 0);
        ip._mth02B4(k, l);
        if (i != 0x80000000 || j != 0x80000000)
        {
            ip._mth02B3(i, j);
        }
        ib = context.getDrawable(_cls1FD1.Toolbar_collapseIcon);
        i = _cls1FD1.Toolbar_collapseContentDescription;
        ic = ((_cls09A3) (context)).hU.getText(i);
        i = _cls1FD1.Toolbar_title;
        attributeset = ((_cls09A3) (context)).hU.getText(i);
        if (!TextUtils.isEmpty(attributeset))
        {
            setTitle(attributeset);
        }
        i = _cls1FD1.Toolbar_subtitle;
        attributeset = ((_cls09A3) (context)).hU.getText(i);
        if (!TextUtils.isEmpty(attributeset))
        {
            setSubtitle(attributeset);
        }
        _fld039A = getContext();
        i = _cls1FD1.Toolbar_popupTheme;
        setPopupTheme(((_cls09A3) (context)).hU.getResourceId(i, 0));
        attributeset = context.getDrawable(_cls1FD1.Toolbar_navigationIcon);
        if (attributeset != null)
        {
            setNavigationIcon(attributeset);
        }
        i = _cls1FD1.Toolbar_navigationContentDescription;
        attributeset = ((_cls09A3) (context)).hU.getText(i);
        if (!TextUtils.isEmpty(attributeset))
        {
            setNavigationContentDescription(attributeset);
        }
        attributeset = context.getDrawable(_cls1FD1.Toolbar_logo);
        if (attributeset != null)
        {
            setLogo(attributeset);
        }
        i = _cls1FD1.Toolbar_logoDescription;
        attributeset = ((_cls09A3) (context)).hU.getText(i);
        if (!TextUtils.isEmpty(attributeset))
        {
            setLogoDescription(attributeset);
        }
        i = _cls1FD1.Toolbar_titleTextColor;
        if (((_cls09A3) (context)).hU.hasValue(i))
        {
            i = _cls1FD1.Toolbar_titleTextColor;
            setTitleTextColor(((_cls09A3) (context)).hU.getColor(i, -1));
        }
        i = _cls1FD1.Toolbar_subtitleTextColor;
        if (((_cls09A3) (context)).hU.hasValue(i))
        {
            i = _cls1FD1.Toolbar_subtitleTextColor;
            setSubtitleTextColor(((_cls09A3) (context)).hU.getColor(i, -1));
        }
        ((_cls09A3) (context)).hU.recycle();
        if (((_cls09A3) (context)).E == null)
        {
            context.E = _cls0715._mth1FBE(((_cls09A3) (context)).mContext);
        }
        E = ((_cls09A3) (context)).E;
    }

    private int _mth0131(int i)
    {
        i &= 0x70;
        switch (i)
        {
        case 16: // '\020'
        case 48: // '0'
        case 80: // 'P'
            return i;
        }
        return bB & 0x70;
    }

    private int _mth01C3(int i)
    {
        int j = FE70._mth02C9(this);
        i = FE7C.getAbsoluteGravity(i, j) & 7;
        switch (i)
        {
        case 1: // '\001'
        case 3: // '\003'
        case 5: // '\005'
            return i;
        }
        return j != 1 ? 3 : 5;
    }

    private int _mth02BD(View view, int i)
    {
        _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
        int k = view.getMeasuredHeight();
        if (i > 0)
        {
            i = (k - i) / 2;
        } else
        {
            i = 0;
        }
        switch (_mth0131(_lcls02ca.gravity))
        {
        case 48: // '0'
            return getPaddingTop() - i;

        case 80: // 'P'
            return getHeight() - getPaddingBottom() - k - _lcls02ca.bottomMargin - i;
        }
        int l = getPaddingTop();
        int i1 = getPaddingBottom();
        int j1 = getHeight();
        i = (j1 - l - i1 - k) / 2;
        int j = i;
        if (i < _lcls02ca.topMargin)
        {
            i = _lcls02ca.topMargin;
        } else
        {
            k = j1 - i1 - k - j - l;
            i = j;
            if (k < _lcls02ca.bottomMargin)
            {
                i = Math.max(0, j - (_lcls02ca.bottomMargin - k));
            }
        }
        return l + i;
    }

    private int _mth02CA(View view, int i, int j, int k, int l, int ai[])
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i1 = marginlayoutparams.leftMargin - ai[0];
        int j1 = marginlayoutparams.rightMargin - ai[1];
        int k1 = Math.max(0, i1) + Math.max(0, j1);
        ai[0] = Math.max(0, -i1);
        ai[1] = Math.max(0, -j1);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + k1 + j, marginlayoutparams.width), getChildMeasureSpec(k, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin + l, marginlayoutparams.height));
        return view.getMeasuredWidth() + k1;
    }

    private int _mth02CA(View view, int i, int ai[], int j)
    {
        _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
        int k = _lcls02ca.leftMargin - ai[0];
        i += Math.max(0, k);
        ai[0] = Math.max(0, -k);
        j = _mth02BD(view, j);
        k = view.getMeasuredWidth();
        view.layout(i, j, i + k, view.getMeasuredHeight() + j);
        return _lcls02ca.rightMargin + k + i;
    }

    public static o._cls1D3A._cls02CF _mth02CA(Toolbar toolbar)
    {
        return toolbar.iy;
    }

    private int _mth02CB(View view, int i, int ai[], int j)
    {
        _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
        int k = _lcls02ca.rightMargin - ai[1];
        i -= Math.max(0, k);
        ai[1] = Math.max(0, -k);
        j = _mth02BD(view, j);
        k = view.getMeasuredWidth();
        view.layout(i - k, j, i, view.getMeasuredHeight() + j);
        return i - (_lcls02ca.leftMargin + k);
    }

    static void _mth02CB(Toolbar toolbar)
    {
        if (toolbar.ie == null)
        {
            toolbar.ie = new ImageButton(toolbar.getContext(), null, _cls1541.toolbarNavigationButtonStyle);
            toolbar.ie.setImageDrawable(toolbar.ib);
            toolbar.ie.setContentDescription(toolbar.ic);
            _cls02CA _lcls02ca = new _cls02CA(-2, -2);
            _lcls02ca.gravity = toolbar.ii & 0x70 | 0x800003;
            _lcls02ca.iH = 2;
            toolbar.ie.setLayoutParams(_lcls02ca);
            toolbar.ie.setOnClickListener(new _cls0E46(toolbar));
        }
    }

    private void _mth02CB(View view, int i, int j, int k, int l, int i1)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        l = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginlayoutparams.leftMargin + marginlayoutparams.rightMargin + j, marginlayoutparams.width);
        j = getChildMeasureSpec(k, getPaddingTop() + getPaddingBottom() + marginlayoutparams.topMargin + marginlayoutparams.bottomMargin, marginlayoutparams.height);
        i = j;
        k = android.view.View.MeasureSpec.getMode(j);
        j = i;
        if (k != 0x40000000)
        {
            j = i;
            if (i1 >= 0)
            {
                if (k != 0)
                {
                    i1 = Math.min(android.view.View.MeasureSpec.getSize(i), i1);
                }
                j = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
            }
        }
        view.measure(l, j);
    }

    private void _mth02CB(ArrayList arraylist, int i)
    {
        boolean flag;
        if (FE70._mth02C9(this) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k = getChildCount();
        int j = FE7C.getAbsoluteGravity(i, FE70._mth02C9(this));
        arraylist.clear();
        if (flag)
        {
            for (i = k - 1; i >= 0; i--)
            {
                View view = getChildAt(i);
                _cls02CA _lcls02ca = (_cls02CA)view.getLayoutParams();
                if (_lcls02ca.iH != 0)
                {
                    continue;
                }
                boolean flag1;
                if (view != null && view.getParent() == this && view.getVisibility() != 8)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1 && _mth01C3(_lcls02ca.gravity) == j)
                {
                    arraylist.add(view);
                }
            }

            return;
        }
        for (i = 0; i < k; i++)
        {
            View view1 = getChildAt(i);
            _cls02CA _lcls02ca1 = (_cls02CA)view1.getLayoutParams();
            if (_lcls02ca1.iH != 0)
            {
                continue;
            }
            boolean flag2;
            if (view1 != null && view1.getParent() == this && view1.getVisibility() != 8)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2 && _mth01C3(_lcls02ca1.gravity) == j)
            {
                arraylist.add(view1);
            }
        }

    }

    static ImageButton _mth02CE(Toolbar toolbar)
    {
        return toolbar.ie;
    }

    private void _mth02CE(View view, boolean flag)
    {
        Object obj = view.getLayoutParams();
        if (obj == null)
        {
            obj = new _cls02CA(-2, -2);
        } else
        if (!checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj))))
        {
            obj = _mth02CF(((android.view.ViewGroup.LayoutParams) (obj)));
        } else
        {
            obj = (_cls02CA)obj;
        }
        obj.iH = 1;
        if (flag && _fldif != null)
        {
            view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            iw.add(view);
            return;
        } else
        {
            addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
            return;
        }
    }

    static int _mth02CF(Toolbar toolbar)
    {
        return toolbar.ii;
    }

    private static _cls02CA _mth02CF(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof _cls02CA)
        {
            return new _cls02CA((_cls02CA)layoutparams);
        }
        if (layoutparams instanceof o._cls019A.if)
        {
            return new _cls02CA((o._cls019A.if)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new _cls02CA((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new _cls02CA(layoutparams);
        }
    }

    private void FE98()
    {
        if (_fld039B == null)
        {
            _fld039B = new _cls1D3A(getContext());
            _fld039B.setPopupTheme(_fld216D);
            _fld039B.setOnMenuItemClickListener(iz);
            _fld039B.setMenuCallbacks(_fld304F, _fld3063);
            _cls02CA _lcls02ca = new _cls02CA(-2, -2);
            _lcls02ca.gravity = ii & 0x70 | 0x800005;
            _fld039B.setLayoutParams(_lcls02ca);
            _mth02CE(_fld039B, false);
        }
    }

    private void FEAB()
    {
        if (hZ == null)
        {
            hZ = new ImageButton(getContext(), null, _cls1541.toolbarNavigationButtonStyle);
            _cls02CA _lcls02ca = new _cls02CA(-2, -2);
            _lcls02ca.gravity = ii & 0x70 | 0x800003;
            hZ.setLayoutParams(_lcls02ca);
        }
    }

    protected static _cls02CA FEF4()
    {
        return new _cls02CA(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return super.checkLayoutParams(layoutparams) && (layoutparams instanceof _cls02CA);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new _cls02CA(-2, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new _cls02CA(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return _mth02CF(layoutparams);
    }

    public final boolean isOverflowMenuShowing()
    {
        if (_fld039B != null)
        {
            _cls1D3A _lcls1d3a = _fld039B;
            boolean flag;
            if (_lcls1d3a._fld2183 != null && _lcls1d3a._fld2183.isOverflowMenuShowing())
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
        return false;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeCallbacks(iE);
    }

    public boolean onHoverEvent(MotionEvent motionevent)
    {
        int i = _cls153E._mth02CA(motionevent);
        if (i == 9)
        {
            _fld03F5 = false;
        }
        if (!_fld03F5)
        {
            boolean flag = super.onHoverEvent(motionevent);
            if (i == 9 && !flag)
            {
                _fld03F5 = true;
            }
        }
        if (i == 10 || i == 3)
        {
            _fld03F5 = false;
        }
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int ai[];
        int j5;
        int k5;
        int l5;
        int i6;
label0:
        {
            boolean flag1;
            if (FE70._mth02C9(this) == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            l5 = getWidth();
            int j6 = getHeight();
            j5 = getPaddingLeft();
            i6 = getPaddingRight();
            int k4 = getPaddingTop();
            int k6 = getPaddingBottom();
            k = j5;
            int l1 = l5 - i6;
            ai = ix;
            ai[1] = 0;
            ai[0] = 0;
            k5 = FE70._mth1427(this);
            Object obj = hZ;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                l = 1;
            } else
            {
                l = 0;
            }
            i = k;
            j = l1;
            if (l != 0)
            {
                if (flag1)
                {
                    j = _mth02CB(hZ, l1, ai, k5);
                    i = k;
                } else
                {
                    i = _mth02CA(hZ, j5, ai, k5);
                    j = l1;
                }
            }
            obj = ie;
            boolean flag2;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            k = i;
            l = j;
            if (flag2)
            {
                if (flag1)
                {
                    l = _mth02CB(ie, j, ai, k5);
                    k = i;
                } else
                {
                    k = _mth02CA(ie, i, ai, k5);
                    l = j;
                }
            }
            obj = _fld039B;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            flag2 = k;
            i = l;
            if (j != 0)
            {
                if (flag1)
                {
                    flag2 = _mth02CA(_fld039B, k, ai, k5);
                    i = l;
                } else
                {
                    i = _mth02CB(_fld039B, l, ai, k5);
                    flag2 = k;
                }
            }
            ai[0] = Math.max(0, ip.fK - flag2);
            ai[1] = Math.max(0, ip.fL - (l5 - i6 - i));
            k = Math.max(flag2, ip.fK);
            flag2 = Math.min(i, l5 - i6 - ip.fL);
            obj = _fldif;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            i = k;
            l = ((flag2) ? 1 : 0);
            if (j != 0)
            {
                if (flag1)
                {
                    l = _mth02CB(_fldif, flag2, ai, k5);
                    i = k;
                } else
                {
                    i = _mth02CA(_fldif, k, ai, k5);
                    l = ((flag2) ? 1 : 0);
                }
            }
            obj = ia;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            j = i;
            k = l;
            if (flag2)
            {
                if (flag1)
                {
                    k = _mth02CB(ia, l, ai, k5);
                    j = i;
                } else
                {
                    j = _mth02CA(ia, i, ai, k5);
                    k = l;
                }
            }
            obj = hX;
            int i3;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                i3 = 1;
            } else
            {
                i3 = 0;
            }
            obj = hY;
            int j2;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                j2 = 1;
            } else
            {
                j2 = 0;
            }
            i = 0;
            if (i3 != 0)
            {
                obj = (_cls02CA)hX.getLayoutParams();
                i = ((_cls02CA) (obj)).topMargin + hX.getMeasuredHeight() + ((_cls02CA) (obj)).bottomMargin + 0;
            }
            int k3 = i;
            if (j2 != 0)
            {
                obj = (_cls02CA)hY.getLayoutParams();
                k3 = i + (((_cls02CA) (obj)).topMargin + hY.getMeasuredHeight() + ((_cls02CA) (obj)).bottomMargin);
            }
            if (i3 == 0)
            {
                i = j;
                l = k;
                if (j2 == 0)
                {
                    break label0;
                }
            }
            if (i3 != 0)
            {
                obj = hX;
            } else
            {
                obj = hY;
            }
            Object obj1;
            if (j2 != 0)
            {
                obj1 = hY;
            } else
            {
                obj1 = hX;
            }
            obj = (_cls02CA)((View) (obj)).getLayoutParams();
            obj1 = (_cls02CA)((View) (obj1)).getLayoutParams();
            if (i3 != 0 && hX.getMeasuredWidth() > 0 || j2 != 0 && hY.getMeasuredWidth() > 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            switch (bB & 0x70)
            {
            case 48: // '0'
                i = getPaddingTop() + ((_cls02CA) (obj)).topMargin + im;
                break;

            default:
                i = (j6 - k4 - k6 - k3) / 2;
                l = i;
                if (i < ((_cls02CA) (obj)).topMargin + im)
                {
                    i = ((_cls02CA) (obj)).topMargin + im;
                } else
                {
                    k3 = j6 - k6 - k3 - l - k4;
                    i = l;
                    if (k3 < ((_cls02CA) (obj)).bottomMargin + io)
                    {
                        i = Math.max(0, l - ((((_cls02CA) (obj1)).bottomMargin + io) - k3));
                    }
                }
                i = k4 + i;
                break;

            case 80: // 'P'
                i = j6 - k6 - ((_cls02CA) (obj1)).bottomMargin - io - k3;
                break;
            }
            if (flag1)
            {
                if (flag2)
                {
                    l = ik;
                } else
                {
                    l = 0;
                }
                l -= ai[1];
                k -= Math.max(0, l);
                ai[1] = Math.max(0, -l);
                int l3 = k;
                l = k;
                int l4 = i;
                int i1 = l3;
                if (i3 != 0)
                {
                    _cls02CA _lcls02ca = (_cls02CA)hX.getLayoutParams();
                    i1 = l3 - hX.getMeasuredWidth();
                    i3 = i + hX.getMeasuredHeight();
                    hX.layout(i1, i, l3, i3);
                    i1 -= il;
                    l4 = i3 + _lcls02ca.bottomMargin;
                }
                i = l;
                if (j2 != 0)
                {
                    _cls02CA _lcls02ca1 = (_cls02CA)hY.getLayoutParams();
                    i = l4 + _lcls02ca1.topMargin;
                    j2 = hY.getMeasuredWidth();
                    i3 = hY.getMeasuredHeight();
                    hY.layout(l - j2, i, l, i + i3);
                    i = l - il;
                    l = _lcls02ca1.bottomMargin;
                }
                if (flag2)
                {
                    k = Math.min(i1, i);
                }
                i = j;
                l = k;
            } else
            {
                if (flag2)
                {
                    l = ik;
                } else
                {
                    l = 0;
                }
                l -= ai[0];
                j += Math.max(0, l);
                ai[0] = Math.max(0, -l);
                int i4 = j;
                l = j;
                int i5 = i;
                int j1 = i4;
                if (i3 != 0)
                {
                    _cls02CA _lcls02ca2 = (_cls02CA)hX.getLayoutParams();
                    j1 = i4 + hX.getMeasuredWidth();
                    i3 = i + hX.getMeasuredHeight();
                    hX.layout(i4, i, j1, i3);
                    j1 += il;
                    i5 = i3 + _lcls02ca2.bottomMargin;
                }
                i3 = l;
                if (j2 != 0)
                {
                    _cls02CA _lcls02ca3 = (_cls02CA)hY.getLayoutParams();
                    i = i5 + _lcls02ca3.topMargin;
                    int k2 = l + hY.getMeasuredWidth();
                    i3 = hY.getMeasuredHeight();
                    hY.layout(l, i, k2, i + i3);
                    i3 = k2 + il;
                    i = _lcls02ca3.bottomMargin;
                }
                i = j;
                l = k;
                if (flag2)
                {
                    i = Math.max(j1, i3);
                    l = k;
                }
            }
        }
        _mth02CB(iu, 3);
        k = iu.size();
        for (j = 0; j < k; j++)
        {
            i = _mth02CA((View)iu.get(j), i, ai, k5);
        }

        _mth02CB(iu, 5);
        k = iu.size();
        for (j = 0; j < k; j++)
        {
            l = _mth02CB((View)iu.get(j), l, ai, k5);
        }

        _mth02CB(iu, 1);
        ArrayList arraylist = iu;
        int i2 = ai[0];
        int k1 = ai[1];
        j = 0;
        int l2 = arraylist.size();
        for (k = 0; k < l2; k++)
        {
            View view = (View)arraylist.get(k);
            _cls02CA _lcls02ca4 = (_cls02CA)view.getLayoutParams();
            i2 = _lcls02ca4.leftMargin - i2;
            k1 = _lcls02ca4.rightMargin - k1;
            int j3 = Math.max(0, i2);
            int j4 = Math.max(0, k1);
            i2 = Math.max(0, -i2);
            k1 = Math.max(0, -k1);
            j += view.getMeasuredWidth() + j3 + j4;
        }

        k1 = (j5 + (l5 - j5 - i6) / 2) - j / 2;
        k = k1;
        j = k1 + j;
        if (k >= i)
        {
            i = k;
            if (j > l)
            {
                i = k - (j - l);
            }
        }
        k = iu.size();
        for (j = 0; j < k; j++)
        {
            i = _mth02CA((View)iu.get(j), i, ai, k5);
        }

        iu.clear();
    }

    protected void onMeasure(int i, int j)
    {
        int l;
        int i1;
label0:
        {
            int k1 = 0;
            int j1 = 0;
            int ai[] = ix;
            int i2;
            int j2;
            if (_cls14AB._mth02CF(this))
            {
                j2 = 1;
                i2 = 0;
            } else
            {
                j2 = 0;
                i2 = 1;
            }
            int l1 = 0;
            Object obj = hZ;
            boolean flag;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _mth02CB(hZ, i, 0, j, 0, ij);
                int k = hZ.getMeasuredWidth();
                obj = (android.view.ViewGroup.MarginLayoutParams)hZ.getLayoutParams();
                l1 = k + (_cls144B._mth02CA(((android.view.ViewGroup.MarginLayoutParams) (obj))) + _cls144B._mth02CB(((android.view.ViewGroup.MarginLayoutParams) (obj))));
                k = hZ.getMeasuredHeight();
                obj = (android.view.ViewGroup.MarginLayoutParams)hZ.getLayoutParams();
                k1 = Math.max(0, k + (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin));
                j1 = _cls14AB.combineMeasuredStates(0, FE70._mth02CC(hZ));
            }
            obj = ie;
            boolean flag3;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            i1 = k1;
            l = j1;
            if (flag3)
            {
                _mth02CB(ie, i, 0, j, 0, ij);
                l = ie.getMeasuredWidth();
                obj = (android.view.ViewGroup.MarginLayoutParams)ie.getLayoutParams();
                l1 = l + (_cls144B._mth02CA(((android.view.ViewGroup.MarginLayoutParams) (obj))) + _cls144B._mth02CB(((android.view.ViewGroup.MarginLayoutParams) (obj))));
                l = ie.getMeasuredHeight();
                obj = (android.view.ViewGroup.MarginLayoutParams)ie.getLayoutParams();
                i1 = Math.max(k1, l + (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin));
                l = _cls14AB.combineMeasuredStates(j1, FE70._mth02CC(ie));
            }
            obj = ip;
            if (((FF72) (obj)).fP)
            {
                j1 = ((FF72) (obj)).fL;
            } else
            {
                j1 = ((FF72) (obj)).fK;
            }
            int k2 = Math.max(j1, l1) + 0;
            ai[j2] = Math.max(0, j1 - l1);
            l1 = 0;
            obj = _fld039B;
            boolean flag2;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            k1 = i1;
            j1 = l;
            if (flag2)
            {
                _mth02CB(_fld039B, i, k2, j, 0, ij);
                j1 = _fld039B.getMeasuredWidth();
                obj = (android.view.ViewGroup.MarginLayoutParams)_fld039B.getLayoutParams();
                l1 = j1 + (_cls144B._mth02CA(((android.view.ViewGroup.MarginLayoutParams) (obj))) + _cls144B._mth02CB(((android.view.ViewGroup.MarginLayoutParams) (obj))));
                j1 = _fld039B.getMeasuredHeight();
                obj = (android.view.ViewGroup.MarginLayoutParams)_fld039B.getLayoutParams();
                k1 = Math.max(i1, j1 + (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin));
                j1 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(_fld039B));
            }
            obj = ip;
            if (((FF72) (obj)).fP)
            {
                l = ((FF72) (obj)).fK;
            } else
            {
                l = ((FF72) (obj)).fL;
            }
            flag2 = k2 + Math.max(l, l1);
            ai[i2] = Math.max(0, l - l1);
            obj = _fldif;
            boolean flag1;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            l1 = ((flag2) ? 1 : 0);
            i1 = k1;
            l = j1;
            if (flag1)
            {
                l1 = flag2 + _mth02CA(_fldif, i, flag2, j, 0, ai);
                l = _fldif.getMeasuredHeight();
                obj = (android.view.ViewGroup.MarginLayoutParams)_fldif.getLayoutParams();
                i1 = Math.max(k1, l + (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin));
                l = _cls14AB.combineMeasuredStates(j1, FE70._mth02CC(_fldif));
            }
            obj = ia;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            j1 = l1;
            k1 = i1;
            flag1 = l;
            if (flag2)
            {
                j1 = l1 + _mth02CA(ia, i, l1, j, 0, ai);
                k1 = ia.getMeasuredHeight();
                obj = (android.view.ViewGroup.MarginLayoutParams)ia.getLayoutParams();
                k1 = Math.max(i1, k1 + (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin));
                flag1 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(ia));
            }
            int l2 = getChildCount();
            i1 = 0;
            l = ((flag1) ? 1 : 0);
            flag1 = k1;
            l1 = j1;
            while (i1 < l2) 
            {
                obj = getChildAt(i1);
                flag2 = l1;
                k1 = ((flag1) ? 1 : 0);
                j1 = l;
                if (((_cls02CA)((View) (obj)).getLayoutParams()).iH == 0)
                {
                    boolean flag4;
                    if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    flag2 = l1;
                    k1 = ((flag1) ? 1 : 0);
                    j1 = l;
                    if (flag4)
                    {
                        flag2 = l1 + _mth02CA(((View) (obj)), i, l1, j, 0, ai);
                        j1 = ((View) (obj)).getMeasuredHeight();
                        android.view.ViewGroup.MarginLayoutParams marginlayoutparams1 = (android.view.ViewGroup.MarginLayoutParams)((View) (obj)).getLayoutParams();
                        k1 = Math.max(flag1, j1 + (marginlayoutparams1.topMargin + marginlayoutparams1.bottomMargin));
                        j1 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(((View) (obj))));
                    }
                }
                i1++;
                l1 = ((flag2) ? 1 : 0);
                flag1 = k1;
                l = j1;
            }
            k1 = 0;
            j1 = 0;
            int i3 = im + io;
            int j3 = ik + il;
            obj = hX;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            i1 = l;
            if (flag2)
            {
                _mth02CA(hX, i, l1 + j3, j, i3, ai);
                i1 = hX.getMeasuredWidth();
                obj = (android.view.ViewGroup.MarginLayoutParams)hX.getLayoutParams();
                k1 = i1 + (_cls144B._mth02CA(((android.view.ViewGroup.MarginLayoutParams) (obj))) + _cls144B._mth02CB(((android.view.ViewGroup.MarginLayoutParams) (obj))));
                i1 = hX.getMeasuredHeight();
                obj = (android.view.ViewGroup.MarginLayoutParams)hX.getLayoutParams();
                j1 = i1 + (((android.view.ViewGroup.MarginLayoutParams) (obj)).topMargin + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin);
                i1 = _cls14AB.combineMeasuredStates(l, FE70._mth02CC(hX));
            }
            obj = hY;
            boolean flag5;
            if (obj != null && ((View) (obj)).getParent() == this && ((View) (obj)).getVisibility() != 8)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            l = i1;
            flag2 = k1;
            flag4 = j1;
            if (flag5)
            {
                flag2 = Math.max(k1, _mth02CA(hY, i, l1 + j3, j, j1 + i3, ai));
                l = hY.getMeasuredHeight();
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)hY.getLayoutParams();
                flag4 = j1 + (l + (marginlayoutparams.topMargin + marginlayoutparams.bottomMargin));
                l = _cls14AB.combineMeasuredStates(i1, FE70._mth02CC(hY));
            }
            j1 = Math.max(flag1, flag4);
            i1 = getPaddingLeft();
            flag4 = getPaddingRight();
            k1 = getPaddingTop();
            flag1 = getPaddingBottom();
            i1 = FE70.resolveSizeAndState(Math.max(l1 + flag2 + (i1 + flag4), getSuggestedMinimumWidth()), i, 0xff000000 & l);
            l = FE70.resolveSizeAndState(Math.max(j1 + (k1 + flag1), getSuggestedMinimumHeight()), j, l << 16);
            if (!iD)
            {
                i = 0;
                break label0;
            }
            j1 = getChildCount();
            i = 0;
            do
            {
                if (i >= j1)
                {
                    break;
                }
                View view = getChildAt(i);
                if (view != null && view.getParent() == this && view.getVisibility() != 8)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (j != 0 && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0)
                {
                    i = 0;
                    break label0;
                }
                i++;
            } while (true);
            i = 1;
        }
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = l;
        }
        setMeasuredDimension(i1, i);
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (_fld039B != null)
        {
            parcelable = _fld039B.FB30;
        } else
        {
            parcelable = null;
        }
        if (savedstate.iI != 0 && iC != null && parcelable != null)
        {
            parcelable = parcelable.findItem(savedstate.iI);
            if (parcelable != null)
            {
                _cls14BE._mth02CB(parcelable);
            }
        }
        if (savedstate.iJ)
        {
            removeCallbacks(iE);
            post(iE);
        }
    }

    public void onRtlPropertiesChanged(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            super.onRtlPropertiesChanged(i);
        }
        FF72 ff72 = ip;
        boolean flag;
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag != ff72.fP)
        {
            ff72.fP = flag;
            if (ff72.fQ)
            {
                if (flag)
                {
                    if (ff72._fld1ECA != 0x80000000)
                    {
                        i = ff72._fld1ECA;
                    } else
                    {
                        i = ff72.fN;
                    }
                    ff72.fK = i;
                    if (ff72.fM != 0x80000000)
                    {
                        i = ff72.fM;
                    } else
                    {
                        i = ff72.fO;
                    }
                    ff72.fL = i;
                    return;
                }
                if (ff72.fM != 0x80000000)
                {
                    i = ff72.fM;
                } else
                {
                    i = ff72.fN;
                }
                ff72.fK = i;
                if (ff72._fld1ECA != 0x80000000)
                {
                    i = ff72._fld1ECA;
                } else
                {
                    i = ff72.fO;
                }
                ff72.fL = i;
                return;
            }
            ff72.fK = ff72.fN;
            ff72.fL = ff72.fO;
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (iC != null && iC.iG != null)
        {
            savedstate.iI = iC.iG.getItemId();
        }
        savedstate.iJ = isOverflowMenuShowing();
        return savedstate;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = _cls153E._mth02CA(motionevent);
        if (i == 0)
        {
            _fld03EF = false;
        }
        if (!_fld03EF)
        {
            boolean flag = super.onTouchEvent(motionevent);
            if (i == 0 && !flag)
            {
                _fld03EF = true;
            }
        }
        if (i == 1 || i == 3)
        {
            _fld03EF = false;
        }
        return true;
    }

    public void setCollapsible(boolean flag)
    {
        iD = flag;
        requestLayout();
    }

    public void setContentInsetsAbsolute(int i, int j)
    {
        ip._mth02B4(i, j);
    }

    public void setContentInsetsRelative(int i, int j)
    {
        ip._mth02B3(i, j);
    }

    public void setLogo(int i)
    {
        setLogo(E._mth02BD(i, false));
    }

    public void setLogo(Drawable drawable)
    {
        if (drawable != null)
        {
            if (ia == null)
            {
                ia = new ImageView(getContext());
            }
            ImageView imageview = ia;
            boolean flag;
            if (imageview.getParent() == this || iw.contains(imageview))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _mth02CE(ia, true);
            }
        } else
        if (ia != null)
        {
            ImageView imageview1 = ia;
            boolean flag1;
            if (imageview1.getParent() == this || iw.contains(imageview1))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                removeView(ia);
                iw.remove(ia);
            }
        }
        if (ia != null)
        {
            ia.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i)
    {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence) && ia == null)
        {
            ia = new ImageView(getContext());
        }
        if (ia != null)
        {
            ia.setContentDescription(charsequence);
        }
    }

    public void setMenu(_cls02E0 _pcls02e0, _cls1D10 _pcls1d10)
    {
        if (_pcls02e0 == null && _fld039B == null)
        {
            return;
        }
        FE98();
        _cls02E0 _lcls02e0 = _fld039B.FB30;
        if (_lcls02e0 == _pcls02e0)
        {
            return;
        }
        if (_lcls02e0 != null)
        {
            _lcls02e0._mth02CA(iB);
            _lcls02e0._mth02CA(iC);
        }
        if (iC == null)
        {
            iC = new if(this, (byte)0);
        }
        _pcls1d10._fld15B8 = true;
        if (_pcls02e0 != null)
        {
            Object obj = _fld039A;
            _pcls02e0._fld5B80.add(new WeakReference(_pcls1d10));
            _pcls1d10._mth02CA(((Context) (obj)), _pcls02e0);
            _pcls02e0._fld1F3F = true;
            obj = iC;
            Context context = _fld039A;
            _pcls02e0._fld5B80.add(new WeakReference(obj));
            ((_cls0491) (obj))._mth02CA(context, _pcls02e0);
            _pcls02e0._fld1F3F = true;
        } else
        {
            _pcls1d10._mth02CA(_fld039A, null);
            iC._mth02CA(_fld039A, null);
            _pcls1d10._mth1427(true);
            iC._mth1427(true);
        }
        _fld039B.setPopupTheme(_fld216D);
        _fld039B.setPresenter(_pcls1d10);
        iB = _pcls1d10;
    }

    public void setMenuCallbacks(o._cls0491.if if1, o._cls02E0.if if2)
    {
        _fld304F = if1;
        _fld3063 = if2;
    }

    public void setNavigationContentDescription(int i)
    {
        CharSequence charsequence;
        if (i != 0)
        {
            charsequence = getContext().getText(i);
        } else
        {
            charsequence = null;
        }
        setNavigationContentDescription(charsequence);
    }

    public void setNavigationContentDescription(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            FEAB();
        }
        if (hZ != null)
        {
            hZ.setContentDescription(charsequence);
        }
    }

    public void setNavigationIcon(int i)
    {
        setNavigationIcon(E._mth02BD(i, false));
    }

    public void setNavigationIcon(Drawable drawable)
    {
        if (drawable != null)
        {
            FEAB();
            ImageButton imagebutton = hZ;
            boolean flag;
            if (imagebutton.getParent() == this || iw.contains(imagebutton))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _mth02CE(hZ, true);
            }
        } else
        if (hZ != null)
        {
            ImageButton imagebutton1 = hZ;
            boolean flag1;
            if (imagebutton1.getParent() == this || iw.contains(imagebutton1))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                removeView(hZ);
                iw.remove(hZ);
            }
        }
        if (hZ != null)
        {
            hZ.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        FEAB();
        hZ.setOnClickListener(onclicklistener);
    }

    public void setOnMenuItemClickListener$486aeec7(o._cls1D3A._cls02CF _pcls02cf)
    {
        iy = _pcls02cf;
    }

    public void setOverflowIcon(Drawable drawable)
    {
        FE7F();
        _fld039B.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i)
    {
        if (_fld216D != i)
        {
            _fld216D = i;
            if (i == 0)
            {
                _fld039A = getContext();
                return;
            }
            _fld039A = new ContextThemeWrapper(getContext(), i);
        }
    }

    public void setSubtitle(int i)
    {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            if (hY == null)
            {
                Context context = getContext();
                hY = new TextView(context);
                hY.setSingleLine();
                hY.setEllipsize(android.text.TextUtils.TruncateAt.END);
                if (ih != 0)
                {
                    hY.setTextAppearance(context, ih);
                }
                if (it != 0)
                {
                    hY.setTextColor(it);
                }
            }
            TextView textview = hY;
            boolean flag;
            if (textview.getParent() == this || iw.contains(textview))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _mth02CE(hY, true);
            }
        } else
        if (hY != null)
        {
            TextView textview1 = hY;
            boolean flag1;
            if (textview1.getParent() == this || iw.contains(textview1))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                removeView(hY);
                iw.remove(hY);
            }
        }
        if (hY != null)
        {
            hY.setText(charsequence);
        }
        ir = charsequence;
    }

    public void setSubtitleTextAppearance(Context context, int i)
    {
        ih = i;
        if (hY != null)
        {
            hY.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(int i)
    {
        it = i;
        if (hY != null)
        {
            hY.setTextColor(i);
        }
    }

    public void setTitle(int i)
    {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            if (hX == null)
            {
                Context context = getContext();
                hX = new TextView(context);
                hX.setSingleLine();
                hX.setEllipsize(android.text.TextUtils.TruncateAt.END);
                if (ig != 0)
                {
                    hX.setTextAppearance(context, ig);
                }
                if (is != 0)
                {
                    hX.setTextColor(is);
                }
            }
            TextView textview = hX;
            boolean flag;
            if (textview.getParent() == this || iw.contains(textview))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _mth02CE(hX, true);
            }
        } else
        if (hX != null)
        {
            TextView textview1 = hX;
            boolean flag1;
            if (textview1.getParent() == this || iw.contains(textview1))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                removeView(hX);
                iw.remove(hX);
            }
        }
        if (hX != null)
        {
            hX.setText(charsequence);
        }
        iq = charsequence;
    }

    public void setTitleTextAppearance(Context context, int i)
    {
        ig = i;
        if (hX != null)
        {
            hX.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i)
    {
        is = i;
        if (hX != null)
        {
            hX.setTextColor(i);
        }
    }

    public final boolean showOverflowMenu()
    {
        if (_fld039B != null)
        {
            _cls1D3A _lcls1d3a = _fld039B;
            boolean flag;
            if (_lcls1d3a._fld2183 != null && _lcls1d3a._fld2183.showOverflowMenu())
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
        return false;
    }

    final void _mth012B()
    {
        for (int i = iw.size() - 1; i >= 0; i--)
        {
            addView((View)iw.get(i));
        }

        iw.clear();
    }

    public void FE7F()
    {
        FE98();
        if (_fld039B.FB30 == null)
        {
            _cls02E0 _lcls02e0 = (_cls02E0)_fld039B._mth1601();
            if (iC == null)
            {
                iC = new if(this, (byte)0);
            }
            _fld039B.setExpandedActionViewsExclusive(true);
            if if1 = iC;
            Context context = _fld039A;
            _lcls02e0._fld5B80.add(new WeakReference(if1));
            if1._mth02CA(context, _lcls02e0);
            _lcls02e0._fld1F3F = true;
        }
    }
}
