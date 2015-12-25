// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.EOFException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

// Referenced classes of package org.spongycastle.asn1:
//            LimitedInputStream

class DefiniteLengthInputStream extends LimitedInputStream
{

    private static final byte WQ[] = new byte[0];
    private final int WR;
    int WS;

    DefiniteLengthInputStream(InputStream inputstream, int i)
    {
        super(inputstream, i);
        if (i < 0)
        {
            throw new IllegalArgumentException("negative lengths not allowed");
        }
        WR = i;
        WS = i;
        if (i == 0)
        {
            _mth05D5(true);
        }
    }

    final int getRemaining()
    {
        return WS;
    }

    public int read()
    {
        if (WS == 0)
        {
            return -1;
        }
        int i = Wi.read();
        if (i < 0)
        {
            throw new EOFException((new StringBuilder("DEF length ")).append(WR).append(" object truncated by ").append(WS).toString());
        }
        int j = WS - 1;
        WS = j;
        if (j == 0)
        {
            _mth05D5(true);
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (WS == 0)
        {
            return -1;
        }
        j = Math.min(j, WS);
        i = Wi.read(abyte0, i, j);
        if (i < 0)
        {
            throw new EOFException((new StringBuilder("DEF length ")).append(WR).append(" object truncated by ").append(WS).toString());
        }
        j = WS - i;
        WS = j;
        if (j == 0)
        {
            _mth05D5(true);
        }
        return i;
    }

    final byte[] toByteArray()
    {
        if (WS == 0)
        {
            return WQ;
        }
        byte abyte0[] = new byte[WS];
        int i = WS - Streams._mth02CB(Wi, abyte0);
        WS = i;
        if (i != 0)
        {
            throw new EOFException((new StringBuilder("DEF length ")).append(WR).append(" object truncated by ").append(WS).toString());
        } else
        {
            _mth05D5(true);
            return abyte0;
        }
    }

}
