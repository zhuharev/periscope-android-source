// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.jce.interfaces.GOST3410Params;
import org.spongycastle.jce.interfaces.GOST3410PrivateKey;
import org.spongycastle.jce.interfaces.GOST3410PublicKey;
import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class GOST3410Util
{

    public GOST3410Util()
    {
    }

    public static GOST3410PrivateKeyParameters _mth141D(PrivateKey privatekey)
    {
        if (privatekey instanceof GOST3410PrivateKey)
        {
            privatekey = (GOST3410PrivateKey)privatekey;
            GOST3410PublicKeyParameterSetSpec gost3410publickeyparametersetspec = privatekey._mth15BD()._mth1D2D();
            return new GOST3410PrivateKeyParameters(privatekey.getX(), new GOST3410Parameters(gost3410publickeyparametersetspec.amM, gost3410publickeyparametersetspec.amN, gost3410publickeyparametersetspec.amW));
        } else
        {
            throw new InvalidKeyException("can't identify GOST3410 private key.");
        }
    }

    public static GOST3410PublicKeyParameters _mth141D(PublicKey publickey)
    {
        if (publickey instanceof GOST3410PublicKey)
        {
            publickey = (GOST3410PublicKey)publickey;
            GOST3410PublicKeyParameterSetSpec gost3410publickeyparametersetspec = publickey._mth15BD()._mth1D2D();
            return new GOST3410PublicKeyParameters(publickey.getY(), new GOST3410Parameters(gost3410publickeyparametersetspec.amM, gost3410publickeyparametersetspec.amN, gost3410publickeyparametersetspec.amW));
        } else
        {
            throw new InvalidKeyException((new StringBuilder("can't identify GOST3410 public key: ")).append(publickey.getClass().getName()).toString());
        }
    }
}
