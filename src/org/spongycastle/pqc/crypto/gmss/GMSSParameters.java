// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.util.Arrays;

public class GMSSParameters
{

    public int aKK;
    public int aKL[];
    public int aKx[];
    public int anY[];

    public GMSSParameters(int i, int ai[], int ai1[], int ai2[])
    {
        _mth02CF(i, ai, ai1, ai2);
    }

    private void _mth02CF(int i, int ai[], int ai1[], int ai2[])
    {
        String s;
label0:
        {
            boolean flag = true;
            s = "";
            aKK = i;
            if (aKK == ai1.length && aKK == ai.length)
            {
                i = ((flag) ? 1 : 0);
                if (aKK == ai2.length)
                {
                    break label0;
                }
            }
            i = 0;
            s = "Unexpected parameterset format";
        }
        for (int j = 0; j < aKK; j++)
        {
            if (ai2[j] < 2 || (ai[j] - ai2[j]) % 2 != 0)
            {
                i = 0;
                s = "Wrong parameter K (K >= 2 and H-K even required)!";
            }
            if (ai[j] < 4 || ai1[j] < 2)
            {
                i = 0;
                s = "Wrong parameter H or w (H > 3 and w > 1 required)!";
            }
        }

        if (i != 0)
        {
            aKx = Arrays._mth02D1(ai);
            aKL = Arrays._mth02D1(ai1);
            anY = Arrays._mth02D1(ai2);
            return;
        } else
        {
            throw new IllegalArgumentException(s);
        }
    }
}
