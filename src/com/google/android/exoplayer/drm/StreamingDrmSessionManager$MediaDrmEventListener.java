// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.media.MediaDrm;

// Referenced classes of package com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager

class <init>
    implements android.media.iaDrmEventListener
{

    final StreamingDrmSessionManager this$0;

    public void onEvent(MediaDrm mediadrm, byte abyte0[], int i, int j, byte abyte1[])
    {
        mediaDrmHandler.ptyMessage(i);
    }

    private ()
    {
        this$0 = StreamingDrmSessionManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
