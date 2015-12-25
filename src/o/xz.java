// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            yn

public final class xz extends yn
{

    public xz(boolean flag, Map map)
    {
        super(flag, map, 1000);
    }

    public final volatile void _mth02CA(List list, boolean flag, String s)
    {
        super._mth02CA(list, flag, s);
    }

    protected final long _mth1D62(long l)
    {
        return TimeUnit.NANOSECONDS.toMillis(l);
    }

    protected final long _mth2071(long l)
    {
        return TimeUnit.MILLISECONDS.toNanos(l);
    }
}
