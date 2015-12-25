// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.crypto.paddings:
//            BlockCipherPadding

public class TBCPadding
    implements BlockCipherPadding
{

    public TBCPadding()
    {
    }

    public final void init(SecureRandom securerandom)
    {
    }

    public final int _mth1427(byte abyte0[], int i)
    {
        int k = abyte0.length;
        byte byte0;
        int j;
        if (i > 0)
        {
            if ((abyte0[i - 1] & 1) == 0)
            {
                j = 255;
            } else
            {
                j = 0;
            }
            byte0 = (byte)j;
            j = i;
        } else
        {
            if ((abyte0[abyte0.length - 1] & 1) == 0)
            {
                j = 255;
            } else
            {
                j = 0;
            }
            byte0 = (byte)j;
            j = i;
        }
        for (; j < abyte0.length; j++)
        {
            abyte0[j] = byte0;
        }

        return k - i;
    }

    public final int _mth1540(byte abyte0[])
    {
        byte byte0 = abyte0[abyte0.length - 1];
        int i;
        for (i = abyte0.length - 1; i > 0 && abyte0[i - 1] == byte0; i--) { }
        return abyte0.length - i;
    }
}
