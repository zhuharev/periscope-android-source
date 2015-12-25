// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.VelocityTracker;

public class FBE9
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    static final _cls02CB _fld1F77;

    public FBE9()
    {
    }

    public static float _mth02CA(VelocityTracker velocitytracker, int i)
    {
        return _fld1F77._mth02CA(velocitytracker, i);
    }

    public static float _mth02CB(VelocityTracker velocitytracker, int i)
    {
        return _fld1F77._mth02CB(velocitytracker, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            _fld1F77 = new _cls02CA();
        } else
        {
            _fld1F77 = new if();
        }
    }
}
