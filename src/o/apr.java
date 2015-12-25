// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package o:
//            apq

final class apr extends android.support.v7.widget.RecyclerView.aux
{

    private apq bzd;

    apr(apq apq1)
    {
        bzd = apq1;
        super();
    }

    public final void _mth02CA(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.con con)
    {
        boolean flag;
        if (RecyclerView._mth15EE(view) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            rect.top = apq._mth02CA(bzd);
        } else
        {
            rect.top = 0;
        }
        rect.left = 0;
        rect.right = 0;
        rect.bottom = apq._mth02CA(bzd);
    }
}
