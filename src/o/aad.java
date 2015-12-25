// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer.CodecCounters;
import com.google.android.exoplayer.DummyTrackRenderer;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecTrackRenderer;
import com.google.android.exoplayer.TimeRange;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.text.TextRenderer;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer.util.PlayerControl;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class aad
    implements com.google.android.exoplayer.ExoPlayer.Listener, com.google.android.exoplayer.chunk.ChunkSampleSource.EventListener, com.google.android.exoplayer.hls.HlsSampleSource.EventListener, com.google.android.exoplayer.upstream.BandwidthMeter.EventListener, com.google.android.exoplayer.MediaCodecVideoTrackRenderer.EventListener, com.google.android.exoplayer.MediaCodecAudioTrackRenderer.EventListener, com.google.android.exoplayer.drm.StreamingDrmSessionManager.EventListener, com.google.android.exoplayer.dash.DashChunkSource.EventListener, TextRenderer, com.google.android.exoplayer.metadata.MetadataTrackRenderer.MetadataRenderer, com.google.android.exoplayer.util.DebugTextViewHelper.Provider
{
    public static interface aux
    {

        public abstract void cancel();

        public abstract void _mth02CA(aad aad1);
    }

    public static interface if
    {
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}

    /* member class not found */
    class _cls02CF {}


    public final aux aZa;
    public final ExoPlayer aZb = com.google.android.exoplayer.ExoPlayer.Factory.newInstance(4, 1000, 5000);
    private final PlayerControl aZc;
    public final CopyOnWriteArrayList aZd = new CopyOnWriteArrayList();
    public int aZe;
    private int aZf;
    private boolean aZg;
    public TrackRenderer aZh;
    private Format aZi;
    public if aZj;
    public _cls02CA aZk;
    public _cls02CE aZl;
    public _cls02CB aZm;
    private BandwidthMeter bandwidthMeter;
    private CodecCounters codecCounters;
    final Handler jT = new Handler();
    public Surface surface;

    public aad(aux aux1)
    {
        aZa = aux1;
        aZb.addListener(this);
        aZc = new PlayerControl(aZb);
        aZf = 1;
        aZe = 1;
        aZb.setSelectedTrack(2, -1);
    }

    private void N()
    {
        boolean flag = aZb.getPlayWhenReady();
        int i = getPlaybackState();
        if (aZg != flag || aZf != i)
        {
            for (Iterator iterator = aZd.iterator(); iterator.hasNext(); ((_cls02CF)iterator.next())._mth02CB(flag, i)) { }
            aZg = flag;
            aZf = i;
        }
    }

    public final BandwidthMeter getBandwidthMeter()
    {
        return bandwidthMeter;
    }

    public final CodecCounters getCodecCounters()
    {
        return codecCounters;
    }

    public final long getCurrentPosition()
    {
        return aZb.getCurrentPosition();
    }

    public final Format getFormat()
    {
        return aZi;
    }

    public final int getPlaybackState()
    {
        if (aZe == 2)
        {
            return 2;
        }
        int i = aZb.getPlaybackState();
        if (aZe == 3 && i == 1)
        {
            return 2;
        } else
        {
            return i;
        }
    }

    public final void onAudioTrackInitializationError(com.google.android.exoplayer.audio.AudioTrack.InitializationException initializationexception)
    {
        if (aZl != null)
        {
            aZl.onAudioTrackInitializationError(initializationexception);
        }
    }

    public final void onAudioTrackWriteError(com.google.android.exoplayer.audio.AudioTrack.WriteException writeexception)
    {
        if (aZl != null)
        {
            aZl.onAudioTrackWriteError(writeexception);
        }
    }

    public final void onAvailableRangeChanged(TimeRange timerange)
    {
        if (aZm != null)
        {
            aZm.onAvailableRangeChanged(timerange);
        }
    }

    public final void onBandwidthSample(int i, long l, long l1)
    {
        if (aZm != null)
        {
            aZm.onBandwidthSample(i, l, l1);
        }
    }

    public final void onCryptoError(android.media.MediaCodec.CryptoException cryptoexception)
    {
        if (aZl != null)
        {
            aZl.onCryptoError(cryptoexception);
        }
    }

    public final void onCues(List list)
    {
        if (aZj != null)
        {
            aZb.getSelectedTrack(2);
        }
    }

    public final void onDecoderInitializationError(com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException decoderinitializationexception)
    {
        if (aZl != null)
        {
            aZl.onDecoderInitializationError(decoderinitializationexception);
        }
    }

    public final void onDecoderInitialized(String s, long l, long l1)
    {
        if (aZm != null)
        {
            aZm.M();
        }
    }

    public final void onDownstreamFormatChanged(int i, Format format, int j, long l)
    {
        if (aZm == null)
        {
            return;
        }
        if (i == 0)
        {
            aZi = format;
            aZm._mth02CA(format, j);
            return;
        }
        if (i == 1)
        {
            aZm._mth02CB(format, j);
        }
    }

    public final void onDrawnToSurface(Surface surface1)
    {
    }

    public final void onDrmKeysLoaded()
    {
    }

    public final void onDrmSessionManagerError(Exception exception)
    {
        if (aZl != null)
        {
            aZl.onDrmSessionManagerError(exception);
        }
    }

    public final void onDroppedFrames(int i, long l)
    {
        if (aZm != null)
        {
            aZm._mth1ECA(i);
        }
    }

    public final void onLoadCanceled(int i, long l)
    {
    }

    public final void onLoadCompleted(int i, long l, int j, int k, Format format, long l1, long l2, long l3, long l4)
    {
        if (aZm != null)
        {
            aZm._mth1ECB(i);
        }
    }

    public final void onLoadError(int i, IOException ioexception)
    {
        if (aZl != null)
        {
            aZl._mth02CA(ioexception);
        }
    }

    public final void onLoadStarted(int i, long l, int j, int k, Format format, long l1, long l2)
    {
        if (aZm != null)
        {
            aZm._mth02CA(i, j, l1, l2);
        }
    }

    public final void onMetadata(Object obj)
    {
        obj = (Map)obj;
        if (aZk != null && aZb.getSelectedTrack(3) != -1)
        {
            aZk._mth02CF(((Map) (obj)));
        }
    }

    public final void onPlayWhenReadyCommitted()
    {
    }

    public final void onPlayerError(ExoPlaybackException exoplaybackexception)
    {
        aZe = 1;
        for (Iterator iterator = aZd.iterator(); iterator.hasNext(); ((_cls02CF)iterator.next()).onError(exoplaybackexception)) { }
    }

    public final void onPlayerSeekComplete()
    {
        for (Iterator iterator = aZd.iterator(); iterator.hasNext(); ((_cls02CF)iterator.next()).onPlayerSeekComplete()) { }
    }

    public final void onPlayerStateChanged(boolean flag, int i)
    {
        N();
    }

    public final void onUpstreamDiscarded(int i, long l, long l1)
    {
    }

    public final void onVideoSizeChanged(int i, int j, int k, float f)
    {
        for (Iterator iterator = aZd.iterator(); iterator.hasNext(); ((_cls02CF)iterator.next())._mth02CA(i, j, f)) { }
    }

    public final void prepare()
    {
        if (aZe == 3)
        {
            aZb.stop();
        }
        aZa.cancel();
        aZi = null;
        aZh = null;
        aZe = 2;
        N();
        aZa._mth02CA(this);
    }

    final void _mth02CA(TrackRenderer atrackrenderer[], DefaultBandwidthMeter defaultbandwidthmeter)
    {
        for (int i = 0; i < 4; i++)
        {
            if (atrackrenderer[i] == null)
            {
                atrackrenderer[i] = new DummyTrackRenderer();
            }
        }

        aZh = atrackrenderer[0];
        CodecCounters codeccounters;
        if (aZh instanceof MediaCodecTrackRenderer)
        {
            codeccounters = ((MediaCodecTrackRenderer)aZh).codecCounters;
        } else
        if (atrackrenderer[1] instanceof MediaCodecTrackRenderer)
        {
            codeccounters = ((MediaCodecTrackRenderer)atrackrenderer[1]).codecCounters;
        } else
        {
            codeccounters = null;
        }
        codecCounters = codeccounters;
        bandwidthMeter = defaultbandwidthmeter;
        if (aZh != null)
        {
            aZb.sendMessage(aZh, 1, surface);
        }
        aZb.prepare(atrackrenderer);
        aZe = 3;
    }

    final void _mth141D(Exception exception)
    {
        if (aZl != null)
        {
            aZl._mth02CF(exception);
        }
        for (Iterator iterator = aZd.iterator(); iterator.hasNext(); ((_cls02CF)iterator.next()).onError(exception)) { }
        aZe = 1;
        N();
    }
}
