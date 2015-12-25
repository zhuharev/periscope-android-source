// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


// Referenced classes of package com.google.android.exoplayer.util:
//            ManifestFetcher

class this._cls0
    implements Runnable
{

    final ManifestFetcher this$0;

    public void run()
    {
        ManifestFetcher.access$000(ManifestFetcher.this).onManifestRefreshStarted();
    }

    entListener()
    {
        this$0 = ManifestFetcher.this;
        super();
    }
}
