// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends ASN1Object
{

    public AlgorithmIdentifier aaK;

    private EncryptionScheme(ASN1Sequence asn1sequence)
    {
        aaK = AlgorithmIdentifier._mth01C3(asn1sequence);
    }

    public static EncryptionScheme _mth1D36(Object obj)
    {
        if (obj instanceof EncryptionScheme)
        {
            return (EncryptionScheme)obj;
        }
        if (obj != null)
        {
            return new EncryptionScheme(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return aaK._mth0427();
    }
}
