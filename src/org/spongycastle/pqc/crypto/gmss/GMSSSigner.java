// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.gmss.util.GMSSUtil;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            GMSSPrivateKeyParameters, GMSSPublicKeyParameters, GMSSParameters, GMSSKeyParameters

public class GMSSSigner
    implements MessageSigner
{

    private int aKM[];
    private byte aKN[][][];
    private int aKv;
    private GMSSParameters aKw;
    private byte aLE[];
    private WinternitzOTSignature aLF;
    private byte aLG[][];
    private GMSSKeyParameters aLH;
    private SecureRandom amC;

    private void _mth0691()
    {
        throw new NullPointerException();
    }

    public final byte[] _mth02B2(byte abyte0[])
    {
        abyte0 = aLF._mth05D5(abyte0);
        byte abyte2[] = GMSSUtil._mth02CB(aKN[aKv - 1]);
        byte abyte3[] = GMSSUtil._mth217C(aKM[aKv - 1]);
        byte abyte1[] = new byte[abyte0.length + 4 + abyte2.length];
        System.arraycopy(abyte3, 0, abyte1, 0, 4);
        System.arraycopy(abyte0, 0, abyte1, 4, abyte0.length);
        System.arraycopy(abyte2, 0, abyte1, abyte0.length + 4, abyte2.length);
        abyte0 = new byte[0];
        for (int i = aKv - 1 - 1; i >= 0; i--)
        {
            abyte2 = GMSSUtil._mth02CB(aKN[i]);
            byte abyte4[] = GMSSUtil._mth217C(aKM[i]);
            byte abyte5[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte5, 0, abyte0.length);
            abyte0 = new byte[abyte5.length + 4 + aLG[i].length + abyte2.length];
            System.arraycopy(abyte5, 0, abyte0, 0, abyte5.length);
            System.arraycopy(abyte4, 0, abyte0, abyte5.length, 4);
            System.arraycopy(aLG[i], 0, abyte0, abyte5.length + 4, aLG[i].length);
            System.arraycopy(abyte2, 0, abyte0, abyte5.length + 4 + aLG[i].length, abyte2.length);
        }

        abyte2 = new byte[abyte1.length + abyte0.length];
        System.arraycopy(abyte1, 0, abyte2, 0, abyte1.length);
        System.arraycopy(abyte0, 0, abyte2, abyte1.length, abyte0.length);
        return abyte2;
    }

    public final boolean _mth02C9(byte abyte0[], byte abyte1[])
    {
        throw new NullPointerException();
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                amC = ((ParametersWithRandom) (cipherparameters)).amC;
                aLH = (GMSSPrivateKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
                _mth0691();
                return;
            } else
            {
                amC = new SecureRandom();
                aLH = (GMSSPrivateKeyParameters)cipherparameters;
                _mth0691();
                return;
            }
        } else
        {
            aLH = (GMSSPublicKeyParameters)cipherparameters;
            throw new NullPointerException();
        }
    }
}
