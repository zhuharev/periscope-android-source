// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package o:
//            aih, aig, zc, atv, 
//            yv, atn, ato, FBFF

public final class aio extends aih
{

    private final yv bnS;
    private final int bnT;

    public aio(int i, int j, yv yv1)
    {
        super(i);
        bnS = yv1;
        bnT = j;
    }

    public final void _mth02CA(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.con con)
    {
        boolean flag;
label0:
        {
label1:
            {
                int i;
label2:
                {
                    rect.left = 0;
                    rect.right = 0;
                    rect.bottom = bng;
                    if (RecyclerView._mth15EE(view) == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        rect.top = bng;
                        return;
                    }
                    i = RecyclerView._mth15EE(view);
                    if (i == 0)
                    {
                        break label1;
                    }
                    recyclerview = (aig)recyclerview.dF;
                    Object obj = (atv)((aig) (recyclerview)).bmU.FF89.get(i);
                    con = bnS;
                    obj = ((atv) (obj)).ga();
                    con = (atn)((yv) (con)).aWg.get(obj);
                    if (con != null)
                    {
                        if (((atn) (con)).bDW == ato.bEd)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (!flag)
                        {
                            break label2;
                        }
                    }
                    flag = false;
                    break label0;
                }
                con = (atv)((aig) (recyclerview)).bmU.FF89.get(i - 1);
                recyclerview = bnS;
                con = con.ga();
                recyclerview = (atn)((yv) (recyclerview)).aWg.get(con);
                if (recyclerview != null)
                {
                    if (((atn) (recyclerview)).bDW == ato.bEd)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        flag = true;
                        break label0;
                    }
                }
            }
            flag = false;
        }
        if (flag)
        {
            rect.top = bnT;
            return;
        }
        if (view instanceof FBFF)
        {
            rect.bottom = 0;
            return;
        } else
        {
            rect.top = 0;
            return;
        }
    }
}
