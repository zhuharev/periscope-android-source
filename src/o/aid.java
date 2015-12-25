// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package o:
//            aht, ahm, aev

public final class aid extends aht
    implements android.view.View.OnClickListener
{

    private final aev blC;
    public ahm bmB;
    public final TextView bmQ;

    public aid(View view, aev aev1)
    {
        super(view);
        bmQ = (TextView)view.findViewById(0x7f0d000c);
        blC = aev1;
        view.setOnClickListener(this);
    }

    public final void onClick(View view)
    {
        if (bmB == null)
        {
            return;
        }
        boolean flag;
        if (bmB.blR > 0.2F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            blC._mth02CA(bmB.aVl, null);
            return;
        } else
        {
            blC.onCancel();
            return;
        }
    }
}
