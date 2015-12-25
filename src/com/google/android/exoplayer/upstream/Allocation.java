// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;


public final class Allocation
{

    public final byte data[];
    private final int offset;

    public Allocation(byte abyte0[], int i)
    {
        data = abyte0;
        offset = i;
    }

    public final int translateOffset(int i)
    {
        return offset + i;
    }
}
