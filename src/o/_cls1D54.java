// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            FE76, FE7A, _cls1D62, _cls2071

class _cls1D54
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    _cls1D54()
    {
    }

    public static Object _mth02CA(Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = ((Transition)obj).clone();
        }
        return obj1;
    }

    public static Object _mth02CA(Object obj, View view, ArrayList arraylist, Map map, View view1)
    {
        if (obj != null)
        {
            _mth02CA(arraylist, view);
            if (map != null)
            {
                arraylist.removeAll(map.values());
            }
            if (arraylist.isEmpty())
            {
                return null;
            }
            arraylist.add(view1);
            _mth02CB((Transition)obj, arraylist);
        }
        return obj;
    }

    public static Object _mth02CA(Object obj, Object obj1, Object obj2, boolean flag)
    {
        boolean flag2 = true;
        Transition transition = (Transition)obj;
        obj = (Transition)obj1;
        obj2 = (Transition)obj2;
        boolean flag1 = flag2;
        if (transition != null)
        {
            flag1 = flag2;
            if (obj != null)
            {
                flag1 = flag;
            }
        }
        if (flag1)
        {
            obj1 = new TransitionSet();
            if (transition != null)
            {
                ((TransitionSet) (obj1)).addTransition(transition);
            }
            if (obj != null)
            {
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj)));
            }
            if (obj2 != null)
            {
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj2)));
            }
            return obj1;
        }
        obj1 = null;
        if (obj != null && transition != null)
        {
            obj = (new TransitionSet()).addTransition(((Transition) (obj))).addTransition(transition).setOrdering(1);
        } else
        if (obj == null)
        {
            obj = obj1;
            if (transition != null)
            {
                obj = transition;
            }
        }
        if (obj2 != null)
        {
            obj1 = new TransitionSet();
            if (obj != null)
            {
                ((TransitionSet) (obj1)).addTransition(((Transition) (obj)));
            }
            ((TransitionSet) (obj1)).addTransition(((Transition) (obj2)));
            return obj1;
        } else
        {
            return obj;
        }
    }

    public static String _mth02CA(View view)
    {
        return view.getTransitionName();
    }

    private static void _mth02CA(Transition transition, if if1)
    {
        if (transition != null)
        {
            transition.setEpicenterCallback(new FE76(if1));
        }
    }

    public static void _mth02CA(View view, View view1, Object obj, ArrayList arraylist, Object obj1, ArrayList arraylist1, Object obj2, ArrayList arraylist2, 
            Object obj3, ArrayList arraylist3, Map map)
    {
        obj = (Transition)obj;
        obj1 = (Transition)obj1;
        obj2 = (Transition)obj2;
        obj3 = (Transition)obj3;
        if (obj3 != null)
        {
            view.getViewTreeObserver().addOnPreDrawListener(new FE7A(view, ((Transition) (obj)), arraylist, ((Transition) (obj1)), arraylist1, ((Transition) (obj2)), arraylist2, map, arraylist3, ((Transition) (obj3)), view1));
        }
    }

    public static void _mth02CA(ViewGroup viewgroup, Object obj)
    {
        TransitionManager.beginDelayedTransition(viewgroup, (Transition)obj);
    }

    public static void _mth02CA(Object obj, View view)
    {
        ((Transition)obj).setEpicenterCallback(new _cls1D62(_mth02CB(view)));
    }

    public static void _mth02CA(Object obj, View view, Map map, ArrayList arraylist)
    {
        obj = (TransitionSet)obj;
        arraylist.clear();
        arraylist.addAll(map.values());
        map = ((TransitionSet) (obj)).getTargets();
        map.clear();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            _mth02CA(((List) (map)), (View)arraylist.get(i));
        }

        arraylist.add(view);
        _mth02CB(obj, arraylist);
    }

    public static void _mth02CA(Object obj, View view, boolean flag)
    {
        ((Transition)obj).excludeTarget(view, flag);
    }

    public static void _mth02CA(Object obj, Object obj1, View view, _cls02CA _pcls02ca, View view1, if if1, Map map, ArrayList arraylist, 
            Map map1, Map map2, ArrayList arraylist1)
    {
        if (obj != null || obj1 != null)
        {
            obj = (Transition)obj;
            if (obj != null)
            {
                ((Transition) (obj)).addTarget(view1);
            }
            if (obj1 != null)
            {
                _mth02CA(obj1, view1, map1, arraylist1);
            }
            if (_pcls02ca != null)
            {
                view.getViewTreeObserver().addOnPreDrawListener(new _cls2071(view, ((Transition) (obj)), view1, _pcls02ca, map, map2, arraylist));
            }
            _mth02CA(((Transition) (obj)), if1);
        }
    }

    public static void _mth02CA(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        if (obj instanceof TransitionSet)
        {
            obj = (TransitionSet)obj;
            int k = ((TransitionSet) (obj)).getTransitionCount();
            for (int i = 0; i < k; i++)
            {
                _mth02CA(((TransitionSet) (obj)).getTransitionAt(i), arraylist);
            }

            return;
        }
        if (!_mth02CA(((Transition) (obj))))
        {
            List list = ((Transition) (obj)).getTargets();
            if (list != null && list.size() == arraylist.size() && list.containsAll(arraylist))
            {
                for (int j = arraylist.size() - 1; j >= 0; j--)
                {
                    ((Transition) (obj)).removeTarget((View)arraylist.get(j));
                }

            }
        }
    }

    private static void _mth02CA(ArrayList arraylist, View view)
    {
        if (view.getVisibility() == 0)
        {
            if (view instanceof ViewGroup)
            {
                view = (ViewGroup)view;
                if (view.isTransitionGroup())
                {
                    arraylist.add(view);
                    return;
                }
                int j = view.getChildCount();
                for (int i = 0; i < j; i++)
                {
                    _mth02CA(arraylist, view.getChildAt(i));
                }

                return;
            }
            arraylist.add(view);
        }
    }

    private static void _mth02CA(List list, View view)
    {
        int k = list.size();
        if (_mth02CA(list, view, k))
        {
            return;
        }
        list.add(view);
        for (int i = k; i < list.size(); i++)
        {
            view = (View)list.get(i);
            if (!(view instanceof ViewGroup))
            {
                continue;
            }
            view = (ViewGroup)view;
            int l = view.getChildCount();
            for (int j = 0; j < l; j++)
            {
                View view1 = view.getChildAt(j);
                if (!_mth02CA(list, view1, k))
                {
                    list.add(view1);
                }
            }

        }

    }

    public static void _mth02CA(Map map, View view)
    {
        if (view.getVisibility() == 0)
        {
            String s = view.getTransitionName();
            if (s != null)
            {
                map.put(s, view);
            }
            if (view instanceof ViewGroup)
            {
                view = (ViewGroup)view;
                int j = view.getChildCount();
                for (int i = 0; i < j; i++)
                {
                    _mth02CA(map, view.getChildAt(i));
                }

            }
        }
    }

    private static boolean _mth02CA(Transition transition)
    {
        return !_mth02CA(transition.getTargetIds()) || !_mth02CA(transition.getTargetNames()) || !_mth02CA(transition.getTargetTypes());
    }

    private static boolean _mth02CA(List list)
    {
        return list == null || list.isEmpty();
    }

    private static boolean _mth02CA(List list, View view, int i)
    {
        for (int j = 0; j < i; j++)
        {
            if (list.get(j) == view)
            {
                return true;
            }
        }

        return false;
    }

    private static Rect _mth02CB(View view)
    {
        Rect rect = new Rect();
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        rect.set(ai[0], ai[1], ai[0] + view.getWidth(), ai[1] + view.getHeight());
        return rect;
    }

    public static Object _mth02CB(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        obj = (Transition)obj;
        if (obj == null)
        {
            return null;
        } else
        {
            TransitionSet transitionset = new TransitionSet();
            transitionset.addTransition(((Transition) (obj)));
            return transitionset;
        }
    }

    public static void _mth02CB(Object obj, ArrayList arraylist)
    {
        obj = (Transition)obj;
        if (obj instanceof TransitionSet)
        {
            obj = (TransitionSet)obj;
            int k = ((TransitionSet) (obj)).getTransitionCount();
            for (int i = 0; i < k; i++)
            {
                _mth02CB(((TransitionSet) (obj)).getTransitionAt(i), arraylist);
            }

            return;
        }
        if (!_mth02CA(((Transition) (obj))) && _mth02CA(((Transition) (obj)).getTargets()))
        {
            int l = arraylist.size();
            for (int j = 0; j < l; j++)
            {
                ((Transition) (obj)).addTarget((View)arraylist.get(j));
            }

        }
    }

    static void _mth02CB(ArrayList arraylist, View view)
    {
        _mth02CA(arraylist, view);
    }

    static Rect _mth02CE(View view)
    {
        return _mth02CB(view);
    }
}
