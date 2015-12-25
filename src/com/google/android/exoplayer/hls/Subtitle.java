// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;


public final class Subtitle
{

    public final boolean autoSelect;
    public final boolean isDefault;
    public final String language;
    public final String name;
    public final String uri;

    public Subtitle(String s, String s1, String s2, boolean flag, boolean flag1)
    {
        name = s;
        uri = s1;
        language = s2;
        autoSelect = flag1;
        isDefault = flag;
    }
}
