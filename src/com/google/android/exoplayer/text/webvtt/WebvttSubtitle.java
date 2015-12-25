// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text.webvtt:
//            WebvttCue

public final class WebvttSubtitle
    implements Subtitle
{

    private final long cueTimesUs[];
    private final List cues;
    private final int numCues;
    private final long sortedCueTimesUs[];

    public WebvttSubtitle(List list)
    {
        cues = list;
        numCues = list.size();
        cueTimesUs = new long[numCues * 2];
        for (int i = 0; i < numCues; i++)
        {
            WebvttCue webvttcue = (WebvttCue)list.get(i);
            int j = i << 1;
            cueTimesUs[j] = webvttcue.startTime;
            cueTimesUs[j + 1] = webvttcue.endTime;
        }

        sortedCueTimesUs = Arrays.copyOf(cueTimesUs, cueTimesUs.length);
        Arrays.sort(sortedCueTimesUs);
    }

    public final List getCues(long l)
    {
        ArrayList arraylist1 = null;
        WebvttCue webvttcue = null;
        Object obj = null;
        for (int i = 0; i < numCues;)
        {
            ArrayList arraylist = arraylist1;
            WebvttCue webvttcue1 = webvttcue;
            Object obj1 = obj;
            if (cueTimesUs[i << 1] <= l)
            {
                arraylist = arraylist1;
                webvttcue1 = webvttcue;
                obj1 = obj;
                if (l < cueTimesUs[(i << 1) + 1])
                {
                    arraylist = arraylist1;
                    if (arraylist1 == null)
                    {
                        arraylist = new ArrayList();
                    }
                    webvttcue1 = (WebvttCue)cues.get(i);
                    if (webvttcue1.isNormalCue())
                    {
                        if (webvttcue == null)
                        {
                            obj1 = obj;
                        } else
                        if (obj == null)
                        {
                            obj1 = new SpannableStringBuilder();
                            ((SpannableStringBuilder) (obj1)).append(webvttcue.text).append("\n").append(webvttcue1.text);
                            webvttcue1 = webvttcue;
                        } else
                        {
                            ((SpannableStringBuilder) (obj)).append("\n").append(webvttcue1.text);
                            webvttcue1 = webvttcue;
                            obj1 = obj;
                        }
                    } else
                    {
                        arraylist.add(webvttcue1);
                        obj1 = obj;
                        webvttcue1 = webvttcue;
                    }
                }
            }
            i++;
            arraylist1 = arraylist;
            webvttcue = webvttcue1;
            obj = obj1;
        }

        if (obj != null)
        {
            arraylist1.add(new WebvttCue(((CharSequence) (obj))));
        } else
        if (webvttcue != null)
        {
            arraylist1.add(webvttcue);
        }
        if (arraylist1 != null)
        {
            return arraylist1;
        } else
        {
            return Collections.emptyList();
        }
    }

    public final long getEventTime(int i)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (i < sortedCueTimesUs.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        return sortedCueTimesUs[i];
    }

    public final int getEventTimeCount()
    {
        return sortedCueTimesUs.length;
    }

    public final long getLastEventTime()
    {
        if (getEventTimeCount() == 0)
        {
            return -1L;
        } else
        {
            return sortedCueTimesUs[sortedCueTimesUs.length - 1];
        }
    }

    public final int getNextEventTimeIndex(long l)
    {
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        int i = Util.binarySearchCeil(sortedCueTimesUs, l, false, false);
        if (i < sortedCueTimesUs.length)
        {
            return i;
        } else
        {
            return -1;
        }
    }
}
