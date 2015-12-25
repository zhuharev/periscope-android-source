// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import java.util.List;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsPlaylist

public final class HlsMediaPlaylist extends HlsPlaylist
{
    public static final class Segment
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

        public Segment(String s, double d, boolean flag, long l, boolean flag1, 
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


    public static final String ENCRYPTION_METHOD_AES_128 = "AES-128";
    public static final String ENCRYPTION_METHOD_NONE = "NONE";
    public final long durationUs;
    public final boolean live;
    public final int mediaSequence;
    public final List segments;
    public final int targetDurationSecs;
    public final int version;

    public HlsMediaPlaylist(String s, int i, int j, int k, boolean flag, List list)
    {
        super(s, 1);
        mediaSequence = i;
        targetDurationSecs = j;
        version = k;
        live = flag;
        segments = list;
        if (!list.isEmpty())
        {
            s = (Segment)list.get(list.size() - 1);
            durationUs = ((Segment) (s)).startTimeUs + (long)(((Segment) (s)).durationSecs * 1000000D);
            return;
        } else
        {
            durationUs = 0L;
            return;
        }
    }
}
