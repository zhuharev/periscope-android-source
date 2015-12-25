// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

public final class AudioCapabilities
{

    private static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[] {
        2
    }, 2);
    private final int maxChannelCount;
    private final int supportedEncodings[];

    AudioCapabilities(int ai[], int i)
    {
        if (ai != null)
        {
            supportedEncodings = Arrays.copyOf(ai, ai.length);
            Arrays.sort(supportedEncodings);
        } else
        {
            supportedEncodings = new int[0];
        }
        maxChannelCount = i;
    }

    public static AudioCapabilities getCapabilities(Context context)
    {
        return getCapabilities(context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static AudioCapabilities getCapabilities(Intent intent)
    {
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0)
        {
            return DEFAULT_AUDIO_CAPABILITIES;
        } else
        {
            return new AudioCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
        }
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof AudioCapabilities))
        {
            return false;
        }
        obj = (AudioCapabilities)obj;
        return Arrays.equals(supportedEncodings, ((AudioCapabilities) (obj)).supportedEncodings) && maxChannelCount == ((AudioCapabilities) (obj)).maxChannelCount;
    }

    public final int getMaxChannelCount()
    {
        return maxChannelCount;
    }

    public final int hashCode()
    {
        return maxChannelCount + Arrays.hashCode(supportedEncodings) * 31;
    }

    public final boolean supportsEncoding(int i)
    {
        return Arrays.binarySearch(supportedEncodings, i) >= 0;
    }

    public final String toString()
    {
        return (new StringBuilder("AudioCapabilities[maxChannelCount=")).append(maxChannelCount).append(", supportedEncodings=").append(Arrays.toString(supportedEncodings)).append("]").toString();
    }

}
