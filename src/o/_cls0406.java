// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.LayoutInflater;

// Referenced classes of package o:
//            _cls1449

public class _cls0406
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    static final if _fld1D17;

    public static void _mth02CA(LayoutInflater layoutinflater, _cls1449 _pcls1449)
    {
        _fld1D17._mth02CA(layoutinflater, _pcls1449);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            _fld1D17 = new _cls02CE();
        } else
        if (i >= 11)
        {
            _fld1D17 = new _cls02CB();
        } else
        {
            _fld1D17 = new _cls02CA();
        }
    }
}
