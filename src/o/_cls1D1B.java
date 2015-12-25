// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls1D10, _cls0445, _cls1E3B

final class _cls1D1B extends _cls1E3B._cls02CA
{

    private _cls1D10 _fld1FEB;
    private _cls1D10._cls02CE _fld212A;

    _cls1D1B(_cls1D10._cls02CE _pcls02ce, _cls1D10._cls02CE _pcls02ce1, _cls1D10 _pcls1d10)
    {
        _fld212A = _pcls02ce;
        _fld1FEB = _pcls1d10;
        super(_pcls02ce1);
    }

    public final _cls1E3B _mth0457()
    {
        if (_fld212A._fld1FE8._fld1D46 == null)
        {
            return null;
        } else
        {
            return ((_cls0445) (_fld212A._fld1FE8._fld1D46)).FF93;
        }
    }

    public final boolean _mth04C0()
    {
        _fld212A._fld1FE8.showOverflowMenu();
        return true;
    }

    public final boolean FBFE()
    {
        if (_fld212A._fld1FE8._fld1E38 != null)
        {
            return false;
        } else
        {
            _fld212A._fld1FE8.hideOverflowMenu();
            return true;
        }
    }
}
