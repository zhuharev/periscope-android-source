// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.Arrays;

// Referenced classes of package o:
//            _cls0157, _cls017F, FB61, _cls153E, 
//            FBE9, arx

public final class _cls0142
{
    /* member class not found */
    class if {}


    private static final _cls0157 _fld026C = new _cls0157();
    private int _fld0107;
    private float _fld0128;
    public float _fld013D;
    private int _fld0167;
    public final if _fld01AC;
    public View _fld0211;
    private boolean _fld021B;
    public final ViewGroup _fld0264;
    public final _cls017F _fld03A4 = new _cls017F(this);
    private int _fld0EC0;
    public VelocityTracker _fld14EF;
    public int _fld157B;
    public int FBA3;
    public FB61 FEAE;
    public float FEB0[];
    public float FEEA[];
    public float FF6F[];
    public float FF7C[];
    public int FF7F[];
    private int FF84[];
    private int FF95[];

    private _cls0142(Context context, ViewGroup viewgroup, if if1)
    {
        _fld157B = -1;
        if (viewgroup == null)
        {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (if1 == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        } else
        {
            _fld0264 = viewgroup;
            _fld01AC = if1;
            viewgroup = ViewConfiguration.get(context);
            _fld0167 = (int)(20F * context.getResources().getDisplayMetrics().density + 0.5F);
            _fld0EC0 = viewgroup.getScaledTouchSlop();
            _fld0128 = viewgroup.getScaledMaximumFlingVelocity();
            _fld013D = viewgroup.getScaledMinimumFlingVelocity();
            FEAE = FB61._mth02CA(context, _fld026C);
            return;
        }
    }

    private static int _mth02BB(int i, int j, int k)
    {
        int l = Math.abs(i);
        if (l < j)
        {
            return 0;
        }
        if (l > k)
        {
            if (i > 0)
            {
                return k;
            } else
            {
                return -k;
            }
        } else
        {
            return i;
        }
    }

    private int _mth02CA(View view, int i, int j, int k, int l)
    {
        k = _mth02BB(k, (int)_fld013D, (int)_fld0128);
        l = _mth02BB(l, (int)_fld013D, (int)_fld0128);
        int i1 = Math.abs(i);
        int j1 = Math.abs(j);
        int k1 = Math.abs(k);
        int l1 = Math.abs(l);
        int i2 = k1 + l1;
        int j2 = i1 + j1;
        float f;
        if (k != 0)
        {
            f = (float)k1 / (float)i2;
        } else
        {
            f = (float)i1 / (float)j2;
        }
        float f1;
        if (l != 0)
        {
            f1 = (float)l1 / (float)i2;
        } else
        {
            f1 = (float)j1 / (float)j2;
        }
        i = _mth141D(i, k, 0);
        j = _mth141D(j, l, _fld01AC._mth06E5(view));
        return (int)((float)i * f + (float)j * f1);
    }

    public static _cls0142 _mth02CA(arx arx, float f, arx._cls02CE _pcls02ce)
    {
        arx = new _cls0142(arx.getContext(), arx, _pcls02ce);
        arx._fld0EC0 = (int)(float)((_cls0142) (arx))._fld0EC0;
        return arx;
    }

    private boolean _mth02CA(float f, float f1, int i, int j)
    {
        f = Math.abs(f);
        f1 = Math.abs(f1);
        if ((FF7F[i] & j) != j || (j & 0) == 0 || (FF95[i] & j) == j || (FF84[i] & j) == j || f <= (float)_fld0EC0 && f1 <= (float)_fld0EC0)
        {
            return false;
        }
        return (FF84[i] & j) == 0 && f > (float)_fld0EC0;
    }

    private static float _mth02CB(float f, float f1, float f2)
    {
        float f3 = Math.abs(f);
        if (f3 < f1)
        {
            return 0.0F;
        }
        if (f3 > f2)
        {
            if (f > 0.0F)
            {
                return f2;
            } else
            {
                return -f2;
            }
        } else
        {
            return f;
        }
    }

    private boolean _mth02CE(int i, int j, int k, int l)
    {
        int i1 = _fld0211.getLeft();
        int j1 = _fld0211.getTop();
        i -= i1;
        j -= j1;
        if (i == 0 && j == 0)
        {
            FEAE.abortAnimation();
            _mth2071(0);
            return false;
        } else
        {
            k = _mth02CA(_fld0211, i, j, k, l);
            FEAE.startScroll(i1, j1, i, j, k);
            _mth2071(2);
            return true;
        }
    }

    private int _mth141D(int i, int j, int k)
    {
        if (i == 0)
        {
            return 0;
        }
        int l = _fld0264.getWidth();
        int i1 = l / 2;
        float f2 = Math.min(1.0F, (float)Math.abs(i) / (float)l);
        float f = i1;
        float f1 = i1;
        f2 = FloatMath.sin((float)((double)(f2 - 0.5F) * 0.4712389167638204D));
        j = Math.abs(j);
        if (j > 0)
        {
            i = Math.round(Math.abs((f + f1 * f2) / (float)j) * 1000F) * 4;
        } else
        {
            i = (int)(((float)Math.abs(i) / (float)k + 1.0F) * 256F);
        }
        return Math.min(i, 600);
    }

    public final void cancel()
    {
        _fld157B = -1;
        if (FEB0 != null)
        {
            Arrays.fill(FEB0, 0.0F);
            Arrays.fill(FEEA, 0.0F);
            Arrays.fill(FF6F, 0.0F);
            Arrays.fill(FF7C, 0.0F);
            Arrays.fill(FF7F, 0);
            Arrays.fill(FF84, 0);
            Arrays.fill(FF95, 0);
            _fld0107 = 0;
        }
        if (_fld14EF != null)
        {
            _fld14EF.recycle();
            _fld14EF = null;
        }
    }

    public void _mth02BB(MotionEvent motionevent)
    {
        int j = _cls153E._mth02CE(motionevent);
        for (int i = 0; i < j; i++)
        {
            int k = _cls153E._mth02CB(motionevent, i);
            float f = _cls153E._mth02CE(motionevent, i);
            float f1 = _cls153E._mth02CF(motionevent, i);
            FF6F[k] = f;
            FF7C[k] = f1;
        }

    }

    public final boolean _mth02BC(int i, int j)
    {
        if (!_fld021B)
        {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else
        {
            return _mth02CE(i, j, (int)FBE9._mth02CA(_fld14EF, _fld157B), (int)FBE9._mth02CB(_fld14EF, _fld157B));
        }
    }

    public final boolean _mth02BD(int i, int j)
    {
        if ((_fld0107 & 1 << j) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return false;
        }
        return Math.abs(FF7C[j] - FEEA[j]) > (float)_fld0EC0;
    }

    public void _mth02CA(float f, float f1, int i)
    {
        if (FEB0 == null || FEB0.length <= i)
        {
            float af[] = new float[i + 1];
            float af2[] = new float[i + 1];
            float af3[] = new float[i + 1];
            float af4[] = new float[i + 1];
            int ai[] = new int[i + 1];
            int ai1[] = new int[i + 1];
            int ai2[] = new int[i + 1];
            if (FEB0 != null)
            {
                System.arraycopy(FEB0, 0, af, 0, FEB0.length);
                System.arraycopy(FEEA, 0, af2, 0, FEEA.length);
                System.arraycopy(FF6F, 0, af3, 0, FF6F.length);
                System.arraycopy(FF7C, 0, af4, 0, FF7C.length);
                System.arraycopy(FF7F, 0, ai, 0, FF7F.length);
                System.arraycopy(FF84, 0, ai1, 0, FF84.length);
                System.arraycopy(FF95, 0, ai2, 0, FF95.length);
            }
            FEB0 = af;
            FEEA = af2;
            FF6F = af3;
            FF7C = af4;
            FF7F = ai;
            FF84 = ai1;
            FF95 = ai2;
        }
        float af1[] = FEB0;
        FF6F[i] = f;
        af1[i] = f;
        af1 = FEEA;
        FF7C[i] = f1;
        af1[i] = f1;
        af1 = FF7F;
        int i1 = (int)f;
        int l = (int)f1;
        int k = 0;
        if (i1 < _fld0264.getLeft() + _fld0167)
        {
            k = 1;
        }
        int j = k;
        if (l < _fld0264.getTop() + _fld0167)
        {
            j = k | 4;
        }
        k = j;
        if (i1 > _fld0264.getRight() - _fld0167)
        {
            k = j | 2;
        }
        j = k;
        if (l > _fld0264.getBottom() - _fld0167)
        {
            j = k | 8;
        }
        af1[i] = j;
        _fld0107 = _fld0107 | 1 << i;
    }

    public boolean _mth02CA(View view, float f, float f1)
    {
        if (view == null)
        {
            return false;
        }
        boolean flag;
        if (_fld01AC._mth06E5(view) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return Math.abs(f1) > (float)_fld0EC0;
        } else
        {
            return false;
        }
    }

    public void _mth02CB(float f, float f1, int i)
    {
        int k = 0;
        if (_mth02CA(f, f1, i, 1))
        {
            k = 1;
        }
        int j = k;
        if (_mth02CA(f1, f, i, 4))
        {
            j = k | 4;
        }
        k = j;
        if (_mth02CA(f, f1, i, 2))
        {
            k = j | 2;
        }
        j = k;
        if (_mth02CA(f1, f, i, 8))
        {
            j = k | 8;
        }
        if (j != 0)
        {
            int ai[] = FF84;
            ai[i] = ai[i] | j;
        }
    }

    public final boolean _mth02CE(View view, int i, int j)
    {
        _fld0211 = view;
        _fld157B = -1;
        boolean flag = _mth02CE(i, j, 0, 0);
        if (!flag && FBA3 == 0 && _fld0211 != null)
        {
            _fld0211 = null;
        }
        return flag;
    }

    public void _mth02CF(float f, float f1)
    {
        _fld021B = true;
        _fld01AC._mth02BE(_fld0211, f1);
        _fld021B = false;
        if (FBA3 == 1)
        {
            _mth2071(0);
        }
    }

    public final void _mth02CF(View view, int i)
    {
        if (view.getParent() != _fld0264)
        {
            throw new IllegalArgumentException((new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (")).append(_fld0264).append(")").toString());
        } else
        {
            _fld0211 = view;
            _fld157B = i;
            _mth2071(1);
            return;
        }
    }

    public final View _mth037A(int i, int j)
    {
        for (int k = _fld0264.getChildCount() - 1; k >= 0; k--)
        {
            View view = _fld0264.getChildAt(_fld01AC.FE7A(k));
            if (i >= view.getLeft() && i < view.getRight() && j >= view.getTop() && j < view.getBottom())
            {
                return view;
            }
        }

        return null;
    }

    public final boolean _mth141D(View view, int i)
    {
        if (view == _fld0211 && _fld157B == i)
        {
            return true;
        }
        if (view != null && _fld01AC._mth1420(view))
        {
            _fld157B = i;
            _mth02CF(view, i);
            return true;
        } else
        {
            return false;
        }
    }

    public void _mth1D62(int i)
    {
        if (FEB0 == null)
        {
            return;
        } else
        {
            FEB0[i] = 0.0F;
            FEEA[i] = 0.0F;
            FF6F[i] = 0.0F;
            FF7C[i] = 0.0F;
            FF7F[i] = 0;
            FF84[i] = 0;
            FF95[i] = 0;
            _fld0107 = _fld0107 & ~(1 << i);
            return;
        }
    }

    final void _mth2071(int i)
    {
        _fld0264.removeCallbacks(_fld03A4);
        if (FBA3 != i)
        {
            FBA3 = i;
            _fld01AC.FE76(i);
            if (FBA3 == 0)
            {
                _fld0211 = null;
            }
        }
    }

    public void FBE8()
    {
        _fld14EF.computeCurrentVelocity(1000, _fld0128);
        _mth02CF(_mth02CB(FBE9._mth02CA(_fld14EF, _fld157B), _fld013D, _fld0128), _mth02CB(FBE9._mth02CB(_fld14EF, _fld157B), _fld013D, _fld0128));
    }

}
