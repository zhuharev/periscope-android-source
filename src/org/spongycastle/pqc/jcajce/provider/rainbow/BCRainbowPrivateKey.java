// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;

public class BCRainbowPrivateKey
    implements PrivateKey
{

    Layer aKk[];
    short aND[][];
    short aNE[];
    short aNG[][];
    short aNH[];
    int aNI[];

    public BCRainbowPrivateKey(RainbowPrivateKeyParameters rainbowprivatekeyparameters)
    {
        this(rainbowprivatekeyparameters.aND, rainbowprivatekeyparameters.aNE, rainbowprivatekeyparameters.aNG, rainbowprivatekeyparameters.aNH, rainbowprivatekeyparameters.aNI, rainbowprivatekeyparameters.aKk);
    }

    public BCRainbowPrivateKey(RainbowPrivateKeySpec rainbowprivatekeyspec)
    {
        this(rainbowprivatekeyspec.aND, rainbowprivatekeyspec.aNE, rainbowprivatekeyspec.aNG, rainbowprivatekeyspec.aNH, rainbowprivatekeyspec.aNI, rainbowprivatekeyspec.aKk);
    }

    public BCRainbowPrivateKey(short aword0[][], short aword1[], short aword2[][], short aword3[], int ai[], Layer alayer[])
    {
        aND = aword0;
        aNE = aword1;
        aNG = aword2;
        aNH = aword3;
        aNI = ai;
        aKk = alayer;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof BCRainbowPrivateKey))
        {
            return false;
        }
        obj = (BCRainbowPrivateKey)obj;
        boolean flag;
        if (RainbowUtil._mth02CB(aND, ((BCRainbowPrivateKey) (obj)).aND))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && RainbowUtil._mth02CB(aNG, ((BCRainbowPrivateKey) (obj)).aNG))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && RainbowUtil.equals(aNE, ((BCRainbowPrivateKey) (obj)).aNE))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && RainbowUtil.equals(aNH, ((BCRainbowPrivateKey) (obj)).aNH))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (flag && Arrays.equals(aNI, ((BCRainbowPrivateKey) (obj)).aNI))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (aKk.length != ((BCRainbowPrivateKey) (obj)).aKk.length)
        {
            return false;
        }
        for (int i = aKk.length - 1; i >= 0; i--)
        {
            flag1 &= aKk[i].equals(((BCRainbowPrivateKey) (obj)).aKk[i]);
        }

        return flag1;
    }

    public final String getAlgorithm()
    {
        return "Rainbow";
    }

    public byte[] getEncoded()
    {
        Object obj = new RainbowPrivateKey(aND, aNE, aNG, aNH, aNI, aKk);
        try
        {
            obj = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.aJU, DERNull.WL), ((org.spongycastle.asn1.ASN1Object) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = ((PrivateKeyInfo) (obj)).getEncoded();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public String getFormat()
    {
        return "PKCS#8";
    }

    public int hashCode()
    {
        int j = ((((aKk.length * 37 + org.spongycastle.util.Arrays._mth02CE(aND)) * 37 + org.spongycastle.util.Arrays.hashCode(aNE)) * 37 + org.spongycastle.util.Arrays._mth02CE(aNG)) * 37 + org.spongycastle.util.Arrays.hashCode(aNH)) * 37 + org.spongycastle.util.Arrays.hashCode(aNI);
        for (int i = aKk.length - 1; i >= 0; i--)
        {
            j = j * 37 + aKk[i].hashCode();
        }

        return j;
    }
}
