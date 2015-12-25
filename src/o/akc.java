// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

// Referenced classes of package o:
//            FB54, aka, aqe

final class akc extends FB54
{

    private final aqe bpX;
    final List bpp;

    akc(List list, aqe aqe)
    {
        bpp = list;
        bpX = aqe;
    }

    public final int getCount()
    {
        return bpp.size();
    }

    public final Object _mth02CA(ViewPager viewpager, int i)
    {
        aka aka1 = (aka)bpp.get(i);
        aka1._mth02CA(viewpager, i, bpX);
        return aka1;
    }

    public final void _mth02CA(ViewPager viewpager, int i, Object obj)
    {
        viewpager.removeViewAt(i);
        ((aka)bpp.remove(i)).cP().destroy();
    }

    public final boolean _mth02CB(View view, Object obj)
    {
        return ((aka)bpp.get(view.getId())).equals(obj);
    }
}
