// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.OutputStream;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;

public class MacOutputStream extends OutputStream
{

    private Mac arN;

    public MacOutputStream(HMac hmac)
    {
        arN = hmac;
    }

    public void write(int i)
    {
        arN.update((byte)i);
    }

    public void write(byte abyte0[], int i, int j)
    {
        arN.update(abyte0, i, j);
    }
}
