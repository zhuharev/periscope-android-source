// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

// Referenced classes of package org.spongycastle.jcajce.provider.symmetric.util:
//            BaseSecretKeyFactory, PBE, BCPBEKey

public class PBESecretKeyFactory extends BaseSecretKeyFactory
    implements PBE
{

    private int Yp;
    private boolean aFu;
    private int aFv;
    private int aFw;
    private int scheme;

    public PBESecretKeyFactory(String s, ASN1ObjectIdentifier asn1objectidentifier, boolean flag, int i, int j, int k, int l)
    {
        super(s, asn1objectidentifier);
        aFu = flag;
        scheme = i;
        aFv = j;
        Yp = k;
        aFw = l;
    }

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
                keyspec = PBE.Util._mth02CA(pbekeyspec, scheme, aFv, Yp, aFw);
            } else
            {
                keyspec = PBE.Util._mth02CA(pbekeyspec, scheme, aFv, Yp);
            }
            return new BCPBEKey(aFS, aFZ, scheme, aFv, Yp, aFw, pbekeyspec, keyspec);
        } else
        {
            throw new InvalidKeySpecException("Invalid KeySpec");
        }
    }
}
