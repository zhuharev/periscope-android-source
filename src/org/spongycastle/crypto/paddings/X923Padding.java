// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

// Referenced classes of package org.spongycastle.crypto.paddings:
//            BlockCipherPadding

public class X923Padding
    implements BlockCipherPadding
{

    private SecureRandom amC;

    public X923Padding()
    {
        amC = null;
    }

    public final void init(SecureRandom securerandom)
    {
        amC = securerandom;
    }

    public final int _mth1427(byte abyte0[], int i)
    {
        byte byte0 = (byte)(abyte0.length - i);
        for (; i < abyte0.length - 1; i++)
        {
            if (amC == null)
            {
                abyte0[i] = 0;
            } else
            {
                abyte0[i] = (byte)amC.nextInt();
            }
        }

        abyte0[i] = byte0;
        return byte0;
    }

    public final int _mth1540(byte abyte0[])
    {
        int i = abyte0[abyte0.length - 1] & 0xff;
        if (i > abyte0.length)
        {
            throw new InvalidCipherTextException("pad block corrupted");
        } else
        {
            return i;
        }
    }
}
