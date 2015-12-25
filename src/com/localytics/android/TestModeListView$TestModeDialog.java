// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            TestModeListView, InAppCallable

final class adjustLayout extends Dialog
{

    private TranslateAnimation mAnimIn;
    private TranslateAnimation mAnimOut;
    private RelativeLayout mDialogLayout;
    private DisplayMetrics mMetrics;
    final TestModeListView this$0;

    private void adjustLayout()
    {
        mMetrics = new DisplayMetrics();
        ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(mMetrics);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
        android.view.odeDialog odedialog = window.getAttributes();
        odedialog.ount = 0.0F;
        odedialog. = mMetrics.widthPixels;
        window.setAttributes(odedialog);
        if (TestModeListView.access$400(TestModeListView.this).getAndSet(false))
        {
            mDialogLayout.startAnimation(mAnimIn);
        }
        window.setFlags(1024, 1024);
    }

    private void createAnimations()
    {
        mAnimIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
        mAnimIn.setDuration(250L);
        mAnimOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
        mAnimOut.setDuration(250L);
        class _cls4
            implements android.view.animation.Animation.AnimationListener
        {

            final TestModeListView.TestModeDialog this$1;

            public void onAnimationEnd(Animation animation)
            {
                dismiss();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            _cls4()
            {
                this$1 = TestModeListView.TestModeDialog.this;
                super();
            }
        }

        mAnimOut.setAnimationListener(new _cls4());
    }

    private void setupViews()
    {
        float f = getResources().getDisplayMetrics().density;
        mDialogLayout = new RelativeLayout(getContext());
        mDialogLayout.setLayoutParams(new android.widget.t>(-1, -1));
        mDialogLayout.setBackgroundColor(-1);
        RelativeLayout relativelayout = new RelativeLayout(getContext());
        Object obj = new android.widget.t>(-1, -2);
        ((android.widget.t>) (obj)).ule(10);
        relativelayout.setId(1);
        relativelayout.setLayoutParams(((android.view.) (obj)));
        relativelayout.setBackgroundColor(Color.argb(255, 73, 73, 73));
        relativelayout.setPadding((int)(8F * f + 0.5F), (int)(12F * f + 0.5F), (int)(8F * f + 0.5F), (int)(12F * f + 0.5F));
        mDialogLayout.addView(relativelayout);
        obj = new TextView(getContext());
        ((TextView) (obj)).setText("Close");
        ((TextView) (obj)).setTextSize(22F);
        int ai[] = {
            0x10100a7
        };
        int ai1[] = {
            0x101009c
        };
        int ai2[] = new int[0];
        int i = Color.argb(255, 255, 0, 0);
        int j = Color.argb(255, 0, 91, 255);
        int k = Color.argb(255, 0, 91, 255);
        ((TextView) (obj)).setTextColor(new ColorStateList(new int[][] {
            ai, ai1, ai2
        }, new int[] {
            i, j, k
        }));
        class _cls1
            implements android.view.View.OnClickListener
        {

            final TestModeListView.TestModeDialog this$1;

            public void onClick(View view)
            {
                mDialogLayout.startAnimation(mAnimOut);
                if (TestModeListView.access$200(this$0) != null)
                {
                    view = (InAppCallable)TestModeListView.access$200(this$0).get(Integer.valueOf(10));
                    if (view != null)
                    {
                        view.call(null);
                    }
                }
            }

            _cls1()
            {
                this$1 = TestModeListView.TestModeDialog.this;
                super();
            }
        }

        ((TextView) (obj)).setOnClickListener(new _cls1());
        android.widget.eDialog edialog = new android.widget.t>(-2, -2);
        edialog.ule(9);
        ((TextView) (obj)).setLayoutParams(edialog);
        relativelayout.addView(((View) (obj)));
        obj = new TextView(getContext());
        ((TextView) (obj)).setText("Localytics");
        ((TextView) (obj)).setTextSize(22F);
        ((TextView) (obj)).setTextColor(-1);
        edialog = new android.widget.t>(-2, -2);
        edialog.ule(13);
        ((TextView) (obj)).setLayoutParams(edialog);
        relativelayout.addView(((View) (obj)));
        obj = new TextView(getContext());
        ((TextView) (obj)).setText("Menu");
        ((TextView) (obj)).setTextSize(22F);
        i = Color.argb(255, 255, 0, 0);
        j = Color.argb(255, 0, 91, 255);
        k = Color.argb(255, 0, 91, 255);
        ((TextView) (obj)).setTextColor(new ColorStateList(new int[][] {
            new int[] {
                0x10100a7
            }, new int[] {
                0x101009c
            }, new int[0]
        }, new int[] {
            i, j, k
        }));
        class _cls2
            implements android.view.View.OnClickListener
        {

            final TestModeListView.TestModeDialog this$1;

            public void onClick(View view)
            {
                if (TestModeListView.access$200(this$0) != null)
                {
                    (new TestModeListView.MenuDialog(this$0, getActivity(), 0x103000b)).show();
                }
            }

            _cls2()
            {
                this$1 = TestModeListView.TestModeDialog.this;
                super();
            }
        }

        ((TextView) (obj)).setOnClickListener(new _cls2());
        edialog = new android.widget.t>(-2, -2);
        edialog.ule(11);
        ((TextView) (obj)).setLayoutParams(edialog);
        relativelayout.addView(((View) (obj)));
        relativelayout = new RelativeLayout(getContext());
        obj = new android.widget.t>(-1, -1);
        ((android.widget.t>) (obj)).ule(3, 1);
        relativelayout.setLayoutParams(((android.view.) (obj)));
        mDialogLayout.addView(relativelayout);
        obj = new ListView(getContext());
        ((ListView) (obj)).setAdapter(TestModeListView.access$300(TestModeListView.this));
        class _cls3
            implements android.widget.AdapterView.OnItemClickListener
        {

            final TestModeListView.TestModeDialog this$1;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                if (TestModeListView.access$200(this$0) != null)
                {
                    view = (InAppCallable)TestModeListView.access$200(this$0).get(Integer.valueOf(11));
                    if (view != null)
                    {
                        view.call(new Object[] {
                            adapterview.getItemAtPosition(l)
                        });
                    }
                }
            }

            _cls3()
            {
                this$1 = TestModeListView.TestModeDialog.this;
                super();
            }
        }

        ((ListView) (obj)).setOnItemClickListener(new _cls3());
        relativelayout.addView(((View) (obj)));
        requestWindowFeature(1);
        setContentView(mDialogLayout);
    }

    public final boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            mDialogLayout.startAnimation(mAnimOut);
            if (TestModeListView.access$200(TestModeListView.this) != null)
            {
                InAppCallable inappcallable = (InAppCallable)TestModeListView.access$200(TestModeListView.this).get(Integer.valueOf(10));
                if (inappcallable != null)
                {
                    inappcallable.call(null);
                }
            }
            return super.onKeyDown(i, keyevent);
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }



    public _cls3(Context context, int i)
    {
        this$0 = TestModeListView.this;
        super(context, i);
        setupViews();
        createAnimations();
        adjustLayout();
    }
}
