// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import java.math.BigInteger;

// Referenced classes of package org.spongycastle.math.ec:
//            ECConstants

class SimpleBigDecimal
{

    final BigInteger aIU;
    final int aIV;

    public SimpleBigDecimal(BigInteger biginteger, int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("scale may not be negative");
        } else
        {
            aIU = biginteger;
            aIV = i;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof SimpleBigDecimal))
        {
            return false;
        }
        obj = (SimpleBigDecimal)obj;
        return aIU.equals(((SimpleBigDecimal) (obj)).aIU) && aIV == ((SimpleBigDecimal) (obj)).aIV;
    }

    public int hashCode()
    {
        return aIU.hashCode() ^ aIV;
    }

    public String toString()
    {
        if (aIV == 0)
        {
            return aIU.toString();
        }
        BigInteger biginteger = aIU.shiftRight(aIV);
        Object obj1 = aIU.subtract(biginteger.shiftLeft(aIV));
        Object obj = obj1;
        if (aIU.signum() == -1)
        {
            obj = ECConstants.ONE.shiftLeft(aIV).subtract(((BigInteger) (obj1)));
        }
        obj1 = biginteger;
        if (biginteger.signum() == -1)
        {
            obj1 = biginteger;
            if (!((BigInteger) (obj)).equals(ECConstants.ZERO))
            {
                obj1 = biginteger.add(ECConstants.ONE);
            }
        }
        obj1 = ((BigInteger) (obj1)).toString();
        char ac[] = new char[aIV];
        obj = ((BigInteger) (obj)).toString(2);
        int k = ((String) (obj)).length();
        int l = aIV - k;
        for (int i = 0; i < l; i++)
        {
            ac[i] = '0';
        }

        for (int j = 0; j < k; j++)
        {
            ac[l + j] = ((String) (obj)).charAt(j);
        }

        obj = new String(ac);
        obj1 = new StringBuffer(((String) (obj1)));
        ((StringBuffer) (obj1)).append(".");
        ((StringBuffer) (obj1)).append(((String) (obj)));
        return ((StringBuffer) (obj1)).toString();
    }

    public final SimpleBigDecimal _mth02CA(SimpleBigDecimal simplebigdecimal)
    {
        if (aIV != simplebigdecimal.aIV)
        {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        } else
        {
            return new SimpleBigDecimal(aIU.add(simplebigdecimal.aIU), aIV);
        }
    }

    public final BigInteger _mth03EF()
    {
        SimpleBigDecimal simplebigdecimal = new SimpleBigDecimal(ECConstants.ONE, 1);
        int i = aIV;
        if (i < 0)
        {
            throw new IllegalArgumentException("scale may not be negative");
        }
        if (i != simplebigdecimal.aIV)
        {
            simplebigdecimal = new SimpleBigDecimal(simplebigdecimal.aIU.shiftLeft(i - simplebigdecimal.aIV), i);
        }
        simplebigdecimal = _mth02CA(simplebigdecimal);
        return simplebigdecimal.aIU.shiftRight(simplebigdecimal.aIV);
    }
}
