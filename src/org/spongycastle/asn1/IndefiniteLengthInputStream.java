// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.EOFException;
import java.io.InputStream;

// Referenced classes of package org.spongycastle.asn1:
//            LimitedInputStream

class IndefiniteLengthInputStream extends LimitedInputStream
{

    private int WT;
    private int WU;
    private boolean WV;
    boolean WW;

    IndefiniteLengthInputStream(InputStream inputstream, int i)
    {
        super(inputstream, i);
        WV = false;
        WW = true;
        WT = inputstream.read();
        WU = inputstream.read();
        if (WU < 0)
        {
            throw new EOFException();
        } else
        {
            _mth06CA();
            return;
        }
    }

    public int read()
    {
        if (_mth06CA())
        {
            return -1;
        }
        int i = Wi.read();
        if (i < 0)
        {
            throw new EOFException();
        } else
        {
            int j = WT;
            WT = WU;
            WU = i;
            return j;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (WW || j < 3)
        {
            return super.read(abyte0, i, j);
        }
        if (WV)
        {
            return -1;
        }
        j = Wi.read(abyte0, i + 2, j - 2);
        if (j < 0)
        {
            throw new EOFException();
        }
        abyte0[i] = (byte)WT;
        abyte0[i + 1] = (byte)WU;
        WT = Wi.read();
        WU = Wi.read();
        if (WU < 0)
        {
            throw new EOFException();
        } else
        {
            return j + 2;
        }
    }

    boolean _mth06CA()
    {
        if (!WV && WW && WT == 0 && WU == 0)
        {
            WV = true;
            _mth05D5(true);
        }
        return WV;
    }
}
