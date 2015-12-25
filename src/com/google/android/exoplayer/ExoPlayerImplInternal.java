// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.PriorityHandlerThread;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.exoplayer:
//            StandaloneMediaClock, TrackRenderer, MediaFormat, ExoPlaybackException, 
//            MediaClock

final class ExoPlayerImplInternal
    implements android.os.Handler.Callback
{

    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_CUSTOM = 9;
    private static final int MSG_DO_SOME_WORK = 7;
    public static final int MSG_ERROR = 4;
    private static final int MSG_INCREMENTAL_PREPARE = 2;
    private static final int MSG_PREPARE = 1;
    public static final int MSG_PREPARED = 1;
    private static final int MSG_RELEASE = 5;
    public static final int MSG_SEEK_COMPLETE = 1000;
    private static final int MSG_SEEK_TO = 6;
    private static final int MSG_SET_PLAY_WHEN_READY = 3;
    public static final int MSG_SET_PLAY_WHEN_READY_ACK = 3;
    private static final int MSG_SET_RENDERER_SELECTED_TRACK = 8;
    public static final int MSG_STATE_CHANGED = 2;
    private static final int MSG_STOP = 4;
    private static final int PREPARE_INTERVAL_MS = 10;
    private static final int RENDERING_INTERVAL_MS = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private volatile long bufferedPositionUs;
    private int customMessagesProcessed;
    private int customMessagesSent;
    private volatile long durationUs;
    private long elapsedRealtimeUs;
    private final List enabledRenderers;
    private final Handler eventHandler;
    private final Handler handler;
    private final HandlerThread internalPlaybackThread = new PriorityHandlerThread((new StringBuilder()).append(getClass().getSimpleName()).append(":Handler").toString(), -16);
    private long lastSeekPositionMs;
    private final long minBufferUs;
    private final long minRebufferUs;
    private boolean pendingSeek;
    private final AtomicInteger pendingSeekCount = new AtomicInteger();
    private boolean playWhenReady;
    private volatile long positionUs;
    private boolean rebuffering;
    private boolean released;
    private MediaClock rendererMediaClock;
    private TrackRenderer rendererMediaClockSource;
    private TrackRenderer renderers[];
    private final int selectedTrackIndices[];
    private final StandaloneMediaClock standaloneMediaClock = new StandaloneMediaClock();
    private int state;
    private final MediaFormat trackFormats[][];

    public ExoPlayerImplInternal(Handler handler1, boolean flag, int ai[], int i, int j)
    {
        customMessagesSent = 0;
        customMessagesProcessed = 0;
        eventHandler = handler1;
        playWhenReady = flag;
        minBufferUs = (long)i * 1000L;
        minRebufferUs = (long)j * 1000L;
        selectedTrackIndices = Arrays.copyOf(ai, ai.length);
        state = 1;
        durationUs = -1L;
        bufferedPositionUs = -1L;
        enabledRenderers = new ArrayList(ai.length);
        trackFormats = new MediaFormat[ai.length][];
        internalPlaybackThread.start();
        handler = new Handler(internalPlaybackThread.getLooper(), this);
    }

    private void doSomeWork()
    {
        TraceUtil.beginSection("doSomeWork");
        long l2 = SystemClock.elapsedRealtime();
        long l;
        if (durationUs != -1L)
        {
            l = durationUs;
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        boolean flag = true;
        boolean flag1 = true;
        updatePositionUs();
        int i = 0;
        long l1;
        for (l1 = l; i < enabledRenderers.size(); l1 = l)
        {
label0:
            {
                TrackRenderer trackrenderer = (TrackRenderer)enabledRenderers.get(i);
                trackrenderer.doSomeWork(positionUs, elapsedRealtimeUs);
                if (flag && trackrenderer.isEnded())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                boolean flag2 = rendererReadyOrEnded(trackrenderer);
                if (!flag2)
                {
                    trackrenderer.maybeThrowError();
                }
                if (flag1 && flag2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                l = l1;
                if (l1 == -1L)
                {
                    break label0;
                }
                long l3 = trackrenderer.getDurationUs();
                long l4 = trackrenderer.getBufferedPositionUs();
                if (l4 == -1L)
                {
                    l = -1L;
                    break label0;
                }
                l = l1;
                if (l4 == -3L)
                {
                    break label0;
                }
                if (l3 != -1L && l3 != -2L)
                {
                    l = l1;
                    if (l4 >= l3)
                    {
                        break label0;
                    }
                }
                l = Math.min(l1, l4);
            }
            i++;
        }

        bufferedPositionUs = l1;
        if (flag && (durationUs == -1L || durationUs <= positionUs))
        {
            setState(5);
            stopRenderers();
        } else
        if (state == 3 && flag1)
        {
            if (pendingSeek)
            {
                pendingSeek = false;
                eventHandler.sendEmptyMessage(1000);
            }
            setState(4);
            if (playWhenReady)
            {
                startRenderers();
            }
        } else
        if (state == 4 && !flag1)
        {
            rebuffering = playWhenReady;
            setState(3);
            stopRenderers();
        }
        handler.removeMessages(7);
        if (playWhenReady && state == 4 || state == 3)
        {
            scheduleNextOperation(7, l2, 10L);
        } else
        if (!enabledRenderers.isEmpty())
        {
            scheduleNextOperation(7, l2, 1000L);
        }
        TraceUtil.endSection();
    }

    private void ensureStopped(TrackRenderer trackrenderer)
    {
        if (trackrenderer.getState() == 3)
        {
            trackrenderer.stop();
        }
    }

    private void incrementalPrepareInternal()
    {
        long l1 = SystemClock.elapsedRealtime();
        boolean flag1 = true;
        for (int i = 0; i < renderers.length;)
        {
            TrackRenderer trackrenderer = renderers[i];
            boolean flag2 = flag1;
            if (trackrenderer.getState() == 0)
            {
                flag2 = flag1;
                if (trackrenderer.prepare(positionUs) == 0)
                {
                    trackrenderer.maybeThrowError();
                    flag2 = false;
                }
            }
            i++;
            flag1 = flag2;
        }

        if (!flag1)
        {
            scheduleNextOperation(2, l1, 10L);
            return;
        }
        long l3 = 0L;
        flag1 = true;
        boolean flag3 = true;
        for (int l = 0; l < renderers.length;)
        {
            TrackRenderer trackrenderer1 = renderers[l];
            int i1 = trackrenderer1.getTrackCount();
            MediaFormat amediaformat[] = new MediaFormat[i1];
            for (int j = 0; j < i1; j++)
            {
                amediaformat[j] = trackrenderer1.getFormat(j);
            }

            trackFormats[l] = amediaformat;
            boolean flag = flag3;
            long l4 = l3;
            boolean flag4 = flag1;
            if (i1 > 0)
            {
                long l2 = l3;
                if (l3 != -1L)
                {
                    l4 = trackrenderer1.getDurationUs();
                    if (l4 == -1L)
                    {
                        l2 = -1L;
                    } else
                    {
                        l2 = l3;
                        if (l4 != -2L)
                        {
                            l2 = Math.max(l3, l4);
                        }
                    }
                }
                int j1 = selectedTrackIndices[l];
                flag = flag3;
                l4 = l2;
                flag4 = flag1;
                if (j1 >= 0)
                {
                    flag = flag3;
                    l4 = l2;
                    flag4 = flag1;
                    if (j1 < amediaformat.length)
                    {
                        trackrenderer1.enable(j1, positionUs, false);
                        enabledRenderers.add(trackrenderer1);
                        if (flag1 && trackrenderer1.isEnded())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag3 && rendererReadyOrEnded(trackrenderer1))
                        {
                            flag = true;
                            l4 = l2;
                            flag4 = flag1;
                        } else
                        {
                            flag = false;
                            flag4 = flag1;
                            l4 = l2;
                        }
                    }
                }
            }
            l++;
            flag3 = flag;
            l3 = l4;
            flag1 = flag4;
        }

        durationUs = l3;
        int k;
        if (flag1 && (l3 == -1L || l3 <= positionUs))
        {
            k = 5;
        } else
        if (flag3)
        {
            k = 4;
        } else
        {
            k = 3;
        }
        state = k;
        eventHandler.obtainMessage(1, state, 0, trackFormats).sendToTarget();
        if (playWhenReady && state == 4)
        {
            startRenderers();
        }
        handler.sendEmptyMessage(7);
    }

    private void prepareInternal(TrackRenderer atrackrenderer[])
    {
        resetInternal();
        renderers = atrackrenderer;
        Arrays.fill(trackFormats, null);
        for (int i = 0; i < atrackrenderer.length; i++)
        {
            MediaClock mediaclock = atrackrenderer[i].getMediaClock();
            if (mediaclock == null)
            {
                continue;
            }
            boolean flag;
            if (rendererMediaClock == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assertions.checkState(flag);
            rendererMediaClock = mediaclock;
            rendererMediaClockSource = atrackrenderer[i];
        }

        setState(2);
        incrementalPrepareInternal();
    }

    private void release(TrackRenderer trackrenderer)
    {
        try
        {
            trackrenderer.release();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Release failed.", trackrenderer);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Release failed.", trackrenderer);
        }
    }

    private void releaseInternal()
    {
        resetInternal();
        setState(1);
        this;
        JVM INSTR monitorenter ;
        released = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean rendererReadyOrEnded(TrackRenderer trackrenderer)
    {
        if (trackrenderer.isEnded())
        {
            return true;
        }
        if (!trackrenderer.isReady())
        {
            return false;
        }
        if (state == 4)
        {
            return true;
        }
        long l1 = trackrenderer.getDurationUs();
        long l2 = trackrenderer.getBufferedPositionUs();
        long l;
        if (rebuffering)
        {
            l = minRebufferUs;
        } else
        {
            l = minBufferUs;
        }
        return l <= 0L || l2 == -1L || l2 == -3L || l2 >= positionUs + l || l1 != -1L && l1 != -2L && l2 >= l1;
    }

    private void resetInternal()
    {
        handler.removeMessages(7);
        handler.removeMessages(2);
        rebuffering = false;
        standaloneMediaClock.stop();
        if (renderers == null)
        {
            return;
        }
        for (int i = 0; i < renderers.length; i++)
        {
            TrackRenderer trackrenderer = renderers[i];
            stopAndDisable(trackrenderer);
            release(trackrenderer);
        }

        renderers = null;
        rendererMediaClock = null;
        rendererMediaClockSource = null;
        enabledRenderers.clear();
    }

    private void scheduleNextOperation(int i, long l, long l1)
    {
        l = (l + l1) - SystemClock.elapsedRealtime();
        if (l <= 0L)
        {
            handler.sendEmptyMessage(i);
            return;
        } else
        {
            handler.sendEmptyMessageDelayed(i, l);
            return;
        }
    }

    private void seekToInternal(long l)
    {
        if (l != positionUs / 1000L)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        eventHandler.sendEmptyMessage(1000);
        pendingSeekCount.decrementAndGet();
        return;
        int i;
        rebuffering = false;
        positionUs = 1000L * l;
        standaloneMediaClock.stop();
        standaloneMediaClock.setPositionUs(positionUs);
        if (state == 1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        i = state;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        pendingSeekCount.decrementAndGet();
        return;
        i = 0;
_L2:
        if (i >= enabledRenderers.size())
        {
            break; /* Loop/switch isn't completed */
        }
        TrackRenderer trackrenderer = (TrackRenderer)enabledRenderers.get(i);
        ensureStopped(trackrenderer);
        trackrenderer.seekTo(positionUs);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        pendingSeek = true;
        setState(3);
        handler.sendEmptyMessage(7);
        pendingSeekCount.decrementAndGet();
        return;
        Exception exception;
        exception;
        pendingSeekCount.decrementAndGet();
        throw exception;
    }

    private void sendMessageInternal(int i, Object obj)
    {
        obj = (Pair)obj;
        ((ExoPlayer.ExoPlayerComponent)((Pair) (obj)).first).handleMessage(i, ((Pair) (obj)).second);
        if (state != 1 && state != 2)
        {
            handler.sendEmptyMessage(7);
        }
        this;
        JVM INSTR monitorenter ;
        customMessagesProcessed = customMessagesProcessed + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
        obj;
        this;
        JVM INSTR monitorenter ;
        customMessagesProcessed = customMessagesProcessed + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        throw obj;
    }

    private void setPlayWhenReadyInternal(boolean flag)
    {
        rebuffering = false;
        playWhenReady = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        stopRenderers();
        updatePositionUs();
        break MISSING_BLOCK_LABEL_68;
        if (state == 4)
        {
            startRenderers();
            handler.sendEmptyMessage(7);
            break MISSING_BLOCK_LABEL_68;
        }
        if (state == 3)
        {
            handler.sendEmptyMessage(7);
        }
        eventHandler.obtainMessage(3).sendToTarget();
        return;
        Exception exception;
        exception;
        eventHandler.obtainMessage(3).sendToTarget();
        throw exception;
    }

    private void setRendererSelectedTrackInternal(int i, int j)
    {
        if (selectedTrackIndices[i] == j)
        {
            return;
        }
        selectedTrackIndices[i] = j;
        if (state == 1 || state == 2)
        {
            return;
        }
        TrackRenderer trackrenderer = renderers[i];
        int k = trackrenderer.getState();
        if (k == 0 || k == -1 || trackrenderer.getTrackCount() == 0)
        {
            return;
        }
        boolean flag;
        if (k == 2 || k == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j >= 0 && j < trackFormats[i].length)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag)
        {
            if (i == 0 && trackrenderer == rendererMediaClockSource)
            {
                standaloneMediaClock.setPositionUs(rendererMediaClock.getPositionUs());
            }
            ensureStopped(trackrenderer);
            enabledRenderers.remove(trackrenderer);
            trackrenderer.disable();
        }
        if (i != 0)
        {
            boolean flag1;
            if (playWhenReady && state == 4)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            trackrenderer.enable(j, positionUs, flag1);
            enabledRenderers.add(trackrenderer);
            if (flag1)
            {
                trackrenderer.start();
            }
            handler.sendEmptyMessage(7);
        }
    }

    private void setState(int i)
    {
        if (state != i)
        {
            state = i;
            eventHandler.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void startRenderers()
    {
        rebuffering = false;
        standaloneMediaClock.start();
        for (int i = 0; i < enabledRenderers.size(); i++)
        {
            ((TrackRenderer)enabledRenderers.get(i)).start();
        }

    }

    private void stopAndDisable(TrackRenderer trackrenderer)
    {
        try
        {
            ensureStopped(trackrenderer);
            if (trackrenderer.getState() == 2)
            {
                trackrenderer.disable();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Stop failed.", trackrenderer);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Stop failed.", trackrenderer);
        }
    }

    private void stopInternal()
    {
        resetInternal();
        setState(1);
    }

    private void stopRenderers()
    {
        standaloneMediaClock.stop();
        for (int i = 0; i < enabledRenderers.size(); i++)
        {
            ensureStopped((TrackRenderer)enabledRenderers.get(i));
        }

    }

    private void updatePositionUs()
    {
        if (rendererMediaClock != null && enabledRenderers.contains(rendererMediaClockSource) && !rendererMediaClockSource.isEnded())
        {
            positionUs = rendererMediaClock.getPositionUs();
            standaloneMediaClock.setPositionUs(positionUs);
        } else
        {
            positionUs = standaloneMediaClock.getPositionUs();
        }
        elapsedRealtimeUs = SystemClock.elapsedRealtime() * 1000L;
    }

    public final void blockingSendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!released)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Log.w("ExoPlayerImplInternal", (new StringBuilder("Sent message(")).append(i).append(") after release. Message ignored.").toString());
        this;
        JVM INSTR monitorexit ;
        return;
        int j;
        j = customMessagesSent;
        customMessagesSent = j + 1;
        handler.obtainMessage(9, i, 0, Pair.create(exoplayercomponent, obj)).sendToTarget();
_L3:
        i = customMessagesProcessed;
        if (i > j) goto _L2; else goto _L1
_L1:
        wait();
          goto _L3
_L4:
        Thread.currentThread().interrupt();
          goto _L3
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        exoplayercomponent;
        throw exoplayercomponent;
        exoplayercomponent;
          goto _L4
    }

    public final long getBufferedPosition()
    {
        if (bufferedPositionUs == -1L)
        {
            return -1L;
        } else
        {
            return bufferedPositionUs / 1000L;
        }
    }

    public final long getCurrentPosition()
    {
        if (pendingSeekCount.get() > 0)
        {
            return lastSeekPositionMs;
        } else
        {
            return positionUs / 1000L;
        }
    }

    public final long getDuration()
    {
        if (durationUs == -1L)
        {
            return -1L;
        } else
        {
            return durationUs / 1000L;
        }
    }

    public final Looper getPlaybackLooper()
    {
        return internalPlaybackThread.getLooper();
    }

    public final boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 9: default 225
    //                   1 56
    //                   2 69
    //                   3 75
    //                   4 117
    //                   5 123
    //                   6 100
    //                   7 94
    //                   8 143
    //                   9 129;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        prepareInternal((TrackRenderer[])message.obj);
        return true;
_L3:
        boolean flag;
        try
        {
            incrementalPrepareInternal();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", message);
            eventHandler.obtainMessage(4, message).sendToTarget();
            stopInternal();
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", message);
            eventHandler.obtainMessage(4, new ExoPlaybackException(message, true)).sendToTarget();
            stopInternal();
            return true;
        }
        return true;
_L4:
        if (message.arg1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setPlayWhenReadyInternal(flag);
        return true;
_L8:
        doSomeWork();
        return true;
_L7:
        seekToInternal(Util.getLong(message.arg1, message.arg2));
        return true;
_L5:
        stopInternal();
        return true;
_L6:
        releaseInternal();
        return true;
_L10:
        sendMessageInternal(message.arg1, message.obj);
        return true;
_L9:
        setRendererSelectedTrackInternal(message.arg1, message.arg2);
        return true;
_L1:
        return false;
    }

    public final transient void prepare(TrackRenderer atrackrenderer[])
    {
        handler.obtainMessage(1, atrackrenderer).sendToTarget();
    }

    public final void release()
    {
        this;
        JVM INSTR monitorenter ;
        if (!released)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        handler.sendEmptyMessage(5);
_L3:
        boolean flag = released;
        if (flag) goto _L2; else goto _L1
_L1:
        wait();
          goto _L3
_L4:
        Thread.currentThread().interrupt();
          goto _L3
_L2:
        internalPlaybackThread.quit();
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        throw obj;
        obj;
          goto _L4
    }

    public final void seekTo(long l)
    {
        lastSeekPositionMs = l;
        pendingSeekCount.incrementAndGet();
        handler.obtainMessage(6, Util.getTopInt(l), Util.getBottomInt(l)).sendToTarget();
    }

    public final void sendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        customMessagesSent = customMessagesSent + 1;
        handler.obtainMessage(9, i, 0, Pair.create(exoplayercomponent, obj)).sendToTarget();
    }

    public final void setPlayWhenReady(boolean flag)
    {
        Handler handler1 = handler;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        handler1.obtainMessage(3, i, 0).sendToTarget();
    }

    public final void setRendererSelectedTrack(int i, int j)
    {
        handler.obtainMessage(8, i, j).sendToTarget();
    }

    public final void stop()
    {
        handler.sendEmptyMessage(4);
    }
}
