// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.LayoutInflater;

// Referenced classes of package o:
//            _cls1449

class _cls0457
{
    /* member class not found */
    class if {}


    _cls0457()
    {
    }

    static void _mth02CA(LayoutInflater layoutinflater, _cls1449 _pcls1449)
    {
        if (_pcls1449 != null)
        {
            _pcls1449 = new if(_pcls1449);
        } else
        {
            _pcls1449 = null;
        }
        layoutinflater.setFactory(_pcls1449);
    }
}
