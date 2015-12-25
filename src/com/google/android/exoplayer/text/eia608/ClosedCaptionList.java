// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.eia608;


// Referenced classes of package com.google.android.exoplayer.text.eia608:
//            ClosedCaption

final class ClosedCaptionList
    implements Comparable
{

    public final ClosedCaption captions[];
    public final boolean decodeOnly;
    public final long timeUs;

    public ClosedCaptionList(long l, boolean flag, ClosedCaption aclosedcaption[])
    {
        timeUs = l;
        decodeOnly = flag;
        captions = aclosedcaption;
    }

    public final int compareTo(ClosedCaptionList closedcaptionlist)
    {
        long l = timeUs - closedcaptionlist.timeUs;
        if (l == 0L)
        {
            return 0;
        }
        return l <= 0L ? -1 : 1;
    }

    public final volatile int compareTo(Object obj)
    {
        return compareTo((ClosedCaptionList)obj);
    }
}
