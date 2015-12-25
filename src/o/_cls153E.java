// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.MotionEvent;

public class _cls153E
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    static final _cls02CF _fld1E37;

    public _cls153E()
    {
    }

    public static int _mth02CA(MotionEvent motionevent)
    {
        return motionevent.getAction() & 0xff;
    }

    public static int _mth02CA(MotionEvent motionevent, int i)
    {
        return _fld1E37._mth02CA(motionevent, i);
    }

    public static int _mth02CB(MotionEvent motionevent)
    {
        return motionevent.getAction() >> 8 & 0xff;
    }

    public static int _mth02CB(MotionEvent motionevent, int i)
    {
        return _fld1E37._mth02CB(motionevent, i);
    }

    public static float _mth02CE(MotionEvent motionevent, int i)
    {
        return _fld1E37._mth02CE(motionevent, i);
    }

    public static int _mth02CE(MotionEvent motionevent)
    {
        return _fld1E37._mth02CE(motionevent);
    }

    public static float _mth02CF(MotionEvent motionevent, int i)
    {
        return _fld1E37._mth02CF(motionevent, i);
    }

    public static int _mth02CF(MotionEvent motionevent)
    {
        return _fld1E37._mth02CF(motionevent);
    }

    public static float _mth141D(MotionEvent motionevent, int i)
    {
        return _fld1E37._mth141D(motionevent, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            _fld1E37 = new _cls02CE();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            _fld1E37 = new _cls02CB();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            _fld1E37 = new _cls02CA();
        } else
        {
            _fld1E37 = new if();
        }
    }
}
