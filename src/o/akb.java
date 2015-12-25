// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class akb extends android.support.v7.widget.RecyclerView.aux
{

    public akb()
    {
    }

    public void _mth02CA(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.con con)
    {
        boolean flag;
        if (RecyclerView._mth15EE(view) == recyclerview.dF.getItemCount() - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            rect.bottom = recyclerview.getResources().getDimensionPixelOffset(0x7f09008d);
        }
    }
}
