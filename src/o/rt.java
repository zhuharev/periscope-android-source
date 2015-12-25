// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ry, rs, rr, ra, 
//            rl

final class rt extends ry
{

    private rr Rl;
    private rs Rm;

    rt(rs rs1, rr rr1)
    {
        Rm = rs1;
        Rl = rr1;
        super();
    }

    public final void _mth012A()
    {
        rr rr1 = Rm._mth066E();
        if (!Rl.equals(rr1))
        {
            ra._mth0454()._mth02BE("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            Rm._mth02CA(rr1);
        }
    }
}
