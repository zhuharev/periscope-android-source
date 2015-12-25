// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;


public final class TrackEncryptionBox
{

    public final int initializationVectorSize;
    public final boolean isEncrypted;
    public final byte keyId[];

    public TrackEncryptionBox(boolean flag, int i, byte abyte0[])
    {
        isEncrypted = flag;
        initializationVectorSize = i;
        keyId = abyte0;
    }
}
