// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.UriLoadable;
import java.io.IOException;
import java.util.concurrent.CancellationException;

// Referenced classes of package com.google.android.exoplayer.util:
//            ManifestFetcher

class wrappedCallback
    implements com.google.android.exoplayer.upstream.pedCallback
{

    private final Looper callbackLooper;
    private long loadStartTimestamp;
    private final UriLoadable singleUseLoadable;
    private final Loader singleUseLoader = new Loader("manifestLoader:single");
    final ManifestFetcher this$0;
    private final singleUseLoadable wrappedCallback;

    private void releaseLoader()
    {
        singleUseLoader.release();
    }

    public void onLoadCanceled(com.google.android.exoplayer.upstream.leUseLoader leuseloader)
    {
        leuseloader = new IOException("Load cancelled", new CancellationException());
        wrappedCallback.nSingleManifestError(leuseloader);
        releaseLoader();
        return;
        leuseloader;
        releaseLoader();
        throw leuseloader;
    }

    public void onLoadCompleted(com.google.android.exoplayer.upstream.aseLoader aseloader)
    {
        aseloader = ((com.google.android.exoplayer.upstream.aseLoader) (singleUseLoadable.getResult()));
        onSingleFetchCompleted(aseloader, loadStartTimestamp);
        wrappedCallback.nSingleManifest(aseloader);
        releaseLoader();
        return;
        aseloader;
        releaseLoader();
        throw aseloader;
    }

    public void onLoadError(com.google.android.exoplayer.upstream.aseLoader aseloader, IOException ioexception)
    {
        wrappedCallback.nSingleManifestError(ioexception);
        releaseLoader();
        return;
        aseloader;
        releaseLoader();
        throw aseloader;
    }

    public void startLoading()
    {
        loadStartTimestamp = SystemClock.elapsedRealtime();
        singleUseLoader.startLoading(callbackLooper, singleUseLoadable, this);
    }

    public I(UriLoadable uriloadable, Looper looper, I i)
    {
        this$0 = ManifestFetcher.this;
        super();
        singleUseLoadable = uriloadable;
        callbackLooper = looper;
        wrappedCallback = i;
    }
}
