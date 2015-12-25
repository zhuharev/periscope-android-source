// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package o:
//            xf, aed

final class aeo extends android.view.GestureDetector.SimpleOnGestureListener
{

    private aed bhH;

    aeo(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final boolean onDoubleTap(MotionEvent motionevent)
    {
        xf._mth02CA(xf.if.aSs);
        aed._mth0640(bhH);
        return true;
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (aed._mth141D(bhH).getAlpha() < 1.0F)
        {
            aed._mth02CF(bhH).removeCallbacks(aed._mth02CE(bhH));
            aed._mth141D(bhH).animate().alpha(1.0F);
            aed._mth02C8(bhH);
        } else
        {
            aed._mth141D(bhH).animate().alpha(0.0F);
        }
        return true;
    }
}
