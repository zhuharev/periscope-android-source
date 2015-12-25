// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.models.ApiError;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import o.ig;
import o.iq;
import o.it;
import o.iv;
import o.iy;
import o.kd;
import o.ra;
import o.rl;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterException, TwitterRateLimit

public class TwitterApiException extends TwitterException
{

    public static final int DEFAULT_ERROR_CODE = 0;
    private final ApiError apiError;
    private final RetrofitError retrofitError;
    private final TwitterRateLimit twitterRateLimit;

    TwitterApiException(ApiError apierror, TwitterRateLimit twitterratelimit, RetrofitError retrofiterror)
    {
        super(retrofiterror.getMessage());
        retrofitError = retrofiterror;
        apiError = apierror;
        twitterRateLimit = twitterratelimit;
    }

    TwitterApiException(RetrofitError retrofiterror)
    {
        super(createExceptionMessage(retrofiterror));
        setStackTrace(retrofiterror.getStackTrace());
        retrofitError = retrofiterror;
        twitterRateLimit = createRateLimit(retrofiterror);
        apiError = readApiError(retrofiterror);
    }

    public static final TwitterApiException convert(RetrofitError retrofiterror)
    {
        return new TwitterApiException(retrofiterror);
    }

    private static String createExceptionMessage(RetrofitError retrofiterror)
    {
        if (retrofiterror.getMessage() != null)
        {
            return retrofiterror.getMessage();
        }
        if (retrofiterror.getResponse() != null)
        {
            return (new StringBuilder("Status: ")).append(retrofiterror.getResponse().getStatus()).toString();
        } else
        {
            return "unknown error";
        }
    }

    private static TwitterRateLimit createRateLimit(RetrofitError retrofiterror)
    {
        if (retrofiterror.getResponse() != null)
        {
            return new TwitterRateLimit(retrofiterror.getResponse().getHeaders());
        } else
        {
            return null;
        }
    }

    static ApiError parseApiError(String s)
    {
        ig ig1 = new ig();
        ApiError aapierror[];
        int i;
        aapierror = (ApiError[])ig1._mth02CA((iq)(new iv())._mth02CA(new StringReader(s))._mth0673().GC.get("errors"), [Lcom/twitter/sdk/android/core/models/ApiError;);
        i = aapierror.length;
        if (i == 0)
        {
            return null;
        } else
        {
            return aapierror[0];
        }
        Object obj;
        obj;
        ra._mth0454()._mth02CB("Twitter", (new StringBuilder("Invalid json: ")).append(s).toString(), ((Exception) (obj)));
        break MISSING_BLOCK_LABEL_118;
        obj;
        ra._mth0454()._mth02CB("Twitter", (new StringBuilder("Unexpected response: ")).append(s).toString(), ((Exception) (obj)));
        return null;
    }

    public static ApiError readApiError(RetrofitError retrofiterror)
    {
        if (retrofiterror == null || retrofiterror.getResponse() == null || retrofiterror.getResponse().getBody() == null)
        {
            return null;
        }
        retrofiterror = ((TypedByteArray)retrofiterror.getResponse().getBody()).getBytes();
        if (retrofiterror == null)
        {
            return null;
        }
        try
        {
            retrofiterror = parseApiError(new String(retrofiterror, "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (RetrofitError retrofiterror)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to convert to string", retrofiterror);
            return null;
        }
        return retrofiterror;
    }

    public boolean canRetry()
    {
        int i = retrofitError.getResponse().getStatus();
        return i < 400 || i > 499;
    }

    public int getErrorCode()
    {
        if (apiError == null)
        {
            return 0;
        } else
        {
            return apiError.getCode();
        }
    }

    public String getErrorMessage()
    {
        if (apiError == null)
        {
            return null;
        } else
        {
            return apiError.getMessage();
        }
    }

    public RetrofitError getRetrofitError()
    {
        return retrofitError;
    }

    public TwitterRateLimit getTwitterRateLimit()
    {
        return twitterRateLimit;
    }
}
