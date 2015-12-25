// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewParent;

// Referenced classes of package o:
//            adu

public final class adv
    implements android.support.v7.widget.RecyclerView._cls02BD
{

    private adu bfy;

    adv(adu adu)
    {
        bfy = adu;
        super();
    }

    public final boolean _mth1428(RecyclerView recyclerview)
    {
        Object obj = (LinearLayoutManager)recyclerview.dG;
        obj = ((LinearLayoutManager) (obj))._mth02CA(0, ((LinearLayoutManager) (obj)).getChildCount(), true, false);
        int i;
        if (obj == null)
        {
            i = -1;
        } else
        {
            i = LinearLayoutManager._mth1D38(((android.view.View) (obj)));
        }
        if (i == 0)
        {
            recyclerview.getParent().requestDisallowInterceptTouchEvent(false);
        } else
        {
            recyclerview.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }
}
