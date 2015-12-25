// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;


// Referenced classes of package com.google.android.exoplayer:
//            DefaultLoadControl

static class nextLoadPositionUs
{

    public final int bufferSizeContribution;
    public int bufferState;
    public boolean loading;
    public long nextLoadPositionUs;

    public A(int i)
    {
        bufferSizeContribution = i;
        bufferState = 0;
        loading = false;
        nextLoadPositionUs = -1L;
    }
}
