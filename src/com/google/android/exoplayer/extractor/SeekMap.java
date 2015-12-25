// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor;


public interface SeekMap
{

    public static final SeekMap UNSEEKABLE = new _cls1();

    public abstract long getPosition(long l);

    public abstract boolean isSeekable();


    private class _cls1
        implements SeekMap
    {

        public final long getPosition(long l)
        {
            return 0L;
        }

        public final boolean isSeekable()
        {
            return false;
        }

        _cls1()
        {
        }
    }

}
