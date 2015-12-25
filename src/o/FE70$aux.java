// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

// Referenced classes of package o:
//            FE70, _cls1601, _cls0130, _cls1646

static class w.View extends 
{

    static Field _fld203F;
    static boolean _fld2040 = false;

    public boolean _mth02BD(View view)
    {
        if (_fld2040)
        {
            return false;
        }
        if (_fld203F == null)
        {
            try
            {
                Field field = android/view/View.getDeclaredField("mAccessibilityDelegate");
                _fld203F = field;
                field.setAccessible(true);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                _fld2040 = true;
                return false;
            }
        }
        try
        {
            view = ((View) (_fld203F.get(view)));
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            _fld2040 = true;
            return false;
        }
        return view != null;
    }

    public void _mth02CA(View view, _cls1601 _pcls1601)
    {
        if (_pcls1601 == null)
        {
            _pcls1601 = null;
        } else
        {
            _pcls1601 = ((_cls1601) (_pcls1601.FB1D()));
        }
        _cls0130._mth02CE(view, _pcls1601);
    }

    public boolean _mth02CA(View view, int i)
    {
        return _cls0130._mth02CA(view, i);
    }

    public boolean _mth02CB(View view, int i)
    {
        return _cls0130._mth02CB(view, i);
    }

    public _cls1646 _mth1428(View view)
    {
        if (_fld1FD1 == null)
        {
            _fld1FD1 = new WeakHashMap();
        }
        _cls1646 _lcls1646_1 = (_cls1646)_fld1FD1.get(view);
        _cls1646 _lcls1646 = _lcls1646_1;
        if (_lcls1646_1 == null)
        {
            _lcls1646 = new _cls1646(view);
            _fld1FD1.put(view, _lcls1646);
        }
        return _lcls1646;
    }


    w.View()
    {
    }
}
