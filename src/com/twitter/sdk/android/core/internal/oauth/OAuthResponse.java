// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.TwitterAuthToken;

public class OAuthResponse
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public final TwitterAuthToken authToken;
    public final long userId;
    public final String userName;

    private OAuthResponse(Parcel parcel)
    {
        authToken = (TwitterAuthToken)parcel.readParcelable(com/twitter/sdk/android/core/TwitterAuthToken.getClassLoader());
        userName = parcel.readString();
        userId = parcel.readLong();
    }

    OAuthResponse(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public OAuthResponse(TwitterAuthToken twitterauthtoken, String s, long l)
    {
        authToken = twitterauthtoken;
        userName = s;
        userId = l;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder("authToken=")).append(authToken).append(",userName=").append(userName).append(",userId=").append(userId).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(authToken, i);
        parcel.writeString(userName);
        parcel.writeLong(userId);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final OAuthResponse createFromParcel(Parcel parcel)
        {
            return new OAuthResponse(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final OAuthResponse[] newArray(int i)
        {
            return new OAuthResponse[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
