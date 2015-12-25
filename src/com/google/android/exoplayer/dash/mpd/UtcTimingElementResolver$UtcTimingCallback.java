// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            UtcTimingElementResolver, UtcTimingElement

public static interface 
{

    public abstract void onTimestampError(UtcTimingElement utctimingelement, IOException ioexception);

    public abstract void onTimestampResolved(UtcTimingElement utctimingelement, long l);
}
