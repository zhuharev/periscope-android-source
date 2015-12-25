// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package o:
//            _cls1EF4, ra, rl

final class _cls1F37
    implements Callable
{

    private _cls1EF4 uq;

    _cls1F37(_cls1EF4 _pcls1ef4)
    {
        uq = _pcls1ef4;
        super();
    }

    public final Object call()
    {
        _cls1EF4._mth02CA(uq).createNewFile();
        ra._mth0454()._mth02BE("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }
}
