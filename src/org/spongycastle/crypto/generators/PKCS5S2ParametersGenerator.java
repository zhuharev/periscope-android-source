// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator
{

    private byte aob[];
    private HMac auv;

    public PKCS5S2ParametersGenerator()
    {
        this(((ExtendedDigest) (new SHA1Digest())));
    }

    public PKCS5S2ParametersGenerator(ExtendedDigest extendeddigest)
    {
        auv = new HMac(extendeddigest);
        aob = new byte[auv._mth14B3()];
    }

    private byte[] FEF3(int i)
    {
        int j1 = auv._mth14B3();
        int k1 = ((i + j1) - 1) / j1;
        byte abyte0[] = new byte[4];
        byte abyte1[] = new byte[k1 * j1];
        int j = 0;
        KeyParameter keyparameter = new KeyParameter(amG);
        auv._mth02CA(keyparameter);
        for (i = 1; i <= k1; i++)
        {
            int k = 3;
            do
            {
                byte byte0 = (byte)(abyte0[k] + 1);
                abyte0[k] = byte0;
                if (byte0 != 0)
                {
                    break;
                }
                k--;
            } while (true);
            byte abyte2[] = aaN;
            int l1 = amH;
            if (l1 == 0)
            {
                throw new IllegalArgumentException("iteration count must be at least 1.");
            }
            if (abyte2 != null)
            {
                auv.update(abyte2, 0, abyte2.length);
            }
            auv.update(abyte0, 0, 4);
            auv.doFinal(aob, 0);
            System.arraycopy(aob, 0, abyte1, j, aob.length);
            for (int l = 1; l < l1; l++)
            {
                auv.update(aob, 0, aob.length);
                auv.doFinal(aob, 0);
                for (int i1 = 0; i1 != aob.length; i1++)
                {
                    int i2 = j + i1;
                    abyte1[i2] = (byte)(abyte1[i2] ^ aob[i1]);
                }

            }

            j += j1;
        }

        return abyte1;
    }

    public final KeyParameter _mth155D(int i)
    {
        i /= 8;
        return new KeyParameter(FEF3(i), 0, i);
    }

    public final CipherParameters _mth1D52(int i)
    {
        i /= 8;
        return new KeyParameter(FEF3(i), 0, i);
    }

    public final ParametersWithIV _mth1D63(int i, int j)
    {
        i /= 8;
        j /= 8;
        byte abyte0[] = FEF3(i + j);
        return new ParametersWithIV(new KeyParameter(abyte0, 0, i), abyte0, i, j);
    }
}
