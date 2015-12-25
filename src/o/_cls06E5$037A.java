// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;

// Referenced classes of package o:
//            _cls06E5, _cls1540

static class  extends 
{

    public Notification _mth02CA( ,  1)
    {
        1 = ._fld02B6;
        1.setLatestEventInfo(.mContext, ._fld155D, ._fld1D52, ._fld1D58);
        1 = _cls1540._mth02CA(1, .mContext, ._fld155D, ._fld1D52, ._fld1D58, ._fld1D64);
        if (.mPriority > 0)
        {
            1.flags = ((Notification) (1)).flags | 0x80;
        }
        return 1;
    }

    ()
    {
    }
}
