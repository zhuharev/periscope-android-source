// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import o.02BF;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            Constants, MarketingMessage, InAppCallable, JavaScriptClient, 
//            DatapointHelper

public final class InAppDialogFragment extends _cls02BF
{
    final class MarketingDialog extends Dialog
    {

        private static final String LOCATION_BOTTOM = "bottom";
        private static final String LOCATION_CENTER = "center";
        private static final String LOCATION_FULL = "full";
        private static final String LOCATION_TOP = "top";
        private static final int MARGIN = 10;
        private static final int MAX_BANNER_WIDTH_DIP = 360;
        private TranslateAnimation mAnimBottomIn;
        private TranslateAnimation mAnimBottomOut;
        private TranslateAnimation mAnimCenterIn;
        private TranslateAnimation mAnimCenterOut;
        private TranslateAnimation mAnimFullIn;
        private TranslateAnimation mAnimFullOut;
        private TranslateAnimation mAnimTopIn;
        private TranslateAnimation mAnimTopOut;
        private CloseButton mBtnClose;
        private RelativeLayout mDialogLayout;
        private float mHeight;
        private String mLocation;
        private DisplayMetrics mMetrics;
        private RelativeLayout mRootLayout;
        private MarketingWebView mWebView;
        private float mWidth;
        final InAppDialogFragment this$0;

        private void adjustLayout()
        {
            mMetrics = new DisplayMetrics();
            ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(mMetrics);
            mWidth = ((Float)mMarketingMessage.get("display_width")).floatValue();
            mHeight = ((Float)mMarketingMessage.get("display_height")).floatValue();
            float f = mHeight / mWidth;
            float f1 = Math.min(mMetrics.density * 360F, Math.min(mMetrics.widthPixels, mMetrics.heightPixels));
            Window window = getWindow();
            Object obj = window.getAttributes();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setFlags(32, 32);
            if (mLocation.equals("center"))
            {
                window.setLayout(mMetrics.widthPixels, mMetrics.heightPixels);
                int i = (int)(mMetrics.density * 10F + 0.5F);
                obj = (android.view.ViewGroup.MarginLayoutParams)mWebView.getLayoutParams();
                obj.width = (int)Math.min(f1 - (float)(i << 1), (int)(mWidth * mMetrics.density + 0.5F)) + (i << 1);
                obj.height = (int)(Math.min(f1 - (float)(i << 1), (int)(mWidth * mMetrics.density + 0.5F)) * f) + (i << 1);
                ((android.view.ViewGroup.MarginLayoutParams) (obj)).setMargins(i, i, i, i);
                mWebView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                mWebView.requestLayout();
                obj = (android.widget.RelativeLayout.LayoutParams)mBtnClose.getLayoutParams();
                ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, -i, 0);
                mBtnClose.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                mBtnClose.requestLayout();
            } else
            if (mLocation.equals("full"))
            {
                window.setLayout(mMetrics.widthPixels, mMetrics.heightPixels);
            } else
            if (mLocation.equals("top"))
            {
                obj.y = 0xf0000001;
                obj.dimAmount = 0.0F;
                window.setLayout((int)f1, (int)(f1 * f + 0.5F));
            } else
            if (mLocation.equals("bottom"))
            {
                obj.y = 0xfffffff;
                obj.dimAmount = 0.0F;
                window.setLayout((int)f1, (int)(f1 * f + 0.5F));
            }
            window.setFlags(1024, 1024);
        }

        private void createAnimations()
        {
            mAnimCenterIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            mAnimCenterIn.setDuration(500L);
            mAnimCenterOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
            mAnimCenterOut.setDuration(500L);
            mAnimTopIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1F, 2, 0.0F);
            mAnimTopIn.setDuration(500L);
            mAnimTopOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1F);
            mAnimTopOut.setDuration(500L);
            mAnimBottomIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            mAnimBottomIn.setDuration(500L);
            mAnimBottomOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
            mAnimBottomOut.setDuration(500L);
            mAnimFullIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            mAnimFullIn.setDuration(500L);
            mAnimFullOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
            mAnimFullOut.setDuration(500L);
            class _cls3
                implements android.view.animation.Animation.AnimationListener
            {

                final MarketingDialog this$1;

                public void onAnimationEnd(Animation animation)
                {
                    try
                    {
                        dismiss();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Animation animation)
                    {
                        LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", animation);
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                    if (mCallbacks != null)
                    {
                        animation = (InAppCallable)mCallbacks.get(17);
                        if (!Constants.isTestModeEnabled() && animation != null)
                        {
                            animation.call(null);
                        }
                    }
                }

                _cls3()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            Object obj = new _cls3();
            mAnimCenterOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimTopOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimBottomOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimFullOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            class _cls4
                implements android.view.animation.Animation.AnimationListener
            {

                final MarketingDialog this$1;

                public void onAnimationEnd(Animation animation)
                {
                    if (mCallbacks != null)
                    {
                        animation = (InAppCallable)mCallbacks.get(16);
                        if (!Constants.isTestModeEnabled() && animation != null)
                        {
                            animation.call(new Object[] {
                                mMarketingMessage
                            });
                        }
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

                _cls4()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            obj = new _cls4();
            mAnimCenterIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimTopIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimBottomIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimFullIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
        }

        private void setupViews()
        {
            mRootLayout = new RelativeLayout(getContext());
            mRootLayout.setVisibility(4);
            mRootLayout.setContentDescription("amp_view");
            mRootLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
            mDialogLayout = new RelativeLayout(getContext());
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(13);
            mDialogLayout.setLayoutParams(layoutparams);
            mRootLayout.addView(mDialogLayout);
            mWebView = new MarketingWebView(getContext(), null);
            mWebView.setId(2);
            mDialogLayout.addView(mWebView);
            mBtnClose = new CloseButton(getContext(), null);
            class _cls2
                implements android.view.View.OnClickListener
            {

                final MarketingDialog this$1;

                public void onClick(View view)
                {
                    if (mExitAnimatable.getAndSet(false))
                    {
                        dismissWithAnimation();
                    }
                }

                _cls2()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            mBtnClose.setOnClickListener(new _cls2());
            if (InAppDialogFragment.dismissButtonLocation == Localytics.InAppMessageDismissButtonLocation.RIGHT)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams1 = (android.widget.RelativeLayout.LayoutParams)mBtnClose.getLayoutParams();
                layoutparams1.addRule(7, mWebView.getId());
                mBtnClose.setLayoutParams(layoutparams1);
            }
            mDialogLayout.addView(mBtnClose);
            requestWindowFeature(1);
            setContentView(mRootLayout);
        }

        final void dismissWithAnimation()
        {
            class _cls5
                implements Runnable
            {

                final MarketingDialog this$1;

                public void run()
                {
                    String s = (String)mMarketingMessage.get("location");
                    if (s.equals("center"))
                    {
                        mRootLayout.startAnimation(mAnimCenterOut);
                        return;
                    }
                    if (s.equals("full"))
                    {
                        mRootLayout.startAnimation(mAnimFullOut);
                        return;
                    }
                    if (s.equals("top"))
                    {
                        mRootLayout.startAnimation(mAnimTopOut);
                        return;
                    }
                    if (s.equals("bottom"))
                    {
                        mRootLayout.startAnimation(mAnimBottomOut);
                    }
                }

                _cls5()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            (new Handler(Looper.getMainLooper())).post(new _cls5());
        }

        final void enterWithAnimation()
        {
            String s = (String)mMarketingMessage.get("location");
            if (s.equals("center"))
            {
                mRootLayout.startAnimation(mAnimCenterIn);
                return;
            }
            if (s.equals("full"))
            {
                mRootLayout.startAnimation(mAnimFullIn);
                return;
            }
            if (s.equals("top"))
            {
                mRootLayout.startAnimation(mAnimTopIn);
                return;
            }
            if (s.equals("bottom"))
            {
                mRootLayout.startAnimation(mAnimBottomIn);
            }
        }

        public final boolean onKeyDown(int i, KeyEvent keyevent)
        {
            if (i == 4)
            {
                if (mExitAnimatable.getAndSet(false))
                {
                    dismissWithAnimation();
                }
                return true;
            } else
            {
                return super.onKeyDown(i, keyevent);
            }
        }

        protected final void onStop()
        {
            if (mBtnClose != null)
            {
                mBtnClose.release();
            }
            super.onStop();
        }










        MarketingDialog(Context context, int i)
        {
            this$0 = InAppDialogFragment.this;
            super(context, i);
            if (mMarketingMessage == null)
            {
                dismiss();
                return;
            }
            mLocation = (String)mMarketingMessage.get("location");
            setupViews();
            createAnimations();
            adjustLayout();
            context = (String)mMarketingMessage.get("html_url");
            if (context != null)
            {
                mWebView.loadUrl(context);
                return;
            } else
            {
                class _cls1
                    implements Runnable
                {

                    final MarketingDialog this$1;
                    final InAppDialogFragment val$this$0;

                    public void run()
                    {
                        dismiss();
                    }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
                }

                (new Handler(Looper.getMainLooper())).post(new _cls1());
                return;
            }
        }
    }

    final class MarketingDialog.CloseButton extends View
    {

        private Bitmap mBitmap;
        private final float mCenterX;
        private final float mCenterY;
        private final float mInnerRadius;
        private final float mOffset;
        private final Paint mPaint = new Paint(1);
        private final float mRadius;
        private final Paint mShadowInnerPaint = new Paint(1);
        private final Paint mShadowOuterPaint = new Paint(1);
        private final float mStrokeWidth;
        final MarketingDialog this$1;

        protected final void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            float f2 = getResources().getDisplayMetrics().density;
            float f;
            Bitmap bitmap;
            if (InAppDialogFragment.sDismissButtonImage != null)
            {
                bitmap = InAppDialogFragment.sDismissButtonImage;
                f = (float)(bitmap.getHeight() - bitmap.getWidth()) / 2.0F;
            } else
            if (mBitmap != null)
            {
                float f1;
                if (InAppDialogFragment.dismissButtonLocation == Localytics.InAppMessageDismissButtonLocation.LEFT)
                {
                    f = 0.0F;
                    f1 = f2;
                } else
                {
                    f = 4F * f2;
                    f1 = 3F * f2;
                }
                canvas.drawCircle(mCenterX + f1, mCenterY + f2, mRadius - f2, mShadowInnerPaint);
                canvas.drawCircle(mCenterX + f1, mCenterY + f2, mRadius - f2, mShadowOuterPaint);
                bitmap = mBitmap;
            } else
            {
                return;
            }
            canvas.drawBitmap(bitmap, f, 0.0F, mPaint);
        }

        public final void release()
        {
            if (mBitmap != null)
            {
                mBitmap.recycle();
                mBitmap = null;
            }
        }

        MarketingDialog.CloseButton(Context context, AttributeSet attributeset)
        {
            this$1 = MarketingDialog.this;
            super(context, attributeset);
            setId(1);
            setContentDescription("close_button");
            if (DatapointHelper.getApiLevel() >= 14)
            {
                setLayerType(1, null);
            }
            float f1 = getResources().getDisplayMetrics().density;
            mCenterX = 13F * f1;
            mCenterY = 13F * f1;
            mRadius = 13F * f1;
            mOffset = 5F * f1;
            mStrokeWidth = 2.5F * f1;
            mInnerRadius = mRadius - mStrokeWidth * 0.5F;
            mShadowInnerPaint.setMaskFilter(new BlurMaskFilter(mRadius - f1, android.graphics.BlurMaskFilter.Blur.INNER));
            mShadowOuterPaint.setMaskFilter(new BlurMaskFilter(2.0F * f1, android.graphics.BlurMaskFilter.Blur.OUTER));
            float f;
            if (InAppDialogFragment.sDismissButtonImage == null)
            {
                f = 30F;
            } else
            {
                f = 40F;
            }
            f = f * f1 + 0.5F;
            setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f, (int)f));
            mBitmap = Bitmap.createBitmap((int)(26F * f1 + 0.5F), (int)(26F * f1 + 0.5F), android.graphics.Bitmap.Config.ARGB_8888);
            marketingdialog = new Canvas(mBitmap);
            mPaint.setColor(0xff000000);
            mPaint.setStyle(android.graphics.Paint.Style.FILL);
            drawCircle(mCenterX, mCenterY, mRadius, mPaint);
            mPaint.setColor(-1);
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setStrokeWidth(mStrokeWidth);
            drawCircle(mCenterX, mCenterY, mInnerRadius, mPaint);
            mPaint.setStrokeWidth(4.5F * f1);
            drawLine(mCenterX - mOffset, mCenterY - mOffset, mCenterX + mOffset, mCenterY + mOffset, mPaint);
            drawLine(mCenterX - mOffset, mCenterY + mOffset, mCenterX + mOffset, mCenterY - mOffset, mPaint);
        }
    }

    final class MarketingDialog.MarketingWebView extends WebView
    {

        final MarketingDialog this$1;

        MarketingDialog.MarketingWebView(Context context, AttributeSet attributeset)
        {
            this$1 = MarketingDialog.this;
            super(context, attributeset);
            if (DatapointHelper.getApiLevel() >= 19)
            {
                setLayerType(1, null);
            }
            context = new android.widget.LinearLayout.LayoutParams(-1, -1);
            context.gravity = 17;
            setLayoutParams(context);
            setBackgroundColor(0);
            setInitialScale(1);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            setWebViewClient(new MarketingWebViewClient(getActivity()));
            context = getSettings();
            context.setJavaScriptEnabled(true);
            addJavascriptInterface(mJavaScriptClient, "localytics");
            context.setUseWideViewPort(true);
        }
    }

    final class MarketingDialog.MarketingWebView.MarketingWebViewClient extends WebViewClient
    {

        private final Activity mActivity;
        final MarketingDialog.MarketingWebView this$2;

        public final void onPageFinished(WebView webview, String s)
        {
            int i;
            if (((String)mMarketingMessage.get("location")).equals("center"))
            {
                i = (int)(mMetrics.density * 10F + 0.5F) << 1;
            } else
            {
                i = 0;
            }
            int j = Math.min(mMetrics.widthPixels, mMetrics.heightPixels);
            int k = Math.max(mMetrics.widthPixels, mMetrics.heightPixels);
            webview.loadUrl(String.format("javascript:(function() {  var viewportNode = document.createElement('meta');  viewportNode.name    = 'viewport';  viewportNode.content = 'width=%f, height=%f, user-scalable=no, minimum-scale=.25, maximum-scale=1';  viewportNode.id      = 'metatag';  document.getElementsByTagName('head')[0].appendChild(viewportNode);})()", new Object[] {
                Float.valueOf((float)Math.min(j - i, (int)(mWidth * mMetrics.density + 0.5F)) / mMetrics.density), Float.valueOf((float)Math.min(k - i, (int)(mHeight * mMetrics.density + 0.5F)) / mMetrics.density)
            }));
            webview.loadUrl(mJavaScriptClient.getJsGlueCode());
            mRootLayout.setVisibility(0);
            if (mEnterAnimatable.getAndSet(false))
            {
                enterWithAnimation();
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            int i;
            Object obj = new URL(s);
            obj = handleFileProtocolRequest(((URL) (obj)));
            static class _cls3
            {

                static final int $SwitchMap$com$localytics$android$InAppDialogFragment$ProtocolHandleAction[];

                static 
                {
                    $SwitchMap$com$localytics$android$InAppDialogFragment$ProtocolHandleAction = new int[ProtocolHandleAction.values().length];
                    try
                    {
                        $SwitchMap$com$localytics$android$InAppDialogFragment$ProtocolHandleAction[ProtocolHandleAction.OPENING_INTERNAL.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                    try
                    {
                        $SwitchMap$com$localytics$android$InAppDialogFragment$ProtocolHandleAction[ProtocolHandleAction.PROTOCOL_UNMATCHED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                }
            }

            i = _cls3..SwitchMap.com.localytics.android.InAppDialogFragment.ProtocolHandleAction[((ProtocolHandleAction) (obj)).ordinal()];
            boolean flag;
            switch (i)
            {
            case 1: // '\001'
            case 2: // '\002'
                flag = false;
                break;

            default:
                flag = true;
                break;
            }
              goto _L1
_L3:
            flag = true;
_L1:
            if (flag)
            {
                return new WebResourceResponse("text/plain", "UTF-8", null);
            } else
            {
                return super.shouldInterceptRequest(webview, s);
            }
            MalformedURLException malformedurlexception;
            malformedurlexception;
            if (true) goto _L3; else goto _L2
_L2:
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            return handleUrl(s, mActivity) != ProtocolHandleAction.OPENING_INTERNAL;
        }

        MarketingDialog.MarketingWebView.MarketingWebViewClient(Activity activity)
        {
            this$2 = MarketingDialog.MarketingWebView.this;
            super();
            mActivity = activity;
        }
    }

    static final class ProtocolHandleAction extends Enum
    {

        private static final ProtocolHandleAction $VALUES[];
        public static final ProtocolHandleAction DO_NOT_OPEN;
        public static final ProtocolHandleAction OPENING_EXTERNAL;
        public static final ProtocolHandleAction OPENING_INTERNAL;
        public static final ProtocolHandleAction PROTOCOL_UNMATCHED;

        public static ProtocolHandleAction valueOf(String s)
        {
            return (ProtocolHandleAction)Enum.valueOf(com/localytics/android/InAppDialogFragment$ProtocolHandleAction, s);
        }

        public static ProtocolHandleAction[] values()
        {
            return (ProtocolHandleAction[])$VALUES.clone();
        }

        static 
        {
            PROTOCOL_UNMATCHED = new ProtocolHandleAction("PROTOCOL_UNMATCHED", 0);
            OPENING_INTERNAL = new ProtocolHandleAction("OPENING_INTERNAL", 1);
            OPENING_EXTERNAL = new ProtocolHandleAction("OPENING_EXTERNAL", 2);
            DO_NOT_OPEN = new ProtocolHandleAction("DO_NOT_OPEN", 3);
            $VALUES = (new ProtocolHandleAction[] {
                PROTOCOL_UNMATCHED, OPENING_INTERNAL, OPENING_EXTERNAL, DO_NOT_OPEN
            });
        }

        private ProtocolHandleAction(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String AMP_DESCRIPTION = "amp_view";
    private static final String CLOSE_BUTTON_DESCRIPTION = "close_button";
    private static final int CLOSE_BUTTON_ID = 1;
    static final String DIALOG_TAG = "marketing_dialog";
    private static final int WEB_VIEW_ID = 2;
    private static Localytics.InAppMessageDismissButtonLocation dismissButtonLocation;
    private static Bitmap sDismissButtonImage = null;
    private File mAllowableFileDir;
    private SparseArray mCallbacks;
    private final AtomicBoolean mEnterAnimatable = new AtomicBoolean(true);
    private final AtomicBoolean mExitAnimatable = new AtomicBoolean(true);
    private JavaScriptClient mJavaScriptClient;
    private MarketingDialog mMarketingDialog;
    private MarketingMessage mMarketingMessage;
    private final AtomicBoolean mUploadedViewEvent = new AtomicBoolean(false);

    public InAppDialogFragment()
    {
    }

    static Localytics.InAppMessageDismissButtonLocation getInAppDismissButtonLocation()
    {
        return dismissButtonLocation;
    }

    private String getValueByQueryKey(String s, URI uri)
    {
        String s1 = uri.getQuery();
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            return null;
        }
        uri = uri.getQuery().split("[&]");
        int j = uri.length;
        for (int i = 0; i < j; i++)
        {
            String as[] = uri[i].split("[=]");
            if (as[0].compareTo(s) == 0 && 2 == as.length)
            {
                try
                {
                    s = URLDecoder.decode(as[1], "UTF-8");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return null;
                }
                return s;
            }
        }

        return null;
    }

    private String getValueByQueryKey(String s, URL url)
    {
        try
        {
            s = getValueByQueryKey(s, url.toURI());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private ProtocolHandleAction handleCustomProtocolRequest(String s, Activity activity)
    {
        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
        if (mMarketingDialog.getContext().getPackageManager().queryIntentActivities(s, 0).size() > 0)
        {
            Localytics.Log.w("[In-app Nav Handler]: An app on this device is registered to handle this protocol scheme. Opening...");
            s.setFlags(0x20000);
            activity.startActivity(s);
            return ProtocolHandleAction.OPENING_EXTERNAL;
        } else
        {
            return ProtocolHandleAction.PROTOCOL_UNMATCHED;
        }
    }

    private ProtocolHandleAction handleCustomProtocolRequest(URL url, Activity activity)
    {
        return handleCustomProtocolRequest(url.toString(), activity);
    }

    private ProtocolHandleAction handleFileProtocolRequest(URL url)
    {
        if (!url.getProtocol().equals("file"))
        {
            return ProtocolHandleAction.PROTOCOL_UNMATCHED;
        }
        if ((TextUtils.isEmpty(url.getHost()) || url.getHost().equals("localhost")) && isPathWithinCreativeDir(url.getPath()))
        {
            return ProtocolHandleAction.OPENING_INTERNAL;
        } else
        {
            Localytics.Log.w("[In-app Nav Handler]: Displaying content from your local creatives.");
            return ProtocolHandleAction.DO_NOT_OPEN;
        }
    }

    private ProtocolHandleAction handleHttpProtocolRequest(URL url, Activity activity)
    {
        String s = url.getProtocol();
        if (!s.equals("http") && !s.equals("https"))
        {
            return ProtocolHandleAction.PROTOCOL_UNMATCHED;
        }
        Localytics.Log.w("[In-app Nav Handler]: Handling a request for an external HTTP address.");
        s = getValueByQueryKey("ampExternalOpen", url);
        if (!TextUtils.isEmpty(s) && s.toLowerCase(Locale.US).equals("true"))
        {
            Localytics.Log.w(String.format("[In-app Nav Handler]: Query string hook [%s] set to true. Opening the URL in chrome", new Object[] {
                "ampExternalOpen"
            }));
            url = new Intent("android.intent.action.VIEW", Uri.parse(url.toString()));
            if (mMarketingDialog.getContext().getPackageManager().queryIntentActivities(url, 0).size() > 0)
            {
                activity.startActivity(url);
                return ProtocolHandleAction.OPENING_EXTERNAL;
            }
        }
        Localytics.Log.w("[In-app Nav Handler]: Loading HTTP request inside the current in-app view");
        return ProtocolHandleAction.OPENING_INTERNAL;
    }

    private boolean isPathWithinCreativeDir(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            File file = new File(s);
            try
            {
                s = file.getCanonicalFile();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = file.getAbsoluteFile();
            }
            for (; s != null && s.exists(); s = s.getParentFile())
            {
                if (s.equals(mAllowableFileDir))
                {
                    return true;
                }
            }

        }
        return false;
    }

    static InAppDialogFragment newInstance()
    {
        InAppDialogFragment inappdialogfragment = new InAppDialogFragment();
        inappdialogfragment.setRetainInstance(true);
        return inappdialogfragment;
    }

    static void setDismissButtonImage(Bitmap bitmap)
    {
        if (sDismissButtonImage != null)
        {
            sDismissButtonImage.recycle();
        }
        sDismissButtonImage = bitmap;
    }

    static void setInAppDismissButtonLocation(Localytics.InAppMessageDismissButtonLocation inappmessagedismissbuttonlocation)
    {
        dismissButtonLocation = inappmessagedismissbuttonlocation;
    }

    private void tagMarketingActionEventWithAction(String s)
    {
        if (Constants.isTestModeEnabled())
        {
            return;
        }
        if (mUploadedViewEvent.getAndSet(true))
        {
            Localytics.Log.w(String.format("The in-app action for this message has already been set. Ignoring in-app Action: [%s]", new Object[] {
                s
            }));
            return;
        }
        Object obj = new TreeMap();
        ((TreeMap) (obj)).put("ampAction", s);
        ((TreeMap) (obj)).put("type", "In-App");
        ((TreeMap) (obj)).put("ampCampaignId", mMarketingMessage.get("campaign_id").toString());
        ((TreeMap) (obj)).put("ampCampaign", mMarketingMessage.get("rule_name_non_unique").toString());
        ((TreeMap) (obj)).put("Schema Version - Client", "3");
        s = ((String) (mMarketingMessage.get("schema_version")));
        if (s != null)
        {
            ((TreeMap) (obj)).put("Schema Version - Server", s.toString());
        }
        s = (String)mMarketingMessage.get("ab_test");
        if (!TextUtils.isEmpty(s))
        {
            ((TreeMap) (obj)).put("ampAB", s);
        }
        if (mCallbacks != null)
        {
            s = (InAppCallable)mCallbacks.get(2);
            if (s != null)
            {
                s.call(new Object[] {
                    "ampView", obj
                });
            }
            if (Constants.IS_LOGGING_ENABLED)
            {
                s = new StringBuilder();
                java.util.Map.Entry entry;
                for (obj = ((TreeMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); s.append("Key = ").append((String)entry.getKey()).append(", Value = ").append((String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                }

                Localytics.Log.v(String.format("In-app event tagged successfully.\n   Attributes Dictionary = \n%s", new Object[] {
                    s.toString()
                }));
            }
        }
    }

    private void tagMarketingActionForURL(URI uri)
    {
        String s = getValueByQueryKey("ampAction", uri);
        if (!TextUtils.isEmpty(s))
        {
            Localytics.Log.w(String.format("Attempting to tag event with custom in-app action. [Action: %s]", new Object[] {
                s
            }));
            tagMarketingActionEventWithAction(s);
            return;
        }
        uri = uri.getScheme();
        if (!uri.equals("file") && !uri.equals("http") && !uri.equals("https"))
        {
            tagMarketingActionEventWithAction("click");
        }
    }

    final void dismissCampaign()
    {
        if (mMarketingDialog != null)
        {
            if (mMarketingMessage != null)
            {
                tagMarketingActionEventWithAction("X");
            }
            mMarketingDialog.dismiss();
        }
    }

    final ProtocolHandleAction handleUrl(String s, Activity activity)
    {
        Object obj;
        ProtocolHandleAction protocolhandleaction;
        Object obj1;
        String s1;
        String s2;
        ProtocolHandleAction protocolhandleaction1;
        obj1 = s;
        Localytics.Log.w(String.format("[In-app Nav Handler]: Evaluating in-app URL:\n\tURL:%s", new Object[] {
            obj1
        }));
        protocolhandleaction1 = ProtocolHandleAction.PROTOCOL_UNMATCHED;
        s1 = ((String) (obj1));
        obj = protocolhandleaction1;
        s2 = ((String) (obj1));
        protocolhandleaction = protocolhandleaction1;
        if (!((String) (obj1)).endsWith("://"))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        obj = protocolhandleaction1;
        s2 = ((String) (obj1));
        protocolhandleaction = protocolhandleaction1;
        s1 = ((String) (obj1)).substring(0, ((String) (obj1)).length() - 1);
        obj = protocolhandleaction1;
        s2 = s1;
        protocolhandleaction = protocolhandleaction1;
        tagMarketingActionForURL(new URI(s1));
        obj = protocolhandleaction1;
        s2 = s1;
        protocolhandleaction = protocolhandleaction1;
        URL url = new URL(s1);
        obj = protocolhandleaction1;
        s2 = s1;
        protocolhandleaction = protocolhandleaction1;
        protocolhandleaction1 = handleFileProtocolRequest(url);
        obj1 = protocolhandleaction1;
        obj = obj1;
        s2 = s1;
        protocolhandleaction = ((ProtocolHandleAction) (obj1));
        ProtocolHandleAction protocolhandleaction2 = ProtocolHandleAction.PROTOCOL_UNMATCHED;
        if (protocolhandleaction1 != protocolhandleaction2)
        {
            if (obj1 == ProtocolHandleAction.OPENING_EXTERNAL)
            {
                mMarketingDialog.dismissWithAnimation();
            }
            return ((ProtocolHandleAction) (obj1));
        }
        obj = obj1;
        s2 = s1;
        protocolhandleaction = ((ProtocolHandleAction) (obj1));
        protocolhandleaction1 = handleHttpProtocolRequest(url, activity);
        obj1 = protocolhandleaction1;
        obj = obj1;
        s2 = s1;
        protocolhandleaction = ((ProtocolHandleAction) (obj1));
        protocolhandleaction2 = ProtocolHandleAction.PROTOCOL_UNMATCHED;
        if (protocolhandleaction1 != protocolhandleaction2)
        {
            if (obj1 == ProtocolHandleAction.OPENING_EXTERNAL)
            {
                mMarketingDialog.dismissWithAnimation();
            }
            return ((ProtocolHandleAction) (obj1));
        }
        obj = obj1;
        s2 = s1;
        protocolhandleaction = ((ProtocolHandleAction) (obj1));
        protocolhandleaction1 = handleCustomProtocolRequest(url, activity);
        obj1 = protocolhandleaction1;
        obj = obj1;
        s2 = s1;
        protocolhandleaction = ((ProtocolHandleAction) (obj1));
        protocolhandleaction2 = ProtocolHandleAction.PROTOCOL_UNMATCHED;
        if (protocolhandleaction1 != protocolhandleaction2)
        {
            if (obj1 == ProtocolHandleAction.OPENING_EXTERNAL)
            {
                mMarketingDialog.dismissWithAnimation();
            }
            return ((ProtocolHandleAction) (obj1));
        }
        obj = obj1;
        s2 = s1;
        protocolhandleaction = ((ProtocolHandleAction) (obj1));
        Localytics.Log.w(String.format("[In-app Nav Handler]: Protocol handler scheme not recognized. Attempting to load the URL... [Scheme: %s]", new Object[] {
            url.getProtocol()
        }));
        s = ((String) (obj1));
        if (obj1 == ProtocolHandleAction.OPENING_EXTERNAL)
        {
            mMarketingDialog.dismissWithAnimation();
            return ((ProtocolHandleAction) (obj1));
        }
          goto _L1
_L3:
        obj = protocolhandleaction;
        protocolhandleaction = handleCustomProtocolRequest(s2, activity);
        activity = protocolhandleaction;
        obj = activity;
        obj1 = ProtocolHandleAction.PROTOCOL_UNMATCHED;
        if (protocolhandleaction != obj1)
        {
            if (activity == ProtocolHandleAction.OPENING_EXTERNAL)
            {
                mMarketingDialog.dismissWithAnimation();
            }
            return activity;
        }
        obj = activity;
        Localytics.Log.w(String.format("[In-app Nav Handler]: Invalid url %s", new Object[] {
            s
        }));
        obj = activity;
        mMarketingDialog.dismissWithAnimation();
        s = activity;
        if (activity == ProtocolHandleAction.OPENING_EXTERNAL)
        {
            mMarketingDialog.dismissWithAnimation();
            return activity;
        }
          goto _L1
        s;
        if (obj == ProtocolHandleAction.OPENING_EXTERNAL)
        {
            mMarketingDialog.dismissWithAnimation();
        }
        throw s;
_L1:
        return s;
        Exception exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void onActivityCreated(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public final void onAttach(Activity activity)
    {
        Localytics.Log.v("[InAppDialogFragment]: onAttach");
        super.onAttach(activity);
    }

    public final void onCreate(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onCreate");
        super.onCreate(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onCreateDialog");
        bundle = new MarketingDialog(getActivity(), 0x103000b);
        mMarketingDialog = bundle;
        return bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onCreateView");
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public final void onDestroy()
    {
        Localytics.Log.v("[InAppDialogFragment]: onDestroy");
        if (mCallbacks != null)
        {
            InAppCallable inappcallable = (InAppCallable)mCallbacks.get(1);
            if (!Constants.isTestModeEnabled() && inappcallable != null)
            {
                inappcallable.call(new Object[] {
                    mMarketingMessage
                });
            }
        }
        super.onDestroy();
    }

    public final void onDestroyView()
    {
        Localytics.Log.v("[InAppDialogFragment]: onDestroyView");
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    public final void onDetach()
    {
        Localytics.Log.v("[InAppDialogFragment]: onDetach");
        super.onDetach();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        Localytics.Log.v("[InAppDialogFragment]: onDismiss");
        try
        {
            if (mMarketingMessage != null)
            {
                tagMarketingActionEventWithAction("X");
            }
        }
        catch (Exception exception)
        {
            Localytics.Log.e("MarketingDialogFragment onDismiss", exception);
        }
        super.onDismiss(dialoginterface);
    }

    public final void onPause()
    {
        Localytics.Log.v("[InAppDialogFragment]: onPause");
        super.onPause();
    }

    public final void onResume()
    {
        Localytics.Log.v("[InAppDialogFragment]: onResume");
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    public final void onStart()
    {
        Localytics.Log.v("[InAppDialogFragment]: onStart");
        super.onStart();
    }

    public final void onStop()
    {
        Localytics.Log.v("[InAppDialogFragment]: onStop");
        super.onStop();
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onViewStateRestored");
        super.onViewStateRestored(bundle);
    }

    public final InAppDialogFragment setCallbacks(SparseArray sparsearray)
    {
        mCallbacks = sparsearray;
        return this;
    }

    final InAppDialogFragment setData(MarketingMessage marketingmessage)
    {
        IOException ioexception;
        mMarketingMessage = marketingmessage;
        marketingmessage = new File((String)marketingmessage.get("base_path"));
        try
        {
            mAllowableFileDir = marketingmessage.getCanonicalFile();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            mAllowableFileDir = marketingmessage.getAbsoluteFile();
            return this;
        }
        return this;
    }

    final InAppDialogFragment setJavaScriptClient(JavaScriptClient javascriptclient)
    {
        mJavaScriptClient = javascriptclient;
        javascriptclient = mJavaScriptClient.getCallbacks();
        javascriptclient.put(15, new _cls1());
        javascriptclient.put(4, new _cls2());
        return this;
    }

    static 
    {
        dismissButtonLocation = Localytics.InAppMessageDismissButtonLocation.LEFT;
    }










    private class _cls1 extends InAppCallable
    {

        final InAppDialogFragment this$0;

        Object call(final Object url[])
        {
            url = (String)url[0];
            final MarketingDialog.MarketingWebView mWebView = mMarketingDialog.mWebView;
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final MarketingDialog.MarketingWebView val$mWebView;
                final String val$url;

                public void run()
                {
                    mWebView.loadUrl(url);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    mWebView = marketingwebview;
                    url = s;
                    super();
                }
            }

            if (handleUrl(((String) (url)), getActivity()) == ProtocolHandleAction.OPENING_EXTERNAL)
            {
                (new Handler(Looper.getMainLooper())).post(new _cls1());
            }
            return null;
        }

        _cls1()
        {
            this$0 = InAppDialogFragment.this;
            super();
        }
    }


    private class _cls2 extends InAppCallable
    {

        final InAppDialogFragment this$0;

        Object call(Object aobj[])
        {
            mMarketingDialog.dismissWithAnimation();
            return null;
        }

        _cls2()
        {
            this$0 = InAppDialogFragment.this;
            super();
        }
    }

}
