// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.PublicKey;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.provider.util.KeyUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.spongycastle.util.Arrays;

public class BCRainbowPublicKey
    implements PublicKey
{

    int aNM;
    short aNO[][];
    private short aNP[][];
    short aNQ[];

    public BCRainbowPublicKey(int i, short aword0[][], short aword1[][], short aword2[])
    {
        aNM = i;
        aNO = aword0;
        aNP = aword1;
        aNQ = aword2;
    }

    public BCRainbowPublicKey(RainbowPublicKeyParameters rainbowpublickeyparameters)
    {
        this(((RainbowKeyParameters) (rainbowpublickeyparameters)).aNM, rainbowpublickeyparameters.aNO, rainbowpublickeyparameters.aNP, rainbowpublickeyparameters.aNQ);
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec rainbowpublickeyspec)
    {
        this(rainbowpublickeyspec.aNM, rainbowpublickeyspec.aNO, rainbowpublickeyspec.aNP, rainbowpublickeyspec.aNQ);
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof BCRainbowPublicKey))
        {
            return false;
        }
        obj = (BCRainbowPublicKey)obj;
        return aNM == ((BCRainbowPublicKey) (obj)).aNM && RainbowUtil._mth02CB(aNO, ((BCRainbowPublicKey) (obj)).aNO) && RainbowUtil._mth02CB(aNP, ((BCRainbowPublicKey) (obj))._mth09DD()) && RainbowUtil.equals(aNQ, Arrays._mth02CB(((BCRainbowPublicKey) (obj)).aNQ));
    }

    public final String getAlgorithm()
    {
        return "Rainbow";
    }

    public byte[] getEncoded()
    {
        RainbowPublicKey rainbowpublickey = new RainbowPublicKey(aNM, aNO, aNP, aNQ);
        return KeyUtil._mth02CA(new AlgorithmIdentifier(PQCObjectIdentifiers.aJU, DERNull.WL), rainbowpublickey);
    }

    public String getFormat()
    {
        return "X.509";
    }

    public int hashCode()
    {
        return ((aNM * 37 + Arrays._mth02CE(aNO)) * 37 + Arrays._mth02CE(aNP)) * 37 + Arrays.hashCode(aNQ);
    }

    public final short[][] _mth09DD()
    {
        short aword0[][] = new short[aNP.length][];
        for (int i = 0; i != aNP.length; i++)
        {
            aword0[i] = Arrays._mth02CB(aNP[i]);
        }

        return aword0;
    }
}
