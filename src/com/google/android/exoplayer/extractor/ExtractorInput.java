// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;


public interface ExtractorInput
{

    public abstract void advancePeekPosition(int i);

    public abstract long getLength();

    public abstract long getPosition();

    public abstract void peekFully(byte abyte0[], int i, int j);

    public abstract int read(byte abyte0[], int i, int j);

    public abstract void readFully(byte abyte0[], int i, int j);

    public abstract boolean readFully(byte abyte0[], int i, int j, boolean flag);

    public abstract void resetPeekPosition();

    public abstract void skipFully(int i);
}
