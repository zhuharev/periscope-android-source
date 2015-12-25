// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package o:
//            _cls13A2

final class _cls09A7
{
    /* member class not found */
    class if {}


    private final if nv = new if();
    private final HashMap nw = new HashMap();

    _cls09A7()
    {
    }

    public final Object removeLast()
    {
        for (if if1 = nv.nA; !if1.equals(nv); if1 = if1.nA)
        {
            int i;
            if (if1.ny != null)
            {
                i = if1.ny.size();
            } else
            {
                i = 0;
            }
            Object obj;
            if (i > 0)
            {
                obj = if1.ny.remove(i - 1);
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                return obj;
            }
            if1.nA.nz = if1.nz;
            if1.nz.nA = if1.nA;
            nw.remove(if1.nx);
            ((_cls13A2)if1.nx)._mth1D56();
        }

        return null;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("GroupedLinkedMap( ");
        if if1 = nv.nz;
        int i;
        boolean flag;
        for (i = 0; !if1.equals(nv); i = ((flag) ? 1 : 0))
        {
            flag = true;
            StringBuilder stringbuilder1 = stringbuilder.append('{').append(if1.nx).append(':');
            if (if1.ny != null)
            {
                i = if1.ny.size();
            } else
            {
                i = 0;
            }
            stringbuilder1.append(i).append("}, ");
            if1 = if1.nz;
        }

        if (i != 0)
        {
            stringbuilder.delete(stringbuilder.length() - 2, stringbuilder.length());
        }
        return stringbuilder.append(" )").toString();
    }

    public final Object _mth02CA(_cls13A2 _pcls13a2)
    {
        if if1 = (if)nw.get(_pcls13a2);
        if (if1 == null)
        {
            if1 = new if(_pcls13a2);
            nw.put(_pcls13a2, if1);
            _pcls13a2 = if1;
        } else
        {
            _pcls13a2._mth1D56();
            _pcls13a2 = if1;
        }
        ((if) (_pcls13a2)).nA.nz = ((if) (_pcls13a2)).nz;
        ((if) (_pcls13a2)).nz.nA = ((if) (_pcls13a2)).nA;
        _pcls13a2.nA = nv;
        _pcls13a2.nz = nv.nz;
        ((if) (_pcls13a2)).nz.nA = _pcls13a2;
        ((if) (_pcls13a2)).nA.nz = _pcls13a2;
        int i;
        if (((if) (_pcls13a2)).ny != null)
        {
            i = ((if) (_pcls13a2)).ny.size();
        } else
        {
            i = 0;
        }
        if (i > 0)
        {
            return ((if) (_pcls13a2)).ny.remove(i - 1);
        } else
        {
            return null;
        }
    }

    public final void _mth02CA(_cls13A2 _pcls13a2, Bitmap bitmap)
    {
        if if1 = (if)nw.get(_pcls13a2);
        if (if1 == null)
        {
            if1 = new if(_pcls13a2);
            if1.nA.nz = if1.nz;
            if1.nz.nA = if1.nA;
            if1.nA = nv.nA;
            if1.nz = nv;
            if1.nz.nA = if1;
            if1.nA.nz = if1;
            nw.put(_pcls13a2, if1);
            _pcls13a2 = if1;
        } else
        {
            _pcls13a2._mth1D56();
            _pcls13a2 = if1;
        }
        if (((if) (_pcls13a2)).ny == null)
        {
            _pcls13a2.ny = new ArrayList();
        }
        ((if) (_pcls13a2)).ny.add(bitmap);
    }
}
