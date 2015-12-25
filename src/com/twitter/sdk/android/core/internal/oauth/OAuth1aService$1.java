// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import retrofit.client.Response;
import retrofit.mime.TypedInput;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuth1aService

class val.callback extends Callback
{

    final OAuth1aService this$0;
    final Callback val$callback;

    public void failure(TwitterException twitterexception)
    {
        val$callback.failure(twitterexception);
    }

    public void success(Result result)
    {
        Object obj;
        StringBuilder stringbuilder;
        obj = null;
        stringbuilder = new StringBuilder();
        result = new BufferedReader(new InputStreamReader(((Response)result.data).getBody().in()));
_L2:
        obj = result;
        String s = result.readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = result;
        stringbuilder.append(s);
        if (true) goto _L2; else goto _L1
_L1:
        result.close();
        break MISSING_BLOCK_LABEL_83;
        result;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        ((BufferedReader) (obj)).close();
        throw result;
        result = stringbuilder.toString();
        obj = OAuth1aService.parseAuthResponse(result);
        if (obj == null)
        {
            try
            {
                val$callback.failure(new TwitterAuthException((new StringBuilder("Failed to parse auth response: ")).append(result).toString()));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Result result)
            {
                val$callback.failure(new TwitterAuthException(result.getMessage(), result));
            }
            break MISSING_BLOCK_LABEL_165;
        }
        val$callback.success(new Result(obj, null));
        return;
    }

    ()
    {
        this$0 = final_oauth1aservice;
        val$callback = Callback.this;
        super();
    }
}
