// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            _cls0433, _cls026A

class _cls068A
    implements _cls0E27.if
{

    final _cls0433 _fld05E5;
    final _cls0433._cls02CB _fld0690;

    _cls068A(_cls0433._cls02CB _pcls02cb, _cls0433 _pcls0433)
    {
        _fld0690 = _pcls02cb;
        _fld05E5 = _pcls0433;
        super();
    }

    public List findAccessibilityNodeInfosByText(String s, int i)
    {
        s = _fld05E5.findAccessibilityNodeInfosByText(s, i);
        ArrayList arraylist = new ArrayList();
        int j = s.size();
        for (i = 0; i < j; i++)
        {
            arraylist.add(((_cls026A)s.get(i))._mth01C3());
        }

        return arraylist;
    }

    public boolean performAction(int i, int j, Bundle bundle)
    {
        return _fld05E5.performAction(i, j, bundle);
    }

    public Object _mth02B9(int i)
    {
        _cls026A _lcls026a = _fld05E5.FE73(i);
        if (_lcls026a == null)
        {
            return null;
        } else
        {
            return _lcls026a._mth01C3();
        }
    }

    public Object _mth0559(int i)
    {
        _cls026A _lcls026a = _fld05E5.FF9E(i);
        if (_lcls026a == null)
        {
            return null;
        } else
        {
            return _lcls026a._mth01C3();
        }
    }
}
