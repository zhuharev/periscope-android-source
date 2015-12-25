// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.encoders;


public class DecoderException extends IllegalStateException
{

    private Throwable VU;

    DecoderException(String s, Exception exception)
    {
        super(s);
        VU = exception;
    }

    public Throwable getCause()
    {
        return VU;
    }
}
