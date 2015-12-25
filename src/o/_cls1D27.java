// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            _cls1647, _cls1D3C, _cls14FF, _cls0EB2, 
//            _cls1D0F, _cls1F33, FF56, FF74, 
//            _cls1F32, _cls2110, FE93, _cls2148

public final class _cls1D27 extends _cls1647
{

    public final _cls2110 jj;
    public final _cls2110 jk;
    public final _cls1D5A._cls02CA jm;

    _cls1D27(Class class1, _cls2110 _pcls2110, _cls2110 _pcls2110_1, Context context, _cls1D3C _pcls1d3c, FE93 fe93, _cls2148 _pcls2148, 
            _cls1D5A._cls02CA _pcls02ca)
    {
        Object obj;
        if (_pcls2110 == null && _pcls2110_1 == null)
        {
            obj = null;
        } else
        {
            obj = _pcls1d3c.jN._mth02CB(o/14FF, o/0EB2);
            FF54 ff54 = _pcls1d3c.jO._mth02CE(o/1F33, o/14FF);
            obj = new FF74(new _cls1F32(_pcls2110, _pcls2110_1), ((_cls1D08) (obj)), ff54);
        }
        super(context, class1, ((FF74) (obj)), _pcls1d3c, fe93, _pcls2148);
        jj = _pcls2110;
        jk = _pcls2110_1;
        jm = _pcls02ca;
    }
}
