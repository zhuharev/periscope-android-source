// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.ViewGroup;
import o.02B8;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class ez
{

    public final A ey = new A();
    public boolean ez;

    public abstract int getItemCount();

    public long getItemId(int i)
    {
        return -1L;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public abstract void _mth02CA(C c, int i);

    public abstract C _mth02CB(ViewGroup viewgroup, int i);

    public final void _mth02CB(C c, int i)
    {
        c.bX = i;
        if (ez)
        {
            c.fA = getItemId(i);
        }
        c._fld0E20 = c._fld0E20 & 0xfffffdf8 | 1;
        _cls02B8.beginSection("RV OnBindView");
        _mth02CA(c, i);
        _cls02B8.endSection();
    }

    public C()
    {
        ez = false;
    }
}
