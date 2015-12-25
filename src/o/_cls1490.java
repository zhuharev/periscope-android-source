// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            FF54, _cls14FB, _cls1489, _cls14FE, 
//            FB31, _cls06BA, FEE9, FC62

public final class _cls1490
    implements FF54
{

    private final _cls14FB pR;
    private final _cls14FE pS;
    private final FB31 pu = new FB31();
    private final _cls1489 pv;

    public _cls1490(Context context, _cls06BA _pcls06ba)
    {
        pR = new _cls14FB(context, _pcls06ba);
        pv = new _cls1489(pR);
        pS = new _cls14FE(_pcls06ba);
    }

    public final FEE9 _mth4E28()
    {
        return pv;
    }

    public final FEE9 _mth6C35()
    {
        return pR;
    }

    public final FC62 _mth706C()
    {
        return pu;
    }

    public final FC62 FB59()
    {
        return pS;
    }
}
