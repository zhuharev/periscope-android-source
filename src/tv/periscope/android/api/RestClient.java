// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.content.Context;
import com.squareup.okhttp.OkHttpClient;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executor;
import o.FF6A;
import o.yo;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.client.OkClient;

public class RestClient
{

    private static final int LOGCAT_MAX_LENGTH = 3950;
    private static final String TAG = "PsRetrofit";
    private final Object mApiService;
    private final RestAdapter mRestAdapter;

    public RestClient(final Context context, Executor executor, String s, Class class1)
    {
        OkHttpClient okhttpclient = new OkHttpClient();
        OkClient okclient = new OkClient(okhttpclient);
        CookieManager cookiemanager = new CookieManager();
        cookiemanager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
        CookieHandler.setDefault(cookiemanager);
        okhttpclient.setCookieHandler(cookiemanager);
        mRestAdapter = (new retrofit.RestAdapter.Builder()).setEndpoint(s).setExecutors(executor, new MainThreadExecutor()).setClient(okclient).setLogLevel(yo.getLogLevel()).setRequestInterceptor(new _cls2()).setLog(new _cls1()).build();
        mApiService = mRestAdapter.create(class1);
    }

    private static void dumpMessage(String s)
    {
        do
        {
            if (!FF6A.mb)
            {
                return;
            }
            if (s.length() > 3950)
            {
                s = s.substring(3950);
            } else
            {
                return;
            }
        } while (true);
    }

    public RestAdapter getAdapter()
    {
        return mRestAdapter;
    }

    public Object getService()
    {
        return mApiService;
    }


    private class _cls2
        implements RequestInterceptor
    {

        final RestClient this$0;
        final Context val$context;

        public void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
        {
            requestfacade.addHeader("User-Agent", "tv.periscope.android/1.3.2 (1900162)");
            requestfacade.addHeader("package", "tv.periscope.android");
            requestfacade.addHeader("build", "76d06c0");
            requestfacade.addHeader("locale", Locale.getDefault().getLanguage());
            requestfacade.addHeader("install_id", aos._mth1D4B(context));
            requestfacade.addHeader("os", aos.dF());
        }

        _cls2()
        {
            this$0 = RestClient.this;
            context = context1;
            super();
        }
    }


    private class _cls1
        implements retrofit.RestAdapter.Log
    {

        final RestClient this$0;

        public void log(String s)
        {
            RestClient.dumpMessage(s);
        }

        _cls1()
        {
            this$0 = RestClient.this;
            super();
        }
    }

}
