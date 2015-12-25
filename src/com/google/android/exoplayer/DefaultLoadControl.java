// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.Handler;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.NetworkLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer:
//            LoadControl

public final class DefaultLoadControl
    implements LoadControl
{
    public static interface EventListener
    {

        public abstract void onLoadingChanged(boolean flag);
    }

    static class LoaderState
    {

        public final int bufferSizeContribution;
        public int bufferState;
        public boolean loading;
        public long nextLoadPositionUs;

        public LoaderState(int i)
        {
            bufferSizeContribution = i;
            bufferState = 0;
            loading = false;
            nextLoadPositionUs = -1L;
        }
    }


    private static final int ABOVE_HIGH_WATERMARK = 0;
    private static final int BELOW_LOW_WATERMARK = 2;
    private static final int BETWEEN_WATERMARKS = 1;
    public static final float DEFAULT_HIGH_BUFFER_LOAD = 0.8F;
    public static final int DEFAULT_HIGH_WATERMARK_MS = 30000;
    public static final float DEFAULT_LOW_BUFFER_LOAD = 0.2F;
    public static final int DEFAULT_LOW_WATERMARK_MS = 15000;
    private final Allocator allocator;
    private int bufferState;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private boolean fillingBuffers;
    private final float highBufferLoad;
    private final long highWatermarkUs;
    private final HashMap loaderStates;
    private final List loaders;
    private final float lowBufferLoad;
    private final long lowWatermarkUs;
    private long maxLoadStartPositionUs;
    private boolean streamingPrioritySet;
    private int targetBufferSize;

    public DefaultLoadControl(Allocator allocator1)
    {
        this(allocator1, null, null);
    }

    public DefaultLoadControl(Allocator allocator1, Handler handler, EventListener eventlistener)
    {
        this(allocator1, handler, eventlistener, 15000, 30000, 0.2F, 0.8F);
    }

    public DefaultLoadControl(Allocator allocator1, Handler handler, EventListener eventlistener, int i, int j, float f, float f1)
    {
        allocator = allocator1;
        eventHandler = handler;
        eventListener = eventlistener;
        loaders = new ArrayList();
        loaderStates = new HashMap();
        lowWatermarkUs = (long)i * 1000L;
        highWatermarkUs = (long)j * 1000L;
        lowBufferLoad = f;
        highBufferLoad = f1;
    }

    private int getBufferState(int i)
    {
        float f = (float)i / (float)targetBufferSize;
        if (f > highBufferLoad)
        {
            return 0;
        }
        return f >= lowBufferLoad ? 1 : 2;
    }

    private int getLoaderBufferState(long l, long l1)
    {
        if (l1 == -1L)
        {
            return 0;
        }
        l = l1 - l;
        if (l > highWatermarkUs)
        {
            return 0;
        }
        return l >= lowWatermarkUs ? 1 : 2;
    }

    private void notifyLoadingChanged(final boolean loading)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new _cls1());
        }
    }

    private void updateControlState()
    {
        boolean flag1 = false;
        boolean flag = false;
        int k = bufferState;
        for (int i = 0; i < loaders.size();)
        {
            LoaderState loaderstate = (LoaderState)loaderStates.get(loaders.get(i));
            boolean flag2 = flag1 | loaderstate.loading;
            if (loaderstate.nextLoadPositionUs != -1L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag |= flag1;
            k = Math.max(k, loaderstate.bufferState);
            i++;
            flag1 = flag2;
        }

        boolean flag3;
        if (!loaders.isEmpty() && (flag1 || flag) && (k == 2 || k == 1 && fillingBuffers))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        fillingBuffers = flag3;
        if (fillingBuffers && !streamingPrioritySet)
        {
            NetworkLock.instance.add(0);
            streamingPrioritySet = true;
            notifyLoadingChanged(true);
        } else
        if (!fillingBuffers && streamingPrioritySet && !flag1)
        {
            NetworkLock.instance.remove(0);
            streamingPrioritySet = false;
            notifyLoadingChanged(false);
        }
        maxLoadStartPositionUs = -1L;
        if (fillingBuffers)
        {
            for (int j = 0; j < loaders.size(); j++)
            {
                Object obj = loaders.get(j);
                long l = ((LoaderState)loaderStates.get(obj)).nextLoadPositionUs;
                if (l != -1L && (maxLoadStartPositionUs == -1L || l < maxLoadStartPositionUs))
                {
                    maxLoadStartPositionUs = l;
                }
            }

        }
    }

    public final Allocator getAllocator()
    {
        return allocator;
    }

    public final void register(Object obj, int i)
    {
        loaders.add(obj);
        loaderStates.put(obj, new LoaderState(i));
        targetBufferSize = targetBufferSize + i;
    }

    public final void trimAllocator()
    {
        allocator.trim(targetBufferSize);
    }

    public final void unregister(Object obj)
    {
        loaders.remove(obj);
        obj = (LoaderState)loaderStates.remove(obj);
        targetBufferSize = targetBufferSize - ((LoaderState) (obj)).bufferSizeContribution;
        updateControlState();
    }

    public final boolean update(Object obj, long l, long l1, boolean flag)
    {
        int i = getLoaderBufferState(l, l1);
        obj = (LoaderState)loaderStates.get(obj);
        boolean flag1;
        if (((LoaderState) (obj)).bufferState != i || ((LoaderState) (obj)).nextLoadPositionUs != l1 || ((LoaderState) (obj)).loading != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            obj.bufferState = i;
            obj.nextLoadPositionUs = l1;
            obj.loading = flag;
        }
        int j = allocator.getTotalBytesAllocated();
        int k = getBufferState(j);
        boolean flag2;
        if (bufferState != k)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            bufferState = k;
        }
        if (flag1 || flag2)
        {
            updateControlState();
        }
        return j < targetBufferSize && l1 != -1L && l1 <= maxLoadStartPositionUs;
    }


    private class _cls1
        implements Runnable
    {

        final DefaultLoadControl this$0;
        final boolean val$loading;

        public void run()
        {
            eventListener.onLoadingChanged(loading);
        }

        _cls1()
        {
            this$0 = DefaultLoadControl.this;
            loading = flag;
            super();
        }
    }

}
