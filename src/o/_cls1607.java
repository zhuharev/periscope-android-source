// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;

// Referenced classes of package o:
//            _cls159F, _cls1D2E, _cls1D3C, _cls1D0F, 
//            _cls1F33, FF56, FF74, _cls1F32, 
//            _cls2110, _cls1D27

public final class _cls1607 extends _cls159F
{

    private final _cls2110 jj;
    private final _cls2110 jk;
    private final _cls1D3C jl;
    private final _cls1D5A._cls02CA jm;

    public _cls1607(_cls1D27 _pcls1d27, _cls2110 _pcls2110, _cls2110 _pcls2110_1, _cls1D5A._cls02CA _pcls02ca)
    {
        Object obj1 = ((_cls1D2E) (_pcls1d27)).jl;
        Object obj;
        if (_pcls2110 == null && _pcls2110_1 == null)
        {
            obj = null;
        } else
        {
            obj = ((_cls1D3C) (obj1)).jN._mth02CB(android/graphics/Bitmap, android/graphics/Bitmap);
            obj1 = ((_cls1D3C) (obj1)).jO._mth02CE(o/1F33, android/graphics/Bitmap);
            obj = new FF74(new _cls1F32(_pcls2110, _pcls2110_1), ((_cls1D08) (obj)), ((FF54) (obj1)));
        }
        super(((FF74) (obj)), android/graphics/Bitmap, _pcls1d27);
        jj = _pcls2110;
        jk = _pcls2110_1;
        jl = ((_cls1D2E) (_pcls1d27)).jl;
        jm = _pcls02ca;
    }
}
