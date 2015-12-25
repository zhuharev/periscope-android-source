// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager, MediaDrmCallback

class this._cls0 extends Handler
{

    final StreamingDrmSessionManager this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 2: default 120
    //                   0: 32
    //                   1: 62;
           goto _L1 _L2 _L3
_L2:
        Object obj;
        obj = callback.executeProvisionRequest(uuid, (android.media.uuid)message.obj);
        break; /* Loop/switch isn't completed */
_L3:
        try
        {
            obj = callback.executeKeyRequest(uuid, (android.media.uuid)message.obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        break; /* Loop/switch isn't completed */
_L1:
        throw new RuntimeException();
        postResponseHandler.obtainMessage(message.what, obj).sendToTarget();
        return;
    }

    public (Looper looper)
    {
        this$0 = StreamingDrmSessionManager.this;
        super(looper);
    }
}
