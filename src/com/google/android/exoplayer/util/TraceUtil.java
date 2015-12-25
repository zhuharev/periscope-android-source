// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.os.Trace;

// Referenced classes of package com.google.android.exoplayer.util:
//            Util

public final class TraceUtil
{

    private TraceUtil()
    {
    }

    public static void beginSection(String s)
    {
        if (Util.SDK_INT >= 18)
        {
            beginSectionV18(s);
        }
    }

    private static void beginSectionV18(String s)
    {
        Trace.beginSection(s);
    }

    public static void endSection()
    {
        if (Util.SDK_INT >= 18)
        {
            endSectionV18();
        }
    }

    private static void endSectionV18()
    {
        Trace.endSection();
    }
}
