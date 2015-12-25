// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer.upstream.DataSink;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.FileDataSource;
import com.google.android.exoplayer.upstream.TeeDataSource;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            CacheDataSink, Cache, CacheSpan

public final class CacheDataSource
    implements DataSource
{
    public static interface EventListener
    {

        public abstract void onCachedBytesRead(long l, long l1);
    }


    private static final String TAG = "CacheDataSource";
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private DataSource currentDataSource;
    private final EventListener eventListener;
    private int flags;
    private boolean ignoreCache;
    private final boolean ignoreCacheOnError;
    private String key;
    private CacheSpan lockedSpan;
    private long readPosition;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;
    private Uri uri;

    public CacheDataSource(Cache cache1, DataSource datasource, DataSource datasource1, DataSink datasink, boolean flag, boolean flag1, EventListener eventlistener)
    {
        cache = cache1;
        cacheReadDataSource = datasource1;
        blockOnCache = flag;
        ignoreCacheOnError = flag1;
        upstreamDataSource = datasource;
        if (datasink != null)
        {
            cacheWriteDataSource = new TeeDataSource(datasource, datasink);
        } else
        {
            cacheWriteDataSource = null;
        }
        eventListener = eventlistener;
    }

    public CacheDataSource(Cache cache1, DataSource datasource, boolean flag, boolean flag1)
    {
        this(cache1, datasource, flag, flag1, 0x7fffffffffffffffL);
    }

    public CacheDataSource(Cache cache1, DataSource datasource, boolean flag, boolean flag1, long l)
    {
        this(cache1, datasource, ((DataSource) (new FileDataSource())), ((DataSink) (new CacheDataSink(cache1, l))), flag, flag1, null);
    }

    private void closeCurrentSource()
    {
        if (currentDataSource == null)
        {
            return;
        }
        currentDataSource.close();
        currentDataSource = null;
        Exception exception;
        if (lockedSpan != null)
        {
            cache.releaseHoleSpan(lockedSpan);
            lockedSpan = null;
            return;
        } else
        {
            return;
        }
        exception;
        if (lockedSpan != null)
        {
            cache.releaseHoleSpan(lockedSpan);
            lockedSpan = null;
        }
        throw exception;
    }

    private void handleBeforeThrow(IOException ioexception)
    {
        if (ignoreCacheOnError && (currentDataSource == cacheReadDataSource || (ioexception instanceof CacheDataSink.CacheDataSinkException)))
        {
            ignoreCache = true;
        }
    }

    private void notifyBytesRead()
    {
        if (eventListener != null && totalCachedBytesRead > 0L)
        {
            eventListener.onCachedBytesRead(cache.getCacheSpace(), totalCachedBytesRead);
            totalCachedBytesRead = 0L;
        }
    }

    private void openNextSource()
    {
        Object obj;
        if (ignoreCache)
        {
            obj = null;
            break MISSING_BLOCK_LABEL_82;
        }
        if (bytesRemaining != -1L)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        Log.w("CacheDataSource", "Cache bypassed due to unbounded length.");
        obj = null;
        break MISSING_BLOCK_LABEL_82;
        if (blockOnCache)
        {
            obj = cache.startReadWrite(key, readPosition);
            break MISSING_BLOCK_LABEL_82;
        }
        Object obj1;
        long l;
        long l1;
        try
        {
            obj = cache.startReadWriteNonBlocking(key, readPosition);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        currentDataSource = upstreamDataSource;
        obj1 = new DataSpec(uri, readPosition, bytesRemaining, key, flags);
        break MISSING_BLOCK_LABEL_279;
        if (((CacheSpan) (obj)).isCached)
        {
            obj1 = Uri.fromFile(((CacheSpan) (obj)).file);
            l = readPosition - ((CacheSpan) (obj)).position;
            l1 = Math.min(((CacheSpan) (obj)).length - l, bytesRemaining);
            obj1 = new DataSpec(((Uri) (obj1)), readPosition, l, l1, key, flags);
            obj = cacheReadDataSource;
            break MISSING_BLOCK_LABEL_274;
        }
        lockedSpan = ((CacheSpan) (obj));
        if (((CacheSpan) (obj)).isOpenEnded())
        {
            l = bytesRemaining;
            break MISSING_BLOCK_LABEL_229;
        }
        l = Math.min(((CacheSpan) (obj)).length, bytesRemaining);
        obj1 = new DataSpec(uri, readPosition, l, key, flags);
        if (cacheWriteDataSource != null)
        {
            obj = cacheWriteDataSource;
            break MISSING_BLOCK_LABEL_274;
        }
        obj = upstreamDataSource;
        currentDataSource = ((DataSource) (obj));
        currentDataSource.open(((DataSpec) (obj1)));
        return;
    }

    public final void close()
    {
        notifyBytesRead();
        try
        {
            closeCurrentSource();
            return;
        }
        catch (IOException ioexception)
        {
            handleBeforeThrow(ioexception);
            throw ioexception;
        }
    }

    public final long open(DataSpec dataspec)
    {
        long l;
        try
        {
            uri = dataspec.uri;
            flags = dataspec.flags;
            key = dataspec.key;
            readPosition = dataspec.position;
            bytesRemaining = dataspec.length;
            openNextSource();
            l = dataspec.length;
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            handleBeforeThrow(dataspec);
            throw dataspec;
        }
        return l;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        int k;
        try
        {
            k = currentDataSource.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            handleBeforeThrow(abyte0);
            throw abyte0;
        }
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (currentDataSource == cacheReadDataSource)
        {
            totalCachedBytesRead = totalCachedBytesRead + (long)k;
        }
        readPosition = readPosition + (long)k;
        if (bytesRemaining == -1L)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        bytesRemaining = bytesRemaining - (long)k;
        return k;
        closeCurrentSource();
        if (bytesRemaining <= 0L || bytesRemaining == -1L)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        openNextSource();
        i = read(abyte0, i, j);
        return i;
        return k;
    }
}
