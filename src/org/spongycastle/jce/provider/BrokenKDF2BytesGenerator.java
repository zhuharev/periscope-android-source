// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.params.KDFParameters;

public class BrokenKDF2BytesGenerator
    implements DerivationFunction
{

    private byte atS[];
    private byte iv[];

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        if (abyte0.length - j < i)
        {
            throw new DataLengthException("output buffer too small");
        } else
        {
            long l = j << 3;
            throw new NullPointerException();
        }
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        if (!(derivationparameters instanceof KDFParameters))
        {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        } else
        {
            derivationparameters = (KDFParameters)derivationparameters;
            atS = ((KDFParameters) (derivationparameters)).atS;
            iv = ((KDFParameters) (derivationparameters)).iv;
            return;
        }
    }
}
