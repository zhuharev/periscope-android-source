// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.metadata;


public final class PrivMetadata
{

    public static final String TYPE = "PRIV";
    public final String owner;
    public final byte privateData[];

    public PrivMetadata(String s, byte abyte0[])
    {
        owner = s;
        privateData = abyte0;
    }
}
