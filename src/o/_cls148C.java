// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import java.util.Collections;

// Referenced classes of package o:
//            ra, rl, _cls0692

public final class _cls148C
{

    public final _cls0692 sY;

    public _cls148C(_cls0692 _pcls0692)
    {
        sY = _pcls0692;
    }

    public final void _mth02CA(Activity activity, _cls1491._cls02CA _pcls02ca)
    {
        ra._mth0454()._mth02BE("Answers", (new StringBuilder("Logged lifecycle event: ")).append(_pcls02ca.name()).toString());
        _cls0692 _lcls0692 = sY;
        activity = Collections.singletonMap("activity", activity.getClass().getName());
        _pcls02ca = new _cls1491.if(_pcls02ca);
        _pcls02ca.tb = activity;
        _lcls0692._mth02CA(_pcls02ca);
    }
}
