// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.ContentProtection;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.dash.mpd.Representation;
import com.google.android.exoplayer.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashChunkSource, DashSegmentIndex

static final class representationIndices
{

    private long availableEndTimeUs;
    private long availableStartTimeUs;
    private DrmInitData drmInitData;
    private boolean indexIsExplicit;
    private boolean indexIsUnbounded;
    public final int localIndex;
    public final HashMap representationHolders = new HashMap();
    private final int representationIndices[];
    public final long startTimeUs;

    private static DrmInitData getDrmInitData(AdaptationSet adaptationset)
    {
        String s;
        if (DashChunkSource.mimeTypeIsWebm(((Representation)adaptationset.representations.get(0)).format.mimeType))
        {
            s = "video/webm";
        } else
        {
            s = "video/mp4";
        }
        if (adaptationset.contentProtections.isEmpty())
        {
            return null;
        }
        com.google.android.exoplayer.drm.  = null;
        for (int i = 0; i < adaptationset.contentProtections.size();)
        {
            ContentProtection contentprotection = (ContentProtection)adaptationset.contentProtections.get(i);
            com.google.android.exoplayer.drm. 1 = ;
            if (contentprotection.uuid != null)
            {
                1 = ;
                if (contentprotection.data != null)
                {
                    1 = ;
                    if ( == null)
                    {
                        1 = new com.google.android.exoplayer.drm.tections(s);
                    }
                    1.tections(contentprotection.uuid, contentprotection.data);
                }
            }
            i++;
             = 1;
        }

        return ;
    }

    private static long getPeriodDurationUs(MediaPresentationDescription mediapresentationdescription, int i)
    {
        long l = mediapresentationdescription.getPeriodDuration(i);
        if (l == -1L)
        {
            return -1L;
        } else
        {
            return 1000L * l;
        }
    }

    private static int getRepresentationIndex(List list, String s)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (s.equals(((Representation)list.get(i)).format.id))
            {
                return i;
            }
        }

        throw new IllegalStateException((new StringBuilder("Missing format id: ")).append(s).toString());
    }

    private void updateRepresentationIndependentProperties(long l, Representation representation)
    {
        representation = representation.getIndex();
        if (representation != null)
        {
            int i = representation.getFirstSegmentNum();
            int j = representation.getLastSegmentNum(l);
            boolean flag;
            if (j == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            indexIsUnbounded = flag;
            indexIsExplicit = representation.isExplicit();
            availableStartTimeUs = startTimeUs + representation.getTimeUs(i);
            if (!indexIsUnbounded)
            {
                availableEndTimeUs = startTimeUs + representation.getTimeUs(j) + representation.getDurationUs(j, l);
            }
            return;
        } else
        {
            indexIsUnbounded = false;
            indexIsExplicit = true;
            availableStartTimeUs = startTimeUs;
            availableEndTimeUs = startTimeUs + l;
            return;
        }
    }

    public final long getAvailableEndTimeUs()
    {
        if (isIndexUnbounded())
        {
            throw new IllegalStateException("Period has unbounded index");
        } else
        {
            return availableEndTimeUs;
        }
    }

    public final long getAvailableStartTimeUs()
    {
        return availableStartTimeUs;
    }

    public final boolean isIndexExplicit()
    {
        return indexIsExplicit;
    }

    public final boolean isIndexUnbounded()
    {
        return indexIsUnbounded;
    }

    public final void updatePeriod(MediaPresentationDescription mediapresentationdescription, int i, ion ion)
    {
        Period period = mediapresentationdescription.getPeriod(i);
        long l = getPeriodDurationUs(mediapresentationdescription, i);
        mediapresentationdescription = ((AdaptationSet)period.adaptationSets.get(access._mth600(ion))).representations;
        for (i = 0; i < representationIndices.length; i++)
        {
            ion = (Representation)mediapresentationdescription.get(representationIndices[i]);
            ((nHolder)representationHolders.get(((Representation) (ion)).format.id)).updateRepresentation(l, ion);
        }

        updateRepresentationIndependentProperties(l, (Representation)mediapresentationdescription.get(representationIndices[0]));
    }



/*
    static DrmInitData access$202(ion ion, DrmInitData drminitdata)
    {
        ion.drmInitData = drminitdata;
        return drminitdata;
    }

*/

    public nHolder(int i, MediaPresentationDescription mediapresentationdescription, int j, ion ion)
    {
        localIndex = i;
        Period period = mediapresentationdescription.getPeriod(j);
        long l = getPeriodDurationUs(mediapresentationdescription, j);
        AdaptationSet adaptationset = (AdaptationSet)period.adaptationSets.get(access._mth600(ion));
        mediapresentationdescription = adaptationset.representations;
        startTimeUs = period.startMs * 1000L;
        drmInitData = getDrmInitData(adaptationset);
        if (!ion.isAdaptive())
        {
            representationIndices = (new int[] {
                getRepresentationIndex(mediapresentationdescription, access._mth100(ion).id)
            });
        } else
        {
            representationIndices = new int[access._mth000(ion).length];
            for (i = 0; i < access._mth000(ion).length; i++)
            {
                representationIndices[i] = getRepresentationIndex(mediapresentationdescription, access._mth000(ion)[i].id);
            }

        }
        for (i = 0; i < representationIndices.length; i++)
        {
            ion = (Representation)mediapresentationdescription.get(representationIndices[i]);
            nHolder nholder = new nHolder(startTimeUs, l, ion);
            representationHolders.put(((Representation) (ion)).format.id, nholder);
        }

        updateRepresentationIndependentProperties(l, (Representation)mediapresentationdescription.get(representationIndices[0]));
    }
}
