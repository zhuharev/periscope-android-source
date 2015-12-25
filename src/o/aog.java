// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ry, aof

final class aog extends ry
{

    private aof buT;
    private Runnable uw;

    aog(aof aof, Runnable runnable)
    {
        buT = aof;
        uw = runnable;
        super();
    }

    public final void _mth012A()
    {
        uw.run();
    }
}
