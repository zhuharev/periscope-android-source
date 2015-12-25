// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class SSL3Mac
    implements Mac
{

    static final byte aAZ[];
    static final byte aBa[];
    private byte aBb[];
    private int aBc;
    private Digest amS;

    public SSL3Mac(Digest digest)
    {
        amS = digest;
        if (digest._mth14AF() == 20)
        {
            aBc = 40;
            return;
        } else
        {
            aBc = 48;
            return;
        }
    }

    public final int doFinal(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        amS.update(aBb, 0, aBb.length);
        amS.update(aBa, 0, aBc);
        amS.update(abyte1, 0, abyte1.length);
        i = amS.doFinal(abyte0, 0);
        reset();
        return i;
    }

    public final void reset()
    {
        amS.reset();
        amS.update(aBb, 0, aBb.length);
        amS.update(aAZ, 0, aBc);
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        aBb = Arrays._mth1D4C(((KeyParameter)cipherparameters).key);
        reset();
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amS._mth14AC()).append("/SSL3MAC").toString();
    }

    public final int _mth14B3()
    {
        return amS._mth14AF();
    }

    static 
    {
        byte abyte0[] = new byte[48];
        Arrays.fill(abyte0, (byte)54);
        aAZ = abyte0;
        abyte0 = new byte[48];
        Arrays.fill(abyte0, (byte)92);
        aBa = abyte0;
    }
}
