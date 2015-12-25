// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            McElieceCCA2KeysToParams

public class McElieceKobaraImaiCipherSpi extends AsymmetricHybridCipher
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
    public static class McElieceKobaraImai extends McElieceKobaraImaiCipherSpi
    {

        public McElieceKobaraImai()
        {
            super(new SHA1Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai224 extends McElieceKobaraImaiCipherSpi
    {

        public McElieceKobaraImai224()
        {
            super(new SHA224Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai256 extends McElieceKobaraImaiCipherSpi
    {

        public McElieceKobaraImai256()
        {
            super(new SHA256Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai384 extends McElieceKobaraImaiCipherSpi
    {

        public McElieceKobaraImai384()
        {
            super(new SHA384Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai512 extends McElieceKobaraImaiCipherSpi
    {

        public McElieceKobaraImai512()
        {
            super(new SHA512Digest(), new McElieceKobaraImaiCipher());
        }
    }


    private ByteArrayOutputStream aOg;
    private McElieceKobaraImaiCipher aOj;
    private Digest amS;

    public McElieceKobaraImaiCipherSpi()
    {
        aOg = new ByteArrayOutputStream();
        aOg = new ByteArrayOutputStream();
    }

    protected McElieceKobaraImaiCipherSpi(ExtendedDigest extendeddigest, McElieceKobaraImaiCipher mceliecekobaraimaicipher)
    {
        aOg = new ByteArrayOutputStream();
        amS = extendeddigest;
        aOj = mceliecekobaraimaicipher;
        aOg = new ByteArrayOutputStream();
    }

    public final byte[] doFinal(byte abyte0[], int i, int j)
    {
        aOg.write(abyte0, i, j);
        if (aOp != 1) goto _L2; else goto _L1
_L1:
        abyte0 = aOj;
        aOg.write(1);
        byte abyte1[] = aOg.toByteArray();
        aOg.reset();
        abyte0 = abyte0._mth06E6(abyte1);
        return abyte0;
        abyte0;
        abyte0.printStackTrace();
          goto _L3
_L2:
        if (aOp != 2) goto _L3; else goto _L4
_L4:
        abyte0 = aOg.toByteArray();
        aOg.reset();
        abyte0 = aOj._mth0E40(abyte0);
        i = abyte0.length - 1;
          goto _L5
_L7:
        if (abyte0[i] == 1)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        throw new BadPaddingException("invalid ciphertext");
        byte abyte2[];
        abyte2 = new byte[i];
        System.arraycopy(abyte0, 0, abyte2, 0, i);
        return abyte2;
        abyte0;
        abyte0.printStackTrace();
_L3:
        return null;
_L5:
        while (i >= 0 && abyte0[i] == 0) 
        {
            i--;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final byte[] update(byte abyte0[], int i, int j)
    {
        aOg.write(abyte0, i, j);
        return new byte[0];
    }

    protected final void _mth02CA(Key key, SecureRandom securerandom)
    {
        aOg.reset();
        key = new ParametersWithRandom(McElieceCCA2KeysToParams._mth02BD((PublicKey)key), securerandom);
        amS.reset();
        aOj._mth02CA(true, key);
    }

    protected final void _mth02CB(Key key)
    {
        aOg.reset();
        key = McElieceCCA2KeysToParams._mth02BB((PrivateKey)key);
        amS.reset();
        aOj._mth02CA(false, key);
    }

    public final int _mth02CE(Key key)
    {
        if (key instanceof PublicKey)
        {
            return McElieceKobaraImaiCipher._mth02CA((McElieceCCA2KeyParameters)McElieceCCA2KeysToParams._mth02BD((PublicKey)key));
        }
        if (key instanceof PrivateKey)
        {
            return McElieceKobaraImaiCipher._mth02CA((McElieceCCA2KeyParameters)McElieceCCA2KeysToParams._mth02BB((PrivateKey)key));
        } else
        {
            throw new InvalidKeyException();
        }
    }
}
