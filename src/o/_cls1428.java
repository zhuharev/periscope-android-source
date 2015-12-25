// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package o:
//            _cls1427, _cls1449, FE73, _cls0640, 
//            _cls1509, FE70, _cls141D, _cls02B3, 
//            FF9E, _cls15EE, _cls02C7, _cls02CD, 
//            _cls02B9

public final class _cls1428 extends _cls1427
    implements _cls1449
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    public static boolean DEBUG = false;
    private static Field _fld06E6 = null;
    private static boolean _fld1508;
    private static DecelerateInterpolator _fld1D59 = new DecelerateInterpolator(2.5F);
    private static DecelerateInterpolator _fld1D5B = new DecelerateInterpolator(1.5F);
    public _cls0640 mHost;
    private ArrayList _fld0131;
    ArrayList _fld01C3;
    ArrayList _fld02B2;
    int _fld02D0;
    public _cls02CD _fld02E3;
    public Fragment _fld05D5;
    private boolean _fld0E40;
    public boolean _fld13A5;
    public boolean _fld1424;
    String _fld14A1;
    private boolean _fld14A2;
    private Bundle _fld15AE;
    private ArrayList _fld15EE;
    private Runnable _fld1D36[];
    private boolean _fld1D38;
    public ArrayList _fld1D40;
    ArrayList _fld1D4B;
    private SparseArray _fld1D4C;
    private FE73 _fld1D53;
    private ArrayList _fld1D57;
    ArrayList FF9F;

    public _cls1428()
    {
        _fld02D0 = 0;
        _fld15AE = null;
        _fld1D4C = null;
        _fld1D53 = new FE73(this);
    }

    private Fragment _mth02CA(Bundle bundle, String s)
    {
        int i = bundle.getInt(s, -1);
        if (i == -1)
        {
            return null;
        }
        if (i >= _fld1D40.size())
        {
            _mth02CA(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment no longer exists for key ")).append(s).append(": index ").append(i).toString()))));
        }
        bundle = (Fragment)_fld1D40.get(i);
        if (bundle == null)
        {
            _mth02CA(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment no longer exists for key ")).append(s).append(": index ").append(i).toString()))));
        }
        return bundle;
    }

    private Animation _mth02CA(Fragment fragment, int i, boolean flag, int j)
    {
        Animation animation = fragment.onCreateAnimation(i, flag, fragment.mNextAnim);
        if (animation != null)
        {
            return animation;
        }
        if (fragment.mNextAnim != 0)
        {
            fragment = AnimationUtils.loadAnimation(mHost.mContext, fragment.mNextAnim);
            if (fragment != null)
            {
                return fragment;
            }
        }
        if (i == 0)
        {
            return null;
        }
        byte byte0 = -1;
        switch (i)
        {
        default:
            i = byte0;
            break;

        case 4097: 
            if (flag)
            {
                i = 1;
            } else
            {
                i = 2;
            }
            break;

        case 8194: 
            if (flag)
            {
                i = 3;
            } else
            {
                i = 4;
            }
            break;

        case 4099: 
            if (flag)
            {
                i = 5;
            } else
            {
                i = 6;
            }
            break;
        }
        if (i < 0)
        {
            return null;
        }
        switch (i)
        {
        case 1: // '\001'
            return _mth02CA(1.125F, 1.0F, 0.0F, 1.0F);

        case 2: // '\002'
            return _mth02CA(1.0F, 0.975F, 1.0F, 0.0F);

        case 3: // '\003'
            return _mth02CA(0.975F, 1.0F, 0.0F, 1.0F);

        case 4: // '\004'
            return _mth02CA(1.0F, 1.075F, 1.0F, 0.0F);

        case 5: // '\005'
            fragment = new AlphaAnimation(0.0F, 1.0F);
            fragment.setInterpolator(_fld1D5B);
            fragment.setDuration(220L);
            return fragment;

        case 6: // '\006'
            fragment = new AlphaAnimation(1.0F, 0.0F);
            fragment.setInterpolator(_fld1D5B);
            fragment.setDuration(220L);
            return fragment;
        }
        i = j;
        if (j == 0)
        {
            i = j;
            if (mHost.onHasWindowAnimations())
            {
                i = mHost.onGetWindowAnimations();
            }
        }
        if (i == 0)
        {
            return null;
        } else
        {
            return null;
        }
    }

    private static AnimationSet _mth02CA(float f, float f1, float f2, float f3)
    {
        AnimationSet animationset = new AnimationSet(false);
        Object obj = new ScaleAnimation(f, f1, f, f1, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation) (obj)).setInterpolator(_fld1D59);
        ((ScaleAnimation) (obj)).setDuration(220L);
        animationset.addAnimation(((Animation) (obj)));
        obj = new AlphaAnimation(f2, f3);
        ((AlphaAnimation) (obj)).setInterpolator(_fld1D5B);
        ((AlphaAnimation) (obj)).setDuration(220L);
        animationset.addAnimation(((Animation) (obj)));
        return animationset;
    }

    private void _mth02CA(int i, _cls141D _pcls141d)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        if (_fld01C3 == null)
        {
            _fld01C3 = new ArrayList();
        }
        k = _fld01C3.size();
        int j;
        j = k;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        _fld01C3.set(i, _pcls141d);
        break MISSING_BLOCK_LABEL_111;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        _fld01C3.add(null);
        if (_fld02B2 == null)
        {
            _fld02B2 = new ArrayList();
        }
        _fld02B2.add(Integer.valueOf(j));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        _fld01C3.add(_pcls141d);
        this;
        JVM INSTR monitorexit ;
        return;
        _pcls141d;
        throw _pcls141d;
    }

    private void _mth02CA(Bundle bundle, String s, Fragment fragment)
    {
        if (fragment.mIndex < 0)
        {
            _mth02CA(((RuntimeException) (new IllegalStateException((new StringBuilder("Fragment ")).append(fragment).append(" is not currently in the FragmentManager").toString()))));
        }
        bundle.putInt(s, fragment.mIndex);
    }

    private void _mth02CA(RuntimeException runtimeexception)
    {
        Log.e("FragmentManager", runtimeexception.getMessage());
        Log.e("FragmentManager", "Activity state:");
        Object obj = new PrintWriter(new _cls1509("FragmentManager"));
        if (mHost != null)
        {
            try
            {
                mHost.onDump("  ", null, ((PrintWriter) (obj)), new String[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("FragmentManager", "Failed dumping state", ((Throwable) (obj)));
            }
        } else
        {
            try
            {
                dump("  ", null, ((PrintWriter) (obj)), new String[0]);
            }
            catch (Exception exception)
            {
                Log.e("FragmentManager", "Failed dumping state", exception);
            }
        }
        throw runtimeexception;
    }

    static boolean _mth02CA(View view, Animation animation)
    {
label0:
        {
            int i;
label1:
            {
                if (android.os.Build.VERSION.SDK_INT < 19 || FE70._mth02C8(view) != 0 || !FE70._mth05D9(view))
                {
                    break label0;
                }
                if (animation instanceof AlphaAnimation)
                {
                    i = 1;
                    break label1;
                }
                if (animation instanceof AnimationSet)
                {
                    view = ((AnimationSet)animation).getAnimations();
                    i = 0;
                    do
                    {
                        if (i >= view.size())
                        {
                            break;
                        }
                        if (view.get(i) instanceof AlphaAnimation)
                        {
                            i = 1;
                            break label1;
                        }
                        i++;
                    } while (true);
                }
                i = 0;
            }
            if (i != 0)
            {
                return true;
            }
        }
        return false;
    }

    private void _mth02CB(Fragment fragment)
    {
        if (fragment.mIndex >= 0)
        {
            return;
        }
        if (_fld1D57 == null || _fld1D57.size() <= 0)
        {
            if (_fld1D40 == null)
            {
                _fld1D40 = new ArrayList();
            }
            fragment.setIndex(_fld1D40.size(), _fld05D5);
            _fld1D40.add(fragment);
            return;
        } else
        {
            fragment.setIndex(((Integer)_fld1D57.remove(_fld1D57.size() - 1)).intValue(), _fld05D5);
            _fld1D40.set(fragment.mIndex, fragment);
            return;
        }
    }

    private static void _mth02CB(View view, Animation animation)
    {
        android.view.animation.Animation.AnimationListener animationlistener;
        if (view == null || animation == null)
        {
            return;
        }
        if (!_mth02CA(view, animation))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        animationlistener = null;
        android.view.animation.Animation.AnimationListener animationlistener1;
        if (_fld06E6 == null)
        {
            Field field = android/view/animation/Animation.getDeclaredField("mListener");
            _fld06E6 = field;
            field.setAccessible(true);
        }
        animationlistener1 = (android.view.animation.Animation.AnimationListener)_fld06E6.get(animation);
        animationlistener = animationlistener1;
        break MISSING_BLOCK_LABEL_85;
        Object obj;
        obj;
        Log.e("FragmentManager", "No field with the name mListener is found in Animation class", ((Throwable) (obj)));
        break MISSING_BLOCK_LABEL_85;
        obj;
        Log.e("FragmentManager", "Cannot access Animation's mListener field", ((Throwable) (obj)));
        animation.setAnimationListener(new if(view, animation, animationlistener));
    }

    private void _mth02CE(Fragment fragment)
    {
        if (fragment.mIndex < 0)
        {
            return;
        }
        _fld1D40.set(fragment.mIndex, null);
        if (_fld1D57 == null)
        {
            _fld1D57 = new ArrayList();
        }
        _fld1D57.add(Integer.valueOf(fragment.mIndex));
        mHost._mth02BB(fragment.mWho);
        fragment.initState();
    }

    public static int _mth02CF(int i)
    {
        switch (i)
        {
        default:
            return 0;

        case 4097: 
            return 8194;

        case 8194: 
            return 4097;

        case 4099: 
            return 4099;
        }
    }

    private void _mth02CF(Fragment fragment)
    {
        if (fragment.mInnerView == null)
        {
            return;
        }
        if (_fld1D4C == null)
        {
            _fld1D4C = new SparseArray();
        } else
        {
            _fld1D4C.clear();
        }
        fragment.mInnerView.saveHierarchyState(_fld1D4C);
        if (_fld1D4C.size() > 0)
        {
            fragment.mSavedViewState = _fld1D4C;
            _fld1D4C = null;
        }
    }

    private Bundle _mth141D(Fragment fragment)
    {
        Bundle bundle1 = null;
        if (_fld15AE == null)
        {
            _fld15AE = new Bundle();
        }
        fragment.performSaveInstanceState(_fld15AE);
        if (!_fld15AE.isEmpty())
        {
            bundle1 = _fld15AE;
            _fld15AE = null;
        }
        if (fragment.mView != null)
        {
            _mth02CF(fragment);
        }
        Bundle bundle = bundle1;
        if (fragment.mSavedViewState != null)
        {
            bundle = bundle1;
            if (bundle1 == null)
            {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        bundle1 = bundle;
        if (!fragment.mUserVisibleHint)
        {
            bundle1 = bundle;
            if (bundle == null)
            {
                bundle1 = new Bundle();
            }
            bundle1.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle1;
    }

    private void FE73()
    {
        if (_fld1D40 == null)
        {
            return;
        }
        for (int i = 0; i < _fld1D40.size(); i++)
        {
            Fragment fragment = (Fragment)_fld1D40.get(i);
            if (fragment != null)
            {
                _mth02CA(fragment);
            }
        }

    }

    private void FF9E()
    {
        if (_fld13A5)
        {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (_fld14A1 != null)
        {
            throw new IllegalStateException((new StringBuilder("Can not perform this action inside of ")).append(_fld14A1).toString());
        } else
        {
            return;
        }
    }

    public final void dispatchActivityCreated()
    {
        _fld13A5 = false;
        _mth02CA(2, 0, 0, false);
    }

    public final void dispatchConfigurationChanged(Configuration configuration)
    {
        if (_fld1D4B != null)
        {
            for (int i = 0; i < _fld1D4B.size(); i++)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                if (fragment != null)
                {
                    fragment.performConfigurationChanged(configuration);
                }
            }

        }
    }

    public final boolean dispatchContextItemSelected(MenuItem menuitem)
    {
        if (_fld1D4B != null)
        {
            for (int i = 0; i < _fld1D4B.size(); i++)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuitem))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public final void dispatchCreate()
    {
        _fld13A5 = false;
        _mth02CA(1, 0, 0, false);
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        boolean flag1 = false;
        boolean flag = false;
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        if (_fld1D4B != null)
        {
            int i = 0;
            do
            {
                flag1 = flag;
                arraylist1 = arraylist;
                if (i >= _fld1D4B.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                flag1 = flag;
                arraylist1 = arraylist;
                if (fragment != null)
                {
                    flag1 = flag;
                    arraylist1 = arraylist;
                    if (fragment.performCreateOptionsMenu(menu, menuinflater))
                    {
                        flag1 = true;
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(fragment);
                    }
                }
                i++;
                flag = flag1;
                arraylist = arraylist1;
            } while (true);
        }
        if (_fld0131 != null)
        {
            for (int j = 0; j < _fld0131.size(); j++)
            {
                menu = (Fragment)_fld0131.get(j);
                if (arraylist1 == null || !arraylist1.contains(menu))
                {
                    menu.onDestroyOptionsMenu();
                }
            }

        }
        _fld0131 = arraylist1;
        return flag1;
    }

    public final void dispatchLowMemory()
    {
        if (_fld1D4B != null)
        {
            for (int i = 0; i < _fld1D4B.size(); i++)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                if (fragment != null)
                {
                    fragment.performLowMemory();
                }
            }

        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuitem)
    {
        if (_fld1D4B != null)
        {
            for (int i = 0; i < _fld1D4B.size(); i++)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuitem))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu)
    {
        if (_fld1D4B != null)
        {
            for (int i = 0; i < _fld1D4B.size(); i++)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                if (fragment != null)
                {
                    fragment.performOptionsMenuClosed(menu);
                }
            }

        }
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu)
    {
        boolean flag1 = false;
        boolean flag = false;
        if (_fld1D4B != null)
        {
            int i = 0;
            do
            {
                flag1 = flag;
                if (i >= _fld1D4B.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                flag1 = flag;
                if (fragment != null)
                {
                    flag1 = flag;
                    if (fragment.performPrepareOptionsMenu(menu))
                    {
                        flag1 = true;
                    }
                }
                i++;
                flag = flag1;
            } while (true);
        }
        return flag1;
    }

    public final void dispatchResume()
    {
        _fld13A5 = false;
        _mth02CA(5, 0, 0, false);
    }

    public final void dispatchStart()
    {
        _fld13A5 = false;
        _mth02CA(4, 0, 0, false);
    }

    public final void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        String s1 = (new StringBuilder()).append(s).append("    ").toString();
        if (_fld1D40 != null)
        {
            int k1 = _fld1D40.size();
            if (k1 > 0)
            {
                printwriter.print(s);
                printwriter.print("Active Fragments in ");
                printwriter.print(Integer.toHexString(System.identityHashCode(this)));
                printwriter.println(":");
                for (int i = 0; i < k1; i++)
                {
                    Fragment fragment = (Fragment)_fld1D40.get(i);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(i);
                    printwriter.print(": ");
                    printwriter.println(fragment);
                    if (fragment != null)
                    {
                        fragment.dump(s1, filedescriptor, printwriter, as);
                    }
                }

            }
        }
        if (_fld1D4B != null)
        {
            int l1 = _fld1D4B.size();
            if (l1 > 0)
            {
                printwriter.print(s);
                printwriter.println("Added Fragments:");
                for (int j = 0; j < l1; j++)
                {
                    filedescriptor = (Fragment)_fld1D4B.get(j);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(j);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (_fld0131 != null)
        {
            int i2 = _fld0131.size();
            if (i2 > 0)
            {
                printwriter.print(s);
                printwriter.println("Fragments Created Menus:");
                for (int k = 0; k < i2; k++)
                {
                    filedescriptor = (Fragment)_fld0131.get(k);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(k);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                }

            }
        }
        if (FF9F != null)
        {
            int j2 = FF9F.size();
            if (j2 > 0)
            {
                printwriter.print(s);
                printwriter.println("Back Stack:");
                for (int l = 0; l < j2; l++)
                {
                    filedescriptor = (_cls141D)FF9F.get(l);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(l);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor.toString());
                    filedescriptor._mth02CA(s1, printwriter);
                }

            }
        }
        this;
        JVM INSTR monitorenter ;
        if (_fld01C3 == null) goto _L2; else goto _L1
_L1:
        int k2 = _fld01C3.size();
        if (k2 <= 0) goto _L2; else goto _L3
_L3:
        printwriter.print(s);
        printwriter.println("Back Stack Indices:");
        int i1 = 0;
_L4:
        if (i1 >= k2)
        {
            break; /* Loop/switch isn't completed */
        }
        filedescriptor = (_cls141D)_fld01C3.get(i1);
        printwriter.print(s);
        printwriter.print("  #");
        printwriter.print(i1);
        printwriter.print(": ");
        printwriter.println(filedescriptor);
        i1++;
        if (true) goto _L4; else goto _L2
_L2:
        if (_fld02B2 != null && _fld02B2.size() > 0)
        {
            printwriter.print(s);
            printwriter.print("mAvailBackStackIndices: ");
            printwriter.println(Arrays.toString(_fld02B2.toArray()));
        }
        this;
        JVM INSTR monitorexit ;
          goto _L5
        s;
        throw s;
_L5:
        if (_fld15EE != null)
        {
            int l2 = _fld15EE.size();
            if (l2 > 0)
            {
                printwriter.print(s);
                printwriter.println("Pending Actions:");
                for (int j1 = 0; j1 < l2; j1++)
                {
                    filedescriptor = (Runnable)_fld15EE.get(j1);
                    printwriter.print(s);
                    printwriter.print("  #");
                    printwriter.print(j1);
                    printwriter.print(": ");
                    printwriter.println(filedescriptor);
                }

            }
        }
        printwriter.print(s);
        printwriter.println("FragmentManager misc state:");
        printwriter.print(s);
        printwriter.print("  mHost=");
        printwriter.println(mHost);
        printwriter.print(s);
        printwriter.print("  mContainer=");
        printwriter.println(_fld02E3);
        if (_fld05D5 != null)
        {
            printwriter.print(s);
            printwriter.print("  mParent=");
            printwriter.println(_fld05D5);
        }
        printwriter.print(s);
        printwriter.print("  mCurState=");
        printwriter.print(_fld02D0);
        printwriter.print(" mStateSaved=");
        printwriter.print(_fld13A5);
        printwriter.print(" mDestroyed=");
        printwriter.println(_fld1424);
        if (_fld0E40)
        {
            printwriter.print(s);
            printwriter.print("  mNeedMenuInvalidate=");
            printwriter.println(_fld0E40);
        }
        if (_fld14A1 != null)
        {
            printwriter.print(s);
            printwriter.print("  mNoTransactionsBecause=");
            printwriter.println(_fld14A1);
        }
        if (_fld1D57 != null && _fld1D57.size() > 0)
        {
            printwriter.print(s);
            printwriter.print("  mAvailIndices: ");
            printwriter.println(Arrays.toString(_fld1D57.toArray()));
        }
        return;
    }

    public final boolean execPendingActions()
    {
        if (_fld1D38)
        {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != mHost.mHandler.getLooper())
        {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean flag2 = false;
_L3:
        this;
        JVM INSTR monitorenter ;
        int i;
        if (_fld15EE == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        i = _fld15EE.size();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        this;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        int l;
        l = _fld15EE.size();
        if (_fld1D36 == null || _fld1D36.length < l)
        {
            _fld1D36 = new Runnable[l];
        }
        _fld15EE.toArray(_fld1D36);
        _fld15EE.clear();
        mHost.mHandler.removeCallbacks(_fld1D53);
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        _fld1D38 = true;
        for (int j = 0; j < l; j++)
        {
            _fld1D36[j].run();
            _fld1D36[j] = null;
        }

        _fld1D38 = false;
        flag2 = true;
        if (true) goto _L3; else goto _L2
_L2:
        if (_fld14A2)
        {
            boolean flag = false;
            for (int k = 0; k < _fld1D40.size();)
            {
                Fragment fragment = (Fragment)_fld1D40.get(k);
                boolean flag1 = flag;
                if (fragment != null)
                {
                    flag1 = flag;
                    if (fragment.mLoaderManager != null)
                    {
                        flag1 = flag | fragment.mLoaderManager._mth0559();
                    }
                }
                k++;
                flag = flag1;
            }

            if (!flag)
            {
                _fld14A2 = false;
                FE73();
            }
        }
        return flag2;
    }

    public final boolean executePendingTransactions()
    {
        return execPendingActions();
    }

    public final Fragment findFragmentById(int i)
    {
        if (_fld1D4B != null)
        {
            for (int j = _fld1D4B.size() - 1; j >= 0; j--)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(j);
                if (fragment != null && fragment.mFragmentId == i)
                {
                    return fragment;
                }
            }

        }
        if (_fld1D40 != null)
        {
            for (int k = _fld1D40.size() - 1; k >= 0; k--)
            {
                Fragment fragment1 = (Fragment)_fld1D40.get(k);
                if (fragment1 != null && fragment1.mFragmentId == i)
                {
                    return fragment1;
                }
            }

        }
        return null;
    }

    public final Fragment findFragmentByTag(String s)
    {
        if (_fld1D4B != null && s != null)
        {
            for (int i = _fld1D4B.size() - 1; i >= 0; i--)
            {
                Fragment fragment = (Fragment)_fld1D4B.get(i);
                if (fragment != null && s.equals(fragment.mTag))
                {
                    return fragment;
                }
            }

        }
        if (_fld1D40 != null && s != null)
        {
            for (int j = _fld1D40.size() - 1; j >= 0; j--)
            {
                Fragment fragment1 = (Fragment)_fld1D40.get(j);
                if (fragment1 != null && s.equals(fragment1.mTag))
                {
                    return fragment1;
                }
            }

        }
        return null;
    }

    public final boolean isDestroyed()
    {
        return _fld1424;
    }

    public final View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        if (!"fragment".equals(s))
        {
            return null;
        }
        s = attributeset.getAttributeValue(null, "class");
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, _cls02CA._fld02B8);
        String s1 = s;
        if (s == null)
        {
            s1 = typedarray.getString(0);
        }
        int k = typedarray.getResourceId(1, -1);
        String s2 = typedarray.getString(2);
        typedarray.recycle();
        if (!Fragment.isSupportFragmentClass(mHost.mContext, s1))
        {
            return null;
        }
        int i;
        if (view != null)
        {
            i = view.getId();
        } else
        {
            i = 0;
        }
        if (i == -1 && k == -1 && s2 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(s1).toString());
        }
        if (k != -1)
        {
            s = findFragmentById(k);
        } else
        {
            s = null;
        }
        view = s;
        if (s == null)
        {
            view = s;
            if (s2 != null)
            {
                view = findFragmentByTag(s2);
            }
        }
        s = view;
        if (view == null)
        {
            s = view;
            if (i != -1)
            {
                s = findFragmentById(i);
            }
        }
        if (s == null)
        {
            view = Fragment.instantiate(context, s1);
            view.mFromLayout = true;
            int j;
            if (k != 0)
            {
                j = k;
            } else
            {
                j = i;
            }
            view.mFragmentId = j;
            view.mContainerId = i;
            view.mTag = s2;
            view.mInLayout = true;
            view.mFragmentManager = this;
            view.mHost = mHost;
            view.onInflate(mHost.mContext, attributeset, ((Fragment) (view)).mSavedFragmentState);
            _mth02CA(view, true);
        } else
        {
            if (((Fragment) (s)).mInLayout)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(k)).append(", tag ").append(s2).append(", or parent id 0x").append(Integer.toHexString(i)).append(" with another fragment for ").append(s1).toString());
            }
            s.mInLayout = true;
            view = s;
            if (!((Fragment) (s)).mRetaining)
            {
                s.onInflate(mHost.mContext, attributeset, ((Fragment) (s)).mSavedFragmentState);
                view = s;
            }
        }
        if (_fld02D0 <= 0 && ((Fragment) (view)).mFromLayout)
        {
            _mth02CA(view, 1, 0, 0, false);
        } else
        {
            _mth02CA(view, _fld02D0, 0, 0, false);
        }
        if (((Fragment) (view)).mView == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(s1).append(" did not create a view.").toString());
        }
        if (k != 0)
        {
            ((Fragment) (view)).mView.setId(k);
        }
        if (((Fragment) (view)).mView.getTag() == null)
        {
            ((Fragment) (view)).mView.setTag(s2);
        }
        return ((Fragment) (view)).mView;
    }

    public final void popBackStack(int i, int j)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad id: ")).append(i).toString());
        } else
        {
            _mth02CA(new FF9E(this, i, 1), false);
            return;
        }
    }

    public final boolean popBackStackImmediate()
    {
        FF9E();
        execPendingActions();
        return _mth02CA(((String) (null)), -1, 0);
    }

    public final void restoreAllState(Parcelable parcelable, List list)
    {
        if (parcelable == null)
        {
            return;
        }
        parcelable = (FragmentManagerState)parcelable;
        if (((FragmentManagerState) (parcelable))._fld02C0 == null)
        {
            return;
        }
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                Fragment fragment = (Fragment)list.get(i);
                FragmentState fragmentstate1 = ((FragmentManagerState) (parcelable))._fld02C0[fragment.mIndex];
                fragmentstate1._fld03B9 = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                fragment.mTarget = null;
                if (fragmentstate1.mSavedFragmentState != null)
                {
                    fragmentstate1.mSavedFragmentState.setClassLoader(mHost.mContext.getClassLoader());
                    fragment.mSavedViewState = fragmentstate1.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    fragment.mSavedFragmentState = fragmentstate1.mSavedFragmentState;
                }
            }

        }
        _fld1D40 = new ArrayList(((FragmentManagerState) (parcelable))._fld02C0.length);
        if (_fld1D57 != null)
        {
            _fld1D57.clear();
        }
        for (int j = 0; j < ((FragmentManagerState) (parcelable))._fld02C0.length; j++)
        {
            FragmentState fragmentstate = ((FragmentManagerState) (parcelable))._fld02C0[j];
            if (fragmentstate != null)
            {
                Fragment fragment2 = fragmentstate._mth02CA(mHost, _fld05D5);
                _fld1D40.add(fragment2);
                fragmentstate._fld03B9 = null;
                continue;
            }
            _fld1D40.add(null);
            if (_fld1D57 == null)
            {
                _fld1D57 = new ArrayList();
            }
            _fld1D57.add(Integer.valueOf(j));
        }

        if (list != null)
        {
            for (int k = 0; k < list.size(); k++)
            {
                Fragment fragment1 = (Fragment)list.get(k);
                if (fragment1.mTargetIndex < 0)
                {
                    continue;
                }
                if (fragment1.mTargetIndex < _fld1D40.size())
                {
                    fragment1.mTarget = (Fragment)_fld1D40.get(fragment1.mTargetIndex);
                } else
                {
                    Log.w("FragmentManager", (new StringBuilder("Re-attaching retained fragment ")).append(fragment1).append(" target no longer exists: ").append(fragment1.mTargetIndex).toString());
                    fragment1.mTarget = null;
                }
            }

        }
        if (((FragmentManagerState) (parcelable))._fld02C1 != null)
        {
            _fld1D4B = new ArrayList(((FragmentManagerState) (parcelable))._fld02C1.length);
            for (int l = 0; l < ((FragmentManagerState) (parcelable))._fld02C1.length; l++)
            {
                list = (Fragment)_fld1D40.get(((FragmentManagerState) (parcelable))._fld02C1[l]);
                if (list == null)
                {
                    _mth02CA(new IllegalStateException((new StringBuilder("No instantiated fragment for index #")).append(((FragmentManagerState) (parcelable))._fld02C1[l]).toString()));
                }
                list.mAdded = true;
                if (_fld1D4B.contains(list))
                {
                    throw new IllegalStateException("Already added!");
                }
                _fld1D4B.add(list);
            }

        } else
        {
            _fld1D4B = null;
        }
        if (((FragmentManagerState) (parcelable))._fld02E2 != null)
        {
            FF9F = new ArrayList(((FragmentManagerState) (parcelable))._fld02E2.length);
            for (int i1 = 0; i1 < ((FragmentManagerState) (parcelable))._fld02E2.length; i1++)
            {
                list = ((FragmentManagerState) (parcelable))._fld02E2[i1]._mth02CA(this);
                FF9F.add(list);
                if (((_cls141D) (list)).mIndex >= 0)
                {
                    _mth02CA(((_cls141D) (list)).mIndex, list);
                }
            }

            return;
        } else
        {
            FF9F = null;
            return;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("FragmentManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        if (_fld05D5 != null)
        {
            _cls141D._cls02CA._mth02CA(_fld05D5, stringbuilder);
        } else
        {
            _cls141D._cls02CA._mth02CA(mHost, stringbuilder);
        }
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

    public final FragmentManagerState _mth02B9()
    {
        execPendingActions();
        if (_fld1508)
        {
            _fld13A5 = true;
        }
        if (_fld1D40 == null || _fld1D40.size() <= 0)
        {
            return null;
        }
        int j1 = _fld1D40.size();
        FragmentState afragmentstate[] = new FragmentState[j1];
        boolean flag = false;
        for (int i = 0; i < j1; i++)
        {
            Fragment fragment = (Fragment)_fld1D40.get(i);
            if (fragment == null)
            {
                continue;
            }
            if (fragment.mIndex < 0)
            {
                _mth02CA(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(fragment).append(" has cleared index: ").append(fragment.mIndex).toString()));
            }
            boolean flag1 = true;
            FragmentState fragmentstate = new FragmentState(fragment);
            afragmentstate[i] = fragmentstate;
            if (fragment.mState > 0 && fragmentstate.mSavedFragmentState == null)
            {
                fragmentstate.mSavedFragmentState = _mth141D(fragment);
                flag = flag1;
                if (fragment.mTarget == null)
                {
                    continue;
                }
                if (fragment.mTarget.mIndex < 0)
                {
                    _mth02CA(new IllegalStateException((new StringBuilder("Failure saving state: ")).append(fragment).append(" has target not in fragment manager: ").append(fragment.mTarget).toString()));
                }
                if (fragmentstate.mSavedFragmentState == null)
                {
                    fragmentstate.mSavedFragmentState = new Bundle();
                }
                _mth02CA(fragmentstate.mSavedFragmentState, "android:target_state", fragment.mTarget);
                flag = flag1;
                if (fragment.mTargetRequestCode != 0)
                {
                    fragmentstate.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                    flag = flag1;
                }
            } else
            {
                fragmentstate.mSavedFragmentState = fragment.mSavedFragmentState;
                flag = flag1;
            }
        }

        if (!flag)
        {
            return null;
        }
        Object aobj[] = null;
        FragmentManagerState fragmentmanagerstate = null;
        int ai[] = ((int []) (aobj));
        if (_fld1D4B != null)
        {
            int l = _fld1D4B.size();
            ai = ((int []) (aobj));
            if (l > 0)
            {
                aobj = new int[l];
                int j = 0;
                do
                {
                    ai = ((int []) (aobj));
                    if (j >= l)
                    {
                        break;
                    }
                    aobj[j] = ((Fragment)_fld1D4B.get(j)).mIndex;
                    if (aobj[j] < 0)
                    {
                        _mth02CA(new IllegalStateException((new StringBuilder("Failure saving state: active ")).append(_fld1D4B.get(j)).append(" has cleared index: ").append(aobj[j]).toString()));
                    }
                    j++;
                } while (true);
            }
        }
        aobj = fragmentmanagerstate;
        if (FF9F != null)
        {
            int i1 = FF9F.size();
            aobj = fragmentmanagerstate;
            if (i1 > 0)
            {
                BackStackState abackstackstate[] = new BackStackState[i1];
                int k = 0;
                do
                {
                    aobj = abackstackstate;
                    if (k >= i1)
                    {
                        break;
                    }
                    abackstackstate[k] = new BackStackState((_cls141D)FF9F.get(k));
                    k++;
                } while (true);
            }
        }
        abackstackstate = new FragmentManagerState();
        abackstackstate._fld02C0 = afragmentstate;
        abackstackstate._fld02C1 = ai;
        abackstackstate._fld02E2 = ((BackStackState []) (aobj));
        return abackstackstate;
    }

    public final _cls141D _mth02BB()
    {
        return new _cls141D(this);
    }

    public final ArrayList _mth02BC()
    {
        return _fld1D40;
    }

    public final int _mth02CA(_cls141D _pcls141d)
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        if (_fld02B2 != null && _fld02B2.size() > 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (_fld01C3 == null)
        {
            _fld01C3 = new ArrayList();
        }
        i = _fld01C3.size();
        _fld01C3.add(_pcls141d);
        this;
        JVM INSTR monitorexit ;
        return i;
        i = ((Integer)_fld02B2.remove(_fld02B2.size() - 1)).intValue();
        _fld01C3.set(i, _pcls141d);
        this;
        JVM INSTR monitorexit ;
        return i;
        _pcls141d;
        throw _pcls141d;
    }

    public final void _mth02CA(int i, int j, int k, boolean flag)
    {
        if (mHost == null && i != 0)
        {
            throw new IllegalStateException("No host");
        }
        if (!flag && _fld02D0 == i)
        {
            return;
        }
        _fld02D0 = i;
        if (_fld1D40 != null)
        {
            boolean flag1 = false;
            for (int l = 0; l < _fld1D40.size();)
            {
                Fragment fragment = (Fragment)_fld1D40.get(l);
                boolean flag2 = flag1;
                if (fragment != null)
                {
                    _mth02CA(fragment, i, j, k, false);
                    flag2 = flag1;
                    if (fragment.mLoaderManager != null)
                    {
                        flag2 = flag1 | fragment.mLoaderManager._mth0559();
                    }
                }
                l++;
                flag1 = flag2;
            }

            if (!flag1)
            {
                FE73();
            }
            if (_fld0E40 && mHost != null && _fld02D0 == 5)
            {
                mHost._mth02CE();
                _fld0E40 = false;
            }
        }
    }

    public final void _mth02CA(Fragment fragment)
    {
        if (fragment.mDeferStart)
        {
            if (_fld1D38)
            {
                _fld14A2 = true;
                return;
            }
            fragment.mDeferStart = false;
            _mth02CA(fragment, _fld02D0, 0, 0, false);
        }
    }

    public final void _mth02CA(Fragment fragment, int i, int j)
    {
        boolean flag;
        if (!fragment.isInBackStack())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!fragment.mDetached || flag)
        {
            if (_fld1D4B != null)
            {
                _fld1D4B.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible)
            {
                _fld0E40 = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            int k;
            if (flag)
            {
                k = 0;
            } else
            {
                k = 1;
            }
            _mth02CA(fragment, k, i, j, false);
        }
    }

    final void _mth02CA(Fragment fragment, int i, int j, int k, boolean flag)
    {
        int l;
label0:
        {
            if (fragment.mAdded)
            {
                l = i;
                if (!fragment.mDetached)
                {
                    break label0;
                }
            }
            l = i;
            if (i > 1)
            {
                l = 1;
            }
        }
        int i1 = l;
        if (fragment.mRemoving)
        {
            i1 = l;
            if (l > fragment.mState)
            {
                i1 = fragment.mState;
            }
        }
        i = i1;
        if (fragment.mDeferStart)
        {
            i = i1;
            if (fragment.mState < 4)
            {
                i = i1;
                if (i1 > 3)
                {
                    i = 3;
                }
            }
        }
        if (fragment.mState < i)
        {
            if (fragment.mFromLayout && !fragment.mInLayout)
            {
                return;
            }
            if (fragment.mAnimatingAway != null)
            {
                fragment.mAnimatingAway = null;
                _mth02CA(fragment, fragment.mStateAfterAnimating, 0, 0, true);
            }
            l = i;
            int k1 = i;
            int j1 = i;
            switch (fragment.mState)
            {
            case 0: // '\0'
                j1 = i;
                if (fragment.mSavedFragmentState != null)
                {
                    fragment.mSavedFragmentState.setClassLoader(mHost.mContext.getClassLoader());
                    fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    fragment.mTarget = _mth02CA(fragment.mSavedFragmentState, "android:target_state");
                    if (fragment.mTarget != null)
                    {
                        fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
                    }
                    fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                    j1 = i;
                    if (!fragment.mUserVisibleHint)
                    {
                        fragment.mDeferStart = true;
                        j1 = i;
                        if (i > 3)
                        {
                            j1 = 3;
                        }
                    }
                }
                fragment.mHost = mHost;
                fragment.mParentFragment = _fld05D5;
                _cls1428 _lcls1428;
                if (_fld05D5 != null)
                {
                    _lcls1428 = _fld05D5.mChildFragmentManager;
                } else
                {
                    _lcls1428 = mHost.mFragmentManager;
                }
                fragment.mFragmentManager = _lcls1428;
                fragment.mCalled = false;
                fragment.onAttach(mHost.mContext);
                if (!fragment.mCalled)
                {
                    throw new _cls15EE((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onAttach()").toString());
                }
                if (fragment.mParentFragment == null)
                {
                    mHost.onAttachFragment(fragment);
                }
                if (!fragment.mRetaining)
                {
                    fragment.performCreate(fragment.mSavedFragmentState);
                }
                fragment.mRetaining = false;
                l = j1;
                if (fragment.mFromLayout)
                {
                    fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
                    if (fragment.mView != null)
                    {
                        fragment.mInnerView = fragment.mView;
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            FE70._mth02CA(fragment.mView, false);
                        } else
                        {
                            fragment.mView = _cls02C7._mth02CF(fragment.mView);
                        }
                        if (fragment.mHidden)
                        {
                            fragment.mView.setVisibility(8);
                        }
                        fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                        l = j1;
                    } else
                    {
                        fragment.mInnerView = null;
                        l = j1;
                    }
                }
                // fall through

            case 1: // '\001'
                k1 = l;
                if (l > 1)
                {
                    if (!fragment.mFromLayout)
                    {
                        ViewGroup viewgroup = null;
                        if (fragment.mContainerId != 0)
                        {
                            ViewGroup viewgroup1 = (ViewGroup)_fld02E3.onFindViewById(fragment.mContainerId);
                            viewgroup = viewgroup1;
                            if (viewgroup1 == null)
                            {
                                viewgroup = viewgroup1;
                                if (!fragment.mRestored)
                                {
                                    _mth02CA(((RuntimeException) (new IllegalArgumentException((new StringBuilder("No view found for id 0x")).append(Integer.toHexString(fragment.mContainerId)).append(" (").append(fragment.getResources().getResourceName(fragment.mContainerId)).append(") for fragment ").append(fragment).toString()))));
                                    viewgroup = viewgroup1;
                                }
                            }
                        }
                        fragment.mContainer = viewgroup;
                        fragment.mView = fragment.performCreateView(fragment.getLayoutInflater(fragment.mSavedFragmentState), viewgroup, fragment.mSavedFragmentState);
                        if (fragment.mView != null)
                        {
                            fragment.mInnerView = fragment.mView;
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                FE70._mth02CA(fragment.mView, false);
                            } else
                            {
                                fragment.mView = _cls02C7._mth02CF(fragment.mView);
                            }
                            if (viewgroup != null)
                            {
                                Animation animation1 = _mth02CA(fragment, j, true, k);
                                if (animation1 != null)
                                {
                                    _mth02CB(fragment.mView, animation1);
                                    fragment.mView.startAnimation(animation1);
                                }
                                viewgroup.addView(fragment.mView);
                            }
                            if (fragment.mHidden)
                            {
                                fragment.mView.setVisibility(8);
                            }
                            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                        } else
                        {
                            fragment.mInnerView = null;
                        }
                    }
                    fragment.performActivityCreated(fragment.mSavedFragmentState);
                    if (fragment.mView != null)
                    {
                        fragment.restoreViewState(fragment.mSavedFragmentState);
                    }
                    fragment.mSavedFragmentState = null;
                    k1 = l;
                }
                // fall through

            case 2: // '\002'
            case 3: // '\003'
                j1 = k1;
                if (k1 > 3)
                {
                    fragment.performStart();
                    j1 = k1;
                }
                // fall through

            case 4: // '\004'
                i = j1;
                if (j1 > 4)
                {
                    fragment.mResumed = true;
                    fragment.performResume();
                    fragment.mSavedFragmentState = null;
                    fragment.mSavedViewState = null;
                    i = j1;
                }
                // fall through

            default:
                l = i;
                break;
            }
        } else
        {
            l = i;
            if (fragment.mState > i)
            {
                switch (fragment.mState)
                {
                default:
                    l = i;
                    break;

                case 5: // '\005'
                    if (i < 5)
                    {
                        fragment.performPause();
                        fragment.mResumed = false;
                    }
                    // fall through

                case 4: // '\004'
                    if (i < 4)
                    {
                        fragment.performStop();
                    }
                    // fall through

                case 3: // '\003'
                    if (i < 3)
                    {
                        fragment.performReallyStop();
                    }
                    // fall through

                case 2: // '\002'
                    if (i < 2)
                    {
                        if (fragment.mView != null && mHost._mth02CB() && fragment.mSavedViewState == null)
                        {
                            _mth02CF(fragment);
                        }
                        fragment.performDestroyView();
                        if (fragment.mView != null && fragment.mContainer != null)
                        {
                            Object obj = null;
                            Animation animation = obj;
                            if (_fld02D0 > 0)
                            {
                                animation = obj;
                                if (!_fld1424)
                                {
                                    animation = _mth02CA(fragment, j, false, k);
                                }
                            }
                            if (animation != null)
                            {
                                fragment.mAnimatingAway = fragment.mView;
                                fragment.mStateAfterAnimating = i;
                                animation.setAnimationListener(new _cls02B9(this, fragment.mView, animation, fragment));
                                fragment.mView.startAnimation(animation);
                            }
                            fragment.mContainer.removeView(fragment.mView);
                        }
                        fragment.mContainer = null;
                        fragment.mView = null;
                        fragment.mInnerView = null;
                    }
                    // fall through

                case 1: // '\001'
                    l = i;
                    if (i > 0)
                    {
                        break;
                    }
                    if (_fld1424 && fragment.mAnimatingAway != null)
                    {
                        View view = fragment.mAnimatingAway;
                        fragment.mAnimatingAway = null;
                        view.clearAnimation();
                    }
                    if (fragment.mAnimatingAway != null)
                    {
                        fragment.mStateAfterAnimating = i;
                        l = 1;
                        break;
                    }
                    if (!fragment.mRetaining)
                    {
                        fragment.performDestroy();
                    }
                    fragment.mCalled = false;
                    fragment.onDetach();
                    if (!fragment.mCalled)
                    {
                        throw new _cls15EE((new StringBuilder("Fragment ")).append(fragment).append(" did not call through to super.onDetach()").toString());
                    }
                    l = i;
                    if (flag)
                    {
                        break;
                    }
                    if (!fragment.mRetaining)
                    {
                        _mth02CE(fragment);
                        l = i;
                    } else
                    {
                        fragment.mHost = null;
                        fragment.mParentFragment = null;
                        fragment.mFragmentManager = null;
                        fragment.mChildFragmentManager = null;
                        l = i;
                    }
                    break;
                }
            }
        }
        fragment.mState = l;
    }

    public final void _mth02CA(Fragment fragment, boolean flag)
    {
        if (_fld1D4B == null)
        {
            _fld1D4B = new ArrayList();
        }
        _mth02CB(fragment);
        if (!fragment.mDetached)
        {
            if (_fld1D4B.contains(fragment))
            {
                throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
            }
            _fld1D4B.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible)
            {
                _fld0E40 = true;
            }
            if (flag)
            {
                _mth02CA(fragment, _fld02D0, 0, 0, false);
            }
        }
    }

    public final void _mth02CA(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            FF9E();
        }
        this;
        JVM INSTR monitorenter ;
        if (_fld1424 || mHost == null)
        {
            throw new IllegalStateException("Activity has been destroyed");
        }
        if (_fld15EE == null)
        {
            _fld15EE = new ArrayList();
        }
        _fld15EE.add(runnable);
        if (_fld15EE.size() == 1)
        {
            mHost.mHandler.removeCallbacks(_fld1D53);
            mHost.mHandler.post(_fld1D53);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    public final void _mth02CA(_cls0640 _pcls0640, _cls02CD _pcls02cd, Fragment fragment)
    {
        if (mHost != null)
        {
            throw new IllegalStateException("Already attached");
        } else
        {
            mHost = _pcls0640;
            _fld02E3 = _pcls02cd;
            _fld05D5 = fragment;
            return;
        }
    }

    final boolean _mth02CA(String s, int i, int j)
    {
        if (FF9F == null)
        {
            return false;
        }
        if (i < 0 && (j & 1) == 0)
        {
            i = FF9F.size() - 1;
            if (i < 0)
            {
                return false;
            }
            s = (_cls141D)FF9F.remove(i);
            SparseArray sparsearray = new SparseArray();
            SparseArray sparsearray1 = new SparseArray();
            s._mth02CB(sparsearray, sparsearray1);
            s._mth02CA(true, null, sparsearray, sparsearray1);
        } else
        {
            int k = -1;
            if (i >= 0)
            {
                int l = FF9F.size() - 1;
                do
                {
                    if (l < 0)
                    {
                        break;
                    }
                    s = (_cls141D)FF9F.get(l);
                    if (i >= 0 && i == ((_cls141D) (s)).mIndex)
                    {
                        break;
                    }
                    l--;
                } while (true);
                if (l < 0)
                {
                    return false;
                }
                k = l;
                if ((j & 1) != 0)
                {
                    j = l - 1;
                    do
                    {
                        k = j;
                        if (j < 0)
                        {
                            break;
                        }
                        s = (_cls141D)FF9F.get(j);
                        k = j;
                        if (i < 0)
                        {
                            break;
                        }
                        k = j;
                        if (i != ((_cls141D) (s)).mIndex)
                        {
                            break;
                        }
                        j--;
                    } while (true);
                }
            }
            if (k == FF9F.size() - 1)
            {
                return false;
            }
            ArrayList arraylist = new ArrayList();
            for (i = FF9F.size() - 1; i > k; i--)
            {
                arraylist.add(FF9F.remove(i));
            }

            j = arraylist.size() - 1;
            SparseArray sparsearray2 = new SparseArray();
            SparseArray sparsearray3 = new SparseArray();
            for (i = 0; i <= j; i++)
            {
                ((_cls141D)arraylist.get(i))._mth02CB(sparsearray2, sparsearray3);
            }

            s = null;
            for (i = 0; i <= j; i++)
            {
                _cls141D _lcls141d = (_cls141D)arraylist.get(i);
                boolean flag;
                if (i == j)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s = _lcls141d._mth02CA(flag, s, sparsearray2, sparsearray3);
            }

        }
        return true;
    }

    public final void _mth02CB(Fragment fragment, int i, int j)
    {
        if (!fragment.mHidden)
        {
            fragment.mHidden = true;
            if (fragment.mView != null)
            {
                Animation animation = _mth02CA(fragment, i, false, j);
                if (animation != null)
                {
                    _mth02CB(fragment.mView, animation);
                    fragment.mView.startAnimation(animation);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
            {
                _fld0E40 = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public final void _mth02CE(Fragment fragment, int i, int j)
    {
        if (fragment.mHidden)
        {
            fragment.mHidden = false;
            if (fragment.mView != null)
            {
                Animation animation = _mth02CA(fragment, i, true, j);
                if (animation != null)
                {
                    _mth02CB(fragment.mView, animation);
                    fragment.mView.startAnimation(animation);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)
            {
                _fld0E40 = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public final void _mth02CF(Fragment fragment, int i, int j)
    {
        if (!fragment.mDetached)
        {
            fragment.mDetached = true;
            if (fragment.mAdded)
            {
                if (_fld1D4B != null)
                {
                    _fld1D4B.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible)
                {
                    _fld0E40 = true;
                }
                fragment.mAdded = false;
                _mth02CA(fragment, 1, i, j, false);
            }
        }
    }

    public final void _mth141D(Fragment fragment, int i, int j)
    {
        if (fragment.mDetached)
        {
            fragment.mDetached = false;
            if (!fragment.mAdded)
            {
                if (_fld1D4B == null)
                {
                    _fld1D4B = new ArrayList();
                }
                if (_fld1D4B.contains(fragment))
                {
                    throw new IllegalStateException((new StringBuilder("Fragment already added: ")).append(fragment).toString());
                }
                _fld1D4B.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible)
                {
                    _fld0E40 = true;
                }
                _mth02CA(fragment, _fld02D0, i, j, false);
            }
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _fld1508 = flag;
        new AccelerateInterpolator(2.5F);
        new AccelerateInterpolator(1.5F);
    }
}
