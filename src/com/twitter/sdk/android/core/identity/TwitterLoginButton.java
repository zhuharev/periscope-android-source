// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterCore;
import java.lang.ref.WeakReference;
import o.ra;
import o.rl;
import o.rz;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            TwitterAuthClient

public class TwitterLoginButton extends Button
{
    class LoginClickListener
        implements android.view.View.OnClickListener
    {

        final TwitterLoginButton this$0;

        private void checkActivity(Activity activity)
        {
            if (activity == null || activity.isFinishing())
            {
                rz._mth02C8("Twitter", "TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.");
            }
        }

        private void checkCallback(Callback callback1)
        {
            if (callback1 == null)
            {
                rz._mth02C8("Twitter", "Callback must not be null, did you call setCallback?");
            }
        }

        public void onClick(View view)
        {
            checkCallback(callback);
            checkActivity((Activity)activityRef.get());
            getTwitterAuthClient().authorize((Activity)activityRef.get(), callback);
            if (onClickListener != null)
            {
                onClickListener.onClick(view);
            }
        }

        private LoginClickListener()
        {
            this$0 = TwitterLoginButton.this;
            super();
        }

    }


    static final String ERROR_MSG_NO_ACTIVITY = "TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.";
    static final String TAG = "Twitter";
    final WeakReference activityRef;
    volatile TwitterAuthClient authClient;
    Callback callback;
    android.view.View.OnClickListener onClickListener;

    public TwitterLoginButton(Context context)
    {
        this(context, null);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010048);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeset, int i)
    {
        this(context, attributeset, i, null);
    }

    TwitterLoginButton(Context context, AttributeSet attributeset, int i, TwitterAuthClient twitterauthclient)
    {
        super(context, attributeset, i);
        activityRef = new WeakReference(getActivity());
        authClient = twitterauthclient;
        setupButton();
        checkTwitterCoreAndEnable();
    }

    private void checkTwitterCoreAndEnable()
    {
        if (isInEditMode())
        {
            return;
        }
        try
        {
            TwitterCore.getInstance();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            ra._mth0454()._mth02CA("Twitter", illegalstateexception.getMessage());
        }
        setEnabled(false);
    }

    private void setupButton()
    {
        Resources resources = getResources();
        super.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(com.twitter.sdk.android.core.R.drawable.tw__ic_logo_default), null, null, null);
        super.setCompoundDrawablePadding(resources.getDimensionPixelSize(com.twitter.sdk.android.core.R.dimen.tw__login_btn_drawable_padding));
        super.setText(com.twitter.sdk.android.core.R.string.tw__login_btn_txt);
        super.setTextColor(resources.getColor(com.twitter.sdk.android.core.R.color.tw__solid_white));
        super.setTextSize(0, resources.getDimensionPixelSize(com.twitter.sdk.android.core.R.dimen.tw__login_btn_text_size));
        super.setTypeface(Typeface.DEFAULT_BOLD);
        super.setPadding(resources.getDimensionPixelSize(com.twitter.sdk.android.core.R.dimen.tw__login_btn_left_padding), 0, resources.getDimensionPixelSize(com.twitter.sdk.android.core.R.dimen.tw__login_btn_right_padding), 0);
        super.setBackgroundResource(com.twitter.sdk.android.core.R.drawable.tw__login_btn);
        super.setOnClickListener(new LoginClickListener());
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            super.setAllCaps(false);
        }
    }

    protected Activity getActivity()
    {
        if (getContext() instanceof Activity)
        {
            return (Activity)getContext();
        }
        if (isInEditMode())
        {
            return null;
        } else
        {
            throw new IllegalStateException("TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.");
        }
    }

    public Callback getCallback()
    {
        return callback;
    }

    TwitterAuthClient getTwitterAuthClient()
    {
        if (authClient != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        com/twitter/sdk/android/core/identity/TwitterLoginButton;
        JVM INSTR monitorenter ;
        if (authClient == null)
        {
            authClient = new TwitterAuthClient();
        }
        com/twitter/sdk/android/core/identity/TwitterLoginButton;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_40;
        Exception exception;
        exception;
        throw exception;
        return authClient;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == getTwitterAuthClient().getRequestCode())
        {
            getTwitterAuthClient().onActivityResult(i, j, intent);
        }
    }

    public void setCallback(Callback callback1)
    {
        if (callback1 == null)
        {
            throw new IllegalArgumentException("Callback cannot be null");
        } else
        {
            callback = callback1;
            return;
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onClickListener = onclicklistener;
    }
}
