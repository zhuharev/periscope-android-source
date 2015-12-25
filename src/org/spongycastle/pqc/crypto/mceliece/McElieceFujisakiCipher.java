// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

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
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2PublicKeyParameters, McElieceCCA2PrivateKeyParameters, McElieceCCA2KeyParameters, McElieceCCA2Parameters, 
//            Conversions, McElieceCCA2Primitives

public class McElieceFujisakiCipher
    implements MessageEncryptor
{

    private int aJP;
    private Digest aKp;
    private McElieceCCA2KeyParameters aMa;
    private int afK;
    private SecureRandom asp;
    private int axg;

    public McElieceFujisakiCipher()
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
        SecureRandom securerandom;
        if (asp != null)
        {
            securerandom = asp;
        } else
        {
            securerandom = new SecureRandom();
        }
        asp = securerandom;
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
        GF2Vector gf2vector = new GF2Vector(afK, asp);
        byte abyte1[] = gf2vector.getEncoded();
        byte abyte3[] = ByteUtils._mth0640(abyte1, abyte0);
        aKp.update(abyte3, 0, abyte3.length);
        abyte3 = new byte[aKp._mth14AF()];
        aKp.doFinal(abyte3, 0);
        Object obj = Conversions._mth02CB(axg, aJP, abyte3);
        byte abyte2[] = McElieceCCA2Primitives._mth02CA((McElieceCCA2PublicKeyParameters)aMa, gf2vector, ((GF2Vector) (obj))).getEncoded();
        obj = new DigestRandomGenerator(new SHA1Digest());
        ((DigestRandomGenerator) (obj)).FB1D(abyte1);
        abyte1 = new byte[abyte0.length];
        ((DigestRandomGenerator) (obj)).FF9E(abyte1, 0, abyte1.length);
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte1[i] = (byte)(abyte1[i] ^ abyte0[i]);
        }

        return ByteUtils._mth0640(abyte2, abyte1);
    }

    public final byte[] _mth0E40(byte abyte0[])
    {
        int i = axg + 7 >> 3;
        int k = abyte0.length - i;
        abyte0 = ByteUtils._mth2071(abyte0, i);
        Object aobj[] = abyte0[0];
        abyte0 = abyte0[1];
        GF2Vector gf2vector = GF2Vector._mth02CB(axg, ((byte []) (aobj)));
        gf2vector = McElieceCCA2Primitives._mth02CA((McElieceCCA2PrivateKeyParameters)aMa, gf2vector);
        byte abyte2[] = gf2vector[0].getEncoded();
        gf2vector = gf2vector[1];
        DigestRandomGenerator digestrandomgenerator = new DigestRandomGenerator(new SHA1Digest());
        digestrandomgenerator.FB1D(abyte2);
        byte abyte1[] = new byte[k];
        digestrandomgenerator.FF9E(abyte1, 0, abyte1.length);
        for (int j = 0; j < k; j++)
        {
            abyte1[j] = (byte)(abyte1[j] ^ abyte0[j]);
        }

        abyte0 = ByteUtils._mth0640(abyte2, abyte1);
        abyte2 = new byte[aKp._mth14AF()];
        aKp.update(abyte0, 0, abyte0.length);
        aKp.doFinal(abyte2, 0);
        if (!Conversions._mth02CB(axg, aJP, abyte2).equals(gf2vector))
        {
            throw new Exception("Bad Padding: invalid ciphertext");
        } else
        {
            return abyte1;
        }
    }
}
