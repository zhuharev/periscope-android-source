// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.util.concurrent.Callable;

// Referenced classes of package o:
//            _cls1EF4, ra, rl

final class _cls1FD7
    implements Callable
{

    private _cls1EF4 uq;

    _cls1FD7(_cls1EF4 _pcls1ef4)
    {
        uq = _pcls1ef4;
        super();
    }

    private Boolean call()
    {
        boolean flag;
        try
        {
            flag = _cls1EF4._mth02CA(uq).delete();
            ra._mth0454()._mth02BE("CrashlyticsCore", (new StringBuilder("Initialization marker file removed: ")).append(flag).toString());
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(flag);
    }

    public final volatile Object call()
    {
        return call();
    }
}
