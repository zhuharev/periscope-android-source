// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

// Referenced classes of package o:
//            FB54

final class aqp extends FB54
{

    private final List bAK;

    public aqp(List list)
    {
        bAK = list;
    }

    public final int getCount()
    {
        return bAK.size();
    }

    public final Object _mth02CA(ViewPager viewpager, int i)
    {
        View view = (View)bAK.get(i);
        viewpager.addView(view);
        return view;
    }

    public final void _mth02CA(ViewPager viewpager, int i, Object obj)
    {
        viewpager.removeView((View)obj);
    }

    public final boolean _mth02CB(View view, Object obj)
    {
        return view.equals(obj);
    }
}
