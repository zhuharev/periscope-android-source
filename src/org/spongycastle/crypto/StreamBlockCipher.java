// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            BlockCipher, StreamCipher, DataLengthException

public abstract class StreamBlockCipher
    implements BlockCipher, StreamCipher
{

    public final BlockCipher amz;

    public StreamBlockCipher(BlockCipher blockcipher)
    {
        amz = blockcipher;
    }

    public final int _mth02CB(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        if (k + j > abyte1.length)
        {
            throw new DataLengthException("output buffer too short");
        }
        if (i + j > abyte0.length)
        {
            throw new DataLengthException("input buffer too small");
        }
        int i1 = i;
        int l = k;
        for (k = i1; k < i + j;)
        {
            int j1 = l + 1;
            int k1 = k + 1;
            abyte1[l] = _mth02CF(abyte0[k]);
            k = k1;
            l = j1;
        }

        return j;
    }

    public abstract byte _mth02CF(byte byte0);
}
