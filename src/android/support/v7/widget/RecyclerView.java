// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import o.020B;
import o.02B8;
import o.05E8;
import o.0690;
import o.10D0;
import o.1422;
import o.14D2;
import o.153E;
import o.1551;
import o.1D4A;
import o.1D58;
import o.1D64;
import o.2040;
import o.FB1F;
import o.FB3B;
import o.FB60;
import o.FB61;
import o.FB68;
import o.FBA2;
import o.FBE9;
import o.FE70;
import o.FE77;
import o.FE8C;
import o.FEAC;
import o.FEAF;
import o.FEE3;

public class RecyclerView extends ViewGroup
    implements FB60, _cls1D58
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new FEAF();
        Parcelable eY;

        static void _mth02CA(SavedState savedstate, SavedState savedstate1)
        {
            savedstate.eY = savedstate1.eY;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(eY, 0);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            eY = parcel.readParcelable(android/support/v7/widget/RecyclerView$02BB.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static abstract class aux
    {

        public void _mth02CA(Rect rect, View view, RecyclerView recyclerview, con con1)
        {
            ((_cls02BC)view.getLayoutParams()).eJ.getLayoutPosition();
            rect.set(0, 0, 0, 0);
        }

        public aux()
        {
        }
    }

    public static final class con
    {

        int eZ;
        _cls1422 fj;
        _cls1422 fk;
        _cls1422 fl;
        final ArrayList fm = new ArrayList();
        public int fn;
        public int fo;
        public int fp;
        public boolean fq;
        public boolean fr;
        boolean fs;
        boolean ft;

        private static void _mth02CA(_cls1422 _pcls1422, _cls02CC _pcls02cc)
        {
            for (int i = _pcls1422.size() - 1; i >= 0; i--)
            {
                if (_pcls02cc == ((_cls1551) (_pcls1422)).FB48[(i << 1) + 1])
                {
                    _pcls1422.removeAt(i);
                    return;
                }
            }

        }

        public final String toString()
        {
            return (new StringBuilder("State{mTargetPosition=")).append(eZ).append(", mPreLayoutHolderMap=").append(fj).append(", mPostLayoutHolderMap=").append(fk).append(", mData=").append(null).append(", mItemCount=").append(fn).append(", mPreviousLayoutItemCount=").append(fo).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(fp).append(", mStructureChanged=").append(fq).append(", mInPreLayout=").append(fr).append(", mRunSimpleAnimations=").append(fs).append(", mRunPredictiveAnimations=").append(ft).append('}').toString();
        }

        final void _mth02CD(_cls02CC _pcls02cc)
        {
            fj.remove(_pcls02cc);
            fk.remove(_pcls02cc);
            if (fl != null)
            {
                _mth02CA(fl, _pcls02cc);
            }
            fm.remove(_pcls02cc.fy);
        }

        public con()
        {
            eZ = -1;
            fj = new _cls1422();
            fk = new _cls1422();
            fl = new _cls1422();
            fn = 0;
            fo = 0;
            fp = 0;
            fq = false;
            fr = false;
            fs = false;
            ft = false;
        }
    }

    public static abstract class if
    {

        public final _cls02CA ey = new _cls02CA();
        public boolean ez;

        public abstract int getItemCount();

        public long getItemId(int i)
        {
            return -1L;
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public abstract void _mth02CA(_cls02CC _pcls02cc, int i);

        public abstract _cls02CC _mth02CB(ViewGroup viewgroup, int i);

        public final void _mth02CB(_cls02CC _pcls02cc, int i)
        {
            _pcls02cc.bX = i;
            if (ez)
            {
                _pcls02cc.fA = getItemId(i);
            }
            _pcls02cc._fld0E20 = _pcls02cc._fld0E20 & 0xfffffdf8 | 1;
            _cls02B8.beginSection("RV OnBindView");
            _mth02CA(_pcls02cc, i);
            _cls02B8.endSection();
        }

        public if()
        {
            ez = false;
        }
    }

    /* member class not found */
    class _cls02BB {}

    /* member class not found */
    class _cls02BC {}

    /* member class not found */
    class _cls02BD {}

    /* member class not found */
    class _cls02BE {}

    /* member class not found */
    class _cls02BF {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02C8 {}

    /* member class not found */
    class _cls02C9 {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CC {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CF {}

    /* member class not found */
    class _cls037A {}

    /* member class not found */
    class _cls141D {}

    /* member class not found */
    class _cls1FBE {}


    private static final boolean dw;
    private static final Class dx[];
    private static final FBA2 ew = new FBA2();
    private SavedState dA;
    public FB1F dB;
    public _cls0690 dC;
    private boolean dD;
    private final FB3B dE;
    public if dF;
    public _cls02BB dG;
    private o._cls1427.if dH;
    public final ArrayList dI;
    public final ArrayList dJ;
    private _cls02BD dK;
    private boolean dL;
    private boolean dM;
    public boolean dN;
    public boolean dO;
    public boolean dP;
    private int dQ;
    private boolean dR;
    private final boolean dS;
    private final AccessibilityManager dT;
    public boolean dU;
    int dV;
    _cls1D4A dW;
    _cls1D4A dX;
    _cls1D4A dY;
    _cls1D4A dZ;
    private final _cls02BE dy;
    public final _cls1FBE dz;
    public _cls02CE ea;
    private int eb;
    private int ec;
    private int ed;
    private int ee;
    private int ef;
    private final int eg;
    private final int eh;
    private float ei;
    private final _cls02C9 ej;
    public final con ek;
    private FE77 el;
    public boolean em;
    public boolean en;
    private _cls02CF eo;
    private boolean ep;
    private FEE3 eq;
    private o._cls1427.if er;
    private final int es[];
    private final _cls1D64 et;
    private final int eu[];
    private FB68 ev;
    private final int _fld0135[];
    private final int _fld0138[];
    private final Rect _fld01C0;
    private int _fld0EC0;
    private VelocityTracker _fld14EF;
    private int FB1F;

    public RecyclerView(Context context)
    {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeset, int i)
    {
        Object obj;
        super(context, attributeset, i);
        dy = new _cls02BE((byte)0);
        dz = new _cls1FBE();
        dE = new FB3B(this);
        _fld01C0 = new Rect();
        dI = new ArrayList();
        dJ = new ArrayList();
        dU = false;
        dV = 0;
        ea = new _cls10D0();
        FB1F = 0;
        eb = -1;
        ei = 1.401298E-45F;
        ej = new _cls02C9();
        ek = new con();
        em = false;
        en = false;
        eo = new _cls02CF((byte)0);
        ep = false;
        es = new int[2];
        _fld0135 = new int[2];
        _fld0138 = new int[2];
        eu = new int[2];
        ev = new FB68(this);
        setFocusableInTouchMode(true);
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dS = flag;
        obj = ViewConfiguration.get(context);
        _fld0EC0 = ((ViewConfiguration) (obj)).getScaledTouchSlop();
        eg = ((ViewConfiguration) (obj)).getScaledMinimumFlingVelocity();
        eh = ((ViewConfiguration) (obj)).getScaledMaximumFlingVelocity();
        if (FE70._mth02BC(this) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        ea.eA = eo;
        dB = new FB1F(new FEAC(this));
        dC = new _cls0690(new FE8C(this));
        if (FE70._mth02BE(this) == 0)
        {
            FE70._mth02CE(this, 1);
        }
        dT = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new FEE3(this));
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_884;
        }
        obj = context.obtainStyledAttributes(attributeset, _cls2040.RecyclerView, i, 0);
        String s = ((TypedArray) (obj)).getString(_cls2040.RecyclerView_layoutManager);
        ((TypedArray) (obj)).recycle();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_884;
        }
        obj = s.trim();
        if (((String) (obj)).length() == 0)
        {
            break MISSING_BLOCK_LABEL_884;
        }
        if (((String) (obj)).charAt(0) == '.')
        {
            obj = (new StringBuilder()).append(context.getPackageName()).append(((String) (obj))).toString();
        } else
        if (!((String) (obj)).contains("."))
        {
            obj = (new StringBuilder()).append(android/support/v7/widget/RecyclerView.getPackage().getName()).append('.').append(((String) (obj))).toString();
        }
        ClassLoader classloader;
        if (isInEditMode())
        {
            classloader = getClass().getClassLoader();
            break MISSING_BLOCK_LABEL_540;
        }
        classloader = context.getClassLoader();
        Class class1 = classloader.loadClass(((String) (obj))).asSubclass(android/support/v7/widget/RecyclerView$02BB);
        Object aobj[] = null;
        Constructor constructor = class1.getConstructor(dx);
        aobj = (new Object[] {
            context, attributeset, Integer.valueOf(i), Integer.valueOf(0)
        });
        context = constructor;
        break MISSING_BLOCK_LABEL_663;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        try
        {
            context = class1.getConstructor(new Class[0]);
            break MISSING_BLOCK_LABEL_663;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Unable to find LayoutManager ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Cannot access non-public constructor ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Class is not a LayoutManager ").append(((String) (obj))).toString(), context);
        }
        context.initCause(nosuchmethodexception);
        throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error creating LayoutManager ").append(((String) (obj))).toString(), context);
        context.setAccessible(true);
        setLayoutManager((_cls02BB)context.newInstance(aobj));
        break MISSING_BLOCK_LABEL_884;
        et = new _cls1D64(this);
        setNestedScrollingEnabled(true);
        return;
    }

    public static if _mth02BB(RecyclerView recyclerview)
    {
        return recyclerview.dF;
    }

    static void _mth02BC(RecyclerView recyclerview)
    {
        recyclerview.dV = recyclerview.dV + 1;
    }

    static boolean _mth02BD(RecyclerView recyclerview)
    {
        return recyclerview.ea != null && recyclerview.ea.eG;
    }

    static boolean _mth02BE(RecyclerView recyclerview)
    {
        return recyclerview.awakenScrollBars();
    }

    static void _mth02BF(RecyclerView recyclerview)
    {
        if (!recyclerview.dU)
        {
            recyclerview.dU = true;
            int l = recyclerview.dC.aF.getChildCount();
            for (int i = 0; i < l; i++)
            {
                Object obj = recyclerview.dC.aF.getChildAt(i);
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
                }
                if (obj == null)
                {
                    continue;
                }
                boolean flag;
                if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    obj._fld0E20 = ((_cls02CC) (obj))._fld0E20 | 0x200;
                }
            }

            recyclerview = recyclerview.dz;
            int k = ((_cls1FBE) (recyclerview)).eS.size();
            for (int j = 0; j < k; j++)
            {
                _cls02CC _lcls02cc = (_cls02CC)((_cls1FBE) (recyclerview)).eS.get(j);
                if (_lcls02cc != null)
                {
                    _lcls02cc._fld0E20 = _lcls02cc._fld0E20 | 0x200;
                }
            }

        }
    }

    static boolean _mth02C8(RecyclerView recyclerview)
    {
        return recyclerview.dS;
    }

    private void _mth02C9(int i)
    {
        if (i == FB1F)
        {
            return;
        }
        FB1F = i;
        if (i != 2)
        {
            Object obj = ej;
            ((_cls02C9) (obj)).ex.removeCallbacks(((Runnable) (obj)));
            ((_cls02C9) (obj)).FEAE.abortAnimation();
            if (dG != null)
            {
                obj = dG;
            }
        }
    }

    static boolean _mth02C9(RecyclerView recyclerview)
    {
        return recyclerview.dM;
    }

    static int _mth02CA(RecyclerView recyclerview, _cls02CC _pcls02cc)
    {
label0:
        {
            boolean flag;
            if ((_pcls02cc._fld0E20 & 0x20c) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                boolean flag1;
                if ((_pcls02cc._fld0E20 & 1) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    break label0;
                }
            }
            return -1;
        }
        recyclerview = recyclerview.dB;
        int j = _pcls02cc.bX;
        int i1 = ((FB1F) (recyclerview)).s.size();
        for (int l = 0; l < i1;)
        {
            _pcls02cc = (o.FB1F._cls02CA)((FB1F) (recyclerview)).s.get(l);
            int i = j;
            switch (((o.FB1F._cls02CA) (_pcls02cc)).FE7A)
            {
            default:
                i = j;
                break;

            case 2: // '\002'
                break;

            case 0: // '\0'
                i = j;
                if (((o.FB1F._cls02CA) (_pcls02cc)).C <= j)
                {
                    i = j + ((o.FB1F._cls02CA) (_pcls02cc)).D;
                }
                break;

            case 1: // '\001'
                i = j;
                if (((o.FB1F._cls02CA) (_pcls02cc)).C > j)
                {
                    break;
                }
                if (((o.FB1F._cls02CA) (_pcls02cc)).C + ((o.FB1F._cls02CA) (_pcls02cc)).D > j)
                {
                    return -1;
                }
                i = j - ((o.FB1F._cls02CA) (_pcls02cc)).D;
                break;

            case 3: // '\003'
                if (((o.FB1F._cls02CA) (_pcls02cc)).C == j)
                {
                    i = ((o.FB1F._cls02CA) (_pcls02cc)).D;
                    break;
                }
                int k = j;
                if (((o.FB1F._cls02CA) (_pcls02cc)).C < j)
                {
                    k = j - 1;
                }
                i = k;
                if (((o.FB1F._cls02CA) (_pcls02cc)).D <= k)
                {
                    i = k + 1;
                }
                break;
            }
            l++;
            j = i;
        }

        return j;
    }

    private void _mth02CA(_cls02CC _pcls02cc, Rect rect, int i, int j)
    {
        if (rect != null && (rect.left != i || rect.top != j))
        {
            _pcls02cc.setIsRecyclable(false);
            if (ea._mth02CA(_pcls02cc, rect.left, rect.top, i, j))
            {
                if (!ep && dL)
                {
                    FE70._mth02CA(this, ev);
                    ep = true;
                }
                return;
            }
        } else
        {
            _pcls02cc.setIsRecyclable(false);
            ea._mth02CB(_pcls02cc);
            if (!ep && dL)
            {
                FE70._mth02CA(this, ev);
                ep = true;
            }
        }
    }

    private void _mth02CA(_cls02CC _pcls02cc, _cls02CC _pcls02cc1)
    {
        int i;
        int j;
        int k;
        int l;
label0:
        {
label1:
            {
                _pcls02cc.setIsRecyclable(false);
                _mth141D(_pcls02cc);
                _pcls02cc.fD = _pcls02cc1;
                dz._mth02C9(_pcls02cc);
                k = _pcls02cc.fy.getLeft();
                l = _pcls02cc.fy.getTop();
                if (_pcls02cc1 != null)
                {
                    boolean flag;
                    if ((_pcls02cc1._fld0E20 & 0x80) != 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                }
                j = k;
                i = l;
                break label0;
            }
            j = _pcls02cc1.fy.getLeft();
            i = _pcls02cc1.fy.getTop();
            _pcls02cc1.setIsRecyclable(false);
            _pcls02cc1.fE = _pcls02cc;
        }
        if (ea._mth02CA(_pcls02cc, _pcls02cc1, k, l, j, i) && !ep && dL)
        {
            FE70._mth02CA(this, ev);
            ep = true;
        }
    }

    private void _mth02CA(_cls141D _pcls141d)
    {
        View view = _pcls141d.bv.fy;
        _mth141D(_pcls141d.bv);
        int i = _pcls141d.left;
        int j = _pcls141d.top;
        int k = view.getLeft();
        int l = view.getTop();
        if (i != k || j != l)
        {
            _pcls141d.bv.setIsRecyclable(false);
            view.layout(k, l, view.getWidth() + k, view.getHeight() + l);
            if (ea._mth02CA(_pcls141d.bv, i, j, k, l))
            {
                if (!ep && dL)
                {
                    FE70._mth02CA(this, ev);
                    ep = true;
                }
                return;
            }
        } else
        {
            _pcls141d.bv.setIsRecyclable(false);
            if (ea._mth02CA(_pcls141d.bv) && !ep && dL)
            {
                FE70._mth02CA(this, ev);
                ep = true;
            }
        }
    }

    public static void _mth02CA(RecyclerView recyclerview, int i)
    {
        recyclerview.detachViewFromParent(i);
    }

    static void _mth02CA(RecyclerView recyclerview, int i, int j)
    {
        recyclerview._mth0559(i, j);
    }

    public static void _mth02CA(RecyclerView recyclerview, View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            recyclerview = ((_cls02BC)view.getLayoutParams()).eJ;
            return;
        }
    }

    public static void _mth02CA(RecyclerView recyclerview, View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        recyclerview.attachViewToParent(view, i, layoutparams);
    }

    private void _mth02CA(_cls1422 _pcls1422)
    {
        ArrayList arraylist = ek.fm;
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            View view = (View)arraylist.get(i);
            Object obj;
            if (view == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)view.getLayoutParams()).eJ;
            }
            Object obj1 = (_cls141D)ek.fj.remove(obj);
            if (!ek.fr)
            {
                ek.fk.remove(obj);
            }
            if (_pcls1422.remove(view) != null)
            {
                obj1 = dG;
                obj = dz;
                obj1 = ((_cls02BB) (obj1)).dC;
                int j = ((_cls0690) (obj1)).aF.indexOfChild(view);
                if (j >= 0)
                {
                    if (((_cls0690) (obj1)).aG.FB39(j))
                    {
                        ((_cls0690) (obj1)).aH.remove(view);
                    }
                    ((_cls0690) (obj1)).aF.removeViewAt(j);
                }
                ((_cls1FBE) (obj))._mth02D0(view);
                continue;
            }
            if (obj1 != null)
            {
                _mth02CA(((_cls141D) (obj1)));
            } else
            {
                _mth02CA(new _cls141D(((_cls02CC) (obj)), view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }

        arraylist.clear();
    }

    private boolean _mth02CA(int i, int j, MotionEvent motionevent)
    {
        int k = 0;
        boolean flag3 = false;
        int i1 = 0;
        boolean flag1 = false;
        int l = 0;
        boolean flag2 = false;
        int j1 = 0;
        boolean flag = false;
        dE.run();
        if (dF != null)
        {
            if (!dO)
            {
                dO = true;
                dP = false;
            }
            dV = dV + 1;
            _cls02B8.beginSection("RV Scroll");
            k = ((flag3) ? 1 : 0);
            l = ((flag2) ? 1 : 0);
            if (i != 0)
            {
                l = dG._mth02CA(i, dz, ek);
                k = i - l;
            }
            i1 = ((flag1) ? 1 : 0);
            j1 = ((flag) ? 1 : 0);
            if (j != 0)
            {
                j1 = dG._mth02CB(j, dz, ek);
                i1 = j - j1;
            }
            _cls02B8.endSection();
            if (ea != null && ea.eG)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                _cls0690 _lcls0690 = dC;
                int l1 = _lcls0690.aF.getChildCount();
                int i2 = _lcls0690.aH.size();
                for (int k1 = 0; k1 < l1 - i2; k1++)
                {
                    Object obj = dC;
                    int j2 = ((_cls0690) (obj)).FB1D(k1);
                    View view = ((_cls0690) (obj)).aF.getChildAt(j2);
                    obj = _mth1D63(view);
                    if (obj == null || ((_cls02CC) (obj)).fE == null)
                    {
                        continue;
                    }
                    obj = ((_cls02CC) (obj)).fE;
                    if (obj != null)
                    {
                        obj = ((_cls02CC) (obj)).fy;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    j2 = view.getLeft();
                    int k2 = view.getTop();
                    if (j2 != ((View) (obj)).getLeft() || k2 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(j2, k2, ((View) (obj)).getWidth() + j2, ((View) (obj)).getHeight() + k2);
                    }
                }

            }
            dV = dV - 1;
            if (dV <= 0)
            {
                dV = 0;
                _mth1D45();
            }
            _mth2071(false);
        }
        if (!dI.isEmpty())
        {
            invalidate();
        }
        if (dispatchNestedScroll(l, j1, k, i1, _fld0135))
        {
            ee = ee - _fld0135[0];
            ef = ef - _fld0135[1];
            motionevent.offsetLocation(_fld0135[0], _fld0135[1]);
            motionevent = eu;
            motionevent[0] = motionevent[0] + _fld0135[0];
            motionevent = eu;
            motionevent[1] = motionevent[1] + _fld0135[1];
        } else
        if (FE70._mth02BC(this) != 2)
        {
            if (motionevent != null)
            {
                _mth02CE(motionevent.getX(), k, motionevent.getY(), i1);
            }
            _mth0559(i, j);
        }
        if (l != 0 || j1 != 0)
        {
            i = getScrollX();
            j = getScrollY();
            onScrollChanged(i, j, i, j);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        return l != 0 || j1 != 0;
    }

    public static boolean _mth02CA(RecyclerView recyclerview)
    {
        return recyclerview.dN;
    }

    public static boolean _mth02CA(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.ep = false;
        return false;
    }

    static void _mth02CB(RecyclerView recyclerview, int i)
    {
        recyclerview._mth02C9(i);
    }

    static void _mth02CB(RecyclerView recyclerview, int i, int j)
    {
        recyclerview._mth05D9(i, j);
    }

    public static void _mth02CB(RecyclerView recyclerview, View view)
    {
        if (view == null)
        {
            return;
        } else
        {
            recyclerview = ((_cls02BC)view.getLayoutParams()).eJ;
            return;
        }
    }

    private void _mth02CB(int ai[])
    {
        _cls0690 _lcls0690 = dC;
        int i2 = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        if (i2 == 0)
        {
            ai[0] = 0;
            ai[1] = 0;
            return;
        }
        int i = 0x7fffffff;
        int i1 = 0x80000000;
        for (int l = 0; l < i2;)
        {
            Object obj = dC;
            int j = ((_cls0690) (obj)).FB1D(l);
            obj = ((_cls0690) (obj)).aF.getChildAt(j);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
            }
            boolean flag;
            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int j1 = i;
            int k1 = i1;
            if (!flag)
            {
                int l1 = ((_cls02CC) (obj)).getLayoutPosition();
                int k = i;
                if (l1 < i)
                {
                    k = l1;
                }
                j1 = k;
                k1 = i1;
                if (l1 > i1)
                {
                    k1 = l1;
                    j1 = k;
                }
            }
            l++;
            i = j1;
            i1 = k1;
        }

        ai[0] = i;
        ai[1] = i1;
    }

    public static boolean _mth02CB(RecyclerView recyclerview)
    {
        return recyclerview.dU;
    }

    static boolean _mth02CB(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.dR = true;
        return true;
    }

    static boolean _mth02CC(RecyclerView recyclerview)
    {
        return recyclerview.dL;
    }

    static Runnable _mth02CD(RecyclerView recyclerview)
    {
        return recyclerview.dE;
    }

    private void _mth02CE(float f, float f1, float f2, float f3)
    {
        boolean flag1 = false;
        boolean flag;
        if (f1 < 0.0F)
        {
            _mth1D32();
            flag = flag1;
            if (dW._mth02CB(-f1 / (float)getWidth(), 1.0F - f2 / (float)getHeight()))
            {
                flag = true;
            }
        } else
        {
            flag = flag1;
            if (f1 > 0.0F)
            {
                _mth1D3E();
                flag = flag1;
                if (dY._mth02CB(f1 / (float)getWidth(), f2 / (float)getHeight()))
                {
                    flag = true;
                }
            }
        }
        if (f3 < 0.0F)
        {
            _mth1D41();
            flag1 = flag;
            if (dX._mth02CB(-f3 / (float)getHeight(), f / (float)getWidth()))
            {
                flag1 = true;
            }
        } else
        {
            flag1 = flag;
            if (f3 > 0.0F)
            {
                _mth1D43();
                flag1 = flag;
                if (dZ._mth02CB(f3 / (float)getHeight(), 1.0F - f / (float)getWidth()))
                {
                    flag1 = true;
                }
            }
        }
        if (flag1 || f1 != 0.0F || f3 != 0.0F)
        {
            FE70._mth1FBE(this);
        }
    }

    public static void _mth02CE(RecyclerView recyclerview, int i, int j)
    {
        recyclerview.setMeasuredDimension(i, j);
    }

    public static boolean _mth02CE(RecyclerView recyclerview)
    {
        return recyclerview.dP;
    }

    static boolean _mth02CE(RecyclerView recyclerview, View view)
    {
        if (!recyclerview.dO)
        {
            recyclerview.dO = true;
            recyclerview.dP = false;
        }
        _cls0690 _lcls0690 = recyclerview.dC;
        int i = _lcls0690.aF.indexOfChild(view);
        boolean flag;
        if (i == -1)
        {
            _lcls0690.aH.remove(view);
            flag = true;
        } else
        if (_lcls0690.aG.get(i))
        {
            _lcls0690.aG.FB39(i);
            _lcls0690.aH.remove(view);
            _lcls0690.aF.removeViewAt(i);
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (view == null)
            {
                view = null;
            } else
            {
                view = ((_cls02BC)view.getLayoutParams()).eJ;
            }
            recyclerview.dz._mth02C9(view);
            recyclerview.dz._mth02C8(view);
        }
        recyclerview._mth2071(false);
        return flag;
    }

    public static _cls02BB _mth02CF(RecyclerView recyclerview)
    {
        return recyclerview.dG;
    }

    static AccessibilityManager _mth02D1(RecyclerView recyclerview)
    {
        return recyclerview.dT;
    }

    static void _mth037A(RecyclerView recyclerview)
    {
        recyclerview.dV = recyclerview.dV - 1;
        if (recyclerview.dV <= 0)
        {
            recyclerview.dV = 0;
            recyclerview._mth1D45();
        }
    }

    private void _mth037A(MotionEvent motionevent)
    {
        int i = _cls153E._mth02CB(motionevent);
        if (_cls153E._mth02CB(motionevent, i) == eb)
        {
            if (i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            eb = _cls153E._mth02CB(motionevent, i);
            int j = (int)(_cls153E._mth02CE(motionevent, i) + 0.5F);
            ee = j;
            ec = j;
            i = (int)(_cls153E._mth02CF(motionevent, i) + 0.5F);
            ef = i;
            ed = i;
        }
    }

    private void _mth0559(int i, int j)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (dW != null)
        {
            flag = flag1;
            if (!dW.isFinished())
            {
                flag = flag1;
                if (i > 0)
                {
                    flag = dW._mth13A5();
                }
            }
        }
        flag1 = flag;
        if (dY != null)
        {
            flag1 = flag;
            if (!dY.isFinished())
            {
                flag1 = flag;
                if (i < 0)
                {
                    flag1 = flag | dY._mth13A5();
                }
            }
        }
        flag = flag1;
        if (dX != null)
        {
            flag = flag1;
            if (!dX.isFinished())
            {
                flag = flag1;
                if (j > 0)
                {
                    flag = flag1 | dX._mth13A5();
                }
            }
        }
        flag1 = flag;
        if (dZ != null)
        {
            flag1 = flag;
            if (!dZ.isFinished())
            {
                flag1 = flag;
                if (j < 0)
                {
                    flag1 = flag | dZ._mth13A5();
                }
            }
        }
        if (flag1)
        {
            FE70._mth1FBE(this);
        }
    }

    private void _mth05D9(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getMode(i);
        int k = android.view.View.MeasureSpec.getMode(j);
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        switch (l)
        {
        default:
            i = FE70._mth0640(this);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (k)
            {
            default:
                j = FE70._mth1427(this);
                // fall through

            case -2147483648: 
            case 1073741824: 
                setMeasuredDimension(i, j);
                break;
            }
            break;
        }
    }

    static FEE3 _mth0640(RecyclerView recyclerview)
    {
        return recyclerview.eq;
    }

    private boolean _mth0674(int i, int j)
    {
        _cls0690 _lcls0690 = dC;
        int i1 = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
        if (i1 == 0)
        {
            return i != 0 || j != 0;
        }
        for (int k = 0; k < i1; k++)
        {
            Object obj = dC;
            int l = ((_cls0690) (obj)).FB1D(k);
            obj = ((_cls0690) (obj)).aF.getChildAt(l);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
            }
            boolean flag;
            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                continue;
            }
            flag = ((_cls02CC) (obj)).getLayoutPosition();
            if (flag < i || flag > j)
            {
                return true;
            }
        }

        return false;
    }

    private void _mth141D(_cls02CC _pcls02cc)
    {
        View view = _pcls02cc.fy;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dz._mth02C9(_mth1D63(view));
        boolean flag1;
        if ((_pcls02cc._fld0E20 & 0x100) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            dC._mth02CA(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            dC._mth02CA(view, -1, true);
            return;
        }
        _pcls02cc = dC;
        int i = ((_cls0690) (_pcls02cc)).aF.indexOfChild(view);
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("view is not a child, cannot hide ")).append(view).toString());
        } else
        {
            ((_cls0690) (_pcls02cc)).aG.set(i);
            ((_cls0690) (_pcls02cc)).aH.add(view);
            return;
        }
    }

    static void _mth141D(RecyclerView recyclerview)
    {
        recyclerview.dE.run();
    }

    static o._cls1427.if _mth1427(RecyclerView recyclerview)
    {
        return recyclerview.dH;
    }

    public static _cls02CC _mth1508(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((_cls02BC)view.getLayoutParams()).eJ;
        }
    }

    public static int _mth15EE(View view)
    {
        if (view == null)
        {
            view = null;
        } else
        {
            view = ((_cls02BC)view.getLayoutParams()).eJ;
        }
        if (view != null)
        {
            return view.getAdapterPosition();
        } else
        {
            return -1;
        }
    }

    private void _mth1D2C()
    {
        _mth02C9(0);
        Object obj = ej;
        ((_cls02C9) (obj)).ex.removeCallbacks(((Runnable) (obj)));
        ((_cls02C9) (obj)).FEAE.abortAnimation();
        if (dG != null)
        {
            obj = dG;
        }
    }

    private void _mth1D31()
    {
        boolean flag1 = false;
        if (dW != null)
        {
            flag1 = dW._mth13A5();
        }
        boolean flag = flag1;
        if (dX != null)
        {
            flag = flag1 | dX._mth13A5();
        }
        flag1 = flag;
        if (dY != null)
        {
            flag1 = flag | dY._mth13A5();
        }
        flag = flag1;
        if (dZ != null)
        {
            flag = flag1 | dZ._mth13A5();
        }
        if (flag)
        {
            FE70._mth1FBE(this);
        }
    }

    private void _mth1D45()
    {
        int i = dQ;
        dQ = 0;
        if (i != 0 && dT != null && dT.isEnabled())
        {
            AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain();
            accessibilityevent.setEventType(2048);
            _cls020B._mth02CA(accessibilityevent, i);
            sendAccessibilityEventUnchecked(accessibilityevent);
        }
    }

    private void _mth1D49()
    {
        boolean flag1;
label0:
        {
label1:
            {
                if (dU)
                {
                    FB1F fb1f = dB;
                    fb1f._mth02CB(fb1f.s);
                    fb1f._mth02CB(fb1f.t);
                    _mth1ECA();
                }
                if (ea != null && dG._mth0407())
                {
                    dB._mth05D6();
                } else
                {
                    dB._mth05E0();
                }
                if ((!em || en) && !em)
                {
                    if (!en)
                    {
                        break label1;
                    }
                    boolean flag;
                    if (ea != null && ea.eG)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                }
                flag1 = true;
                break label0;
            }
            flag1 = false;
        }
        con con1;
        boolean flag3;
label2:
        {
            con1 = ek;
            if (dN && ea != null && (dU || flag1 || _cls02BB._mth02CA(dG)) && (!dU || dF.ez))
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            con1.fs = flag3;
            con1 = ek;
            if (ek.fs && flag1 && !dU)
            {
                boolean flag2;
                if (ea != null && dG._mth0407())
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (flag2)
                {
                    flag3 = true;
                    break label2;
                }
            }
            flag3 = false;
        }
        con1.ft = flag3;
    }

    private void _mth1D6A()
    {
        int j = dC.aF.getChildCount();
        for (int i = 0; i < j; i++)
        {
            Object obj = dC.aF.getChildAt(i);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
            }
            boolean flag;
            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && ((_cls02CC) (obj)).fz == -1)
            {
                obj.fz = ((_cls02CC) (obj)).bX;
            }
        }

    }

    private void _mth1E2F()
    {
        int k1 = dC.aF.getChildCount();
        for (int i = 0; i < k1; i++)
        {
            Object obj = dC.aF.getChildAt(i);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
            }
            boolean flag;
            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                obj.fz = -1;
                obj.fC = -1;
            }
        }

        _cls1FBE _lcls1fbe = dz;
        int i1 = _lcls1fbe.eS.size();
        for (int j = 0; j < i1; j++)
        {
            _cls02CC _lcls02cc = (_cls02CC)_lcls1fbe.eS.get(j);
            _lcls02cc.fz = -1;
            _lcls02cc.fC = -1;
        }

        i1 = _lcls1fbe.eQ.size();
        for (int k = 0; k < i1; k++)
        {
            _cls02CC _lcls02cc1 = (_cls02CC)_lcls1fbe.eQ.get(k);
            _lcls02cc1.fz = -1;
            _lcls02cc1.fC = -1;
        }

        if (_lcls1fbe.eR != null)
        {
            int j1 = _lcls1fbe.eR.size();
            for (int l = 0; l < j1; l++)
            {
                _cls02CC _lcls02cc2 = (_cls02CC)_lcls1fbe.eR.get(l);
                _lcls02cc2.fz = -1;
                _lcls02cc2.fC = -1;
            }

        }
    }

    private void _mth1ECA()
    {
        int j = dC.aF.getChildCount();
        for (int i = 0; i < j; i++)
        {
            Object obj = dC.aF.getChildAt(i);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
            }
            if (obj == null)
            {
                continue;
            }
            boolean flag;
            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                obj._fld0E20 = ((_cls02CC) (obj))._fld0E20 | 6;
            }
        }

        _mth1D61();
        dz._mth1ECA();
    }

    static Interpolator _mth1ECB()
    {
        return ew;
    }

    static ArrayList _mth1FBE(RecyclerView recyclerview)
    {
        return recyclerview.dI;
    }

    static boolean _mth309D()
    {
        return dw;
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        super.addFocusables(arraylist, i, j);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof _cls02BC) && _cls02BB._mth02CA((_cls02BC)layoutparams);
    }

    public int computeHorizontalScrollExtent()
    {
        if (dG._mth026A())
        {
            return dG._mth02CE(ek);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollOffset()
    {
        if (dG._mth026A())
        {
            return dG._mth02CA(ek);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollRange()
    {
        if (dG._mth026A())
        {
            return dG._mth141D(ek);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollExtent()
    {
        if (dG._mth027E())
        {
            return dG._mth02CF(ek);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollOffset()
    {
        if (dG._mth027E())
        {
            return dG._mth02CB(ek);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollRange()
    {
        if (dG._mth027E())
        {
            return dG._mth02BB(ek);
        } else
        {
            return 0;
        }
    }

    public boolean dispatchNestedFling(float f, float f1, boolean flag)
    {
        return et.dispatchNestedFling(f, f1, flag);
    }

    public boolean dispatchNestedPreFling(float f, float f1)
    {
        _cls1D64 _lcls1d64 = et;
        if (_lcls1d64._fld1E5B && _lcls1d64._fld1E59 != null)
        {
            return _cls14D2._mth02CA(_lcls1d64._fld1E59, _lcls1d64.mView, f, f1);
        } else
        {
            return false;
        }
    }

    public boolean dispatchNestedPreScroll(int i, int j, int ai[], int ai1[])
    {
        return et.dispatchNestedPreScroll(i, j, ai, ai1);
    }

    public boolean dispatchNestedScroll(int i, int j, int k, int l, int ai[])
    {
        return et.dispatchNestedScroll(i, j, k, l, ai);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int k = dI.size();
        for (int i = 0; i < k; i++)
        {
            dI.get(i);
        }

        int j = 0;
        k = j;
        if (dW != null)
        {
            k = j;
            if (!dW.isFinished())
            {
                int l = canvas.save();
                if (dD)
                {
                    j = getPaddingBottom();
                } else
                {
                    j = 0;
                }
                canvas.rotate(270F);
                canvas.translate(-getHeight() + j, 0.0F);
                if (dW != null && dW.draw(canvas))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                canvas.restoreToCount(l);
            }
        }
        j = k;
        if (dX != null)
        {
            j = k;
            if (!dX.isFinished())
            {
                int i1 = canvas.save();
                if (dD)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (dX != null && dX.draw(canvas))
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                j = k | j;
                canvas.restoreToCount(i1);
            }
        }
        k = j;
        if (dY != null)
        {
            k = j;
            if (!dY.isFinished())
            {
                int j1 = canvas.save();
                int l1 = getWidth();
                if (dD)
                {
                    k = getPaddingTop();
                } else
                {
                    k = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-k, -l1);
                if (dY != null && dY.draw(canvas))
                {
                    k = 1;
                } else
                {
                    k = 0;
                }
                k = j | k;
                canvas.restoreToCount(j1);
            }
        }
        j = k;
        if (dZ != null)
        {
            j = k;
            if (!dZ.isFinished())
            {
                int k1 = canvas.save();
                canvas.rotate(180F);
                if (dD)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                if (dZ != null && dZ.draw(canvas))
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                j = k | j;
                canvas.restoreToCount(k1);
            }
        }
        k = j;
        if (j == 0)
        {
            k = j;
            if (ea != null)
            {
                k = j;
                if (dI.size() > 0)
                {
                    k = j;
                    if (ea.isRunning())
                    {
                        k = 1;
                    }
                }
            }
        }
        if (k != 0)
        {
            FE70._mth1FBE(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l)
    {
        return super.drawChild(canvas, view, l);
    }

    public View focusSearch(View view, int i)
    {
        View view2 = FocusFinder.getInstance().findNextFocus(this, view, i);
        View view1 = view2;
        if (view2 == null)
        {
            view1 = view2;
            if (dF != null)
            {
                view1 = view2;
                if (dG != null)
                {
                    if (!dO)
                    {
                        dO = true;
                        dP = false;
                    }
                    view1 = dG._mth02CF(i, dz, ek);
                    _mth2071(false);
                }
            }
        }
        if (view1 != null)
        {
            return view1;
        } else
        {
            return super.focusSearch(view, i);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (dG == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return dG._mth020B();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (dG == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return _cls02BB._mth02CA(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (dG == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return _cls02BB._mth02CE(layoutparams);
        }
    }

    public int getBaseline()
    {
        if (dG != null)
        {
            return -1;
        } else
        {
            return super.getBaseline();
        }
    }

    protected int getChildDrawingOrder(int i, int j)
    {
        if (er == null)
        {
            return super.getChildDrawingOrder(i, j);
        } else
        {
            return er._mth02BD();
        }
    }

    public boolean hasNestedScrollingParent()
    {
        return et._fld1E59 != null;
    }

    public boolean isAttachedToWindow()
    {
        return dL;
    }

    public boolean isNestedScrollingEnabled()
    {
        return et._fld1E5B;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        dV = 0;
        dL = true;
        dN = false;
        if (dG != null)
        {
            dG.j = true;
        }
        ep = false;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (ea != null)
        {
            ea.FF68();
        }
        dN = false;
        _mth1D2C();
        dL = false;
        if (dG != null)
        {
            _cls02BB _lcls02bb = dG;
            _cls1FBE _lcls1fbe = dz;
            _lcls02bb.j = false;
            _lcls02bb._mth02CA(this, _lcls1fbe);
        }
        removeCallbacks(ev);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j = dI.size();
        for (int i = 0; i < j; i++)
        {
            dI.get(i);
        }

    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
label0:
        {
            float f;
            float f1;
            float f2;
label1:
            {
                if (dG == null)
                {
                    return false;
                }
                if ((_cls153E._mth02CF(motionevent) & 2) == 0 || motionevent.getAction() != 8)
                {
                    break label0;
                }
                if (dG._mth027E())
                {
                    f = _cls153E._mth141D(motionevent, 9);
                } else
                {
                    f = 0.0F;
                }
                if (dG._mth026A())
                {
                    f1 = _cls153E._mth141D(motionevent, 10);
                } else
                {
                    f1 = 0.0F;
                }
                if (f == 0.0F && f1 == 0.0F)
                {
                    break label0;
                }
                if (ei == 1.401298E-45F)
                {
                    motionevent = new TypedValue();
                    if (getContext().getTheme().resolveAttribute(0x101004d, motionevent, true))
                    {
                        ei = motionevent.getDimension(getContext().getResources().getDisplayMetrics());
                    } else
                    {
                        f2 = 0.0F;
                        break label1;
                    }
                }
                f2 = ei;
            }
            scrollBy((int)(f1 * f2), (int)(f * f2));
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        if (i == 3 || i == 0)
        {
            dK = null;
        }
        int k = dJ.size();
        for (i = 0; i < k; i++)
        {
            ((_cls02BD)dJ.get(i))._mth1428(this);
        }

        boolean flag = dG._mth026A();
        boolean flag1 = dG._mth027E();
        if (_fld14EF == null)
        {
            _fld14EF = VelocityTracker.obtain();
        }
        _fld14EF.addMovement(motionevent);
        k = _cls153E._mth02CA(motionevent);
        i = _cls153E._mth02CB(motionevent);
        switch (k)
        {
        case 0: // '\0'
            eb = _cls153E._mth02CB(motionevent, 0);
            i = (int)(motionevent.getX() + 0.5F);
            ee = i;
            ec = i;
            i = (int)(motionevent.getY() + 0.5F);
            ef = i;
            ed = i;
            if (FB1F == 2)
            {
                getParent().requestDisallowInterceptTouchEvent(true);
                _mth02C9(1);
            }
            i = 0;
            if (flag)
            {
                i = 1;
            }
            int l = i;
            if (flag1)
            {
                l = i | 2;
            }
            startNestedScroll(l);
            break;

        case 5: // '\005'
            eb = _cls153E._mth02CB(motionevent, i);
            int i1 = (int)(_cls153E._mth02CE(motionevent, i) + 0.5F);
            ee = i1;
            ec = i1;
            i = (int)(_cls153E._mth02CF(motionevent, i) + 0.5F);
            ef = i;
            ed = i;
            break;

        case 2: // '\002'
            int j1 = _cls153E._mth02CA(motionevent, eb);
            if (j1 < 0)
            {
                Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(eb).append(" not found. Did any MotionEvents get skipped?").toString());
                return false;
            }
            int j = (int)(_cls153E._mth02CE(motionevent, j1) + 0.5F);
            j1 = (int)(_cls153E._mth02CF(motionevent, j1) + 0.5F);
            if (FB1F != 1)
            {
                int l1 = j - ec;
                int k1 = j1 - ed;
                j1 = 0;
                j = j1;
                if (flag)
                {
                    j = j1;
                    if (Math.abs(l1) > _fld0EC0)
                    {
                        j1 = ec;
                        int j2 = _fld0EC0;
                        if (l1 < 0)
                        {
                            j = -1;
                        } else
                        {
                            j = 1;
                        }
                        ee = j1 + j2 * j;
                        j = 1;
                    }
                }
                j1 = j;
                if (flag1)
                {
                    j1 = j;
                    if (Math.abs(k1) > _fld0EC0)
                    {
                        j1 = ed;
                        int i2 = _fld0EC0;
                        byte byte0;
                        if (k1 < 0)
                        {
                            byte0 = -1;
                        } else
                        {
                            byte0 = 1;
                        }
                        ef = j1 + i2 * byte0;
                        j1 = 1;
                    }
                }
                if (j1 != 0)
                {
                    _mth02C9(1);
                }
            }
            break;

        case 6: // '\006'
            _mth037A(motionevent);
            break;

        case 1: // '\001'
            _fld14EF.clear();
            stopNestedScroll();
            break;

        case 3: // '\003'
            if (_fld14EF != null)
            {
                _fld14EF.clear();
            }
            stopNestedScroll();
            _mth1D31();
            _mth02C9(0);
            break;
        }
        return FB1F == 1;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (!dO)
        {
            dO = true;
            dP = false;
        }
        _cls02B8.beginSection("RV OnLayout");
        _mth1D4A();
        _cls02B8.endSection();
        _mth2071(false);
        dN = true;
    }

    protected void onMeasure(int i, int j)
    {
        if (dR)
        {
            if (!dO)
            {
                dO = true;
                dP = false;
            }
            _mth1D49();
            if (ek.ft)
            {
                ek.fr = true;
            } else
            {
                dB._mth05E0();
                ek.fr = false;
            }
            dR = false;
            _mth2071(false);
        }
        if (dF != null)
        {
            ek.fn = dF.getItemCount();
        } else
        {
            ek.fn = 0;
        }
        if (dG == null)
        {
            _mth05D9(i, j);
        } else
        {
            dG._mth02CB(dz, ek, i, j);
        }
        ek.fr = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        dA = (SavedState)parcelable;
        super.onRestoreInstanceState(dA.getSuperState());
        if (dG != null && dA.eY != null)
        {
            dG.onRestoreInstanceState(dA.eY);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (dA != null)
        {
            SavedState._mth02CA(savedstate, dA);
            return savedstate;
        }
        if (dG != null)
        {
            savedstate.eY = dG._mth0268();
            return savedstate;
        } else
        {
            savedstate.eY = null;
            return savedstate;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i != k || j != l)
        {
            dZ = null;
            dX = null;
            dY = null;
            dW = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        MotionEvent motionevent1;
        int i;
        int k;
        boolean flag1;
        boolean flag2;
label0:
        {
            i = motionevent.getAction();
            if (dK != null)
            {
                if (i == 0)
                {
                    dK = null;
                } else
                {
                    if (i == 3 || i == 1)
                    {
                        dK = null;
                    }
                    i = 1;
                    break label0;
                }
            }
            if (i != 0)
            {
                int j = dJ.size();
                for (i = 0; i < j; i++)
                {
                    ((_cls02BD)dJ.get(i))._mth1428(this);
                }

            }
            i = 0;
        }
        if (i != 0)
        {
            if (_fld14EF != null)
            {
                _fld14EF.clear();
            }
            stopNestedScroll();
            _mth1D31();
            _mth02C9(0);
            return true;
        }
        flag1 = dG._mth026A();
        flag2 = dG._mth027E();
        if (_fld14EF == null)
        {
            _fld14EF = VelocityTracker.obtain();
        }
        _fld14EF.addMovement(motionevent);
        motionevent1 = MotionEvent.obtain(motionevent);
        k = _cls153E._mth02CA(motionevent);
        i = _cls153E._mth02CB(motionevent);
        if (k == 0)
        {
            int ai[] = eu;
            eu[1] = 0;
            ai[0] = 0;
        }
        motionevent1.offsetLocation(eu[0], eu[1]);
        k;
        JVM INSTR tableswitch 0 6: default 284
    //                   0 287
    //                   1 902
    //                   2 441
    //                   3 1252
    //                   4 1279
    //                   5 378
    //                   6 894;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        eb = _cls153E._mth02CB(motionevent, 0);
        i = (int)(motionevent.getX() + 0.5F);
        ee = i;
        ec = i;
        i = (int)(motionevent.getY() + 0.5F);
        ef = i;
        ed = i;
        i = 0;
        if (flag1)
        {
            i = 1;
        }
        k = i;
        if (flag2)
        {
            k = i | 2;
        }
        startNestedScroll(k);
        break; /* Loop/switch isn't completed */
_L6:
        eb = _cls153E._mth02CB(motionevent, i);
        k = (int)(_cls153E._mth02CE(motionevent, i) + 0.5F);
        ee = k;
        ec = k;
        i = (int)(_cls153E._mth02CF(motionevent, i) + 0.5F);
        ef = i;
        ed = i;
        break; /* Loop/switch isn't completed */
_L4:
        i = _cls153E._mth02CA(motionevent, eb);
        if (i < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(eb).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        int j2 = (int)(_cls153E._mth02CE(motionevent, i) + 0.5F);
        int k2 = (int)(_cls153E._mth02CF(motionevent, i) + 0.5F);
        int k1 = ee - j2;
        int l = ef - k2;
        k = k1;
        i = l;
        if (dispatchNestedPreScroll(k1, l, _fld0138, _fld0135))
        {
            k = k1 - _fld0138[0];
            i = l - _fld0138[1];
            motionevent1.offsetLocation(_fld0135[0], _fld0135[1]);
            motionevent = eu;
            motionevent[0] = motionevent[0] + _fld0135[0];
            motionevent = eu;
            motionevent[1] = motionevent[1] + _fld0135[1];
        }
        int l1 = k;
        k1 = i;
        if (FB1F != 1)
        {
            l1 = 0;
            int i1 = k;
            k1 = l1;
            if (flag1)
            {
                i1 = k;
                k1 = l1;
                if (Math.abs(k) > _fld0EC0)
                {
                    if (k > 0)
                    {
                        i1 = k - _fld0EC0;
                    } else
                    {
                        i1 = k + _fld0EC0;
                    }
                    k1 = 1;
                }
            }
            k = i;
            int i2 = k1;
            if (flag2)
            {
                k = i;
                i2 = k1;
                if (Math.abs(i) > _fld0EC0)
                {
                    if (i > 0)
                    {
                        k = i - _fld0EC0;
                    } else
                    {
                        k = i + _fld0EC0;
                    }
                    i2 = 1;
                }
            }
            l1 = i1;
            k1 = k;
            if (i2 != 0)
            {
                _mth02C9(1);
                k1 = k;
                l1 = i1;
            }
        }
        if (FB1F != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        ee = j2 - _fld0135[0];
        ef = k2 - _fld0135[1];
        if (flag1)
        {
            i = l1;
        } else
        {
            i = 0;
        }
        if (!flag2)
        {
            k1 = 0;
        }
        if (_mth02CA(i, k1, motionevent1))
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        break; /* Loop/switch isn't completed */
_L7:
        _mth037A(motionevent);
        break; /* Loop/switch isn't completed */
_L3:
        float f;
        float f1;
        _fld14EF.computeCurrentVelocity(1000, eh);
        if (flag1)
        {
            f = -FBE9._mth02CA(_fld14EF, eb);
        } else
        {
            f = 0.0F;
        }
        if (flag2)
        {
            f1 = -FBE9._mth02CB(_fld14EF, eb);
        } else
        {
            f1 = 0.0F;
        }
        if (f == 0.0F && f1 == 0.0F) goto _L9; else goto _L8
_L8:
        int j1;
        k = (int)f;
        j1 = (int)f1;
        if (dG != null) goto _L11; else goto _L10
_L10:
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
          goto _L12
_L11:
        flag1 = dG._mth026A();
        flag2 = dG._mth027E();
        if (!flag1) goto _L14; else goto _L13
_L13:
        i = k;
        if (Math.abs(k) >= eg) goto _L15; else goto _L14
_L14:
        i = 0;
_L15:
        if (!flag2) goto _L17; else goto _L16
_L16:
        k = j1;
        if (Math.abs(j1) >= eg) goto _L18; else goto _L17
_L17:
        k = 0;
_L18:
        if (i == 0 && k == 0 || dispatchNestedPreFling(i, k)) goto _L12; else goto _L19
_L19:
        if (flag1 || flag2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        dispatchNestedFling(i, k, flag1);
        if (!flag1) goto _L12; else goto _L20
_L20:
        boolean flag;
        i = Math.max(-eh, Math.min(i, eh));
        k = Math.max(-eh, Math.min(k, eh));
        motionevent = ej;
        ((_cls02C9) (motionevent)).ex._mth02C9(2);
        motionevent.fv = 0;
        motionevent.fu = 0;
        ((_cls02C9) (motionevent)).FEAE.fling(0, 0, i, k, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
        motionevent.FB40();
        flag = true;
          goto _L21
_L12:
        flag = false;
_L21:
        if (flag) goto _L22; else goto _L9
_L9:
        _mth02C9(0);
_L22:
        _fld14EF.clear();
        _mth1D31();
        break; /* Loop/switch isn't completed */
_L5:
        if (_fld14EF != null)
        {
            _fld14EF.clear();
        }
        stopNestedScroll();
        _mth1D31();
        _mth02C9(0);
        motionevent1.recycle();
        return true;
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        _cls02CC _lcls02cc;
        if (view == null)
        {
            _lcls02cc = null;
        } else
        {
            _lcls02cc = ((_cls02BC)view.getLayoutParams()).eJ;
        }
        if (_lcls02cc != null)
        {
            boolean flag1;
            if ((_lcls02cc._fld0E20 & 0x100) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                _lcls02cc._fld0E20 = _lcls02cc._fld0E20 & 0xfffffeff;
            } else
            {
                boolean flag2;
                if ((_lcls02cc._fld0E20 & 0x80) != 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!flag2)
                {
                    throw new IllegalArgumentException((new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.")).append(_lcls02cc).toString());
                }
            }
        }
        if (view != null)
        {
            _lcls02cc = ((_cls02BC)view.getLayoutParams()).eJ;
        }
        super.removeDetachedView(view, flag);
    }

    public void requestChildFocus(View view, View view1)
    {
        _cls02BB _lcls02bb = dG;
        boolean flag;
        if (dV > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && view1 != null)
        {
            _fld01C0.set(0, 0, view1.getWidth(), view1.getHeight());
            Object obj = view1.getLayoutParams();
            if (obj instanceof _cls02BC)
            {
                obj = (_cls02BC)obj;
                if (!((_cls02BC) (obj)).eL)
                {
                    obj = ((_cls02BC) (obj)).eK;
                    Rect rect = _fld01C0;
                    rect.left = rect.left - ((Rect) (obj)).left;
                    rect = _fld01C0;
                    rect.right = rect.right + ((Rect) (obj)).right;
                    rect = _fld01C0;
                    rect.top = rect.top - ((Rect) (obj)).top;
                    rect = _fld01C0;
                    rect.bottom = rect.bottom + ((Rect) (obj)).bottom;
                }
            }
            offsetDescendantRectToMyCoords(view1, _fld01C0);
            offsetRectIntoDescendantCoords(view, _fld01C0);
            obj = _fld01C0;
            boolean flag1;
            if (!dN)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            requestChildRectangleOnScreen(view, ((Rect) (obj)), flag1);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        _cls02BB _lcls02bb = dG;
        int i;
        if (_lcls02bb.eH != null)
        {
            i = _lcls02bb.eH.getPaddingLeft();
        } else
        {
            i = 0;
        }
        int j;
        if (_lcls02bb.eH != null)
        {
            j = _lcls02bb.eH.getPaddingTop();
        } else
        {
            j = 0;
        }
        int k;
        if (_lcls02bb.eH != null)
        {
            k = _lcls02bb.eH.getWidth();
        } else
        {
            k = 0;
        }
        int i1;
        if (_lcls02bb.eH != null)
        {
            i1 = _lcls02bb.eH.getPaddingRight();
        } else
        {
            i1 = 0;
        }
        int k3 = k - i1;
        if (_lcls02bb.eH != null)
        {
            k = _lcls02bb.eH.getHeight();
        } else
        {
            k = 0;
        }
        if (_lcls02bb.eH != null)
        {
            i1 = _lcls02bb.eH.getPaddingBottom();
        } else
        {
            i1 = 0;
        }
        int i4 = view.getLeft() + rect.left;
        int i3 = view.getTop() + rect.top;
        int j4 = i4 + rect.width();
        int k4 = rect.height();
        int i2 = Math.min(0, i4 - i);
        int k1 = Math.min(0, i3 - j);
        int k2 = Math.max(0, j4 - k3);
        k = Math.max(0, (i3 + k4) - (k - i1));
        if (FE70._mth02C9(_lcls02bb.eH) == 1)
        {
            if (k2 != 0)
            {
                i = k2;
            } else
            {
                i = Math.max(i2, j4 - k3);
            }
        } else
        if (i2 != 0)
        {
            i = i2;
        } else
        {
            i = Math.min(i4 - i, k2);
        }
        if (k1 != 0)
        {
            j = k1;
        } else
        {
            j = Math.min(i3 - j, k);
        }
        if (i != 0 || j != 0)
        {
            if (flag)
            {
                scrollBy(i, j);
            } else
            if (dG == null)
            {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else
            {
                if (!dG._mth026A())
                {
                    i = 0;
                }
                if (!dG._mth027E())
                {
                    j = 0;
                }
                if (i != 0 || j != 0)
                {
                    view = ej;
                    int l1 = Math.abs(i);
                    int j2 = Math.abs(j);
                    boolean flag1;
                    if (l1 > j2)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    int l2 = (int)Math.sqrt(0.0D);
                    int j3 = (int)Math.sqrt(i * i + j * j);
                    int l;
                    if (flag1)
                    {
                        l = ((_cls02C9) (view)).ex.getWidth();
                    } else
                    {
                        l = ((_cls02C9) (view)).ex.getHeight();
                    }
                    int l3 = l / 2;
                    float f2 = Math.min(1.0F, ((float)j3 * 1.0F) / (float)l);
                    float f = l3;
                    float f1 = l3;
                    f2 = FloatMath.sin((float)((double)(f2 - 0.5F) * 0.4712389167638204D));
                    if (l2 > 0)
                    {
                        l = Math.round(Math.abs((f + f1 * f2) / (float)l2) * 1000F) * 4;
                    } else
                    {
                        int j1;
                        if (flag1)
                        {
                            j1 = l1;
                        } else
                        {
                            j1 = j2;
                        }
                        l = (int)(((float)j1 / (float)l + 1.0F) * 300F);
                    }
                    l = Math.min(l, 2000);
                    rect = ew;
                    if (((_cls02C9) (view)).mInterpolator != rect)
                    {
                        view.mInterpolator = rect;
                        view.FEAE = FB61._mth02CA(((_cls02C9) (view)).ex.getContext(), rect);
                    }
                    ((_cls02C9) (view)).ex._mth02C9(2);
                    view.fv = 0;
                    view.fu = 0;
                    ((_cls02C9) (view)).FEAE.startScroll(0, 0, i, j, l);
                    view.FB40();
                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        int j = dJ.size();
        for (int i = 0; i < j; i++)
        {
            dJ.get(i);
        }

        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!dO)
        {
            super.requestLayout();
            return;
        } else
        {
            dP = true;
            return;
        }
    }

    public void scrollBy(int i, int j)
    {
        if (dG == null)
        {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        boolean flag = dG._mth026A();
        boolean flag1 = dG._mth027E();
        if (flag || flag1)
        {
            if (!flag)
            {
                i = 0;
            }
            if (!flag1)
            {
                j = 0;
            }
            _mth02CA(i, j, ((MotionEvent) (null)));
        }
    }

    public void scrollTo(int i, int j)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent)
    {
        boolean flag;
        if (dV > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            int i = 0;
            if (accessibilityevent != null)
            {
                i = _cls020B._mth02CB(accessibilityevent);
            }
            int j = i;
            if (i == 0)
            {
                j = 0;
            }
            dQ = dQ | j;
            i = 1;
        } else
        {
            i = 0;
        }
        if (i)
        {
            return;
        } else
        {
            super.sendAccessibilityEventUnchecked(accessibilityevent);
            return;
        }
    }

    public void setAccessibilityDelegateCompat(FEE3 fee3)
    {
        eq = fee3;
        FE70._mth02CA(this, eq);
    }

    public void setAdapter(if if1)
    {
        if (dF != null)
        {
            if if2 = dF;
            _cls02BE _lcls02be = dy;
            if2.ey.unregisterObserver(_lcls02be);
        }
        if (ea != null)
        {
            ea.FF68();
        }
        if (dG != null)
        {
            _cls02BB _lcls02bb = dG;
            _cls1FBE _lcls1fbe = dz;
            int i;
            if (_lcls02bb.dC != null)
            {
                _cls0690 _lcls0690 = _lcls02bb.dC;
                i = _lcls0690.aF.getChildCount() - _lcls0690.aH.size();
            } else
            {
                i = 0;
            }
            for (i--; i >= 0; i--)
            {
                Object obj;
                if (_lcls02bb.dC != null)
                {
                    obj = _lcls02bb.dC;
                    int j = ((_cls0690) (obj)).FB1D(i);
                    obj = ((_cls0690) (obj)).aF.getChildAt(j);
                } else
                {
                    obj = null;
                }
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
                }
                boolean flag;
                if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    continue;
                }
                if (_lcls02bb.dC != null)
                {
                    obj = _lcls02bb.dC;
                    int k = ((_cls0690) (obj)).FB1D(i);
                    obj = ((_cls0690) (obj)).aF.getChildAt(k);
                } else
                {
                    obj = null;
                }
                Object obj2;
                if (_lcls02bb.dC != null)
                {
                    obj2 = _lcls02bb.dC;
                    int l = ((_cls0690) (obj2)).FB1D(i);
                    obj2 = ((_cls0690) (obj2)).aF.getChildAt(l);
                } else
                {
                    obj2 = null;
                }
                if (obj2 != null)
                {
                    _lcls02bb.dC.removeViewAt(i);
                }
                _lcls1fbe._mth02D0(((View) (obj)));
            }

            dG._mth02CB(dz);
        }
        Object obj1 = dz;
        ((_cls1FBE) (obj1)).eQ.clear();
        ((_cls1FBE) (obj1))._mth4E00();
        obj1 = dB;
        ((FB1F) (obj1))._mth02CB(((FB1F) (obj1)).s);
        ((FB1F) (obj1))._mth02CB(((FB1F) (obj1)).t);
        obj1 = dF;
        dF = if1;
        if (if1 != null)
        {
            _cls02BE _lcls02be1 = dy;
            if1.ey.registerObserver(_lcls02be1);
        }
        Object obj3 = dz;
        if1 = dF;
        ((_cls1FBE) (obj3)).eQ.clear();
        ((_cls1FBE) (obj3))._mth4E00();
        if (((_cls1FBE) (obj3)).eV == null)
        {
            obj3.eV = new _cls037A();
        }
        obj3 = ((_cls1FBE) (obj3)).eV;
        if (obj1 != null)
        {
            obj3.eP = ((_cls037A) (obj3)).eP - 1;
        }
        if (true && ((_cls037A) (obj3)).eP == 0)
        {
            ((_cls037A) (obj3)).eN.clear();
        }
        if (if1 != null)
        {
            obj3.eP = ((_cls037A) (obj3)).eP + 1;
        }
        ek.fq = true;
        _mth1ECA();
        requestLayout();
    }

    public void setChildDrawingOrderCallback$65aef0ea(o._cls1427.if if1)
    {
        if (if1 == er)
        {
            return;
        }
        er = if1;
        boolean flag;
        if (er != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChildrenDrawingOrderEnabled(flag);
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != dD)
        {
            dZ = null;
            dX = null;
            dY = null;
            dW = null;
        }
        dD = flag;
        super.setClipToPadding(flag);
        if (dN)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        dM = flag;
    }

    public void setItemAnimator(_cls02CE _pcls02ce)
    {
        if (ea != null)
        {
            ea.FF68();
            ea.eA = null;
        }
        ea = _pcls02ce;
        if (ea != null)
        {
            ea.eA = eo;
        }
    }

    public void setItemViewCacheSize(int i)
    {
        _cls1FBE _lcls1fbe = dz;
        _lcls1fbe.eU = i;
        for (int j = _lcls1fbe.eS.size() - 1; j >= 0 && _lcls1fbe.eS.size() > i; j--)
        {
            _cls02CC _lcls02cc = (_cls02CC)_lcls1fbe.eS.get(j);
            FE70._mth02CA(_lcls02cc.fy, null);
            _lcls1fbe._mth02CC(_lcls02cc);
            _lcls02cc.fH = null;
            if (_lcls1fbe.eV == null)
            {
                _lcls1fbe.eV = new _cls037A();
            }
            _lcls1fbe.eV._mth1FBE(_lcls02cc);
            _lcls1fbe.eS.remove(j);
        }

    }

    public void setLayoutManager(_cls02BB _pcls02bb)
    {
        if (_pcls02bb == dG)
        {
            return;
        }
        if (dG != null)
        {
            if (dL)
            {
                _cls02BB _lcls02bb = dG;
                _cls1FBE _lcls1fbe = dz;
                _lcls02bb.j = false;
                _lcls02bb._mth02CA(this, _lcls1fbe);
            }
            _cls02BB _lcls02bb1 = dG;
            _lcls02bb1.eH = null;
            _lcls02bb1.dC = null;
        }
        Object obj = dz;
        ((_cls1FBE) (obj)).eQ.clear();
        ((_cls1FBE) (obj))._mth4E00();
        obj = dC;
        o._cls0690.if if1 = ((_cls0690) (obj)).aG;
        if1.aI = 0L;
        if (if1.aJ != null)
        {
            if1.aJ.reset();
        }
        ((_cls0690) (obj)).aH.clear();
        ((_cls0690) (obj)).aF.removeAllViews();
        dG = _pcls02bb;
        if (_pcls02bb != null)
        {
            if (_pcls02bb.eH != null)
            {
                throw new IllegalArgumentException((new StringBuilder("LayoutManager ")).append(_pcls02bb).append(" is already attached to a RecyclerView: ").append(_pcls02bb.eH).toString());
            }
            _pcls02bb = dG;
            if (this == null)
            {
                _pcls02bb.eH = null;
                _pcls02bb.dC = null;
            } else
            {
                _pcls02bb.eH = this;
                _pcls02bb.dC = dC;
            }
            if (dL)
            {
                dG.j = true;
            }
        }
        requestLayout();
    }

    public void setNestedScrollingEnabled(boolean flag)
    {
        _cls1D64 _lcls1d64 = et;
        if (_lcls1d64._fld1E5B)
        {
            FE70._mth1D35(_lcls1d64.mView);
        }
        _lcls1d64._fld1E5B = flag;
    }

    public void setOnScrollListener$60a02a29(FE77 fe77)
    {
        el = fe77;
    }

    public void setRecycledViewPool(_cls037A _pcls037a)
    {
        _cls1FBE _lcls1fbe = dz;
        if (_lcls1fbe.eV != null)
        {
            _cls037A _lcls037a = _lcls1fbe.eV;
            _lcls037a.eP = _lcls037a.eP - 1;
        }
        _lcls1fbe.eV = _pcls037a;
        if (_pcls037a != null)
        {
            _pcls037a = _lcls1fbe.eV;
            _pcls037a.eP = _pcls037a.eP + 1;
        }
    }

    public void setRecyclerListener$cc56996(o._cls1427.if if1)
    {
        dH = if1;
    }

    public void setScrollingTouchSlop(int i)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (i)
        {
        default:
            Log.w("RecyclerView", (new StringBuilder("setScrollingTouchSlop(): bad argument constant ")).append(i).append("; using default value").toString());
            // fall through

        case 0: // '\0'
            _fld0EC0 = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            _fld0EC0 = _cls05E8._mth02CA(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(_cls02C8 _pcls02c8)
    {
        dz.eW = _pcls02c8;
    }

    public boolean startNestedScroll(int i)
    {
        return et.startNestedScroll(i);
    }

    public void stopNestedScroll()
    {
        _cls1D64 _lcls1d64 = et;
        if (_lcls1d64._fld1E59 != null)
        {
            _cls14D2._mth02CA(_lcls1d64._fld1E59, _lcls1d64.mView);
            _lcls1d64._fld1E59 = null;
        }
    }

    public final void _mth02CA(int i, int j, boolean flag)
    {
        int j1 = dC.aF.getChildCount();
        for (int k = 0; k < j1; k++)
        {
            Object obj = dC.aF.getChildAt(k);
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
            }
            if (obj == null)
            {
                continue;
            }
            boolean flag1;
            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                continue;
            }
            if (((_cls02CC) (obj)).bX >= i + j)
            {
                ((_cls02CC) (obj))._mth02BC(-j, flag);
                ek.fq = true;
                continue;
            }
            if (((_cls02CC) (obj)).bX >= i)
            {
                int i1 = -j;
                obj._fld0E20 = ((_cls02CC) (obj))._fld0E20 | 8;
                ((_cls02CC) (obj))._mth02BC(i1, flag);
                obj.bX = i - 1;
                ek.fq = true;
            }
        }

        _cls1FBE _lcls1fbe = dz;
        for (int l = _lcls1fbe.eS.size() - 1; l >= 0; l--)
        {
            _cls02CC _lcls02cc = (_cls02CC)_lcls1fbe.eS.get(l);
            if (_lcls02cc == null)
            {
                continue;
            }
            if (_lcls02cc.getLayoutPosition() >= i + j)
            {
                _lcls02cc._mth02BC(-j, flag);
                continue;
            }
            if (_lcls02cc.getLayoutPosition() < i)
            {
                continue;
            }
            _lcls02cc._fld0E20 = _lcls02cc._fld0E20 | 8;
            _lcls02cc = (_cls02CC)_lcls1fbe.eS.get(l);
            FE70._mth02CA(_lcls02cc.fy, null);
            _lcls1fbe._mth02CC(_lcls02cc);
            _lcls02cc.fH = null;
            if (_lcls1fbe.eV == null)
            {
                _lcls1fbe.eV = new _cls037A();
            }
            _lcls1fbe.eV._mth1FBE(_lcls02cc);
            _lcls1fbe.eS.remove(l);
        }

        requestLayout();
    }

    public final void _mth02CA(aux aux1)
    {
        if (dG != null)
        {
            dG._mth1FBE("Cannot add item decoration during a scroll  or layout");
        }
        if (dI.isEmpty())
        {
            setWillNotDraw(false);
        }
        dI.add(aux1);
        _mth1D61();
        requestLayout();
    }

    public final void _mth1507(int i)
    {
        _mth02C9(0);
        Object obj = ej;
        ((_cls02C9) (obj)).ex.removeCallbacks(((Runnable) (obj)));
        ((_cls02C9) (obj)).FEAE.abortAnimation();
        if (dG != null)
        {
            obj = dG;
        }
        if (dG == null)
        {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        } else
        {
            dG._mth1507(i);
            awakenScrollBars();
            return;
        }
    }

    final void _mth1D32()
    {
        if (dW != null)
        {
            return;
        }
        dW = new _cls1D4A(getContext());
        if (dD)
        {
            dW.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            dW.setSize(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    final void _mth1D35(int i, int j)
    {
        i = getScrollX();
        j = getScrollY();
        onScrollChanged(i, j, i, j);
    }

    final Rect _mth1D36(View view)
    {
        _cls02BC _lcls02bc = (_cls02BC)view.getLayoutParams();
        if (!_lcls02bc.eL)
        {
            return _lcls02bc.eK;
        }
        Rect rect = _lcls02bc.eK;
        rect.set(0, 0, 0, 0);
        int j = dI.size();
        for (int i = 0; i < j; i++)
        {
            _fld01C0.set(0, 0, 0, 0);
            ((aux)dI.get(i))._mth02CA(_fld01C0, view, this, ek);
            rect.left = rect.left + _fld01C0.left;
            rect.top = rect.top + _fld01C0.top;
            rect.right = rect.right + _fld01C0.right;
            rect.bottom = rect.bottom + _fld01C0.bottom;
        }

        _lcls02bc.eL = false;
        return rect;
    }

    final void _mth1D3E()
    {
        if (dY != null)
        {
            return;
        }
        dY = new _cls1D4A(getContext());
        if (dD)
        {
            dY.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            dY.setSize(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    final void _mth1D41()
    {
        if (dX != null)
        {
            return;
        }
        dX = new _cls1D4A(getContext());
        if (dD)
        {
            dX.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            dX.setSize(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    final void _mth1D43()
    {
        if (dZ != null)
        {
            return;
        }
        dZ = new _cls1D4A(getContext());
        if (dD)
        {
            dZ.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            dZ.setSize(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    public final void _mth1D4A()
    {
        Object obj;
        Object obj1;
label0:
        {
            if (dF == null)
            {
                Log.e("RecyclerView", "No adapter attached; skipping layout");
                return;
            }
            if (dG == null)
            {
                Log.e("RecyclerView", "No layout manager attached; skipping layout");
                return;
            }
            ek.fm.clear();
            if (!dO)
            {
                dO = true;
                dP = false;
            }
            dV = dV + 1;
            _mth1D49();
            obj1 = ek;
            if (ek.fs && en)
            {
                boolean flag;
                if (ea != null && ea.eG)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    obj = new _cls1422();
                    break label0;
                }
            }
            obj = null;
        }
        obj1.fl = ((_cls1422) (obj));
        en = false;
        em = false;
        obj1 = null;
        ek.fr = ek.ft;
        ek.fn = dF.getItemCount();
        _mth02CB(es);
        if (ek.fs)
        {
            ek.fj.clear();
            ek.fk.clear();
            obj = dC;
            int k3 = ((_cls0690) (obj)).aF.getChildCount();
            int k4 = ((_cls0690) (obj)).aH.size();
            for (int i = 0; i < k3 - k4; i++)
            {
                obj = dC;
                int i2 = ((_cls0690) (obj)).FB1D(i);
                obj = ((_cls0690) (obj)).aF.getChildAt(i2);
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
                }
                boolean flag1;
                if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    continue;
                }
                if ((((_cls02CC) (obj))._fld0E20 & 4) != 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1 || dF.ez)
                {
                    View view = ((_cls02CC) (obj)).fy;
                    ek.fj.put(obj, new _cls141D(((_cls02CC) (obj)), view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
            }

        }
        if (ek.ft)
        {
            _mth1D6A();
            if (ek.fl != null)
            {
                obj = dC;
                int l3 = ((_cls0690) (obj)).aF.getChildCount();
                int l4 = ((_cls0690) (obj)).aH.size();
                for (int j = 0; j < l3 - l4; j++)
                {
                    obj = dC;
                    int j2 = ((_cls0690) (obj)).FB1D(j);
                    obj = ((_cls0690) (obj)).aF.getChildAt(j2);
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
                    }
                    if ((((_cls02CC) (obj))._fld0E20 & 0x40) != 0)
                    {
                        j2 = 1;
                    } else
                    {
                        j2 = 0;
                    }
                    if (!j2)
                    {
                        continue;
                    }
                    boolean flag2;
                    if ((((_cls02CC) (obj))._fld0E20 & 8) != 0)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag2)
                    {
                        continue;
                    }
                    if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (flag2)
                    {
                        continue;
                    }
                    long l5;
                    if (dF.ez)
                    {
                        l5 = ((_cls02CC) (obj)).getItemId();
                    } else
                    {
                        l5 = ((_cls02CC) (obj)).bX;
                    }
                    ek.fl.put(Long.valueOf(l5), obj);
                    ek.fj.remove(obj);
                }

            }
            boolean flag11 = ek.fq;
            ek.fq = false;
            dG._mth02CA(dz, ek);
            ek.fq = flag11;
            obj1 = new _cls1422();
            int k = 0;
            do
            {
                obj = dC;
                if (k >= ((_cls0690) (obj)).aF.getChildCount() - ((_cls0690) (obj)).aH.size())
                {
                    break;
                }
                boolean flag10 = false;
                obj = dC;
                int k2 = ((_cls0690) (obj)).FB1D(k);
                View view1 = ((_cls0690) (obj)).aF.getChildAt(k2);
                if (view1 == null)
                {
                    obj = null;
                } else
                {
                    obj = ((_cls02BC)view1.getLayoutParams()).eJ;
                }
                boolean flag3;
                if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (!flag3)
                {
                    int l2 = 0;
                    boolean flag9;
                    do
                    {
                        flag9 = flag10;
                        if (l2 >= ek.fj.size())
                        {
                            break;
                        }
                        if (((_cls02CC)((_cls1551) (ek.fj)).FB48[l2 << 1]).fy == view1)
                        {
                            flag9 = true;
                            break;
                        }
                        l2++;
                    } while (true);
                    if (!flag9)
                    {
                        ((_cls1422) (obj1)).put(view1, new Rect(view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom()));
                    }
                }
                k++;
            } while (true);
            _mth1E2F();
            dB._mth05DF();
            obj = obj1;
        } else
        {
            _mth1E2F();
            dB._mth05E0();
            obj = obj1;
            if (ek.fl != null)
            {
                obj = dC;
                int i4 = ((_cls0690) (obj)).aF.getChildCount();
                int i5 = ((_cls0690) (obj)).aH.size();
                int l = 0;
                do
                {
                    obj = obj1;
                    if (l >= i4 - i5)
                    {
                        break;
                    }
                    obj = dC.getChildAt(l);
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = ((_cls02BC)((View) (obj)).getLayoutParams()).eJ;
                    }
                    boolean flag4;
                    if ((((_cls02CC) (obj))._fld0E20 & 0x40) != 0)
                    {
                        flag4 = true;
                    } else
                    {
                        flag4 = false;
                    }
                    if (flag4)
                    {
                        boolean flag5;
                        if ((((_cls02CC) (obj))._fld0E20 & 8) != 0)
                        {
                            flag5 = true;
                        } else
                        {
                            flag5 = false;
                        }
                        if (!flag5)
                        {
                            boolean flag6;
                            if ((((_cls02CC) (obj))._fld0E20 & 0x80) != 0)
                            {
                                flag6 = true;
                            } else
                            {
                                flag6 = false;
                            }
                            if (!flag6)
                            {
                                long l6;
                                if (dF.ez)
                                {
                                    l6 = ((_cls02CC) (obj)).getItemId();
                                } else
                                {
                                    l6 = ((_cls02CC) (obj)).bX;
                                }
                                ek.fl.put(Long.valueOf(l6), obj);
                                ek.fj.remove(obj);
                            }
                        }
                    }
                    l++;
                } while (true);
            }
        }
        ek.fn = dF.getItemCount();
        ek.fp = 0;
        ek.fr = false;
        dG._mth02CA(dz, ek);
        ek.fq = false;
        dA = null;
        obj1 = ek;
        boolean flag12;
        if (ek.fs && ea != null)
        {
            flag12 = true;
        } else
        {
            flag12 = false;
        }
        obj1.fs = flag12;
        if (ek.fs)
        {
            _cls1422 _lcls1422;
            if (ek.fl != null)
            {
                _lcls1422 = new _cls1422();
            } else
            {
                _lcls1422 = null;
            }
            _cls0690 _lcls0690 = dC;
            int j4 = _lcls0690.aF.getChildCount();
            int j5 = _lcls0690.aH.size();
            for (int i1 = 0; i1 < j4 - j5; i1++)
            {
                Object obj2 = dC.getChildAt(i1);
                if (obj2 == null)
                {
                    obj2 = null;
                } else
                {
                    obj2 = ((_cls02BC)((View) (obj2)).getLayoutParams()).eJ;
                }
                boolean flag7;
                if ((((_cls02CC) (obj2))._fld0E20 & 0x80) != 0)
                {
                    flag7 = true;
                } else
                {
                    flag7 = false;
                }
                if (flag7)
                {
                    continue;
                }
                View view2 = ((_cls02CC) (obj2)).fy;
                long l7;
                if (dF.ez)
                {
                    l7 = ((_cls02CC) (obj2)).getItemId();
                } else
                {
                    l7 = ((_cls02CC) (obj2)).bX;
                }
                if (_lcls1422 != null && ek.fl.get(Long.valueOf(l7)) != null)
                {
                    _lcls1422.put(Long.valueOf(l7), obj2);
                } else
                {
                    ek.fk.put(obj2, new _cls141D(((_cls02CC) (obj2)), view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
                }
            }

            _mth02CA(((_cls1422) (obj)));
            for (int j1 = ek.fj.size() - 1; j1 >= 0; j1--)
            {
                _cls02CC _lcls02cc2 = (_cls02CC)((_cls1551) (ek.fj)).FB48[j1 << 1];
                if (!ek.fk.containsKey(_lcls02cc2))
                {
                    _cls141D _lcls141d = (_cls141D)((_cls1551) (ek.fj)).FB48[(j1 << 1) + 1];
                    ek.fj.removeAt(j1);
                    dz._mth02C9(_lcls141d.bv);
                    _mth02CA(_lcls141d);
                }
            }

            int k1 = ek.fk.size();
            if (k1 > 0)
            {
                for (k1--; k1 >= 0; k1--)
                {
                    _cls02CC _lcls02cc3 = (_cls02CC)((_cls1551) (ek.fk)).FB48[k1 << 1];
                    _cls141D _lcls141d3 = (_cls141D)((_cls1551) (ek.fk)).FB48[(k1 << 1) + 1];
                    if (!ek.fj.isEmpty() && ek.fj.containsKey(_lcls02cc3))
                    {
                        continue;
                    }
                    ek.fk.removeAt(k1);
                    Rect rect;
                    if (obj != null)
                    {
                        rect = (Rect)((_cls1422) (obj)).get(_lcls02cc3.fy);
                    } else
                    {
                        rect = null;
                    }
                    _mth02CA(_lcls02cc3, rect, _lcls141d3.left, _lcls141d3.top);
                }

            }
            int i3 = ek.fk.size();
            for (k1 = 0; k1 < i3; k1++)
            {
                _cls02CC _lcls02cc = (_cls02CC)((_cls1551) (ek.fk)).FB48[k1 << 1];
                _cls141D _lcls141d1 = (_cls141D)((_cls1551) (ek.fk)).FB48[(k1 << 1) + 1];
                _cls141D _lcls141d2 = (_cls141D)ek.fj.get(_lcls02cc);
                if (_lcls141d2 == null || _lcls141d1 == null || _lcls141d2.left == _lcls141d1.left && _lcls141d2.top == _lcls141d1.top)
                {
                    continue;
                }
                _lcls02cc.setIsRecyclable(false);
                if (ea._mth02CA(_lcls02cc, _lcls141d2.left, _lcls141d2.top, _lcls141d1.left, _lcls141d1.top) && !ep && dL)
                {
                    FE70._mth02CA(this, ev);
                    ep = true;
                }
            }

            if (ek.fl != null)
            {
                k1 = ek.fl.size();
            } else
            {
                k1 = 0;
            }
            for (k1--; k1 >= 0; k1--)
            {
                long l8 = ((Long)((_cls1551) (ek.fl)).FB48[k1 << 1]).longValue();
                _cls02CC _lcls02cc1 = (_cls02CC)ek.fl.get(Long.valueOf(l8));
                boolean flag8;
                if ((_lcls02cc1._fld0E20 & 0x80) != 0)
                {
                    flag8 = true;
                } else
                {
                    flag8 = false;
                }
                if (!flag8 && dz.eR != null && dz.eR.contains(_lcls02cc1))
                {
                    _mth02CA(_lcls02cc1, (_cls02CC)_lcls1422.get(Long.valueOf(l8)));
                }
            }

        }
        _mth2071(false);
        dG._mth02CB(dz);
        ek.fo = ek.fn;
        dU = false;
        ek.fs = false;
        ek.ft = false;
        dV = dV - 1;
        if (dV <= 0)
        {
            dV = 0;
            _mth1D45();
        }
        _cls02BB._mth02CA(dG, false);
        if (dz.eR != null)
        {
            dz.eR.clear();
        }
        ek.fl = null;
        if (_mth0674(es[0], es[1]))
        {
            int l1 = getScrollX();
            int j3 = getScrollY();
            onScrollChanged(l1, j3, l1, j3);
        }
    }

    public final void _mth1D61()
    {
        int j = dC.aF.getChildCount();
        for (int i = 0; i < j; i++)
        {
            ((_cls02BC)dC.aF.getChildAt(i).getLayoutParams()).eL = true;
        }

        dz._mth1D61();
    }

    public final _cls02CC _mth1D63(View view)
    {
        ViewParent viewparent = view.getParent();
        if (viewparent != null && viewparent != this)
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a direct child of ").append(this).toString());
        }
        if (view == null)
        {
            return null;
        } else
        {
            return ((_cls02BC)view.getLayoutParams()).eJ;
        }
    }

    final void _mth1FBE(String s)
    {
        boolean flag;
        if (dV > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (s == null)
            {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s);
            }
        } else
        {
            return;
        }
    }

    public final void _mth2071(boolean flag)
    {
        if (dO)
        {
            if (flag && dP && dG != null && dF != null)
            {
                _mth1D4A();
            }
            dO = false;
            dP = false;
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 18 || android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dw = flag;
        dx = (new Class[] {
            android/content/Context, android/util/AttributeSet, Integer.TYPE, Integer.TYPE
        });
    }
}
