// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.metadata;


public final class GeobMetadata
{

    public static final String TYPE = "GEOB";
    public final byte data[];
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobMetadata(String s, String s1, String s2, byte abyte0[])
    {
        mimeType = s;
        filename = s1;
        description = s2;
        data = abyte0;
    }
}
