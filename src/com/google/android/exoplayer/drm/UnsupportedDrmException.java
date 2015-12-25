// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;


public final class UnsupportedDrmException extends Exception
{

    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    public UnsupportedDrmException(int i)
    {
        reason = i;
    }

    public UnsupportedDrmException(int i, Exception exception)
    {
        super(exception);
        reason = i;
    }
}
