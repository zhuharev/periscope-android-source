// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;


// Referenced classes of package com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager

public static interface 
{

    public abstract void onDrmKeysLoaded();

    public abstract void onDrmSessionManagerError(Exception exception);
}
