// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;


public final class UtcTimingElement
{

    public final String schemeIdUri;
    public final String value;

    public UtcTimingElement(String s, String s1)
    {
        schemeIdUri = s;
        value = s1;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(schemeIdUri).append(", ").append(value).toString();
    }
}
