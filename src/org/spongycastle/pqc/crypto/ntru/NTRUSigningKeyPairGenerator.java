// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUSigningKeyGenerationParameters

public class NTRUSigningKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{
    class BasisGenerationTask
        implements Callable
    {

        private NTRUSigningKeyPairGenerator aNk;

        public Object call()
        {
            NTRUSigningKeyPairGenerator ntrusigningkeypairgenerator = aNk;
            throw new NullPointerException();
        }

        private BasisGenerationTask()
        {
            aNk = NTRUSigningKeyPairGenerator.this;
            super();
        }

        BasisGenerationTask(byte byte0)
        {
            this();
        }
    }

    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis
    {

        private NTRUSigningKeyPairGenerator aNk;
        public IntegerPolynomial aNl;
        public IntegerPolynomial aNm;

        FGBasis(Polynomial polynomial, Polynomial polynomial1, IntegerPolynomial integerpolynomial, IntegerPolynomial integerpolynomial1, IntegerPolynomial integerpolynomial2, NTRUSigningKeyGenerationParameters ntrusigningkeygenerationparameters)
        {
            aNk = NTRUSigningKeyPairGenerator.this;
            super(polynomial, polynomial1, integerpolynomial, ntrusigningkeygenerationparameters);
            aNl = integerpolynomial1;
            aNm = integerpolynomial2;
        }
    }


    public NTRUSigningKeyPairGenerator()
    {
    }

    static void _mth02CA(IntegerPolynomial integerpolynomial, IntegerPolynomial integerpolynomial1, IntegerPolynomial integerpolynomial2, IntegerPolynomial integerpolynomial3, int i)
    {
        int l = 0;
        for (int j = 0; j < i; j++)
        {
            l += i * 2 * (integerpolynomial.aPb[j] * integerpolynomial.aPb[j] + integerpolynomial1.aPb[j] * integerpolynomial1.aPb[j]);
        }

        int l2 = l - 4;
        IntegerPolynomial integerpolynomial4 = (IntegerPolynomial)integerpolynomial.clone();
        IntegerPolynomial integerpolynomial5 = (IntegerPolynomial)integerpolynomial1.clone();
        int k = 0;
        int i1;
        for (int j1 = 0; j1 < i && k < i; j1 = i1)
        {
            i1 = 0;
            for (int k1 = 0; k1 < i; k1++)
            {
                i1 += i * 4 * (integerpolynomial2.aPb[k1] * integerpolynomial.aPb[k1] + integerpolynomial3.aPb[k1] * integerpolynomial1.aPb[k1]);
            }

            int l1 = 0;
            for (int i2 = 0; i2 < integerpolynomial2.aPb.length; i2++)
            {
                l1 += integerpolynomial2.aPb[i2];
            }

            int k2 = 0;
            for (int j2 = 0; j2 < integerpolynomial3.aPb.length; j2++)
            {
                k2 += integerpolynomial3.aPb[j2];
            }

            l1 = i1 - (l1 + k2) * 4;
            if (l1 > l2)
            {
                integerpolynomial2._mth02CF(integerpolynomial4);
                integerpolynomial3._mth02CF(integerpolynomial5);
                i1 = j1 + 1;
                k = 0;
            } else
            {
                i1 = j1;
                if (l1 < -l2)
                {
                    integerpolynomial2._mth02CE(integerpolynomial4);
                    integerpolynomial3._mth02CE(integerpolynomial5);
                    i1 = j1 + 1;
                    k = 0;
                }
            }
            k++;
            integerpolynomial4._mth1625();
            integerpolynomial5._mth1625();
        }

    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        Executors.newCachedThreadPool();
        new ArrayList();
        throw new NullPointerException();
    }
}
