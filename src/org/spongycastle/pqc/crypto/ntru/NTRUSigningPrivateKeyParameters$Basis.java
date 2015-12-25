// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUSigningPrivateKeyParameters, NTRUSigningKeyGenerationParameters

public static class aNr
{

    public IntegerPolynomial aMS;
    public Polynomial aNp;
    public Polynomial aNq;
    NTRUSigningKeyGenerationParameters aNr;

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
        if (!(obj instanceof aNr))
        {
            return false;
        }
        obj = (aNr)obj;
        if (aNp == null)
        {
            if (((aNp) (obj)).aNp != null)
            {
                return false;
            }
        } else
        if (!aNp.equals(((aNp) (obj)).aNp))
        {
            return false;
        }
        if (aNq == null)
        {
            if (((aNq) (obj)).aNq != null)
            {
                return false;
            }
        } else
        if (!aNq.equals(((aNq) (obj)).aNq))
        {
            return false;
        }
        if (aMS == null)
        {
            if (((aMS) (obj)).aMS != null)
            {
                return false;
            }
        } else
        if (!aMS.equals(((aMS) (obj)).aMS))
        {
            return false;
        }
        if (aNr == null)
        {
            if (((aNr) (obj)).aNr != null)
            {
                return false;
            }
        } else
        if (!aNr.equals(((als) (obj)).aNr))
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        int i;
        if (aNp == null)
        {
            i = 0;
        } else
        {
            i = aNp.hashCode();
        }
        int j;
        if (aNq == null)
        {
            j = 0;
        } else
        {
            j = aNq.hashCode();
        }
        int k;
        if (aMS == null)
        {
            k = 0;
        } else
        {
            k = aMS.hashCode();
        }
        int l;
        if (aNr == null)
        {
            l = 0;
        } else
        {
            l = aNr.hashCode();
        }
        return (((i + 31) * 31 + j) * 31 + k) * 31 + l;
    }

    protected (Polynomial polynomial, Polynomial polynomial1, IntegerPolynomial integerpolynomial, NTRUSigningKeyGenerationParameters ntrusigningkeygenerationparameters)
    {
        aNp = polynomial;
        aNq = polynomial1;
        aMS = integerpolynomial;
        aNr = ntrusigningkeygenerationparameters;
    }
}
