// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric:
//            DES

public static class aFw extends BaseSecretKeyFactory
{

    private int Yp;
    private boolean aFu;
    private int aFv;
    private int aFw;
    private int scheme;

    protected SecretKey engineGenerateSecret(KeySpec keyspec)
    {
        if (keyspec instanceof PBEKeySpec)
        {
            PBEKeySpec pbekeyspec = (PBEKeySpec)keyspec;
            if (pbekeyspec.getSalt() == null)
            {
                return new BCPBEKey(aFS, aFZ, scheme, aFv, Yp, aFw, pbekeyspec, null);
            }
            if (aFu)
            {
                keyspec = org.spongycastle.jcajce.provider.symmetric.util.e(pbekeyspec, scheme, aFv, Yp, aFw);
            } else
            {
                keyspec = org.spongycastle.jcajce.provider.symmetric.util.e(pbekeyspec, scheme, aFv, Yp);
            }
            KeyParameter keyparameter;
            if (keyspec instanceof ParametersWithIV)
            {
                keyparameter = (KeyParameter)((ParametersWithIV)keyspec).axC;
            } else
            {
                keyparameter = (KeyParameter)keyspec;
            }
            DESParameters._mth1D55(keyparameter.key);
            return new BCPBEKey(aFS, aFZ, scheme, aFv, Yp, aFw, pbekeyspec, keyspec);
        } else
        {
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }

    public tory(String s, ASN1ObjectIdentifier asn1objectidentifier, boolean flag, int i, int j, int k, int l)
    {
        super(s, asn1objectidentifier);
        aFu = true;
        scheme = i;
        aFv = j;
        Yp = k;
        aFw = 64;
    }
}
