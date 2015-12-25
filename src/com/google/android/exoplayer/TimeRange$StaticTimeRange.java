// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            TimeRange

public static final class endTimeUs
    implements TimeRange
{

    private final long endTimeUs;
    private final long startTimeUs;

    public final boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (endTimeUs)obj;
        return ((endTimeUs) (obj)).startTimeUs == startTimeUs && ((startTimeUs) (obj)).endTimeUs == endTimeUs;
    }

    public final long[] getCurrentBoundsMs(long al[])
    {
        al = getCurrentBoundsUs(al);
        al[0] = al[0] / 1000L;
        al[1] = al[1] / 1000L;
        return al;
    }

    public final long[] getCurrentBoundsUs(long al[])
    {
        long al1[];
label0:
        {
            if (al != null)
            {
                al1 = al;
                if (al.length >= 2)
                {
                    break label0;
                }
            }
            al1 = new long[2];
        }
        al1[0] = startTimeUs;
        al1[1] = endTimeUs;
        return al1;
    }

    public final int hashCode()
    {
        return ((int)startTimeUs + 527) * 31 + (int)endTimeUs;
    }

    public final boolean isStatic()
    {
        return true;
    }

    public (long l, long l1)
    {
        startTimeUs = l;
        endTimeUs = l1;
    }
}
