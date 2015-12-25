// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;


// Referenced classes of package org.spongycastle.crypto.io:
//            CipherIOException

public class InvalidCipherTextIOException extends CipherIOException
{

    public InvalidCipherTextIOException(String s, Exception exception)
    {
        super(s, exception);
    }
}
