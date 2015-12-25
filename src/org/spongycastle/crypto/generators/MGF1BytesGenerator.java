// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.params.MGFParameters;

public class MGF1BytesGenerator
    implements DerivationFunction
{

    private byte aln[];

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        if (abyte0.length - j < i)
        {
            throw new DataLengthException("output buffer too small");
        } else
        {
            abyte0 = new byte[4];
            throw new NullPointerException();
        }
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        if (!(derivationparameters instanceof MGFParameters))
        {
            throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
        } else
        {
            derivationparameters = (MGFParameters)derivationparameters;
            aln = null;
            return;
        }
    }
}
