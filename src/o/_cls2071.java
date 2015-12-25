// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls1D54

final class _cls2071
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    final View _fld1422;
    final Transition _fld14BB;
    final View _fld1505;
    final _cls1D54._cls02CA _fld1509;
    final Map _fld150A;
    final Map _fld150B;
    final ArrayList _fld1541;

    _cls2071(View view, Transition transition, View view1, _cls1D54._cls02CA _pcls02ca, Map map, Map map1, ArrayList arraylist)
    {
        _fld1422 = view;
        _fld14BB = transition;
        _fld1505 = view1;
        _fld1509 = _pcls02ca;
        _fld150A = map;
        _fld150B = map1;
        _fld1541 = arraylist;
        super();
    }

    public final boolean onPreDraw()
    {
        _fld1422.getViewTreeObserver().removeOnPreDrawListener(this);
        if (_fld14BB != null)
        {
            _fld14BB.removeTarget(_fld1505);
        }
        View view = _fld1509.getView();
        if (view != null)
        {
            if (!_fld150A.isEmpty())
            {
                _cls1D54._mth02CA(_fld150B, view);
                _fld150B.keySet().retainAll(_fld150A.values());
                Iterator iterator = _fld150A.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Object obj = (String)entry.getValue();
                    obj = (View)_fld150B.get(obj);
                    if (obj != null)
                    {
                        ((View) (obj)).setTransitionName((String)entry.getKey());
                    }
                } while (true);
            }
            if (_fld14BB != null)
            {
                _cls1D54._mth02CB(_fld1541, view);
                _fld1541.removeAll(_fld150B.values());
                _fld1541.add(_fld1505);
                _cls1D54._mth02CB(_fld14BB, _fld1541);
            }
        }
        return true;
    }
}
