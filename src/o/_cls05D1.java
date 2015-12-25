// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            _cls010B

final class _cls05D1
    implements android.view.View.OnClickListener
{

    private _cls010B hb;

    _cls05D1(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final void onClick(View view)
    {
        if (view == _cls010B._mth141D(hb))
        {
            _cls010B._mth02BB(hb);
            return;
        }
        if (view == _cls010B._mth02BC(hb))
        {
            _cls010B._mth02BD(hb);
            return;
        }
        if (view == _cls010B._mth037A(hb))
        {
            _cls010B._mth1FBE(hb);
            return;
        }
        if (view == _cls010B._mth02BE(hb))
        {
            _cls010B._mth02BF(hb);
            return;
        }
        if (view == _cls010B._mth02C8(hb))
        {
            _cls010B._mth02C9(hb);
        }
    }
}
