// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecUtil

static final class <init>
    implements <init>
{

    public final int getCodecCount()
    {
        return MediaCodecList.getCodecCount();
    }

    public final MediaCodecInfo getCodecInfoAt(int i)
    {
        return MediaCodecList.getCodecInfoAt(i);
    }

    public final boolean isSecurePlaybackSupported(String s, android.media.cListCompatV16 clistcompatv16)
    {
        return "video/avc".equals(s);
    }

    public final boolean secureDecodersExplicit()
    {
        return false;
    }

    private I()
    {
    }

    I(I i)
    {
        this();
    }
}
