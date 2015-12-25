// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class TeeOutputStream extends OutputStream
{

    private OutputStream aPC;
    private OutputStream aPD;

    public TeeOutputStream(FilterOutputStream filteroutputstream, OutputStream outputstream)
    {
        aPC = filteroutputstream;
        aPD = outputstream;
    }

    public void close()
    {
        aPC.close();
        aPD.close();
    }

    public void flush()
    {
        aPC.flush();
        aPD.flush();
    }

    public void write(int i)
    {
        aPC.write(i);
        aPD.write(i);
    }

    public void write(byte abyte0[])
    {
        aPC.write(abyte0);
        aPD.write(abyte0);
    }

    public void write(byte abyte0[], int i, int j)
    {
        aPC.write(abyte0, i, j);
        aPD.write(abyte0, i, j);
    }
}
