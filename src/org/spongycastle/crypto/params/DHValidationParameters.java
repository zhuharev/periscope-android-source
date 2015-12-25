// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.util.Arrays;

public class DHValidationParameters
{

    private int Wr;
    private byte aln[];

    public DHValidationParameters(byte abyte0[], int i)
    {
        aln = abyte0;
        Wr = i;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DHValidationParameters))
        {
            return false;
        }
        obj = (DHValidationParameters)obj;
        if (((DHValidationParameters) (obj)).Wr != Wr)
        {
            return false;
        } else
        {
            return Arrays._mth1427(aln, ((DHValidationParameters) (obj)).aln);
        }
    }

    public int hashCode()
    {
        return Wr ^ Arrays.hashCode(aln);
    }
}
