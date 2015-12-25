// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import android.content.Context;
import com.google.android.exoplayer.chunk.VideoFormatSelectorUtil;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashTrackSelector

public final class DefaultDashTrackSelector
    implements DashTrackSelector
{

    private final int adaptationSetType;
    private final Context context;
    private final boolean filterProtectedHdContent;
    private final boolean filterVideoRepresentations;

    private DefaultDashTrackSelector(int i, Context context1, boolean flag, boolean flag1)
    {
        adaptationSetType = i;
        context = context1;
        filterVideoRepresentations = flag;
        filterProtectedHdContent = flag1;
    }

    public static DefaultDashTrackSelector newAudioInstance()
    {
        return new DefaultDashTrackSelector(1, null, false, false);
    }

    public static DefaultDashTrackSelector newTextInstance()
    {
        return new DefaultDashTrackSelector(2, null, false, false);
    }

    public static DefaultDashTrackSelector newVideoInstance(Context context1, boolean flag, boolean flag1)
    {
        return new DefaultDashTrackSelector(0, context1, flag, flag1);
    }

    public final void selectTracks(MediaPresentationDescription mediapresentationdescription, int i, DashTrackSelector.Output output)
    {
        Period period = mediapresentationdescription.getPeriod(i);
        for (int j = 0; j < period.adaptationSets.size(); j++)
        {
            int ai[] = (AdaptationSet)period.adaptationSets.get(j);
            if (((AdaptationSet) (ai)).type != adaptationSetType)
            {
                continue;
            }
            if (adaptationSetType == 0)
            {
                if (filterVideoRepresentations)
                {
                    Context context1 = context;
                    List list = ((AdaptationSet) (ai)).representations;
                    boolean flag;
                    if (filterProtectedHdContent && ai.hasContentProtection())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ai = VideoFormatSelectorUtil.selectVideoFormatsForDefaultDisplay(context1, list, null, flag);
                } else
                {
                    ai = Util.firstIntegersArray(((AdaptationSet) (ai)).representations.size());
                }
                int i1 = ai.length;
                if (i1 > 1)
                {
                    output.adaptiveTrack(mediapresentationdescription, i, j, ai);
                }
                for (int k = 0; k < i1; k++)
                {
                    output.fixedTrack(mediapresentationdescription, i, j, ai[k]);
                }

                continue;
            }
            for (int l = 0; l < ((AdaptationSet) (ai)).representations.size(); l++)
            {
                output.fixedTrack(mediapresentationdescription, i, j, l);
            }

        }

    }
}
