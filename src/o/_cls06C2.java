// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls0692, _cls148E, ra, rl

final class _cls06C2
    implements Runnable
{

    private _cls0692 sE;

    _cls06C2(_cls0692 _pcls0692)
    {
        sE = _pcls0692;
        super();
    }

    public final void run()
    {
        try
        {
            sE.sB.sendEvents();
            return;
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to send events files", exception);
        }
    }
}
