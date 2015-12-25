// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.google.android.exoplayer:
//            ExoPlayer, ExoPlayerImplInternal, ExoPlaybackException, MediaFormat, 
//            TrackRenderer

final class ExoPlayerImpl
    implements ExoPlayer
{

    private static final String TAG = "ExoPlayerImpl";
    private final Handler eventHandler = new _cls1();
    private final ExoPlayerImplInternal internalPlayer;
    private final CopyOnWriteArraySet listeners = new CopyOnWriteArraySet();
    private int pendingPlayWhenReadyAcks;
    private boolean playWhenReady;
    private int playbackState;
    private final int selectedTrackIndices[];
    private final MediaFormat trackFormats[][];

    public ExoPlayerImpl(int i, int j, int k)
    {
        Log.i("ExoPlayerImpl", "Init 1.5.0");
        playWhenReady = false;
        playbackState = 1;
        trackFormats = new MediaFormat[i][];
        selectedTrackIndices = new int[i];
        internalPlayer = new ExoPlayerImplInternal(eventHandler, playWhenReady, selectedTrackIndices, j, k);
    }

    public final void addListener(ExoPlayer.Listener listener)
    {
        listeners.add(listener);
    }

    public final void blockingSendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        internalPlayer.blockingSendMessage(exoplayercomponent, i, obj);
    }

    public final int getBufferedPercentage()
    {
        long l = getBufferedPosition();
        long l1 = getDuration();
        if (l == -1L || l1 == -1L)
        {
            return 0;
        }
        if (l1 == 0L)
        {
            l = 100L;
        } else
        {
            l = (100L * l) / l1;
        }
        return (int)l;
    }

    public final long getBufferedPosition()
    {
        return internalPlayer.getBufferedPosition();
    }

    public final long getCurrentPosition()
    {
        return internalPlayer.getCurrentPosition();
    }

    public final long getDuration()
    {
        return internalPlayer.getDuration();
    }

    public final boolean getPlayWhenReady()
    {
        return playWhenReady;
    }

    public final Looper getPlaybackLooper()
    {
        return internalPlayer.getPlaybackLooper();
    }

    public final int getPlaybackState()
    {
        return playbackState;
    }

    public final boolean getRendererEnabled(int i)
    {
        return getSelectedTrack(i) >= 0;
    }

    public final boolean getRendererHasMedia(int i)
    {
        return getTrackCount(i) > 0;
    }

    public final int getSelectedTrack(int i)
    {
        return selectedTrackIndices[i];
    }

    public final int getTrackCount(int i)
    {
        if (trackFormats[i] != null)
        {
            return trackFormats[i].length;
        } else
        {
            return 0;
        }
    }

    public final MediaFormat getTrackFormat(int i, int j)
    {
        return trackFormats[i][j];
    }

    final void handleEvent(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            System.arraycopy(message.obj, 0, trackFormats, 0, trackFormats.length);
            playbackState = message.arg1;
            for (message = listeners.iterator(); message.hasNext(); ((ExoPlayer.Listener)message.next()).onPlayerStateChanged(playWhenReady, playbackState)) { }
            return;

        case 2: // '\002'
            playbackState = message.arg1;
            for (message = listeners.iterator(); message.hasNext(); ((ExoPlayer.Listener)message.next()).onPlayerStateChanged(playWhenReady, playbackState)) { }
            return;

        case 3: // '\003'
            pendingPlayWhenReadyAcks = pendingPlayWhenReadyAcks - 1;
            if (pendingPlayWhenReadyAcks == 0)
            {
                for (message = listeners.iterator(); message.hasNext(); ((ExoPlayer.Listener)message.next()).onPlayWhenReadyCommitted()) { }
                return;
            }
            break;

        case 4: // '\004'
            message = (ExoPlaybackException)message.obj;
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((ExoPlayer.Listener)iterator.next()).onPlayerError(message)) { }
            return;

        case 1000: 
            for (message = listeners.iterator(); message.hasNext(); ((ExoPlayer.Listener)message.next()).onPlayerSeekComplete()) { }
            break;
        }
    }

    public final boolean isPlayWhenReadyCommitted()
    {
        return pendingPlayWhenReadyAcks == 0;
    }

    public final transient void prepare(TrackRenderer atrackrenderer[])
    {
        Arrays.fill(trackFormats, null);
        internalPlayer.prepare(atrackrenderer);
    }

    public final void release()
    {
        internalPlayer.release();
        eventHandler.removeCallbacksAndMessages(null);
    }

    public final void removeListener(ExoPlayer.Listener listener)
    {
        listeners.remove(listener);
    }

    public final void seekTo(long l)
    {
        internalPlayer.seekTo(l);
    }

    public final void sendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        internalPlayer.sendMessage(exoplayercomponent, i, obj);
    }

    public final void setPlayWhenReady(boolean flag)
    {
        if (playWhenReady != flag)
        {
            playWhenReady = flag;
            pendingPlayWhenReadyAcks = pendingPlayWhenReadyAcks + 1;
            internalPlayer.setPlayWhenReady(flag);
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((ExoPlayer.Listener)iterator.next()).onPlayerStateChanged(flag, playbackState)) { }
        }
    }

    public final void setRendererEnabled(int i, boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = -1;
        }
        setSelectedTrack(i, byte0);
    }

    public final void setSelectedTrack(int i, int j)
    {
        if (selectedTrackIndices[i] != j)
        {
            selectedTrackIndices[i] = j;
            internalPlayer.setRendererSelectedTrack(i, j);
        }
    }

    public final void stop()
    {
        internalPlayer.stop();
    }

    private class _cls1 extends Handler
    {

        final ExoPlayerImpl this$0;

        public void handleMessage(Message message)
        {
            handleEvent(message);
        }

        _cls1()
        {
            this$0 = ExoPlayerImpl.this;
            super();
        }
    }

}
