// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FE9B, _cls1646, FE70

static class _cls026D
    implements FE9B
{

    _cls1646 _fld026D;

    public void _mth02B3(View view)
    {
        if (_cls1646._mth02CE(_fld026D) >= 0)
        {
            FE70._mth02CA(view, _cls1646._mth02CE(_fld026D), null);
            _cls1646._mth02CA(_fld026D, -1);
        }
        if (_cls1646._mth02CB(_fld026D) != null)
        {
            _cls1646._mth02CB(_fld026D).run();
        }
        Object obj = view.getTag(0x7e000000);
        FE9B fe9b = null;
        if (obj instanceof FE9B)
        {
            fe9b = (FE9B)obj;
        }
        if (fe9b != null)
        {
            fe9b._mth02B3(view);
        }
    }

    public void _mth02B4(View view)
    {
        Object obj = view.getTag(0x7e000000);
        FE9B fe9b = null;
        if (obj instanceof FE9B)
        {
            fe9b = (FE9B)obj;
        }
        if (fe9b != null)
        {
            fe9b._mth02B4(view);
        }
    }

    public void FF70(View view)
    {
        if (_cls1646._mth02CE(_fld026D) >= 0)
        {
            FE70._mth02CA(view, 2, null);
        }
        if (_cls1646._mth02CA(_fld026D) != null)
        {
            _cls1646._mth02CA(_fld026D).run();
        }
        Object obj = view.getTag(0x7e000000);
        FE9B fe9b = null;
        if (obj instanceof FE9B)
        {
            fe9b = (FE9B)obj;
        }
        if (fe9b != null)
        {
            fe9b.FF70(view);
        }
    }

    ew(_cls1646 _pcls1646)
    {
        _fld026D = _pcls1646;
    }
}
