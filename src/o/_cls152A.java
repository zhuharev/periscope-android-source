// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF43, _cls14D5, _cls05D4, _cls14FF, 
//            _cls1502, _cls06BA

public final class _cls152A
    implements FF43
{

    private final FF43 qy;
    private final FF43 qz;

    public _cls152A(_cls06BA _pcls06ba, FF43 ff43)
    {
        this(ff43, new _cls14D5(ff43, _pcls06ba));
    }

    private _cls152A(FF43 ff43, _cls14D5 _pcls14d5)
    {
        qy = ff43;
        qz = _pcls14d5;
    }

    public final String getId()
    {
        return qy.getId();
    }

    public final _cls05D4 _mth02CA(_cls05D4 _pcls05d4, int i, int j)
    {
        _cls05D4 _lcls05d4 = ((_cls14FF)_pcls05d4.get()).qn;
        _cls05D4 _lcls05d4_2 = ((_cls14FF)_pcls05d4.get()).qm;
        if (_lcls05d4 != null && qy != null)
        {
            _lcls05d4_2 = qy._mth02CA(_lcls05d4, i, j);
            if (!_lcls05d4.equals(_lcls05d4_2))
            {
                return new _cls1502(new _cls14FF(_lcls05d4_2, ((_cls14FF)_pcls05d4.get()).qm));
            } else
            {
                return _pcls05d4;
            }
        }
        if (_lcls05d4_2 != null && qz != null)
        {
            _cls05D4 _lcls05d4_1 = qz._mth02CA(_lcls05d4_2, i, j);
            if (!_lcls05d4_2.equals(_lcls05d4_1))
            {
                return new _cls1502(new _cls14FF(((_cls14FF)_pcls05d4.get()).qn, _lcls05d4_1));
            }
        }
        return _pcls05d4;
    }
}
