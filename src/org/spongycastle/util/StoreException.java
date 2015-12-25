// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util;

import java.io.IOException;

public class StoreException extends RuntimeException
{

    private Throwable aPu;

    public StoreException(String s, IOException ioexception)
    {
        super(s);
        aPu = ioexception;
    }

    public Throwable getCause()
    {
        return aPu;
    }
}
