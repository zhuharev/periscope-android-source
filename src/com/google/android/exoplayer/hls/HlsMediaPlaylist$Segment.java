// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;


// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsMediaPlaylist

public static final class byterangeLength
    implements Comparable
{

    public final int byterangeLength;
    public final int byterangeOffset;
    public final boolean discontinuity;
    public final double durationSecs;
    public final String encryptionIV;
    public final String encryptionKeyUri;
    public final boolean isEncrypted;
    public final long startTimeUs;
    public final String url;

    public final int compareTo(Long long1)
    {
        if (startTimeUs > long1.longValue())
        {
            return 1;
        }
        return startTimeUs >= long1.longValue() ? 0 : -1;
    }

    public final volatile int compareTo(Object obj)
    {
        return compareTo((Long)obj);
    }

    public (String s, double d, boolean flag, long l, boolean flag1, 
            String s1, String s2, int i, int j)
    {
        url = s;
        durationSecs = d;
        discontinuity = flag;
        startTimeUs = l;
        isEncrypted = flag1;
        encryptionKeyUri = s1;
        encryptionIV = s2;
        byterangeOffset = i;
        byterangeLength = j;
    }
}
