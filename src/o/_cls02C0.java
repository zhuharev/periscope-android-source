// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Trace;

class _cls02C0
{

    _cls02C0()
    {
    }

    public static void beginSection(String s)
    {
        Trace.beginSection(s);
    }

    public static void endSection()
    {
        Trace.endSection();
    }
}
