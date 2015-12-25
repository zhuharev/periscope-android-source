// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF54, _cls1503, _cls1489, _cls1529, 
//            _cls1526, FC62, _cls0688, _cls1490, 
//            _cls06BA, FEE9

public final class _cls152E
    implements FF54
{

    private final FC62 nd;
    private final _cls1489 pa;
    private final _cls1503 qA;
    private final _cls1526 qB;

    public _cls152E(_cls0688 _pcls0688, _cls1490 _pcls1490, _cls06BA _pcls06ba)
    {
        _pcls06ba = new _cls1503(_pcls0688._mth6C35(), _pcls1490._mth6C35(), _pcls06ba);
        pa = new _cls1489(new _cls1529(_pcls06ba));
        qA = _pcls06ba;
        qB = new _cls1526(_pcls0688.FB59(), _pcls1490.FB59());
        nd = _pcls0688._mth706C();
    }

    public final FEE9 _mth4E28()
    {
        return pa;
    }

    public final FEE9 _mth6C35()
    {
        return qA;
    }

    public final FC62 _mth706C()
    {
        return nd;
    }

    public final FC62 FB59()
    {
        return qB;
    }
}
