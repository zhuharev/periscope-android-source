// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FF8C, _cls1D60

final class <init>
    implements android.view.ckListener
{

    private FF8C gb;

    public final void onClick(View view)
    {
        int j = FF8C._mth02CB(gb).getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view1 = FF8C._mth02CB(gb).getChildAt(i);
            boolean flag;
            if (view1 == view)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view1.setSelected(flag);
        }

    }

    private .View(FF8C ff8c)
    {
        gb = ff8c;
        super();
    }

    ject(FF8C ff8c, byte byte0)
    {
        this(ff8c);
    }
}
