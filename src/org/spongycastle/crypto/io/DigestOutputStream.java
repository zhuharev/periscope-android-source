// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.OutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

public class DigestOutputStream extends OutputStream
{

    private Digest amS;

    public DigestOutputStream(SHA1Digest sha1digest)
    {
        amS = sha1digest;
    }

    public void write(int i)
    {
        amS.update((byte)i);
    }

    public void write(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final byte[] FF97()
    {
        byte abyte0[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte0, 0);
        return abyte0;
    }
}
