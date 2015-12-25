// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsHandshakeHash, TlsUtils, TlsContext, SecurityParameters, 
//            SSL3Mac

class CombinedHash
    implements TlsHandshakeHash
{

    private TlsContext azJ;
    private Digest azV;
    private Digest azW;

    CombinedHash()
    {
        azV = TlsUtils._mth02BD((short)1);
        azW = TlsUtils._mth02BD((short)2);
    }

    private CombinedHash(CombinedHash combinedhash)
    {
        azJ = combinedhash.azJ;
        azV = TlsUtils._mth02CA((short)1, combinedhash.azV);
        azW = TlsUtils._mth02CA((short)2, combinedhash.azW);
    }

    private void _mth02CA(Digest digest, byte abyte0[], byte abyte1[], int i)
    {
        byte abyte2[] = azJ._mth03DC().aBi;
        digest.update(abyte2, 0, abyte2.length);
        digest.update(abyte0, 0, i);
        abyte0 = new byte[digest._mth14AF()];
        digest.doFinal(abyte0, 0);
        digest.update(abyte2, 0, abyte2.length);
        digest.update(abyte1, 0, i);
        digest.update(abyte0, 0, abyte0.length);
    }

    public final int doFinal(byte abyte0[], int i)
    {
        if (azJ != null && TlsUtils._mth02CB(azJ))
        {
            _mth02CA(azV, SSL3Mac.aAZ, SSL3Mac.aBa, 48);
            _mth02CA(azW, SSL3Mac.aAZ, SSL3Mac.aBa, 40);
        }
        int j = azV.doFinal(abyte0, i);
        return j + azW.doFinal(abyte0, i + j);
    }

    public final void reset()
    {
        azV.reset();
        azW.reset();
    }

    public final void update(byte byte0)
    {
        azV.update(byte0);
        azW.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        azV.update(abyte0, i, j);
        azW.update(abyte0, i, j);
    }

    public final void _mth02CA(TlsContext tlscontext)
    {
        azJ = tlscontext;
    }

    public final void _mth02CB(short word0)
    {
        throw new IllegalStateException("CombinedHash only supports calculating the legacy PRF for handshake hash");
    }

    public final byte[] _mth02CE(short word0)
    {
        throw new IllegalStateException("CombinedHash doesn't support multiple hashes");
    }

    public final TlsHandshakeHash _mth05E1()
    {
        return this;
    }

    public final void _mth05E3()
    {
    }

    public final TlsHandshakeHash _mth062A()
    {
        return new CombinedHash(this);
    }

    public final Digest _mth067A()
    {
        return new CombinedHash(this);
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(azV._mth14AC()).append(" and ").append(azW._mth14AC()).toString();
    }

    public final int _mth14AF()
    {
        return azV._mth14AF() + azW._mth14AF();
    }
}
