// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ViewConfiguration;

public class _cls05E8
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


    static final _cls02CF FB84;

    public _cls05E8()
    {
    }

    public static int _mth02CA(ViewConfiguration viewconfiguration)
    {
        return FB84._mth02CA(viewconfiguration);
    }

    public static boolean _mth02CB(ViewConfiguration viewconfiguration)
    {
        return FB84._mth02CB(viewconfiguration);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            FB84 = new _cls02CE();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            FB84 = new _cls02CB();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            FB84 = new _cls02CA();
        } else
        {
            FB84 = new if();
        }
    }
}
