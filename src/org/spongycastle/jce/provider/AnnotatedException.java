// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import org.spongycastle.jce.exception.ExtException;

public class AnnotatedException extends Exception
    implements ExtException
{

    private Throwable aGY;

    AnnotatedException(String s)
    {
        this(s, null);
    }

    AnnotatedException(String s, Exception exception)
    {
        super(s);
        aGY = exception;
    }

    public Throwable getCause()
    {
        return aGY;
    }
}
