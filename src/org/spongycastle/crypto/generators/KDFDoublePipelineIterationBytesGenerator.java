// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class KDFDoublePipelineIterationBytesGenerator
    implements MacDerivationFunction
{

    private static final BigInteger ars = BigInteger.valueOf(2L);
    private static final BigInteger auj = BigInteger.valueOf(0x7fffffffL);
    private int aui;
    private final Mac auk;
    private int aun;
    private byte auo[];
    private byte aup[];
    private boolean auq;
    private final int h;

    private void FF6B()
    {
        if (aui == 0)
        {
            auk.update(aup, 0, aup.length);
            auk.doFinal(null, 0);
        } else
        {
            auk.update(null, 0, null.length);
            auk.doFinal(null, 0);
        }
        auk.update(null, 0, null.length);
        if (auq)
        {
            int i = aui / h + 1;
            switch (auo.length)
            {
            case 4: // '\004'
                auo[0] = i >> 24;
                // fall through

            case 3: // '\003'
                auo[auo.length - 3] = (byte)(i >>> 16);
                // fall through

            case 2: // '\002'
                auo[auo.length - 2] = (byte)(i >>> 8);
                // fall through

            case 1: // '\001'
                auo[auo.length - 1] = (byte)i;
                break;

            default:
                throw new IllegalStateException("Unsupported size of counter i");
            }
            auk.update(auo, 0, auo.length);
        }
        auk.update(aup, 0, aup.length);
        auk.doFinal(null, 0);
    }

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        int k = aui + j;
        if (k < 0 || k >= aun)
        {
            throw new DataLengthException((new StringBuilder("Current KDFCTR may only be used for ")).append(aun).append(" bytes").toString());
        }
        if (aui % h == 0)
        {
            FF6B();
        }
        k = aui;
        int i1 = h;
        int l = Math.min(h - aui % h, j);
        System.arraycopy(null, k % i1, abyte0, i, l);
        aui = aui + l;
        k = j - l;
        for (i += l; k > 0; i += l)
        {
            FF6B();
            l = Math.min(h, k);
            System.arraycopy(null, 0, abyte0, i, l);
            aui = aui + l;
            k -= l;
        }

        return j;
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        if (!(derivationparameters instanceof KDFDoublePipelineIterationParameters))
        {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        derivationparameters = (KDFDoublePipelineIterationParameters)derivationparameters;
        auk._mth02CA(new KeyParameter(((KDFDoublePipelineIterationParameters) (derivationparameters)).axt));
        aup = Arrays._mth1D4C(((KDFDoublePipelineIterationParameters) (derivationparameters)).aup);
        int i = ((KDFDoublePipelineIterationParameters) (derivationparameters)).axu;
        auo = new byte[i / 8];
        if (((KDFDoublePipelineIterationParameters) (derivationparameters)).auq)
        {
            BigInteger biginteger = ars.pow(i).multiply(BigInteger.valueOf(h));
            if (biginteger.compareTo(auj) == 1)
            {
                i = 0x7fffffff;
            } else
            {
                i = biginteger.intValue();
            }
            aun = i;
        } else
        {
            aun = 0x7fffffff;
        }
        auq = ((KDFDoublePipelineIterationParameters) (derivationparameters)).auq;
        aui = 0;
    }

}
