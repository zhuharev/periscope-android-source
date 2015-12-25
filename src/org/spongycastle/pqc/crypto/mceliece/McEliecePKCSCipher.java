// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageEncryptor;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McEliecePublicKeyParameters, McEliecePrivateKeyParameters, McElieceKeyParameters

public class McEliecePKCSCipher
    implements MessageEncryptor
{

    public int aJP;
    public int aMe;
    public int aMf;
    public McElieceKeyParameters aMg;
    public int afK;
    public SecureRandom asp;
    public int axg;

    public McEliecePKCSCipher()
    {
    }

    public static int _mth02CA(McElieceKeyParameters mceliecekeyparameters)
    {
        if (mceliecekeyparameters instanceof McEliecePublicKeyParameters)
        {
            return ((McEliecePublicKeyParameters)mceliecekeyparameters).axg;
        }
        if (mceliecekeyparameters instanceof McEliecePrivateKeyParameters)
        {
            return ((McEliecePrivateKeyParameters)mceliecekeyparameters).axg;
        } else
        {
            throw new IllegalArgumentException("unsupported type");
        }
    }

    private void _mth02CA(McEliecePublicKeyParameters mceliecepublickeyparameters)
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
        axg = mceliecepublickeyparameters.axg;
        afK = mceliecepublickeyparameters.aMk.getNumRows();
        aJP = mceliecepublickeyparameters.aJP;
        aMf = axg >> 3;
        aMe = afK >> 3;
    }

    public static byte[] _mth02CA(GF2Vector gf2vector)
    {
        gf2vector = gf2vector.getEncoded();
        int i;
        for (i = gf2vector.length - 1; i >= 0 && gf2vector[i] == 0; i--) { }
        if (gf2vector[i] != 1)
        {
            throw new Exception("Bad Padding: invalid ciphertext");
        } else
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(gf2vector, 0, abyte0, 0, i);
            return abyte0;
        }
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                asp = ((ParametersWithRandom) (cipherparameters)).amC;
                aMg = (McEliecePublicKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                _mth02CA((McEliecePublicKeyParameters)aMg);
                return;
            } else
            {
                asp = new SecureRandom();
                aMg = (McEliecePublicKeyParameters)cipherparameters;
                _mth02CA((McEliecePublicKeyParameters)aMg);
                return;
            }
        } else
        {
            aMg = (McEliecePrivateKeyParameters)cipherparameters;
            cipherparameters = (McEliecePrivateKeyParameters)aMg;
            axg = ((McEliecePrivateKeyParameters) (cipherparameters)).axg;
            afK = ((McEliecePrivateKeyParameters) (cipherparameters)).afK;
            aMe = afK >> 3;
            aMf = axg >> 3;
            return;
        }
    }
}
