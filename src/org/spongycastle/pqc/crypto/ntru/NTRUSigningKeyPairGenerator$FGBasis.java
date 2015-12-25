// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUSigningKeyPairGenerator, NTRUSigningKeyGenerationParameters

public class aNm extends s
{

    private NTRUSigningKeyPairGenerator aNk;
    public IntegerPolynomial aNl;
    public IntegerPolynomial aNm;

    s(NTRUSigningKeyPairGenerator ntrusigningkeypairgenerator, Polynomial polynomial, Polynomial polynomial1, IntegerPolynomial integerpolynomial, IntegerPolynomial integerpolynomial1, IntegerPolynomial integerpolynomial2, NTRUSigningKeyGenerationParameters ntrusigningkeygenerationparameters)
    {
        aNk = ntrusigningkeypairgenerator;
        super(polynomial, polynomial1, integerpolynomial, ntrusigningkeygenerationparameters);
        aNl = integerpolynomial1;
        aNm = integerpolynomial2;
    }
}
