// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package o:
//            _cls1EF4

final class _cls2113
    implements Callable
{

    private _cls1EF4 uq;

    _cls2113(_cls1EF4 _pcls1ef4)
    {
        uq = _pcls1ef4;
        super();
    }

    public final Object call()
    {
        return Boolean.valueOf(_cls1EF4._mth02CA(uq).exists());
    }
}
