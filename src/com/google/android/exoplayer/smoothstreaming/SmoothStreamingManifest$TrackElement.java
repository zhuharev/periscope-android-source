// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.smoothstreaming;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatWrapper;

// Referenced classes of package com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest

public static class format
    implements FormatWrapper
{

    public final byte csd[][];
    public final Format format;

    public Format getFormat()
    {
        return format;
    }

    public (int i, int j, String s, byte abyte0[][], int k, int l, int i1, 
            int j1)
    {
        csd = abyte0;
        format = new Format(String.valueOf(i), s, k, l, -1F, j1, i1, j);
    }
}
