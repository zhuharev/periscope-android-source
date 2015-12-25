// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.io;

import java.io.OutputStream;

public class MacOutputStream extends OutputStream
{

    public void write(int i)
    {
        i = (byte)i;
        throw new NullPointerException();
    }

    public void write(byte abyte0[], int i, int j)
    {
        throw new NullPointerException();
    }
}
