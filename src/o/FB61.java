// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.animation.Interpolator;

public class FB61
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    Object _fld0507;
    if _fld05D4;

    private FB61(int i, Context context, Interpolator interpolator)
    {
        if (i >= 14)
        {
            _fld05D4 = new _cls02CE();
        } else
        if (i >= 9)
        {
            _fld05D4 = new _cls02CB();
        } else
        {
            _fld05D4 = new _cls02CA();
        }
        _fld0507 = _fld05D4._mth02CB(context, interpolator);
    }

    public FB61(Context context, Interpolator interpolator)
    {
        this(android.os.Build.VERSION.SDK_INT, context, interpolator);
    }

    public static FB61 _mth02CA(Context context, Interpolator interpolator)
    {
        return new FB61(context, interpolator);
    }

    public static FB61 _mth141D(Context context)
    {
        return _mth02CA(context, null);
    }

    public void abortAnimation()
    {
        _fld05D4._mth1D62(_fld0507);
    }

    public boolean computeScrollOffset()
    {
        return _fld05D4._mth1D54(_fld0507);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        _fld05D4._mth02CA(_fld0507, i, j, k, l, i1, j1, k1, l1);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        _fld05D4._mth02CA(_fld0507, i, j, k, l, i1, j1, k1, l1, i2, j2);
    }

    public float getCurrVelocity()
    {
        return _fld05D4._mth1D4E(_fld0507);
    }

    public int getCurrX()
    {
        return _fld05D4._mth0674(_fld0507);
    }

    public int getCurrY()
    {
        return _fld05D4._mth1D35(_fld0507);
    }

    public int getFinalX()
    {
        return _fld05D4._mth2071(_fld0507);
    }

    public int getFinalY()
    {
        return _fld05D4.FE76(_fld0507);
    }

    public boolean isFinished()
    {
        return _fld05D4._mth0559(_fld0507);
    }

    public boolean springBack(int i, int j, int k, int l, int i1, int j1)
    {
        return _fld05D4._mth02CA(_fld0507, i, j, k, l, i1, j1);
    }

    public void startScroll(int i, int j, int k, int l)
    {
        _fld05D4._mth02CA(_fld0507, i, j, k, l);
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        _fld05D4._mth02CA(_fld0507, i, j, k, l, i1);
    }
}
