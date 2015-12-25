// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            RandUtils, IntUtils, IntegerFunctions, LittleEndianConversions

public class Permutation
{

    public int aOL[];

    public Permutation(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("invalid length");
        }
        aOL = new int[i];
        for (i--; i >= 0; i--)
        {
            aOL[i] = i;
        }

    }

    public Permutation(int i, SecureRandom securerandom)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("invalid length");
        }
        aOL = new int[i];
        int ai[] = new int[i];
        for (int j = 0; j < i; j++)
        {
            ai[j] = j;
        }

        int l = i;
        for (int k = 0; k < i; k++)
        {
            int i1 = RandUtils._mth02CB(securerandom, l);
            l--;
            aOL[k] = ai[i1];
            ai[i1] = ai[l];
        }

    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Permutation))
        {
            return false;
        } else
        {
            obj = (Permutation)obj;
            return IntUtils.equals(aOL, ((Permutation) (obj)).aOL);
        }
    }

    public final byte[] getEncoded()
    {
        int j = aOL.length;
        int k = IntegerFunctions._mth026A(j - 1);
        byte abyte0[] = new byte[j * k + 4];
        LittleEndianConversions._mth037A(j, abyte0, 0);
        for (int i = 0; i < j; i++)
        {
            LittleEndianConversions._mth02CF(aOL[i], abyte0, i * k + 4, k);
        }

        return abyte0;
    }

    public int hashCode()
    {
        return aOL.hashCode();
    }

    public String toString()
    {
        String s = (new StringBuilder("[")).append(aOL[0]).toString();
        for (int i = 1; i < aOL.length; i++)
        {
            s = (new StringBuilder()).append(s).append(", ").append(aOL[i]).toString();
        }

        return (new StringBuilder()).append(s).append("]").toString();
    }

    public final Permutation _mth1539()
    {
        Permutation permutation = new Permutation(aOL.length);
        for (int i = aOL.length - 1; i >= 0; i--)
        {
            permutation.aOL[aOL[i]] = i;
        }

        return permutation;
    }
}
