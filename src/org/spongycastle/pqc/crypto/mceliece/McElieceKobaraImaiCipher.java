// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.prng.DigestRandomGenerator;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.ByteUtils;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.IntegerFunctions;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2PublicKeyParameters, McElieceCCA2PrivateKeyParameters, McElieceCCA2KeyParameters, McElieceCCA2Parameters, 
//            Conversions, McElieceCCA2Primitives

public class McElieceKobaraImaiCipher
    implements MessageEncryptor
{

    private static byte aMd[] = "a predetermined public constant".getBytes();
    private int aJP;
    private Digest aKp;
    private McElieceCCA2KeyParameters aMa;
    private int afK;
    private SecureRandom asp;
    private int axg;

    public McElieceKobaraImaiCipher()
    {
    }

    public static int _mth02CA(McElieceCCA2KeyParameters mceliececca2keyparameters)
    {
        if (mceliececca2keyparameters instanceof McElieceCCA2PublicKeyParameters)
        {
            return ((McElieceCCA2PublicKeyParameters)mceliececca2keyparameters).axg;
        }
        if (mceliececca2keyparameters instanceof McElieceCCA2PrivateKeyParameters)
        {
            return ((McElieceCCA2PrivateKeyParameters)mceliececca2keyparameters).axg;
        } else
        {
            throw new IllegalArgumentException("unsupported type");
        }
    }

    private void _mth02CA(McElieceCCA2PublicKeyParameters mceliececca2publickeyparameters)
    {
        aKp = ((McElieceCCA2KeyParameters) (mceliececca2publickeyparameters)).aLQ.aLT;
        axg = mceliececca2publickeyparameters.axg;
        afK = mceliececca2publickeyparameters.aLZ.getNumRows();
        aJP = mceliececca2publickeyparameters.aJP;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                asp = ((ParametersWithRandom) (cipherparameters)).amC;
                aMa = (McElieceCCA2PublicKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                _mth02CA((McElieceCCA2PublicKeyParameters)aMa);
                return;
            } else
            {
                asp = new SecureRandom();
                aMa = (McElieceCCA2PublicKeyParameters)cipherparameters;
                _mth02CA((McElieceCCA2PublicKeyParameters)aMa);
                return;
            }
        }
        aMa = (McElieceCCA2PrivateKeyParameters)cipherparameters;
        cipherparameters = (McElieceCCA2PrivateKeyParameters)aMa;
        aKp = ((McElieceCCA2KeyParameters) (cipherparameters)).aLQ.aLT;
        axg = ((McElieceCCA2PrivateKeyParameters) (cipherparameters)).axg;
        afK = ((McElieceCCA2PrivateKeyParameters) (cipherparameters)).afK;
        cipherparameters = ((McElieceCCA2PrivateKeyParameters) (cipherparameters)).aLV;
        int i = ((PolynomialGF2mSmallM) (cipherparameters)).aOM.length - 1;
        if (((PolynomialGF2mSmallM) (cipherparameters)).aOM[i] == 0)
        {
            i = -1;
        }
        aJP = i;
    }

    public final byte[] _mth06E6(byte abyte0[])
    {
        int k1 = aKp._mth14AF();
        int i1 = afK >> 3;
        int j1 = IntegerFunctions._mth1D57(axg, aJP).bitLength() - 1 >> 3;
        int l = (i1 + j1) - k1 - aMd.length;
        int i = l;
        if (abyte0.length > l)
        {
            i = abyte0.length;
        }
        int l1 = aMd.length + i;
        l = (l1 + k1) - i1 - j1;
        byte abyte1[] = new byte[l1];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        System.arraycopy(aMd, 0, abyte1, i, aMd.length);
        abyte0 = new byte[k1];
        asp.nextBytes(abyte0);
        DigestRandomGenerator digestrandomgenerator = new DigestRandomGenerator(new SHA1Digest());
        digestrandomgenerator.FB1D(abyte0);
        byte abyte2[] = new byte[l1];
        digestrandomgenerator.FF9E(abyte2, 0, abyte2.length);
        for (int j = l1 - 1; j >= 0; j--)
        {
            abyte2[j] = (byte)(abyte2[j] ^ abyte1[j]);
        }

        abyte1 = new byte[aKp._mth14AF()];
        aKp.update(abyte2, 0, abyte2.length);
        aKp.doFinal(abyte1, 0);
        for (int k = k1 - 1; k >= 0; k--)
        {
            abyte1[k] = (byte)(abyte1[k] ^ abyte0[k]);
        }

        abyte1 = ByteUtils._mth0640(abyte1, abyte2);
        abyte0 = new byte[0];
        if (l > 0)
        {
            abyte0 = new byte[l];
            System.arraycopy(abyte1, 0, abyte0, 0, l);
        }
        abyte2 = new byte[j1];
        System.arraycopy(abyte1, l, abyte2, 0, j1);
        byte abyte3[] = new byte[i1];
        System.arraycopy(abyte1, l + j1, abyte3, 0, i1);
        GF2Vector gf2vector = GF2Vector._mth02CB(afK, abyte3);
        GF2Vector gf2vector1 = Conversions._mth02CB(axg, aJP, abyte2);
        gf2vector = McElieceCCA2Primitives._mth02CA((McElieceCCA2PublicKeyParameters)aMa, gf2vector, gf2vector1).getEncoded();
        if (l > 0)
        {
            return ByteUtils._mth0640(abyte0, gf2vector);
        } else
        {
            return gf2vector;
        }
    }

    public final byte[] _mth0E40(byte abyte0[])
    {
        int l = axg >> 3;
        if (abyte0.length < l)
        {
            throw new Exception("Bad Padding: Ciphertext too short.");
        }
        int i = aKp._mth14AF();
        int k = afK >> 3;
        l = abyte0.length - l;
        Object obj;
        if (l > 0)
        {
            obj = ByteUtils._mth2071(abyte0, l);
            abyte0 = obj[0];
            obj = obj[1];
        } else
        {
            byte abyte1[] = new byte[0];
            obj = abyte0;
            abyte0 = abyte1;
        }
        obj = GF2Vector._mth02CB(axg, ((byte []) (obj)));
        Object aobj[] = McElieceCCA2Primitives._mth02CA((McElieceCCA2PrivateKeyParameters)aMa, ((GF2Vector) (obj)));
        byte abyte2[] = aobj[0].getEncoded();
        GF2Vector gf2vector = aobj[1];
        aobj = abyte2;
        if (abyte2.length > k)
        {
            aobj = ByteUtils._mth1D62(abyte2, 0, k);
        }
        abyte0 = ByteUtils._mth0640(ByteUtils._mth0640(abyte0, Conversions._mth02CA(axg, aJP, gf2vector)), ((byte []) (aobj)));
        k = abyte0.length - i;
        abyte0 = ByteUtils._mth2071(abyte0, i);
        byte byte0 = abyte0[0];
        abyte0 = abyte0[1];
        abyte2 = new byte[aKp._mth14AF()];
        aKp.update(abyte0, 0, abyte0.length);
        aKp.doFinal(abyte2, 0);
        for (i--; i >= 0; i--)
        {
            abyte2[i] = (byte)(abyte2[i] ^ byte0[i]);
        }

        byte0 = new DigestRandomGenerator(new SHA1Digest());
        byte0.FB1D(abyte2);
        abyte2 = new byte[k];
        byte0.nextBytes(abyte2);
        for (int j = k - 1; j >= 0; j--)
        {
            abyte2[j] = (byte)(abyte2[j] ^ abyte0[j]);
        }

        if (abyte2.length < k)
        {
            throw new Exception("Bad Padding: invalid ciphertext");
        }
        abyte0 = ByteUtils._mth2071(abyte2, k - aMd.length);
        byte0 = abyte0[0];
        if (!ByteUtils.equals(abyte0[1], aMd))
        {
            throw new Exception("Bad Padding: invalid ciphertext");
        } else
        {
            return byte0;
        }
    }

}
