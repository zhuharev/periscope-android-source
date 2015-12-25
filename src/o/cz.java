// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Executors;

// Referenced classes of package o:
//            ht, dc, _cls0E44, _cls1435

final class cz extends _cls09A8.if
{

    cz()
    {
    }

    public final _cls1435 _mth02CA(Context context, Looper looper, _cls0E44 _pcls0e44, Object obj, _cls09AA._cls02CA _pcls02ca, _cls09AA._cls02CB _pcls02cb)
    {
        return new ht(context, looper, false, _pcls0e44, dc.Cl, _pcls02ca, _pcls02cb, Executors.newSingleThreadExecutor());
    }
}
