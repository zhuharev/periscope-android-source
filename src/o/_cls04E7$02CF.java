// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls1EF2, _cls1681

static final class vt extends vt
{

    private final long time;
    private final String vt;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        _pcls1ef2._mth02CB(1, time);
        _pcls1ef2._mth02CA(2, _cls1681._mth02CD(vt));
    }

    public final int FB65()
    {
        return _cls1EF2._mth02CE(1, time) + _cls1EF2._mth02CB(2, _cls1681._mth02CD(vt));
    }

    public transient ring(long l, String s, ring aring[])
    {
        super(10, aring);
        time = l;
        vt = s;
    }
}
