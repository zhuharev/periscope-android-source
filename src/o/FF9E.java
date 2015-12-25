// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls1428

final class FF9E
    implements Runnable
{

    private _cls1428 _fld1D65;
    private int FBE8;
    private int FE74;

    FF9E(_cls1428 _pcls1428, int i, int j)
    {
        _fld1D65 = _pcls1428;
        FBE8 = i;
        FE74 = j;
        super();
    }

    public final void run()
    {
        _fld1D65._mth02CA(null, FBE8, FE74);
    }
}
