// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager, KeysExpiredException

class this._cls0 extends Handler
{

    final StreamingDrmSessionManager this$0;

    public void handleMessage(Message message)
    {
        if (StreamingDrmSessionManager.access$200(StreamingDrmSessionManager.this) == 0 || StreamingDrmSessionManager.access$300(StreamingDrmSessionManager.this) != 3 && StreamingDrmSessionManager.access$300(StreamingDrmSessionManager.this) != 4)
        {
            return;
        }
        switch (message.what)
        {
        default:
            return;

        case 2: // '\002'
            StreamingDrmSessionManager.access$400(StreamingDrmSessionManager.this);
            return;

        case 3: // '\003'
            StreamingDrmSessionManager.access$302(StreamingDrmSessionManager.this, 3);
            StreamingDrmSessionManager.access$500(StreamingDrmSessionManager.this, new KeysExpiredException());
            return;

        case 1: // '\001'
            StreamingDrmSessionManager.access$302(StreamingDrmSessionManager.this, 3);
            StreamingDrmSessionManager.access$600(StreamingDrmSessionManager.this);
            return;
        }
    }

    public Q(Looper looper)
    {
        this$0 = StreamingDrmSessionManager.this;
        super(looper);
    }
}
