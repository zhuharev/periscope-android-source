// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.RecyclerView;

public final class FB68
    implements Runnable
{

    private RecyclerView ex;

    public FB68(RecyclerView recyclerview)
    {
        ex = recyclerview;
        super();
    }

    public final void run()
    {
        if (ex.ea != null)
        {
            ex.ea.FEE8();
        }
        RecyclerView._mth02CA(ex, false);
    }
}
