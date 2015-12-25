// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager

class this._cls0 extends Handler
{

    final StreamingDrmSessionManager this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            StreamingDrmSessionManager.access$700(StreamingDrmSessionManager.this, message.obj);
            return;

        case 1: // '\001'
            StreamingDrmSessionManager.access$800(StreamingDrmSessionManager.this, message.obj);
            break;
        }
    }

    public (Looper looper)
    {
        this$0 = StreamingDrmSessionManager.this;
        super(looper);
    }
}
