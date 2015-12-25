// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec.endo;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPointMap;
import org.spongycastle.math.ec.ScaleXPointMap;

// Referenced classes of package org.spongycastle.math.ec.endo:
//            GLVEndomorphism, GLVTypeBParameters

public class GLVTypeBEndomorphism
    implements GLVEndomorphism
{

    private GLVTypeBParameters aJv;
    private ScaleXPointMap aJw;
    private ECCurve alm;

    public GLVTypeBEndomorphism(ECCurve eccurve, GLVTypeBParameters glvtypebparameters)
    {
        alm = eccurve;
        aJv = glvtypebparameters;
        aJw = new ScaleXPointMap(eccurve._mth02BB(glvtypebparameters._mth043F()));
    }

    private static BigInteger _mth02CA(BigInteger biginteger, BigInteger biginteger1, int i)
    {
        boolean flag;
        if (biginteger1.signum() < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        biginteger = biginteger.multiply(biginteger1.abs());
        boolean flag1 = biginteger.testBit(i - 1);
        biginteger1 = biginteger.shiftRight(i);
        biginteger = biginteger1;
        if (flag1)
        {
            biginteger = biginteger1.add(ECConstants.ONE);
        }
        if (flag)
        {
            return biginteger.negate();
        } else
        {
            return biginteger;
        }
    }

    public final BigInteger[] _mth02BF(BigInteger biginteger)
    {
        int i = aJv._mth04F4();
        BigInteger biginteger1 = _mth02CA(biginteger, aJv._mth04AC(), i);
        BigInteger biginteger2 = _mth02CA(biginteger, aJv._mth04DF(), i);
        BigInteger abiginteger[] = aJv._mth0475();
        BigInteger abiginteger1[] = aJv._mth0492();
        return (new BigInteger[] {
            biginteger.subtract(biginteger1.multiply(abiginteger[0]).add(biginteger2.multiply(abiginteger1[0]))), biginteger1.multiply(abiginteger[1]).add(biginteger2.multiply(abiginteger1[1])).negate()
        });
    }

    public final ECPointMap _mth043D()
    {
        return aJw;
    }
}
