// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls013E, _cls1E3B

final class ew.View extends A
{

    private _cls013E _fld14B0;

    public final _cls1E3B _mth0457()
    {
        if (_cls013E._mth02CA(_fld14B0) != null)
        {
            return _cls013E._mth02CA(_fld14B0)._mth0457();
        } else
        {
            return null;
        }
    }

    protected final boolean _mth04C0()
    {
        if (_cls013E._mth02CB(_fld14B0) != null && _cls013E._mth02CB(_fld14B0)._mth02CF(_cls013E._mth02CE(_fld14B0)))
        {
            _cls1E3B _lcls1e3b = _mth0457();
            return _lcls1e3b != null && _lcls1e3b.isShowing();
        } else
        {
            return false;
        }
    }

    public ew.View(_cls013E _pcls013e)
    {
        _fld14B0 = _pcls013e;
        super(_pcls013e);
    }
}
