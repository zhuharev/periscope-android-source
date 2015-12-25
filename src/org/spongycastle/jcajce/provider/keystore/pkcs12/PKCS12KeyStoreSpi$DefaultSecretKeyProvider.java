// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.pkcs12;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.util.Integers;

// Referenced classes of package org.spongycastle.jcajce.provider.keystore.pkcs12:
//            PKCS12KeyStoreSpi

static class aFo
{

    final Map aFo;

    a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
        hashmap.put(PKCSObjectIdentifiers.abw.identifier, Integers.valueOf(192));
        hashmap.put(NISTObjectIdentifiers.ZL, Integers.valueOf(128));
        hashmap.put(NISTObjectIdentifiers.ZR, Integers.valueOf(192));
        hashmap.put(NISTObjectIdentifiers.ZX, Integers.valueOf(256));
        hashmap.put(NTTObjectIdentifiers.aah, Integers.valueOf(128));
        hashmap.put(NTTObjectIdentifiers.aai, Integers.valueOf(192));
        hashmap.put(NTTObjectIdentifiers.aaj, Integers.valueOf(256));
        hashmap.put(CryptoProObjectIdentifiers.XQ, Integers.valueOf(256));
        aFo = Collections.unmodifiableMap(hashmap);
    }
}
