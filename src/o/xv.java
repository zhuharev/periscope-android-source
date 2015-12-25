// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ScaleGestureDetector;

// Referenced classes of package o:
//            xu, xt, xl

public final class xv
    implements android.view.ScaleGestureDetector.OnScaleGestureListener
{

    private xu aUb;

    public xv(xu xu1)
    {
        aUb = xu1;
        super();
    }

    public final boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        xl xl1 = aUb.aTY.FECF();
        if (xl1 != null)
        {
            xu xu1 = aUb;
            float f = scalegesturedetector.getScaleFactor();
            xu1.aUa = xu1.aUa + f;
            xu1.aUa = Math.max(0.0F, Math.min(xu1.aUa - 1.0F, 1.0F));
            xl1.setZoom((int)(xu1.aUa * (float)xl1.getMaxZoom() + 0.5F));
        }
        return true;
    }

    public final boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return true;
    }

    public final void onScaleEnd(ScaleGestureDetector scalegesturedetector)
    {
    }
}
