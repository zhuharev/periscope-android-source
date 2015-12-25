// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;

import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.crypto:
//            CipherParameters

public abstract class PBEParametersGenerator
{

    public byte aaN[];
    public byte amG[];
    public int amH;

    public PBEParametersGenerator()
    {
    }

    public static byte[] _mth02CB(char ac[])
    {
        if (ac != null)
        {
            byte abyte0[] = new byte[ac.length];
            for (int i = 0; i != abyte0.length; i++)
            {
                abyte0[i] = (byte)ac[i];
            }

            return abyte0;
        } else
        {
            return new byte[0];
        }
    }

    public static byte[] _mth02CE(char ac[])
    {
        if (ac != null)
        {
            return Strings._mth02BB(ac);
        } else
        {
            return new byte[0];
        }
    }

    public static byte[] _mth02CF(char ac[])
    {
        if (ac != null && ac.length > 0)
        {
            byte abyte0[] = new byte[ac.length + 1 << 1];
            for (int i = 0; i != ac.length; i++)
            {
                abyte0[i << 1] = (byte)(ac[i] >>> 8);
                abyte0[(i << 1) + 1] = (byte)ac[i];
            }

            return abyte0;
        } else
        {
            return new byte[0];
        }
    }

    public final void _mth02CA(byte abyte0[], byte abyte1[], int i)
    {
        amG = abyte0;
        aaN = abyte1;
        amH = i;
    }

    public abstract KeyParameter _mth155D(int i);

    public abstract CipherParameters _mth1D52(int i);

    public abstract ParametersWithIV _mth1D63(int i, int j);
}
