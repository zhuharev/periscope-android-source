// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

// Referenced classes of package org.spongycastle.crypto.engines:
//            DESEngine

public class DESedeEngine extends DESEngine
{

    private boolean amy;
    private int ari[];
    private int arj[];
    private int ark[];

    public DESedeEngine()
    {
        ari = null;
        arj = null;
        ark = null;
    }

    public final int getBlockSize()
    {
        return 8;
    }

    public final void reset()
    {
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        if (ari == null)
        {
            throw new IllegalStateException("DESede engine not initialised");
        }
        if (i + 8 > abyte0.length)
        {
            throw new DataLengthException("input buffer too short");
        }
        if (j + 8 > abyte1.length)
        {
            throw new OutputLengthException("output buffer too short");
        }
        byte abyte2[] = new byte[8];
        if (amy)
        {
            _mth02CA(ari, abyte0, i, abyte2, 0);
            _mth02CA(arj, abyte2, 0, abyte2, 0);
            _mth02CA(ark, abyte2, 0, abyte1, j);
        } else
        {
            _mth02CA(ark, abyte0, i, abyte2, 0);
            _mth02CA(arj, abyte2, 0, abyte2, 0);
            _mth02CA(ari, abyte2, 0, abyte1, j);
        }
        return 8;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (!(cipherparameters instanceof KeyParameter))
        {
            throw new IllegalArgumentException((new StringBuilder("invalid parameter passed to DESede init - ")).append(cipherparameters.getClass().getName()).toString());
        }
        cipherparameters = ((KeyParameter)cipherparameters).key;
        if (cipherparameters.length != 24 && cipherparameters.length != 16)
        {
            throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
        }
        amy = flag;
        byte abyte0[] = new byte[8];
        System.arraycopy(cipherparameters, 0, abyte0, 0, 8);
        ari = _mth02CB(flag, abyte0);
        abyte0 = new byte[8];
        System.arraycopy(cipherparameters, 8, abyte0, 0, 8);
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        arj = _mth02CB(flag1, abyte0);
        if (cipherparameters.length == 24)
        {
            byte abyte1[] = new byte[8];
            System.arraycopy(cipherparameters, 16, abyte1, 0, 8);
            ark = _mth02CB(flag, abyte1);
            return;
        } else
        {
            ark = ari;
            return;
        }
    }

    public final String _mth14AC()
    {
        return "DESede";
    }
}
