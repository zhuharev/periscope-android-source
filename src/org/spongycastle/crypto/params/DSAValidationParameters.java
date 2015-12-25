// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.util.Arrays;

public class DSAValidationParameters
{

    private int Wr;
    private byte aln[];
    private int aua;

    public DSAValidationParameters(byte abyte0[], int i)
    {
        this(abyte0, i, -1);
    }

    public DSAValidationParameters(byte abyte0[], int i, int j)
    {
        aln = abyte0;
        Wr = i;
        aua = j;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DSAValidationParameters))
        {
            return false;
        }
        obj = (DSAValidationParameters)obj;
        if (((DSAValidationParameters) (obj)).Wr != Wr)
        {
            return false;
        } else
        {
            return Arrays._mth1427(aln, ((DSAValidationParameters) (obj)).aln);
        }
    }

    public int hashCode()
    {
        return Wr ^ Arrays.hashCode(aln);
    }
}
