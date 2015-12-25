// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.ArrayList;
import o.FB1F;
import o.FE70;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

final class <init> extends <init>
{

    private RecyclerView ex;

    private void FB32()
    {
        if (RecyclerView._mth02C8(ex) && RecyclerView._mth02C9(ex) && RecyclerView._mth02CC(ex))
        {
            FE70._mth02CA(ex, RecyclerView._mth02CD(ex));
            return;
        } else
        {
            RecyclerView._mth02CB(ex, true);
            ex.requestLayout();
            return;
        }
    }

    public final void onChanged()
    {
        ex._mth1FBE(null);
        if (RecyclerView._mth02BB(ex).)
        {
            ex.ek.q = true;
            RecyclerView._mth02BF(ex);
        } else
        {
            ex.ek.q = true;
            RecyclerView._mth02BF(ex);
        }
        boolean flag;
        if (ex.dB.s.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            ex.requestLayout();
        }
    }

    public final void _mth2071(int i, int j)
    {
        ex._mth1FBE(null);
        FB1F fb1f = ex.dB;
        fb1f.s.add(fb1f._mth02BC(2, i, j));
        if (fb1f.s.size() == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            FB32();
        }
    }

    public final void FE76(int i, int j)
    {
        ex._mth1FBE(null);
        FB1F fb1f = ex.dB;
        fb1f.s.add(fb1f._mth02BC(0, i, j));
        if (fb1f.s.size() == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            FB32();
        }
    }

    public final void FE7A(int i, int j)
    {
        ex._mth1FBE(null);
        FB1F fb1f = ex.dB;
        fb1f.s.add(fb1f._mth02BC(1, i, j));
        if (fb1f.s.size() == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            FB32();
        }
    }

    private (RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
    }

    <init>(RecyclerView recyclerview, byte byte0)
    {
        this(recyclerview);
    }
}
