// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import o.05E8;
import o.071D;
import o.0E32;
import o.1425;
import o.1483;
import o.153E;
import o.1D4A;
import o.FB54;
import o.FBE9;
import o.FE70;
import o.FE78;
import o.FEE7;

public class ViewPager extends ViewGroup
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = FE78._mth02CA(new _cls1483());
        int position;
        Parcelable FEAD;
        ClassLoader FF4A;

        public String toString()
        {
            return (new StringBuilder("FragmentPager.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(position).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(position);
            parcel.writeParcelable(FEAD, i);
        }


        public SavedState(Parcel parcel, ClassLoader classloader)
        {
            super(parcel);
            ClassLoader classloader1 = classloader;
            if (classloader == null)
            {
                classloader1 = getClass().getClassLoader();
            }
            position = parcel.readInt();
            FEAD = parcel.readParcelable(classloader1);
            FF4A = classloader1;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    final class aux extends DataSetObserver
    {

        private ViewPager FB27;

        public final void onChanged()
        {
            FB27._mth15EE();
        }

        public final void onInvalidated()
        {
            FB27._mth15EE();
        }

        private aux()
        {
            FB27 = ViewPager.this;
            super();
        }

        aux(byte byte0)
        {
            this();
        }
    }

    static interface if
    {
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


    private static final _cls141D _fld2179 = new _cls141D();
    private static final int FE7D[] = {
        0x10100b3
    };
    private static final _cls071D FE9C = new _cls071D();
    private static final _cls0E32 FEDF = new _cls0E32();
    private boolean mInLayout;
    private final _cls02CA _fld013E;
    private final Rect _fld01C0;
    private FB54 _fld0254;
    public int _fld025F;
    private int _fld027A;
    private Parcelable _fld027C;
    private ClassLoader _fld02B1;
    private Scroller _fld02E0;
    private aux _fld038A;
    private int _fld03F2;
    private Drawable _fld03F3;
    private int _fld0408;
    private int _fld0441;
    private float _fld0442;
    private float _fld0445;
    private int _fld0458;
    private int _fld0491;
    private boolean _fld05DA;
    private boolean _fld05DB;
    private int _fld0621;
    private boolean _fld0631;
    private boolean _fld068E;
    private int _fld068F;
    private int _fld0ABD;
    private int _fld0EC0;
    private VelocityTracker _fld14EF;
    private float _fld14F0;
    private float _fld14F2;
    private float _fld14F5;
    private float _fld153F;
    private int _fld157B;
    private int _fld1D04;
    private int _fld1D10;
    private int _fld1D1B;
    private int _fld1D3A;
    private _cls1D4A _fld1D48;
    private _cls1D4A _fld1D51;
    private boolean _fld1D68;
    private boolean _fld1E2E;
    private boolean _fld1F38;
    private int _fld1F39;
    private _cls02CF _fld1FD8;
    private o._cls1427.if _fld1FD9;
    private Method _fld1FDA;
    private int _fld1FDB;
    private ArrayList _fld2134;
    private final _cls1425 _fld217D;
    private int FB1F;
    private int FE8B;
    private final ArrayList FF89;

    public ViewPager(Context context)
    {
        super(context);
        FF89 = new ArrayList();
        _fld013E = new _cls02CA();
        _fld01C0 = new Rect();
        _fld027A = -1;
        _fld027C = null;
        _fld02B1 = null;
        _fld0442 = -3.402823E+38F;
        _fld0445 = 3.402823E+38F;
        _fld0621 = 1;
        _fld157B = -1;
        _fld1D68 = true;
        _fld1E2E = false;
        _fld217D = new _cls1425(this);
        FB1F = 0;
        _mth1508();
    }

    public ViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        FF89 = new ArrayList();
        _fld013E = new _cls02CA();
        _fld01C0 = new Rect();
        _fld027A = -1;
        _fld027C = null;
        _fld02B1 = null;
        _fld0442 = -3.402823E+38F;
        _fld0445 = 3.402823E+38F;
        _fld0621 = 1;
        _fld157B = -1;
        _fld1D68 = true;
        _fld1E2E = false;
        _fld217D = new _cls1425(this);
        FB1F = 0;
        _mth1508();
    }

    private boolean arrowScroll(int i)
    {
        View view = findFocus();
        Object obj;
        if (view == this)
        {
            obj = null;
        } else
        {
            obj = view;
            if (view != null)
            {
                boolean flag1 = false;
                obj = view.getParent();
                boolean flag;
                do
                {
                    flag = flag1;
                    if (!(obj instanceof ViewGroup))
                    {
                        break;
                    }
                    if (obj == this)
                    {
                        flag = true;
                        break;
                    }
                    obj = ((ViewParent) (obj)).getParent();
                } while (true);
                obj = view;
                if (!flag)
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append(view.getClass().getSimpleName());
                    for (obj = view.getParent(); obj instanceof ViewGroup; obj = ((ViewParent) (obj)).getParent())
                    {
                        stringbuilder.append(" => ").append(obj.getClass().getSimpleName());
                    }

                    Log.e("ViewPager", (new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ")).append(stringbuilder.toString()).toString());
                    obj = null;
                }
            }
        }
        boolean flag2 = false;
        view = FocusFinder.getInstance().findNextFocus(this, ((View) (obj)), i);
        if (view != null && view != obj)
        {
            if (i == 17)
            {
                int j = _mth02CA(_fld01C0, view).left;
                int l = _mth02CA(_fld01C0, ((View) (obj))).left;
                if (obj != null && j >= l)
                {
                    if (_fld025F > 0)
                    {
                        setCurrentItem(_fld025F - 1, true);
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                } else
                {
                    flag2 = view.requestFocus();
                }
            } else
            if (i == 66)
            {
                int k = _mth02CA(_fld01C0, view).left;
                int i1 = _mth02CA(_fld01C0, ((View) (obj))).left;
                if (obj != null && k <= i1)
                {
                    flag2 = _mth1D4B();
                } else
                {
                    flag2 = view.requestFocus();
                }
            }
        } else
        if (i == 17 || i == 1)
        {
            if (_fld025F > 0)
            {
                setCurrentItem(_fld025F - 1, true);
                flag2 = true;
            } else
            {
                flag2 = false;
            }
        } else
        if (i == 66 || i == 2)
        {
            flag2 = _mth1D4B();
        }
        if (flag2)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return flag2;
    }

    private void _mth02BC(boolean flag)
    {
        boolean flag1;
        if (FB1F == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        boolean flag2 = flag1;
        if (flag1)
        {
            if (_fld05DA)
            {
                _fld05DA = false;
            }
            _fld02E0.abortAnimation();
            int i = getScrollX();
            int k = getScrollY();
            int l = _fld02E0.getCurrX();
            int i1 = _fld02E0.getCurrY();
            if (i != l || k != i1)
            {
                scrollTo(l, i1);
                if (l != i)
                {
                    _mth02D1(l);
                }
            }
        }
        _fld05DB = false;
        for (int j = 0; j < FF89.size(); j++)
        {
            _cls02CA _lcls02ca = (_cls02CA)FF89.get(j);
            if (_lcls02ca.FB5D)
            {
                flag2 = true;
                _lcls02ca.FB5D = false;
            }
        }

        if (flag2)
        {
            if (flag)
            {
                FE70._mth02CA(this, _fld217D);
                return;
            }
            _fld217D.run();
        }
    }

    private void _mth02C9(int i)
    {
        if (FB1F == i)
        {
            return;
        }
        FB1F = i;
        if (_fld1FD9 != null)
        {
            boolean flag;
            if (i != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int k = getChildCount();
            for (int j = 0; j < k; j++)
            {
                byte byte0;
                if (flag)
                {
                    byte0 = 2;
                } else
                {
                    byte0 = 0;
                }
                FE70._mth02CA(getChildAt(j), byte0, null);
            }

        }
        if (_fld1FD8 != null)
        {
            _fld1FD8._mth1427(i);
        }
    }

    private Rect _mth02CA(Rect rect, View view)
    {
        Rect rect1 = rect;
        if (rect == null)
        {
            rect1 = new Rect();
        }
        if (view == null)
        {
            rect1.set(0, 0, 0, 0);
            return rect1;
        }
        rect1.left = view.getLeft();
        rect1.right = view.getRight();
        rect1.top = view.getTop();
        rect1.bottom = view.getBottom();
        for (rect = view.getParent(); (rect instanceof ViewGroup) && rect != this; rect = rect.getParent())
        {
            rect = (ViewGroup)rect;
            rect1.left = rect1.left + rect.getLeft();
            rect1.right = rect1.right + rect.getRight();
            rect1.top = rect1.top + rect.getTop();
            rect1.bottom = rect1.bottom + rect.getBottom();
        }

        return rect1;
    }

    static FB54 _mth02CA(ViewPager viewpager)
    {
        return viewpager._fld0254;
    }

    private void _mth02CA(int i, float f, int j)
    {
        if (_fld1F39 > 0)
        {
            int i2 = getScrollX();
            int k = getPaddingLeft();
            int l = getPaddingRight();
            int j2 = getWidth();
            int k2 = getChildCount();
            for (int j1 = 0; j1 < k2;)
            {
                View view = getChildAt(j1);
                _cls02CB _lcls02cb = (_cls02CB)view.getLayoutParams();
                int k1 = k;
                int l1 = l;
                if (_lcls02cb.FE71)
                {
                    int i1;
                    switch (_lcls02cb.gravity & 7)
                    {
                    case 2: // '\002'
                    case 4: // '\004'
                    default:
                        k1 = k;
                        i1 = l;
                        l = k1;
                        break;

                    case 3: // '\003'
                        k1 = k;
                        k += view.getWidth();
                        i1 = l;
                        l = k1;
                        break;

                    case 1: // '\001'
                        k1 = Math.max((j2 - view.getMeasuredWidth()) / 2, k);
                        i1 = l;
                        l = k1;
                        break;

                    case 5: // '\005'
                        i1 = j2 - l - view.getMeasuredWidth();
                        k1 = l + view.getMeasuredWidth();
                        l = i1;
                        i1 = k1;
                        break;
                    }
                    l = (l + i2) - view.getLeft();
                    k1 = k;
                    l1 = i1;
                    if (l != 0)
                    {
                        view.offsetLeftAndRight(l);
                        l1 = i1;
                        k1 = k;
                    }
                }
                j1++;
                k = k1;
                l = l1;
            }

        }
        if (_fld1FD8 != null)
        {
            _fld1FD8._mth02CA(i, f, j);
        }
        if (_fld1FD9 != null)
        {
            getScrollX();
            j = getChildCount();
            for (i = 0; i < j; i++)
            {
                View view1 = getChildAt(i);
                if (!((_cls02CB)view1.getLayoutParams()).FE71)
                {
                    view1.getLeft();
                    getMeasuredWidth();
                    getPaddingLeft();
                    getPaddingRight();
                }
            }

        }
        _fld1F38 = true;
    }

    private void _mth02CA(int i, int j, int k, int l)
    {
        if (j > 0 && !FF89.isEmpty())
        {
            int i1 = getPaddingLeft();
            int j1 = getPaddingRight();
            int k1 = getPaddingLeft();
            int l1 = getPaddingRight();
            j = (int)(((float)getScrollX() / (float)((j - k1 - l1) + l)) * (float)(k + (i - i1 - j1)));
            scrollTo(j, getScrollY());
            if (!_fld02E0.isFinished())
            {
                k = _fld02E0.getDuration();
                l = _fld02E0.timePassed();
                _cls02CA _lcls02ca = _mth02CD(_fld025F);
                _fld02E0.startScroll(j, 0, (int)(_lcls02ca.FB86 * (float)i), 0, k - l);
            }
            return;
        }
        _cls02CA _lcls02ca1 = _mth02CD(_fld025F);
        float f;
        if (_lcls02ca1 != null)
        {
            f = Math.min(_lcls02ca1.FB86, _fld0445);
        } else
        {
            f = 0.0F;
        }
        i = (int)(f * (float)(i - getPaddingLeft() - getPaddingRight()));
        if (i != getScrollX())
        {
            _mth02BC(false);
            scrollTo(i, getScrollY());
        }
    }

    private void _mth02CA(int i, boolean flag, int j, boolean flag1)
    {
        _cls02CA _lcls02ca = _mth02CD(i);
        int k = 0;
        if (_lcls02ca != null)
        {
            k = (int)((float)(getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) * Math.max(_fld0442, Math.min(_lcls02ca.FB86, _fld0445)));
        }
        if (flag)
        {
            _mth02CB(k, 0, j);
            if (flag1)
            {
                if (_fld1FD8 != null)
                {
                    _fld1FD8._mth0640(i);
                }
                return;
            }
        } else
        {
            if (flag1 && _fld1FD8 != null)
            {
                _fld1FD8._mth0640(i);
            }
            _mth02BC(false);
            scrollTo(k, 0);
            _mth02D1(k);
        }
    }

    private void _mth02CA(int i, boolean flag, boolean flag1, int j)
    {
        if (_fld0254 == null || _fld0254.getCount() <= 0)
        {
            if (_fld05DA)
            {
                _fld05DA = false;
            }
            return;
        }
        if (!flag1 && _fld025F == i && FF89.size() != 0)
        {
            if (_fld05DA)
            {
                _fld05DA = false;
            }
            return;
        }
        int k;
        if (i < 0)
        {
            k = 0;
        } else
        {
            k = i;
            if (i >= _fld0254.getCount())
            {
                k = _fld0254.getCount() - 1;
            }
        }
        i = _fld0621;
        if (k > _fld025F + i || k < _fld025F - i)
        {
            for (i = 0; i < FF89.size(); i++)
            {
                ((_cls02CA)FF89.get(i)).FB5D = true;
            }

        }
        if (_fld025F != k)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (_fld1D68)
        {
            _fld025F = k;
            if (flag1 && _fld1FD8 != null)
            {
                _fld1FD8._mth0640(k);
            }
            requestLayout();
            return;
        } else
        {
            _mth02CC(k);
            _mth02CA(k, flag, j, flag1);
            return;
        }
    }

    private void _mth02CA(_cls02CA _pcls02ca, int i, _cls02CA _pcls02ca1)
    {
        int j2 = _fld0254.getCount();
        int j = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        float f3;
        if (j > 0)
        {
            f3 = (float)_fld03F2 / (float)j;
        } else
        {
            f3 = 0.0F;
        }
        if (_pcls02ca1 != null)
        {
            j = _pcls02ca1.position;
            if (j < _pcls02ca.position)
            {
                int l = 0;
                float f = _pcls02ca1.FB86 + _pcls02ca1.FB65 + f3;
                int k1;
                for (j++; j <= _pcls02ca.position && l < FF89.size(); j = k1 + 1)
                {
                    _pcls02ca1 = (_cls02CA)FF89.get(l);
                    float f4;
                    do
                    {
                        f4 = f;
                        k1 = j;
                        if (j <= _pcls02ca1.position)
                        {
                            break;
                        }
                        f4 = f;
                        k1 = j;
                        if (l >= FF89.size() - 1)
                        {
                            break;
                        }
                        l++;
                        _pcls02ca1 = (_cls02CA)FF89.get(l);
                    } while (true);
                    for (; k1 < _pcls02ca1.position; k1++)
                    {
                        f4 += 1.0F + f3;
                    }

                    _pcls02ca1.FB86 = f4;
                    f = f4 + (_pcls02ca1.FB65 + f3);
                }

            } else
            if (j > _pcls02ca.position)
            {
                int i1 = FF89.size() - 1;
                float f1 = _pcls02ca1.FB86;
                int l1;
                for (j--; j >= _pcls02ca.position && i1 >= 0; j = l1 - 1)
                {
                    _pcls02ca1 = (_cls02CA)FF89.get(i1);
                    float f5;
                    do
                    {
                        f5 = f1;
                        l1 = j;
                        if (j >= _pcls02ca1.position)
                        {
                            break;
                        }
                        f5 = f1;
                        l1 = j;
                        if (i1 <= 0)
                        {
                            break;
                        }
                        i1--;
                        _pcls02ca1 = (_cls02CA)FF89.get(i1);
                    } while (true);
                    for (; l1 > _pcls02ca1.position; l1--)
                    {
                        f5 -= 1.0F + f3;
                    }

                    f1 = f5 - (_pcls02ca1.FB65 + f3);
                    _pcls02ca1.FB86 = f1;
                }

            }
        }
        int i2 = FF89.size();
        float f6 = _pcls02ca.FB86;
        j = _pcls02ca.position - 1;
        float f2;
        if (_pcls02ca.position == 0)
        {
            f2 = _pcls02ca.FB86;
        } else
        {
            f2 = -3.402823E+38F;
        }
        _fld0442 = f2;
        if (_pcls02ca.position == j2 - 1)
        {
            f2 = (_pcls02ca.FB86 + _pcls02ca.FB65) - 1.0F;
        } else
        {
            f2 = 3.402823E+38F;
        }
        _fld0445 = f2;
        int j1 = i - 1;
        f2 = f6;
        while (j1 >= 0) 
        {
            for (_pcls02ca1 = (_cls02CA)FF89.get(j1); j > _pcls02ca1.position;)
            {
                j--;
                f2 -= 1.0F + f3;
            }

            f2 -= _pcls02ca1.FB65 + f3;
            _pcls02ca1.FB86 = f2;
            if (_pcls02ca1.position == 0)
            {
                _fld0442 = f2;
            }
            j1--;
            j--;
        }
        f2 = _pcls02ca.FB86 + _pcls02ca.FB65 + f3;
        j = _pcls02ca.position + 1;
        j1 = i + 1;
        i = j;
        for (int k = j1; k < i2;)
        {
            for (_pcls02ca = (_cls02CA)FF89.get(k); i < _pcls02ca.position;)
            {
                i++;
                f2 += 1.0F + f3;
            }

            if (_pcls02ca.position == j2 - 1)
            {
                _fld0445 = (_pcls02ca.FB65 + f2) - 1.0F;
            }
            _pcls02ca.FB86 = f2;
            f2 += _pcls02ca.FB65 + f3;
            k++;
            i++;
        }

        _fld1E2E = false;
    }

    static int _mth02CB(ViewPager viewpager)
    {
        return viewpager._fld025F;
    }

    private void _mth02CB(int i, int j, int k)
    {
        if (getChildCount() == 0)
        {
            if (_fld05DA)
            {
                _fld05DA = false;
            }
            return;
        }
        j = getScrollX();
        int l = getScrollY();
        int i1 = i - j;
        int j1 = 0 - l;
        if (i1 == 0 && j1 == 0)
        {
            _mth02BC(false);
            _mth02CC(_fld025F);
            _mth02C9(0);
            return;
        }
        if (!_fld05DA)
        {
            _fld05DA = true;
        }
        _mth02C9(2);
        i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int k1 = i / 2;
        float f3 = Math.min(1.0F, ((float)Math.abs(i1) * 1.0F) / (float)i);
        float f = k1;
        float f2 = k1;
        f3 = FloatMath.sin((float)((double)(f3 - 0.5F) * 0.4712389167638204D));
        k = Math.abs(k);
        if (k > 0)
        {
            i = Math.round(Math.abs((f + f2 * f3) / (float)k) * 1000F) * 4;
        } else
        {
            float f1 = i;
            i = (int)(((float)Math.abs(i1) / ((float)_fld03F2 + f1) + 1.0F) * 100F);
        }
        i = Math.min(i, 600);
        _fld02E0.startScroll(j, l, i1, j1, i);
        FE70._mth1FBE(this);
    }

    public static void _mth02CB(ViewPager viewpager, int i)
    {
        viewpager._mth02C9(0);
    }

    private boolean _mth02CB(float f)
    {
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag2 = false;
        float f1 = _fld14F0;
        _fld14F0 = f;
        float f2 = (float)getScrollX() + (f1 - f);
        int i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        f = (float)i * _fld0442;
        f1 = (float)i * _fld0445;
        boolean flag = true;
        boolean flag1 = true;
        _cls02CA _lcls02ca = (_cls02CA)FF89.get(0);
        _cls02CA _lcls02ca1 = (_cls02CA)FF89.get(FF89.size() - 1);
        if (_lcls02ca.position != 0)
        {
            flag = false;
            f = _lcls02ca.FB86 * (float)i;
        }
        if (_lcls02ca1.position != _fld0254.getCount() - 1)
        {
            flag1 = false;
            f1 = _lcls02ca1.FB86 * (float)i;
        }
        if (f2 < f)
        {
            if (flag)
            {
                flag2 = _fld1D48._mth02BC(Math.abs(f - f2) / (float)i);
            }
        } else
        {
            flag2 = flag4;
            f = f2;
            if (f2 > f1)
            {
                flag2 = flag3;
                if (flag1)
                {
                    flag2 = _fld1D51._mth02BC(Math.abs(f2 - f1) / (float)i);
                }
                f = f1;
            }
        }
        _fld14F0 = _fld14F0 + (f - (float)(int)f);
        scrollTo((int)f, getScrollY());
        _mth02D1((int)f);
        return flag2;
    }

    private _cls02CA _mth02CD(int i)
    {
        for (int j = 0; j < FF89.size(); j++)
        {
            _cls02CA _lcls02ca = (_cls02CA)FF89.get(j);
            if (_lcls02ca.position == i)
            {
                return _lcls02ca;
            }
        }

        return null;
    }

    private _cls02CA _mth02CF(int i, int j)
    {
        _cls02CA _lcls02ca = new _cls02CA();
        _lcls02ca.position = i;
        _lcls02ca.FB33 = _fld0254._mth02CA(this, i);
        _lcls02ca.FB65 = 1.0F;
        if (j < 0 || j >= FF89.size())
        {
            FF89.add(_lcls02ca);
            return _lcls02ca;
        } else
        {
            FF89.add(j, _lcls02ca);
            return _lcls02ca;
        }
    }

    private boolean _mth02D1(int i)
    {
        if (FF89.size() == 0)
        {
            _fld1F38 = false;
            _mth02CA(0, 0.0F, 0);
            if (!_fld1F38)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            } else
            {
                return false;
            }
        }
        _cls02CA _lcls02ca = _mth1D40();
        int k = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int l = _fld03F2;
        float f = (float)_fld03F2 / (float)k;
        int j = _lcls02ca.position;
        f = ((float)i / (float)k - _lcls02ca.FB86) / (_lcls02ca.FB65 + f);
        i = (int)(f * (float)(k + l));
        _fld1F38 = false;
        _mth02CA(j, f, i);
        if (!_fld1F38)
        {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else
        {
            return true;
        }
    }

    private void _mth141D(MotionEvent motionevent)
    {
        int i = _cls153E._mth02CB(motionevent);
        if (_cls153E._mth02CB(motionevent, i) == _fld157B)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            _fld14F0 = _cls153E._mth02CE(motionevent, i);
            _fld157B = _cls153E._mth02CB(motionevent, i);
            if (_fld14EF != null)
            {
                _fld14EF.clear();
            }
        }
    }

    private void _mth1508()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        _fld02E0 = new Scroller(context, FEDF);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        _fld0EC0 = _cls05E8._mth02CA(viewconfiguration);
        _fld1D04 = (int)(400F * f);
        _fld1D10 = viewconfiguration.getScaledMaximumFlingVelocity();
        _fld1D48 = new _cls1D4A(context);
        _fld1D51 = new _cls1D4A(context);
        _fld1D1B = (int)(25F * f);
        _fld1D3A = (int)(2.0F * f);
        _fld068F = (int)(16F * f);
        FE70._mth02CA(this, new _cls02CE());
        if (FE70._mth02BE(this) == 0)
        {
            FE70._mth02CE(this, 1);
        }
    }

    private void _mth1D38()
    {
        if (_fld1FDB != 0)
        {
            if (_fld2134 == null)
            {
                _fld2134 = new ArrayList();
            } else
            {
                _fld2134.clear();
            }
            int j = getChildCount();
            for (int i = 0; i < j; i++)
            {
                View view = getChildAt(i);
                _fld2134.add(view);
            }

            Collections.sort(_fld2134, _fld2179);
        }
    }

    private _cls02CA _mth1D40()
    {
        int i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        float f;
        if (i > 0)
        {
            f = (float)getScrollX() / (float)i;
        } else
        {
            f = 0.0F;
        }
        float f1;
        if (i > 0)
        {
            f1 = (float)_fld03F2 / (float)i;
        } else
        {
            f1 = 0.0F;
        }
        int k = -1;
        float f2 = 0.0F;
        float f3 = 0.0F;
        boolean flag = true;
        _cls02CA _lcls02ca1 = null;
        for (int j = 0; j < FF89.size();)
        {
            _cls02CA _lcls02ca2 = (_cls02CA)FF89.get(j);
            int l = j;
            _cls02CA _lcls02ca = _lcls02ca2;
            if (!flag)
            {
                l = j;
                _lcls02ca = _lcls02ca2;
                if (_lcls02ca2.position != k + 1)
                {
                    _lcls02ca = _fld013E;
                    _lcls02ca.FB86 = f2 + f3 + f1;
                    _lcls02ca.position = k + 1;
                    _lcls02ca.FB65 = 1.0F;
                    l = j - 1;
                }
            }
            f3 = _lcls02ca.FB86;
            f2 = f3;
            float f4 = _lcls02ca.FB65;
            if (flag || f >= f3)
            {
                if (f < f4 + f2 + f1 || l == FF89.size() - 1)
                {
                    return _lcls02ca;
                }
            } else
            {
                return _lcls02ca1;
            }
            flag = false;
            k = _lcls02ca.position;
            f3 = _lcls02ca.FB65;
            j = l + 1;
            _lcls02ca1 = _lcls02ca;
        }

        return _lcls02ca1;
    }

    private boolean _mth1D4B()
    {
        if (_fld0254 != null && _fld025F < _fld0254.getCount() - 1)
        {
            setCurrentItem(_fld025F + 1, true);
            return true;
        } else
        {
            return false;
        }
    }

    static int[] _mth1D57()
    {
        return FE7D;
    }

    private _cls02CA _mth2071(View view)
    {
        for (int i = 0; i < FF89.size(); i++)
        {
            _cls02CA _lcls02ca = (_cls02CA)FF89.get(i);
            if (_fld0254._mth02CB(view, _lcls02ca.FB33))
            {
                return _lcls02ca;
            }
        }

        return null;
    }

    private _cls02CA FE76(View view)
    {
        do
        {
            ViewParent viewparent = view.getParent();
            if (viewparent != this)
            {
                if (viewparent == null || !(viewparent instanceof View))
                {
                    return null;
                }
                view = (View)viewparent;
            } else
            {
                return _mth2071(view);
            }
        } while (true);
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        int l = arraylist.size();
        int i1 = getDescendantFocusability();
        if (i1 != 0x60000)
        {
            for (int k = 0; k < getChildCount(); k++)
            {
                View view = getChildAt(k);
                if (view.getVisibility() != 0)
                {
                    continue;
                }
                _cls02CA _lcls02ca = _mth2071(view);
                if (_lcls02ca != null && _lcls02ca.position == _fld025F)
                {
                    view.addFocusables(arraylist, i, j);
                }
            }

        }
        if (i1 != 0x40000 || l == arraylist.size())
        {
            if (!isFocusable())
            {
                return;
            }
            if ((j & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode())
            {
                return;
            }
            if (arraylist != null)
            {
                arraylist.add(this);
            }
        }
    }

    public void addTouchables(ArrayList arraylist)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            _cls02CA _lcls02ca = _mth2071(view);
            if (_lcls02ca != null && _lcls02ca.position == _fld025F)
            {
                view.addTouchables(arraylist);
            }
        }

    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = layoutparams;
        if (!checkLayoutParams(layoutparams))
        {
            layoutparams1 = generateLayoutParams(layoutparams);
        }
        layoutparams = (_cls02CB)layoutparams1;
        layoutparams.FE71 = ((_cls02CB) (layoutparams)).FE71 | (view instanceof if);
        if (mInLayout)
        {
            if (layoutparams != null && ((_cls02CB) (layoutparams)).FE71)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                layoutparams.FE80 = true;
                addViewInLayout(view, i, layoutparams1);
                return;
            }
        } else
        {
            super.addView(view, i, layoutparams1);
            return;
        }
    }

    public boolean canScrollHorizontally(int i)
    {
        if (_fld0254 == null)
        {
            return false;
        }
        int j = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int k = getScrollX();
        if (i < 0)
        {
            return k > (int)((float)j * _fld0442);
        }
        if (i > 0)
        {
            return k < (int)((float)j * _fld0445);
        } else
        {
            return false;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof _cls02CB) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!_fld02E0.isFinished() && _fld02E0.computeScrollOffset())
        {
            int i = getScrollX();
            int j = getScrollY();
            int k = _fld02E0.getCurrX();
            int l = _fld02E0.getCurrY();
            if (i != k || j != l)
            {
                scrollTo(k, l);
                if (!_mth02D1(k))
                {
                    _fld02E0.abortAnimation();
                    scrollTo(0, l);
                }
            }
            FE70._mth1FBE(this);
            return;
        } else
        {
            _mth02BC(true);
            return;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
label0:
        {
            if (!super.dispatchKeyEvent(keyevent))
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (keyevent.getAction() == 0)
                {
                    switch (keyevent.getKeyCode())
                    {
                    default:
                        flag = flag1;
                        break;

                    case 21: // '\025'
                        flag = arrowScroll(17);
                        break;

                    case 22: // '\026'
                        flag = arrowScroll(66);
                        break;

                    case 61: // '='
                        flag = flag1;
                        if (android.os.Build.VERSION.SDK_INT < 11)
                        {
                            break;
                        }
                        if (FEE7._mth02CA(keyevent))
                        {
                            flag = arrowScroll(2);
                            break;
                        }
                        flag = flag1;
                        if (FEE7._mth02CA(keyevent, 1))
                        {
                            flag = arrowScroll(1);
                        }
                        break;
                    }
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        if (accessibilityevent.getEventType() == 4096)
        {
            return super.dispatchPopulateAccessibilityEvent(accessibilityevent);
        }
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            _cls02CA _lcls02ca = _mth2071(view);
            if (_lcls02ca != null && _lcls02ca.position == _fld025F && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
            {
                return true;
            }
        }

        return false;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int j = 0;
        int i = 0;
        int k = FE70._mth02BC(this);
        if (k == 0 || k == 1 && _fld0254 != null && _fld0254.getCount() > 1)
        {
            if (!_fld1D48.isFinished())
            {
                j = canvas.save();
                i = getHeight() - getPaddingTop() - getPaddingBottom();
                int l = getWidth();
                canvas.rotate(270F);
                canvas.translate(-i + getPaddingTop(), _fld0442 * (float)l);
                _fld1D48.setSize(i, l);
                i = _fld1D48.draw(canvas) | false;
                canvas.restoreToCount(j);
            }
            j = i;
            if (!_fld1D51.isFinished())
            {
                int i1 = canvas.save();
                j = getWidth();
                int j1 = getHeight();
                int k1 = getPaddingTop();
                int l1 = getPaddingBottom();
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -(_fld0445 + 1.0F) * (float)j);
                _fld1D51.setSize(j1 - k1 - l1, j);
                j = i | _fld1D51.draw(canvas);
                canvas.restoreToCount(i1);
            }
        } else
        {
            _fld1D48.finish();
            _fld1D51.finish();
        }
        if (j != 0)
        {
            FE70._mth1FBE(this);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = _fld03F3;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new _cls02CB();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new _cls02CB(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    protected int getChildDrawingOrder(int i, int j)
    {
        if (_fld1FDB == 2)
        {
            j = i - 1 - j;
        }
        return ((_cls02CB)((View)_fld2134.get(j)).getLayoutParams()).FEAA;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        _fld1D68 = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(_fld217D);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (_fld03F2 > 0 && _fld03F3 != null && FF89.size() > 0 && _fld0254 != null)
        {
            int k = getScrollX();
            int l = getWidth();
            float f2 = (float)_fld03F2 / (float)l;
            int j = 0;
            Object obj = (_cls02CA)FF89.get(0);
            float f = ((_cls02CA) (obj)).FB86;
            int i1 = FF89.size();
            int i = ((_cls02CA) (obj)).position;
            int j1 = ((_cls02CA)FF89.get(i1 - 1)).position;
            do
            {
                if (i >= j1)
                {
                    break;
                }
                for (; i > ((_cls02CA) (obj)).position && j < i1; obj = (_cls02CA)((ArrayList) (obj)).get(j))
                {
                    obj = FF89;
                    j++;
                }

                float f1;
                if (i == ((_cls02CA) (obj)).position)
                {
                    f1 = (((_cls02CA) (obj)).FB86 + ((_cls02CA) (obj)).FB65) * (float)l;
                    f = ((_cls02CA) (obj)).FB86 + ((_cls02CA) (obj)).FB65 + f2;
                } else
                {
                    f1 = (1.0F + f) * (float)l;
                    f += 1.0F + f2;
                }
                if ((float)_fld03F2 + f1 > (float)k)
                {
                    _fld03F3.setBounds((int)f1, _fld0408, (int)((float)_fld03F2 + f1 + 0.5F), _fld0441);
                    _fld03F3.draw(canvas);
                }
                if (f1 > (float)(k + l))
                {
                    break;
                }
                i++;
            } while (true);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction() & 0xff;
        if (i == 3 || i == 1)
        {
            _fld157B = -1;
            _fld0631 = false;
            _fld068E = false;
            if (_fld14EF != null)
            {
                _fld14EF.recycle();
                _fld14EF = null;
            }
            _fld1D48._mth13A5();
            _fld1D51._mth13A5();
            return false;
        }
        if (i != 0)
        {
            if (_fld0631)
            {
                return true;
            }
            if (_fld068E)
            {
                return false;
            }
        }
        switch (i)
        {
        case 2: // '\002'
            int j = _fld157B;
            if (j != -1)
            {
                j = _cls153E._mth02CA(motionevent, j);
                float f2 = _cls153E._mth02CE(motionevent, j);
                float f = f2 - _fld14F0;
                float f4 = Math.abs(f);
                float f3 = _cls153E._mth02CF(motionevent, j);
                float f5 = Math.abs(f3 - _fld153F);
                if (f != 0.0F)
                {
                    float f6 = _fld14F0;
                    boolean flag;
                    if (f6 < (float)_fld0ABD && f > 0.0F || f6 > (float)(getWidth() - _fld0ABD) && f < 0.0F)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag && _mth02CA(this, false, (int)f, (int)f2, (int)f3))
                    {
                        _fld14F0 = f2;
                        _fld14F2 = f3;
                        _fld068E = true;
                        return false;
                    }
                }
                if (f4 > (float)_fld0EC0 && 0.5F * f4 > f5)
                {
                    _fld0631 = true;
                    ViewParent viewparent = getParent();
                    if (viewparent != null)
                    {
                        viewparent.requestDisallowInterceptTouchEvent(true);
                    }
                    _mth02C9(1);
                    if (f > 0.0F)
                    {
                        f = _fld14F5 + (float)_fld0EC0;
                    } else
                    {
                        f = _fld14F5 - (float)_fld0EC0;
                    }
                    _fld14F0 = f;
                    _fld14F2 = f3;
                    if (!_fld05DA)
                    {
                        _fld05DA = true;
                    }
                } else
                if (f5 > (float)_fld0EC0)
                {
                    _fld068E = true;
                }
                if (_fld0631 && _mth02CB(f2))
                {
                    FE70._mth1FBE(this);
                }
            }
            break;

        case 0: // '\0'
            float f1 = motionevent.getX();
            _fld14F5 = f1;
            _fld14F0 = f1;
            f1 = motionevent.getY();
            _fld153F = f1;
            _fld14F2 = f1;
            _fld157B = _cls153E._mth02CB(motionevent, 0);
            _fld068E = false;
            _fld02E0.computeScrollOffset();
            if (FB1F == 2 && Math.abs(_fld02E0.getFinalX() - _fld02E0.getCurrX()) > _fld1D3A)
            {
                _fld02E0.abortAnimation();
                _fld05DB = false;
                _mth02CC(_fld025F);
                _fld0631 = true;
                ViewParent viewparent1 = getParent();
                if (viewparent1 != null)
                {
                    viewparent1.requestDisallowInterceptTouchEvent(true);
                }
                _mth02C9(1);
            } else
            {
                _mth02BC(false);
                _fld0631 = false;
            }
            break;

        case 6: // '\006'
            _mth141D(motionevent);
            break;
        }
        if (_fld14EF == null)
        {
            _fld14EF = VelocityTracker.obtain();
        }
        _fld14EF.addMovement(motionevent);
        return _fld0631;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i3 = getChildCount();
        int k3 = k - i;
        int j3 = l - j;
        j = getPaddingLeft();
        i = getPaddingTop();
        int i1 = getPaddingRight();
        l = getPaddingBottom();
        int l3 = getScrollX();
        int l1 = 0;
        for (int i2 = 0; i2 < i3;)
        {
            View view = getChildAt(i2);
            int l2 = i1;
            int k2 = l;
            int j2 = l1;
            int j1 = j;
            k = i;
            if (view.getVisibility() != 8)
            {
                _cls02CB _lcls02cb = (_cls02CB)view.getLayoutParams();
                l2 = i1;
                k2 = l;
                j2 = l1;
                j1 = j;
                k = i;
                if (_lcls02cb.FE71)
                {
                    k = _lcls02cb.gravity;
                    j2 = _lcls02cb.gravity;
                    switch (k & 7)
                    {
                    case 2: // '\002'
                    case 4: // '\004'
                    default:
                        k = j;
                        j1 = j;
                        break;

                    case 3: // '\003'
                        k = j;
                        j1 = j + view.getMeasuredWidth();
                        break;

                    case 1: // '\001'
                        k = Math.max((k3 - view.getMeasuredWidth()) / 2, j);
                        j1 = j;
                        break;

                    case 5: // '\005'
                        k = k3 - i1 - view.getMeasuredWidth();
                        i1 += view.getMeasuredWidth();
                        j1 = j;
                        break;
                    }
                    switch (j2 & 0x70)
                    {
                    default:
                        j = i;
                        break;

                    case 48: // '0'
                        j = i;
                        i += view.getMeasuredHeight();
                        break;

                    case 16: // '\020'
                        j = Math.max((j3 - view.getMeasuredHeight()) / 2, i);
                        break;

                    case 80: // 'P'
                        j = j3 - l - view.getMeasuredHeight();
                        l += view.getMeasuredHeight();
                        break;
                    }
                    k += l3;
                    view.layout(k, j, view.getMeasuredWidth() + k, view.getMeasuredHeight() + j);
                    j2 = l1 + 1;
                    k = i;
                    k2 = l;
                    l2 = i1;
                }
            }
            i2++;
            i1 = l2;
            l = k2;
            l1 = j2;
            j = j1;
            i = k;
        }

        i1 = k3 - j - i1;
        for (k = 0; k < i3; k++)
        {
            View view1 = getChildAt(k);
            if (view1.getVisibility() == 8)
            {
                continue;
            }
            _cls02CB _lcls02cb1 = (_cls02CB)view1.getLayoutParams();
            if (_lcls02cb1.FE71)
            {
                continue;
            }
            _cls02CA _lcls02ca = _mth2071(view1);
            if (_lcls02ca == null)
            {
                continue;
            }
            int k1 = j + (int)((float)i1 * _lcls02ca.FB86);
            if (_lcls02cb1.FE80)
            {
                _lcls02cb1.FE80 = false;
                view1.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)i1 * _lcls02cb1.FB65), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j3 - i - l, 0x40000000));
            }
            view1.layout(k1, i, view1.getMeasuredWidth() + k1, view1.getMeasuredHeight() + i);
        }

        _fld0408 = i;
        _fld0441 = j3 - l;
        _fld1F39 = l1;
        if (_fld1D68)
        {
            _mth02CA(_fld025F, false, 0, false);
        }
        _fld1D68 = false;
    }

    protected void onMeasure(int i, int j)
    {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, j));
        i = getMeasuredWidth();
        _fld0ABD = Math.min(i / 10, _fld068F);
        i = i - getPaddingLeft() - getPaddingRight();
        j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int i3 = getChildCount();
        for (int j1 = 0; j1 < i3;)
        {
            View view = getChildAt(j1);
            int k = i;
            int i1 = j;
            if (view.getVisibility() != 8)
            {
                _cls02CB _lcls02cb = (_cls02CB)view.getLayoutParams();
                k = i;
                i1 = j;
                if (_lcls02cb != null)
                {
                    k = i;
                    i1 = j;
                    if (_lcls02cb.FE71)
                    {
                        i1 = _lcls02cb.gravity & 7;
                        int k1 = _lcls02cb.gravity & 0x70;
                        int l1 = 0x80000000;
                        k = 0x80000000;
                        boolean flag;
                        if (k1 == 48 || k1 == 80)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        boolean flag1;
                        if (i1 == 3 || i1 == 5)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag)
                        {
                            i1 = 0x40000000;
                        } else
                        {
                            i1 = l1;
                            if (flag1)
                            {
                                k = 0x40000000;
                                i1 = l1;
                            }
                        }
                        int j2 = i;
                        l1 = j;
                        int i2 = j2;
                        if (_lcls02cb.width != -2)
                        {
                            int k2 = 0x40000000;
                            i1 = k2;
                            i2 = j2;
                            if (_lcls02cb.width != -1)
                            {
                                i2 = _lcls02cb.width;
                                i1 = k2;
                            }
                        }
                        j2 = l1;
                        if (_lcls02cb.height != -2)
                        {
                            int l2 = 0x40000000;
                            k = l2;
                            j2 = l1;
                            if (_lcls02cb.height != -1)
                            {
                                j2 = _lcls02cb.height;
                                k = l2;
                            }
                        }
                        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i2, i1), android.view.View.MeasureSpec.makeMeasureSpec(j2, k));
                        if (flag)
                        {
                            i1 = j - view.getMeasuredHeight();
                            k = i;
                        } else
                        {
                            k = i;
                            i1 = j;
                            if (flag1)
                            {
                                k = i - view.getMeasuredWidth();
                                i1 = j;
                            }
                        }
                    }
                }
            }
            j1++;
            i = k;
            j = i1;
        }

        _fld0458 = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        _fld0491 = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
        mInLayout = true;
        _mth02CC(_fld025F);
        mInLayout = false;
        int l = getChildCount();
        for (j = 0; j < l; j++)
        {
            View view1 = getChildAt(j);
            if (view1.getVisibility() == 8)
            {
                continue;
            }
            _cls02CB _lcls02cb1 = (_cls02CB)view1.getLayoutParams();
            if (_lcls02cb1 == null || !_lcls02cb1.FE71)
            {
                view1.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)i * _lcls02cb1.FB65), 0x40000000), _fld0491);
            }
        }

    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        int k = getChildCount();
        int j;
        byte byte0;
        if ((i & 2) != 0)
        {
            j = 0;
            byte0 = 1;
        } else
        {
            j = k - 1;
            byte0 = -1;
            k = -1;
        }
        for (; j != k; j += byte0)
        {
            View view = getChildAt(j);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            _cls02CA _lcls02ca = _mth2071(view);
            if (_lcls02ca != null && _lcls02ca.position == _fld025F && view.requestFocus(i, rect))
            {
                return true;
            }
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        if (_fld0254 != null)
        {
            _mth02CA(((SavedState) (parcelable)).position, false, true, 0);
            return;
        } else
        {
            _fld027A = ((SavedState) (parcelable)).position;
            _fld027C = ((SavedState) (parcelable)).FEAD;
            _fld02B1 = ((SavedState) (parcelable)).FF4A;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.position = _fld025F;
        if (_fld0254 != null)
        {
            savedstate.FEAD = null;
        }
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k)
        {
            _mth02CA(i, k, _fld03F2, _fld03F2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (_fld0254 == null || _fld0254.getCount() == 0)
        {
            return false;
        }
        if (_fld14EF == null)
        {
            _fld14EF = VelocityTracker.obtain();
        }
        _fld14EF.addMovement(motionevent);
        int k = motionevent.getAction();
        int j = 0;
        int i = j;
        switch (k & 0xff)
        {
        default:
            i = j;
            break;

        case 4: // '\004'
            break;

        case 0: // '\0'
            _fld02E0.abortAnimation();
            _fld05DB = false;
            _mth02CC(_fld025F);
            float f = motionevent.getX();
            _fld14F5 = f;
            _fld14F0 = f;
            f = motionevent.getY();
            _fld153F = f;
            _fld14F2 = f;
            _fld157B = _cls153E._mth02CB(motionevent, 0);
            i = j;
            break;

        case 2: // '\002'
            if (!_fld0631)
            {
                i = _cls153E._mth02CA(motionevent, _fld157B);
                if (i == -1)
                {
                    _fld157B = -1;
                    _fld0631 = false;
                    _fld068E = false;
                    if (_fld14EF != null)
                    {
                        _fld14EF.recycle();
                        _fld14EF = null;
                    }
                    i = _fld1D48._mth13A5() | _fld1D51._mth13A5();
                    break;
                }
                float f1 = _cls153E._mth02CE(motionevent, i);
                float f5 = Math.abs(f1 - _fld14F0);
                float f3 = _cls153E._mth02CF(motionevent, i);
                float f6 = Math.abs(f3 - _fld14F2);
                if (f5 > (float)_fld0EC0 && f5 > f6)
                {
                    _fld0631 = true;
                    ViewParent viewparent = getParent();
                    if (viewparent != null)
                    {
                        viewparent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (f1 - _fld14F5 > 0.0F)
                    {
                        f1 = _fld14F5 + (float)_fld0EC0;
                    } else
                    {
                        f1 = _fld14F5 - (float)_fld0EC0;
                    }
                    _fld14F0 = f1;
                    _fld14F2 = f3;
                    _mth02C9(1);
                    if (!_fld05DA)
                    {
                        _fld05DA = true;
                    }
                    viewparent = getParent();
                    if (viewparent != null)
                    {
                        viewparent.requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            i = j;
            if (_fld0631)
            {
                i = _mth02CB(_cls153E._mth02CE(motionevent, _cls153E._mth02CA(motionevent, _fld157B))) | false;
            }
            break;

        case 1: // '\001'
            i = j;
            if (_fld0631)
            {
                Object obj = _fld14EF;
                ((VelocityTracker) (obj)).computeCurrentVelocity(1000, _fld1D10);
                int l = (int)FBE9._mth02CA(((VelocityTracker) (obj)), _fld157B);
                _fld05DB = true;
                j = getMeasuredWidth();
                int i1 = getPaddingLeft();
                int j1 = getPaddingRight();
                int k1 = getScrollX();
                obj = _mth1D40();
                i = ((_cls02CA) (obj)).position;
                float f4 = ((float)k1 / (float)(j - i1 - j1) - ((_cls02CA) (obj)).FB86) / ((_cls02CA) (obj)).FB65;
                if (Math.abs((int)(_cls153E._mth02CE(motionevent, _cls153E._mth02CA(motionevent, _fld157B)) - _fld14F5)) > _fld1D1B && Math.abs(l) > _fld1D04)
                {
                    if (l <= 0)
                    {
                        i++;
                    }
                } else
                {
                    float f2;
                    if (i >= _fld025F)
                    {
                        f2 = 0.4F;
                    } else
                    {
                        f2 = 0.6F;
                    }
                    i = (int)((float)i + f4 + f2);
                }
                j = i;
                if (FF89.size() > 0)
                {
                    motionevent = (_cls02CA)FF89.get(0);
                    _cls02CA _lcls02ca = (_cls02CA)FF89.get(FF89.size() - 1);
                    j = Math.max(((_cls02CA) (motionevent)).position, Math.min(i, _lcls02ca.position));
                }
                _mth02CA(j, true, true, l);
                _fld157B = -1;
                _fld0631 = false;
                _fld068E = false;
                if (_fld14EF != null)
                {
                    _fld14EF.recycle();
                    _fld14EF = null;
                }
                i = _fld1D48._mth13A5() | _fld1D51._mth13A5();
            }
            break;

        case 3: // '\003'
            i = j;
            if (_fld0631)
            {
                _mth02CA(_fld025F, true, 0, false);
                _fld157B = -1;
                _fld0631 = false;
                _fld068E = false;
                if (_fld14EF != null)
                {
                    _fld14EF.recycle();
                    _fld14EF = null;
                }
                i = _fld1D48._mth13A5() | _fld1D51._mth13A5();
            }
            break;

        case 5: // '\005'
            i = _cls153E._mth02CB(motionevent);
            _fld14F0 = _cls153E._mth02CE(motionevent, i);
            _fld157B = _cls153E._mth02CB(motionevent, i);
            i = j;
            break;

        case 6: // '\006'
            _mth141D(motionevent);
            _fld14F0 = _cls153E._mth02CE(motionevent, _cls153E._mth02CA(motionevent, _fld157B));
            i = j;
            break;
        }
        if (i != 0)
        {
            FE70._mth1FBE(this);
        }
        return true;
    }

    public void removeView(View view)
    {
        if (mInLayout)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(FB54 fb54)
    {
        if (_fld0254 != null)
        {
            FB54 fb54_1 = _fld0254;
            aux aux2 = _fld038A;
            fb54_1._fld1F76.unregisterObserver(aux2);
            for (int i = 0; i < FF89.size(); i++)
            {
                _cls02CA _lcls02ca = (_cls02CA)FF89.get(i);
                _fld0254._mth02CA(this, _lcls02ca.position, _lcls02ca.FB33);
            }

            FF89.clear();
            int k;
            for (int j = 0; j < getChildCount(); j = k + 1)
            {
                k = j;
                if (!((_cls02CB)getChildAt(j).getLayoutParams()).FE71)
                {
                    removeViewAt(j);
                    k = j - 1;
                }
            }

            _fld025F = 0;
            scrollTo(0, 0);
        }
        _fld0254 = fb54;
        FE8B = 0;
        if (_fld0254 != null)
        {
            if (_fld038A == null)
            {
                _fld038A = new aux((byte)0);
            }
            fb54 = _fld0254;
            aux aux1 = _fld038A;
            fb54._fld1F76.registerObserver(aux1);
            _fld05DB = false;
            boolean flag = _fld1D68;
            _fld1D68 = true;
            FE8B = _fld0254.getCount();
            if (_fld027A >= 0)
            {
                _mth02CA(_fld027A, false, true, 0);
                _fld027A = -1;
                _fld027C = null;
                _fld02B1 = null;
                return;
            }
            if (!flag)
            {
                _mth02CC(_fld025F);
                return;
            }
            requestLayout();
        }
    }

    public void setCurrentItem(int i)
    {
        _fld05DB = false;
        boolean flag;
        if (!_fld1D68)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _mth02CA(i, flag, false, 0);
    }

    public void setCurrentItem(int i, boolean flag)
    {
        _fld05DB = false;
        _mth02CA(i, flag, false, 0);
    }

    public void setOffscreenPageLimit(int i)
    {
        int j = i;
        if (i <= 0)
        {
            Log.w("ViewPager", (new StringBuilder("Requested offscreen page limit ")).append(i).append(" too small; defaulting to 1").toString());
            j = 1;
        }
        if (j != _fld0621)
        {
            _fld0621 = j;
            _mth1D36();
        }
    }

    public void setOnPageChangeListener(_cls02CF _pcls02cf)
    {
        _fld1FD8 = _pcls02cf;
    }

    public void setPageMargin(int i)
    {
        int j = _fld03F2;
        _fld03F2 = i;
        int k = getWidth();
        _mth02CA(k, k, i, j);
        requestLayout();
    }

    public void setPageMarginDrawable(int i)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        _fld03F3 = drawable;
        if (drawable != null)
        {
            refreshDrawableState();
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setPageTransformer$382b7817(boolean flag, o._cls1427.if if1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag2;
            if (if1 != null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            boolean flag3;
            if (_fld1FD9 != null)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            boolean flag1;
            if (flag2 != flag3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            _fld1FD9 = if1;
            if (android.os.Build.VERSION.SDK_INT >= 7)
            {
                if (_fld1FDA == null)
                {
                    try
                    {
                        _fld1FDA = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                            Boolean.TYPE
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (o._cls1427.if if1)
                    {
                        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", if1);
                    }
                }
                try
                {
                    _fld1FDA.invoke(this, new Object[] {
                        Boolean.valueOf(flag2)
                    });
                }
                // Misplaced declaration of an exception variable
                catch (o._cls1427.if if1)
                {
                    Log.e("ViewPager", "Error changing children drawing order", if1);
                }
            }
            if (flag2)
            {
                int i;
                if (flag)
                {
                    i = 2;
                } else
                {
                    i = 1;
                }
                _fld1FDB = i;
            } else
            {
                _fld1FDB = 0;
            }
            if (flag1)
            {
                _mth02CC(_fld025F);
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == _fld03F3;
    }

    public boolean _mth02CA(View view, boolean flag, int i, int j, int k)
    {
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = view.getScrollX();
            int j1 = view.getScrollY();
            for (int l = viewgroup.getChildCount() - 1; l >= 0; l--)
            {
                View view1 = viewgroup.getChildAt(l);
                if (j + i1 >= view1.getLeft() && j + i1 < view1.getRight() && k + j1 >= view1.getTop() && k + j1 < view1.getBottom() && _mth02CA(view1, true, i, (j + i1) - view1.getLeft(), (k + j1) - view1.getTop()))
                {
                    return true;
                }
            }

        }
        return flag && FE70._mth02CA(view, -i);
    }

    public final void _mth02CC(int i)
    {
        android.content.res.Resources.NotFoundException notfoundexception;
        _cls02CA _lcls02ca5 = null;
        byte byte1 = 2;
        if (_fld025F != i)
        {
            byte byte0;
            if (_fld025F < i)
            {
                byte0 = 66;
            } else
            {
                byte0 = 17;
            }
            _lcls02ca5 = _mth02CD(_fld025F);
            _fld025F = i;
            byte1 = byte0;
        }
        if (_fld0254 == null)
        {
            _mth1D38();
            return;
        }
        if (_fld05DB)
        {
            _mth1D38();
            return;
        }
        if (getWindowToken() == null)
        {
            return;
        }
        i = _fld0621;
        int k2 = Math.max(0, _fld025F - i);
        int i2 = _fld0254.getCount();
        int j2 = Math.min(i2 - 1, _fld025F + i);
        if (i2 != FE8B)
        {
            String s;
            try
            {
                s = getResources().getResourceName(getId());
            }
            // Misplaced declaration of an exception variable
            catch (android.content.res.Resources.NotFoundException notfoundexception)
            {
                s = Integer.toHexString(getId());
            }
            throw new IllegalStateException((new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ")).append(FE8B).append(", found: ").append(i2).append(" Pager id: ").append(s).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(_fld0254.getClass()).toString());
        }
        _cls02CA _lcls02ca7 = null;
        i = 0;
        _cls02CA _lcls02ca;
        do
        {
            _lcls02ca = _lcls02ca7;
            if (i >= FF89.size())
            {
                break;
            }
            _cls02CA _lcls02ca8 = (_cls02CA)FF89.get(i);
            if (_lcls02ca8.position >= _fld025F)
            {
                _lcls02ca = _lcls02ca7;
                if (_lcls02ca8.position == _fld025F)
                {
                    _lcls02ca = _lcls02ca8;
                }
                break;
            }
            i++;
        } while (true);
        _lcls02ca7 = _lcls02ca;
        if (_lcls02ca == null)
        {
            _lcls02ca7 = _lcls02ca;
            if (i2 > 0)
            {
                _lcls02ca7 = _mth02CF(_fld025F, i);
            }
        }
        if (_lcls02ca7 != null)
        {
            float f4 = 0.0F;
            int j = i - 1;
            int l1 = j;
            _cls02CA _lcls02ca1;
            if (j >= 0)
            {
                _lcls02ca1 = (_cls02CA)FF89.get(l1);
            } else
            {
                _lcls02ca1 = null;
            }
            int l2 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
            float f2;
            if (l2 <= 0)
            {
                f2 = 0.0F;
            } else
            {
                f2 = (2.0F - _lcls02ca7.FB65) + (float)getPaddingLeft() / (float)l2;
            }
            int k1 = _fld025F - 1;
            _cls02CA _lcls02ca9 = _lcls02ca1;
            int j1 = i;
            while (k1 >= 0) 
            {
                float f;
                _cls02CA _lcls02ca2;
                int k;
                if (f4 >= f2 && k1 < k2)
                {
                    if (_lcls02ca9 == null)
                    {
                        break;
                    }
                    i = j1;
                    f = f4;
                    k = l1;
                    _lcls02ca2 = _lcls02ca9;
                    if (k1 == _lcls02ca9.position)
                    {
                        i = j1;
                        f = f4;
                        k = l1;
                        _lcls02ca2 = _lcls02ca9;
                        if (!_lcls02ca9.FB5D)
                        {
                            FF89.remove(l1);
                            _fld0254._mth02CA(this, k1, _lcls02ca9.FB33);
                            k = l1 - 1;
                            i = j1 - 1;
                            if (k >= 0)
                            {
                                _lcls02ca2 = (_cls02CA)FF89.get(k);
                            } else
                            {
                                _lcls02ca2 = null;
                            }
                            f = f4;
                        }
                    }
                } else
                if (_lcls02ca9 != null && k1 == _lcls02ca9.position)
                {
                    f = f4 + _lcls02ca9.FB65;
                    k = l1 - 1;
                    if (k >= 0)
                    {
                        _lcls02ca2 = (_cls02CA)FF89.get(k);
                    } else
                    {
                        _lcls02ca2 = null;
                    }
                    i = j1;
                } else
                {
                    f = f4 + _mth02CF(k1, l1 + 1).FB65;
                    i = j1 + 1;
                    if (l1 >= 0)
                    {
                        _lcls02ca2 = (_cls02CA)FF89.get(l1);
                        k = l1;
                    } else
                    {
                        _lcls02ca2 = null;
                        k = l1;
                    }
                }
                k1--;
                j1 = i;
                f4 = f;
                l1 = k;
                _lcls02ca9 = _lcls02ca2;
            }
            f4 = _lcls02ca7.FB65;
            k1 = j1 + 1;
            if (f4 < 2.0F)
            {
                _cls02CA _lcls02ca3;
                if (k1 < FF89.size())
                {
                    _lcls02ca3 = (_cls02CA)FF89.get(k1);
                } else
                {
                    _lcls02ca3 = null;
                }
                float f3;
                if (l2 <= 0)
                {
                    f3 = 0.0F;
                } else
                {
                    f3 = (float)getPaddingRight() / (float)l2 + 2.0F;
                }
                int l = _fld025F + 1;
                _cls02CA _lcls02ca10 = _lcls02ca3;
                while (l < i2) 
                {
                    float f1;
                    _cls02CA _lcls02ca4;
                    if (f4 >= f3 && l > j2)
                    {
                        if (_lcls02ca10 == null)
                        {
                            break;
                        }
                        i = k1;
                        _lcls02ca4 = _lcls02ca10;
                        f1 = f4;
                        if (l == _lcls02ca10.position)
                        {
                            i = k1;
                            _lcls02ca4 = _lcls02ca10;
                            f1 = f4;
                            if (!_lcls02ca10.FB5D)
                            {
                                FF89.remove(k1);
                                _fld0254._mth02CA(this, l, _lcls02ca10.FB33);
                                if (k1 < FF89.size())
                                {
                                    _lcls02ca4 = (_cls02CA)FF89.get(k1);
                                } else
                                {
                                    _lcls02ca4 = null;
                                }
                                i = k1;
                                f1 = f4;
                            }
                        }
                    } else
                    if (_lcls02ca10 != null && l == _lcls02ca10.position)
                    {
                        f1 = f4 + _lcls02ca10.FB65;
                        i = k1 + 1;
                        if (i < FF89.size())
                        {
                            _lcls02ca4 = (_cls02CA)FF89.get(i);
                        } else
                        {
                            _lcls02ca4 = null;
                        }
                    } else
                    {
                        _lcls02ca4 = _mth02CF(l, k1);
                        i = k1 + 1;
                        f1 = f4 + _lcls02ca4.FB65;
                        if (i < FF89.size())
                        {
                            _lcls02ca4 = (_cls02CA)FF89.get(i);
                        } else
                        {
                            _lcls02ca4 = null;
                        }
                    }
                    l++;
                    k1 = i;
                    _lcls02ca10 = _lcls02ca4;
                    f4 = f1;
                }
            }
            _mth02CA(_lcls02ca7, j1, _lcls02ca5);
        }
        int i1 = getChildCount();
        for (i = 0; i < i1; i++)
        {
            Object obj1 = getChildAt(i);
            _cls02CB _lcls02cb = (_cls02CB)((View) (obj1)).getLayoutParams();
            _lcls02cb.FEAA = i;
            if (_lcls02cb.FE71 || _lcls02cb.FB65 != 0.0F)
            {
                continue;
            }
            obj1 = _mth2071(((View) (obj1)));
            if (obj1 != null)
            {
                _lcls02cb.FB65 = ((_cls02CA) (obj1)).FB65;
                _lcls02cb.position = ((_cls02CA) (obj1)).position;
            }
        }

        _mth1D38();
        if (hasFocus())
        {
            Object obj = findFocus();
            if (obj != null)
            {
                obj = FE76(((View) (obj)));
            } else
            {
                obj = null;
            }
            if (obj == null || ((_cls02CA) (obj)).position != _fld025F)
            {
                i = 0;
                do
                {
                    if (i >= getChildCount())
                    {
                        break;
                    }
                    View view = getChildAt(i);
                    _cls02CA _lcls02ca6 = _mth2071(view);
                    if (_lcls02ca6 != null && _lcls02ca6.position == _fld025F && view.requestFocus(byte1))
                    {
                        break;
                    }
                    i++;
                } while (true);
            }
        }
    }

    final void _mth15EE()
    {
        int i = _fld0254.getCount();
        FE8B = i;
        boolean flag;
        if (FF89.size() < (_fld0621 << 1) + 1 && FF89.size() < i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int i1 = _fld025F;
        for (int k = 0; k < FF89.size(); k++)
        {
            FF89.get(k);
        }

        Collections.sort(FF89, FE9C);
        if (flag)
        {
            int l = getChildCount();
            for (int j = 0; j < l; j++)
            {
                _cls02CB _lcls02cb = (_cls02CB)getChildAt(j).getLayoutParams();
                if (!_lcls02cb.FE71)
                {
                    _lcls02cb.FB65 = 0.0F;
                }
            }

            _mth02CA(i1, false, true, 0);
            requestLayout();
        }
    }

    final void _mth1D36()
    {
        _mth02CC(_fld025F);
    }

}
