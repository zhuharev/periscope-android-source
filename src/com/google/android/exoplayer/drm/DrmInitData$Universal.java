// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import java.util.UUID;

// Referenced classes of package com.google.android.exoplayer.drm:
//            DrmInitData

public static final class data extends DrmInitData
{

    private byte data[];

    public final byte[] get(UUID uuid)
    {
        return data;
    }

    public (String s, byte abyte0[])
    {
        super(s);
        data = abyte0;
    }
}
