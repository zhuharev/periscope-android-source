// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.02BF;
import o.02C9;
import o.1427;

// Referenced classes of package com.localytics.android:
//            Constants, DatapointHelper

public final class TestModeButton extends _cls02BF
{
    final class TestModeDialog extends Dialog
    {

        private static final int X_OFFSET = 0;
        private static final int Y_OFFSET = 85;
        private TranslateAnimation mAnimIn;
        private TranslateAnimation mAnimOut;
        private RelativeLayout mDialogLayout;
        private DisplayMetrics mMetrics;
        final TestModeButton this$0;

        private void adjustLayout()
        {
            mMetrics = new DisplayMetrics();
            ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(mMetrics);
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(51);
            android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
            layoutparams.x = (int)TypedValue.applyDimension(1, 0.0F, mMetrics);
            layoutparams.y = (int)TypedValue.applyDimension(1, 85F, mMetrics);
            layoutparams.dimAmount = 0.0F;
            window.setAttributes(layoutparams);
            window.clearFlags(2);
            window.setFlags(32, 32);
            if (mEnterAnimatable.getAndSet(false))
            {
                mDialogLayout.startAnimation(mAnimIn);
            }
            window.setFlags(1024, 1024);
        }

        private void createAnimations()
        {
            mAnimIn = new TranslateAnimation(2, -1F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
            mAnimIn.setDuration(250L);
            mAnimOut = new TranslateAnimation(2, 0.0F, 2, -1F, 2, 0.0F, 2, 0.0F);
            mAnimOut.setDuration(250L);
            class _cls2
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

                _cls2()
                {
                    this$1 = TestModeDialog.this;
                    super();
                }
            }

            mAnimOut.setAnimationListener(new _cls2());
        }

        private void setupViews()
        {
            mDialogLayout = new RelativeLayout(getContext());
            Object obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            mDialogLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new Button(getContext(), null);
            class _cls1
                implements android.view.View.OnClickListener
            {

                final TestModeDialog this$1;

                public void onClick(View view)
                {
                    mDialogLayout.startAnimation(mAnimOut);
                    if (mCallbacks != null)
                    {
                        view = (InAppCallable)mCallbacks.get(Integer.valueOf(9));
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

            ((Button) (obj)).setOnClickListener(new _cls1());
            mDialogLayout.addView(((View) (obj)));
            requestWindowFeature(1);
            setContentView(mDialogLayout);
        }

        public final boolean onKeyDown(int i, KeyEvent keyevent)
        {
            if (i == 4)
            {
                mDialogLayout.startAnimation(mAnimOut);
                Constants.setTestModeEnabled(false);
            }
            return super.onKeyDown(i, keyevent);
        }



        public TestModeDialog(Context context, int i)
        {
            this$0 = TestModeButton.this;
            super(context, i);
            setupViews();
            createAnimations();
            adjustLayout();
        }
    }

    final class TestModeDialog.Button extends View
    {

        private static final int HEIGHT = 60;
        private static final int WIDTH = 60;
        private final int BACKGROUND_COLOR = Color.argb(255, 51, 51, 51);
        private final int BAR1_COLOR = Color.argb(255, 138, 138, 138);
        private final int BAR2_COLOR = Color.argb(255, 217, 217, 217);
        private final int BAR3_COLOR = Color.argb(255, 220, 220, 220);
        private final int OVAL_COLOR = Color.argb(255, 70, 70, 70);
        private final Paint mPaint = new Paint(1);
        private final RectF mRectF;
        final TestModeDialog this$1;

        protected final void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            float f = getResources().getDisplayMetrics().density;
            mPaint.setColor(BACKGROUND_COLOR);
            canvas.drawRect(0.0F, 0.0F, 60F * f, 60F * f, mPaint);
            canvas.drawRoundRect(mRectF, 5F * f, 5F * f, mPaint);
            mPaint.setColor(BAR1_COLOR);
            canvas.drawRect(7F * f, 42F * f, 13F * f, 48F * f, mPaint);
            mPaint.setColor(BAR2_COLOR);
            canvas.drawRect(16F * f, 36F * f, 22F * f, 48F * f, mPaint);
            mPaint.setColor(BAR3_COLOR);
            canvas.drawRect(25F * f, 27F * f, 31F * f, 48F * f, mPaint);
            mPaint.setColor(-1);
            canvas.drawRect(34F * f, 12F * f, 40F * f, 48F * f, mPaint);
            mPaint.setColor(-1);
            canvas.drawRect(37F * f, 42F * f, 55F * f, 48F * f, mPaint);
            mPaint.setColor(OVAL_COLOR);
            canvas.drawOval(new RectF(59F * f, 40F * f, 63F * f, 44F * f), mPaint);
            canvas.drawOval(new RectF(59F * f, 30F * f, 63F * f, 34F * f), mPaint);
            canvas.drawOval(new RectF(59F * f, 20F * f, 63F * f, 24F * f), mPaint);
            canvas.drawOval(new RectF(59F * f, 10F * f, 63F * f, 14F * f), mPaint);
            canvas.drawOval(new RectF(54F * f, 35F * f, 58F * f, 39F * f), mPaint);
            canvas.drawOval(new RectF(54F * f, 25F * f, 58F * f, 29F * f), mPaint);
            canvas.drawOval(new RectF(54F * f, 15F * f, 58F * f, 19F * f), mPaint);
        }

        TestModeDialog.Button(Context context, AttributeSet attributeset)
        {
            this$1 = TestModeDialog.this;
            super(context, attributeset);
            if (DatapointHelper.getApiLevel() >= 19)
            {
                setLayerType(1, null);
            }
            float f = getResources().getDisplayMetrics().density;
            mRectF = new RectF(55F * f, 0.0F, 65F * f, 60F * f);
            setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)(65F * f + 0.5F), (int)(60F * f + 0.5F)));
            mPaint.setColor(BACKGROUND_COLOR);
            mPaint.setStyle(android.graphics.Paint.Style.FILL);
        }
    }


    static final String TEST_MODE_BUTTON_TAG = "marketing_test_mode_button";
    private Map mCallbacks;
    private final AtomicBoolean mEnterAnimatable = new AtomicBoolean(true);

    public TestModeButton()
    {
    }

    static TestModeButton newInstance()
    {
        TestModeButton testmodebutton = new TestModeButton();
        testmodebutton.setRetainInstance(true);
        return testmodebutton;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        Localytics.Log.d("[TestModeButton]: onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public final void onAttach(Activity activity)
    {
        Localytics.Log.d("[TestModeButton]: onAttach");
        super.onAttach(activity);
    }

    public final void onCreate(Bundle bundle)
    {
        Localytics.Log.d("[TestModeButton]: onCreate");
        super.onCreate(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        Localytics.Log.d("[TestModeButton]: onCreateDialog");
        return new TestModeDialog(getActivity(), 0x103000b);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Localytics.Log.d("[TestModeButton]: onCreateView");
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public final void onDestroy()
    {
        Localytics.Log.d("[TestModeButton]: onDestroy");
        super.onDestroy();
    }

    public final void onDestroyView()
    {
        Localytics.Log.d("[TestModeButton]: onDestroyView");
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    public final void onDetach()
    {
        Localytics.Log.d("[TestModeButton]: onDetach");
        super.onDetach();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        Localytics.Log.d("[TestModeButton]: onDismiss");
        super.onDismiss(dialoginterface);
    }

    public final void onPause()
    {
        Localytics.Log.d("[TestModeButton]: onPause");
        super.onPause();
    }

    public final void onResume()
    {
        Localytics.Log.d("[TestModeButton]: onResume");
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        Localytics.Log.d("[TestModeButton]: onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    public final void onStart()
    {
        Localytics.Log.d("[TestModeButton]: onStart");
        super.onStart();
    }

    public final void onStop()
    {
        Localytics.Log.d("[TestModeButton]: onStop");
        super.onStop();
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        Localytics.Log.d("[TestModeButton]: onViewStateRestored");
        super.onViewStateRestored(bundle);
    }

    final TestModeButton setCallbacks(Map map)
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
