// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.io.ByteArrayInputStream;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsChunkSource, HlsPlaylistParser, HlsMediaPlaylist

static class playlistUrl extends DataChunk
{

    private final HlsPlaylistParser playlistParser;
    private final String playlistUrl;
    private HlsMediaPlaylist result;
    public final int variantIndex;

    protected void consume(byte abyte0[], int i)
    {
        result = (HlsMediaPlaylist)playlistParser.parse(playlistUrl, new ByteArrayInputStream(abyte0, 0, i));
    }

    public HlsMediaPlaylist getResult()
    {
        return result;
    }

    public (DataSource datasource, DataSpec dataspec, byte abyte0[], HlsPlaylistParser hlsplaylistparser, int i, String s)
    {
        super(datasource, dataspec, 4, 0, null, -1, abyte0);
        variantIndex = i;
        playlistParser = hlsplaylistparser;
        playlistUrl = s;
    }
}
