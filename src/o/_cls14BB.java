// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls150B, _cls1551, _cls1422

final class _cls14BB extends _cls150B
{

    private _cls1422 _fld14D1;

    _cls14BB(_cls1422 _pcls1422)
    {
        _fld14D1 = _pcls1422;
        super();
    }

    protected final Object _mth02CA(int i, Object obj)
    {
        _cls1422 _lcls1422 = _fld14D1;
        i = (i << 1) + 1;
        Object obj1 = ((_cls1551) (_lcls1422)).FB48[i];
        ((_cls1551) (_lcls1422)).FB48[i] = obj;
        return obj1;
    }

    protected final void _mth02CA(Object obj, Object obj1)
    {
        _fld14D1.put(obj, obj1);
    }

    protected final int _mth02CE(Object obj)
    {
        _cls1422 _lcls1422 = _fld14D1;
        if (obj == null)
        {
            return _lcls1422._mth1D55();
        } else
        {
            return _lcls1422.indexOf(obj, obj.hashCode());
        }
    }

    protected final Object _mth02CE(int i, int j)
    {
        return _fld14D1.FB48[(i << 1) + j];
    }

    protected final int _mth02CF(Object obj)
    {
        return _fld14D1.indexOfValue(obj);
    }

    protected final int _mth1420()
    {
        return _fld14D1._fld1D61;
    }

    protected final _cls1422 _mth1423()
    {
        return _fld14D1;
    }

    protected final void _mth1429()
    {
        _fld14D1.clear();
    }

    protected final void _mth1FBE(int i)
    {
        _fld14D1.removeAt(i);
    }
}
