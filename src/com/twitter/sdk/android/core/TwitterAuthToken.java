// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.twitter.sdk.android.core:
//            AuthToken, TwitterAuthConfig

public class TwitterAuthToken extends AuthToken
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public final String secret;
    public final String token;

    private TwitterAuthToken(Parcel parcel)
    {
        token = parcel.readString();
        secret = parcel.readString();
    }

    TwitterAuthToken(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public TwitterAuthToken(String s, String s1)
    {
        token = s;
        secret = s1;
    }

    TwitterAuthToken(String s, String s1, long l)
    {
        super(l);
        token = s;
        secret = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof TwitterAuthToken))
        {
            return false;
        }
        obj = (TwitterAuthToken)obj;
        if (secret == null ? ((TwitterAuthToken) (obj)).secret != null : !secret.equals(((TwitterAuthToken) (obj)).secret))
        {
            return false;
        }
        return token == null ? ((TwitterAuthToken) (obj)).token == null : token.equals(((TwitterAuthToken) (obj)).token);
    }

    public Map getAuthHeaders(TwitterAuthConfig twitterauthconfig, String s, String s1, Map map)
    {
        HashMap hashmap = new HashMap(1);
        hashmap.put("Authorization", (new OAuth1aHeaders()).getAuthorizationHeader(twitterauthconfig, this, null, s, s1, map));
        return hashmap;
    }

    public int hashCode()
    {
        int i;
        if (token != null)
        {
            i = token.hashCode();
        } else
        {
            i = 0;
        }
        int j;
        if (secret != null)
        {
            j = secret.hashCode();
        } else
        {
            j = 0;
        }
        return i * 31 + j;
    }

    public boolean isExpired()
    {
        return false;
    }

    public String toString()
    {
        return (new StringBuilder("token=")).append(token).append(",secret=").append(secret).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(token);
        parcel.writeString(secret);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final TwitterAuthToken createFromParcel(Parcel parcel)
        {
            return new TwitterAuthToken(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final TwitterAuthToken[] newArray(int i)
        {
            return new TwitterAuthToken[i];
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
