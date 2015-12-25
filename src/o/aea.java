// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            adx

final class aea
    implements Runnable
{

    private adx bgi;
    private double bgk;

    aea(adx adx1, double d)
    {
        bgi = adx1;
        bgk = d;
        super();
    }

    public final void run()
    {
        adx._mth02CB(bgi, bgk);
    }
}
