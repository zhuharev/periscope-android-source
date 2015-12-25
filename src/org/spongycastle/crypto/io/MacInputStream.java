// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;

public class MacInputStream extends FilterInputStream
{

    private Mac arN;

    public MacInputStream(DataInputStream datainputstream, HMac hmac)
    {
        super(datainputstream);
        arN = hmac;
    }

    public int read()
    {
        int i = in.read();
        if (i >= 0)
        {
            arN.update((byte)i);
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = in.read(abyte0, i, j);
        if (j >= 0)
        {
            arN.update(abyte0, i, j);
        }
        return j;
    }
}
