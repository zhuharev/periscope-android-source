// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class aks extends FrameLayout
{

    private View bqQ;

    public aks(Context context)
    {
        super(context);
    }

    public aks(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public aks(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean canScrollVertically(int i)
    {
        return bqQ.canScrollVertically(i);
    }

    protected void onFinishInflate()
    {
        bqQ = findViewById(0x7f0d0067);
    }
}
