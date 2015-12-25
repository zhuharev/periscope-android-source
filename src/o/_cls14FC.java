// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls05D7, _cls14FD, _cls05D4, FEAE, 
//            _cls028B, _cls04AD

public final class _cls14FC extends _cls05D7
    implements _cls14FD
{

    private _cls14FD.if of;

    public _cls14FC(int i)
    {
        super(i);
    }

    protected final int _mth02B4(Object obj)
    {
        return ((_cls05D4)obj).getSize();
    }

    public final _cls05D4 _mth02BC(FEAE feae)
    {
        return (_cls05D4)super._mth037A(feae);
    }

    public final void _mth02CA(_cls028B _pcls028b)
    {
        of = _pcls028b;
    }

    public final _cls05D4 _mth02CE(FEAE feae, _cls04AD _pcls04ad)
    {
        return (_cls05D4)super.put(feae, _pcls04ad);
    }

    protected final volatile void _mth02CF(Object obj, Object obj1)
    {
        obj = (_cls05D4)obj1;
        if (of != null)
        {
            of._mth02CF(((_cls05D4) (obj)));
        }
    }

    public final void _mth14A1(int i)
    {
        if (i >= 60)
        {
            _mth1E59();
            return;
        }
        if (i >= 40)
        {
            trimToSize(super.nG / 2);
        }
    }
}
