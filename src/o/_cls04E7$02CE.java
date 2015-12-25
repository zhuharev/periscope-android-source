// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls04E7, _cls1EF2

static final class vs extends vs
{

    private final int orientation;
    private final float vo;
    private final int vp;
    private final boolean vq;
    private final long vr;
    private final long vs;

    public final void _mth02CA(_cls1EF2 _pcls1ef2)
    {
        _pcls1ef2._mth02CA(1, vo);
        _pcls1ef2._mth1420(2, vp);
        _pcls1ef2._mth037A(3, vq);
        _pcls1ef2._mth02EE(4, orientation);
        _pcls1ef2._mth02CB(5, vr);
        _pcls1ef2._mth02CB(6, vs);
    }

    public final int FB65()
    {
        float f = vo;
        int i = _cls1EF2.FE74(8);
        int j = _cls1EF2._mth1429(2, vp);
        boolean flag = vq;
        int k = _cls1EF2.FE74(24);
        int l = orientation;
        return i + 4 + 0 + j + (k + 1) + (_cls1EF2.FE74(32) + _cls1EF2.FE74(l)) + _cls1EF2._mth02CE(5, vr) + _cls1EF2._mth02CE(6, vs);
    }

    public (float f, int i, boolean flag, int j, long l, long l1)
    {
        super(5, new <init>[0]);
        vo = f;
        vp = i;
        vq = flag;
        orientation = j;
        vr = l;
        vs = l1;
    }
}
