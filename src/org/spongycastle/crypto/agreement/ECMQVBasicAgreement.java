// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;

public class ECMQVBasicAgreement
    implements BasicAgreement
{

    private MQVPrivateParameters amL;

    public ECMQVBasicAgreement()
    {
    }

    public final int getFieldSize()
    {
        return (((ECKeyParameters) (amL.axv)).aub.alm.getFieldSize() + 7) / 8;
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        amL = (MQVPrivateParameters)cipherparameters;
    }

    public final BigInteger _mth02CB(CipherParameters cipherparameters)
    {
        Object obj1 = (MQVPublicParameters)cipherparameters;
        Object obj2 = amL.axv;
        Object obj = ((ECKeyParameters) (obj2)).aub;
        Object obj3 = amL.axw;
        cipherparameters = amL.axx;
        Object obj4 = ((MQVPublicParameters) (obj1)).axy;
        ECPublicKeyParameters ecpublickeyparameters = ((MQVPublicParameters) (obj1)).axx;
        obj1 = ((ECDomainParameters) (obj)).alr;
        int i = (((BigInteger) (obj1)).bitLength() + 1) / 2;
        BigInteger biginteger = ECConstants.ONE.shiftLeft(i);
        ECCurve eccurve = ((ECDomainParameters) (obj)).alm;
        ECPoint aecpoint[] = new ECPoint[3];
        if (cipherparameters == null)
        {
            cipherparameters = ((ECDomainParameters) (obj)).axi;
            BigInteger biginteger1 = ((ECPrivateKeyParameters) (obj3)).awZ;
            cipherparameters = cipherparameters.FF79().FE9F()._mth02CA(cipherparameters, biginteger1);
        } else
        {
            cipherparameters = ((ECPublicKeyParameters) (cipherparameters)).axk;
        }
        aecpoint[0] = ECAlgorithms._mth02CA(eccurve, cipherparameters);
        aecpoint[1] = ECAlgorithms._mth02CA(eccurve, ((ECPublicKeyParameters) (obj4)).axk);
        aecpoint[2] = ECAlgorithms._mth02CA(eccurve, ecpublickeyparameters.axk);
        eccurve._mth02CA(aecpoint);
        obj4 = aecpoint[0];
        cipherparameters = aecpoint[1];
        ECPoint ecpoint = aecpoint[2];
        obj4 = ((ECPoint) (obj4)).FF8A().toBigInteger().mod(biginteger).setBit(i);
        obj2 = ((ECPrivateKeyParameters) (obj2)).awZ.multiply(((BigInteger) (obj4))).add(((ECPrivateKeyParameters) (obj3)).awZ).mod(((BigInteger) (obj1)));
        obj3 = ecpoint.FF8A().toBigInteger().mod(biginteger).setBit(i);
        obj = ((ECDomainParameters) (obj)).als.multiply(((BigInteger) (obj2))).mod(((BigInteger) (obj1)));
        cipherparameters = ECAlgorithms._mth02CA(cipherparameters, ((BigInteger) (obj3)).multiply(((BigInteger) (obj))).mod(((BigInteger) (obj1))), ecpoint, ((BigInteger) (obj)))._mth0188();
        if (cipherparameters._mth021D())
        {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        } else
        {
            return cipherparameters.FF8A().toBigInteger();
        }
    }
}
