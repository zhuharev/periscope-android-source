// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;

public class PushNotificationOptions
{
    public static class Builder
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
            return new PushNotificationOptions(this);
        }

        public Builder setAccentColor(int i)
        {
            mAccentColor = i;
            return this;
        }

        public Builder setCategory(String s)
        {
            mCategory = s;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap)
        {
            if (mLargeIcon != null)
            {
                mLargeIcon.recycle();
            }
            mLargeIcon = bitmap;
            return this;
        }

        public Builder setLaunchIntent(Intent intent)
        {
            mLaunchIntent = intent;
            return this;
        }

        public Builder setLedLight(int i, int j, int k)
        {
            mLedLightColor = i;
            mLedLightOnMillis = j;
            mLedLightOffMillis = k;
            return this;
        }

        public Builder setOnlyAlertOnce(boolean flag)
        {
            mOnlyAlertOnce = flag;
            return this;
        }

        public Builder setPriority(int i)
        {
            mPriority = i;
            return this;
        }

        public Builder setSmallIcon(int i)
        {
            mSmallIcon = i;
            return this;
        }

        public Builder setSound(Uri uri)
        {
            mSoundUri = uri;
            return this;
        }

        public Builder setTitle(CharSequence charsequence)
        {
            if (!TextUtils.isEmpty(charsequence))
            {
                mTitle = charsequence;
            }
            return this;
        }

        public Builder setVibrationPattern(long al[])
        {
            mVibrationPattern = al;
            return this;
        }

        public Builder setVisibility(int i)
        {
            mVisibility = i;
            return this;
        }















        public Builder()
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


    private final int mAccentColor;
    private final String mCategory;
    private final Bitmap mLargeIcon;
    private final Intent mLaunchIntent;
    private final int mLedLightColor;
    private final int mLedLightOffMillis;
    private final int mLedLightOnMillis;
    private final boolean mOnlyAlertOnce;
    private final int mPriority;
    private final int mSmallIcon;
    private final Uri mSoundUri;
    private final CharSequence mTitle;
    private final long mVibrationPattern[];
    private final int mVisibility;

    private PushNotificationOptions(Builder builder)
    {
        mAccentColor = builder.mAccentColor;
        mCategory = builder.mCategory;
        mSoundUri = builder.mSoundUri;
        mVisibility = builder.mVisibility;
        mPriority = builder.mPriority;
        mSmallIcon = builder.mSmallIcon;
        mLargeIcon = builder.mLargeIcon;
        mLedLightColor = builder.mLedLightColor;
        mLedLightOnMillis = builder.mLedLightOnMillis;
        mLedLightOffMillis = builder.mLedLightOffMillis;
        mVibrationPattern = builder.mVibrationPattern;
        mOnlyAlertOnce = builder.mOnlyAlertOnce;
        mLaunchIntent = builder.mLaunchIntent;
        mTitle = builder.mTitle;
    }


    public int getAccentColor()
    {
        return mAccentColor;
    }

    public String getCategory()
    {
        return mCategory;
    }

    public Bitmap getLargeIcon()
    {
        return mLargeIcon;
    }

    public Intent getLaunchIntent()
    {
        return mLaunchIntent;
    }

    public int getLedLightColor()
    {
        return mLedLightColor;
    }

    public int getLedLightOffMillis()
    {
        return mLedLightOffMillis;
    }

    public int getLedLightOnMillis()
    {
        return mLedLightOnMillis;
    }

    public boolean getOnlyAlertOnce()
    {
        return mOnlyAlertOnce;
    }

    public int getPriority()
    {
        return mPriority;
    }

    public int getSmallIcon()
    {
        return mSmallIcon;
    }

    public Uri getSoundUri()
    {
        return mSoundUri;
    }

    public CharSequence getTitle()
    {
        return mTitle;
    }

    public long[] getVibrationPattern()
    {
        return mVibrationPattern;
    }

    public int getVisibility()
    {
        return mVisibility;
    }
}
