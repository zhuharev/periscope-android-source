// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodecInfo;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecUtil

static interface 
{

    public abstract int getCodecCount();

    public abstract MediaCodecInfo getCodecInfoAt(int i);

    public abstract boolean isSecurePlaybackSupported(String s, android.media.odecListCompat odeclistcompat);

    public abstract boolean secureDecodersExplicit();
}
