// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls0295, _cls1E3B

class _cls0296 extends _cls1E3B._cls02CA
{

    final _cls0295._cls02CA al;
    final _cls0295 am;

    _cls0296(_cls0295 _pcls0295, View view, _cls0295._cls02CA _pcls02ca)
    {
        am = _pcls0295;
        al = _pcls02ca;
        super(view);
    }

    public _cls1E3B _mth0457()
    {
        return al;
    }

    public boolean _mth04C0()
    {
        if (!_cls0295._mth02CA(am).isShowing())
        {
            _cls0295._mth02CA(am).show();
        }
        return true;
    }
}
