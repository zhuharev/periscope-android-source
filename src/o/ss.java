// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


final class ss
    implements Runnable
{

    private so._cls02CB SF;
    private Runnable val$r;

    ss(so._cls02CB _pcls02cb, Runnable runnable)
    {
        SF = _pcls02cb;
        val$r = runnable;
        super();
    }

    public final void run()
    {
        val$r.run();
        SF._mth14D5();
        return;
        Exception exception;
        exception;
        SF._mth14D5();
        throw exception;
    }
}
