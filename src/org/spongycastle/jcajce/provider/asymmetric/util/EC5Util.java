// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.jce.spec.ECParameterSpec;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.field.FiniteField;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.util:
//            ECUtil

public class EC5Util
{

    private static HashMap aEp;

    public EC5Util()
    {
    }

    public static java.security.spec.ECParameterSpec _mth02CA(EllipticCurve ellipticcurve, ECParameterSpec ecparameterspec)
    {
        if (ecparameterspec instanceof ECNamedCurveParameterSpec)
        {
            return new ECNamedCurveSpec(((ECNamedCurveParameterSpec)ecparameterspec).name, ellipticcurve, new ECPoint(ecparameterspec.axi.FF8A().toBigInteger(), ecparameterspec.axi.FF93().toBigInteger()), ecparameterspec.alr, ecparameterspec.als);
        } else
        {
            return new java.security.spec.ECParameterSpec(ellipticcurve, new ECPoint(ecparameterspec.axi.FF8A().toBigInteger(), ecparameterspec.axi.FF93().toBigInteger()), ecparameterspec.alr, ecparameterspec.als.intValue());
        }
    }

    public static ECParameterSpec _mth02CA(java.security.spec.ECParameterSpec ecparameterspec, boolean flag)
    {
        ECCurve eccurve = _mth02CA(ecparameterspec.getCurve());
        ECPoint ecpoint = ecparameterspec.getGenerator();
        return new ECParameterSpec(eccurve, eccurve._mth02CA(ecpoint.getAffineX(), ecpoint.getAffineY(), flag), ecparameterspec.getOrder(), BigInteger.valueOf(ecparameterspec.getCofactor()), ecparameterspec.getCurve().getSeed());
    }

    public static ECCurve _mth02CA(EllipticCurve ellipticcurve)
    {
        Object obj = ellipticcurve.getField();
        BigInteger biginteger = ellipticcurve.getA();
        ellipticcurve = ellipticcurve.getB();
        if (obj instanceof ECFieldFp)
        {
            ellipticcurve = new org.spongycastle.math.ec.ECCurve.Fp(((ECFieldFp)obj).getP(), biginteger, ellipticcurve);
            if (aEp.containsKey(ellipticcurve))
            {
                return (ECCurve)aEp.get(ellipticcurve);
            } else
            {
                return ellipticcurve;
            }
        } else
        {
            obj = (ECFieldF2m)obj;
            int i = ((ECFieldF2m) (obj)).getM();
            int ai[] = ECUtil._mth02BB(((ECFieldF2m) (obj)).getMidTermsOfReductionPolynomial());
            return new org.spongycastle.math.ec.ECCurve.F2m(i, ai[0], ai[1], ai[2], biginteger, ellipticcurve);
        }
    }

    public static org.spongycastle.math.ec.ECPoint _mth02CA(java.security.spec.ECParameterSpec ecparameterspec, ECPoint ecpoint, boolean flag)
    {
        return _mth02CA(ecparameterspec.getCurve())._mth02CA(ecpoint.getAffineX(), ecpoint.getAffineY(), false);
    }

    public static org.spongycastle.math.ec.ECPoint _mth02CA(ECCurve eccurve, ECPoint ecpoint, boolean flag)
    {
        return eccurve._mth02CA(ecpoint.getAffineX(), ecpoint.getAffineY(), flag);
    }

    public static EllipticCurve _mth02CE(ECCurve eccurve)
    {
        if (ECAlgorithms._mth141D(eccurve))
        {
            return new EllipticCurve(new ECFieldFp(eccurve.FB25()._mth0506()), eccurve.FB46().toBigInteger(), eccurve.FB4C().toBigInteger(), null);
        }
        org.spongycastle.math.ec.ECCurve.F2m f2m = (org.spongycastle.math.ec.ECCurve.F2m)eccurve;
        boolean flag;
        if (f2m.avk == 0 && f2m.avl == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            int i = f2m.avj;
            return new EllipticCurve(new ECFieldF2m(f2m.afJ, new int[] {
                i
            }), eccurve.FB46().toBigInteger(), eccurve.FB4C().toBigInteger(), null);
        } else
        {
            int j = f2m.avl;
            int k = f2m.avk;
            int l = f2m.avj;
            return new EllipticCurve(new ECFieldF2m(f2m.afJ, new int[] {
                j, k, l
            }), eccurve.FB46().toBigInteger(), eccurve.FB4C().toBigInteger(), null);
        }
    }

    static 
    {
        aEp = new HashMap();
        Enumeration enumeration = CustomNamedCurves._mth1681();
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break;
            }
            String s = (String)enumeration.nextElement();
            X9ECParameters x9ecparameters = ECNamedCurveTable._mth14BB(s);
            if (x9ecparameters != null)
            {
                aEp.put(x9ecparameters.alm, CustomNamedCurves._mth14BB(s).alm);
            }
        } while (true);
    }
}
