// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            xm

final class xo
    implements Runnable
{

    private xm aTI;
    private int aTJ[];

    xo(xm xm1, int ai[])
    {
        aTI = xm1;
        aTJ = ai;
        super();
    }

    public final void run()
    {
        xm._mth02CE(aTI)._mth02B9(aTJ);
    }
}
