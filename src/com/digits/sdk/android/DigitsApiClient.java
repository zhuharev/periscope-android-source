// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.AuthenticatedClient;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLSocketFactory;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

// Referenced classes of package com.digits.sdk.android:
//            Digits, DigitsUserAgent, DigitsApi, DigitsRequestInterceptor

class DigitsApiClient
{
    public static interface AccountService
    {

        public abstract void verifyAccount(Callback callback);
    }

    public static interface DeviceService
    {

        public abstract void register(String s, String s1, Boolean boolean1, String s2, String s3, String s4, Callback callback);
    }

    public static interface SdkService
    {

        public abstract void account(String s, String s1, Callback callback);

        public abstract void auth(String s, String s1, Callback callback);

        public abstract void login(String s, long l, String s1, Callback callback);

        public abstract void verifyPin(String s, long l, String s1, Callback callback);
    }


    private final RestAdapter restAdapter;
    private final ConcurrentHashMap services;
    private final Session session;

    DigitsApiClient(Session session1)
    {
        this(session1, TwitterCore.getInstance().getAuthConfig(), TwitterCore.getInstance().getSSLSocketFactory(), Digits.getInstance().getExecutorService(), new DigitsUserAgent(Digits.getInstance().getVersion(), android.os.Build.VERSION.RELEASE));
    }

    DigitsApiClient(Session session1, TwitterAuthConfig twitterauthconfig, SSLSocketFactory sslsocketfactory, ExecutorService executorservice, DigitsUserAgent digitsuseragent)
    {
        session = session1;
        services = new ConcurrentHashMap();
        restAdapter = (new retrofit.RestAdapter.Builder()).setEndpoint((new DigitsApi()).getBaseHostUrl()).setRequestInterceptor(new DigitsRequestInterceptor(digitsuseragent)).setExecutors(executorservice, new MainThreadExecutor()).setClient(new AuthenticatedClient(twitterauthconfig, session1, sslsocketfactory)).build();
    }

    private Object getService(Class class1)
    {
        if (!services.containsKey(class1))
        {
            services.put(class1, restAdapter.create(class1));
        }
        return services.get(class1);
    }

    public AccountService getAccountService()
    {
        return (AccountService)getService(com/digits/sdk/android/DigitsApiClient$AccountService);
    }

    public DeviceService getDeviceService()
    {
        return (DeviceService)getService(com/digits/sdk/android/DigitsApiClient$DeviceService);
    }

    public SdkService getSdkService()
    {
        return (SdkService)getService(com/digits/sdk/android/DigitsApiClient$SdkService);
    }

    public Session getSession()
    {
        return session;
    }
}
