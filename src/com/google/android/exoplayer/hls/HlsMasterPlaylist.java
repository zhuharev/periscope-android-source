// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import java.util.List;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsPlaylist

public final class HlsMasterPlaylist extends HlsPlaylist
{

    public final List subtitles;
    public final List variants;

    public HlsMasterPlaylist(String s, List list, List list1)
    {
        super(s, 0);
        variants = list;
        subtitles = list1;
    }
}
