// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls067B, _cls1EF2, _cls1681

static final class rtance extends 
{

    private final int importance;
    private final long offset;
    private final long vu;
    private final String vv;
    private final String vw;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        _pcls1ef2._mth02CB(1, vu);
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD(vv));
        _pcls1ef2._mth02CA(3, _cls1681._mth02CD(vw));
        _pcls1ef2._mth02CB(4, offset);
        _pcls1ef2._mth02EE(5, importance);
    }

    public final int FB65()
    {
        int i = _cls1EF2._mth02CE(1, vu);
        int j = _cls1EF2._mth02CB(2, _cls1681._mth02CD(vv));
        int k = _cls1EF2._mth02CB(3, _cls1681._mth02CD(vw));
        int l = _cls1EF2._mth02CE(4, offset);
        int i1 = importance;
        return i + j + k + l + (_cls1EF2.FE74(40) + _cls1EF2.FE74(i1));
    }

    public (_cls067B _pcls067b)
    {
        super(3, new [0]);
        vu = _pcls067b.vu;
        vv = _pcls067b.vv;
        vw = _pcls067b.vw;
        offset = _pcls067b.offset;
        importance = _pcls067b.importance;
    }
}
