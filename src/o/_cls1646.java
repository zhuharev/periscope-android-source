// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            FE9B, FEE8

public class _cls1646
{
    /* member class not found */
    class aux {}

    /* member class not found */
    class if {}

    /* member class not found */
    class if.if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls141D {}


    static final _cls141D _fld0155;
    private WeakReference _fld012A;
    private Runnable _fld012C;
    private Runnable _fld012E;
    private int _fld012F;

    _cls1646(View view)
    {
        _fld012C = null;
        _fld012E = null;
        _fld012F = -1;
        _fld012A = new WeakReference(view);
    }

    static int _mth02CA(_cls1646 _pcls1646, int i)
    {
        _pcls1646._fld012F = i;
        return i;
    }

    static Runnable _mth02CA(_cls1646 _pcls1646)
    {
        return _pcls1646._fld012C;
    }

    static Runnable _mth02CB(_cls1646 _pcls1646)
    {
        return _pcls1646._fld012E;
    }

    static int _mth02CE(_cls1646 _pcls1646)
    {
        return _pcls1646._fld012F;
    }

    public void cancel()
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CB(this, view);
        }
    }

    public long getDuration()
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            return _fld0155._mth02CA(this, view);
        } else
        {
            return 0L;
        }
    }

    public void start()
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CE(this, view);
        }
    }

    public _cls1646 _mth02BB(float f)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CF(this, view, f);
        }
        return this;
    }

    public _cls1646 _mth02CA(Interpolator interpolator)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CA(this, view, interpolator);
        }
        return this;
    }

    public _cls1646 _mth02CA(FE9B fe9b)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CA(this, view, fe9b);
        }
        return this;
    }

    public _cls1646 _mth02CA(FEE8 fee8)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CA(this, view, fee8);
        }
        return this;
    }

    public _cls1646 _mth02CB(long l)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CA(this, view, l);
        }
        return this;
    }

    public _cls1646 _mth02CE(float f)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CA(this, view, f);
        }
        return this;
    }

    public _cls1646 _mth02CE(long l)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CB(this, view, l);
        }
        return this;
    }

    public _cls1646 _mth02CF(float f)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CB(this, view, f);
        }
        return this;
    }

    public _cls1646 _mth141D(float f)
    {
        View view = (View)_fld012A.get();
        if (view != null)
        {
            _fld0155._mth02CE(this, view, f);
        }
        return this;
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            _fld0155 = new aux();
        } else
        if (i >= 19)
        {
            _fld0155 = new _cls02CF();
        } else
        if (i >= 18)
        {
            _fld0155 = new _cls02CB();
        } else
        if (i >= 16)
        {
            _fld0155 = new _cls02CE();
        } else
        if (i >= 14)
        {
            _fld0155 = new _cls02CA();
        } else
        {
            _fld0155 = new if();
        }
    }
}
