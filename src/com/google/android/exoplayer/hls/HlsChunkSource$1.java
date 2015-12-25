// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import java.util.Comparator;

// Referenced classes of package com.google.android.exoplayer.hls:
//            Variant

final class ngBandwidthComparator
    implements Comparator
{

    private final Comparator formatComparator = new com.google.android.exoplayer.chunk.BandwidthComparator();

    public final int compare(Variant variant, Variant variant1)
    {
        return formatComparator.compare(variant.format, variant1.format);
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        return compare((Variant)obj, (Variant)obj1);
    }

    ngBandwidthComparator()
    {
    }
}
