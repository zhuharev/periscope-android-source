// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUEncryptionKeyParameters, NTRUEncryptionParameters

public class NTRUEncryptionPrivateKeyParameters extends NTRUEncryptionKeyParameters
{

    public Polynomial aMQ;
    public IntegerPolynomial aMR;
    public IntegerPolynomial aMS;

    public NTRUEncryptionPrivateKeyParameters(IntegerPolynomial integerpolynomial, Polynomial polynomial, IntegerPolynomial integerpolynomial1, NTRUEncryptionParameters ntruencryptionparameters)
    {
        super(true, ntruencryptionparameters);
        aMS = integerpolynomial;
        aMQ = polynomial;
        aMR = integerpolynomial1;
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
        if (!(obj instanceof NTRUEncryptionPrivateKeyParameters))
        {
            return false;
        }
        obj = (NTRUEncryptionPrivateKeyParameters)obj;
        if (aMP == null)
        {
            if (((NTRUEncryptionPrivateKeyParameters) (obj)).aMP != null)
            {
                return false;
            }
        } else
        if (!aMP.equals(((NTRUEncryptionPrivateKeyParameters) (obj)).aMP))
        {
            return false;
        }
        if (aMQ == null)
        {
            if (((NTRUEncryptionPrivateKeyParameters) (obj)).aMQ != null)
            {
                return false;
            }
        } else
        if (!aMQ.equals(((NTRUEncryptionPrivateKeyParameters) (obj)).aMQ))
        {
            return false;
        }
        return aMS.equals(((NTRUEncryptionPrivateKeyParameters) (obj)).aMS);
    }

    public int hashCode()
    {
        int i;
        if (aMP == null)
        {
            i = 0;
        } else
        {
            i = aMP.hashCode();
        }
        int j;
        if (aMQ == null)
        {
            j = 0;
        } else
        {
            j = aMQ.hashCode();
        }
        int k;
        if (aMS == null)
        {
            k = 0;
        } else
        {
            k = aMS.hashCode();
        }
        return ((i + 31) * 31 + j) * 31 + k;
    }
}
