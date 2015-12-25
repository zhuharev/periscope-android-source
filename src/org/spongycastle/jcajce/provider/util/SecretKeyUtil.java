// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.util.Integers;

public class SecretKeyUtil
{

    private static HashMap aGi;

    public SecretKeyUtil()
    {
    }

    static 
    {
        HashMap hashmap = new HashMap();
        aGi = hashmap;
        hashmap.put(PKCSObjectIdentifiers.abw.identifier, Integers.valueOf(192));
        aGi.put(NISTObjectIdentifiers.ZL, Integers.valueOf(128));
        aGi.put(NISTObjectIdentifiers.ZR, Integers.valueOf(192));
        aGi.put(NISTObjectIdentifiers.ZX, Integers.valueOf(256));
        aGi.put(NTTObjectIdentifiers.aah, Integers.valueOf(128));
        aGi.put(NTTObjectIdentifiers.aai, Integers.valueOf(192));
        aGi.put(NTTObjectIdentifiers.aaj, Integers.valueOf(256));
    }
}
