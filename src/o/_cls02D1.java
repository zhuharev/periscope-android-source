// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package o:
//            _cls0640, _cls1428

public class _cls02D1
{

    final _cls0640 mHost;

    public _cls02D1()
    {
    }

    _cls02D1(_cls0640 _pcls0640)
    {
        mHost = _pcls0640;
    }

    public final List _mth02CA(ArrayList arraylist)
    {
        if (mHost.mFragmentManager._fld1D40 == null)
        {
            return null;
        } else
        {
            arraylist.addAll(mHost.mFragmentManager._fld1D40);
            return arraylist;
        }
    }
}
