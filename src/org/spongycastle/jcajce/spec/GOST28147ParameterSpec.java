// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.util.Arrays;

public class GOST28147ParameterSpec
    implements AlgorithmParameterSpec
{

    private static HashMap aGj;
    public byte ank[];
    public byte iv[];

    private GOST28147ParameterSpec(String s)
    {
        iv = null;
        ank = null;
        ank = GOST28147Engine._mth1541(s);
    }

    public GOST28147ParameterSpec(ASN1ObjectIdentifier asn1objectidentifier, byte abyte0[])
    {
        String s = (String)aGj.get(asn1objectidentifier);
        if (s == null)
        {
            throw new IllegalArgumentException((new StringBuilder("unknown OID: ")).append(asn1objectidentifier).toString());
        } else
        {
            this(s);
            iv = Arrays._mth1D4C(abyte0);
            return;
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        aGj = hashmap;
        hashmap.put(CryptoProObjectIdentifiers.XR, "E-A");
        aGj.put(CryptoProObjectIdentifiers.XS, "E-B");
        aGj.put(CryptoProObjectIdentifiers.XT, "E-C");
        aGj.put(CryptoProObjectIdentifiers.XU, "E-D");
    }
}
