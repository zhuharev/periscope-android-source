// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import android.content.Context;
import com.google.android.exoplayer.chunk.VideoFormatSelectorUtil;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingTrackSelector, SmoothStreamingManifest

public final class DefaultSmoothStreamingTrackSelector
    implements SmoothStreamingTrackSelector
{

    private final Context context;
    private final int streamElementType;

    public DefaultSmoothStreamingTrackSelector(Context context1, int i)
    {
        context = context1;
        streamElementType = i;
    }

    public final void selectTracks(SmoothStreamingManifest smoothstreamingmanifest, SmoothStreamingTrackSelector.Output output)
    {
        for (int i = 0; i < smoothstreamingmanifest.streamElements.length; i++)
        {
            if (smoothstreamingmanifest.streamElements[i].type != streamElementType)
            {
                continue;
            }
            if (streamElementType == 1)
            {
                int ai[] = VideoFormatSelectorUtil.selectVideoFormatsForDefaultDisplay(context, Arrays.asList(smoothstreamingmanifest.streamElements[i].tracks), null, false);
                int l = ai.length;
                if (l > 1)
                {
                    output.adaptiveTrack(smoothstreamingmanifest, i, ai);
                }
                for (int j = 0; j < l; j++)
                {
                    output.fixedTrack(smoothstreamingmanifest, i, ai[j]);
                }

                continue;
            }
            for (int k = 0; k < smoothstreamingmanifest.streamElements[i].tracks.length; k++)
            {
                output.fixedTrack(smoothstreamingmanifest, i, k);
            }

        }

    }
}
