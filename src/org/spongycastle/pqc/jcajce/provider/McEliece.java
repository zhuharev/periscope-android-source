// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;

public class McEliece
{
    public static class Mappings extends AsymmetricAlgorithmProvider
    {

        public final void _mth02CA(ConfigurableProvider configurableprovider)
        {
            configurableprovider._mth0640("KeyPairGenerator.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableprovider._mth0640("KeyPairGenerator.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableprovider._mth0640("KeyPairGenerator.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableprovider._mth0640("KeyPairGenerator.McEliecePKCS", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McEliece");
            configurableprovider._mth0640((new StringBuilder("KeyPairGenerator.")).append(PQCObjectIdentifiers.aKa).toString(), "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McEliece");
            configurableprovider._mth0640((new StringBuilder("KeyPairGenerator.")).append(PQCObjectIdentifiers.aKb).toString(), "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi$McElieceCCA2");
            configurableprovider._mth0640("Cipher.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
            configurableprovider._mth0640("Cipher.McEliecePointchevalWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
            configurableprovider._mth0640("Cipher.McEliecePointchevalWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval224");
            configurableprovider._mth0640("Cipher.McEliecePointchevalWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval256");
            configurableprovider._mth0640("Cipher.McEliecePointchevalWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval384");
            configurableprovider._mth0640("Cipher.McEliecePointchevalWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval512");
            configurableprovider._mth0640("Cipher.McEliecePKCS", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
            configurableprovider._mth0640("Cipher.McEliecePKCSWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
            configurableprovider._mth0640("Cipher.McEliecePKCSWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS224");
            configurableprovider._mth0640("Cipher.McEliecePKCSWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS256");
            configurableprovider._mth0640("Cipher.McEliecePKCSWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS384");
            configurableprovider._mth0640("Cipher.McEliecePKCSWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS512");
            configurableprovider._mth0640("Cipher.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
            configurableprovider._mth0640("Cipher.McElieceKobaraImaiWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
            configurableprovider._mth0640("Cipher.McElieceKobaraImaiWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai224");
            configurableprovider._mth0640("Cipher.McElieceKobaraImaiWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai256");
            configurableprovider._mth0640("Cipher.McElieceKobaraImaiWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai384");
            configurableprovider._mth0640("Cipher.McElieceKobaraImaiWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai512");
            configurableprovider._mth0640("Cipher.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
            configurableprovider._mth0640("Cipher.McElieceFujisakiWithSHA1", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
            configurableprovider._mth0640("Cipher.McElieceFujisakiWithSHA224", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki224");
            configurableprovider._mth0640("Cipher.McElieceFujisakiWithSHA256", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki256");
            configurableprovider._mth0640("Cipher.McElieceFujisakiWithSHA384", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki384");
            configurableprovider._mth0640("Cipher.McElieceFujisakiWithSHA512", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki512");
        }

        public Mappings()
        {
        }
    }


    public McEliece()
    {
    }
}
