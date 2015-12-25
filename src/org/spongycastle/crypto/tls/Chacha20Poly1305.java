// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.macs.Poly1305;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCipher, TlsUtils, TlsFatalAlert, TlsContext

public class Chacha20Poly1305
    implements TlsCipher
{

    private TlsContext azJ;
    private ChaChaEngine azT;
    private ChaChaEngine azU;

    public Chacha20Poly1305(TlsContext tlscontext)
    {
        if (!TlsUtils._mth02CF(tlscontext))
        {
            throw new TlsFatalAlert((short)80);
        }
        azJ = tlscontext;
        byte abyte0[] = TlsUtils._mth02CA(tlscontext, 64);
        KeyParameter keyparameter = new KeyParameter(abyte0, 0, 32);
        KeyParameter keyparameter1 = new KeyParameter(abyte0, 32, 32);
        azT = new ChaChaEngine(20);
        azU = new ChaChaEngine(20);
        if (tlscontext._mth09B0())
        {
            tlscontext = keyparameter;
            keyparameter = keyparameter1;
        } else
        {
            tlscontext = keyparameter1;
        }
        keyparameter1 = new byte[8];
        azT._mth02CA(true, new ParametersWithIV(keyparameter, keyparameter1));
        azU._mth02CA(false, new ParametersWithIV(tlscontext, keyparameter1));
    }

    private static KeyParameter _mth02CA(ChaChaEngine chachaengine, boolean flag, long l)
    {
        byte abyte0[] = new byte[8];
        TlsUtils._mth02CE(l, abyte0, 0);
        chachaengine._mth02CA(flag, new ParametersWithIV(null, abyte0));
        abyte0 = new byte[64];
        chachaengine._mth02CB(abyte0, 0, 64, abyte0, 0);
        System.arraycopy(abyte0, 0, abyte0, 32, 16);
        chachaengine = new KeyParameter(abyte0, 16, 32);
        Poly1305KeyGenerator._mth02C6(((KeyParameter) (chachaengine)).key);
        return chachaengine;
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

    private byte[] _mth02CA(KeyParameter keyparameter, byte abyte0[], byte abyte1[], int i, int j)
    {
        Poly1305 poly1305 = new Poly1305();
        poly1305._mth02CA(keyparameter);
        int k = abyte0.length;
        poly1305.update(abyte0, 0, k);
        poly1305.update(Pack._mth1D4E((long)k & 0xffffffffL), 0, 8);
        poly1305.update(abyte1, i, j);
        poly1305.update(Pack._mth1D4E((long)j & 0xffffffffL), 0, 8);
        keyparameter = new byte[poly1305._mth14B3()];
        poly1305.doFinal(keyparameter, 0);
        return keyparameter;
    }

    public final byte[] _mth02CA(long l, short word0, byte abyte0[], int i, int j)
    {
        KeyParameter keyparameter = _mth02CA(azT, true, l);
        byte abyte1[] = new byte[j + 16];
        azT._mth02CB(abyte0, i, j, abyte1, 0);
        abyte0 = _mth02CA(keyparameter, _mth02CA(l, word0, j), abyte1, 0, j);
        System.arraycopy(abyte0, 0, abyte1, j, abyte0.length);
        return abyte1;
    }

    public final byte[] _mth02CB(long l, short word0, byte abyte0[], int i, int j)
    {
        if (j - 16 < 0)
        {
            throw new TlsFatalAlert((short)50);
        }
        i = j - 16;
        byte abyte1[] = Arrays.copyOfRange(abyte0, i + 0, j + 0);
        if (!Arrays._mth1428(_mth02CA(_mth02CA(azU, false, l), _mth02CA(l, word0, i), abyte0, 0, i), abyte1))
        {
            throw new TlsFatalAlert((short)20);
        } else
        {
            byte abyte2[] = new byte[i];
            azU._mth02CB(abyte0, 0, i, abyte2, 0);
            return abyte2;
        }
    }
}
