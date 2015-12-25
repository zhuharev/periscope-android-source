// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

// Referenced classes of package o:
//            _cls1D3B

public class _cls1D30 extends LinearLayout
    implements _cls1D3B
{

    private _cls1D3B.if bw;

    public _cls1D30(Context context)
    {
        super(context);
    }

    public _cls1D30(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        if (bw != null)
        {
            bw._mth02CA(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(_cls1D3B.if if1)
    {
        bw = if1;
    }
}
