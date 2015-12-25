// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            TestModeListView, DatapointHelper

class adjustLayout extends Dialog
{

    private LinearLayout mDialogLayout;
    private DisplayMetrics mMetrics;
    final TestModeListView this$0;

    private void adjustLayout()
    {
        mMetrics = new DisplayMetrics();
        ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(mMetrics);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setAttributes(window.getAttributes());
        window.setFlags(1024, 1024);
    }

    private void setupViews()
    {
        mDialogLayout = new LinearLayout(getContext());
        mDialogLayout.setLayoutParams(new android.widget.nit>(-1, -2));
        mDialogLayout.setGravity(16);
        mDialogLayout.setOrientation(1);
        int i = getContext().getResources().getColor(0x106000d);
        Object obj = new pter(TestModeListView.this, getActivity());
        Object obj1 = new ListView(getActivity());
        ((ListView) (obj1)).setAdapter(((android.widget.ListAdapter) (obj)));
        if (DatapointHelper.getApiLevel() >= 16)
        {
            ((ListView) (obj1)).setBackground(new ColorDrawable(i));
        } else
        {
            ((ListView) (obj1)).setBackgroundColor(i);
        }
        ((ListView) (obj1)).setDividerHeight(1);
        class _cls1
            implements android.widget.AdapterView.OnItemClickListener
        {

            final TestModeListView.MenuDialog this$1;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                if (j == 0)
                {
                    Constants.setTestModeEnabled(false);
                    dismiss();
                } else
                if (j == 1)
                {
                    if (TestModeListView.access$200(this$0) != null)
                    {
                        adapterview = (InAppCallable)TestModeListView.access$200(this$0).get(Integer.valueOf(12));
                        if (adapterview != null)
                        {
                            adapterview.call(null);
                        }
                    }
                } else
                if (j == 2)
                {
                    if (TestModeListView.access$200(this$0) != null)
                    {
                        adapterview = (InAppCallable)TestModeListView.access$200(this$0).get(Integer.valueOf(13));
                        if (adapterview != null)
                        {
                            adapterview.call(null);
                        }
                    }
                } else
                if (j == 3 && TestModeListView.access$200(this$0) != null)
                {
                    adapterview = (InAppCallable)TestModeListView.access$200(this$0).get(Integer.valueOf(14));
                    if (adapterview != null)
                    {
                        adapterview.call(null);
                    }
                }
                dismiss();
            }

            _cls1()
            {
                this$1 = TestModeListView.MenuDialog.this;
                super();
            }
        }

        ((ListView) (obj1)).setOnItemClickListener(new _cls1());
        mDialogLayout.addView(((View) (obj1)));
        obj = new View(getActivity());
        if (DatapointHelper.getApiLevel() >= 16)
        {
            ((View) (obj)).setBackground(new ColorDrawable(i));
        } else
        {
            ((View) (obj)).setBackgroundColor(i);
        }
        ((View) (obj)).setLayoutParams(new android.widget.nit>(-1, (int)(getResources().getDisplayMetrics().density * 10F + 0.5F)));
        mDialogLayout.addView(((View) (obj)));
        obj1 = new dapter(TestModeListView.this, getActivity());
        ListView listview = new ListView(getActivity());
        listview.setAdapter(((android.widget.ListAdapter) (obj1)));
        if (DatapointHelper.getApiLevel() >= 16)
        {
            listview.setBackground(new ColorDrawable(i));
        } else
        {
            ((View) (obj)).setBackgroundColor(i);
        }
        class _cls2
            implements android.widget.AdapterView.OnItemClickListener
        {

            final TestModeListView.MenuDialog this$1;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                dismiss();
            }

            _cls2()
            {
                this$1 = TestModeListView.MenuDialog.this;
                super();
            }
        }

        listview.setOnItemClickListener(new _cls2());
        mDialogLayout.addView(listview);
        requestWindowFeature(1);
        setContentView(mDialogLayout);
    }

    public _cls2(Context context, int i)
    {
        this$0 = TestModeListView.this;
        super(context, i);
        setupViews();
        adjustLayout();
    }
}
