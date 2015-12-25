// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package o:
//            akb, FBFF

public class aih extends akb
{

    protected final int bng;

    public aih(int i)
    {
        bng = i;
    }

    public void _mth02CA(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.con con)
    {
label0:
        {
            rect.left = 0;
            rect.right = 0;
            rect.bottom = bng;
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
                boolean flag1;
                switch (recyclerview._mth1D63(view).getItemViewType())
                {
                case 1: // '\001'
                case 2: // '\002'
                    flag1 = true;
                    break;

                default:
                    flag1 = false;
                    break;
                }
                if (flag1)
                {
                    rect.top = bng;
                    break label0;
                }
            }
            if (view instanceof FBFF)
            {
                rect.bottom = 0;
            } else
            {
                rect.top = 0;
            }
        }
        super._mth02CA(rect, view, recyclerview, con);
    }
}
