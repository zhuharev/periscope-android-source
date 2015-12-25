// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public class <init>
    implements if
{

    private RecyclerView ex;

    public final void _mth02BB(if if1)
    {
        if1.setIsRecyclable(true);
        if (!RecyclerView._mth02CE(ex, if1.fy))
        {
            boolean flag;
            if ((if1._fld0E20 & 0x100) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                ex.removeDetachedView(if1.fy, false);
            }
        }
    }

    public final void _mth02BC(fy fy)
    {
        fy.setIsRecyclable(true);
        boolean flag;
        if ((fy._fld0E20 & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            RecyclerView._mth02CE(ex, fy.fy);
        }
    }

    public final void _mth02BD(fy fy)
    {
        fy.setIsRecyclable(true);
        boolean flag;
        if ((fy._fld0E20 & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            RecyclerView._mth02CE(ex, fy.fy);
        }
    }

    public final void _mth037A(fy fy)
    {
        fy.setIsRecyclable(true);
        if (fy.fD != null && fy.fE == null)
        {
            fy.fD = null;
            int i = fy._fld0E20;
            fy._fld0E20 = fy._fld0E20 & ~i | i & 0xffffffbf;
        }
        fy.fE = null;
        boolean flag;
        if ((fy._fld0E20 & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            RecyclerView._mth02CE(ex, fy.fy);
        }
    }

    if()
    {
    }

    private if(RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
    }

    ex(RecyclerView recyclerview, byte byte0)
    {
        this(recyclerview);
    }
}
