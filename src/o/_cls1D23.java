// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package o:
//            _cls2148, _cls0645, _cls5196

final class _cls1D23
    implements _cls2148
{

    private boolean pJ;
    private final Set qG = Collections.newSetFromMap(new WeakHashMap());
    private boolean qH;

    _cls1D23()
    {
    }

    final void onDestroy()
    {
        qH = true;
        for (Iterator iterator = _cls0645._mth02CA(qG).iterator(); iterator.hasNext(); ((_cls5196)iterator.next()).onDestroy()) { }
    }

    final void onStart()
    {
        pJ = true;
        for (Iterator iterator = _cls0645._mth02CA(qG).iterator(); iterator.hasNext(); ((_cls5196)iterator.next()).onStart()) { }
    }

    final void onStop()
    {
        pJ = false;
        for (Iterator iterator = _cls0645._mth02CA(qG).iterator(); iterator.hasNext(); ((_cls5196)iterator.next()).onStop()) { }
    }

    public final void _mth02CA(_cls5196 _pcls5196)
    {
        qG.add(_pcls5196);
        if (qH)
        {
            _pcls5196.onDestroy();
            return;
        }
        if (pJ)
        {
            _pcls5196.onStart();
            return;
        } else
        {
            _pcls5196.onStop();
            return;
        }
    }
}
