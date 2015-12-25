// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package o:
//            _cls1D2C

public final class _cls1E2F extends _cls1D2C
{

    private final ListView _fld0697;

    public _cls1E2F(_cls1E3B.if if1)
    {
        super(if1);
        _fld0697 = if1;
    }

    public final void _mth05D9(int i)
    {
        ListView listview = _fld0697;
        int j = listview.getFirstVisiblePosition();
        if (j == -1)
        {
            return;
        }
        View view = listview.getChildAt(0);
        if (view == null)
        {
            return;
        } else
        {
            listview.setSelectionFromTop(j, view.getTop() - i);
            return;
        }
    }

    public final boolean _mth0674(int i)
    {
        ListView listview = _fld0697;
        int j = listview.getCount();
        if (j == 0)
        {
            return false;
        }
        int k = listview.getChildCount();
        int l = listview.getFirstVisiblePosition();
        if (i > 0)
        {
            if (l + k >= j && listview.getChildAt(k - 1).getBottom() <= listview.getHeight())
            {
                return false;
            }
        } else
        if (i < 0)
        {
            if (l <= 0 && listview.getChildAt(0).getTop() >= 0)
            {
                return false;
            }
        } else
        {
            return false;
        }
        return true;
    }
}
