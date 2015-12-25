// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;

// Referenced classes of package com.localytics.android:
//            PushNotificationOptions

public static class mTitle
{

    private int mAccentColor;
    private String mCategory;
    private Bitmap mLargeIcon;
    private Intent mLaunchIntent;
    private int mLedLightColor;
    private int mLedLightOffMillis;
    private int mLedLightOnMillis;
    private boolean mOnlyAlertOnce;
    private int mPriority;
    private int mSmallIcon;
    private Uri mSoundUri;
    private CharSequence mTitle;
    private long mVibrationPattern[];
    private int mVisibility;

    public PushNotificationOptions build()
    {
        return new PushNotificationOptions(this, null);
    }

    public mTitle setAccentColor(int i)
    {
        mAccentColor = i;
        return this;
    }

    public mAccentColor setCategory(String s)
    {
        mCategory = s;
        return this;
    }

    public mCategory setLargeIcon(Bitmap bitmap)
    {
        if (mLargeIcon != null)
        {
            mLargeIcon.recycle();
        }
        mLargeIcon = bitmap;
        return this;
    }

    public mLargeIcon setLaunchIntent(Intent intent)
    {
        mLaunchIntent = intent;
        return this;
    }

    public mLaunchIntent setLedLight(int i, int j, int k)
    {
        mLedLightColor = i;
        mLedLightOnMillis = j;
        mLedLightOffMillis = k;
        return this;
    }

    public mLedLightOffMillis setOnlyAlertOnce(boolean flag)
    {
        mOnlyAlertOnce = flag;
        return this;
    }

    public mOnlyAlertOnce setPriority(int i)
    {
        mPriority = i;
        return this;
    }

    public mPriority setSmallIcon(int i)
    {
        mSmallIcon = i;
        return this;
    }

    public mSmallIcon setSound(Uri uri)
    {
        mSoundUri = uri;
        return this;
    }

    public mSoundUri setTitle(CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            mTitle = charsequence;
        }
        return this;
    }

    public mTitle setVibrationPattern(long al[])
    {
        mVibrationPattern = al;
        return this;
    }

    public mVibrationPattern setVisibility(int i)
    {
        mVisibility = i;
        return this;
    }















    public ()
    {
        mAccentColor = 0;
        mCategory = null;
        mSoundUri = null;
        mVisibility = 0;
        mPriority = 0;
        mSmallIcon = -1;
        mLargeIcon = null;
        mLedLightColor = -1;
        mLedLightOnMillis = 0;
        mLedLightOffMillis = 0;
        mVibrationPattern = null;
        mOnlyAlertOnce = false;
        mLaunchIntent = null;
        mTitle = null;
    }
}
