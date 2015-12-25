// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package o:
//            _cls0445, _cls1D10, _cls1541, _cls0621, 
//            _cls03F3

final class _cls7 extends _cls0445
{

    private _cls1D10 _fld1FE8;
    private _cls0621 FB5E;

    public final void onDismiss()
    {
        super.onDismiss();
        _fld1FE8._fld1E1E = null;
        _fld1FE8._fld1F59 = 0;
    }

    public ew.View(_cls1D10 _pcls1d10, Context context, _cls0621 _pcls0621)
    {
        _fld1FE8 = _pcls1d10;
        super(context, _pcls0621, null, false, _cls1541.actionOverflowMenuStyle);
        FB5E = _pcls0621;
        boolean flag;
        if ((((_cls03F3)_pcls0621.getItem())._fld0E20 & 0x20) == 32)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            if (_pcls1d10._fld1542 == null)
            {
                context = (View)_cls1D10._mth02CE(_pcls1d10);
            } else
            {
                context = _pcls1d10._fld1542;
            }
            super.FF8A = context;
        }
        super._fld0141 = _pcls1d10._fld1E7E;
        boolean flag2 = false;
        int j = _pcls0621.size();
        int i = 0;
        boolean flag1;
        do
        {
            flag1 = flag2;
            if (i >= j)
            {
                break;
            }
            _pcls1d10 = _pcls0621.getItem(i);
            if (_pcls1d10.isVisible() && _pcls1d10.getIcon() != null)
            {
                flag1 = true;
                break;
            }
            i++;
        } while (true);
        super._fld1627 = flag1;
    }
}
