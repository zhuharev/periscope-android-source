// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public class _cls144B
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    static final if _fld1D56;

    public _cls144B()
    {
    }

    public static int _mth02CA(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return _fld1D56._mth02CA(marginlayoutparams);
    }

    public static int _mth02CB(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return _fld1D56._mth02CB(marginlayoutparams);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            _fld1D56 = new _cls02CB();
        } else
        {
            _fld1D56 = new _cls02CA();
        }
    }
}
