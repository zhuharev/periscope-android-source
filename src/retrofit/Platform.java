// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import o.ig;
import retrofit.android.AndroidApacheClient;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.appengine.UrlFetchClient;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

abstract class Platform
{
    static class Android extends Platform
    {

        Executor defaultCallbackExecutor()
        {
            return new MainThreadExecutor();
        }

        retrofit.client.Client.Provider defaultClient()
        {
            final Object client;
            if (Platform.hasOkHttpOnClasspath())
            {
                client = OkClientInstantiator.instantiate();
            } else
            if (android.os.Build.VERSION.SDK_INT < 9)
            {
                client = new AndroidApacheClient();
            } else
            {
                client = new UrlConnectionClient();
            }
            class _cls1
                implements retrofit.client.Client.Provider
            {

                final Android this$0;
                final Client val$client;

                public Client get()
                {
                    return client;
                }

                _cls1()
                {
                    this$0 = Android.this;
                    client = client1;
                    super();
                }
            }

            return new _cls1();
        }

        Converter defaultConverter()
        {
            return new GsonConverter(new ig());
        }

        Executor defaultHttpExecutor()
        {
            class _cls2
                implements ThreadFactory
            {

                final Android this$0;

                public Thread newThread(final Runnable r)
                {
                    class _cls1
                        implements Runnable
                    {

                        final _cls2 this$1;
                        final Runnable val$r;

                        public void run()
                        {
                            Process.setThreadPriority(10);
                            r.run();
                        }

                            _cls1()
                            {
                                this$1 = _cls2.this;
                                r = runnable;
                                super();
                            }
                    }

                    return new Thread(new _cls1(), "Retrofit-Idle");
                }

                _cls2()
                {
                    this$0 = Android.this;
                    super();
                }
            }

            return Executors.newCachedThreadPool(new _cls2());
        }

        RestAdapter.Log defaultLog()
        {
            return new AndroidLog("Retrofit");
        }

        private Android()
        {
        }

        Android(_cls1 _pcls1)
        {
            this();
        }
    }

    static class AppEngine extends Base
    {

        retrofit.client.Client.Provider defaultClient()
        {
            class _cls1
                implements retrofit.client.Client.Provider
            {

                final AppEngine this$0;
                final UrlFetchClient val$client;

                public Client get()
                {
                    return client;
                }

                _cls1()
                {
                    this$0 = AppEngine.this;
                    client = urlfetchclient;
                    super();
                }
            }

            return new _cls1();
        }

        private AppEngine()
        {
            super(null);
        }

        AppEngine(_cls1 _pcls1)
        {
            this();
        }
    }

    static class Base extends Platform
    {

        Executor defaultCallbackExecutor()
        {
            return new Utils.SynchronousExecutor();
        }

        retrofit.client.Client.Provider defaultClient()
        {
            final Object client;
            if (Platform.hasOkHttpOnClasspath())
            {
                client = OkClientInstantiator.instantiate();
            } else
            {
                client = new UrlConnectionClient();
            }
            class _cls1
                implements retrofit.client.Client.Provider
            {

                final Base this$0;
                final Client val$client;

                public Client get()
                {
                    return client;
                }

                _cls1()
                {
                    this$0 = Base.this;
                    client = client1;
                    super();
                }
            }

            return new _cls1();
        }

        Converter defaultConverter()
        {
            return new GsonConverter(new ig());
        }

        Executor defaultHttpExecutor()
        {
            class _cls2
                implements ThreadFactory
            {

                final Base this$0;

                public Thread newThread(final Runnable r)
                {
                    class _cls1
                        implements Runnable
                    {

                        final _cls2 this$1;
                        final Runnable val$r;

                        public void run()
                        {
                            Thread.currentThread().setPriority(1);
                            r.run();
                        }

                            _cls1()
                            {
                                this$1 = _cls2.this;
                                r = runnable;
                                super();
                            }
                    }

                    return new Thread(new _cls1(), "Retrofit-Idle");
                }

                _cls2()
                {
                    this$0 = Base.this;
                    super();
                }
            }

            return Executors.newCachedThreadPool(new _cls2());
        }

        RestAdapter.Log defaultLog()
        {
            class _cls3
                implements RestAdapter.Log
            {

                final Base this$0;

                public void log(String s)
                {
                    System.out.println(s);
                }

                _cls3()
                {
                    this$0 = Base.this;
                    super();
                }
            }

            return new _cls3();
        }

        private Base()
        {
        }

        Base(_cls1 _pcls1)
        {
            this();
        }
    }

    static class OkClientInstantiator
    {

        static Client instantiate()
        {
            return new OkClient();
        }

        private OkClientInstantiator()
        {
        }
    }


    static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();
    private static final Platform PLATFORM = findPlatform();

    Platform()
    {
    }

    private static Platform findPlatform()
    {
        Android android;
        Class.forName("android.os.Build");
        if (android.os.Build.VERSION.SDK_INT == 0)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        android = new Android(null);
        return android;
_L2:
        if (System.getProperty("com.google.appengine.runtime.version") != null)
        {
            return new AppEngine(null);
        } else
        {
            return new Base(null);
        }
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static Platform get()
    {
        return PLATFORM;
    }

    private static boolean hasOkHttpOnClasspath()
    {
        ClassNotFoundException classnotfoundexception;
        try
        {
            Class.forName("com.squareup.okhttp.OkHttpClient");
        }
        // Misplaced declaration of an exception variable
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    private static boolean hasRxJavaOnClasspath()
    {
        ClassNotFoundException classnotfoundexception;
        try
        {
            Class.forName("rx.Observable");
        }
        // Misplaced declaration of an exception variable
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    abstract Executor defaultCallbackExecutor();

    abstract retrofit.client.Client.Provider defaultClient();

    abstract Converter defaultConverter();

    abstract Executor defaultHttpExecutor();

    abstract RestAdapter.Log defaultLog();


}
