// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DHBasicAgreement
    implements BasicAgreement
{

    private DHPrivateKeyParameters amI;
    private DHParameters amJ;

    public DHBasicAgreement()
    {
    }

    public final int getFieldSize()
    {
        return (((DHKeyParameters) (amI)).axb.amM.bitLength() + 7) / 8;
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters = (AsymmetricKeyParameter)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            cipherparameters = (AsymmetricKeyParameter)cipherparameters;
        }
        if (!(cipherparameters instanceof DHPrivateKeyParameters))
        {
            throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
        } else
        {
            amI = (DHPrivateKeyParameters)cipherparameters;
            amJ = ((DHKeyParameters) (amI)).axb;
            return;
        }
    }

    public final BigInteger _mth02CB(CipherParameters cipherparameters)
    {
        cipherparameters = (DHPublicKeyParameters)cipherparameters;
        if (!((DHKeyParameters) (cipherparameters)).axb.equals(amJ))
        {
            throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
        } else
        {
            return ((DHPublicKeyParameters) (cipherparameters)).axe.modPow(amI.amZ, amJ.amM);
        }
    }
}
