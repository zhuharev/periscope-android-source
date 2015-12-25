// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import javax.crypto.CipherInputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

public class DigestInputStream extends FilterInputStream
{

    private Digest amS;

    public DigestInputStream(CipherInputStream cipherinputstream, SHA1Digest sha1digest)
    {
        super(cipherinputstream);
        amS = sha1digest;
    }

    public int read()
    {
        int i = in.read();
        if (i >= 0)
        {
            amS.update((byte)i);
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = in.read(abyte0, i, j);
        if (j > 0)
        {
            amS.update(abyte0, i, j);
        }
        return j;
    }
}
