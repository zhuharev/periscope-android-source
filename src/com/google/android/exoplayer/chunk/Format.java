// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.util.Assertions;
import java.util.Comparator;

public class Format
{
    public static final class DecreasingBandwidthComparator
        implements Comparator
    {

        public final int compare(Format format, Format format1)
        {
            return format1.bitrate - format.bitrate;
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((Format)obj, (Format)obj1);
        }

        public DecreasingBandwidthComparator()
        {
        }
    }


    public final int audioChannels;
    public final int audioSamplingRate;
    public final int bitrate;
    public final String codecs;
    public final float frameRate;
    public final int height;
    public final String id;
    public final String language;
    public final String mimeType;
    public final int width;

    public Format(String s, String s1, int i, int j, float f, int k, int l, 
            int i1)
    {
        this(s, s1, i, j, f, k, l, i1, null);
    }

    public Format(String s, String s1, int i, int j, float f, int k, int l, 
            int i1, String s2)
    {
        this(s, s1, i, j, f, k, l, i1, s2, null);
    }

    public Format(String s, String s1, int i, int j, float f, int k, int l, 
            int i1, String s2, String s3)
    {
        id = (String)Assertions.checkNotNull(s);
        mimeType = s1;
        width = i;
        height = j;
        frameRate = f;
        audioChannels = k;
        audioSamplingRate = l;
        bitrate = i1;
        language = s2;
        codecs = s3;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            return ((Format)obj).id.equals(id);
        }
    }

    public int hashCode()
    {
        return id.hashCode();
    }
}
