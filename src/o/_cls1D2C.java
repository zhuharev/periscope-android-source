// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ListView;

// Referenced classes of package o:
//            _cls153E, FE70

public abstract class _cls1D2C
    implements android.view.View.OnTouchListener
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final int _fld1FD3 = ViewConfiguration.getTapTimeout();
    private final if _fld14A3 = new if();
    private final AccelerateInterpolator _fld14A5 = new AccelerateInterpolator();
    private final View _fld14A7;
    private _cls02CA _fld14AA;
    private float _fld14F3[] = {
        0.0F, 0.0F
    };
    private float _fld1604[] = {
        3.402823E+38F, 3.402823E+38F
    };
    private int _fld1D20;
    private int _fld1D30;
    private float _fld1D3B[] = {
        0.0F, 0.0F
    };
    private float _fld1D60[] = {
        0.0F, 0.0F
    };
    private float _fld1D69[] = {
        3.402823E+38F, 3.402823E+38F
    };
    private boolean _fld1E3B;
    private boolean _fld1E5F;
    private boolean _fld1E9B;
    private boolean _fld1EC8;
    private boolean _fld1FD2;

    public _cls1D2C(ListView listview)
    {
        _fld14A7 = listview;
        listview = Resources.getSystem().getDisplayMetrics();
        int i = (int)(((DisplayMetrics) (listview)).density * 1575F + 0.5F);
        int j = (int)(((DisplayMetrics) (listview)).density * 315F + 0.5F);
        float f = i;
        float f1 = i;
        _fld1D69[0] = f / 1000F;
        _fld1D69[1] = f1 / 1000F;
        f = j;
        f1 = j;
        _fld1D60[0] = f / 1000F;
        _fld1D60[1] = f1 / 1000F;
        _fld1D20 = 1;
        _fld1604[0] = 3.402823E+38F;
        _fld1604[1] = 3.402823E+38F;
        _fld14F3[0] = 0.2F;
        _fld14F3[1] = 0.2F;
        _fld1D3B[0] = 0.001F;
        _fld1D3B[1] = 0.001F;
        _fld1D30 = _fld1FD3;
        _fld14A3._fld216C = 500;
        _fld14A3._fld2174 = 500;
    }

    static void _mth02BB(_cls1D2C _pcls1d2c)
    {
        long l = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        _pcls1d2c._fld14A7.onTouchEvent(motionevent);
        motionevent.recycle();
    }

    static View _mth02BC(_cls1D2C _pcls1d2c)
    {
        return _pcls1d2c._fld14A7;
    }

    private float _mth02CA(float f, float f1)
    {
        if (f1 == 0.0F)
        {
            return 0.0F;
        }
        switch (_fld1D20)
        {
        default:
            break;

        case 0: // '\0'
        case 1: // '\001'
            if (f < f1)
            {
                if (f >= 0.0F)
                {
                    return 1.0F - f / f1;
                }
                if (_fld1EC8 && _fld1D20 == 1)
                {
                    return 1.0F;
                }
            }
            break;

        case 2: // '\002'
            if (f < 0.0F)
            {
                return f / -f1;
            }
            break;
        }
        return 0.0F;
    }

    static float _mth02CA(float f, float f1, float f2)
    {
        if (f > 1.0F)
        {
            return 1.0F;
        }
        if (f < 0.0F)
        {
            return 0.0F;
        } else
        {
            return f;
        }
    }

    private float _mth02CA(int i, float f, float f1, float f2)
    {
        float f3 = _mth02CB(_fld14F3[i], f1, _fld1604[i], f);
        if (f3 == 0.0F)
        {
            return 0.0F;
        }
        float f4 = _fld1D3B[i];
        f = _fld1D60[i];
        f1 = _fld1D69[i];
        f2 = f4 * f2;
        if (f3 > 0.0F)
        {
            f2 = f3 * f2;
            if (f2 > f1)
            {
                return f1;
            }
            if (f2 < f)
            {
                return f;
            } else
            {
                return f2;
            }
        }
        f2 = -f3 * f2;
        if (f2 > f1)
        {
            f = f1;
        } else
        if (f2 >= f)
        {
            f = f2;
        }
        return -f;
    }

    static boolean _mth02CA(_cls1D2C _pcls1d2c)
    {
        return _pcls1d2c._fld1EC8;
    }

    static boolean _mth02CA(_cls1D2C _pcls1d2c, boolean flag)
    {
        _pcls1d2c._fld1E5F = false;
        return false;
    }

    private float _mth02CB(float f, float f1, float f2, float f3)
    {
        f *= f1;
        if (f > f2)
        {
            f = f2;
        } else
        if (f < 0.0F)
        {
            f = 0.0F;
        }
        f2 = _mth02CA(f3, f);
        f = _mth02CA(f1 - f3, f) - f2;
        if (f < 0.0F)
        {
            f = -_fld14A5.getInterpolation(-f);
        } else
        if (f > 0.0F)
        {
            f = _fld14A5.getInterpolation(f);
        } else
        {
            return 0.0F;
        }
        if (f > 1.0F)
        {
            return 1.0F;
        }
        if (f < -1F)
        {
            return -1F;
        } else
        {
            return f;
        }
    }

    static boolean _mth02CB(_cls1D2C _pcls1d2c)
    {
        return _pcls1d2c._fld1E5F;
    }

    static boolean _mth02CB(_cls1D2C _pcls1d2c, boolean flag)
    {
        _pcls1d2c._fld1EC8 = false;
        return false;
    }

    static int _mth02CE(int i, int j, int k)
    {
        if (i > k)
        {
            return k;
        }
        if (i < 0)
        {
            return 0;
        } else
        {
            return i;
        }
    }

    static if _mth02CE(_cls1D2C _pcls1d2c)
    {
        return _pcls1d2c._fld14A3;
    }

    static boolean _mth02CE(_cls1D2C _pcls1d2c, boolean flag)
    {
        _pcls1d2c._fld1E9B = false;
        return false;
    }

    static boolean _mth02CF(_cls1D2C _pcls1d2c)
    {
        return _pcls1d2c._mth06E6();
    }

    private boolean _mth06E6()
    {
        if if1 = _fld14A3;
        int i = (int)(if1.FB3A / Math.abs(if1.FB3A));
        int j = (int)(if1._fld30A3 / Math.abs(if1._fld30A3));
        if (i == 0 || !_mth0674(i))
        {
            if (j == 0);
        } else
        {
            return true;
        }
        return false;
    }

    static boolean _mth141D(_cls1D2C _pcls1d2c)
    {
        return _pcls1d2c._fld1E9B;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!_fld1FD2)
        {
            return false;
        }
        switch (_cls153E._mth02CA(motionevent))
        {
        default:
            break;

        case 0: // '\0'
            _fld1E9B = true;
            _fld1E3B = false;
            // fall through

        case 2: // '\002'
            float f = _mth02CA(0, motionevent.getX(), view.getWidth(), _fld14A7.getWidth());
            float f1 = _mth02CA(1, motionevent.getY(), view.getHeight(), _fld14A7.getHeight());
            view = _fld14A3;
            view._fld30A3 = f;
            view.FB3A = f1;
            if (!_fld1EC8 && _mth06E6())
            {
                if (_fld14AA == null)
                {
                    _fld14AA = new _cls02CA((byte)0);
                }
                _fld1EC8 = true;
                _fld1E5F = true;
                if (!_fld1E3B && _fld1D30 > 0)
                {
                    FE70._mth02CA(_fld14A7, _fld14AA, _fld1D30);
                } else
                {
                    _fld14AA.run();
                }
                _fld1E3B = true;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            if (_fld1E5F)
            {
                _fld1EC8 = false;
            } else
            {
                _fld14A3._mth0E40();
            }
            break;
        }
        return false;
    }

    public final _cls1D2C _mth02BD(boolean flag)
    {
        if (_fld1FD2 && !flag)
        {
            if (_fld1E5F)
            {
                _fld1EC8 = false;
            } else
            {
                _fld14A3._mth0E40();
            }
        }
        _fld1FD2 = flag;
        return this;
    }

    public abstract void _mth05D9(int i);

    public abstract boolean _mth0674(int i);

}
