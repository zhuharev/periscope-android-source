// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            InAppDialogFragment, MarketingMessage, DatapointHelper, JavaScriptClient

final class _cls1 extends Dialog
{
    final class CloseButton extends View
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
        final InAppDialogFragment.MarketingDialog this$1;

        protected final void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            float f2 = getResources().getDisplayMetrics().density;
            float f;
            Bitmap bitmap;
            if (InAppDialogFragment.access$1700() != null)
            {
                bitmap = InAppDialogFragment.access$1700();
                f = (float)(bitmap.getHeight() - bitmap.getWidth()) / 2.0F;
            } else
            if (mBitmap != null)
            {
                float f1;
                if (InAppDialogFragment.access$400() == Localytics.InAppMessageDismissButtonLocation.LEFT)
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

        CloseButton(Context context, AttributeSet attributeset)
        {
            this$1 = InAppDialogFragment.MarketingDialog.this;
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
            if (InAppDialogFragment.access$1700() == null)
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

    final class MarketingWebView extends WebView
    {

        final InAppDialogFragment.MarketingDialog this$1;

        MarketingWebView(Context context, AttributeSet attributeset)
        {
            this$1 = InAppDialogFragment.MarketingDialog.this;
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
            addJavascriptInterface(InAppDialogFragment.access$1100(this$0), "localytics");
            context.setUseWideViewPort(true);
        }
    }

    final class MarketingWebView.MarketingWebViewClient extends WebViewClient
    {

        private final Activity mActivity;
        final MarketingWebView this$2;

        public final void onPageFinished(WebView webview, String s)
        {
            int i;
            if (((String)InAppDialogFragment.access$200(this$0).get("location")).equals("center"))
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
            webview.loadUrl(InAppDialogFragment.access$1100(this$0).getJsGlueCode());
            mRootLayout.setVisibility(0);
            if (InAppDialogFragment.access$1500(this$0).getAndSet(false))
            {
                enterWithAnimation();
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webview, String s)
        {
            int i;
            Object obj = new URL(s);
            obj = InAppDialogFragment.access$1600(this$0, ((URL) (obj)));
            i = InAppDialogFragment._cls3.$Swi