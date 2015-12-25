// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCipher, TlsFatalAlert, TlsUtils, TlsMac, 
//            TlsContext

public class TlsNullCipher
    implements TlsCipher
{

    private TlsMac aBC;
    private TlsMac aBD;
    private TlsContext azJ;

    public TlsNullCipher(TlsContext tlscontext, Digest digest, Digest digest1)
    {
        boolean flag;
        if (digest == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (digest1 == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            throw new TlsFatalAlert((short)80);
        }
        azJ = tlscontext;
        TlsMac tlsmac = null;
        Object obj = null;
        if (digest != null)
        {
            int i = digest._mth14AF() + digest1._mth14AF();
            obj = TlsUtils._mth02CA(tlscontext, i);
            tlsmac = new TlsMac(tlscontext, digest, ((byte []) (obj)), 0, digest._mth14AF());
            int j = digest._mth14AF() + 0;
            obj = new TlsMac(tlscontext, digest1, ((byte []) (obj)), j, digest1._mth14AF());
            if (digest1._mth14AF() + j != i)
            {
                throw new TlsFatalAlert((short)80);
            }
        }
        if (tlscontext._mth09B0())
        {
            aBC = ((TlsMac) (obj));
            aBD = tlsmac;
            return;
        } else
        {
            aBC = tlsmac;
            aBD = ((TlsMac) (obj));
            return;
        }
    }

    public final byte[] _mth02CA(long l, short word0, byte abyte0[], int i, int j)
    {
        if (aBC == null)
        {
            return Arrays.copyOfRange(abyte0, i, i + j);
        } else
        {
            byte abyte1[] = aBC._mth02CE(l, word0, abyte0, i, j);
            byte abyte2[] = new byte[abyte1.length + j];
            System.arraycopy(abyte0, i, abyte2, 0, j);
            System.arraycopy(abyte1, 0, abyte2, j, abyte1.length);
            return abyte2;
        }
    }

    public final byte[] _mth02CB(long l, short word0, byte abyte0[], int i, int j)
    {
        if (aBD == null)
        {
            return Arrays.copyOfRange(abyte0, 0, j + 0);
        }
        i = aBD.getSize();
        if (j < i)
        {
            throw new TlsFatalAlert((short)50);
        }
        i = j - i;
        if (!Arrays._mth1428(Arrays.copyOfRange(abyte0, i + 0, j + 0), aBD._mth02CE(l, word0, abyte0, 0, i)))
        {
            throw new TlsFatalAlert((short)20);
        } else
        {
            return Arrays.copyOfRange(abyte0, 0, i + 0);
        }
    }
}
