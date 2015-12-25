// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package o:
//            apq

final class apt extends LinearLayoutManager
{

    private apq bzd;

    apt(apq apq1, Context context)
    {
        bzd = apq1;
        super(context);
    }

    public final void _mth02CB(android.support.v7.widget.RecyclerView._cls1FBE _pcls1fbe, android.support.v7.widget.RecyclerView.con con, int i, int j)
    {
        android.support.v7.widget.RecyclerView.if if1;
        if (super.eH != null)
        {
            if1 = super.eH.dF;
        } else
        {
            if1 = null;
        }
        int k;
        if (if1 != null)
        {
            k = if1.getItemCount();
        } else
        {
            k = 0;
        }
        if (apq._mth02CB(bzd) > 0 && k > 0)
        {
            j = 0;
            int l = 0;
            int i1;
            do
            {
                i1 = j;
                if (l >= k)
                {
                    break;
                }
                View view = _pcls1fbe._mth02BB(l, false);
                if (view != null)
                {
                    _mth141D(view, 0, 0);
                    con = new int[2];
                    Rect rect = ((android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams()).eK;
                    con[0] = view.getMeasuredWidth() + rect.left + rect.right;
                    rect = ((android.support.v7.widget.RecyclerView._cls02BC)view.getLayoutParams()).eK;
                    con[1] = view.getMeasuredHeight() + rect.top + rect.bottom;
                    _pcls1fbe._mth02D0(view);
                } else
                {
                    con = null;
                }
                i1 = j;
                if (con != null)
                {
                    i1 = j + con[1];
                }
                if (i1 > apq._mth02CB(bzd))
                {
                    i1 = apq._mth02CB(bzd);
                    break;
                }
                l++;
                j = i1;
            } while (true);
            i = android.view.View.MeasureSpec.getSize(i);
            RecyclerView._mth02CE(super.eH, i, i1);
            return;
        } else
        {
            super._mth02CB(_pcls1fbe, con, i, j);
            return;
        }
    }
}
