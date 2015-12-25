// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.text.TextUtils;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecUtil

static final class secure
{

    public final String mimeType;
    public final boolean secure;

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || obj.getClass() != com/google/android/exoplayer/MediaCodecUtil$CodecKey)
        {
            return false;
        }
        obj = (secure)obj;
        return TextUtils.equals(mimeType, ((mimeType) (obj)).mimeType) && secure == ((secure) (obj)).secure;
    }

    public final int hashCode()
    {
        int i;
        if (mimeType == null)
        {
            i = 0;
        } else
        {
            i = mimeType.hashCode();
        }
        char c;
        if (secure)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return (i + 31) * 31 + c;
    }

    public (String s, boolean flag)
    {
        mimeType = s;
        secure = flag;
    }
}
