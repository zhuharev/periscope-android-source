// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;

// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ECParameters

public class X962Parameters extends ASN1Object
    implements ASN1Choice
{

    public ASN1Primitive alk;

    public X962Parameters(ASN1ObjectIdentifier asn1objectidentifier)
    {
        alk = null;
        alk = asn1objectidentifier;
    }

    public X962Parameters(ASN1Primitive asn1primitive)
    {
        alk = null;
        alk = asn1primitive;
    }

    public X962Parameters(X9ECParameters x9ecparameters)
    {
        alk = null;
        alk = x9ecparameters._mth0427();
    }

    public static X962Parameters _mth06E5(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof X962Parameters))
        {
            return (X962Parameters)asn1encodable;
        }
        if (asn1encodable instanceof ASN1Primitive)
        {
            return new X962Parameters((ASN1Primitive)asn1encodable);
        } else
        {
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
    }

    public final ASN1Primitive _mth0427()
    {
        return alk;
    }
}
