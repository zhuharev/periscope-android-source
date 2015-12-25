// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUSigningParameters

public class NTRUSigningPublicKeyParameters extends AsymmetricKeyParameter
{

    private IntegerPolynomial aMS;
    private NTRUSigningParameters aNs;

    public NTRUSigningPublicKeyParameters(IntegerPolynomial integerpolynomial, NTRUSigningParameters ntrusigningparameters)
    {
        super(false);
        aMS = integerpolynomial;
        aNs = ntrusigningparameters;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (NTRUSigningPublicKeyParameters)obj;
        if (aMS == null)
        {
            if (((NTRUSigningPublicKeyParameters) (obj)).aMS != null)
            {
                return false;
            }
        } else
        if (!aMS.equals(((NTRUSigningPublicKeyParameters) (obj)).aMS))
        {
            return false;
        }
        if (aNs == null)
        {
            if (((NTRUSigningPublicKeyParameters) (obj)).aNs != null)
            {
                return false;
            }
        } else
        if (!aNs.equals(((NTRUSigningPublicKeyParameters) (obj)).aNs))
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        int i;
        if (aMS == null)
        {
            i = 0;
        } else
        {
            i = aMS.hashCode();
        }
        int j;
        if (aNs == null)
        {
            j = 0;
        } else
        {
            j = aNs.hashCode();
        }
        return (i + 31) * 31 + j;
    }
}
