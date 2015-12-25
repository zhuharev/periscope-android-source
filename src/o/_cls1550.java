// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.MotionEvent;

class _cls1550
{

    _cls1550()
    {
    }

    public static int _mth02CA(MotionEvent motionevent, int i)
    {
        return motionevent.findPointerIndex(i);
    }

    public static int _mth02CB(MotionEvent motionevent, int i)
    {
        return motionevent.getPointerId(i);
    }

    public static float _mth02CE(MotionEvent motionevent, int i)
    {
        return motionevent.getX(i);
    }

    public static int _mth02CE(MotionEvent motionevent)
    {
        return motionevent.getPointerCount();
    }

    public static float _mth02CF(MotionEvent motionevent, int i)
    {
        return motionevent.getY(i);
    }
}
