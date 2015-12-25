// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Locale;

public class _cls02C1
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final if _fld068A;

    public _cls02C1()
    {
    }

    public static String _mth02CA(Locale locale)
    {
        return _fld068A._mth02CA(locale);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            _fld068A = new _cls02CE();
        } else
        if (i >= 14)
        {
            _fld068A = new _cls02CB();
        } else
        {
            _fld068A = new _cls02CA();
        }
    }
}
