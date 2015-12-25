// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;

public class IESParameterSpec
    implements AlgorithmParameterSpec
{

    public byte XD[];
    public byte axp[];
    public byte axq[];
    public int axr;
    public int axs;

    public IESParameterSpec(byte abyte0[], byte abyte1[], int i)
    {
        this(abyte0, abyte1, i, -1);
    }

    public IESParameterSpec(byte abyte0[], byte abyte1[], int i, int j)
    {
        this(abyte0, abyte1, i, j, null);
    }

    private IESParameterSpec(byte abyte0[], byte abyte1[], int i, int j, byte abyte2[])
    {
        if (abyte0 != null)
        {
            axp = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, axp, 0, abyte0.length);
        } else
        {
            axp = null;
        }
        if (abyte1 != null)
        {
            axq = new byte[abyte1.length];
            System.arraycopy(abyte1, 0, axq, 0, abyte1.length);
        } else
        {
            axq = null;
        }
        axr = i;
        axs = j;
        XD = Arrays._mth1D4C(null);
    }
}
