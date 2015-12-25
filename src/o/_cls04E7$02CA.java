// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls05E3, _cls1EF2, _cls1681

static final class uuid extends uuid
{

    private final String uuid;
    private final long vl;
    private final long vm;
    private final String vn;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        _pcls1ef2._mth02CB(1, vl);
        _pcls1ef2._mth02CB(2, vm);
        _pcls1ef2._mth02CA(3, _cls1681._mth02CD(vn));
        _pcls1ef2._mth02CA(4, _cls1681._mth02CD(uuid));
    }

    public final int FB65()
    {
        int i = _cls1EF2._mth02CE(1, vl);
        int j = _cls1EF2._mth02CE(2, vm);
        return _cls1EF2._mth02CB(3, _cls1681._mth02CD(vn)) + i + j + _cls1EF2._mth02CB(4, _cls1681._mth02CD(uuid));
    }

    public ring(_cls05E3 _pcls05e3)
    {
        super(4, new <init>[0]);
        vl = _pcls05e3.wa;
        vm = _pcls05e3.size;
        vn = _pcls05e3.wb;
        uuid = _pcls05e3.id;
    }
}
