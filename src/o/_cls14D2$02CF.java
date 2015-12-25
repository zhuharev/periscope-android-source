// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewParent;

// Referenced classes of package o:
//            _cls14D2, _cls207F

static class .View
    implements ject
{

    public void _mth02CA(ViewParent viewparent, View view)
    {
        if (viewparent instanceof _cls207F)
        {
            ((_cls207F)viewparent).onStopNestedScroll(view);
        }
    }

    public void _mth02CA(ViewParent viewparent, View view, int i, int j, int k, int l)
    {
        if (viewparent instanceof _cls207F)
        {
            ((_cls207F)viewparent).onNestedScroll(view, i, j, k, l);
        }
    }

    public void _mth02CA(ViewParent viewparent, View view, int i, int j, int ai[])
    {
        if (viewparent instanceof _cls207F)
        {
            ((_cls207F)viewparent).onNestedPreScroll(view, i, j, ai);
        }
    }

    public boolean _mth02CA(ViewParent viewparent, View view, float f, float f1)
    {
        if (viewparent instanceof _cls207F)
        {
            return ((_cls207F)viewparent).onNestedPreFling(view, f, f1);
        } else
        {
            return false;
        }
    }

    public boolean _mth02CA(ViewParent viewparent, View view, float f, float f1, boolean flag)
    {
        if (viewparent instanceof _cls207F)
        {
            return ((_cls207F)viewparent).onNestedFling(view, f, f1, flag);
        } else
        {
            return false;
        }
    }

    public boolean _mth02CA(ViewParent viewparent, View view, View view1, int i)
    {
        if (viewparent instanceof _cls207F)
        {
            return ((_cls207F)viewparent).onStartNestedScroll(view, view1, i);
        } else
        {
            return false;
        }
    }

    public void _mth02CB(ViewParent viewparent, View view, View view1, int i)
    {
        if (viewparent instanceof _cls207F)
        {
            ((_cls207F)viewparent).onNestedScrollAccepted(view, view1, i);
        }
    }

    .View()
    {
    }
}
