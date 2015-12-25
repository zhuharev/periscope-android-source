// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer.util.Predicate;
import com.google.android.exoplayer.util.Util;

final class 
    implements Predicate
{

    public final volatile boolean evaluate(Object obj)
    {
        return evaluate((String)obj);
    }

    public final boolean evaluate(String s)
    {
        s = Util.toLowerInvariant(s);
        return !TextUtils.isEmpty(s) && (!s.contains("text") || s.contains("text/vtt")) && !s.contains("html") && !s.contains("xml");
    }

    ()
    {
    }
}
