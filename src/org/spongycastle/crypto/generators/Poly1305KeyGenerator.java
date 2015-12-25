// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;

public class Poly1305KeyGenerator extends CipherKeyGenerator
{

    public Poly1305KeyGenerator()
    {
    }

    public static void _mth02C6(byte abyte0[])
    {
        if (abyte0.length != 32)
        {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        } else
        {
            abyte0[19] = (byte)(abyte0[19] & 0xf);
            abyte0[23] = (byte)(abyte0[23] & 0xf);
            abyte0[27] = (byte)(abyte0[27] & 0xf);
            abyte0[31] = (byte)(abyte0[31] & 0xf);
            abyte0[20] = (byte)(abyte0[20] & -4);
            abyte0[24] = (byte)(abyte0[24] & -4);
            abyte0[28] = (byte)(abyte0[28] & -4);
            return;
        }
    }

    public static void _mth02C7(byte abyte0[])
    {
        if (abyte0.length != 32)
        {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        if ((abyte0[19] & 0xfffffff0) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
        if ((abyte0[23] & 0xfffffff0) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
        if ((abyte0[27] & 0xfffffff0) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
        if ((abyte0[31] & 0xfffffff0) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
        if ((abyte0[20] & 3) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
        if ((abyte0[24] & 3) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
        if ((abyte0[28] & 3) != 0)
        {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        } else
        {
            return;
        }
    }

    public final void _mth02CA(KeyGenerationParameters keygenerationparameters)
    {
        super._mth02CA(new KeyGenerationParameters(keygenerationparameters.amC, 256));
    }

    public final byte[] _mth14AE()
    {
        byte abyte0[] = super._mth14AE();
        _mth02C6(abyte0);
        return abyte0;
    }
}
