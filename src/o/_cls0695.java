// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls0692, _cls148E, ra, rl, 
//            ut

final class _cls0695
    implements Runnable
{

    private ut sC;
    private String sD;
    private _cls0692 sE;

    _cls0695(_cls0692 _pcls0692, ut ut, String s)
    {
        sE = _pcls0692;
        sC = ut;
        sD = s;
        super();
    }

    public final void run()
    {
        try
        {
            sE.sB._mth02CA(sC, sD);
            return;
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Answers", "Failed to set analytics settings data", exception);
        }
    }
}
