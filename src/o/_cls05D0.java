// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF54, _cls1489, _cls0E1A, _cls05E2, 
//            _cls03BF, _cls01AC, FC62, _cls06BA, 
//            FC60, FEE9

public final class _cls05D0
    implements FF54
{

    private final FC62 nd = _cls01AC._mth1FD1();
    private final _cls1489 pa;
    private final _cls05E2 pb;
    private final _cls03BF pc = new _cls03BF();

    public _cls05D0(_cls06BA _pcls06ba, FC60 fc60)
    {
        pa = new _cls1489(new _cls0E1A(_pcls06ba, fc60));
        pb = new _cls05E2(_pcls06ba, fc60);
    }

    public final FEE9 _mth4E28()
    {
        return pa;
    }

    public final FEE9 _mth6C35()
    {
        return pb;
    }

    public final FC62 _mth706C()
    {
        return nd;
    }

    public final FC62 FB59()
    {
        return pc;
    }
}
