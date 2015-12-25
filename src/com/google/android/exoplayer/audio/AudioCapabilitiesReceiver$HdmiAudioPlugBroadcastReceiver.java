// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.android.exoplayer.audio:
//            AudioCapabilitiesReceiver, AudioCapabilities

final class <init> extends BroadcastReceiver
{

    final AudioCapabilitiesReceiver this$0;

    public final void onReceive(Context context, Intent intent)
    {
        if (!isInitialStickyBroadcast())
        {
            context = AudioCapabilities.getCapabilities(intent);
            if (!context.equals(audioCapabilities))
            {
                audioCapabilities = context;
                AudioCapabilitiesReceiver.access$100(AudioCapabilitiesReceiver.this).nged(context);
            }
        }
    }

    private a()
    {
        this$0 = AudioCapabilitiesReceiver.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
