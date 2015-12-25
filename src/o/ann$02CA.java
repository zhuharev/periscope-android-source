// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package o:
//            ann, aqt

final class w.ickListener extends android.support.v7.widget.iew._cls02CC
    implements android.view.ickListener
{

    private TextView bmQ;
    private ann bur;
    public final aqt bus;

    public final void onClick(View view)
    {
        boolean flag;
        if (!bus.bAL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bus.setChecked(flag);
        if (ann._mth02CE(bur) != null)
        {
            ann._mth02CE(bur).E4(flag);
        }
    }

    public w.ickListener(ann ann1, View view)
    {
        bur = ann1;
        super(view);
        bmQ = (TextView)view.findViewById(0x7f0d0186);
        bus = (aqt)view.findViewById(0x7f0d0187);
        view.setOnClickListener(this);
    }
}
