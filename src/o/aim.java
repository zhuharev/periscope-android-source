// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package o:
//            aos

class aim extends android.support.v7.widget.RecyclerView._cls02CC
{

    public final View bnK;
    private TextView bnL;
    public final View bnM;
    public String broadcastId;

    public aim(View view)
    {
        super(view);
        bnK = view.findViewById(0x7f0d0083);
        bnL = (TextView)view.findViewById(0x7f0d008d);
        bnM = view.findViewById(0x7f0d008c);
    }

    public final void FB36(int i)
    {
        if (i > 0)
        {
            bnL.setText(aos._mth02CA(bnL.getResources(), i, true));
            bnK.setVisibility(0);
            return;
        } else
        {
            bnK.setVisibility(4);
            return;
        }
    }
}
