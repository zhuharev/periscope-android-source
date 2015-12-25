// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import com.google.android.exoplayer.ExoPlayer;

public class PlayerControl
    implements android.widget.MediaController.MediaPlayerControl
{

    private final ExoPlayer exoPlayer;

    public PlayerControl(ExoPlayer exoplayer)
    {
        exoPlayer = exoplayer;
    }

    public boolean canPause()
    {
        return true;
    }

    public boolean canSeekBackward()
    {
        return true;
    }

    public boolean canSeekForward()
    {
        return true;
    }

    public int getAudioSessionId()
    {
        throw new UnsupportedOperationException();
    }

    public int getBufferPercentage()
    {
        return exoPlayer.getBufferedPercentage();
    }

    public int getCurrentPosition()
    {
        if (exoPlayer.getDuration() == -1L)
        {
            return 0;
        } else
        {
            return (int)exoPlayer.getCurrentPosition();
        }
    }

    public int getDuration()
    {
        if (exoPlayer.getDuration() == -1L)
        {
            return 0;
        } else
        {
            return (int)exoPlayer.getDuration();
        }
    }

    public boolean isPlaying()
    {
        return exoPlayer.getPlayWhenReady();
    }

    public void pause()
    {
        exoPlayer.setPlayWhenReady(false);
    }

    public void seekTo(int i)
    {
        long l;
        if (exoPlayer.getDuration() == -1L)
        {
            l = 0L;
        } else
        {
            l = Math.min(Math.max(0, i), getDuration());
        }
        exoPlayer.seekTo(l);
    }

    public void start()
    {
        exoPlayer.setPlayWhenReady(true);
    }
}
