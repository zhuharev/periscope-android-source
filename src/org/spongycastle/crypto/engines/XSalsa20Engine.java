// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.engines:
//            Salsa20Engine

public class XSalsa20Engine extends Salsa20Engine
{

    public XSalsa20Engine()
    {
    }

    protected final void _mth02CB(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("XSalsa20 doesn't support re-init with null key").toString());
        }
        if (abyte0.length != 32)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("XSalsa20 requires a 256 bit key").toString());
        } else
        {
            super._mth02CB(abyte0, abyte1);
            arY[8] = Pack._mth02C6(abyte1, 8);
            arY[9] = Pack._mth02C6(abyte1, 12);
            abyte0 = new int[arY.length];
            _mth02CA(20, arY, abyte0);
            arY[1] = abyte0[0] - arY[0];
            arY[2] = abyte0[5] - arY[5];
            arY[3] = abyte0[10] - arY[10];
            arY[4] = abyte0[15] - arY[15];
            arY[11] = abyte0[6] - arY[6];
            arY[12] = abyte0[7] - arY[7];
            arY[13] = abyte0[8] - arY[8];
            arY[14] = abyte0[9] - arY[9];
            arY[6] = Pack._mth02C6(abyte1, 16);
            arY[7] = Pack._mth02C6(abyte1, 20);
            return;
        }
    }

    public final String _mth14AC()
    {
        return "XSalsa20";
    }

    protected final int _mth2164()
    {
        return 24;
    }
}
