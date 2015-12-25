// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.media.MediaCrypto;

// Referenced classes of package com.google.android.exoplayer.drm:
//            DrmInitData

public interface DrmSessionManager
{

    public static final int STATE_CLOSED = 1;
    public static final int STATE_ERROR = 0;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;

    public abstract void close();

    public abstract Exception getError();

    public abstract MediaCrypto getMediaCrypto();

    public abstract int getState();

    public abstract void open(DrmInitData drminitdata);

    public abstract boolean requiresSecureDecoderComponent(String s);
}
