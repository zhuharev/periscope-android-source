// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

// Referenced classes of package o:
//            FE7B

public class ara extends FrameLayout
{

    private FE7B bhP;

    public ara(Context context)
    {
        super(context);
    }

    public ara(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ara(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (bhP != null)
        {
            bhP.onTouchEvent(motionevent);
        }
        return super.onInterceptTouchEvent(motionevent);
    }

    public void setGestureListener(android.view.GestureDetector.OnGestureListener ongesturelistener)
    {
        bhP = new FE7B(getContext(), ongesturelistener);
    }
}
