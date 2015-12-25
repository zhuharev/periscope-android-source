// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            arc, aqt, anz

public final class any extends android.support.v7.widget.RecyclerView._cls02CC
    implements android.view.View.OnClickListener
{

    public final ImageView btM;
    public final TextView btO;
    public final arc btR;
    private final anz btV;
    public final aqt bus;
    public PsUser user;

    public any(View view, anz anz1, int i)
    {
        super(view);
        btM = (ImageView)view.findViewById(0x7f0d0075);
        btO = (TextView)view.findViewById(0x7f0d0077);
        btR = (arc)view.findViewById(0x7f0d019a);
        bus = (aqt)view.findViewById(i);
        bus.setOnClickListener(this);
        view.setOnClickListener(this);
        btV = anz1;
    }

    public final void onClick(View view)
    {
        if (user != null)
        {
            if (view == bus)
            {
                boolean flag;
                if (!bus.bAL)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                btV._mth02CA(flag, user);
                bus.setChecked(flag);
                return;
            }
            if (view == fy)
            {
                btV._mth02CE(user);
            }
        }
    }
}
