// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.BigIntegers;

public abstract class DSTU4145PointEncoder
{

    public DSTU4145PointEncoder()
    {
    }

    private static ECFieldElement _mth02CA(ECCurve eccurve, ECFieldElement ecfieldelement)
    {
        if (ecfieldelement.isZero())
        {
            return ecfieldelement;
        }
        ECFieldElement ecfieldelement3 = eccurve._mth02BB(ECConstants.ZERO);
        Random random = new Random();
        int j = ecfieldelement.getFieldSize();
        ECFieldElement ecfieldelement1;
        do
        {
            ECFieldElement ecfieldelement4 = eccurve._mth02BB(new BigInteger(j, random));
            ecfieldelement1 = ecfieldelement3;
            ECFieldElement ecfieldelement2 = ecfieldelement;
            for (int i = 1; i <= j - 1; i++)
            {
                ecfieldelement2 = ecfieldelement2.FF4C();
                ecfieldelement1 = ecfieldelement1.FF4C()._mth02CE(ecfieldelement2._mth141D(ecfieldelement4));
                ecfieldelement2 = ecfieldelement2._mth02CE(ecfieldelement);
            }

            if (!ecfieldelement2.isZero())
            {
                return null;
            }
        } while (ecfieldelement1.FF4C()._mth02CE(ecfieldelement1).isZero());
        return ecfieldelement1;
    }

    private static ECFieldElement _mth02CA(ECFieldElement ecfieldelement)
    {
        ECFieldElement ecfieldelement1 = ecfieldelement;
        for (int i = 1; i < ecfieldelement.getFieldSize(); i++)
        {
            ecfieldelement1 = ecfieldelement1.FF4C()._mth02CE(ecfieldelement);
        }

        return ecfieldelement1;
    }

    public static ECPoint _mth02CA(ECCurve eccurve, byte abyte0[])
    {
        ECFieldElement ecfieldelement1 = eccurve._mth02BB(BigInteger.valueOf(abyte0[abyte0.length - 1] & 1));
        abyte0 = eccurve._mth02BB(new BigInteger(1, abyte0));
        Object obj = abyte0;
        if (!_mth02CA(((ECFieldElement) (abyte0))).equals(eccurve.FB46()))
        {
            obj = abyte0.FF26();
        }
        abyte0 = null;
        if (((ECFieldElement) (obj)).isZero())
        {
            abyte0 = eccurve.FB4C().FF52();
        } else
        {
            ECFieldElement ecfieldelement = _mth02CA(eccurve, ((ECFieldElement) (obj)).FF4C().FF4E()._mth141D(eccurve.FB4C())._mth02CE(eccurve.FB46())._mth02CE(((ECFieldElement) (obj))));
            if (ecfieldelement != null)
            {
                abyte0 = ecfieldelement;
                if (!_mth02CA(ecfieldelement).equals(ecfieldelement1))
                {
                    abyte0 = ecfieldelement.FF26();
                }
                abyte0 = ((ECFieldElement) (obj))._mth141D(abyte0);
            }
        }
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Invalid point compression");
        } else
        {
            return eccurve._mth02CA(((ECFieldElement) (obj)).toBigInteger(), abyte0.toBigInteger(), false);
        }
    }

    public static byte[] _mth02CA(ECPoint ecpoint)
    {
        ecpoint = ecpoint._mth0188();
        ECFieldElement ecfieldelement = ecpoint.FF8A();
        byte abyte0[] = BigIntegers._mth02BB((ecfieldelement.getFieldSize() + 7) / 8, ecfieldelement.toBigInteger());
        if (!ecfieldelement.isZero())
        {
            ecfieldelement = ecpoint.FF93()._mth02BB(ecfieldelement);
            int i = 1;
            ecpoint = ecfieldelement;
            for (; i < ecfieldelement.getFieldSize(); i++)
            {
                ecpoint = ecpoint.FF4C()._mth02CE(ecfieldelement);
            }

            if (ecpoint.FF53())
            {
                i = abyte0.length - 1;
                abyte0[i] = (byte)(abyte0[i] | 1);
                return abyte0;
            }
            i = abyte0.length - 1;
            abyte0[i] = (byte)(abyte0[i] & 0xfe);
        }
        return abyte0;
    }
}
