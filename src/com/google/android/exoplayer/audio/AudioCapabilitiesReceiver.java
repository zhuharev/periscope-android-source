// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioCapabilities

public final class AudioCapabilitiesReceiver
{
    final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver
    {

        final AudioCapabilitiesReceiver this$0;

        public final void onReceive(Context context1, Intent intent)
        {
            if (!isInitialStickyBroadcast())
            {
                context1 = AudioCapabilities.getCapabilities(intent);
                if (!context1.equals(audioCapabilities))
                {
                    audioCapabilities = context1;
                    listener.onAudioCapabilitiesChanged(context1);
                }
            }
        }

        private HdmiAudioPlugBroadcastReceiver()
        {
            this$0 = AudioCapabilitiesReceiver.this;
            super();
        }

    }

    public static interface Listener
    {

        public abstract void onAudioCapabilitiesChanged(AudioCapabilities audiocapabilities);
    }


    AudioCapabilities audioCapabilities;
    private final Context context;
    private final Listener listener;
    private final BroadcastReceiver receiver;

    public AudioCapabilitiesReceiver(Context context1, Listener listener1)
    {
        context = (Context)Assertions.checkNotNull(context1);
        listener = (Listener)Assertions.checkNotNull(listener1);
        if (Util.SDK_INT >= 21)
        {
            context1 = new HdmiAudioPlugBroadcastReceiver();
        } else
        {
            context1 = null;
        }
        receiver = context1;
    }

    public final AudioCapabilities register()
    {
        Intent intent;
        if (receiver == null)
        {
            intent = null;
        } else
        {
            intent = context.registerReceiver(receiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        }
        audioCapabilities = AudioCapabilities.getCapabilities(intent);
        return audioCapabilities;
    }

    public final void unregister()
    {
        if (receiver != null)
        {
            context.unregisterReceiver(receiver);
        }
    }

}
