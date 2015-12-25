// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls0E30, _cls148D, _cls0645, _cls06BA, 
//            _cls14D7, _cls1D3C

public final class _cls14D3 extends _cls0E30
{

    public _cls14D3(_cls148D _pcls148d)
    {
        super(_pcls148d);
    }

    public final int getSize()
    {
        return ((_cls148D)pz).pF.data.length + _cls0645._mth037A(((_cls148D)pz).pF.pQ);
    }

    public final void recycle()
    {
        ((_cls148D)pz).stop();
        _cls148D _lcls148d = (_cls148D)pz;
        _lcls148d.ni = true;
        _lcls148d.pF.je._mth02BD(_lcls148d.pF.pQ);
        _cls14D7 _lcls14d7 = _lcls148d.pH;
        _lcls14d7.pI = false;
        if (_lcls14d7.pY != null)
        {
            _cls1D3C._mth02CA(_lcls14d7.pY);
            _lcls14d7.pY = null;
        }
        _lcls14d7.pZ = true;
        _lcls148d.pH.pI = false;
    }
}
