// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.OutputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsFatalAlert, TlsUtils, ProtocolVersion, TlsCipher, 
//            TlsCompression, TlsHandshakeHash

class RecordStream
{

    TlsCompression aAL;
    private TlsCompression aAM;
    TlsCompression aAN;
    TlsCipher aAO;
    private TlsCipher aAP;
    TlsCipher aAQ;
    private long aAR;
    long aAS;
    TlsHandshakeHash aAT;
    ProtocolVersion aAU;
    ProtocolVersion aAV;
    private boolean aAW;
    int aAX;
    int aAY;
    private int compressedLimit;

    static void _mth02CA(int i, int j, short word0)
    {
        if (i > j)
        {
            throw new TlsFatalAlert(word0);
        } else
        {
            return;
        }
    }

    static void _mth02CA(short word0, short word1)
    {
        switch (word0)
        {
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
            return;
        }
        throw new TlsFatalAlert(word1);
    }

    final void _mth099A()
    {
        if (aAL == null || aAO == null)
        {
            throw new TlsFatalAlert((short)40);
        } else
        {
            aAM = aAL;
            aAP = aAO;
            aAR = 0L;
            return;
        }
    }

    public final boolean _mth09A6()
    {
        byte abyte0[] = TlsUtils._mth02CE(5, null);
        if (abyte0 == null)
        {
            return false;
        }
        short word0 = TlsUtils._mth05D9(abyte0, 0);
        _mth02CA(word0, (short)10);
        if (!aAW)
        {
            if ((TlsUtils._mth1D4E(abyte0, 1) & 0xffffff00) != 768)
            {
                throw new TlsFatalAlert((short)47);
            }
        } else
        {
            ProtocolVersion protocolversion1 = TlsUtils._mth1D35(abyte0, 1);
            if (aAU == null)
            {
                aAU = protocolversion1;
            } else
            {
                ProtocolVersion protocolversion = aAU;
                boolean flag;
                if (protocolversion != null && protocolversion1.version == protocolversion.version)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    throw new TlsFatalAlert((short)47);
                }
            }
        }
        int i = TlsUtils._mth0674(abyte0, 3);
        if (i > aAY)
        {
            throw new TlsFatalAlert((short)22);
        }
        byte abyte1[] = TlsUtils._mth02CF(i, null);
        Object obj = aAP;
        long l = aAR;
        aAR = 1L + l;
        abyte1 = ((TlsCipher) (obj))._mth02CB(l, word0, abyte1, 0, abyte1.length);
        if (abyte1.length > compressedLimit)
        {
            throw new TlsFatalAlert((short)22);
        }
        obj = aAM._mth02CF(null);
        if (obj != null)
        {
            ((OutputStream) (obj)).write(abyte1, 0, abyte1.length);
            ((OutputStream) (obj)).flush();
            throw new NullPointerException();
        }
        if (abyte1.length > aAX)
        {
            throw new TlsFatalAlert((short)30);
        }
        if (abyte1.length <= 0 && word0 != 23)
        {
            throw new TlsFatalAlert((short)47);
        }
        i = abyte1.length;
        switch (word0)
        {
        case 21: // '\025'
            throw new NullPointerException();

        case 23: // '\027'
            throw new NullPointerException();

        case 20: // '\024'
            throw new NullPointerException();

        case 22: // '\026'
            throw new NullPointerException();

        case 24: // '\030'
            throw new NullPointerException();
        }
        return true;
    }
}
