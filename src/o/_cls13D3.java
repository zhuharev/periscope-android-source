// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package o:
//            FF89, _cls13B1

final class _cls13D3
    implements android.view.View.OnClickListener
{

    private FF89 iW;
    private _cls13B1 iX;

    _cls13D3(_cls13B1 _pcls13b1)
    {
        iX = _pcls13b1;
        super();
        iW = new FF89(iX.iK.getContext(), 0, 0x102002c, 0, 0, iX.mTitle);
    }

    public final void onClick(View view)
    {
        if (iX.iR != null && iX.iS)
        {
            iX.iR.onMenuItemSelected(0, iW);
        }
    }
}
