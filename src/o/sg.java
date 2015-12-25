// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ry, sf

final class sg extends ry
{

    private sf RN;
    private Runnable uw;

    sg(sf sf, Runnable runnable)
    {
        RN = sf;
        uw = runnable;
        super();
    }

    public final void _mth012A()
    {
        uw.run();
    }
}
