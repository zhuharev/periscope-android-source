// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.RelativeLayout;
import java.util.Random;

// Referenced classes of package o:
//            amp, aiq, aix, aos, 
//            aok, aip

public class amu extends amp
    implements android.view.View.OnClickListener
{

    private RelativeLayout btg;
    private aiq bth;

    public amu()
    {
    }

    protected final void dr()
    {
        setContentView(0x7f03004e);
        ((RelativeLayout)findViewById(0x7f0d0107)).setOnClickListener(this);
        btg = (RelativeLayout)findViewById(0x7f0d0108);
        bth = new aiq(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558663: 
            view = new aix(this);
            break;
        }
        view.setColor(aok._mth02CA(getResources(), aos.dE().nextInt(14)));
        bth._mth02CA(view, btg, true);
    }
}
