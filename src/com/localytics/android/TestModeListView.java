// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.02BF;
import o.02C9;
import o.1427;

// Referenced classes of package com.localytics.android:
//            DatapointHelper, InAppCallable

final class TestModeListView extends _cls02BF
{
    final class CancelItemAdapter extends BaseAdapter
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
                viewgroup.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
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
                view = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, new int[] {
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

        CancelItemAdapter(Context context)
        {
            this$0 = TestModeListView.this;
            super();
            mContext = context;
        }
    }

    class MenuDialog extends Dialog
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
            mDialogLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            mDialogLayout.setGravity(16);
            mDialogLayout.setOrientation(1);
            int i = getContext().getResources().getColor(0x106000d);
            Object obj = new MenuItemAdapter(getActivity());
            Object obj1 = new ListView(getActivity());
            ((ListView) (obj1)).setAdapter(((ListAdapter) (obj)));
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

                final MenuDialog this$1;

                public void onItemClick(AdapterView adapterview, View view, int j, long l)
                {
                    if (j == 0)
                    {
                        Constants.setTestModeEnabled(false);
                        dismiss();
                    } else
                    if (j == 1)
                    {
                        if (mCallbacks != null)
                        {
                            adapterview = (InAppCallable)mCallbacks.get(Integer.valueOf(12));
                            if (adapterview != null)
                            {
                                adapterview.call(null);
                            }
                        }
                    } else
                    if (j == 2)
                    {
                        if (mCallbacks != null)
                        {
                            adapterview = (InAppCallable)mCallbacks.get(Integer.valueOf(13));
                            if (adapterview != null)
                            {
                                adapterview.call(null);
                            }
                        }
                    } else
                    if (j == 3 && mCallbacks != null)
                    {
                        adapterview = (InAppCallable)mCallbacks.get(Integer.valueOf(14));
                        if (adapterview != null)
                        {
                            adapterview.call(null);
                        }
                    }
                    dismiss();
                }

                _cls1()
                {
                    this$1 = MenuDialog.this;
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
            ((View) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, (int)(getResources().getDisplayMetrics().density * 10F + 0.5F)));
            mDialogLayout.addView(((View) (obj)));
            obj1 = new CancelItemAdapter(getActivity());
            ListView listview = new ListView(getActivity());
            listview.setAdapter(((ListAdapter) (obj1)));
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

                final MenuDialog this$1;

                public void onItemClick(AdapterView adapterview, View view, int j, long l)
                {
                    dismiss();
                }

                _cls2()
                {
                    this$1 = MenuDialog.this;
                    super();
                }
            }

            listview.setOnItemClickListener(new _cls2());
            mDialogLayout.addView(listview);
            requestWindowFeature(1);
            setContentView(mDialogLayout);
        }

        public MenuDialog(Context context, int i)
        {
            this$0 = TestModeListView.this;
            super(context, i);
            setupViews();
            adjustLayout();
        }
    }

    final class MenuItemAdapter extends BaseAdapter
    {

        private final String MENU_ITEMS[] = {
            "Disable Test Mode", "Refresh", "Copy Push Token", "Copy Install ID"
        };
        private final Context mContext;
        final TestModeListView this$0;

        private Drawable getShape(int i)
        {
            float f = getResources().getDisplayMetrics().density * 8F;
            GradientDrawable gradientdrawable = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, new int[] {
                -1, -1, -1
            });
            gradientdrawable.setGradientType(0);
            switch (i)
            {
            default:
                return gradientdrawable;

            case 0: // '\0'
                gradientdrawable.setCornerRadii(new float[] {
                    f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F
                });
                return gradientdrawable;

            case 1: // '\001'
            case 2: // '\002'
                return gradientdrawable;

            case 3: // '\003'
                gradientdrawable.setCornerRadii(new float[] {
                    0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f
                });
                break;
            }
            return gradientdrawable;
        }

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
                viewgroup.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
                viewgroup.setOrientation(1);
                int j = (int)(mContext.getResources().getDisplayMetrics().density * 6F + 0.5F);
                viewgroup.setPadding(0, j, 0, j);
                view = new TextView(mContext);
                view.setId(1);
                view.setTextSize(26F);
                view.setTextColor(Color.argb(255, 0, 91, 255));
                view.setGravity(17);
                viewgroup.addView(view);
                if (DatapointHelper.getApiLevel() >= 16)
                {
                    viewgroup.setBackground(getShape(i));
                } else
                {
                    viewgroup.setBackgroundColor(-1);
                }
            }
            view = (TextView)viewgroup.findViewById(1);
            view.setText(MENU_ITEMS[i]);
            switch (i)
            {
            default:
                return viewgroup;

            case 0: // '\0'
                view.setTextColor(0xffff0000);
                break;
            }
            return viewgroup;
        }

        public MenuItemAdapter(Context context)
        {
            this$0 = TestModeListView.this;
            super();
            mContext = context;
        }
    }

    final class TestModeDialog extends Dialog
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
            android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
            layoutparams.dimAmount = 0.0F;
            layoutparams.width = mMetrics.widthPixels;
            window.setAttributes(layoutparams);
            if (mEnterAnimatable.getAndSet(false))
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

                final TestModeDialog this$1;

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
                    this$1 = TestModeDialog.this;
                    super();
                }
            }

            mAnimOut.setAnimationListener(new _cls4());
        }

        private void setupViews()
        {
            float f = getResources().getDisplayMetrics().density;
            mDialogLayout = new RelativeLayout(getContext());
            mDialogLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            mDialogLayout.setBackgroundColor(-1);
            RelativeLayout relativelayout = new RelativeLayout(getContext());
            Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            relativelayout.setId(1);
            relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
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

                final TestModeDialog this$1;

                public void onClick(View view)
                {
                    mDialogLayout.startAnimation(mAnimOut);
                    if (mCallbacks != null)
                    {
                        view = (InAppCallable)mCallbacks.get(Integer.valueOf(10));
                        if (view != null)
                        {
                            view.call(null);
                        }
                    }
                }

                _cls1()
                {
                    this$1 = TestModeDialog.this;
                    super();
                }
            }

            ((TextView) (obj)).setOnClickListener(new _cls1());
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(9);
            ((TextView) (obj)).setLayoutParams(layoutparams);
            relativelayout.addView(((View) (obj)));
            obj = new TextView(getContext());
            ((TextView) (obj)).setText("Localytics");
            ((TextView) (obj)).setTextSize(22F);
            ((TextView) (obj)).setTextColor(-1);
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(13);
            ((TextView) (obj)).setLayoutParams(layoutparams);
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

                final TestModeDialog this$1;

                public void onClick(View view)
                {
                    if (mCallbacks != null)
                    {
                        (new MenuDialog(getActivity(), 0x103000b)).show();
                    }
                }

                _cls2()
                {
                    this$1 = TestModeDialog.this;
                    super();
                }
            }

            ((TextView) (obj)).setOnClickListener(new _cls2());
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(11);
            ((TextView) (obj)).setLayoutParams(layoutparams);
            relativelayout.addView(((View) (obj)));
            relativelayout = new RelativeLayout(getContext());
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, 1);
            relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mDialogLayout.addView(relativelayout);
            obj = new ListView(getContext());
            ((ListView) (obj)).setAdapter(mAdapter);
            class _cls3
                implements android.widget.AdapterView.OnItemClickListener
            {

                final TestModeDialog this$1;

                public void onItemClick(AdapterView adapterview, View view, int l, long l1)
                {
                    if (mCallbacks != null)
                    {
                        view = (InAppCallable)mCallbacks.get(Integer.valueOf(11));
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
                    this$1 = TestModeDialog.this;
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
                if (mCallbacks != null)
                {
                    InAppCallable inappcallable = (InAppCallable)mCallbacks.get(Integer.valueOf(10));
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



        public TestModeDialog(Context context, int i)
        {
            this$0 = TestModeListView.this;
            super(context, i);
            setupViews();
            createAnimations();
            adjustLayout();
        }
    }


    static final String TEST_MODE_LIST_TAG = "marketing_test_mode_list";
    private ListAdapter mAdapter;
    private Map mCallbacks;
    private final AtomicBoolean mEnterAnimatable = new AtomicBoolean(true);

    private TestModeListView()
    {
    }

    public static TestModeListView newInstance()
    {
        TestModeListView testmodelistview = new TestModeListView();
        testmodelistview.setRetainInstance(true);
        return testmodelistview;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        Localytics.Log.d("[TestModeListView]: onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public final void onAttach(Activity activity)
    {
        Localytics.Log.d("[TestModeListView]: onAttach");
        super.onAttach(activity);
    }

    public final void onCreate(Bundle bundle)
    {
        Localytics.Log.d("[TestModeListView]: onCreate");
        super.onCreate(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        Localytics.Log.d("[TestModeListView]: onCreateDialog");
        return new TestModeDialog(getActivity(), 0x103000b);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Localytics.Log.d("[TestModeListView]: onCreateView");
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public final void onDestroy()
    {
        Localytics.Log.d("[TestModeListView]: onDestroy");
        super.onDestroy();
    }

    public final void onDestroyView()
    {
        Localytics.Log.d("[TestModeListView]: onDestroyView");
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    public final void onDetach()
    {
        Localytics.Log.d("[TestModeListView]: onDetach");
        super.onDetach();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        Localytics.Log.d("[TestModeListView]: onDismiss");
        super.onDismiss(dialoginterface);
    }

    public final void onPause()
    {
        Localytics.Log.d("[TestModeListView]: onPause");
        super.onPause();
    }

    public final void onResume()
    {
        Localytics.Log.d("[TestModeListView]: onResume");
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        Localytics.Log.d("[TestModeListView]: onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    public final void onStart()
    {
        Localytics.Log.d("[TestModeListView]: onStart");
        super.onStart();
    }

    public final void onStop()
    {
        Localytics.Log.d("[TestModeListView]: onStop");
        super.onStop();
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        Localytics.Log.d("[TestModeListView]: onViewStateRestored");
        super.onViewStateRestored(bundle);
    }

    public final void setAdapter(ListAdapter listadapter)
    {
        mAdapter = listadapter;
    }

    public final TestModeListView setCallbacks(Map map)
    {
        mCallbacks = map;
        return this;
    }

    public final void show(_cls1427 _pcls1427, String s)
    {
        mEnterAnimatable.set(true);
        super.show(_pcls1427, s);
    }



}
