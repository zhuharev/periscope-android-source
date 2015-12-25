// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.upstream.UriLoadable;
import java.io.IOException;
import java.util.concurrent.CancellationException;

public class ManifestFetcher
    implements com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface EventListener
    {

        public abstract void onManifestError(IOException ioexception);

        public abstract void onManifestRefreshStarted();

        public abstract void onManifestRefreshed();
    }

    public static interface ManifestCallback
    {

        public abstract void onSingleManifest(Object obj);

        public abstract void onSingleManifestError(IOException ioexception);
    }

    public static interface RedirectingManifest
    {

        public abstract String getNextManifestUri();
    }

    class SingleFetchHelper
        implements com.google.android.exoplayer.upstream.Loader.Callback
    {

        private final Looper callbackLooper;
        private long loadStartTimestamp;
        private final UriLoadable singleUseLoadable;
        private final Loader singleUseLoader = new Loader("manifestLoader:single");
        final ManifestFetcher this$0;
        private final ManifestCallback wrappedCallback;

        private void releaseLoader()
        {
            singleUseLoader.release();
        }

        public void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
        {
            loadable = new IOException("Load cancelled", new CancellationException());
            wrappedCallback.onSingleManifestError(loadable);
            releaseLoader();
            return;
            loadable;
            releaseLoader();
            throw loadable;
        }

        public void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
        {
            loadable = ((com.google.android.exoplayer.upstream.Loader.Loadable) (singleUseLoadable.getResult()));
            onSingleFetchCompleted(loadable, loadStartTimestamp);
            wrappedCallback.onSingleManifest(loadable);
            releaseLoader();
            return;
            loadable;
            releaseLoader();
            throw loadable;
        }

        public void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
        {
            wrappedCallback.onSingleManifestError(ioexception);
            releaseLoader();
            return;
            loadable;
            releaseLoader();
            throw loadable;
        }

        public void startLoading()
        {
            loadStartTimestamp = SystemClock.elapsedRealtime();
            singleUseLoader.startLoading(callbackLooper, singleUseLoadable, this);
        }

        public SingleFetchHelper(UriLoadable uriloadable, Looper looper, ManifestCallback manifestcallback)
        {
            this$0 = ManifestFetcher.this;
            super();
            singleUseLoadable = uriloadable;
            callbackLooper = looper;
            wrappedCallback = manifestcallback;
        }
    }


    private long currentLoadStartTimestamp;
    private UriLoadable currentLoadable;
    private int enabledCount;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private IOException loadException;
    private int loadExceptionCount;
    private long loadExceptionTimestamp;
    private Loader loader;
    private volatile Object manifest;
    private volatile long manifestLoadCompleteTimestamp;
    private volatile long manifestLoadStartTimestamp;
    volatile String manifestUri;
    private final com.google.android.exoplayer.upstream.UriLoadable.Parser parser;
    private final UriDataSource uriDataSource;

    public ManifestFetcher(String s, UriDataSource uridatasource, com.google.android.exoplayer.upstream.UriLoadable.Parser parser1)
    {
        this(s, uridatasource, parser1, null, null);
    }

    public ManifestFetcher(String s, UriDataSource uridatasource, com.google.android.exoplayer.upstream.UriLoadable.Parser parser1, Handler handler, EventListener eventlistener)
    {
        parser = parser1;
        manifestUri = s;
        uriDataSource = uridatasource;
        eventHandler = handler;
        eventListener = eventlistener;
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private void notifyManifestError(final IOException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls3());
        }
    }

    private void notifyManifestRefreshStarted()
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    private void notifyManifestRefreshed()
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls2());
        }
    }

    public void disable()
    {
        int i = enabledCount - 1;
        enabledCount = i;
        if (i == 0 && loader != null)
        {
            loader.release();
            loader = null;
        }
    }

    public void enable()
    {
        int i = enabledCount;
        enabledCount = i + 1;
        if (i == 0)
        {
            loadExceptionCount = 0;
            loadException = null;
        }
    }

    public Object getManifest()
    {
        return manifest;
    }

    public long getManifestLoadCompleteTimestamp()
    {
        return manifestLoadCompleteTimestamp;
    }

    public long getManifestLoadStartTimestamp()
    {
        return manifestLoadStartTimestamp;
    }

    public void maybeThrowError()
    {
        if (loadException == null || loadExceptionCount <= 1)
        {
            return;
        } else
        {
            throw loadException;
        }
    }

    public void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
    }

    public void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        if (currentLoadable != loadable)
        {
            return;
        }
        manifest = currentLoadable.getResult();
        manifestLoadStartTimestamp = currentLoadStartTimestamp;
        manifestLoadCompleteTimestamp = SystemClock.elapsedRealtime();
        loadExceptionCount = 0;
        loadException = null;
        if (manifest instanceof RedirectingManifest)
        {
            loadable = ((RedirectingManifest)manifest).getNextManifestUri();
            if (!TextUtils.isEmpty(loadable))
            {
                manifestUri = loadable;
            }
        }
        notifyManifestRefreshed();
    }

    public void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        if (currentLoadable != loadable)
        {
            return;
        } else
        {
            loadExceptionCount = loadExceptionCount + 1;
            loadExceptionTimestamp = SystemClock.elapsedRealtime();
            loadException = new IOException(ioexception);
            notifyManifestError(loadException);
            return;
        }
    }

    void onSingleFetchCompleted(Object obj, long l)
    {
        manifest = obj;
        manifestLoadStartTimestamp = l;
        manifestLoadCompleteTimestamp = SystemClock.elapsedRealtime();
    }

    public void requestRefresh()
    {
        if (loadException != null && SystemClock.elapsedRealtime() < loadExceptionTimestamp + getRetryDelayMillis(loadExceptionCount))
        {
            return;
        }
        if (loader == null)
        {
            loader = new Loader("manifestLoader");
        }
        if (!loader.isLoading())
        {
            currentLoadable = new UriLoadable(manifestUri, uriDataSource, parser);
            currentLoadStartTimestamp = SystemClock.elapsedRealtime();
            loader.startLoading(currentLoadable, this);
            notifyManifestRefreshStarted();
        }
    }

    public void singleLoad(Looper looper, ManifestCallback manifestcallback)
    {
        (new SingleFetchHelper(new UriLoadable(manifestUri, uriDataSource, parser), looper, manifestcallback)).startLoading();
    }

    public void updateManifestUri(String s)
    {
        manifestUri = s;
    }


    private class _cls3
        implements Runnable
    {

        final ManifestFetcher this$0;
        final IOException val$e;

        public void run()
        {
            eventListener.onManifestError(e);
        }

        _cls3()
        {
            this$0 = ManifestFetcher.this;
            e = ioexception;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final ManifestFetcher this$0;

        public void run()
        {
            eventListener.onManifestRefreshStarted();
        }

        _cls1()
        {
            this$0 = ManifestFetcher.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final ManifestFetcher this$0;

        public void run()
        {
            eventListener.onManifestRefreshed();
        }

        _cls2()
        {
            this$0 = ManifestFetcher.this;
            super();
        }
    }

}
