// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioCapabilities;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorSampleSource;
import com.google.android.exoplayer.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer.text.SubtitleParser;
import com.google.android.exoplayer.text.TextTrackRenderer;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;

// Referenced classes of package o:
//            aad

public final class aab
    implements aad.aux
{

    private final Context context;
    private final Extractor extractor;
    private final Uri uri;
    private final String userAgent;

    public aab(Context context1, String s, Uri uri1, Mp4Extractor mp4extractor)
    {
        context = context1;
        userAgent = s;
        uri = uri1;
        extractor = mp4extractor;
    }

    public final void cancel()
    {
    }

    public final void _mth02CA(aad aad1)
    {
        Object obj = new DefaultAllocator(0xa00000);
        DefaultBandwidthMeter defaultbandwidthmeter = new DefaultBandwidthMeter(aad1.jT, null);
        Object obj1 = new DefaultUriDataSource(context, defaultbandwidthmeter, userAgent, true);
        Object obj2 = new ExtractorSampleSource(uri, ((com.google.android.exoplayer.upstream.DataSource) (obj1)), ((com.google.android.exoplayer.upstream.Allocator) (obj)), 0xa00000, new Extractor[] {
            extractor
        });
        obj = new MediaCodecVideoTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj2)), null, true, 1, 5000L, null, aad1.jT, aad1, 50);
        obj1 = new MediaCodecAudioTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj2)), null, true, aad1.jT, aad1, AudioCapabilities.getCapabilities(context));
        obj2 = new TextTrackRenderer(((com.google.android.exoplayer.SampleSource) (obj2)), aad1, aad1.jT.getLooper(), new SubtitleParser[0]);
        TrackRenderer atrackrenderer[] = new TrackRenderer[4];
        atrackrenderer[0] = ((TrackRenderer) (obj));
        atrackrenderer[1] = ((TrackRenderer) (obj1));
        atrackrenderer[2] = ((TrackRenderer) (obj2));
        aad1._mth02CA(atrackrenderer, defaultbandwidthmeter);
    }
}
