// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;

public class NullDigest
    implements Digest
{

    private ByteArrayOutputStream anR;

    public NullDigest()
    {
        anR = new ByteArrayOutputStream();
    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = anR.toByteArray();
        System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
        anR.reset();
        return abyte1.length;
    }

    public final void reset()
    {
        anR.reset();
    }

    public final void update(byte byte0)
    {
        anR.write(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        anR.write(abyte0, i, j);
    }

    public final String _mth14AC()
    {
        return "NULL";
    }

    public final int _mth14AF()
    {
        return anR.size();
    }
}
