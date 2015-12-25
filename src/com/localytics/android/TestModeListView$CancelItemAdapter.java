// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.localytics.android:
//            TestModeListView, DatapointHelper

final class mContext extends BaseAdapter
{

    private final String MENU_ITEMS[] = {
        "Cancel"
    };
    private final Context mContext;
    final TestModeListView this$0;

    public final int getCount()
    {
        return MENU_ITEMS.length;
    }

    public final volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public final String getItem(int i)
    {
        return MENU_ITEMS[i];
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = new LinearLayout(mContext);
            viewgroup.setLayoutParams(new android.widget.Adapter.mContext(-1, -2));
            viewgroup.setOrientation(1);
            int j = (int)(mContext.getResources().getDisplayMetrics().density * 6F + 0.5F);
            viewgroup.setPadding(0, j, 0, j);
            view = new TextView(mContext);
            view.setId(1);
            view.setTextSize(26F);
            view.setTextColor(Color.argb(255, 0, 91, 255));
            view.setGravity(17);
            viewgroup.addView(view);
            float f = getResources().getDisplayMetrics().density * 8F;
            view = new GradientDrawable(android.graphics.drawable.ntext, new int[] {
                -1, -1, -1
            });
            view.setGradientType(0);
            view.setCornerRadii(new float[] {
                f, f, f, f, f, f, f, f
            });
            if (DatapointHelper.getApiLevel() >= 16)
            {
                viewgroup.setBackground(view);
            } else
            {
                viewgroup.setBackgroundColor(-1);
            }
        }
        view = (TextView)viewgroup.findViewById(1);
        view.setText(MENU_ITEMS[i]);
        view.setTypeface(null, 1);
        return viewgroup;
    }

    (Context context)
    {
        this$0 = TestModeListView.this;
        super();
        mContext = context;
    }
}
