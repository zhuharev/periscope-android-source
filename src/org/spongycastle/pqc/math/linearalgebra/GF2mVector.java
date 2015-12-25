// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            Vector, GF2mField, IntUtils, GF2Vector

public class GF2mVector extends Vector
{

    GF2mField aLU;
    int aOB[];

    public GF2mVector(GF2mField gf2mfield, int ai[])
    {
        aLU = gf2mfield;
        length = ai.length;
        for (int i = ai.length - 1; i >= 0; i--)
        {
            if (!gf2mfield._mth0208(ai[i]))
            {
                throw new ArithmeticException("Element array is not specified over the given finite field.");
            }
        }

        aOB = IntUtils._mth02D1(ai);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof GF2mVector))
        {
            return false;
        }
        obj = (GF2mVector)obj;
        if (!aLU.equals(((GF2mVector) (obj)).aLU))
        {
            return false;
        } else
        {
            return IntUtils.equals(aOB, ((GF2mVector) (obj)).aOB);
        }
    }

    public int hashCode()
    {
        return aLU.hashCode() * 31 + aOB.hashCode();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < aOB.length; i++)
        {
            for (int j = 0; j < aLU.aOz; j++)
            {
                if ((aOB[i] & 1 << (j & 0x1f)) != 0)
                {
                    stringbuffer.append('1');
                } else
                {
                    stringbuffer.append('0');
                }
            }

            stringbuffer.append(' ');
        }

        return stringbuffer.toString();
    }

    public final GF2Vector _mth141D(GF2Vector gf2vector)
    {
        throw new RuntimeException("not implemented");
    }
}
