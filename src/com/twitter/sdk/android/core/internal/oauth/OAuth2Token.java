// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.AuthToken;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuth2Service

public class OAuth2Token extends AuthToken
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final String TOKEN_TYPE_BEARER = "bearer";
    private final String accessToken;
    private final String tokenType;

    private OAuth2Token(Parcel parcel)
    {
        tokenType = parcel.readString();
        accessToken = parcel.readString();
    }

    OAuth2Token(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public OAuth2Token(String s, String s1)
    {
        tokenType = s;
        accessToken = s1;
    }

    public OAuth2Token(String s, String s1, long l)
    {
        super(l);
        tokenType = s;
        accessToken = s1;
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
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (OAuth2Token)obj;
        if (accessToken == null ? ((OAuth2Token) (obj)).accessToken != null : !accessToken.equals(((OAuth2Token) (obj)).accessToken))
        {
            return false;
        }
        return tokenType == null ? ((OAuth2Token) (obj)).tokenType == null : tokenType.equals(((OAuth2Token) (obj)).tokenType);
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public Map getAuthHeaders(TwitterAuthConfig twitterauthconfig, String s, String s1, Map map)
    {
        twitterauthconfig = new HashMap();
        twitterauthconfig.put("Authorization", OAuth2Service.getAuthorizationHeader(this));
        return twitterauthconfig;
    }

    public String getTokenType()
    {
        return tokenType;
    }

    public int hashCode()
    {
        int i;
        if (tokenType != null)
        {
            i = tokenType.hashCode();
        } else
        {
            i = 0;
        }
        int j;
        if (accessToken != null)
        {
            j = accessToken.hashCode();
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

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(tokenType);
        parcel.writeString(accessToken);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final OAuth2Token createFromParcel(Parcel parcel)
        {
            return new OAuth2Token(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final OAuth2Token[] newArray(int i)
        {
            return new OAuth2Token[i];
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
