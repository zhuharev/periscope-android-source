// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecUtil

static final class codecKind
    implements codecKind
{

    private final int codecKind;
    private MediaCodecInfo mediaCodecInfos[];

    private void ensureMediaCodecInfosInitialized()
    {
        if (mediaCodecInfos == null)
        {
            mediaCodecInfos = (new MediaCodecList(codecKind)).getCodecInfos();
        }
    }

    public final int getCodecCount()
    {
        ensureMediaCodecInfosInitialized();
        return mediaCodecInfos.length;
    }

    public final MediaCodecInfo getCodecInfoAt(int i)
    {
        ensureMediaCodecInfosInitialized();
        return mediaCodecInfos[i];
    }

    public final boolean isSecurePlaybackSupported(String s, android.media.cListCompatV21 clistcompatv21)
    {
        return clistcompatv21.ureSupported("secure-playback");
    }

    public final boolean secureDecodersExplicit()
    {
        return true;
    }

    public I(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        codecKind = i;
    }
}
