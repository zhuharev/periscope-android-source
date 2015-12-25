// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterException;
import retrofit.RetrofitError;

// Referenced classes of package com.digits.sdk.android:
//            AuthConfig, ErrorCodes, CouldNotAuthenticateException, OperatorUnsupportedException, 
//            UnrecoverableException

public class DigitsException extends RuntimeException
{

    private final AuthConfig config;
    private final int errorCode;

    DigitsException(String s)
    {
        this(s, -1, new AuthConfig());
    }

    DigitsException(String s, int i, AuthConfig authconfig)
    {
        super(s);
        errorCode = i;
        config = authconfig;
    }

    static DigitsException create(ErrorCodes errorcodes, TwitterException twitterexception)
    {
        if (twitterexception instanceof TwitterApiException)
        {
            twitterexception = (TwitterApiException)twitterexception;
            errorcodes = getMessageForApiError(errorcodes, twitterexception);
            return createException(twitterexception.getErrorCode(), errorcodes, (AuthConfig)twitterexception.getRetrofitError().getBodyAs(com/digits/sdk/android/AuthConfig));
        } else
        {
            return new DigitsException(errorcodes.getDefaultMessage());
        }
    }

    private static DigitsException createException(int i, String s, AuthConfig authconfig)
    {
        if (i == 32)
        {
            return new CouldNotAuthenticateException(s, i, authconfig);
        }
        if (i == 286)
        {
            return new OperatorUnsupportedException(s, i, authconfig);
        }
        if (isUnrecoverable(i))
        {
            return new UnrecoverableException(s, i, authconfig);
        } else
        {
            return new DigitsException(s, i, authconfig);
        }
    }

    private static String getMessageForApiError(ErrorCodes errorcodes, TwitterApiException twitterapiexception)
    {
        if (twitterapiexception.getRetrofitError().isNetworkError())
        {
            return errorcodes.getNetworkError();
        } else
        {
            return errorcodes.getMessage(twitterapiexception.getErrorCode());
        }
    }

    private static boolean isUnrecoverable(int i)
    {
        return i == 269 || i == 235 || i == 237 || i == 299 || i == 284;
    }

    public AuthConfig getConfig()
    {
        return config;
    }

    public int getErrorCode()
    {
        return errorCode;
    }
}
