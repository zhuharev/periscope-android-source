// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls067A, _cls1681, _cls1EF2

static final class vC extends vC
{

    private final String vA;
    private final String vB;
    private final long vC;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        _pcls1ef2._mth02CA(1, _cls1681._mth02CD(vA));
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD(vB));
        _pcls1ef2._mth02CB(3, vC);
    }

    public final int FB65()
    {
        return _cls1EF2._mth02CB(1, _cls1681._mth02CD(vA)) + _cls1EF2._mth02CB(2, _cls1681._mth02CD(vB)) + _cls1EF2._mth02CE(3, vC);
    }

    public ring(_cls067A _pcls067a)
    {
        super(3, new <init>[0]);
        vA = _pcls067a.name;
        vB = _pcls067a.wp;
        vC = _pcls067a.wq;
    }
}
