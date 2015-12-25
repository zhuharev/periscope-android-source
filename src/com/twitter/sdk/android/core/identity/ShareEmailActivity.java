// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.TextView;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            ShareEmailController, ShareEmailClient

public class ShareEmailActivity extends Activity
{

    static final String EXTRA_RESULT_RECEIVER = "result_receiver";
    static final String EXTRA_SESSION_ID = "session_id";
    ShareEmailController controller;
    private TwitterSession session;

    public ShareEmailActivity()
    {
    }

    private ResultReceiver getResultReceiver(Intent intent)
    {
        intent = (ResultReceiver)intent.getParcelableExtra("result_receiver");
        if (intent == null)
        {
            throw new IllegalArgumentException("ResultReceiver must not be null. This activity should not be started directly.");
        } else
        {
            return intent;
        }
    }

    private TwitterSession getSession(Intent intent)
    {
        long l = intent.getLongExtra("session_id", -1L);
        intent = (TwitterSession)TwitterCore.getInstance().getSessionManager().getSession(l);
        if (intent == null)
        {
            throw new IllegalArgumentException((new StringBuilder("No TwitterSession for id:")).append(l).toString());
        } else
        {
            return intent;
        }
    }

    public void onBackPressed()
    {
        controller.cancelRequest();
        super.onBackPressed();
    }

    public void onClickAllow(View view)
    {
        controller.executeRequest();
        finish();
    }

    public void onClickNotNow(View view)
    {
        controller.cancelRequest();
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.twitter.sdk.android.core.R.layout.tw__activity_share_email);
        try
        {
            bundle = getIntent();
            ResultReceiver resultreceiver = getResultReceiver(bundle);
            session = getSession(bundle);
            controller = new ShareEmailController(new ShareEmailClient(session), resultreceiver);
            setUpShareEmailDesc(this, (TextView)findViewById(com.twitter.sdk.android.core.R.id.tw__share_email_desc));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to create ShareEmailActivity.", bundle);
        }
        finish();
    }

    void setUpShareEmailDesc(Context context, TextView textview)
    {
        PackageManager packagemanager = context.getPackageManager();
        textview.setText(getResources().getString(com.twitter.sdk.android.core.R.string.tw__share_email_desc, new Object[] {
            packagemanager.getApplicationLabel(context.getApplicationInfo()), session.getUserName()
        }));
    }
}
