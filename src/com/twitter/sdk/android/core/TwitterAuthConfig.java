// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import java.net.HttpURLConnection;
import java.util.Map;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterAuthToken

public class TwitterAuthConfig
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final int DEFAULT_AUTH_REQUEST_CODE = 140;
    private final String consumerKey;
    private final String consumerSecret;

    private TwitterAuthConfig(Parcel parcel)
    {
        consumerKey = parcel.readString();
        consumerSecret = parcel.readString();
    }

    TwitterAuthConfig(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public TwitterAuthConfig(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
        } else
        {
            consumerKey = sanitizeAttribute(s);
            consumerSecret = sanitizeAttribute(s1);
            return;
        }
    }

    static String sanitizeAttribute(String s)
    {
        if (s != null)
        {
            return s.trim();
        } else
        {
            return null;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getConsumerKey()
    {
        return consumerKey;
    }

    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    public int getRequestCode()
    {
        return 140;
    }

    public void signRequest(TwitterAuthToken twitterauthtoken, HttpURLConnection httpurlconnection)
    {
        OAuth1aService.signRequest(this, twitterauthtoken, httpurlconnection, null);
    }

    public void signRequest(TwitterAuthToken twitterauthtoken, HttpURLConnection httpurlconnection, Map map)
    {
        OAuth1aService.signRequest(this, twitterauthtoken, httpurlconnection, map);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(consumerKey);
        parcel.writeString(consumerSecret);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final TwitterAuthConfig createFromParcel(Parcel parcel)
        {
            return new TwitterAuthConfig(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final TwitterAuthConfig[] newArray(int i)
        {
            return new TwitterAuthConfig[i];
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
