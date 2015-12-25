// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;


// Referenced classes of package org.spongycastle.crypto.prng:
//            RandomGenerator

public class ReversedWindowGenerator
    implements RandomGenerator
{

    private final RandomGenerator axV;
    private int axW;

    private void _mth02B9(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        i = 0;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (axW <= 0)
        {
            axV.FF9E(null, 0, null.length);
            axW = null.length;
        }
        i++;
        axW = axW - 1;
        throw new NullPointerException();
        return;
        abyte0;
        throw abyte0;
    }

    public final void nextBytes(byte abyte0[])
    {
        _mth02B9(abyte0, 0, abyte0.length);
    }

    public final void FF9E(byte abyte0[], int i, int j)
    {
        _mth02B9(abyte0, 0, j);
    }
}
