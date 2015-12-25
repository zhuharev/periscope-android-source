// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.List;

// Referenced classes of package o:
//            apl, aob

public final class apn
    implements apl, android.view.View.OnClickListener
{

    private final apl byV;
    private final View byW;

    public apn(aob aob, View view)
    {
        byV = aob;
        byW = view;
        byW.setOnClickListener(this);
    }

    public final boolean aO()
    {
        return byV.aO();
    }

    public final void dC()
    {
        byW.setVisibility(8);
        byV.dC();
    }

    public final void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558615: 
            byW.setVisibility(8);
            break;
        }
        byV.dC();
    }

    public final void _mth02CB(String s, List list)
    {
        byW.setVisibility(0);
        byV._mth02CB(s, list);
    }
}
