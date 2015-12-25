// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

// Referenced classes of package o:
//            asd

public class acx extends asd
{

    private ViewGroup bdI;

    public acx(Context context)
    {
        super(context);
        init(context);
    }

    public acx(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public acx(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f0d014e);
        LayoutInflater.from(context).inflate(0x7f03006b, viewgroup, true);
        bdI = (ViewGroup)findViewById(0x7f0d0129);
    }

    public void setContent(int i)
    {
        if (bdI.getChildCount() > 0)
        {
            bdI.removeAllViews();
        }
        LayoutInflater.from(getContext()).inflate(i, bdI, true);
    }
}
