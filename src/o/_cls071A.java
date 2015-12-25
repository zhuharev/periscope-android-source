// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls0692, _cls148E, ra, rl

final class _cls071A
    implements Runnable
{

    private _cls0692 sE;
    private _cls1491.if sF;
    private boolean sG;

    _cls071A(_cls0692 _pcls0692, _cls1491.if if1, boolean flag)
    {
        sE = _pcls0692;
        sF = if1;
        sG = flag;
        super();
    }

    public final void run()
    {
        try
        {
            sE.sB._mth02CB(sF);
            if (sG)
            {
                sE.sB.rollFileOver();
            }
            return;
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to process event", exception);
        }
    }
}
