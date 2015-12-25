// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls1ECA

final class _cls30FD
    implements android.graphics.drawable.Drawable.Callback
{

    private _cls1ECA _fld1D27;

    _cls30FD(_cls1ECA _pcls1eca)
    {
        _fld1D27 = _pcls1eca;
        super();
    }

    public final void invalidateDrawable(Drawable drawable)
    {
        _fld1D27.invalidateSelf();
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        _fld1D27.scheduleSelf(runnable, l);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        _fld1D27.unscheduleSelf(runnable);
    }
}
