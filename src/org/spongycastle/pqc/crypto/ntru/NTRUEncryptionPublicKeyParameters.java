// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUEncryptionKeyParameters, NTRUEncryptionParameters

public class NTRUEncryptionPublicKeyParameters extends NTRUEncryptionKeyParameters
{

    public IntegerPolynomial aMS;

    public NTRUEncryptionPublicKeyParameters(IntegerPolynomial integerpolynomial, NTRUEncryptionParameters ntruencryptionparameters)
    {
        super(false, ntruencryptionparameters);
        aMS = integerpolynomial;
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
        if (!(obj instanceof NTRUEncryptionPublicKeyParameters))
        {
            return false;
        }
        obj = (NTRUEncryptionPublicKeyParameters)obj;
        if (aMS == null)
        {
            if (((NTRUEncryptionPublicKeyParameters) (obj)).aMS != null)
            {
                return false;
            }
        } else
        if (!aMS.equals(((NTRUEncryptionPublicKeyParameters) (obj)).aMS))
        {
            return false;
        }
        if (aMP == null)
        {
            if (((NTRUEncryptionPublicKeyParameters) (obj)).aMP != null)
            {
                return false;
            }
        } else
        if (!aMP.equals(((NTRUEncryptionPublicKeyParameters) (obj)).aMP))
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
        if (aMP == null)
        {
            j = 0;
        } else
        {
            j = aMP.hashCode();
        }
        return (i + 31) * 31 + j;
    }
}
