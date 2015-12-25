// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            _cls010B, _cls0689, _cls1D45

final class _cls03C2
    implements Runnable
{

    private _cls010B hb;

    _cls03C2(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final void run()
    {
        if (_cls010B._mth02CB(hb) != null && (_cls010B._mth02CB(hb) instanceof _cls0689))
        {
            _cls010B._mth02CB(hb).changeCursor(null);
        }
    }
}
