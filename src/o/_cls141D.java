// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1D4E, _cls1428, _cls0640, _cls1422, 
//            _cls1D54, _cls150B, _cls02CD, _cls1551, 
//            _cls02BC, _cls02BB, _cls02BD, _cls02BF

public final class _cls141D extends _cls1D4E
    implements Runnable
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static boolean _fld141D;
    public int mIndex;
    public String mName;
    private _cls1428 _fld02BB;
    public if _fld02BC;
    private if _fld02BD;
    public int _fld02BE;
    public boolean _fld02BF;
    private boolean _fld02C8;
    private boolean _fld02C9;
    public int _fld02CC;
    public CharSequence _fld02CD;
    public int _fld02D1;
    public int _fld037A;
    public CharSequence _fld0640;
    public ArrayList _fld1427;
    public ArrayList _fld1428;
    public int _fld1FBE;

    public _cls141D(_cls1428 _pcls1428)
    {
        _fld02C8 = true;
        mIndex = -1;
        _fld02BB = _pcls1428;
    }

    private int _mth02CA(boolean flag)
    {
        if (_fld02C9)
        {
            throw new IllegalStateException("commit already called");
        }
        boolean flag1 = _cls1428.DEBUG;
        _fld02C9 = true;
        if (_fld02BF)
        {
            mIndex = _fld02BB._mth02CA(this);
        } else
        {
            mIndex = -1;
        }
        _fld02BB._mth02CA(this, flag);
        return mIndex;
    }

    private _cls02CA _mth02CA(SparseArray sparsearray, SparseArray sparsearray1, boolean flag)
    {
        _cls02CA _lcls02ca = new _cls02CA();
        _lcls02ca._fld144A = new View(_fld02BB.mHost.mContext);
        boolean flag1 = false;
        for (int i = 0; i < sparsearray.size(); i++)
        {
            if (_mth02CA(sparsearray.keyAt(i), _lcls02ca, flag, sparsearray, sparsearray1))
            {
                flag1 = true;
            }
        }

        for (int j = 0; j < sparsearray1.size();)
        {
            int k = sparsearray1.keyAt(j);
            boolean flag2 = flag1;
            if (sparsearray.get(k) == null)
            {
                flag2 = flag1;
                if (_mth02CA(k, _lcls02ca, flag, sparsearray, sparsearray1))
                {
                    flag2 = true;
                }
            }
            j++;
            flag1 = flag2;
        }

        sparsearray = _lcls02ca;
        if (!flag1)
        {
            sparsearray = null;
        }
        return sparsearray;
    }

    private static _cls1422 _mth02CA(ArrayList arraylist, ArrayList arraylist1, _cls1422 _pcls1422)
    {
        if (_pcls1422.isEmpty())
        {
            return _pcls1422;
        }
        _cls1422 _lcls1422 = new _cls1422();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            View view = (View)_pcls1422.get(arraylist.get(i));
            if (view != null)
            {
                _lcls1422.put(arraylist1.get(i), view);
            }
        }

        return _lcls1422;
    }

    private _cls1422 _mth02CA(_cls02CA _pcls02ca, Fragment fragment, boolean flag)
    {
        _cls1422 _lcls1422_1 = new _cls1422();
        _cls1422 _lcls1422 = _lcls1422_1;
        if (_fld1427 != null)
        {
            _cls1D54._mth02CA(_lcls1422_1, fragment.getView());
            if (flag)
            {
                _cls150B._mth02CA(_lcls1422_1, _fld1428);
                _lcls1422 = _lcls1422_1;
            } else
            {
                _lcls1422 = _mth02CA(_fld1427, _fld1428, _lcls1422_1);
            }
        }
        if (flag)
        {
            _mth02CA(_pcls02ca, _lcls1422, false);
            return _lcls1422;
        } else
        {
            _mth02CB(_pcls02ca, _lcls1422, false);
            return _lcls1422;
        }
    }

    static _cls1422 _mth02CA(_cls141D _pcls141d, _cls02CA _pcls02ca, boolean flag, Fragment fragment)
    {
        _cls1422 _lcls1422 = new _cls1422();
        View view = fragment.getView();
        fragment = _lcls1422;
        if (view != null)
        {
            fragment = _lcls1422;
            if (_pcls141d._fld1427 != null)
            {
                _cls1D54._mth02CA(_lcls1422, view);
                if (flag)
                {
                    fragment = _mth02CA(_pcls141d._fld1427, _pcls141d._fld1428, _lcls1422);
                } else
                {
                    _cls150B._mth02CA(_lcls1422, _pcls141d._fld1428);
                    fragment = _lcls1422;
                }
            }
        }
        if (flag)
        {
            _pcls141d._mth02CA(_pcls02ca, ((_cls1422) (fragment)), true);
            return fragment;
        } else
        {
            _mth02CB(_pcls02ca, fragment, true);
            return fragment;
        }
    }

    private static void _mth02CA(SparseArray sparsearray, Fragment fragment)
    {
        if (fragment != null)
        {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparsearray.get(i) == null)
            {
                sparsearray.put(i, fragment);
            }
        }
    }

    private void _mth02CA(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if if1;
        if (!_fld02BB._fld02E3.onHasView())
        {
            return;
        }
        if1 = _fld02BC;
_L16:
        if (if1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if1.FE7A;
        JVM INSTR tableswitch 1 7: default 72
    //                   1 75
    //                   2 106
    //                   3 243
    //                   4 255
    //                   5 267
    //                   6 298
    //                   7 310;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        Fragment fragment = if1.FF70;
        if (fragment == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = fragment.mContainerId;
        if (i != 0)
        {
            sparsearray1.put(i, fragment);
        }
        break; /* Loop/switch isn't completed */
_L3:
        Fragment fragment1;
        Fragment fragment4;
        fragment1 = if1.FF70;
        fragment4 = fragment1;
        if (_fld02BB._fld1D4B == null) goto _L10; else goto _L9
_L9:
        int j = 0;
_L14:
        Fragment fragment5;
        fragment4 = fragment1;
        if (j >= _fld02BB._fld1D4B.size())
        {
            break; /* Loop/switch isn't completed */
        }
        fragment5 = (Fragment)_fld02BB._fld1D4B.get(j);
        if (fragment1 == null) goto _L12; else goto _L11
_L11:
        fragment4 = fragment1;
        if (fragment5.mContainerId != fragment1.mContainerId) goto _L13; else goto _L12
_L12:
        if (fragment5 == fragment1)
        {
            fragment4 = null;
        } else
        {
            _mth02CA(sparsearray, fragment5);
            fragment4 = fragment1;
        }
_L13:
        j++;
        fragment1 = fragment4;
        if (true) goto _L14; else goto _L10
_L10:
        if (fragment4 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = fragment4.mContainerId;
        if (k != 0)
        {
            sparsearray1.put(k, fragment4);
        }
        break; /* Loop/switch isn't completed */
_L4:
        _mth02CA(sparsearray, if1.FF70);
        break; /* Loop/switch isn't completed */
_L5:
        _mth02CA(sparsearray, if1.FF70);
        break; /* Loop/switch isn't completed */
_L6:
        Fragment fragment2 = if1.FF70;
        if (fragment2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int l = fragment2.mContainerId;
        if (l != 0)
        {
            sparsearray1.put(l, fragment2);
        }
        break; /* Loop/switch isn't completed */
_L7:
        _mth02CA(sparsearray, if1.FF70);
        break; /* Loop/switch isn't completed */
_L8:
        Fragment fragment3 = if1.FF70;
        if (fragment3 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i1 = fragment3.mContainerId;
        if (i1 != 0)
        {
            sparsearray1.put(i1, fragment3);
        }
        if1 = if1._fld2071;
        if (true) goto _L16; else goto _L15
_L15:
    }

    private void _mth02CA(_cls02CA _pcls02ca, int i, Object obj)
    {
        if (_fld02BB._fld1D4B != null)
        {
            for (int j = 0; j < _fld02BB._fld1D4B.size(); j++)
            {
                Fragment fragment = (Fragment)_fld02BB._fld1D4B.get(j);
                if (fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)
                {
                    continue;
                }
                if (fragment.mHidden)
                {
                    if (!_pcls02ca._fld1423.contains(fragment.mView))
                    {
                        _cls1D54._mth02CA(obj, fragment.mView, true);
                        _pcls02ca._fld1423.add(fragment.mView);
                    }
                } else
                {
                    _cls1D54._mth02CA(obj, fragment.mView, false);
                    _pcls02ca._fld1423.remove(fragment.mView);
                }
            }

        }
    }

    private void _mth02CA(_cls02CA _pcls02ca, _cls1422 _pcls1422, boolean flag)
    {
        int i;
        if (_fld1428 == null)
        {
            i = 0;
        } else
        {
            i = _fld1428.size();
        }
        for (int j = 0; j < i; j++)
        {
            String s = (String)_fld1427.get(j);
            Object obj = (View)_pcls1422.get((String)_fld1428.get(j));
            if (obj == null)
            {
                continue;
            }
            obj = _cls1D54._mth02CA(((View) (obj)));
            if (flag)
            {
                _mth02CA(_pcls02ca._fld1420, s, ((String) (obj)));
            } else
            {
                _mth02CA(_pcls02ca._fld1420, ((String) (obj)), s);
            }
        }

    }

    static void _mth02CA(_cls141D _pcls141d, _cls02CA _pcls02ca, int i, Object obj)
    {
        _pcls141d._mth02CA(_pcls02ca, i, obj);
    }

    static void _mth02CA(_cls141D _pcls141d, _cls02CA _pcls02ca, Fragment fragment, Fragment fragment1, boolean flag, _cls1422 _pcls1422)
    {
        if (flag)
        {
            _pcls141d = fragment1.mEnterTransitionCallback;
        } else
        {
            _pcls141d = fragment.mEnterTransitionCallback;
        }
        if (_pcls141d != null)
        {
            new ArrayList(_pcls1422.keySet());
            new ArrayList(_pcls1422.values());
        }
    }

    static void _mth02CA(_cls141D _pcls141d, _cls1422 _pcls1422, _cls02CA _pcls02ca)
    {
        if (_pcls141d._fld1428 != null && !_pcls1422.isEmpty())
        {
            _pcls141d = (View)_pcls1422.get(_pcls141d._fld1428.get(0));
            if (_pcls141d != null)
            {
                _pcls02ca._fld1429.FB4B = _pcls141d;
            }
        }
    }

    private static void _mth02CA(_cls1422 _pcls1422, String s, String s1)
    {
        if (s != null && s1 != null)
        {
            for (int i = 0; i < _pcls1422.size(); i++)
            {
                if (s.equals(((_cls1551) (_pcls1422)).FB48[(i << 1) + 1]))
                {
                    i = (i << 1) + 1;
                    s = ((String) (((_cls1551) (_pcls1422)).FB48[i]));
                    ((_cls1551) (_pcls1422)).FB48[i] = s1;
                    return;
                }
            }

            _pcls1422.put(s, s1);
        }
    }

    private boolean _mth02CA(int i, _cls02CA _pcls02ca, boolean flag, SparseArray sparsearray, SparseArray sparsearray1)
    {
        ViewGroup viewgroup = (ViewGroup)_fld02BB._fld02E3.onFindViewById(i);
        if (viewgroup == null)
        {
            return false;
        }
        Object obj4 = (Fragment)sparsearray1.get(i);
        Object obj5 = (Fragment)sparsearray.get(i);
        Object obj1;
        if (obj4 == null)
        {
            obj1 = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj4)).getReenterTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj4)).getEnterTransition()));
            }
            obj1 = _cls1D54._mth02CA(sparsearray);
        }
        if (obj4 == null || obj5 == null)
        {
            sparsearray1 = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj5)).getSharedElementReturnTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj4)).getSharedElementEnterTransition()));
            }
            sparsearray1 = ((SparseArray) (_cls1D54._mth02CB(sparsearray)));
        }
        if (obj5 == null)
        {
            sparsearray = null;
        } else
        {
            if (flag)
            {
                sparsearray = ((SparseArray) (((Fragment) (obj5)).getReturnTransition()));
            } else
            {
                sparsearray = ((SparseArray) (((Fragment) (obj5)).getExitTransition()));
            }
            sparsearray = ((SparseArray) (_cls1D54._mth02CA(sparsearray)));
        }
        Object obj = null;
        ArrayList arraylist = new ArrayList();
        Object obj2 = sparsearray1;
        if (sparsearray1 != null)
        {
            obj2 = _mth02CA(_pcls02ca, ((Fragment) (obj5)), flag);
            if (((_cls1422) (obj2)).isEmpty())
            {
                obj2 = null;
                obj = null;
            } else
            {
                if (flag)
                {
                    obj = ((Fragment) (obj5)).mEnterTransitionCallback;
                } else
                {
                    obj = ((Fragment) (obj4)).mEnterTransitionCallback;
                }
                if (obj != null)
                {
                    new ArrayList(((_cls1422) (obj2)).keySet());
                    new ArrayList(((_cls1422) (obj2)).values());
                }
                viewgroup.getViewTreeObserver().addOnPreDrawListener(new _cls02BC(this, viewgroup, sparsearray1, arraylist, _pcls02ca, flag, ((Fragment) (obj4)), ((Fragment) (obj5))));
                obj = obj2;
                obj2 = sparsearray1;
            }
        }
        if (obj1 == null && obj2 == null && sparsearray == null)
        {
            return false;
        }
        ArrayList arraylist1 = new ArrayList();
        View view = _pcls02ca._fld144A;
        Object obj3 = sparsearray;
        sparsearray1 = ((SparseArray) (obj3));
        if (sparsearray != null)
        {
            sparsearray1 = ((SparseArray) (_cls1D54._mth02CA(obj3, ((Fragment) (obj5)).getView(), arraylist1, ((java.util.Map) (obj)), view)));
        }
        if (_fld1428 != null && obj != null)
        {
            sparsearray = (View)((_cls1422) (obj)).get(_fld1428.get(0));
            if (sparsearray != null)
            {
                if (sparsearray1 != null)
                {
                    _cls1D54._mth02CA(sparsearray1, sparsearray);
                }
                if (obj2 != null)
                {
                    _cls1D54._mth02CA(obj2, sparsearray);
                }
            }
        }
        sparsearray = new _cls02BB(this, ((Fragment) (obj4)));
        obj3 = new ArrayList();
        obj5 = new _cls1422();
        boolean flag1 = true;
        if (obj4 != null)
        {
            if (flag)
            {
                flag1 = ((Fragment) (obj4)).getAllowReturnTransitionOverlap();
            } else
            {
                flag1 = ((Fragment) (obj4)).getAllowEnterTransitionOverlap();
            }
        }
        obj4 = _cls1D54._mth02CA(obj1, sparsearray1, obj2, flag1);
        if (obj4 != null)
        {
            _cls1D54._mth02CA(obj1, obj2, viewgroup, sparsearray, _pcls02ca._fld144A, _pcls02ca._fld1429, _pcls02ca._fld1420, ((ArrayList) (obj3)), ((java.util.Map) (obj)), ((java.util.Map) (obj5)), arraylist);
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new _cls02BD(this, viewgroup, _pcls02ca, i, obj4));
            _cls1D54._mth02CA(obj4, _pcls02ca._fld144A, true);
            _mth02CA(_pcls02ca, i, obj4);
            _cls1D54._mth02CA(viewgroup, obj4);
            _cls1D54._mth02CA(viewgroup, _pcls02ca._fld144A, obj1, ((ArrayList) (obj3)), sparsearray1, arraylist1, obj2, arraylist, obj4, _pcls02ca._fld1423, ((java.util.Map) (obj5)));
        }
        return obj4 != null;
    }

    private static void _mth02CB(_cls02CA _pcls02ca, _cls1422 _pcls1422, boolean flag)
    {
        int j = _pcls1422.size();
        for (int i = 0; i < j; i++)
        {
            String s = (String)((_cls1551) (_pcls1422)).FB48[i << 1];
            String s1 = _cls1D54._mth02CA((View)((_cls1551) (_pcls1422)).FB48[(i << 1) + 1]);
            if (flag)
            {
                _mth02CA(_pcls02ca._fld1420, s, s1);
            } else
            {
                _mth02CA(_pcls02ca._fld1420, s1, s);
            }
        }

    }

    public final int commit()
    {
        return _mth02CA(false);
    }

    public final int commitAllowingStateLoss()
    {
        return _mth02CA(true);
    }

    public final void run()
    {
        boolean flag = _cls1428.DEBUG;
        if (_fld02BF && mIndex < 0)
        {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        _mth02CA(1);
        Object obj = null;
        if (_fld141D)
        {
            SparseArray sparsearray = new SparseArray();
            obj = new SparseArray();
            _mth02CA(sparsearray, ((SparseArray) (obj)));
            obj = _mth02CA(sparsearray, ((SparseArray) (obj)), false);
        }
        int i;
        if (obj != null)
        {
            i = 0;
        } else
        {
            i = _fld02BE;
        }
        int j;
        if (obj != null)
        {
            j = 0;
        } else
        {
            j = _fld1FBE;
        }
        for (if if1 = _fld02BC; if1 != null; if1 = if1._fld2071)
        {
            int k;
            if (obj != null)
            {
                k = 0;
            } else
            {
                k = if1._fld02B3;
            }
            int l;
            if (obj != null)
            {
                l = 0;
            } else
            {
                l = if1._fld02B4;
            }
            switch (if1.FE7A)
            {
            case 1: // '\001'
                Fragment fragment = if1.FF70;
                fragment.mNextAnim = k;
                _fld02BB._mth02CA(fragment, false);
                break;

            case 2: // '\002'
                Fragment fragment1 = if1.FF70;
                int j1 = fragment1.mContainerId;
                Fragment fragment7 = fragment1;
                if (_fld02BB._fld1D4B != null)
                {
                    int i1 = 0;
                    do
                    {
                        fragment7 = fragment1;
                        if (i1 >= _fld02BB._fld1D4B.size())
                        {
                            break;
                        }
                        Fragment fragment8 = (Fragment)_fld02BB._fld1D4B.get(i1);
                        boolean flag1 = _cls1428.DEBUG;
                        fragment7 = fragment1;
                        if (fragment8.mContainerId == j1)
                        {
                            if (fragment8 == fragment1)
                            {
                                fragment7 = null;
                                if1.FF70 = null;
                            } else
                            {
                                if (if1._fld02E1 == null)
                                {
                                    if1._fld02E1 = new ArrayList();
                                }
                                if1._fld02E1.add(fragment8);
                                fragment8.mNextAnim = l;
                                if (_fld02BF)
                                {
                                    fragment8.mBackStackNesting = fragment8.mBackStackNesting + 1;
                                    boolean flag2 = _cls1428.DEBUG;
                                }
                                _fld02BB._mth02CA(fragment8, j, i);
                                fragment7 = fragment1;
                            }
                        }
                        i1++;
                        fragment1 = fragment7;
                    } while (true);
                }
                if (fragment7 != null)
                {
                    fragment7.mNextAnim = k;
                    _fld02BB._mth02CA(fragment7, false);
                }
                break;

            case 3: // '\003'
                Fragment fragment2 = if1.FF70;
                fragment2.mNextAnim = l;
                _fld02BB._mth02CA(fragment2, j, i);
                break;

            case 4: // '\004'
                Fragment fragment3 = if1.FF70;
                fragment3.mNextAnim = l;
                _fld02BB._mth02CB(fragment3, j, i);
                break;

            case 5: // '\005'
                Fragment fragment4 = if1.FF70;
                fragment4.mNextAnim = k;
                _fld02BB._mth02CE(fragment4, j, i);
                break;

            case 6: // '\006'
                Fragment fragment5 = if1.FF70;
                fragment5.mNextAnim = l;
                _fld02BB._mth02CF(fragment5, j, i);
                break;

            case 7: // '\007'
                Fragment fragment6 = if1.FF70;
                fragment6.mNextAnim = k;
                _fld02BB._mth141D(fragment6, j, i);
                break;

            default:
                throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(if1.FE7A).toString());
            }
        }

        _fld02BB._mth02CA(_fld02BB._fld02D0, j, i, true);
        if (_fld02BF)
        {
            _cls1428 _lcls1428 = _fld02BB;
            if (_lcls1428.FF9F == null)
            {
                _lcls1428.FF9F = new ArrayList();
            }
            _lcls1428.FF9F.add(this);
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("BackStackEntry{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (mIndex >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(mIndex);
        }
        if (mName != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(mName);
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public final _cls02CA _mth02CA(boolean flag, _cls02CA _pcls02ca, SparseArray sparsearray, SparseArray sparsearray1)
    {
        Object obj;
label0:
        {
            boolean flag1 = _cls1428.DEBUG;
            obj = _pcls02ca;
            if (!_fld141D)
            {
                break label0;
            }
            if (_pcls02ca == null)
            {
                if (sparsearray.size() == 0)
                {
                    obj = _pcls02ca;
                    if (sparsearray1.size() == 0)
                    {
                        break label0;
                    }
                }
                obj = _mth02CA(sparsearray, sparsearray1, true);
            } else
            {
                obj = _pcls02ca;
                if (!flag)
                {
                    sparsearray = _fld1428;
                    sparsearray1 = _fld1427;
                    obj = _pcls02ca;
                    if (sparsearray != null)
                    {
                        int i = 0;
                        do
                        {
                            obj = _pcls02ca;
                            if (i >= sparsearray.size())
                            {
                                break;
                            }
                            obj = (String)sparsearray.get(i);
                            String s = (String)sparsearray1.get(i);
                            _mth02CA(_pcls02ca._fld1420, ((String) (obj)), s);
                            i++;
                        } while (true);
                    }
                }
            }
        }
        _mth02CA(-1);
        int j;
        if (obj != null)
        {
            j = 0;
        } else
        {
            j = _fld02BE;
        }
        int l;
        if (obj != null)
        {
            l = 0;
        } else
        {
            l = _fld1FBE;
        }
        for (_pcls02ca = _fld02BD; _pcls02ca != null; _pcls02ca = ((if) (_pcls02ca)).FE76)
        {
            int i1;
            if (obj != null)
            {
                i1 = 0;
            } else
            {
                i1 = ((if) (_pcls02ca))._fld02C6;
            }
            int j1;
            if (obj != null)
            {
                j1 = 0;
            } else
            {
                j1 = ((if) (_pcls02ca))._fld02C7;
            }
            switch (((if) (_pcls02ca)).FE7A)
            {
            case 1: // '\001'
                sparsearray = ((if) (_pcls02ca)).FF70;
                sparsearray.mNextAnim = j1;
                _fld02BB._mth02CA(sparsearray, _cls1428._mth02CF(l), j);
                break;

            case 2: // '\002'
                sparsearray = ((if) (_pcls02ca)).FF70;
                if (sparsearray != null)
                {
                    sparsearray.mNextAnim = j1;
                    _fld02BB._mth02CA(sparsearray, _cls1428._mth02CF(l), j);
                }
                if (((if) (_pcls02ca))._fld02E1 == null)
                {
                    break;
                }
                for (j1 = 0; j1 < ((if) (_pcls02ca))._fld02E1.size(); j1++)
                {
                    sparsearray = (Fragment)((if) (_pcls02ca))._fld02E1.get(j1);
                    sparsearray.mNextAnim = i1;
                    _fld02BB._mth02CA(sparsearray, false);
                }

                break;

            case 3: // '\003'
                sparsearray = ((if) (_pcls02ca)).FF70;
                sparsearray.mNextAnim = i1;
                _fld02BB._mth02CA(sparsearray, false);
                break;

            case 4: // '\004'
                sparsearray = ((if) (_pcls02ca)).FF70;
                sparsearray.mNextAnim = i1;
                _fld02BB._mth02CE(sparsearray, _cls1428._mth02CF(l), j);
                break;

            case 5: // '\005'
                sparsearray = ((if) (_pcls02ca)).FF70;
                sparsearray.mNextAnim = j1;
                _fld02BB._mth02CB(sparsearray, _cls1428._mth02CF(l), j);
                break;

            case 6: // '\006'
                sparsearray = ((if) (_pcls02ca)).FF70;
                sparsearray.mNextAnim = i1;
                _fld02BB._mth141D(sparsearray, _cls1428._mth02CF(l), j);
                break;

            case 7: // '\007'
                sparsearray = ((if) (_pcls02ca)).FF70;
                sparsearray.mNextAnim = i1;
                _fld02BB._mth02CF(sparsearray, _cls1428._mth02CF(l), j);
                break;

            default:
                throw new IllegalArgumentException((new StringBuilder("Unknown cmd: ")).append(((if) (_pcls02ca)).FE7A).toString());
            }
        }

        if (flag)
        {
            _fld02BB._mth02CA(_fld02BB._fld02D0, _cls1428._mth02CF(l), j, true);
            obj = null;
        }
        if (mIndex < 0)
        {
            break MISSING_BLOCK_LABEL_665;
        }
        _pcls02ca = _fld02BB;
        int k = mIndex;
        _pcls02ca;
        JVM INSTR monitorenter ;
        ((_cls1428) (_pcls02ca))._fld01C3.set(k, null);
        if (((_cls1428) (_pcls02ca))._fld02B2 == null)
        {
            _pcls02ca._fld02B2 = new ArrayList();
        }
        ((_cls1428) (_pcls02ca))._fld02B2.add(Integer.valueOf(k));
        _pcls02ca;
        JVM INSTR monitorexit ;
          goto _L1
        sparsearray;
        throw sparsearray;
_L1:
        mIndex = -1;
        return ((_cls02CA) (obj));
    }

    public final _cls141D _mth02CA(Fragment fragment, String s)
    {
        fragment.mFragmentManager = _fld02BB;
        if (s != null)
        {
            if (fragment.mTag != null && !s.equals(fragment.mTag))
            {
                throw new IllegalStateException((new StringBuilder("Can't change tag of fragment ")).append(fragment).append(": was ").append(fragment.mTag).append(" now ").append(s).toString());
            }
            fragment.mTag = s;
        }
        s = new if();
        s.FE7A = 1;
        s.FF70 = fragment;
        _mth02CA(((if) (s)));
        return this;
    }

    public final _cls141D _mth02CA(_cls02BF _pcls02bf)
    {
        if if1 = new if();
        if1.FE7A = 3;
        if1.FF70 = _pcls02bf;
        _mth02CA(if1);
        return this;
    }

    public final void _mth02CA(int i)
    {
        if (!_fld02BF)
        {
            return;
        }
        boolean flag = _cls1428.DEBUG;
        for (if if1 = _fld02BC; if1 != null; if1 = if1._fld2071)
        {
            if (if1.FF70 != null)
            {
                Fragment fragment = if1.FF70;
                fragment.mBackStackNesting = fragment.mBackStackNesting + i;
                boolean flag1 = _cls1428.DEBUG;
            }
            if (if1._fld02E1 == null)
            {
                continue;
            }
            for (int j = if1._fld02E1.size() - 1; j >= 0; j--)
            {
                Fragment fragment1 = (Fragment)if1._fld02E1.get(j);
                fragment1.mBackStackNesting = fragment1.mBackStackNesting + i;
                boolean flag2 = _cls1428.DEBUG;
            }

        }

    }

    public final void _mth02CA(String s, PrintWriter printwriter)
    {
        if (true)
        {
            printwriter.print(s);
            printwriter.print("mName=");
            printwriter.print(mName);
            printwriter.print(" mIndex=");
            printwriter.print(mIndex);
            printwriter.print(" mCommitted=");
            printwriter.println(_fld02C9);
            if (_fld1FBE != 0)
            {
                printwriter.print(s);
                printwriter.print("mTransition=#");
                printwriter.print(Integer.toHexString(_fld1FBE));
                printwriter.print(" mTransitionStyle=#");
                printwriter.println(Integer.toHexString(_fld02BE));
            }
            if (_fld02CC != 0 || _fld02CD != null)
            {
                printwriter.print(s);
                printwriter.print("mBreadCrumbTitleRes=#");
                printwriter.print(Integer.toHexString(_fld02CC));
                printwriter.print(" mBreadCrumbTitleText=");
                printwriter.println(_fld02CD);
            }
            if (_fld02D1 != 0 || _fld0640 != null)
            {
                printwriter.print(s);
                printwriter.print("mBreadCrumbShortTitleRes=#");
                printwriter.print(Integer.toHexString(_fld02D1));
                printwriter.print(" mBreadCrumbShortTitleText=");
                printwriter.println(_fld0640);
            }
        }
        if (_fld02BC != null)
        {
            printwriter.print(s);
            printwriter.println("Operations:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            if if1 = _fld02BC;
            for (int i = 0; if1 != null; i++)
            {
                String s1;
                switch (if1.FE7A)
                {
                case 0: // '\0'
                    s1 = "NULL";
                    break;

                case 1: // '\001'
                    s1 = "ADD";
                    break;

                case 2: // '\002'
                    s1 = "REPLACE";
                    break;

                case 3: // '\003'
                    s1 = "REMOVE";
                    break;

                case 4: // '\004'
                    s1 = "HIDE";
                    break;

                case 5: // '\005'
                    s1 = "SHOW";
                    break;

                case 6: // '\006'
                    s1 = "DETACH";
                    break;

                case 7: // '\007'
                    s1 = "ATTACH";
                    break;

                default:
                    s1 = (new StringBuilder("cmd=")).append(if1.FE7A).toString();
                    break;
                }
                printwriter.print(s);
                printwriter.print("  Op #");
                printwriter.print(i);
                printwriter.print(": ");
                printwriter.print(s1);
                printwriter.print(" ");
                printwriter.println(if1.FF70);
                if (true)
                {
                    if (if1._fld02B3 != 0 || if1._fld02B4 != 0)
                    {
                        printwriter.print(s);
                        printwriter.print("enterAnim=#");
                        printwriter.print(Integer.toHexString(if1._fld02B3));
                        printwriter.print(" exitAnim=#");
                        printwriter.println(Integer.toHexString(if1._fld02B4));
                    }
                    if (if1._fld02C6 != 0 || if1._fld02C7 != 0)
                    {
                        printwriter.print(s);
                        printwriter.print("popEnterAnim=#");
                        printwriter.print(Integer.toHexString(if1._fld02C6));
                        printwriter.print(" popExitAnim=#");
                        printwriter.println(Integer.toHexString(if1._fld02C7));
                    }
                }
                if (if1._fld02E1 != null && if1._fld02E1.size() > 0)
                {
                    for (int j = 0; j < if1._fld02E1.size(); j++)
                    {
                        printwriter.print(s2);
                        if (if1._fld02E1.size() == 1)
                        {
                            printwriter.print("Removed: ");
                        } else
                        {
                            if (j == 0)
                            {
                                printwriter.println("Removed:");
                            }
                            printwriter.print(s2);
                            printwriter.print("  #");
                            printwriter.print(j);
                            printwriter.print(": ");
                        }
                        printwriter.println(if1._fld02E1.get(j));
                    }

                }
                if1 = if1._fld2071;
            }

        }
    }

    public final void _mth02CA(if if1)
    {
        if (_fld02BC == null)
        {
            _fld02BD = if1;
            _fld02BC = if1;
        } else
        {
            if1.FE76 = _fld02BD;
            _fld02BD._fld2071 = if1;
            _fld02BD = if1;
        }
        if1._fld02B3 = 0;
        if1._fld02B4 = 0;
        if1._fld02C6 = 0;
        if1._fld02C7 = 0;
        _fld037A = _fld037A + 1;
    }

    public final void _mth02CB(SparseArray sparsearray, SparseArray sparsearray1)
    {
        if (!_fld02BB._fld02E3.onHasView())
        {
            return;
        }
        for (if if1 = _fld02BC; if1 != null; if1 = if1._fld2071)
        {
            switch (if1.FE7A)
            {
            default:
                break;

            case 1: // '\001'
                _mth02CA(sparsearray, if1.FF70);
                break;

            case 2: // '\002'
                if (if1._fld02E1 != null)
                {
                    for (int i = if1._fld02E1.size() - 1; i >= 0; i--)
                    {
                        Fragment fragment = (Fragment)if1._fld02E1.get(i);
                        if (fragment == null)
                        {
                            continue;
                        }
                        int i1 = fragment.mContainerId;
                        if (i1 != 0)
                        {
                            sparsearray1.put(i1, fragment);
                        }
                    }

                }
                _mth02CA(sparsearray, if1.FF70);
                break;

            case 3: // '\003'
                Fragment fragment1 = if1.FF70;
                if (fragment1 == null)
                {
                    break;
                }
                int j = fragment1.mContainerId;
                if (j != 0)
                {
                    sparsearray1.put(j, fragment1);
                }
                break;

            case 4: // '\004'
                Fragment fragment2 = if1.FF70;
                if (fragment2 == null)
                {
                    break;
                }
                int k = fragment2.mContainerId;
                if (k != 0)
                {
                    sparsearray1.put(k, fragment2);
                }
                break;

            case 5: // '\005'
                _mth02CA(sparsearray, if1.FF70);
                break;

            case 6: // '\006'
                Fragment fragment3 = if1.FF70;
                if (fragment3 == null)
                {
                    break;
                }
                int l = fragment3.mContainerId;
                if (l != 0)
                {
                    sparsearray1.put(l, fragment3);
                }
                break;

            case 7: // '\007'
                _mth02CA(sparsearray, if1.FF70);
                break;
            }
        }

    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _fld141D = flag;
    }
}
