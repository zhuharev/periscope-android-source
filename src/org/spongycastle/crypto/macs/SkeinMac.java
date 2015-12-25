// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SkeinEngine;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Integers;

public class SkeinMac
    implements Mac
{

    private SkeinEngine aoB;

    public SkeinMac(int i, int j)
    {
        aoB = new SkeinEngine(i, j);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        return aoB.doFinal(abyte0, 0);
    }

    public final void reset()
    {
        aoB.reset();
    }

    public final void update(byte byte0)
    {
        aoB.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        SkeinEngine skeinengine = aoB;
        skeinengine.aoJ._mth02CA(abyte0, i, j, skeinengine.aoF);
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof SkeinParameters)
        {
            cipherparameters = (SkeinParameters)cipherparameters;
        } else
        if (cipherparameters instanceof KeyParameter)
        {
            org.spongycastle.crypto.params.SkeinParameters.Builder builder = new org.spongycastle.crypto.params.SkeinParameters.Builder();
            cipherparameters = ((KeyParameter)cipherparameters).key;
            if (cipherparameters == null)
            {
                throw new IllegalArgumentException("Parameter value must not be null.");
            }
            builder.axJ.put(Integers.valueOf(0), cipherparameters);
            cipherparameters = new SkeinParameters(builder.axJ, (byte)0);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Invalid parameter passed to Skein MAC init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        if ((byte[])((SkeinParameters) (cipherparameters)).axJ.get(Integers.valueOf(0)) == null)
        {
            throw new IllegalArgumentException("Skein MAC requires a key parameter.");
        } else
        {
            aoB._mth02CA(cipherparameters);
            return;
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder("Skein-MAC-")).append(aoB.aoD.atu << 3).append("-").append(aoB.aoE << 3).toString();
    }

    public final int _mth14B3()
    {
        return aoB.aoE;
    }
}
