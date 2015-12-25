// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package o:
//            aqf

final class aqh extends android.support.v7.widget.RecyclerView.aux
{

    private aqf bAJ;

    aqh(aqf aqf1)
    {
        bAJ = aqf1;
        super();
    }

    public final void _mth02CA(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.con con)
    {
        if (RecyclerView._mth15EE(view) == 0)
        {
            rect.top = bAJ.getResources().getDimensionPixelOffset(0x7f09008c);
        }
    }
}
