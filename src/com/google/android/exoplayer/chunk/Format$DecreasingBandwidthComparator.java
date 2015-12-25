// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import java.util.Comparator;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Format

public static final class 
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

    public ()
    {
    }
}
