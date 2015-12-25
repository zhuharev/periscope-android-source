// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            Loader

public static interface 
{

    public abstract void onLoadCanceled( );

    public abstract void onLoadCompleted( );

    public abstract void onLoadError( , IOException ioexception);
}
