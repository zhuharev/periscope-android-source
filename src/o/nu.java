// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ov, oy, oa, pf

abstract class nu extends ov
{

    private volatile int LQ;
    private volatile int LR;
    private volatile int LS;

    public nu(String s, int i, int j)
    {
        super(s, i, j);
        LQ = 5;
        LR = 5000;
        LS = 0;
    }

    public final void _mth02CA(oa oa)
    {
        java.util.Vector vector = Ns;
        vector;
        JVM INSTR monitorenter ;
        _mth1F34();
        super._mth02CA(oa);
        vector;
        JVM INSTR monitorexit ;
        return;
        oa;
        throw oa;
    }

    public final pf _mth1F33()
    {
        return new oy(Ns, LX, LW, LQ, LR, LS, Nu);
    }
}
