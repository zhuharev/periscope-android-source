// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCipher, TlsContext, TlsUtils, TlsMac, 
//            TlsFatalAlert

public class TlsStreamCipher
    implements TlsCipher
{

    private TlsMac aBC;
    private TlsMac aBD;
    private StreamCipher aCw;
    private StreamCipher aCx;
    private boolean aCy;
    private TlsContext azJ;

    public TlsStreamCipher(TlsContext tlscontext, StreamCipher streamcipher, StreamCipher streamcipher1, Digest digest, Digest digest1, int i, boolean flag)
    {
        boolean flag1 = tlscontext._mth09B0();
        azJ = tlscontext;
        aCy = flag;
        aCw = streamcipher;
        aCx = streamcipher1;
        int j = i * 2 + digest._mth14AF() + digest1._mth14AF();
        byte abyte0[] = TlsUtils._mth02CA(tlscontext, j);
        TlsMac tlsmac = new TlsMac(tlscontext, digest, abyte0, 0, digest._mth14AF());
        int k = digest._mth14AF() + 0;
        TlsMac tlsmac1 = new TlsMac(tlscontext, digest1, abyte0, k, digest1._mth14AF());
        k += digest1._mth14AF();
        tlscontext = new KeyParameter(abyte0, k, i);
        k += i;
        digest = new KeyParameter(abyte0, k, i);
        if (k + i != j)
        {
            throw new TlsFatalAlert((short)80);
        }
        if (flag1)
        {
            aBC = tlsmac1;
            aBD = tlsmac;
            aCw = streamcipher1;
            aCx = streamcipher;
            streamcipher = digest;
        } else
        {
            aBC = tlsmac;
            aBD = tlsmac1;
            aCw = streamcipher;
            aCx = streamcipher1;
            streamcipher = tlscontext;
            tlscontext = digest;
        }
        digest = streamcipher;
        streamcipher1 = tlscontext;
        if (flag)
        {
            streamcipher1 = new byte[8];
            digest = new ParametersWithIV(streamcipher, streamcipher1);
            streamcipher1 = new ParametersWithIV(tlscontext, streamcipher1);
        }
        aCw._mth02CA(true, digest);
        aCx._mth02CA(false, streamcipher1);
    }

    public final byte[] _mth02CA(long l, short word0, byte abyte0[], int i, int j)
    {
        if (aCy)
        {
            StreamCipher streamcipher = aCw;
            byte abyte2[] = new byte[8];
            TlsUtils._mth02CE(l, abyte2, 0);
            streamcipher._mth02CA(true, new ParametersWithIV(null, abyte2));
        }
        byte abyte1[] = new byte[aBC.getSize() + j];
        aCw._mth02CB(abyte0, i, j, abyte1, 0);
        abyte0 = aBC._mth02CE(l, word0, abyte0, i, j);
        aCw._mth02CB(abyte0, 0, abyte0.length, abyte1, j);
        return abyte1;
    }

    public final byte[] _mth02CB(long l, short word0, byte abyte0[], int i, int j)
    {
        if (aCy)
        {
            StreamCipher streamcipher = aCx;
            byte abyte2[] = new byte[8];
            TlsUtils._mth02CE(l, abyte2, 0);
            streamcipher._mth02CA(false, new ParametersWithIV(null, abyte2));
        }
        i = aBD.getSize();
        if (j < i)
        {
            throw new TlsFatalAlert((short)50);
        }
        i = j - i;
        byte abyte1[] = new byte[j];
        aCx._mth02CB(abyte0, 0, j, abyte1, 0);
        if (!Arrays._mth1428(Arrays.copyOfRange(abyte1, i, j), aBD._mth02CE(l, word0, abyte1, 0, i)))
        {
            throw new TlsFatalAlert((short)20);
        } else
        {
            return Arrays.copyOfRange(abyte1, 0, i);
        }
    }
}
