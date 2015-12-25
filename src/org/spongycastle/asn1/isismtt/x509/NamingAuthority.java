// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;

public class NamingAuthority extends ASN1Object
{

    public static final ASN1ObjectIdentifier Zp;

    public final ASN1Primitive _mth0427()
    {
        return new DERSequence(new ASN1EncodableVector());
    }

    static 
    {
        Zp = new ASN1ObjectIdentifier((new StringBuilder()).append(ISISMTTObjectIdentifiers.Zo).append(".1").toString());
    }
}
