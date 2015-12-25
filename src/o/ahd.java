// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.TextureView;
import java.util.TreeMap;

// Referenced classes of package o:
//            agp, adx, afw, zz, 
//            aft

public final class ahd extends android.view.GestureDetector.SimpleOnGestureListener
{

    private agp ble;

    ahd(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void onLongPress(MotionEvent motionevent)
    {
        if (agp._mth02BB(ble) != null && agp._mth02BB(ble).bly && agp._mth02CF(ble).bfL && !agp._mth02BF(ble) && !agp._mth02C8(ble).FE7B)
        {
            afw afw1 = agp._mth02C8(ble);
            if (afw1.bjt == null)
            {
                throw new IllegalStateException("You must call setPlayerProvider before startScrubbing");
            }
            if (!afw1.FE7B)
            {
                afw1.bjy = afw1.bjy + 1;
                afw1.bjz = System.currentTimeMillis();
                long l = afw1.bjt.K();
                afw1.bjw = afw1.bjt.J();
                afw1.bjx = 0L;
                long l1 = afw1.bjw;
                afw1.bjo.setDuration(l);
                afw1.bjo.setZoomZonePercentage(0.3F);
                afw1.bjo.setZoom(1.0F, afw.FE73(1.0F));
                afw1.bjo.setInitialTime(l1);
                afw1._mth02CA(afw1._mth02CA(afw._mth02CA(l1, afw1.bjq.navigableKeySet())));
                afw1.bjp._mth1FBE(motionevent);
                afw1.FE7B = true;
                afw1.bjv = false;
                motionevent = afw1.bjo;
                ((aft) (motionevent)).bjd.cancel();
                ((aft) (motionevent)).bjc.start();
                if (afw1.bju != null)
                {
                    afw1.bju.onStarted();
                }
            }
            agp._mth02C9(ble).performHapticFeedback(0);
        }
    }
}
