// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;


// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            IntegerPolynomial

public class LongPolynomial5
{

    long aPd[];
    int aPe;

    public LongPolynomial5(IntegerPolynomial integerpolynomial)
    {
        aPe = integerpolynomial.aPb.length;
        aPd = new long[(aPe + 4) / 5];
        int k = 0;
        int i = 0;
        for (int j = 0; j < aPe;)
        {
            long al[] = aPd;
            al[k] = al[k] | (long)integerpolynomial.aPb[j] << i;
            int i1 = i + 12;
            int l = k;
            i = i1;
            if (i1 >= 60)
            {
                i = 0;
                l = k + 1;
            }
            j++;
            k = l;
        }

    }

    LongPolynomial5(long al[], int i)
    {
        aPd = al;
        aPe = i;
    }
}
