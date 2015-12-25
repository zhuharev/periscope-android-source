// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUSigningKeyGenerationParameters, NTRUSigningPublicKeyParameters

public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter
{
    public static class Basis
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
            if (!(obj instanceof Basis))
            {
                return false;
            }
            obj = (Basis)obj;
            if (aNp == null)
            {
                if (((Basis) (obj)).aNp != null)
                {
                    return false;
                }
            } else
            if (!aNp.equals(((Basis) (obj)).aNp))
            {
                return false;
            }
            if (aNq == null)
            {
                if (((Basis) (obj)).aNq != null)
                {
                    return false;
                }
            } else
            if (!aNq.equals(((Basis) (obj)).aNq))
            {
                return false;
            }
            if (aMS == null)
            {
                if (((Basis) (obj)).aMS != null)
                {
                    return false;
                }
            } else
            if (!aMS.equals(((Basis) (obj)).aMS))
            {
                return false;
            }
            if (aNr == null)
            {
                if (((Basis) (obj)).aNr != null)
                {
                    return false;
                }
            } else
            if (!aNr.equals(((Basis) (obj)).aNr))
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

        protected Basis(Polynomial polynomial, Polynomial polynomial1, IntegerPolynomial integerpolynomial, NTRUSigningKeyGenerationParameters ntrusigningkeygenerationparameters)
        {
            aNp = polynomial;
            aNq = polynomial1;
            aMS = integerpolynomial;
            aNr = ntrusigningkeygenerationparameters;
        }
    }


    private ArrayList aNn;
    private NTRUSigningPublicKeyParameters aNo;

    public NTRUSigningPrivateKeyParameters(ArrayList arraylist, NTRUSigningPublicKeyParameters ntrusigningpublickeyparameters)
    {
        super(true);
        aNn = new ArrayList(arraylist);
        aNo = ntrusigningpublickeyparameters;
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
        obj = (NTRUSigningPrivateKeyParameters)obj;
        if (aNn == null && ((NTRUSigningPrivateKeyParameters) (obj)).aNn != null)
        {
            return false;
        }
        if (aNn.size() != ((NTRUSigningPrivateKeyParameters) (obj)).aNn.size())
        {
            return false;
        }
        for (int i = 0; i < aNn.size(); i++)
        {
            Basis basis = (Basis)aNn.get(i);
            Basis basis1 = (Basis)((NTRUSigningPrivateKeyParameters) (obj)).aNn.get(i);
            if (!basis.aNp.equals(basis1.aNp))
            {
                return false;
            }
            if (!basis.aNq.equals(basis1.aNq))
            {
                return false;
            }
            if (i != 0 && !basis.aMS.equals(basis1.aMS))
            {
                return false;
            }
            if (!basis.aNr.equals(basis1.aNr))
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        int i;
        if (aNn == null)
        {
            i = 0;
        } else
        {
            i = aNn.hashCode();
        }
        i += 31;
        for (Iterator iterator = aNn.iterator(); iterator.hasNext();)
        {
            i += ((Basis)iterator.next()).hashCode();
        }

        return i;
    }
}
