// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
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
import org.spongycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePKCSCipher;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.Vector;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            McElieceKeysToParams

public class McEliecePKCSCipherSpi extends AsymmetricBlockCipher
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
    public static class McEliecePKCS extends McEliecePKCSCipherSpi
    {

        public McEliecePKCS()
        {
            super(new SHA1Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS224 extends McEliecePKCSCipherSpi
    {

        public McEliecePKCS224()
        {
            super(new SHA224Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS256 extends McEliecePKCSCipherSpi
    {

        public McEliecePKCS256()
        {
            super(new SHA256Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS384 extends McEliecePKCSCipherSpi
    {

        public McEliecePKCS384()
        {
            super(new SHA384Digest(), new McEliecePKCSCipher());
        }
    }

    public static class McEliecePKCS512 extends McEliecePKCSCipherSpi
    {

        public McEliecePKCS512()
        {
            super(new SHA512Digest(), new McEliecePKCSCipher());
        }
    }


    private McEliecePKCSCipher aOk;
    private Digest amS;

    public McEliecePKCSCipherSpi(ExtendedDigest extendeddigest, McEliecePKCSCipher mceliecepkcscipher)
    {
        amS = extendeddigest;
        aOk = mceliecepkcscipher;
    }

    protected final void _mth02CA(Key key, SecureRandom securerandom)
    {
        key = new ParametersWithRandom(McElieceKeysToParams._mth037A((PublicKey)key), securerandom);
        amS.reset();
        aOk._mth02CA(true, key);
        aMe = aOk.aMe;
        aMf = aOk.aMf;
    }

    protected final void _mth02CB(Key key)
    {
        key = McElieceKeysToParams._mth02BC((PrivateKey)key);
        amS.reset();
        aOk._mth02CA(false, key);
        aMe = aOk.aMe;
        aMf = aOk.aMf;
    }

    public final int _mth02CE(Key key)
    {
        if (key instanceof PublicKey)
        {
            key = (McElieceKeyParameters)McElieceKeysToParams._mth037A((PublicKey)key);
        } else
        {
            key = (McElieceKeyParameters)McElieceKeysToParams._mth02BC((PrivateKey)key);
        }
        return McEliecePKCSCipher._mth02CA(key);
    }

    protected final byte[] _mth06E6(byte abyte0[])
    {
        McEliecePKCSCipher mceliecepkcscipher;
        int j;
        mceliecepkcscipher = aOk;
        j = mceliecepkcscipher.aMe;
        int i;
        if ((mceliecepkcscipher.afK & 7) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            byte abyte1[] = new byte[j + i];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            abyte1[abyte0.length] = 1;
            abyte0 = GF2Vector._mth02CB(mceliecepkcscipher.afK, abyte1);
            GF2Vector gf2vector = new GF2Vector(mceliecepkcscipher.axg, mceliecepkcscipher.aJP, mceliecepkcscipher.asp);
            abyte0 = ((GF2Vector)((McEliecePublicKeyParameters)mceliecepkcscipher.aMg).aMk._mth02CB(abyte0)._mth141D(gf2vector)).getEncoded();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

    protected final byte[] _mth0E40(byte abyte0[])
    {
        McEliecePKCSCipher mceliecepkcscipher;
        Object obj;
        Object obj1;
        Object obj2;
        org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM polynomialgf2msmallm;
        GF2Matrix gf2matrix;
        GF2Vector gf2vector;
        Permutation permutation;
        org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM apolynomialgf2msmallm[];
        int i;
        try
        {
            mceliecepkcscipher = aOk;
            gf2vector = GF2Vector._mth02CB(mceliecepkcscipher.axg, abyte0);
            obj1 = (McEliecePrivateKeyParameters)mceliecepkcscipher.aMg;
            obj2 = ((McEliecePrivateKeyParameters) (obj1)).aLU;
            polynomialgf2msmallm = ((McEliecePrivateKeyParameters) (obj1)).aLV;
            abyte0 = ((McEliecePrivateKeyParameters) (obj1)).aMh;
            obj = ((McEliecePrivateKeyParameters) (obj1)).aMi;
            permutation = ((McEliecePrivateKeyParameters) (obj1)).aMj;
            gf2matrix = ((McEliecePrivateKeyParameters) (obj1)).aLX;
            apolynomialgf2msmallm = ((McEliecePrivateKeyParameters) (obj1)).aLY;
            if (permutation.aOL.length != ((Permutation) (obj)).aOL.length)
            {
                throw new IllegalArgumentException("length mismatch");
            }
            obj1 = new Permutation(((Permutation) (obj)).aOL.length);
            i = ((Permutation) (obj)).aOL.length - 1;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((Permutation) (obj1)).aOL[i] = ((Permutation) (obj)).aOL[permutation.aOL[i]];
        i--;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_118;
_L1:
        gf2vector = (GF2Vector)gf2vector._mth02CB(((Permutation) (obj1))._mth1539());
        obj2 = GoppaCode._mth02CA((GF2Vector)gf2matrix._mth02CF(gf2vector), ((org.spongycastle.pqc.math.linearalgebra.GF2mField) (obj2)), polynomialgf2msmallm, apolynomialgf2msmallm);
        obj = (GF2Vector)((GF2Vector)gf2vector._mth141D(((GF2Vector) (obj2))))._mth02CB(((Permutation) (obj)));
        ((GF2Vector) (obj2))._mth02CB(((Permutation) (obj1)));
        abyte0 = McEliecePKCSCipher._mth02CA((GF2Vector)abyte0._mth02CB(((GF2Vector) (obj)).FEE8(mceliecepkcscipher.afK)));
        return abyte0;
    }
}
