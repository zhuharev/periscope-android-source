// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.FrameLayout;

// Referenced classes of package o:
//            FE7B

public class aeu extends FrameLayout
{

    private ScaleGestureDetector bhO;
    private FE7B bhP;

    public aeu(Context context)
    {
        super(context);
    }

    public aeu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public aeu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        if (bhP != null && bhP.onTouchEvent(motionevent))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1 = flag;
        boolean flag2 = flag1;
        if (!flag)
        {
            flag2 = flag1;
            if (bhO != null)
            {
                flag2 = bhO.onTouchEvent(motionevent);
            }
        }
        return super.onTouchEvent(motionevent) || flag2;
    }

    public void setGestureListener(android.view.GestureDetector.SimpleOnGestureListener simpleongesturelistener)
    {
        bhP = new FE7B(getContext(), simpleongesturelistener);
        bhP.setOnDoubleTapListener(simpleongesturelistener);
    }

    public void setScaleGestureListener(android.view.ScaleGestureDetector.OnScaleGestureListener onscalegesturelistener)
    {
        bhO = new ScaleGestureDetector(getContext(), onscalegesturelistener);
        bhO.setQuickScaleEnabled(false);
    }
}
