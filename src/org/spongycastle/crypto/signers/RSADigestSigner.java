// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class RSADigestSigner
    implements Signer
{

    private static final Hashtable azA;
    private final AlgorithmIdentifier aaK;
    private final Digest amS;
    private boolean ayZ;
    private final PKCS1Encoding azz = new PKCS1Encoding(new RSABlindedEngine());

    public RSADigestSigner(Digest digest, ASN1ObjectIdentifier asn1objectidentifier)
    {
        amS = digest;
        aaK = new AlgorithmIdentifier(asn1objectidentifier, DERNull.WL);
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        ayZ = flag;
        AsymmetricKeyParameter asymmetrickeyparameter;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            asymmetrickeyparameter = (AsymmetricKeyParameter)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            asymmetrickeyparameter = (AsymmetricKeyParameter)cipherparameters;
        }
        if (flag && !asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!flag && asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("verification requires public key");
        } else
        {
            amS.reset();
            azz._mth02CA(flag, cipherparameters);
            return;
        }
    }

    public final byte[] _mth14B6()
    {
        if (!ayZ)
        {
            throw new IllegalStateException("RSADigestSigner not initialised for signature generation.");
        }
        byte abyte0[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte0, 0);
        try
        {
            abyte0 = (new DigestInfo(aaK, abyte0)).getEncoded("DER");
            abyte0 = azz._mth1FBE(abyte0, 0, abyte0.length);
        }
        catch (IOException ioexception)
        {
            throw new CryptoException((new StringBuilder("unable to encode signature: ")).append(ioexception.getMessage()).toString(), ioexception);
        }
        return abyte0;
    }

    public final boolean FE73(byte abyte0[])
    {
        if (ayZ)
        {
            throw new IllegalStateException("RSADigestSigner not initialised for verification");
        }
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        byte abyte2[];
        try
        {
            abyte0 = azz._mth1FBE(abyte0, 0, abyte0.length);
            abyte2 = (new DigestInfo(aaK, abyte1)).getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return false;
        }
        if (abyte0.length == abyte2.length)
        {
            return Arrays._mth1428(abyte0, abyte2);
        }
        if (abyte0.length == abyte2.length - 2)
        {
            int l = abyte0.length - abyte1.length - 2;
            int i1 = abyte2.length;
            int j1 = abyte1.length;
            abyte2[1] = (byte)(abyte2[1] - 2);
            abyte2[3] = (byte)(abyte2[3] - 2);
            int i = 0;
            for (int j = 0; j < abyte1.length; j++)
            {
                i |= abyte0[l + j] ^ abyte2[(i1 - j1 - 2) + j];
            }

            for (int k = 0; k < l; k++)
            {
                i |= abyte0[k] ^ abyte2[k];
            }

            return i == 0;
        } else
        {
            return false;
        }
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        azA = hashtable;
        hashtable.put("RIPEMD128", TeleTrusTObjectIdentifiers.afk);
        azA.put("RIPEMD160", TeleTrusTObjectIdentifiers.afj);
        azA.put("RIPEMD256", TeleTrusTObjectIdentifiers.afl);
        azA.put("SHA-1", X509ObjectIdentifiers.akD);
        azA.put("SHA-224", NISTObjectIdentifiers.ZG);
        azA.put("SHA-256", NISTObjectIdentifiers.ZD);
        azA.put("SHA-384", NISTObjectIdentifiers.ZE);
        azA.put("SHA-512", NISTObjectIdentifiers.ZF);
        azA.put("SHA-512/224", NISTObjectIdentifiers.ZH);
        azA.put("SHA-512/256", NISTObjectIdentifiers.ZI);
        azA.put("MD2", PKCSObjectIdentifiers.abA);
        azA.put("MD4", PKCSObjectIdentifiers.abB);
        azA.put("MD5", PKCSObjectIdentifiers.abC);
    }
}
