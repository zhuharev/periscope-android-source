// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.security.SecureRandom;
import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSalt;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Integers;

public class ISO9796d2PSSSigner
    implements SignerWithRecovery
{

    private static Hashtable azf;
    private SecureRandom amC;
    private byte azg[];
    private int azh;
    private byte azi[];
    private int azj;
    private boolean azk;
    private byte azl[];
    private byte azm[];
    private byte azn[];
    private int azo;
    private int azp;
    private byte kv[];

    private byte[] _mth02CA(byte abyte0[], int i, int j, int k)
    {
        abyte0 = new byte[k];
        abyte0 = new byte[4];
        throw new NullPointerException();
    }

    private static void _mth02CE(long l, byte abyte0[])
    {
        abyte0[0] = (byte)(int)(l >>> 56);
        abyte0[1] = (byte)(int)(l >>> 48);
        abyte0[2] = (byte)(int)(l >>> 40);
        abyte0[3] = (byte)(int)(l >>> 32);
        abyte0[4] = (byte)(int)(l >>> 24);
        abyte0[5] = (byte)(int)(l >>> 16);
        abyte0[6] = (byte)(int)(l >>> 8);
        abyte0[7] = (byte)(int)l;
    }

    private boolean _mth037A(byte abyte0[], byte abyte1[])
    {
        boolean flag = true;
        if (azj != abyte1.length)
        {
            flag = false;
        }
        for (int i = 0; i != abyte1.length; i++)
        {
            if (abyte0[i] != abyte1[i])
            {
                flag = false;
            }
        }

        return flag;
    }

    private static void _mth14BD(byte abyte0[])
    {
        for (int i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = 0;
        }

    }

    public final void update(byte byte0)
    {
        if (azm == null && azj < azi.length)
        {
            byte abyte0[] = azi;
            int i = azj;
            azj = i + 1;
            abyte0[i] = byte0;
            return;
        } else
        {
            throw new NullPointerException();
        }
    }

    public final void update(byte abyte0[], int i, int j)
    {
        int k = i;
        k = j;
        if (azm == null)
        {
            do
            {
                k = i;
                k = j;
                if (j <= 0)
                {
                    break;
                }
                k = i;
                k = j;
                if (azj >= azi.length)
                {
                    break;
                }
                update(abyte0[i]);
                i++;
                j--;
            } while (true);
        }
        if (k > 0)
        {
            throw new NullPointerException();
        } else
        {
            return;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        boolean flag4 = false;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            ParametersWithRandom parameterswithrandom = (ParametersWithRandom)cipherparameters;
            cipherparameters = (RSAKeyParameters)parameterswithrandom.axC;
            if (flag)
            {
                amC = parameterswithrandom.amC;
            }
            boolean flag1 = flag4;
        } else
        if (cipherparameters instanceof ParametersWithSalt)
        {
            cipherparameters = (ParametersWithSalt)cipherparameters;
            cipherparameters = null;
            azg = null;
            int i = azg.length;
            if (azg.length != 0)
            {
                throw new IllegalArgumentException("Fixed salt is of wrong length");
            }
        } else
        {
            RSAKeyParameters rsakeyparameters = (RSAKeyParameters)cipherparameters;
            boolean flag2 = flag4;
            cipherparameters = rsakeyparameters;
            if (flag)
            {
                amC = new SecureRandom();
                cipherparameters = rsakeyparameters;
                boolean flag3 = flag4;
            }
        }
        throw new NullPointerException();
    }

    public final byte[] _mth14B6()
    {
        throw new NullPointerException();
    }

    public final boolean FE73(byte abyte0[])
    {
        throw new NullPointerException();
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        azf = hashtable;
        hashtable.put("RIPEMD128", Integers.valueOf(13004));
        azf.put("RIPEMD160", Integers.valueOf(12748));
        azf.put("SHA-1", Integers.valueOf(13260));
        azf.put("SHA-256", Integers.valueOf(13516));
        azf.put("SHA-384", Integers.valueOf(14028));
        azf.put("SHA-512", Integers.valueOf(13772));
        azf.put("Whirlpool", Integers.valueOf(14284));
    }
}
