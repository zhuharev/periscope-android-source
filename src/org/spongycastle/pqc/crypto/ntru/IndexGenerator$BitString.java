// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;


// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            IndexGenerator

public static class bytes
{

    int aMq;
    int aMr;
    byte bytes[];

    public final void _mth141D(byte byte0)
    {
        if (aMq == bytes.length)
        {
            bytes = IndexGenerator._mth1D62(bytes, bytes.length * 2);
        }
        if (aMq == 0)
        {
            aMq = 1;
            bytes[0] = byte0;
            aMr = 8;
            return;
        }
        if (aMr == 8)
        {
            byte abyte0[] = bytes;
            int i = aMq;
            aMq = i + 1;
            abyte0[i] = byte0;
            return;
        } else
        {
            int j = aMr;
            byte abyte1[] = bytes;
            int k = aMq - 1;
            abyte1[k] = (byte)(abyte1[k] | (byte0 & 0xff) << aMr);
            abyte1 = bytes;
            k = aMq;
            aMq = k + 1;
            abyte1[k] = (byte)((byte0 & 0xff) >> 8 - j);
            return;
        }
    }

    public ()
    {
        bytes = new byte[4];
    }
}
