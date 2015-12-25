// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class ESSCertIDv2 extends ASN1Object
{

    private static final AlgorithmIdentifier YW;

    public final ASN1Primitive _mth0427()
    {
        new ASN1EncodableVector();
        AlgorithmIdentifier algorithmidentifier = YW;
        throw new NullPointerException();
    }

    static 
    {
        YW = new AlgorithmIdentifier(NISTObjectIdentifiers.ZD);
    }
}
