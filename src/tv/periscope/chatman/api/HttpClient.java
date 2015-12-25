// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;

import com.squareup.okhttp.OkHttpClient;
import java.util.concurrent.Executor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.client.OkClient;

// Referenced classes of package tv.periscope.chatman.api:
//            HttpService

public class HttpClient
{

    private final HttpService mService;

    public HttpClient(Executor executor, String s, retrofit.RestAdapter.LogLevel loglevel)
    {
        mService = (HttpService)(new retrofit.RestAdapter.Builder()).setExecutors(executor, new MainThreadExecutor()).setEndpoint((new StringBuilder()).append(s).append("/chatapi/v1").toString()).setLogLevel(loglevel).setClient(new OkClient(new OkHttpClient())).setLog(new _cls1()).build().create(tv/periscope/chatman/api/HttpService);
    }

    public HttpService getService()
    {
        return mService;
    }

    private class _cls1
        implements retrofit.RestAdapter.Log
    {

        final HttpClient this$0;

        public void log(String s)
        {
            aul._mth02BF("ChatMan", s);
        }

        _cls1()
        {
            this$0 = HttpClient.this;
            super();
        }
    }

}
