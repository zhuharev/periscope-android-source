// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer.DefaultLoadControl;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.chunk.VideoFormatSelectorUtil;
import com.google.android.exoplayer.hls.HlsChunkSource;
import com.google.android.exoplayer.hls.HlsMasterPlaylist;
import com.google.android.exoplayer.hls.HlsPlaylist;
import com.google.android.exoplayer.hls.HlsPlaylistParser;
import com.google.android.exoplayer.hls.HlsSampleSource;
import com.google.android.exoplayer.metadata.Id3Parser;
import com.google.android.exoplayer.metadata.MetadataTrackRenderer;
import com.google.android.exoplayer.text.eia608.Eia608TrackRenderer;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.util.ManifestFetcher;
import java.io.IOException;

// Referenced classes of package o:
//            aad

public final class aac
    implements aad.aux
{
    static final class if
        implements com.google.android.exoplayer.util.ManifestFetcher.ManifestCallback
    {

        final aad aYY;
        final ManifestFetcher aYZ;
        boolean canceled;
        private final Context context;
        private final String url;
        private final String userAgent;

        public final void onSingleManifest(Object obj)
        {
            Object obj2 = (HlsPlaylist)obj;
            if (!canceled)
            {
                Object obj1 = aYY.jT;
                Object obj3 = new DefaultLoadControl(new DefaultAllocator(0x10000));
                DefaultBandwidthMeter defaultbandwidthmeter = new DefaultBandwidthMeter();
                int ai[] = null;
                if (obj2 instanceof HlsMasterPlaylist)
                {
                    obj = (HlsMasterPlaylist)obj2;
                    try
                    {
                        obj = VideoFormatSelectorUtil.selectVideoFormatsForDefaultDisplay(context, ((HlsMasterPlaylist) (obj)).variants, null, false);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        aYY._mth141D(((Exception) (obj)));
                        return;
                    }
                    ai = ((int []) (obj));
                    if (obj.length == 0)
                    {
                        aYY._mth141D(new IllegalStateException("No variants selected."));
                        return;
                    }
                }
                obj3 = new HlsSampleSource(new HlsChunkSource(new DefaultUriDataSource(context, defaultbandwidthmeter, userAgent, true), url, ((HlsPlaylist) (obj2)), defaultbandwidthmeter, ai, 1), ((com.google.android.exoplayer.LoadControl) (obj3)), 0x1000000, ((Handler) (obj1)), aYY, 0);
                obj = new MediaCodecVideoTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj3)), 1, 5000L, ((Handler) (obj1)), aYY, 50);
                MediaCodecAudioTrackRenderer mediacodecaudiotrackrenderer = new MediaCodecAudioTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj3)), null, true, aYY.jT, aYY, AudioCapabilities.getCapabilities(context));
                obj2 = new MetadataTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj3)), new Id3Parser(), aYY, ((Handler) (obj1)).getLooper());
                obj1 = new Eia608TrackRenderer(((com.google.android.exoplayer.SampleSource) (obj3)), aYY, ((Handler) (obj1)).getLooper());
                aYY._mth02CA(new TrackRenderer[] {
                    obj, mediacodecaudiotrackrenderer, obj1, obj2
                }, defaultbandwidthmeter);
            }
        }

        public final void onSingleManifestError(IOException ioexception)
        {
            if (canceled)
            {
                return;
            } else
            {
                aYY._mth141D(ioexception);
                return;
            }
        }

        public if(Context context1, String s, String s1, aad aad1)
        {
            context = context1;
            userAgent = s;
            url = s1;
            aYY = aad1;
            aad1 = new HlsPlaylistParser();
            aYZ = new ManifestFetcher(s1, new DefaultUriDataSource(context1, null, s, true), aad1);
        }
    }


    private if aYX;
    private final Context context;
    private final String url;
    private final String userAgent;

    public aac(Context context1, String s, String s1)
    {
        context = context1;
        userAgent = s;
        url = s1;
    }

    public final void cancel()
    {
        if (aYX != null)
        {
            aYX.canceled = true;
            aYX = null;
        }
    }

    public final void _mth02CA(aad aad1)
    {
        aYX = new if(context, userAgent, url, aad1);
        aad1 = aYX;
        ((if) (aad1)).aYZ.singleLoad(((if) (aad1)).aYY.jT.getLooper(), aad1);
    }
}
