// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.LongDigest;
import org.spongycastle.crypto.params.KeyParameter;

public class OldHMac
    implements Mac
{

    private Digest amS;
    private int auN;
    private byte auR[];
    private byte auY[];

    public OldHMac(LongDigest longdigest)
    {
        auR = new byte[64];
        auY = new byte[64];
        amS = longdigest;
        auN = longdigest._mth14AF();
    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[auN];
        amS.doFinal(abyte1, 0);
        amS.update(auY, 0, auY.length);
        amS.update(abyte1, 0, abyte1.length);
        i = amS.doFinal(abyte0, 0);
        amS.reset();
        amS.update(auR, 0, auR.length);
        return i;
    }

    public final void reset()
    {
        amS.reset();
        amS.update(auR, 0, auR.length);
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        amS.reset();
        cipherparameters = ((KeyParameter)cipherparameters).key;
        if (cipherparameters.length > 64)
        {
            amS.update(cipherparameters, 0, cipherparameters.length);
            amS.doFinal(auR, 0);
            for (int i = auN; i < auR.length; i++)
            {
                auR[i] = 0;
            }

        } else
        {
            System.arraycopy(cipherparameters, 0, auR, 0, cipherparameters.length);
            for (int j = cipherparameters.length; j < auR.length; j++)
            {
                auR[j] = 0;
            }

        }
        auY = new byte[auR.length];
        System.arraycopy(auR, 0, auY, 0, auR.length);
        for (int k = 0; k < auR.length; k++)
        {
            cipherparameters = auR;
            cipherparameters[k] = (byte)(cipherparameters[k] ^ 0x36);
        }

        for (int l = 0; l < auY.length; l++)
        {
            cipherparameters = auY;
            cipherparameters[l] = (byte)(cipherparameters[l] ^ 0x5c);
        }

        amS.update(auR, 0, auR.length);
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amS._mth14AC()).append("/HMAC").toString();
    }

    public final int _mth14B3()
    {
        return auN;
    }
}
