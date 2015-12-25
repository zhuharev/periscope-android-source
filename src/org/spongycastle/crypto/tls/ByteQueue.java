// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


public class ByteQueue
{

    private byte azK[];
    private int azL;
    int azM;

    public ByteQueue()
    {
        this(1024);
    }

    private ByteQueue(int i)
    {
        azL = 0;
        azM = 0;
        azK = new byte[1024];
    }

    public final void _mth02CB(byte abyte0[], int i, int j, int k)
    {
        if (abyte0.length - i < j)
        {
            throw new IllegalArgumentException((new StringBuilder("Buffer size of ")).append(abyte0.length).append(" is too small for a read of ").append(j).append(" bytes").toString());
        }
        if (azM - k < j)
        {
            throw new IllegalStateException("Not enough data to read");
        } else
        {
            System.arraycopy(azK, azL + k, abyte0, i, j);
            return;
        }
    }

    public final void _mth02CE(byte abyte0[], int i, int j, int k)
    {
        _mth02CB(abyte0, i, j, k);
        i = k + j;
        if (i > azM)
        {
            throw new IllegalStateException((new StringBuilder("Cannot remove ")).append(i).append(" bytes, only got ").append(azM).toString());
        } else
        {
            azM = azM - i;
            azL = azL + i;
            return;
        }
    }

    public final void _mth05D9(byte abyte0[], int i, int j)
    {
        if (azL + azM + j > azK.length)
        {
            int k = azM + j;
            k |= k >> 1;
            k |= k >> 2;
            k |= k >> 4;
            k |= k >> 8;
            k = (k | k >> 16) + 1;
            if (k > azK.length)
            {
                byte abyte1[] = new byte[k];
                System.arraycopy(azK, azL, abyte1, 0, azM);
                azK = abyte1;
            } else
            {
                System.arraycopy(azK, azL, azK, 0, azM);
            }
            azL = 0;
        }
        System.arraycopy(abyte0, i, azK, azL + azM, j);
        azM = azM + j;
    }
}
