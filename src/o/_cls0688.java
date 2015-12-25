// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF54, _cls1F34, _cls0671, FEE9, 
//            FC62, _cls093D, _cls05D0

public final class _cls0688
    implements FF54
{

    private final FEE9 na;
    private final FC62 nc;
    private final _cls0671 pr;
    private final _cls1F34 ps;

    public _cls0688(_cls093D _pcls093d, _cls05D0 _pcls05d0)
    {
        nc = _pcls093d.FB59();
        ps = new _cls1F34(_pcls093d._mth706C(), _pcls05d0._mth706C());
        na = _pcls093d._mth4E28();
        pr = new _cls0671(_pcls093d._mth6C35(), _pcls05d0._mth6C35());
    }

    public final FEE9 _mth4E28()
    {
        return na;
    }

    public final FEE9 _mth6C35()
    {
        return pr;
    }

    public final FC62 _mth706C()
    {
        return ps;
    }

    public final FC62 FB59()
    {
        return nc;
    }
}
