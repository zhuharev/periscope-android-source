// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

// Referenced classes of package o:
//            _cls15AE

final class _cls1D4C extends _cls15AE
{

    _cls1D4C(Drawable drawable)
    {
        super(drawable);
    }

    public final void applyTheme(android.content.res.Resources.Theme theme)
    {
        _fld0407.applyTheme(theme);
    }

    public final boolean canApplyTheme()
    {
        return _fld0407.canApplyTheme();
    }

    public final Rect getDirtyBounds()
    {
        return _fld0407.getDirtyBounds();
    }

    public final void getOutline(Outline outline)
    {
        _fld0407.getOutline(outline);
    }

    public final void setHotspot(float f, float f1)
    {
        _fld0407.setHotspot(f, f1);
    }

    public final void setHotspotBounds(int i, int j, int k, int l)
    {
        _fld0407.setHotspotBounds(i, j, k, l);
    }
}
