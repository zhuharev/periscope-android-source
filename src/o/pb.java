// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


abstract class pb
{

    private int NC;

    pb(int i)
    {
        NC = i;
    }

    public final int getInterval()
    {
        return NC;
    }

    public abstract void run();

    public final void _mth1D44(int i)
    {
        NC = i;
    }
}
