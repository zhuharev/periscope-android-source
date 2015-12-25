// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.text.TextUtils;
import com.twitter.sdk.android.core.AuthToken;
import com.twitter.sdk.android.core.AuthTokenAdapter;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import o.ig;
import o.im;
import o.is;
import o.ki;
import o.ra;
import o.rl;
import o.ur;
import retrofit.client.Header;
import retrofit.client.Response;

// Referenced classes of package com.digits.sdk.android:
//            DigitsSessionResponse, VerifyAccountResponse, DigitsUser

public class DigitsSession extends Session
{
    public static class Serializer
        implements ur
    {

        private static final String TAG = "Digits";
        private final ig gson = (new im())._mth02CA(com/twitter/sdk/android/core/AuthToken, new AuthTokenAdapter())._mth0490();

        public DigitsSession deserialize(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                break MISSING_BLOCK_LABEL_91;
            }
            ig ig1 = gson;
            if (s == null)
            {
                s = null;
                break MISSING_BLOCK_LABEL_36;
            }
            s = ((String) (ig1._mth02CA(new StringReader(s), com/digits/sdk/android/DigitsSession)));
            s = (DigitsSession)ki._mth02BC(com/digits/sdk/android/DigitsSession).cast(s);
            if (((DigitsSession) (s)).phoneNumber != null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            s = new DigitsSession(s.getAuthToken(), s.getId(), "");
            return s;
            return s;
            s;
            ra._mth0454()._mth02BE("Digits", s.getMessage());
            return null;
        }

        public volatile Object deserialize(String s)
        {
            return deserialize(s);
        }

        public String serialize(DigitsSession digitssession)
        {
            if (digitssession == null || digitssession.getAuthToken() == null)
            {
                break MISSING_BLOCK_LABEL_53;
            }
            ig ig1 = gson;
            if (digitssession != null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            return ig1._mth02CA(is.GB);
            digitssession = ig1._mth02CA(digitssession, digitssession.getClass());
            return digitssession;
            digitssession;
            ra._mth0454()._mth02BE("Digits", digitssession.getMessage());
            return "";
        }

        public volatile String serialize(Object obj)
        {
            return serialize((DigitsSession)obj);
        }

        public Serializer()
        {
        }
    }


    public static final String DEFAULT_PHONE_NUMBER = "";
    public static final long LOGGED_OUT_USER_ID = 0L;
    static final String SECRET_HEADER = "x-twitter-new-account-oauth-secret";
    static final String TOKEN_HEADER = "x-twitter-new-account-oauth-access-token";
    public static final long UNKNOWN_USER_ID = -1L;
    private final String phoneNumber;

    public DigitsSession(AuthToken authtoken, long l)
    {
        this(authtoken, l, "");
    }

    public DigitsSession(AuthToken authtoken, long l, String s)
    {
        super(authtoken, l);
        phoneNumber = s;
    }

    public DigitsSession(OAuth2Token oauth2token)
    {
        this(((AuthToken) (oauth2token)), 0L, "");
    }

    static DigitsSession create(DigitsSessionResponse digitssessionresponse, String s)
    {
        if (digitssessionresponse == null)
        {
            throw new NullPointerException("result must not be null");
        }
        if (s == null)
        {
            throw new NullPointerException("phoneNumber must not be null");
        } else
        {
            return new DigitsSession(new TwitterAuthToken(digitssessionresponse.token, digitssessionresponse.secret), digitssessionresponse.userId, s);
        }
    }

    public static DigitsSession create(VerifyAccountResponse verifyaccountresponse)
    {
        if (verifyaccountresponse == null)
        {
            throw new NullPointerException("verifyAccountResponse must not be null");
        } else
        {
            return new DigitsSession(verifyaccountresponse.token, verifyaccountresponse.userId, verifyaccountresponse.phoneNumber);
        }
    }

    static DigitsSession create(Result result, String s)
    {
        if (result == null)
        {
            throw new NullPointerException("result must not be null");
        }
        if (result.data == null)
        {
            throw new NullPointerException("result.data must not be null");
        }
        if (result.response == null)
        {
            throw new NullPointerException("result.response must not be null");
        }
        if (s == null)
        {
            throw new NullPointerException("phoneNumber must not be null");
        }
        List list = result.response.getHeaders();
        String s1 = "";
        String s2 = "";
        Iterator iterator = list.iterator();
        Object obj;
        String s4;
        do
        {
            obj = s1;
            s4 = s2;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (Header)iterator.next();
            String s3;
            if ("x-twitter-new-account-oauth-access-token".equals(((Header) (obj)).getName()))
            {
                s3 = ((Header) (obj)).getValue();
            } else
            {
                s3 = s1;
                if ("x-twitter-new-account-oauth-secret".equals(((Header) (obj)).getName()))
                {
                    s2 = ((Header) (obj)).getValue();
                    s3 = s1;
                }
            }
            if (!TextUtils.isEmpty(s3))
            {
                obj = s3;
                s4 = s2;
                if (!TextUtils.isEmpty(s2))
                {
                    break;
                }
            }
            s1 = s3;
        } while (true);
        return new DigitsSession(new TwitterAuthToken(((String) (obj)), s4), ((DigitsUser)result.data).id, s);
    }

    private boolean isValidUserId(long l)
    {
        return !isLoggedOutUser() && l != -1L;
    }

    private boolean isValidUserToken(AuthToken authtoken)
    {
        return (authtoken instanceof TwitterAuthToken) && ((TwitterAuthToken)authtoken).secret != null && ((TwitterAuthToken)authtoken).token != null;
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
        if (!super.equals(obj))
        {
            return false;
        }
        obj = (DigitsSession)obj;
        if (phoneNumber == null)
        {
            return ((DigitsSession) (obj)).phoneNumber == null;
        } else
        {
            return phoneNumber.equals(((DigitsSession) (obj)).phoneNumber);
        }
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public int hashCode()
    {
        int j = super.hashCode();
        int i;
        if (phoneNumber != null)
        {
            i = phoneNumber.hashCode();
        } else
        {
            i = 0;
        }
        return j * 31 + i;
    }

    public boolean isLoggedOutUser()
    {
        return getId() == 0L;
    }

    public boolean isValidUser()
    {
        return isValidUserId(getId()) && isValidUserToken(getAuthToken());
    }

}
