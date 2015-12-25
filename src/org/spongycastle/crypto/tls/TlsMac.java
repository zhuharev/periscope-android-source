// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.LongDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsUtils, SSL3Mac, TlsContext, SecurityParameters, 
//            ProtocolVersion

public class TlsMac
{

    private int aBY;
    private int aBZ;
    private byte aBb[];
    private int aCa;
    private Mac arN;
    private TlsContext azJ;

    public TlsMac(TlsContext tlscontext, Digest digest, byte abyte0[], int i, int j)
    {
        azJ = tlscontext;
        abyte0 = new KeyParameter(abyte0, i, j);
        aBb = Arrays._mth1D4C(((KeyParameter) (abyte0)).key);
        if (digest instanceof LongDigest)
        {
            aBY = 128;
            aBZ = 16;
        } else
        {
            aBY = 64;
            aBZ = 8;
        }
        if (TlsUtils._mth02CB(tlscontext))
        {
            arN = new SSL3Mac(digest);
            if (digest._mth14AF() == 20)
            {
                aBZ = 4;
            }
        } else
        {
            arN = new HMac(digest);
        }
        arN._mth02CA(abyte0);
        aCa = arN._mth14B3();
        if (tlscontext._mth03DC().aBl)
        {
            aCa = Math.min(aCa, 10);
        }
    }

    public final int getSize()
    {
        return aCa;
    }

    public final byte[] _mth02CA(long l, short word0, byte abyte0[], int i, int j, int k, 
            byte abyte1[])
    {
        abyte0 = _mth02CE(l, word0, abyte0, i, j);
        if (TlsUtils._mth02CB(azJ))
        {
            i = 11;
        } else
        {
            i = 13;
        }
        i = (aBZ + (i + k)) / aBY - (aBZ + (i + j)) / aBY;
        do
        {
            i--;
            if (i >= 0)
            {
                arN.update(abyte1, 0, aBY);
            } else
            {
                arN.update(abyte1[0]);
                arN.reset();
                return abyte0;
            }
        } while (true);
    }

    public final byte[] _mth02CE(long l, short word0, byte abyte0[], int i, int j)
    {
        ProtocolVersion protocolversion = azJ._mth0455();
        boolean flag;
        if (protocolversion == ProtocolVersion.aAF)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        byte byte0;
        if (flag)
        {
            byte0 = 11;
        } else
        {
            byte0 = 13;
        }
        byte abyte1[] = new byte[byte0];
        TlsUtils._mth02CE(l, abyte1, 0);
        TlsUtils._mth02CA(word0, abyte1, 8);
        if (!flag)
        {
            TlsUtils._mth02CA(protocolversion, abyte1, 9);
        }
        TlsUtils._mth02BC(j, abyte1, abyte1.length - 2);
        arN.update(abyte1, 0, abyte1.length);
        arN.update(abyte0, i, j);
        abyte0 = new byte[arN._mth14B3()];
        arN.doFinal(abyte0, 0);
        if (abyte0.length <= aCa)
        {
            return abyte0;
        } else
        {
            return Arrays.copyOf(abyte0, aCa);
        }
    }
}
