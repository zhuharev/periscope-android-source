// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.digest;

import java.security.MessageDigest;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;

public class BCMessageDigest extends MessageDigest
{

    protected Digest amS;

    protected BCMessageDigest(ExtendedDigest extendeddigest)
    {
        super(extendeddigest._mth14AC());
        amS = extendeddigest;
    }

    public byte[] engineDigest()
    {
        byte abyte0[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte0, 0);
        return abyte0;
    }

    public void engineReset()
    {
        amS.reset();
    }

    public void engineUpdate(byte byte0)
    {
        amS.update(byte0);
    }

    public void engineUpdate(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }
}
