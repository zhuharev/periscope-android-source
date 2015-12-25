// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls2148, _cls1D5A

final class _cls1D5D
    implements Runnable
{

    private _cls2148 kf;
    private _cls1D5A kg;

    _cls1D5D(_cls1D5A _pcls1d5a, _cls2148 _pcls2148)
    {
        kg = _pcls1d5a;
        kf = _pcls2148;
        super();
    }

    public final void run()
    {
        kf._mth02CA(kg);
    }
}
