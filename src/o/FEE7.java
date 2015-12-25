// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.KeyEvent;

public class FEE7
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    static final _cls02CE _fld15A6;

    public FEE7()
    {
    }

    public static boolean _mth02CA(KeyEvent keyevent)
    {
        return _fld15A6.metaStateHasNoModifiers(keyevent.getMetaState());
    }

    public static boolean _mth02CA(KeyEvent keyevent, int i)
    {
        return _fld15A6.metaStateHasModifiers(keyevent.getMetaState(), i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            _fld15A6 = new _cls02CB();
        } else
        {
            _fld15A6 = new if();
        }
    }
}
