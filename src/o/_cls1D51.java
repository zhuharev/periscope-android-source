// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

// Referenced classes of package o:
//            _cls1D68, _cls2134, _cls1FD1, _cls0285, 
//            _cls1D60, _cls2179, _cls217D, _cls1D48, 
//            _cls1E3B, FE77

public final class _cls1D51 extends ViewGroup
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private final int a;
    FE77 b;
    private final _cls1D68 c;
    private final _cls2134 d;
    private _cls1E3B e;
    private android.widget.PopupWindow.OnDismissListener f;
    private boolean g;
    private int i;
    private boolean j;
    private int k;
    private final if FC61;
    private final _cls02CA FE99;
    private final _cls1D60 FECF;
    private final Drawable FED0;
    private final FrameLayout FEDB;
    private final ImageView FF4B;
    private final FrameLayout FF87;
    private final ImageView FF92;

    public _cls1D51(Context context)
    {
        this(context, null);
    }

    public _cls1D51(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public _cls1D51(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        c = new _cls1D68(this);
        d = new _cls2134(this);
        i = 4;
        Object obj = context.obtainStyledAttributes(attributeset, _cls1FD1.ActivityChooserView, l, 0);
        i = ((TypedArray) (obj)).getInt(_cls1FD1.ActivityChooserView_initialActivityCount, 4);
        attributeset = ((TypedArray) (obj)).getDrawable(_cls1FD1.ActivityChooserView_expandActivityOverflowButtonDrawable);
        ((TypedArray) (obj)).recycle();
        LayoutInflater.from(getContext()).inflate(_cls0285.if.abc_activity_chooser_view, this, true);
        FE99 = new _cls02CA((byte)0);
        FECF = (_cls1D60)findViewById(_cls0285.activity_chooser_view_content);
        FED0 = FECF.getBackground();
        FF87 = (FrameLayout)findViewById(_cls0285.default_activity_button);
        FF87.setOnClickListener(FE99);
        FF87.setOnLongClickListener(FE99);
        FF92 = (ImageView)FF87.findViewById(_cls0285.image);
        obj = (FrameLayout)findViewById(_cls0285.expand_activities_button);
        ((FrameLayout) (obj)).setOnClickListener(FE99);
        ((FrameLayout) (obj)).setOnTouchListener(new _cls2179(this, ((FrameLayout) (obj))));
        FEDB = ((FrameLayout) (obj));
        FF4B = (ImageView)((FrameLayout) (obj)).findViewById(_cls0285.image);
        FF4B.setImageDrawable(attributeset);
        FC61 = new if((byte)0);
        FC61.registerDataSetObserver(new _cls217D(this));
        context = context.getResources();
        a = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(_cls1ECA.if.abc_config_prefDialogWidth));
    }

    static FrameLayout _mth02BB(_cls1D51 _pcls1d51)
    {
        return _pcls1d51.FEDB;
    }

    static int _mth02BC(_cls1D51 _pcls1d51)
    {
        return _pcls1d51.i;
    }

    static android.widget.PopupWindow.OnDismissListener _mth02BD(_cls1D51 _pcls1d51)
    {
        return _pcls1d51.f;
    }

    static if _mth02CA(_cls1D51 _pcls1d51)
    {
        return _pcls1d51.FC61;
    }

    static void _mth02CA(_cls1D51 _pcls1d51, int l)
    {
        _pcls1d51._mth1423(l);
    }

    static boolean _mth02CA(_cls1D51 _pcls1d51, boolean flag)
    {
        _pcls1d51.g = flag;
        return flag;
    }

    static _cls1E3B _mth02CB(_cls1D51 _pcls1d51)
    {
        return _pcls1d51._mth05D2();
    }

    static void _mth02CE(_cls1D51 _pcls1d51)
    {
        if (_pcls1d51.FC61.getCount() > 0)
        {
            _pcls1d51.FEDB.setEnabled(true);
        } else
        {
            _pcls1d51.FEDB.setEnabled(false);
        }
        int l = _pcls1d51.FC61.m.FEF3();
        int i1 = _pcls1d51.FC61.m.getHistorySize();
        if (l == 1 || l > 1 && i1 > 0)
        {
            _pcls1d51.FF87.setVisibility(0);
            Object obj = _pcls1d51.FC61.m.FF3F();
            android.content.pm.PackageManager packagemanager = _pcls1d51.getContext().getPackageManager();
            _pcls1d51.FF92.setImageDrawable(((ResolveInfo) (obj)).loadIcon(packagemanager));
            if (_pcls1d51.k != 0)
            {
                obj = ((ResolveInfo) (obj)).loadLabel(packagemanager);
                obj = _pcls1d51.getContext().getString(_pcls1d51.k, new Object[] {
                    obj
                });
                _pcls1d51.FF87.setContentDescription(((CharSequence) (obj)));
            }
        } else
        {
            _pcls1d51.FF87.setVisibility(8);
        }
        if (_pcls1d51.FF87.getVisibility() == 0)
        {
            _pcls1d51.FECF.setBackgroundDrawable(_pcls1d51.FED0);
            return;
        } else
        {
            _pcls1d51.FECF.setBackgroundDrawable(null);
            return;
        }
    }

    static boolean _mth02CF(_cls1D51 _pcls1d51)
    {
        return _pcls1d51.g;
    }

    static FrameLayout _mth141D(_cls1D51 _pcls1d51)
    {
        return _pcls1d51.FF87;
    }

    private void _mth1423(int l)
    {
        if (FC61.m == null)
        {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(d);
        boolean flag;
        if (FF87.getVisibility() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int j1 = FC61.m.FEF3();
        int i1;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (l != 0x7fffffff && j1 > l + i1)
        {
            if if1 = FC61;
            if (!if1.q)
            {
                if1.q = true;
                if1.notifyDataSetChanged();
            }
            if1 = FC61;
            l--;
            if (if1.n != l)
            {
                if1.n = l;
                if1.notifyDataSetChanged();
            }
        } else
        {
            if if2 = FC61;
            if (if2.q)
            {
                if2.q = false;
                if2.notifyDataSetChanged();
            }
            if2 = FC61;
            if (if2.n != l)
            {
                if2.n = l;
                if2.notifyDataSetChanged();
            }
        }
        _cls1E3B _lcls1e3b = _mth05D2();
        if (!_lcls1e3b.isShowing())
        {
            if (g || !flag)
            {
                if if3 = FC61;
                if (!if3.o || if3.p != flag)
                {
                    if3.o = true;
                    if3.p = flag;
                    if3.notifyDataSetChanged();
                }
            } else
            {
                if if4 = FC61;
                if (if4.o || if4.p)
                {
                    if4.o = false;
                    if4.p = false;
                    if4.notifyDataSetChanged();
                }
            }
            _lcls1e3b.setContentWidth(Math.min(FC61._mth207F(), a));
            _lcls1e3b.show();
            if (b != null)
            {
                b._mth141D(true);
            }
            _lcls1e3b.getListView().setContentDescription(getContext().getString(_cls09F3.if.abc_activitychooserview_choose_application));
        }
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        _cls1D48 _lcls1d48 = FC61.m;
        if (_lcls1d48 != null)
        {
            _lcls1d48.registerObserver(c);
        }
        j = true;
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        Object obj = FC61.m;
        if (obj != null)
        {
            ((_cls1D48) (obj)).unregisterObserver(c);
        }
        obj = getViewTreeObserver();
        if (((ViewTreeObserver) (obj)).isAlive())
        {
            ((ViewTreeObserver) (obj)).removeGlobalOnLayoutListener(d);
        }
        if (_mth05D2().isShowing())
        {
            _mth03CA();
        }
        j = false;
    }

    protected final void onLayout(boolean flag, int l, int i1, int j1, int k1)
    {
        FECF.layout(0, 0, j1 - l, k1 - i1);
        if (!_mth05D2().isShowing())
        {
            _mth03CA();
        }
    }

    protected final void onMeasure(int l, int i1)
    {
        _cls1D60 _lcls1d60 = FECF;
        int j1 = i1;
        if (FF87.getVisibility() != 0)
        {
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i1), 0x40000000);
        }
        measureChild(_lcls1d60, l, j1);
        setMeasuredDimension(_lcls1d60.getMeasuredWidth(), _lcls1d60.getMeasuredHeight());
    }

    public final void setActivityChooserModel(_cls1D48 _pcls1d48)
    {
        if if1 = FC61;
        _cls1D48 _lcls1d48 = if1.l.FC61.m;
        if (_lcls1d48 != null && if1.l.isShown())
        {
            _lcls1d48.unregisterObserver(if1.l.c);
        }
        if1.m = _pcls1d48;
        if (_pcls1d48 != null && if1.l.isShown())
        {
            _pcls1d48.registerObserver(if1.l.c);
        }
        if1.notifyDataSetChanged();
        if (_mth05D2().isShowing())
        {
            _mth03CA();
            if (_mth05D2().isShowing() || !j)
            {
                return;
            }
            g = false;
            _mth1423(i);
        }
    }

    public final void setDefaultActionButtonContentDescription(int l)
    {
        k = l;
    }

    public final void setExpandActivityOverflowButtonContentDescription(int l)
    {
        String s = getContext().getString(l);
        FF4B.setContentDescription(s);
    }

    public final void setExpandActivityOverflowButtonDrawable(Drawable drawable)
    {
        FF4B.setImageDrawable(drawable);
    }

    public final void setInitialActivityCount(int l)
    {
        i = l;
    }

    public final void setOnDismissListener(android.widget.PopupWindow.OnDismissListener ondismisslistener)
    {
        f = ondismisslistener;
    }

    public final void setProvider(FE77 fe77)
    {
        b = fe77;
    }

    public final boolean _mth02B6()
    {
        if (_mth05D2().isShowing() || !j)
        {
            return false;
        } else
        {
            g = false;
            _mth1423(i);
            return true;
        }
    }

    public final boolean _mth03CA()
    {
        if (_mth05D2().isShowing())
        {
            _mth05D2().dismiss();
            ViewTreeObserver viewtreeobserver = getViewTreeObserver();
            if (viewtreeobserver.isAlive())
            {
                viewtreeobserver.removeGlobalOnLayoutListener(d);
            }
        }
        return true;
    }

    _cls1E3B _mth05D2()
    {
        if (e == null)
        {
            e = new _cls1E3B(getContext());
            e.setAdapter(FC61);
            e.setAnchorView(this);
            e.setModal(true);
            e.setOnItemClickListener(FE99);
            e.setOnDismissListener(FE99);
        }
        return e;
    }
}
