// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.RelativeLayout;
import java.util.Random;

// Referenced classes of package o:
//            amp, ait, aix, aok, 
//            aip

public class amt extends amp
    implements android.view.View.OnClickListener
{

    private RelativeLayout bte;
    private ait btf;

    public amt()
    {
    }

    protected final void dr()
    {
        setContentView(0x7f03004f);
        RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f0d0108);
        ((RelativeLayout)findViewById(0x7f0d0107)).setOnClickListener(this);
        bte = relativelayout;
        btf = new ait(this);
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
        view.setColor(aok._mth02CA(getResources(), (new Random()).nextInt(13)));
        btf._mth02CA(view, bte, true);
    }
}
