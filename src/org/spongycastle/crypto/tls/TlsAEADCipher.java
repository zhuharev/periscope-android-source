// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCipher, TlsUtils, TlsFatalAlert, TlsContext

public class TlsAEADCipher
    implements TlsCipher
{

    private int aBt;
    private AEADBlockCipher aBu;
    private AEADBlockCipher aBv;
    private byte aBw[];
    private byte aBx[];
    private int auF;
    private TlsContext azJ;

    public TlsAEADCipher(TlsContext tlscontext, AEADBlockCipher aeadblockcipher, AEADBlockCipher aeadblockcipher1, int i, int j)
    {
        if (!TlsUtils._mth02CF(tlscontext))
        {
            throw new TlsFatalAlert((short)80);
        }
        azJ = tlscontext;
        auF = j;
        aBt = 8;
        int k = i * 2 + 8;
        byte abyte1[] = TlsUtils._mth02CA(tlscontext, k);
        KeyParameter keyparameter = new KeyParameter(abyte1, 0, i);
        int l = i + 0;
        KeyParameter keyparameter1 = new KeyParameter(abyte1, l, i);
        i = l + i;
        byte abyte0[] = Arrays.copyOfRange(abyte1, i, i + 4);
        i += 4;
        abyte1 = Arrays.copyOfRange(abyte1, i, i + 4);
        if (i + 4 != k)
        {
            throw new TlsFatalAlert((short)80);
        }
        if (tlscontext._mth09B0())
        {
            aBu = aeadblockcipher1;
            aBv = aeadblockcipher;
            aBw = abyte1;
            aBx = abyte0;
            tlscontext = keyparameter;
            keyparameter = keyparameter1;
        } else
        {
            aBu = aeadblockcipher;
            aBv = aeadblockcipher1;
            aBw = abyte0;
            aBx = abyte1;
            tlscontext = keyparameter1;
        }
        aeadblockcipher = new byte[aBt + 4];
        aBu._mth02CA(true, new AEADParameters(keyparameter, j * 8, aeadblockcipher));
        aBv._mth02CA(false, new AEADParameters(tlscontext, j * 8, aeadblockcipher));
    }

    private byte[] _mth02CA(long l, short word0, int i)
    {
        byte abyte0[] = new byte[13];
        TlsUtils._mth02CE(l, abyte0, 0);
        TlsUtils._mth02CA(word0, abyte0, 8);
        TlsUtils._mth02CA(azJ._mth0455(), abyte0, 9);
        TlsUtils._mth02BC(i, abyte0, 11);
        return abyte0;
    }

    public final byte[] _mth02CA(long l, short word0, byte abyte0[], int i, int j)
    {
        byte abyte2[] = new byte[aBw.length + aBt];
        System.arraycopy(aBw, 0, abyte2, 0, aBw.length);
        TlsUtils._mth02CE(l, abyte2, aBw.length);
        int k = aBu.getOutputSize(j);
        byte abyte1[] = new byte[aBt + k];
        System.arraycopy(abyte2, aBw.length, abyte1, 0, aBt);
        k = aBt;
        byte abyte3[] = _mth02CA(l, word0, j);
        AEADParameters aeadparameters = new AEADParameters(null, auF * 8, abyte2, abyte3);
        try
        {
            aBu._mth02CA(true, aeadparameters);
            i = aBu._mth02CB(abyte0, i, j, abyte1, k) + k;
            j = aBu.doFinal(abyte1, i);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TlsFatalAlert((short)80);
        }
        if (i + j != abyte1.length)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return abyte1;
        }
    }

    public final byte[] _mth02CB(long l, short word0, byte abyte0[], int i, int j)
    {
        if (j - auF - aBt < 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        byte abyte2[] = new byte[aBx.length + aBt];
        System.arraycopy(aBx, 0, abyte2, 0, aBx.length);
        System.arraycopy(abyte0, 0, abyte2, aBx.length, aBt);
        i = aBt;
        j -= aBt;
        int k = aBv.getOutputSize(j);
        byte abyte1[] = new byte[k];
        byte abyte3[] = _mth02CA(l, word0, k);
        AEADParameters aeadparameters = new AEADParameters(null, auF * 8, abyte2, abyte3);
        try
        {
            aBv._mth02CA(false, aeadparameters);
            i = aBv._mth02CB(abyte0, i + 0, j, abyte1, 0) + 0;
            j = aBv.doFinal(abyte1, i);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TlsFatalAlert((short)20);
        }
        if (i + j != abyte1.length)
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            return abyte1;
        }
    }
}
