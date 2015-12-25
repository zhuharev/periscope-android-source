// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package o:
//            act, aqu

public final class .ckListener extends android.support.v7.widget.ew._cls02CC
    implements android.view.ckListener
{

    public aqu bdB;
    private ject bdC;

    public final void onClick(View view)
    {
        if (act._mth02CA(bdC.).size() == 1 && bdB.isChecked())
        {
            return;
        }
        bdB.toggle();
        view = (String)bdC..get(bdB.beL.getText().toString());
        if (bdB.isChecked())
        {
            act._mth02CA(bdC.).add(view);
            return;
        } else
        {
            act._mth02CA(bdC.).remove(view);
            return;
        }
    }

    public .ckListener(.View view, View view1)
    {
        bdC = view;
        super(view1);
        bdB = (aqu)view1;
        bdB.setOnClickListener(this);
    }
}
