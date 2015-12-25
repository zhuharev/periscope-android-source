// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Format

public abstract class Chunk
    implements com.google.android.exoplayer.upstream.Loader.Loadable
{

    public static final int NO_PARENT_ID = -1;
    public static final int TRIGGER_ADAPTIVE = 3;
    public static final int TRIGGER_CUSTOM_BASE = 10000;
    public static final int TRIGGER_INITIAL = 1;
    public static final int TRIGGER_MANUAL = 2;
    public static final int TRIGGER_TRICK_PLAY = 4;
    public static final int TRIGGER_UNSPECIFIED = 0;
    public static final int TYPE_CUSTOM_BASE = 10000;
    public static final int TYPE_DRM = 3;
    public static final int TYPE_MANIFEST = 4;
    public static final int TYPE_MEDIA = 1;
    public static final int TYPE_MEDIA_INITIALIZATION = 2;
    public static final int TYPE_UNSPECIFIED = 0;
    public final DataSource dataSource;
    public final DataSpec dataSpec;
    public final Format format;
    public final int parentId;
    public final int trigger;
    public final int type;

    public Chunk(DataSource datasource, DataSpec dataspec, int i, int j, Format format1, int k)
    {
        dataSource = (DataSource)Assertions.checkNotNull(datasource);
        dataSpec = (DataSpec)Assertions.checkNotNull(dataspec);
        type = i;
        trigger = j;
        format = format1;
        parentId = k;
    }

    public abstract long bytesLoaded();
}
