// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;

// Referenced classes of package o:
//            _cls06E5

static class 
    implements ject
{

    public Notification _mth02CA(ject ject, ject ject1)
    {
        ject1 = ject._fld02B6;
        ject1.setLatestEventInfo(ject.mContext, ject._fld155D, ject._fld1D52, ject._fld1D58);
        if (ject.mPriority > 0)
        {
            ject1.flags = ((Notification) (ject1)).flags | 0x80;
        }
        return ject1;
    }

    ()
    {
    }
}
