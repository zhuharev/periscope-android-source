// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package o:
//            FB54, alu

final class alv extends FB54
{

    private final int bsq[];
    private final int bsr[];
    private final Context mContext;

    public alv(alu alu, int ai[], int ai1[])
    {
        mContext = alu;
        bsq = ai;
        bsr = ai1;
    }

    public final int getCount()
    {
        return bsq.length;
    }

    public final Object _mth02CA(ViewPager viewpager, int i)
    {
        View view = LayoutInflater.from(mContext).inflate(0x7f030098, viewpager, false);
        ((ImageView)view.findViewById(0x7f0d0033)).setImageResource(bsq[i]);
        ((TextView)view.findViewById(0x7f0d000c)).setText(bsr[i]);
        viewpager.addView(view);
        return view;
    }

    public final void _mth02CA(ViewPager viewpager, int i, Object obj)
    {
        viewpager.removeView((View)obj);
    }

    public final boolean _mth02CB(View view, Object obj)
    {
        return view == obj;
    }
}
