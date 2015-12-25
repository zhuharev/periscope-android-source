// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;

public class rl
{

    int QX;

    public rl()
    {
        QX = 4;
    }

    public void _mth02BE(String s, String s1)
    {
        _mth02CB(s, s1, ((Throwable) (null)));
    }

    public void _mth02BF(String s, String s1)
    {
        _mth02CE(s, s1, null);
    }

    public void _mth02CA(int i, String s, String s1, boolean flag)
    {
        if (FB35(i))
        {
            Log.println(i, s, s1);
        }
    }

    public void _mth02CA(String s, String s1)
    {
        _mth02CB(s, s1, ((Exception) (null)));
    }

    public void _mth02CA(String s, String s1, Exception exception)
    {
        if (FB35(5))
        {
            Log.w(s, s1, exception);
        }
    }

    public void _mth02CB(int i, String s, String s1)
    {
        _mth02CA(i, s, s1, false);
    }

    public void _mth02CB(String s, String s1)
    {
        _mth02CF(s, s1, null);
    }

    public void _mth02CB(String s, String s1, Exception exception)
    {
        if (FB35(6))
        {
            Log.e(s, s1, exception);
        }
    }

    public void _mth02CB(String s, String s1, Throwable throwable)
    {
        if (FB35(3))
        {
            Log.d(s, s1, throwable);
        }
    }

    public void _mth02CE(String s, String s1)
    {
        _mth02CA(s, s1, null);
    }

    public void _mth02CE(String s, String s1, Throwable throwable)
    {
        if (FB35(2))
        {
            Log.v(s, s1, null);
        }
    }

    public void _mth02CF(String s, String s1, Throwable throwable)
    {
        if (FB35(4))
        {
            Log.i(s, s1, null);
        }
    }

    public boolean FB35(int i)
    {
        return QX <= i;
    }
}
